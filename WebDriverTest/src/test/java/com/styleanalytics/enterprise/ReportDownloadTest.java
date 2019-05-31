package com.styleanalytics.enterprise;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class ReportDownloadTest extends EnterpriseBaseClass {

	@BeforeClass
	public void downloadReportPreRequist() throws InterruptedException, IOException {

		GoTo.goToExplore();

		String pName = property("PortfolioToDownloadFromExplorer");

		Utility.portfolioQuickSearchInExplorer(pName);

	}

	@Test(priority=2)
	public void downloadExcel() throws InterruptedException{


		selectDownloadsMenu();
		WebElement excel = Driver.findElement(By.linkText("Excel"));
		dropDownMenuBuilder(excel);

		WebElement template = Driver.findElement(By.linkText("Default Excel Report"));
		dropDownMenuBuilder(template);
		template.click();
		Thread.sleep(25000);


	}

	@Test(priority=3)
	public void downloadPdf() throws InterruptedException{


		selectDownloadsMenu();
		WebElement pdf = Driver.findElement(By.linkText("PDF"));
		dropDownMenuBuilder(pdf);

		WebElement template = Driver.findElement(By.linkText("Default Report"));
		dropDownMenuBuilder(template);
		template.click();



	}


	@Test(priority=4)
	public void downloadImage() throws InterruptedException {

		selectDownloadsMenu();
		WebElement images = Driver.findElement(By.linkText("Images"));
		dropDownMenuBuilder(images);

		WebElement template = Driver.findElement(By.linkText("Default Report"));
		dropDownMenuBuilder(template);
		template.click();



	}

	@Test(priority = 5)
	public void downloadPowepoint() throws InterruptedException {

		selectDownloadsMenu();
		WebElement pp = Driver.findElement(By.linkText("Powerpoint"));
		dropDownMenuBuilder(pp);

		WebElement ppTemplate = Driver.findElement(By.linkText("Sample PowerPoint Features"));
		dropDownMenuBuilder(ppTemplate);
		ppTemplate.click();


	}

	@Test(priority=6)
	public void downloadXml() throws InterruptedException{


		selectDownloadsMenu();
		WebElement xml = Driver.findElement(By.linkText("XML"));
		dropDownMenuBuilder(xml);

		WebElement xmlTemplate = Driver.findElement(By.linkText("XML Default"));
		dropDownMenuBuilder(xmlTemplate);
		xmlTemplate.click();


	}

	@Test(priority=7)
	public void verifyDownloadedReprots() throws InterruptedException{


		Thread.sleep(3000);
		Driver.findElement(By.id("siteMapClose")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//a[contains(text(),'Exported Reports')]")).click();

		Thread.sleep(3000);

		String part1="//*[@id='ctl00_mainContentPlaceHolder_gridDownloads_ctl00__";
		String part2="']/td[2]";
		for(int i=0;i<4;i++)
		{
			String status = Driver.findElement(By.xpath(part1+i+part2)).getText();
			if(status=="running"){

				System.out.print("Exports still running");

			}else if(status=="Pending"){

				System.out.print("Exports Pending");

			}else if(status=="Failed"){

				System.out.print("Exports Failed");
				Assert.fail();
			}

		}


	}


	public void dropDownMenuBuilder(WebElement menu) throws InterruptedException{


		Actions action = new Actions(Driver);
		action.moveToElement(menu).build().perform();
		Thread.sleep(3000);


	}

	public void selectDownloadsMenu() throws InterruptedException {


		WebElement mainMenu;
		Thread.sleep(3000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar']/div/div/div/ul/li[1]/a/span/span/span/span[1]")).click();
		Thread.sleep(3000);

		mainMenu = Driver.findElement(By.linkText("Download"));
		dropDownMenuBuilder(mainMenu);
		Thread.sleep(3000);


	}
	@AfterMethod
	public void tear1Down(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// Create refernce of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot) Driver;

				// Call method to capture screenshot
				File source = ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all screenshot in our project home directory and
				// result.getName() will return name of test case so that screenshot name will be same
				FileUtils.copyFile(source, new File("C:\\Selenium\\ScreenshotsErrors\\" + result.getName() + ".png"));
				//FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));

				System.out.println("Screenshot taken");
			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}


		}

	}
}
	


