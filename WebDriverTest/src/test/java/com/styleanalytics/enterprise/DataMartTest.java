package com.styleanalytics.enterprise;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.pages.DataMartPage;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataMartTest extends TestBase {

	WebDriver driver;
	DataMartPage dataMartPage;

	@BeforeClass
	public void setup() throws IOException {

		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login();
	    dataMartPage = new DataMartPage(getDriver());
		driver = getDriver();


	}
	@Test(priority = 1)
	public void goToDataMart() throws Exception {

		dataMartPage.dataMart(getURL());
		if(!getDriver().getTitle().equalsIgnoreCase("Data Mart")){
			throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
		}
	}
	
	@Test(priority = 2)
	public void addPortfolioFromDataMart() throws InterruptedException, IOException {

		Utility.isElementPresentAndClick("//span[@class='slick-column-name']//input[@type='checkbox']",6);

		Utility.isElementPresentAndClick("//span[@class='slick-column-name']//input[@type='checkbox']",5);

		driver.findElement(By.xpath("//*[@id='divPortfolios']/div[4]/div[1]/div[2]/div[3]/input")).sendKeys("Alliance");

		driver.findElement(By.xpath("//*[@id='divPortfolios']/div[4]/div[3]/div/div[1]/div[1]/input")).click();

		driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdRemove_input']")).click();

		driver.findElement(By.xpath("//*[@id='divPortfolios']/div[4]/div[3]/div/div[1]/div[1]/input")).click();

		driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdAdd_input']")).click();

		driver.findElement(By.cssSelector(".rwInnerSpan")).click();


	}

	//@Test(priority = 2)
	public void verifyPortfolioAddedFromDataMart() throws IOException, InterruptedException {

		//Verify portfolio is add to your account or not

		//GoTo.goToExplore();

		Utility.portfolioQuickSearchInExplorer("African Alliance SA S&P GIVI Eq Prsct");

		//explorerQuickSearch("African Alliance SA S&P GIVI Eq Prsct");

		Thread.sleep(10000);

		WebElement portfolioNameInExplorer = driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_ExploreDetail_portfolioName']"));

		Assert.assertEquals(portfolioNameInExplorer.getText(),"African Alliance SA S&P GIVI Eq Prsct");
	}
}
