package com.styleanalytics.enterprise.PortfolioLabs;

import com.styleanalytics.enterprise.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class PortfolioLabsTest extends EnterpriseBaseClass {

	Waits waits = new Waits();

	@BeforeClass
	public void portfolioLabsSetup() throws IOException, InterruptedException {

		String lPort = property("LabsPortfolio");
        Utility.searchPortfolioInReportsPage(lPort);


	}

	@Test (priority =1)
	public void CreateScenario() throws InterruptedException, IOException {

		Utility.isElementPresentAndClick("//*[@id='ctl00_mainContentPlaceHolder_report_Image1']",5);
		//Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_Image1']")).click();

	    //Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_aCreateScenario']/span[1]")).click();

	    Utility.isElementPresentAndClick("//*[@id='ctl00_mainContentPlaceHolder_report_aCreateScenario']/span[1]",5);

        Utility.isElementPresentAndClick("//*[@id='scenarioName']",5);

		WebElement scenarioName= Driver.findElement(By.xpath("//*[@id='scenarioName']"));

		String sName = scenarioName.getText();

		Assert.assertTrue(sName.contains("SCENARIO: LABS AUTOMATION"));

        try {

			Utility.isElementPresentAndDisplayed("//*[@id='btnChange']",120);

        }catch (TimeoutException e){

            System.out.println("Reports taking long time to display"+ e);


        }

        try {

            WebElement retry = Driver.findElement(By.xpath("//*[@id=\"analysisNotCompleteMessage\"]/a"));

            if (retry.isDisplayed()) {

                retry.click();
				Utility.isElementPresentAndDisplayed("//*[@id='btnChange']",120);
            }

            IsReportsDisplayed();

        }catch (Exception e){

            System.out.println("Reports Not displayed after retry"+ e);
        }






	}

	@Test(priority =2)
	public void SellStock() throws InterruptedException {


		Utility.isElementPresentAndClick("//*[@id=\"ctl00_mainContentPlaceHolder_cmdToggleReports_input\"]",60);

		Utility.isElementPresentAndClick("//*[@id='divGridScenarioEditor']/div[4]/div[3]/div/div[2]/div[1]/img",20);

		Utility.moveToElement("//*[@id='divGridScenarioEditor']/div[4]/div[3]/div/div[5]/div[1]/img");

		Driver.findElement(By.xpath("//*[@id='divGridScenarioEditor']/div[4]/div[3]/div/div[5]/div[1]/img")).click();


		Utility.isElementPresentAndDisplayed("//*[@id='btnChange']",120);
		//waits.explicitWait("//*[@id='btnChange']");

		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdApplyChanges_input']")).click();



    }
    @Test(priority = 3)
    public void VerifyChangeReports() throws InterruptedException {



		waits.explicitWait("//*[@id='btnChange']");
		Driver.findElement(By.xpath("//*[@id='btnChange']")).click();

		IsReportsDisplayed();
	}
	@Test(priority =4 )
	public void BeforeAfterReports() throws InterruptedException {

		waits.explicitWait("//*[@id='btnBeforeAfter']");
		Driver.findElement(By.xpath("//*[@id='btnBeforeAfter']")).click();
		IsReportsDisplayed();
	}
	@Test(priority =5 )
	public void BeforeReports() throws InterruptedException {


		waits.explicitWait("//*[@id='btnBefore']");
		Driver.findElement(By.xpath("//*[@id='btnBefore']")).click();
		IsReportsDisplayed();
	}
	@Test(priority =6 )
	public void AfterReports() throws InterruptedException {


		waits.explicitWait("//*[@id='btnAfter']");
		Driver.findElement(By.xpath("//*[@id='btnAfter']")).click();
		IsReportsDisplayed();
	}

	public void IsReportsDisplayed() throws InterruptedException {

		Wait.waitForSpinnerToDisappear(Driver,60);

        Driver.findElement(By.xpath("//*[@id='pagePane0_divContent0-img']")).isDisplayed();
        Driver.findElement(By.xpath("//*[@id='pagePane0_divContent1-img']")).isDisplayed();
        Driver.findElement(By.xpath("//*[@id='pagePane0_divContent2']")).isDisplayed();
		Thread.sleep(2000);

		Driver.findElement(By.xpath("//*[@id='carouselNavigatorControls']/div[1]")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='pagePane1_divContent0-img']")).isDisplayed();
		Driver.findElement(By.xpath("//*[@id='pagePane1_divContent1-img']")).isDisplayed();
		Driver.findElement(By.xpath("//*[@id='carouselNavigatorControls']/div[1]")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='pagePane2_divContent0-img']")).isDisplayed();
		Driver.findElement(By.xpath("//*[@id='pagePane2_divContent1-img']")).isDisplayed();
		Thread.sleep(2000);



    }


	@Test  (priority =7)
    public void BuySecurity() throws InterruptedException{


	    Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdBuySecurity_input']")).click();
	    Thread.sleep(3000);
	    Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_Input']")).sendKeys("apple inc.");
	    Utility.waitForElementToDisplayByXpath("//span[@title='APPLE INC.']",30);
	    Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_DropDown']/div[2]/ul/li[2]")).click();
	    Thread.sleep(2000);
	    Driver.findElement(By.xpath("//*[@id='txtBuyWeight']")).sendKeys("10");
	    Thread.sleep(2000);
	    Driver.findElement(By.xpath("//*[@id='btnBuy']")).click();
	    Thread.sleep(5000);
	    Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdApplyChanges_input']")).click();

		waits.explicitWait("//*[@id='btnChange']");

		IsReportsDisplayed();



	}
	@Test  (priority =8)
    public void BuyFunds() throws InterruptedException{


		 Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdBuySecurity_input']")).click();
		 Utility.isElementPresentAndClick("//*[@id='radBuySecurityAssetType_4']",3);

         Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_Input']")).clear();
		 Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_Input']")).sendKeys("Sanity");
		 Utility.isElementPresentAndClick("//*[@id='ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_DropDown']/div[2]/ul/li[1]",15);
		 Driver.findElement(By.xpath("//*[@id='txtBuyWeight']")).sendKeys("10");
		 Utility.isElementPresentAndClick("//*[@id='btnBuy']",5);
		 Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdApplyChanges_input']")).click();
		 waits.explicitWait("//*[@id='btnChange']");
		 IsReportsDisplayed();


	}
	@Test  (priority =9)
    public void IncreaseCash() throws InterruptedException{


	 Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_RadButton2_input']")).click();
	 Driver.findElement(By.xpath("//*[@id='txtAddCashNAV']")).sendKeys("50000");
	 Driver.findElement(By.xpath("//*[@id='btnAddCash']")).click();

	
    }
	@Test  (priority =10)
    public void IncreaseNav() throws InterruptedException{
	

	 Thread.sleep(5000);
	 Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_RadButton1_input']")).click();
	 Driver.findElement(By.xpath("//*[@id='txtUpdateNAV']")).clear();
	 Driver.findElement(By.xpath("//*[@id='txtUpdateNAV']")).sendKeys("100000010");
	 Driver.findElement(By.xpath("//*[@id='btnUpdateNav']")).click();
	 Thread.sleep(3000);
	 WebElement navValue = Driver.findElement(By.xpath("//*[@id=\"spanNav\"]"));

	 Assert.assertEquals(navValue.getText(),"100,000,010");

    }

   // @Test (priority =11)
    public void labsReportCleanUp() throws InterruptedException, IOException {

		GoTo.portfolioLabs();

		List<WebElement> scenarioName;

         scenarioName = Driver.findElements(By.xpath("//div[@class='slick-cell l0 r0']"));

        for(int i=0; i<scenarioName.size();i++){
        	//scenarioName = Driver.findElements(By.xpath("//div[@class='slick-cell l0 r0']"));
			if(!scenarioName.get(i).getText().equalsIgnoreCase("Labs PDF Comparison Test ")) {
				Driver.findElement(By.xpath(" //div[@class='ui-state-default slick-headerrow-column l0 r0']//input[@type='text']")).sendKeys(scenarioName.get(i).getText());
				Thread.sleep(3000);
				/*Utility.isElementPresentAndClick("//a[@class='sgButtonRed']", 5);
				Thread.sleep(3000);
				Driver.switchTo().alert().accept();*/
			}

        }



    }

	public void BuySecurityReusable(String securityName) throws InterruptedException{


		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdBuySecurity_input']")).click();
		Thread.sleep(3000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_Input']")).sendKeys(securityName);
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_DropDown']/div[2]/ul/li[2]")).click();
		Thread.sleep(2000);


	}





}
