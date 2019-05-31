package com.styleanalytics.setup;


import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.StartEnvironment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {

    WebDriver driver;

    private String dev;
    private String stage;
    private String live;
    private String test;
    StartEnvironment startEnvironment;

    DateFormat dateFormat = new SimpleDateFormat("d/MM/YY hh:mm:ss");

    Date date = new Date();

    public static String property(String prop) throws IOException {


        Properties cp = new Properties();
        String propValue = getEnvironmentVariableValue("ENVIRONMENT");


        InputStream input1;
        String propValue1 = null;
        if (propValue.equalsIgnoreCase("Dev")) {

            input1 = new FileInputStream("Dev_config.properties");
            cp.load(input1);
            propValue1 = cp.getProperty(prop);

        } else if (propValue.equalsIgnoreCase("Test")) {

            input1 = new FileInputStream("Test_config.properties");
            cp.load(input1);
            propValue1 = cp.getProperty(prop);

        } else if (propValue.equalsIgnoreCase("Stage")) {

            input1 = new FileInputStream("Stage_config.properties");
            cp.load(input1);
            propValue1 = cp.getProperty(prop);

        }else if (propValue.equalsIgnoreCase("Live")) {

            input1 = new FileInputStream("Live_config.properties");
            cp.load(input1);
            propValue1 = cp.getProperty(prop);
        }

        return propValue1;

    }

    public static String getEnvironmentVariableValue(String EnviName) {

        Map<String, String> env = System.getenv();

        String propValue = env.get(EnviName);

        return propValue;


    }


    //@BeforeSuite
    public void browserSetup() throws Exception {

        //Get the browser details from config file
        String browserName = property("browser");
        String chromeDriver = property("chromeDriver");
        String ieDriver = property("ieDriver");
        String downloadFilePath = property("PDFDownloadLocation");

        if (browserName.equalsIgnoreCase("Firefox")) {

            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Chrome")) {

            //To Turns off multiple download warning

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", downloadFilePath);
            prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
            prefs.put("download.prompt_for_download", false); //Turns off download prompt
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
            options.setCapability(ChromeOptions.CAPABILITY, options);


            options.addArguments("enable-automation");
            //options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);


            options.addArguments("--start-maximized");
            //options.addArguments("--start-fullscreen");

            System.setProperty("webdriver.chrome.driver", chromeDriver);
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("ie")) {

            System.setProperty("webdriver.ie.driver", ieDriver);
            driver = new InternetExplorerDriver();
        } else {

            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    //@BeforeClass
    public void environment() throws IOException, InterruptedException {

        String environmentName = getEnvironmentVariableValue("ENVIRONMENT");

        startEnvironment = new StartEnvironment(driver);

        if (environmentName.equalsIgnoreCase("Dev")) {

            dev = "https://devanalyzer.styleresearch.com";
            System.out.println("Environment:Dev");
            driver.get(dev);

            startEnvironment.starting(dev, environmentName);

        } else if (environmentName.equalsIgnoreCase("Stage")) {

            stage = "https://staginganalyzer.styleresearch.com";
            System.out.println("Environment:Stage");
            driver.get(stage);

            startEnvironment.starting(stage, environmentName);

        } else if (environmentName.equalsIgnoreCase("Live")) {

            live = "https://analyzer.styleresearch.com";
            System.out.println("Environment:Live");
            driver.get(live);

        } else if (environmentName.equalsIgnoreCase("Test")) {

            test = "https://testanalyzer.styleresearch.com";
            System.out.println("Environment:Test");
            driver.get(test);

            startEnvironment.starting(test, environmentName);
        }


    }

    public static boolean exists(String URLName) {

        try {
            //HttpURLConnection.setFollowRedirects(false);
            // note : you may also need
            // HttpURLConnection.setInstanceFollowRedirects(false)
            HttpURLConnection con = (HttpURLConnection) new URL(URLName)
                    .openConnection();
            con.setRequestMethod("HEAD");
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    //@BeforeClass(dependsOnMethods = "environment")
    public void loginTest() throws Exception {

        Thread.sleep(3000);

        //Get the user details from config file

        String user = property("username");
        String pass = property("password");
        try {
            driver.findElement(By.xpath("//*[@id='UserLogin_UserName']")).sendKeys(user);
        } catch (NoSuchElementException e) {

            driver.quit();
            browserSetup();
            environment();
            driver.findElement(By.xpath("//*[@id='UserLogin_UserName']")).sendKeys(user);
        }
        driver.findElement(By.xpath("//*[@id='UserLogin_Password']")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id='UserLogin_LoginButton']")).click();

        Thread.sleep(3000);

        System.out.println("Logged in to Enterprise");
        try {
            turnOffImplicitWaits(driver);
            WebElement splashScreen = driver.findElement(By.xpath("//*[@id=\"splashDiv\"]/div/div/input[2]"));

            if (splashScreen.isDisplayed()) {

                driver.findElement(By.xpath("//*[@id=\"splashDiv\"]/div/div/input[1]")).click();


            } else System.out.println("SplashScreen Not Found");
        } catch (Exception e) {

        }
        turnOnImplicitWaits(driver);
    }


    // @AfterClass
    public void LogoutTest() throws InterruptedException, IOException {

        String url = property("URL");//Get the URL info from config file.


        try {

            driver.get(url + "/authentication/srlogout.aspx");
            Thread.sleep(3000);
            System.out.println("Logout Successfully");

        } catch (UnhandledAlertException e) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (Exception e1) {
                System.out.println("Alert Popup closed");
                driver.get(url + "/authentication/srlogout.aspx");
            }

        }


    }

    @AfterClass
    public void Close() {

        driver.quit();

    }

    @BeforeClass
    public void browserSetupToLogin() throws Exception {

        browserSetup();

        environment();

    }

    public WebDriver getDriver(){

        return driver;
    }

    public void beforeClassSetup() throws IOException {

        GoTo.goToDashboard();
    }


    public void turnOffImplicitWaits(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void turnOnImplicitWaits(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void takeScreenShotOnFailure(String name) throws IOException {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\Selenium\\Screenshots\\" + name + ".jpg"));
    }


    public void Verify(String webElement, String verifyText) {

        Assert.assertEquals(verifyText, webElement);

    }

    public String getURL() throws IOException {

        String url = property("URL");
        return url;
    }

    public void moveToElement(String xpath){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(xpath));
        jse.executeScript("arguments[0].scrollIntoView(true);", element);


    }

    public void moveToElement(WebElement element){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);


    }

    public String getDateTime(String format){

        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }


    public void logInAsDiffUser(String Uname, String Pword) {

        driver.findElement(By.id("UserLogin_UserName")).sendKeys(Uname);
        driver.findElement(By.id("UserLogin_Password")).sendKeys(Pword);
        driver.findElement(By.id("UserLogin_LoginButton")).click();

        try {
            turnOffImplicitWaits(driver);
            WebElement splashScreen = driver.findElement(By.xpath("//*[@id=\"splashDiv\"]/div/div/input[2]"));

            if (splashScreen.isDisplayed()) {

                driver.findElement(By.xpath("//*[@id=\"splashDiv\"]/div/div/input[1]")).click();


            } else System.out.println("SplashScreen Not Found");
        } catch (Exception e) {

        }
        turnOnImplicitWaits(driver);


    }

}


