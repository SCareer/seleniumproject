package com.styleanalytics.enterprise.Manage;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegionSetTest extends EnterpriseBaseClass {

	@BeforeClass
	public void setup() throws IOException {

		GoTo.goToReportsPage();

		Utility.isElementPresentAndClick("//img[@src='../images/rhsHamb.png']",10);

		Utility.isElementPresentAndClick("//a[@id='ctl00_mainContentPlaceHolder_report_aViewManageRegionSets']",3);

	}

	@Test(priority=3)
	public void DeleteRegionSet() throws InterruptedException{

		//Driver.switchTo().frame(0);
		Driver.findElement(By.partialLinkText("Test Automation")).click();
		Thread.sleep(5000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radToolbar']/div/div/div/ul/li[2]/a/span/span/span/span")).click();
		Thread.sleep(3000);
		Driver.switchTo().defaultContent();

	}
	
	@Test(priority=2)
	public void CreateRegion() throws InterruptedException{

	    Driver.switchTo().frame(0);
	    Driver.findElement(By.xpath("//*[@id='aspnetForm']/div[3]/ul/li/a")).click();
	    Thread.sleep(2000);
		DateFormat dateFormat = new SimpleDateFormat("d/MM/YY hh:mm:ss");
		//get current date time with Date()
		Date date = new Date();
	    Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtRegionSetName']")).sendKeys(dateFormat.format(date)+" Test Automation- Region set Test");
	    Thread.sleep(2000);
	    Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radToolbar']/div/div/div/ul/li/a/span/span/span/span")).click();
	    Thread.sleep(2000);
	    Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtRegionName']")).clear();
	    Thread.sleep(2000);
	    Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtRegionName']")).sendKeys("Test Auto Region");
	    Thread.sleep(2000);
	    Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_lstAvailableCountries']/table/tbody/tr/td/a[3]/span/span/span/span/span")).click();
	    Thread.sleep(2000);
	    Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_butSave_input']")).click();
	    Thread.sleep(2000);


	}
	
}
