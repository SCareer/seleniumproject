package com.styleanalytics.enterprise.Manage;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DefaultBenchmark extends EnterpriseBaseClass {
	
	@BeforeClass
	public void setup() throws InterruptedException, IOException {

		GoTo.goToExplore();
		String pName = property("PortfolioForDefaultBM");
		Utility.portfolioQuickSearchInExplorer(pName);


	}
	@Test(priority=1)
	public void addDefaultBenchmarkFromExplorer() throws InterruptedException{
		
		Actions action = new Actions(Driver);
		Thread.sleep(3000);
		WebElement e = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorer_ctl00_ctl02_ctl00_CheckboxSelectColumnSelectCheckBox']"));
		action.moveToElement(e);
		action.contextClick(e).sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(5000);
		
		 WebElement Down = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerContextMenu_detached']/ul/li[13]/a/span"));
		 action.moveToElement(Down).build().perform();
		 Thread.sleep(5000);
		 action.moveToElement(Down).build().perform();
		 
		 WebElement f = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerContextMenu_detached']/ul/li[13]/div/ul/li[9]/a/span"));
		 action.moveToElement(f).click().build().perform();
		 Thread.sleep(5000);
		
		 Driver.switchTo().frame(0);
		 try {
			 Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radGridPortfolioDefaultBenchmark_ctl00_ctl04_radComboBenchmark_radComboBoxPortfolioQuickSearch_Input']")).click();
			 Thread.sleep(5000);
			 Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radGridPortfolioDefaultBenchmark_ctl00_ctl04_radComboBenchmark_radComboBoxPortfolioQuickSearch_Input']")).sendKeys("MSCI EUROPE");
			 Thread.sleep(8000);
			 Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radGridPortfolioDefaultBenchmark_ctl00_ctl04_radComboBenchmark_radComboBoxPortfolioQuickSearch_DropDown']/div[2]/ul/li[1]")).click();
		 }catch (UnhandledAlertException e1){
		 		try{
		 			Driver.switchTo().alert().accept();
				}catch (NoAlertPresentException e2){
		 			System.out.println("No Alert");
				}
		 }
		 Utility.isElementPresentAndClick("//*[@id='ctl00_mainContentPlaceHolder_btnSave_input']",5);
		 Driver.switchTo().defaultContent();
		
		
	}
	@Test(priority = 2)
	public void verifyDefaultBM() throws InterruptedException {


		Actions action = new Actions(Driver);
		Thread.sleep(3000);
		WebElement e = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorer_ctl00_ctl02_ctl00_CheckboxSelectColumnSelectCheckBox']"));
		action.moveToElement(e);
		action.contextClick(e).sendKeys(Keys.ARROW_DOWN).build().perform();

		Utility.isElementPresentAndClick("//*[@id=\"ctl00_mainContentPlaceHolder_explorerContextMenu_detached\"]/ul/li[7]/a/span",3);

		Thread.sleep(4000);

		WebElement portfolioEle = Utility.isElementPresent("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioEditWindow_C_userPortfolioEditContent_txtPortfolioName\"]",3);
		String portfolioName = portfolioEle.getAttribute("value");
		Assert.assertEquals(portfolioName,"Analysis Task");

		WebElement BMEle = Utility.isElementPresent("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioEditWindow_C_userPortfolioEditContent_radComboBenchmark_radComboBoxPortfolioQuickSearch_Input\"]",3);
		String BMName = BMEle.getAttribute("value");
		Assert.assertEquals(BMName,"MSCI EUROPE");




	}

}
