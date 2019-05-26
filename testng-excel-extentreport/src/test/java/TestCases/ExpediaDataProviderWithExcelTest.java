package TestCases;

import dataprovider.TestDataProvider;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageObject.HomePage;

import java.util.concurrent.TimeUnit;

public class ExpediaDataProviderWithExcelTest {

    public static final Logger log= Logger.getLogger(ExpediaDataProviderWithExcelTest.class.getName());

    String baseURL = "https://www.expedia.co.uk/";
    WebDriver driver;
    HomePage homePage = new HomePage(driver);

    @BeforeTest
    public void beforeMethod() throws Exception {
        System.setProperty("webdriver.ie.driver", "C:\\selenium\\seleniumdriver\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test(groups = "SmokeTest", priority=1, enabled=true, dataProvider = "ExpediaTestData", dataProviderClass = TestDataProvider.class)
    public void Test1(String Origin, String Destination, String Departing, String Returning) throws Exception {
        WebElement hdrHome = driver.findElement(By.id("tab-flight-tab-hp"));
        hdrHome.click();

        WebElement inputOrigin = driver.findElement(By.id("flight-origin-hp-flight"));
        inputOrigin.click();
        inputOrigin.clear();
        inputOrigin.sendKeys(Origin);

        WebElement inputDestination = driver.findElement(By.id("flight-destination-hp-flight"));
        inputDestination.click();
        inputDestination.clear();
        inputDestination.sendKeys(Destination);

        WebElement inputDeparting = driver.findElement(By.id("flight-departing-hp-flight"));
        inputDeparting.click();
        inputDeparting.clear();
        inputDeparting.sendKeys(Departing);

        WebElement inputReturning = driver.findElement(By.id("flight-returning-hp-flight"));
        inputReturning.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        inputReturning.sendKeys(Returning);

        inputReturning.sendKeys(Keys.TAB);

        WebElement btnSubmit = driver.findElement(By.xpath("//*[@id='gcw-flights-form-hp-flight']//button[@type='submit']"));
        btnSubmit.click();

        Thread.sleep(4000);
        WebElement btnHome = driver.findElement(By.id("primary-header-home"));
        btnHome.click();

        WebElement hdrHome1 = driver.findElement(By.id("tab-flight-tab-hp"));
        hdrHome1.click();

    }

    @Test(groups = "SIT", priority=1, enabled=true, dataProvider = "ExpediaTestData1", dataProviderClass = TestDataProvider.class)
    public void Test2(String Origin, String Destination, String Departing, String Returning) throws Exception {
        WebElement hdrHome = driver.findElement(By.id("tab-flight-tab-hp"));
        hdrHome.click();

        WebElement inputOrigin = driver.findElement(By.id("flight-origin-hp-flight"));
        inputOrigin.click();
        inputOrigin.clear();
        inputOrigin.sendKeys(Origin);

        WebElement inputDestination = driver.findElement(By.id("flight-destination-hp-flight"));
        inputDestination.click();
        inputDestination.clear();
        inputDestination.sendKeys(Destination);

        WebElement inputDeparting = driver.findElement(By.id("flight-departing-hp-flight"));
        inputDeparting.click();
        inputDeparting.clear();
        inputDeparting.sendKeys(Departing);

        WebElement inputReturning = driver.findElement(By.id("flight-returning-hp-flight"));
        inputReturning.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        inputReturning.sendKeys(Returning);

        inputReturning.sendKeys(Keys.TAB);

        WebElement btnSubmit = driver.findElement(By.xpath("//*[@id='gcw-flights-form-hp-flight']//button[@type='submit']"));
        btnSubmit.click();

        Thread.sleep(4000);
        WebElement btnHome = driver.findElement(By.id("primary-header-home"));
        btnHome.click();

        WebElement hdrHome1 = driver.findElement(By.id("tab-flight-tab-hp"));
        hdrHome1.click();
    }

    @AfterTest
    public void EndTest() {
        driver.close();
    }
}
