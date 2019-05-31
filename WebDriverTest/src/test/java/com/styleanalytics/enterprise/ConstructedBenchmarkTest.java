package com.styleanalytics.enterprise;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.styleanalytics.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConstructedBenchmarkTest extends EnterpriseBaseClass {

	@BeforeClass
	public void setup() throws IOException {

		GoTo.goToExplore();
	}

	@Test(priority = 1)
	public void CreateConstructedBM() throws InterruptedException, IOException {


		Actions action = new Actions(Driver);
		Thread.sleep(3000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar']/div/div/div/ul/li[1]/a/span/span/span/span[1]")).click();
		Thread.sleep(5000);
		WebElement Down = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerToolbarContextMenu_detached']/ul/li[8]/a/span"));
		action.moveToElement(Down).build().perform();
		Thread.sleep(5000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerToolbarContextMenu_detached']/ul/li[8]/a/span")).click();
		Thread.sleep(3000);
		DateFormat dateFormat = new SimpleDateFormat("d/MM/YY hh:mm:ss");
		//get current date time with Date()
		Date date = new Date();

		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtName']")).sendKeys(dateFormat.format(date) + " - Constructed BM");
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_rptRules_ctl01_lbEditRule']")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_windowRule_C_ruleControl_dateStart_dateInput']")).clear();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_windowRule_C_ruleControl_dateStart_dateInput']")).sendKeys("Aug 2015");
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_windowRule_C_ruleControl_cbAllStocks']")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_windowRule_C_ruleControl_ddlUniverse_radComboBoxPortfolioQuickSearch_Input']")).sendKeys(" MSCI EUROPE");
		Thread.sleep(5000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_windowRule_C_ruleControl_ddlUniverse_radComboBoxPortfolioQuickSearch_DropDown']/div[2]/ul/li[1]")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_windowRule_C_cmdSaveRule_input']")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdSave_input']")).click();


	}


	@Test(priority = 2)
	public void VerifyConstructedBM() throws InterruptedException, IOException {

		DateFormat dateFormat = new SimpleDateFormat("d/MM/YY");
		Date date = new Date();
		SearchPage sp = new SearchPage(Driver);

		sp.setSearchIcon();
		sp.setSearchTextBlock(dateFormat.format(date) + " Constructed BM");
		sp.setFirstSearchResult();

		String constructedBMName = Driver.findElement(By.xpath("//h2[@class='portfolioSearchHeader']")).getText();
		System.out.println(constructedBMName);
		if (constructedBMName.contains(dateFormat.format(date))) {
			System.out.println("BM Constructed Successfully");
		} else {
			System.out.println("Failed to construct");
			Assert.fail();

		}
	}
}