package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	private static WebDriver driver;
	 
	  @DataProvider(name = "Authentication")	 
	  public static Object[][] credentials() {	 
	        // The number of times data is repeated, test will be executed the same no. of times
	        // Here it will execute two times	 
	        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
	 	  }
	 
	  // Here we are calling the Data Provider object with its Name	 
	  @Test(groups = "E2E", dataProvider = "Authentication")
	  public void test(String sUsername, String sPassword) {
		  System.setProperty("webdriver.ie.driver", "C:\\selenium\\seleniumdriver\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		  driver = new InternetExplorerDriver();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  Reporter.log("now printing username & password ");
		  System.out.println(sUsername+"-------------"+sPassword);
//	      driver.get("http://www.store.demoqa.com");
//	      driver.findElement(By.xpath(".//*[@id='account']/a")).click();
//
//	      // Argument passed will be used here as String Variable
//
//	      driver.findElement(By.id("log")).sendKeys(sUsername);
//	      driver.findElement(By.id("pwd")).sendKeys(sPassword);
//	      driver.findElement(By.id("login")).click();
//	      driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	      driver.quit();
	 
	  }
	 

}
