package com.styleanalytics.enterprise.Sharing;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TemplateNotShared extends EnterpriseBaseClass {


    Utility screenShot= new Utility();

    public String yesterdaysDate(){

        Date date = new Date(System.currentTimeMillis()-24*60*60*1000);
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/YY");
        return dateFormat.format(date);

    }



    @Test(priority = 1)
    public void accessTemplates() throws InterruptedException, IOException {
        try{
        GoTo goTo = new GoTo();
        goTo.goToTemplates();

    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplateNotShared_accessTemplates","TemplateNotShared_accessTemplates",e);
         }

    }



    @Test(priority = 2)
    public void createNotSharedTemplate() throws InterruptedException, IOException {
        try{
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdShowNew\"]")).click();
        Driver.findElement(By.xpath("//*[@id=\"divNewOptions\"]/a[1]")).click();
        Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[5]/div[1]/div/div[1]/div[1]")).click();
        Thread.sleep(5000);
        Driver.findElement(By.id("templateName")).sendKeys(yesterdaysDate() + " NotShared");
        WebElement TemplateSettings = Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[2]/div[1]"));
        Actions Act = new Actions(Driver);
        Act.moveToElement(TemplateSettings).build().perform();
        Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[2]/div[1]")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdSave\"]")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdClose_input\"]")).click();
        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(yesterdaysDate() + " NotShared");
        String ActTemplatenmae = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[1]/a")).getText();
        String ExpTemplateName = yesterdaysDate() + " NotShared";
        Assert.assertEquals(ActTemplatenmae, ExpTemplateName);
        Thread.sleep(5000);
        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[4]/a")).getText(), "No");
    }
        catch(Exception e){
            screenShot.takeScreenshotOnError("TemplateNotShared_createNotSharedTemplate","TemplateNotShared_createNotSharedTemplate",e);

    }
    }

    @Test(priority = 3)
    public void LogOutUser() throws InterruptedException {

        try {

            String url = property("URL");//Get the URL info from config file.

            Driver.get(url + "/authentication/srlogout.aspx");
            Thread.sleep(3000);
            System.out.print("Logout Successfully");

        } catch (Exception e) {

            System.out.print("Logout Failed");


        }
    }

    @Test(priority = 4)

    public void LogInAsOtherUser() throws InterruptedException, IOException {
        try{

        Driver.findElement(By.xpath("//*[@id='UserLogin_UserName']")).sendKeys("automatedtest2");
        Driver.findElement(By.xpath("//*[@id='UserLogin_Password']")).sendKeys("Test1234%");
        Driver.findElement(By.xpath("//*[@id='UserLogin_LoginButton']")).click();
        Thread.sleep(4000);

    }
        catch(Exception e){
            screenShot.takeScreenshotOnError("TemplateNotShared_LogInAsOtherUser","TemplateNotShared_LogInAsOtherUser",e);

    }

    }


    @Test(priority = 5)
    public void searchNotSharedTemplateByOtherUser() throws InterruptedException, IOException {
        try{
        GoTo goTo = new GoTo();
        goTo.goToTemplates();

        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(yesterdaysDate() + " NotShared");
        List<WebElement> FactorSets = Driver.findElements(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[2]")); // verifing deleted factor set
        Assert.assertEquals(FactorSets.size(), 0);
    }
        catch(Exception e){
            screenShot.takeScreenshotOnError("TemplateNotShared_searchNotSharedTemplateByOtherUser","TemplateNotShared_LsearchNotSharedTemplateByOtherUser",e);

    }

    }


    @Test(priority = 6)
    public void deleteNotSharedTemplate() throws InterruptedException, IOException {
        try{


        FactorSetsReadOnly factorsetRead = new FactorSetsReadOnly();
        factorsetRead.logBackToOriginalUser();

        GoTo goTo = new GoTo();
        goTo.goToTemplates();

        Thread.sleep(4000);

            Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).clear();
            Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(yesterdaysDate() + " NotShared");
            Thread.sleep(3000);
            Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[8]/a")).click();
            Thread.sleep(5000);

            String dynamicID = Driver.findElement(By.xpath("//iframe[contains(@name,'confirm')]")).getAttribute("name");
            Thread.sleep(5000);
            Driver.findElement(By.xpath("//*[@id='" + dynamicID + "_content']/div/div[2]/a/span/span")).click();

            Thread.sleep(3000);
            Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).clear();
            Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(yesterdaysDate() + " NotShared");
            List<WebElement> Sets=  Driver.findElements(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[2]")); // verifing deleted factor set
            Assert.assertEquals(Sets.size(), 0);
    }
        catch(Exception e){
            screenShot.takeScreenshotOnError("TemplateNotShared_deleteNotsharedTemplate","TemplateNotShared_deleteNotsharedTemplate",e);

    }
    }



}

   /* @Test(priority = 5)
    public void  verifyNotSharedTemplateInDownloads() throws InterruptedException {

        Driver.findElement(By.xpath("//*[@id=\"topNav2_hlReports\"]")).click();
        Thread.sleep(5000);
        WebElement RightHandmenu  = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_Image1\"]"));
        Actions Act = new Actions(Driver);
        Act.moveToElement(RightHandmenu).build().perform();
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_Image1\"]")).click();
        Thread.sleep(4000);
        Driver.findElement(By.xpath("//*[@id=\"rtvSettingsContainer\"]/div/div[2]/div/a[9]/span[2]")).click();
        Driver.switchTo().frame(0);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_txtFilter\"]")).sendKeys(dateFormat.format(date) + " NotShared");
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdFilter_input\"]")).click();
        Thread.sleep(5000);
        String Actmessage =Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridDownloadSettings_ctl00\"]/tbody/tr/td/div")).getText();
        String ExpMessage = "No records to display.";
        Assert.assertEquals(Actmessage, ExpMessage);
        Driver.switchTo().defaultContent();
        Driver.findElement(By.xpath("//*[@id=\"RadWindowWrapper_ctl00_mainContentPlaceHolder_report_radWindowStyleExposureSettings\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li/a")).click();


    }*/










