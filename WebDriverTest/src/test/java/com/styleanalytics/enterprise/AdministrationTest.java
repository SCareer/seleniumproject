package com.styleanalytics.enterprise;

//import Excel_read;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class AdministrationTest extends EnterpriseBaseClass{

	@AfterClass
	public void error() throws IOException {

		EnterpriseBaseClass enterBC=new EnterpriseBaseClass();
		enterBC.takeScreenShotOnFailure("Administration");
	}
	//@Test(priority = 2)
	public void DeleteLocation() throws InterruptedException{
		

		Thread.sleep(5000);
		Driver.switchTo().defaultContent();
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radGridManageLocations_ctl00__0']/td[3]")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radGridManageLocations_ctl00_ctl04_gbcDeleteButton']")).click();
		
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radToolbarManageLocations']/div/div/div/ul/li/a/span/span/span/span[1]")).click();
		System.out.println("Clicked the delete button");
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='aspnetForm']/div[1]/div/ul/li[3]/a/span")).click();
		Driver.findElement(By.xpath("//*[@id='aspnetForm']/div[1]/div/ul/li[3]/a/span")).sendKeys(Keys.RETURN);
		}
		
		
		
	/*	// Click on the confirmation popup
		
				String dynamicID = Driver.findElement(By.xpath("//iframe[contains(@name,'confirm')]")).getAttribute("name");
				
				String verifyText= Driver.findElement(By.xpath("//*[@id='"+dynamicID+"_content']/div/div[1]")).getText();
				
				Assert.assertTrue(verifyText.contains("Are you sure you want to delete this Location?"));
				System.out.println("Clicked the delete button");
				
				Driver.findElement(By.xpath("//*[@id='"+dynamicID+"_content']/div/div[2]/a[1]/span/span")).click();
				Thread.sleep(5000);*/
		

	
	@Test(priority=1)
	public void AddLocation() throws InterruptedException, IOException {

		String URL = property("URL");

		Thread.sleep(2000);
		Driver.get(URL+"/admin/manageLocations.aspx");
		Thread.sleep(2000); 
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_organizationSelector_cmbOrg_Input']")).click();
		Thread.sleep(2000); 
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_organizationSelector_cmbOrg_Input']")).sendKeys("Test Automation");

		Thread.sleep(5000); 
		
		//Refractor the code to select the first result of the search drop down
		
	/*	String part1="//*[@id='ctl00_mainContentPlaceHolder_organizationSelector_cmbOrg_DropDown']/div[2]/ul/li[";
		String part2="]/table/tbody/tr/td[1]";
		
		for(int count=0;count<;count++)*/

		
		Driver.findElement(By.xpath("//*[@id='ctl00_ctl00_mainContentPlaceHolder_organizationSelectorPanel']/div/div/label")).click();
		Thread.sleep(5000); 
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radToolbarManageLocations']/div/div/div/ul/li/a/span/span/span/span[1]")).click();
		Thread.sleep(2000); 
		Driver.findElement(By.xpath(" //*[@id='aspnetForm']/div[1]/div/ul/li[1]/a/span")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_manageLocationEditWindow_C_manageLocationEdit_txtLocationName']")).sendKeys("Test Automated Location");
		Thread.sleep(2000); 
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_manageLocationEditWindow_C_manageLocationEdit_radDDLCountryName']/span")).click();
		Thread.sleep(2000); 
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_manageLocationEditWindow_C_manageLocationEdit_radDDLCountryName_DropDown']/div/ul/li[138]")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_manageLocationEditWindow_C_manageLocationEdit_btnSave_input']")).click();
		Thread.sleep(4000);
		
		// Click on the confirmation popup
		
		String dynamicID = Driver.findElement(By.xpath("//iframe[contains(@name,'alert')]")).getAttribute("name");
		
		String verifyText= Driver.findElement(By.xpath("//*[@id='"+dynamicID+"_content']/div/div[1]")).getText();
		
		Assert.assertTrue(verifyText.contains("added successfully for Test Automation."));
		
		Driver.findElement(By.xpath("//*[@id='"+dynamicID+"_content']/div/div[2]/a/span/span")).click();
		Thread.sleep(5000);
		}

	
	
	@Test(priority=3)
	public void CreateBundle() throws InterruptedException, IOException {

		String URL = property("URL");

		Driver.get(URL+"/Admin/manageBundles.aspx");
		
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdAddNew_input']")).click();
		Thread.sleep(2000);
		Driver.switchTo().frame(0);
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtName']")).sendKeys("Producer Bundle");
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtDesc']")).sendKeys("Producer Bundle");
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='gridProducts']/div[4]/div[1]/div[2]/div[2]/input")).sendKeys("Producer");
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='gridProducts']/div[4]/div[3]/div/div[1]/div[1]/input")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radTabStripProducts']/div/ul/li[2]/a/span/span/span")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='gridProducts']/div[4]/div[3]/div/div[1]/div[1]/input")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radTabStripProducts']/div/ul/li[3]/a/span/span/span")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='gridProducts']/div[4]/div[3]/div/div[1]/div[1]/input")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdSave_input']")).click();
		Driver.switchTo().defaultContent();
		
		Driver.findElement(By.xpath("//*[@id='divBundles']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys("Producer Bundle");
		Thread.sleep(2000);
		String bundleName = Driver.findElement(By.xpath("//*[@id='divBundles']/div[4]/div[3]/div/div/div[1]/a")).getText();
		Assert.assertEquals(bundleName,"Producer Bundle");
		}
	
	
		

	@Test(priority=4)
	public void DeleteBundle() throws InterruptedException, IOException {

		String URL = property("URL");
		Driver.get(URL+"/Admin/manageBundles.aspx");
		
		Driver.findElement(By.xpath("//*[@id='divBundles']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys("Producer Bundle");
		Thread.sleep(2000);
		String bundleName = Driver.findElement(By.xpath("//*[@id='divBundles']/div[4]/div[3]/div/div/div[1]/a")).getText();
		Thread.sleep(2000);
		Assert.assertEquals("Producer Bundle", bundleName);
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='divBundles']/div[4]/div[3]/div/div/div[8]/img")).click();
		
		}

	
	public void AddUser() throws InterruptedException {
		// TODO Auto-generated method stub
	

			Driver.findElement(By.xpath("//*[@id='topNav2_Image1']")).click();
			Driver.findElement(By.xpath("//*[@id='topNav2_navSiteMap1_rptMenu_ctl07_rptSubMenu_ctl02_hlMenu']")).click();
			Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_organizationSelector_cmbOrg_Input']")).sendKeys("Vish Test Organization");
			Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_organizationSelector_cmbOrg_Input']")).sendKeys(Keys.RETURN);
			Thread.sleep(5000);
			Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radToolbarManageUsers']/div/div/div/ul/li[1]/a/span/span/span/span[2]")).click();
			Thread.sleep(2000);
			Driver.findElement(By.xpath("//*[@id='aspnetForm']/div[1]/div/ul/li[1]/a")).click();
			Thread.sleep(5000);
			//Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_manageUserEditWindow_C_manageUserEdit_txtUserEmailAddress']")).sendKeys(Excel_read.value);
			Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_manageUserEditWindow_C_manageUserEdit_txtUserName']")).sendKeys("b");
			Thread.sleep(5000);
			
			String title = Driver.getTitle();
			System.out.println(title);
			Driver.findElement(By.cssSelector(".rwInnerSpan")).click();
			
		
			Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_manageUserEditWindow_C_manageUserEdit_CheckBoxUserGroups']/tbody/tr[1]/td[1]/label")).click();
			Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_manageUserEditWindow_C_manageUserEdit_CheckBoxListFunctionalProducts']/tbody/tr[1]/td[1]/label")).click();
			Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_manageUserEditWindow_C_manageUserEdit_btnSave_input']")).click();
			Thread.sleep(5000);
			Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_manageUserEditWindow_C_manageUserEdit_btnClose_input']")).click();
			Driver.findElement(By.xpath("//*[@id='ctl00_topNav2_HyperLink1']")).click();
			}

}
