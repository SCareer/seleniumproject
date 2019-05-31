package com.styleanalytics.enterprise;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StockMatching extends EnterpriseBaseClass {

	@BeforeClass
	public void uptoLoadStep3() throws InterruptedException, IOException {

		GoTo goTo = new GoTo();
		goTo.goToLoadPage();

		try {

			Driver.findElement(By.id("ctl00_mainContentPlaceHolder_fileUploadfile0")).sendKeys("C:\\Selenium\\Regression Portfolio.xlsx");

			String xpathForNext = "//*[@id='ctl00_mainContentPlaceHolder_loadheader_cmdNext_input']";
			Waits waits = new Waits();
			waits.explicitWaitAndClick(xpathForNext);

			DateFormat dateFormat = new SimpleDateFormat("d/MM/YY hh:mm:ss");
			//get current date time with Date()
			Date date = new Date();

			Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_gridFiles_ctl00_ctl04_radComboPortfolioName_radComboBoxPortfolioQuickSearch_Input']")).sendKeys(" " + dateFormat.format(date) + " - Sanity automation");
			Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_gridFiles_ctl00_ctl04_labMultipleDates']")).click();

			String xpathForNext1 = "//*[@id='ctl00_mainContentPlaceHolder_header_cmdNext_input']";
			waits.explicitWaitAndClick(xpathForNext1);

			Thread.sleep(60000);

		} catch (UnhandledAlertException e) {

			System.out.println("Loading File Failed: "+e);

			try {
				Driver.switchTo().alert().accept();
			}catch (NoAlertPresentException e1){
				System.out.println("No Alert Found: "+e1);
			}

			Assert.fail();
		}

	}
	
	
	@Test(priority=1)
	public void matchEquity() throws InterruptedException{
		

	WebElement stockNameBefore = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00__0']/td[4]"));
	System.out.println(stockNameBefore.getText());
	Thread.sleep(5000);
	Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00_ctl04_labMatchedSecurityName']")).click();
	Thread.sleep(5000);
	Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input']")).click();
	Thread.sleep(5000);
	Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_DropDown']/div[2]/ul/li")).click();
	Thread.sleep(5000);
	Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radButtonApply_input']")).click();
	Thread.sleep(5000);
	WebElement stockNameAfter = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00__0']/td[4]"));
	System.out.println(stockNameAfter.getText());
	Assert.assertNotEquals(stockNameAfter, stockNameBefore);
	
	
	}
	
	@Test(priority=2)
	public void matchPortfolio() throws InterruptedException{
		
	Thread.sleep(5000);	
	WebElement stockNameBefore = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00__0']/td[4]"));
	System.out.println(stockNameBefore.getText());
	Thread.sleep(5000);	
	Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00_ctl04_labMatchedSecurityName']")).click();
	Thread.sleep(5000);	
	Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_ddlAssetType_Arrow']")).click();
	Thread.sleep(5000);
	Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_ddlAssetType_DropDown']/div/ul/li[2]")).click();
	Thread.sleep(5000);
	Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input']")).clear();
	Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input']")).sendKeys("Sanity");
	Thread.sleep(5000);
	Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_DropDown']/div[2]/ul/li")).click();
	Thread.sleep(5000);
	Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radButtonApply_input']")).click();
	Thread.sleep(30000);
	WebElement stockNameAfter = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00__0']/td[4]"));
	System.out.println(stockNameAfter.getText());
	Assert.assertNotEquals(stockNameAfter, stockNameBefore);
	//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_DropDown']/div[2]/ul/li
	
	
     }
	
	@Test(priority=3)
	public void suggestMatches() throws InterruptedException{
		
		Thread.sleep(5000);
		WebElement stockNameBefore = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00__0']/td[4]"));
		System.out.println(stockNameBefore.getText());
		Thread.sleep(5000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radButtonMatchSuggest_input']")).click();
		Thread.sleep(25000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00_ctl02_ctl01_radButtonAcceptMatches_input']")).click();
		Thread.sleep(5000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radButtonApply_input']")).click();
		Thread.sleep(30000);
		WebElement stockNameAfter = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00__0']/td[4]"));
		System.out.println(stockNameAfter.getText());
		Assert.assertNotEquals(stockNameAfter, stockNameBefore);
		Thread.sleep(15000);
		
		
	}
	//@Test(priority=5)
	public void securityDetailsPopup() throws InterruptedException{
		
		Thread.sleep(15000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radMenuStockMatching']/ul/li/a/span")).click();
		Thread.sleep(5000);
		Actions action = new Actions(Driver);
		WebElement p=Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radMenuStockMatching']/ul/li/div/ul/li[2]/a/span"));
		//for (int i=0; i<5;i++){
		do{
		action.moveToElement(p).build().perform();
		}while(Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radMenuStockMatching']/ul/li/div/ul/li[2]/div/ul/li[2]/a")).isEnabled());
		
		WebElement q = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radMenuStockMatching']/ul/li/div/ul/li[2]/div/ul/li[2]/a"));
		action.moveToElement(q).click().build().perform();
		
		Thread.sleep(5000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00__10']/td[4]")).click();
		Thread.sleep(5000);
		Driver.switchTo().frame(0);
		WebElement content1=Driver.findElement(By.xpath("//*[@id='aspnetForm']/div[4]/div[1]/div[1]"));
		Assert.assertEquals("SECURITY DETAILS", content1.getText());
		Thread.sleep(5000);
		
		WebElement content2=Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_labFactorValuesTitle']"));
		Assert.assertEquals("FACTOR VALUES", content2.getText());
		Thread.sleep(5000);
		Driver.switchTo().defaultContent();
		Driver.findElement(By.cssSelector(".rwCloseButton")).click();
		
		
		
		
	}
}