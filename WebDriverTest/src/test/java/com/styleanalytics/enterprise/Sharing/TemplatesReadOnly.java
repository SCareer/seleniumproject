package com.styleanalytics.enterprise.Sharing;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TemplatesReadOnly extends Utility {

    Utility screenShot= new Utility();

    private String ydate = yesterdaysDate("dd/MM/YY");

    private String tdate = todaysDate("dd/MM/yy HH:mm");

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult result){

        Utility.tearDown(result);
    }


    @Test(priority = 1)
    public void accessTemplates() throws InterruptedException, IOException {
        try{
       GoTo goTo = new GoTo();
         goTo.goToTemplates();
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesReadOnly_accessTemplates","TemplatesReadOnly_accessTemplates",e);

    }

    }

    @Test(priority = 2)
    public void createReadOnlyTemplate() throws InterruptedException, IOException {

        try {

            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdShowNew\"]")).click();
            Driver.findElement(By.xpath("//*[@id=\"divNewOptions\"]/a[1]")).click();
            Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[5]/div[1]/div/div[1]/div[1]")).click();
            Thread.sleep(5000);
            Driver.findElement(By.id("templateName")).sendKeys(tdate + "ReadOnlyTemplate");
            WebElement TemplateSettings = Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[2]/div[1]"));
            Actions Act = new Actions(Driver);
            Act.moveToElement(TemplateSettings).build().perform();
            Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[2]/div[1]")).click();
            Thread.sleep(5000);
            Driver.findElement(By.xpath("//*[@id =\"shareTemplateButton\"]/input")).click();
            Driver.switchTo().frame(0);
            WebElement t = Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[1]"));
            System.out.println(t.getText());
            Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[3]/input")).click();
            Thread.sleep(5000);
            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).click();
            Thread.sleep(5000);
            Driver.switchTo().defaultContent();
            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdSave\"]")).click();
            Thread.sleep(5000);
            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdClose_input\"]")).click();
            Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + "ReadOnlyTemplate");
            String ActTemplatename = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[1]/a")).getText();
            String ExpTemplateName = tdate + "ReadOnlyTemplate";
            Assert.assertEquals(ActTemplatename, ExpTemplateName);
            Thread.sleep(5000);
            String ActIsShared = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[4]")).getText();
            String ExpectedIsShared = "Yes";
            Assert.assertEquals(ActIsShared, ExpectedIsShared);
        } catch (UnhandledAlertException f) {
            try {
                Alert alert = Driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            screenShot.takeScreenshotOnError("TemplatesReadOnly_createReadOnlyTemplate", "TemplatesReadOnly_createReadOnlyTemplate", e);


        }

    }

    @Test(priority = 3)

    public void LoginAsOtherUser() throws InterruptedException, IOException {
        try{


            String OtherUser = property("sharedUser");
            String  Pwd = property("sharedUserPass");

            SharingHelpers sH= new SharingHelpers();

            sH.logOutUser();

            sH.logInasOther(OtherUser, Pwd);
    }
         catch(Exception e){
            System.out.println("TemplateReadOnly_LoginAsOtherUser Test Failed "+e);
             screenShot.takeScreenshotOnError("TemplatesReadOnly_LoginAsOtherUser","TemplatesReadOnly_LoginAsOtherUser",e);

        }

    }

    @Test(priority = 4)
    public void readonlyTemplateByOtherUser() throws InterruptedException, IOException {
        try{
        GoTo goTo = new GoTo();
        goTo.goToTemplates();
        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + "ReadOnlyTemplate");
        String sharedTemplate = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[1]/a")).getText();
        System.out.println(sharedTemplate);
        String ExpectedSharedTemplate = tdate + "ReadOnlyTemplate";
        Assert.assertEquals(sharedTemplate, ExpectedSharedTemplate);
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesReadOnly_readonlyTemplateByOtherUser","TemplatesReadOnly_readonlyTemplateByOtherUser",e);

    }

    }

    @Test(priority = 5)
    public void isSharedLabel() throws IOException {
        try{

        String ReadoOnlyIsShared = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[4]")).getText();
        String ExpReadoOnlyIsShared = "Yes";
        Assert.assertEquals(ReadoOnlyIsShared, ExpReadoOnlyIsShared);
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesReadOnly_isSharedLabel","TemplatesReadOnly_isSharedLabel",e);

    }

    }

    @Test(priority = 6)
    public void accessReadOnlyTemplate() throws IOException {
       try{


        WebElement ViewText = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[7]"));
        Actions Act = new Actions(Driver);
        Act.moveToElement(ViewText).build().perform();
        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[7]/a")).click();
        String ActLabel = Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[1]/div[2]/div[1]")).getText();
        String ExpLabel = "Template Name:";
        Assert.assertEquals(ActLabel, ExpLabel);
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesReadOnly_accessReadOnlyTemplate","TemplatesReadOnly_accessReadOnlyTemplate",e);

    }


    }

    @Test(priority = 7)
    public void editReadOnlyTemplate() throws InterruptedException, IOException {
        try{

        Thread.sleep(3000);
        Boolean ActSavebuttonEnabled = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdDelete_input\"]")).isEnabled();
        System.out.println(ActSavebuttonEnabled);
        Boolean ExpSavebuttonEnabled = false;
        Assert.assertEquals(ActSavebuttonEnabled, ExpSavebuttonEnabled);
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesReadOnly_editReadOnlyTemplate","TemplatesReadOnly_editReadOnlyTemplate",e);

    }

    }

    @Test(priority = 8)
    public boolean deleteButton() throws InterruptedException, IOException {

        GoTo goTo = new GoTo();
        goTo.goToTemplates();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + "ReadOnlyTemplate");


        try {
            Driver.findElement(By.className("sgButtonRed"));
            System.out.println("Element Present");
            return false;

        } catch (NoSuchElementException e) {
            System.out.println("Element absent");


            return true;
        }

    }






    @Test(priority = 9)
    public void dleateReadOnlyTemplate() throws InterruptedException, IOException {
        String OrgninalUser = property("username");
        String  OriginalPwd = property("password");

        try{
            SharingHelpers sH= new SharingHelpers();

            sH.logOutUser();

            sH.logInasOther(OrgninalUser, OriginalPwd);

            Thread.sleep(4000);
        }
        catch(Exception e){
            screenShot.takeScreenshotOnError("FactorSetReadOnly_logBackToOriginalUser","FactorSetsReadOnly_logBackToOriginalUser",e);
        }

        GoTo goTo = new GoTo();
        goTo.goToTemplates();
        screenShot.deleteTemplate(ydate);

            }

   /*@Test(priority = 10)

    public void verifyReadOnlyTemplateinDownloads() throws InterruptedException {


        try {
            Alert al = Driver.switchTo().alert();// 2seconds
            Thread.sleep(5000);
            System.out.println(al.getText());
            al.accept();//ok
            //al.dismiss();
            Driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }


        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdClose_input\"]")).click();
        Thread.sleep(5000);

        //Driver.findElement(By.xpath("//*[@id=\"topNav2_hlReports\"]")).click();


        Thread.sleep(5000);
        WebElement RightHandmenu = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_Image1\"]"));
        Actions Act = new Actions(Driver);
        Act.moveToElement(RightHandmenu).build().perform();
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_Image1\"]")).click();
        Thread.sleep(4000);
        Driver.findElement(By.xpath("//*[@id=\"rtvSettingsContainer\"]/div/div[2]/div/a[9]/span[2]")).click();
        Driver.switchTo().frame(0);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_txtFilter\"]")).sendKeys(dateFormat.format(date) + " ReadOnlyTemplate");
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdFilter_input\"]")).click();
        Thread.sleep(5000);
        String ActTemplateName = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridDownloadSettings_ctl00__0\"]/td[1]/a")).getText();
        String ExpTemplateName = dateFormat.format(date) + " ReadOnlyTemplate";
        Assert.assertEquals(ActTemplateName, ExpTemplateName);
        Driver.switchTo().defaultContent();
        Driver.findElement(By.xpath("//*[@id=\"RadWindowWrapper_ctl00_mainContentPlaceHolder_report_radWindowStyleExposureSettings\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li/a")).click();


    }*/


}

