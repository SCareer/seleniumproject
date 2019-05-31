package com.styleanalytics.enterprise.TemplateBuilder;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TemplateBuilderTest extends EnterpriseBaseClass {

	DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-YY");
	Date date = new Date();
	
	@Test(priority = 1)
	public void navigateToTemplateBuilder() throws InterruptedException, IOException {

		String URL = property("URL");
		Thread.sleep(2000);
		Driver.get(URL + "/Reporting/BlockTemplateList.aspx"); //Need to find the element in the left side menu to select template link.


	}
	@Test(priority = 3)
	public void createTemplate()throws InterruptedException{

		Thread.sleep(5000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdShowNew_input']")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='divNewOptions']/a[2]")).click();
		Thread.sleep(2000);
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY hh:mm");
		//get current date time with Date()
		Date date = new Date();
		Driver.findElement(By.xpath("//*[@id='templateName']")).sendKeys(dateFormat.format(date)+" Test Automation"); //Need to Uncomment this *************
		Thread.sleep(2000);
		//Driver.switchTo().defaultContent();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[contains(text(),'Style Skyline')]")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[contains(text(),'Style Skyline Range')]")).click();
		Thread.sleep(2000);
		//Driver.findElement(By.xpath("//*[@id='pageListIcons']/div[2]")).click();
		Thread.sleep(2000);
		//Driver.findElement(By.xpath("//*[@id='aspnetForm']/div[6]/div[1]/div/div/div[3]/div/div[4]/div[1]/div/div[4]/div[2]")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdSave_input']")).click();
		Thread.sleep(5000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdClose_input']")).click();
		Thread.sleep(5000);

	}

	@Test(priority = 2)
	public void deleteTemplate() throws InterruptedException {

		Utility ut = new Utility();
		ut.deleteTemplate("Test Auto");
	}

	@Test(priority = 3)
	public void verifyTemplateCreated() throws InterruptedException, IOException {

		String URL = property("URL");

		Driver.get(URL+"/analysis/viewReports.aspx");
		Thread.sleep(5000);
		Driver.findElement(By.xpath("//img[@id='rhsHamb']")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
		Thread.sleep(5000);
		Driver.switchTo().frame(0);
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtFilter']")).sendKeys(dateFormat1.format(date));
		Thread.sleep(5000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdFilter_input']")).click();
		Thread.sleep(5000);

		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_gridDownloadSettings_ctl00__0']/td[1]/a")).click();
		Thread.sleep(2000);

		try{

			Driver.findElement(By.cssSelector("#ctl00_mainContentPlaceHolder_dialogcancel_input")).click();

		}catch(Exception e){}
		//Driver.findElement(By.xpath("//*[@id='RadWindowWrapper_ctl00_mainContentPlaceHolder_report_radWindowStyleExposureSettings']/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li/a")).click();
		Thread.sleep(2000);
		Driver.switchTo().defaultContent();

	}

}
