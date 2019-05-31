package com.styleanalytics.enterprise.Loader;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.enterprise.Waits;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoadTest extends TestBase {

	DateFormat dateFormat = new SimpleDateFormat("d/MM/YY hh:mm:ss");
	//get current date time with Date()
	Date date = new Date();

	WebDriver driver;

	public LoadTest(){

		driver = getDriver();
	}

	@Test
	public void regressionMonthlyPortfolio() throws IOException, InterruptedException {

		LoadPage loadPage = new LoadPage(getDriver());

		try {

			loadPage.loadPortfolioWithSpecifyNameOnRuntime("C:\\Selenium\\Regression Portfolio.xlsx", " " + dateFormat.format(date) + " - Sanity automation");

		}catch (Exception e){

			takeScreenShotOnFailure("Loader");
			Assert.fail("Portfolio Load Failed");
		}
	}


	//@Test(priority = 1)
	public void deleteLoadedPortfolio() throws IOException, InterruptedException {

		GoTo goTo =new GoTo();
		goTo.goToExplorerPage();

		Utility ut = new Utility();
		String yDate = ut.yesterdaysDate("dd/MM/YY");
		try {
			selectAllAndDelete(yDate, "Automation");
		}catch (NoSuchElementException e){
			System.out.println("Nothing to Delete:LoadedPortfolio "+e);
		}

	}

	//@Test(priority = 2)
	public void deleteBMConstructionPortfolio() throws IOException, InterruptedException {

		GoTo goTo =new GoTo();
		goTo.goToExplorerPage();

		Utility ut = new Utility();
		String yDate = ut.yesterdaysDate("dd/MM/YY");

		try {
			selectAllAndDelete(yDate, "Constructed");
		}catch (NoSuchElementException e){
			System.out.println("Nothing to Delete:BMConstructionPortfolio "+e);
		}

	}

	public void selectAllAndDelete(String sDate,String sName) throws InterruptedException {

		Utility ut = new Utility();

		ut.searchAndSelectPortfoliosWithSimilarNameInExplorer(sDate+ " "+sName);

		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_explorer_ctl00_ctl02_ctl00_CheckboxSelectColumnSelectCheckBox\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_explorerToolbar\"]/div/div/div/ul/li[1]/a/span/span/span/span[2]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_explorerToolbarContextMenu_detached\"]/ul/li[9]/a/span")).click();
		Thread.sleep(5000);

		ut.clickOnConfirmPopup();
	}



     //This is work in progress
	public void loadMultiplePortfolio(String filePath, File[] files) throws InterruptedException, IOException {


		GoTo goTo = new GoTo();
		goTo.goToLoadPage();

		try {

			for(File file:files) {

				Thread.sleep(2000);

				driver.findElement(By.id("ctl00_mainContentPlaceHolder_fileUploadfile0")).sendKeys(filePath+file.getName());
			}
			String xpathForNext = "//*[@id='ctl00_mainContentPlaceHolder_loadheader_cmdNext_input']";
			Waits waits = new Waits();
			waits.explicitWaitAndClick(xpathForNext);  //First Next Click

			//Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_gridFiles_ctl00_ctl04_labMultipleDates']")).click();

			String xpathForNext1 = "//*[@id='ctl00_mainContentPlaceHolder_header_cmdNext_input']";
			waits.explicitWaitAndClick(xpathForNext1); //Second Next Click

			//Thread.sleep(60000);

			//*[@id="ctl00_mainContentPlaceHolder_portfolioStockMatch_labSnapshotCount"]

			//Utility.waitForElementToDisplay("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_labSnapshotCount\"]");

			waits.explicitWaitAndClick(xpathForNext1); //third Next Click

			waits.explicitWaitAndClick(xpathForNext1); //fourth Next Click

			waits.explicitWaitAndClick(xpathForNext1); //Fifth Next Click

			Thread.sleep(3000);

			driver.findElement(By.cssSelector(".rwInnerSpan")).click();

		}catch (UnhandledAlertException e){

			System.out.println(e);
			Assert.fail();
		}

	}



}




