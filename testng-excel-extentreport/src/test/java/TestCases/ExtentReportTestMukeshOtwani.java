package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.AssertJUnit.assertEquals;

public class ExtentReportTestMukeshOtwani {
    public WebDriver driver;

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeTest
    public void setExtent() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/myReport_" + getcurrentdateandtime() + ".html");
        htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
        htmlReporter.config().setReportName("Functional Testing"); // Name of the report
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        htmlReporter.config().setAutoCreateRelativePathMedia(true);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // Passing General information
        extent.setSystemInfo("Host name", "LocalHost");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Browser", "IE");
    }

    @AfterTest
    public void endReport() {

        driver.quit();
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.ie.driver", "C:\\Softwares\\seleniumdriver\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.nopcommerce.com/");
    }

    //Test1
    @Test
    public void test01() {
        test = extent.createTest("Test01-0001");
        SoftAssert softAssertion= new SoftAssert();
        String title = driver.getTitle();
//        System.out.println(title);
//        Assert.assertEquals(title, "eCommerce demo store");
        test.log(Status.INFO, "Captured screen title - " + title);
        System.out.println("test1 executed");
//        Assert.assertEquals("testExpected", "testExpected");
//        test.createNode("testExpected..passed");
//        Assert.assertEquals("testExpectedFail", "testExpectedFail1");
//        test.createNode("testExpected..failed");
//        Assert.assertEquals("testExpectedPass1", "testExpectedPass1");
//        test.createNode("testExpected..passed");
        softAssertion.assertEquals("testExpected", "testExpected", "Screen title 1 : ");
        test.log(Status.INFO, "Captured screen title - " + title);
//        softAssertion.assertAll();
        softAssertion.assertEquals("Actual_01", "Expected_01","Screen title 2 : " );
        test.log(Status.INFO, "Captured screen title - " + title);
        softAssertion.assertEquals("Actual_02", "Expected_02","Screen title 3 : ");
        test.log(Status.FAIL, "Captured screen title - " + title);
        softAssertion.assertEquals("Actual_03", "Expected_03", "Screen title 4 : ");
        test.log(Status.INFO, "Captured screen title - " + title);
        softAssertion.assertEquals("Actual_04", "Expected_04", "Screen title 5 : ");
        test.log(Status.FAIL, "Captured screen title - " + title);
        softAssertion.assertEquals("Actual_05", "Expected_05", "Screen title 6 : ");
        test.log(Status.INFO, "Captured screen title - " + title);
        softAssertion.assertAll();
    }

    //Test2
    @Test
    public void test02() {
        test = extent.createTest("Test01-0002");
//        boolean b = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isTest01-0001Displayed();
//        Assert.assertTrue(b);
        System.out.println("Test2 executed");
        Assert.assertEquals("testresultmatched", "testresultmatcheds");
        driver.close();
    }

    //Test3
    @Test
    public void test03() {
        test = extent.createTest("Test01-0003");

        test.createNode("Login with Valid input");
        Assert.assertTrue(true);
        test.createNode("Login with In-valid input");
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
//            String screenshotPath = ExtentReportTestMukeshOtwani.getScreenshot(driver, result.getName());
            String screenshotPath = utility.getScreenshot(driver);
            test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
            test.skip(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
        }
        driver.close();
        extent.flush();
    }



    private static String getcurrentdateandtime() {
        String str = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
            Date date = new Date();
            str = dateFormat.format(date);
            str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
        } catch (Exception e) {
        }
        return str;
    }


}
