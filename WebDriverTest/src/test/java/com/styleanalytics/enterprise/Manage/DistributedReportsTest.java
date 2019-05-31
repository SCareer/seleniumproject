package com.styleanalytics.enterprise.Manage;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.pages.PortfolioReportsPage;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DistributedReportsTest extends TestBase {
	WebDriver driver;

	@BeforeClass
	public void setup() throws IOException, InterruptedException {

		driver = getDriver();

		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login();

		PortfolioReportsPage portfolioReportsPage = new PortfolioReportsPage(getDriver());
		portfolioReportsPage.goToReportsPage(getURL());

		driver.findElement(By.xpath("//img[@id='rhsHamb']")).click();

		Wait.waitForElementToDisplayByXpath(getDriver(),"//*[@id='ctl00_mainContentPlaceHolder_report_aDistribute']/span[1]",3);
		driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_aDistribute']/span[1]")).click();

		//Utility.isElementPresentAndClick("//img[@id='rhsHamb']",10);
		//Utility.isElementPresentAndClick("//*[@id='ctl00_mainContentPlaceHolder_report_aDistribute']/span[1]",3);
	}

	@Test
	public void distributedReports() throws InterruptedException, IOException {

		Thread.sleep(5000);

		String uName = property("DistributeToUser");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_distEdit_radTextBoxAddRecipient']")).sendKeys(uName);

		driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_distEdit_radButtonAddReportDistributionRecipient_input']")).click();

		driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_distEdit_txtMessage']")).sendKeys("Hello");

		driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_distEdit_btnDistribute_input']")).click();



		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		Utility.isElementPresentAndClickCSS(".rwInnerSpan",10);
		//driver.findElement(By.cssSelector(".rwInnerSpan")).click();
		driver.switchTo().defaultContent();

	}

}
