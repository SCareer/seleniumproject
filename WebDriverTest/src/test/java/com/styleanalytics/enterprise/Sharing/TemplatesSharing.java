package com.styleanalytics.enterprise.Sharing;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.mustache.Value;
import sun.awt.SunHints;
import sun.security.krb5.Config;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;



public class TemplatesSharing extends Utility {



    Utility screenShot= new Utility();

    private String ydate = yesterdaysDate("dd/MM/YY");

    private String tdate = todaysDate("dd/MM/yy HH:mm");



    @Test(priority = 1)
        public void accessTemplates() throws InterruptedException, IOException {
            try{
        GoTo goTo = new GoTo();
        goTo.goToTemplates();
        }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesSharing_accessTemplates","TemplatesSharing_accessTemplates",e);
    }

    }



    @Test(priority = 2)
    public void createNotSharedTemplate() throws InterruptedException, IOException {

        try{
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdShowNew\"]")).click();
        Driver.findElement(By.xpath("//*[@id=\"divNewOptions\"]/a[1]")).click();
        //Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[5]/div[1]/div/div[1]/div[1]")).click();
        Thread.sleep(5000);
        Driver.findElement(By.id("templateName")).sendKeys(tdate);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdSave\"]")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdClose_input\"]")).click();
        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate);
        String ActTemplatenmae = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[1]/a")).getText();
        String ExpTemplateName = tdate;
        Assert.assertEquals(ActTemplatenmae, ExpTemplateName);
        Thread.sleep(5000);
        String ActIsShared = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[4]")).getText();
        String ExpectedIsShared = "No";
        Assert.assertEquals(ActIsShared, ExpectedIsShared);
    }
        catch(Exception e){
            screenShot.takeScreenshotOnError("TemplatesSharing_createNotSharedTemplate","TemplatesSharing_createNotSharedTemplate",e);

    }


    }


    @Test(priority = 3)
    public void deleteButton() throws IOException {
            try {
                String ActDeleteText = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[8]")).getText();
                String EcpDeleteText = "DELETE";
                Assert.assertEquals(ActDeleteText, EcpDeleteText);
            }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesSharing_deleteButton","TemplatesSharing_deleteButton",e);


         }
    }

    @Test(priority = 4)
    public void verifyView() throws IOException {
            try{
        String ACTView = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[7]")).getText();
        String ExpView = "VIEW";
        Assert.assertEquals(ACTView, ExpView);
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesSharing_verifyView","TemplatesSharing_verifyView",e);
    }
    }

    @Test(priority = 5)
    public void viewTemplate() throws IOException {
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
             screenShot.takeScreenshotOnError("TemplatesSharing_viewTemplate","TemplatesSharing_viewTemplate",e);

    }


    }


    @Test(priority = 6)
    public void sharingLabel() throws InterruptedException, IOException {
            try{
        WebElement TemplateSettings  = Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[2]/div[1]"));
        Actions Act = new Actions(Driver);
        Act.moveToElement(TemplateSettings).build().perform();
        Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[2]/div[1]")).click();
        Thread.sleep(5000);
        String ActSharingLabel = Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[2]/div[2]/div[12]/label")).getText();
        String ExpSharingLable = "Sharing:";
        Assert.assertEquals(ActSharingLabel, ExpSharingLable);
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesSharing_sharingLabel","TemplatesSharing_sharingLabel",e);

    }
    }

    @Test(priority = 7)
    public void notSharedLabel() throws IOException {
            try{
      String AcrNotShared=   Driver.findElement(By.xpath("//*[@id=\"shareTemplateButton\"]/span")).getText();
      String ExpNotShared =  "Not shared";
      Assert.assertEquals(AcrNotShared, ExpNotShared);
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesSharing_notSharedLabel","TemplatesSharing_notSharedLabel",e);

    }

    }

    @Test(priority = 8)
    public void accessRightPopup() throws InterruptedException, IOException {

            try{

       // Driver.findElement(By.cssSelector("*[id $='ctl00_mainContentPlaceHolder']"));
        Driver.findElement(By.xpath("//input[@value='Edit']")).click();
        Driver.switchTo().frame(0);
        //Driver.findElement(By.id("//*[contains(@id, 'RadWindowWrapper_ctl00_mainContentPlaceHolder')]"));
        WebElement t = Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[1]"));
        System.out.println(t.getText());
        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[3]/input")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).click();
        Thread.sleep(5000);
        Driver.switchTo().defaultContent();
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdClose_input\"]")).click();
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesSharing_accessRightPopup","TemplatesSharing_accessRightPopup",e);
    }


    }
    @Test(priority = 9)
    public void sharedAfterEdit() throws InterruptedException, IOException {
            try{
        Driver.findElement(By.xpath("/html[1]/body[1]/div[2]/form[1]/div[6]/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/input[1]")).sendKeys(tdate);

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[1]/a")).getText(), tdate);
        Thread.sleep(5000);
        String ActIsSharedAfterEdit = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[4]")).getText();
        String ExpectedIsSharedAfterEdit = "Yes";
        Assert.assertEquals(ActIsSharedAfterEdit, ExpectedIsSharedAfterEdit);
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesSharing_sharedAfterEdit","TemplatesSharing_sharedAfterEdit",e);
    }

    }

    @Test(priority = 10)
    public void sharedFullAccessFromManageTemplates() throws InterruptedException, IOException {
            try{
        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).clear();
        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate);
        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[4]")).click();
        Driver.switchTo().frame(0);
        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[4]/input")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).click();
        Thread.sleep(5000);
        Driver.switchTo().defaultContent();

        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate);
        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[4]")).click();
        Driver.switchTo().frame(0);
        boolean actualselected= Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[4]/input")).isSelected();
        boolean expectedFullcontrolSelected = true;
        Assert.assertEquals(actualselected,expectedFullcontrolSelected);
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).click();
        Driver.switchTo().defaultContent();
        Thread.sleep(3000);
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesSharing_sharedFullAccessFromManageTemplates","TemplatesSharing_sharedFullAccessFromManageTemplates",e);
    }
    }


    @Test(priority = 11)
    public void notSharedFromManageTemplates() throws InterruptedException, IOException {
            try{

        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[4]")).click();
        Driver.switchTo().frame(0);
        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[2]/input")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).click();
        Thread.sleep(5000);
        Driver.switchTo().defaultContent();
        String ActIsNotSharedText = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[4]")).getText();
        String ExpectedNotSharedText = "No";
        Assert.assertEquals(ActIsNotSharedText, ExpectedNotSharedText);
    }
         catch(Exception e){
             screenShot.takeScreenshotOnError("TemplatesSharing_notSharedFromManageTemplates","TemplatesSharing_notSharedFromManageTemplates",e);
    }

    }

    @Test(priority = 12)
    public void deleteTemplate() throws InterruptedException, IOException {


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



    }









