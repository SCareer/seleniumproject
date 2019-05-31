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

public class TemplateFullControl extends Utility {

    Utility screenShot = new Utility();

    private String ydate = yesterdaysDate("dd/MM/YY");

    private String tdate = todaysDate("dd/MM/yy HH:mm");

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult result) {

        Utility.tearDown(result);
    }


    public void accessTemplates() throws InterruptedException, IOException {

        GoTo goTo = new GoTo();
        goTo.goToTemplates();


    }

    @Test(priority = 2)
    public void createTemplatefullControl() throws InterruptedException, IOException {


        accessTemplates();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdShowNew\"]")).click();
        Driver.findElement(By.xpath("//*[@id=\"divNewOptions\"]/a[1]")).click();
        //Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[5]/div[1]/div/div[1]/div[1]")).click();
        Thread.sleep(5000);
        Driver.findElement(By.id("templateName")).sendKeys(tdate + " TestTemplate");
        WebElement TemplateSettings = Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[2]/div[1]"));
        Actions Act = new Actions(Driver);
        Act.moveToElement(TemplateSettings).build().perform();
        Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[2]/div[1]")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id =\"shareTemplateButton\"]/input")).click();
        Driver.switchTo().frame(0);

        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[4]/input")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).click();
        Thread.sleep(5000);
        Driver.switchTo().defaultContent();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdSave\"]")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdClose_input\"]")).click();

        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + " TestTemplate");

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[1]/a")).getText(), tdate + " TestTemplate");
        Thread.sleep(5000);

        Assert.assertEquals(Driver.findElement(By.xpath("//div[@class='grid-canvas grid-canvas-top grid-canvas-left']//div[1]//div[4]//a[1]")).getText(), "Yes");


    }


    public void LogInAsOtherUser() throws InterruptedException, IOException {


        String OtherUser = property("sharedUser");
        String Pwd = property("sharedUserPass");

        SharingHelpers sH = new SharingHelpers();

        sH.logOutUser();

        sH.logInasOther(OtherUser, Pwd);


    }


    @Test(priority = 4, dependsOnMethods = "createTemplatefullControl")
    public void verifyFullControlTemplateByOtherUser() throws InterruptedException, IOException {


        LogInAsOtherUser();

        accessTemplates();

        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + " TestTemplate");
        Thread.sleep(3000);
        String sharedTemplate = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[1]/a")).getText();
        System.out.println(sharedTemplate);
        String ExpectedSharedTemplate = tdate + " TestTemplate";
        Assert.assertEquals(sharedTemplate, ExpectedSharedTemplate);


    }

    @Test(priority = 5, dependsOnMethods = "createTemplatefullControl")
    public void verifyIsSharedLabel() throws IOException {

        String FullControlIsShared = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div/div[4]")).getText();
        String ExpectedFullControlIsShared = "Yes";
        Assert.assertEquals(FullControlIsShared, ExpectedFullControlIsShared);

    }


    @Test(priority = 6, dependsOnMethods = "createTemplatefullControl")
    public void verifyView() throws InterruptedException, IOException {


        String ActFullcontrolView = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[7]/a")).getText();
        String ExpFullcontrolView = "VIEW";
        Assert.assertEquals(ActFullcontrolView, ExpFullcontrolView);


    }

    @Test(priority = 7, dependsOnMethods = "createTemplatefullControl")
    public void verifyDeleteButton() throws InterruptedException, IOException {


        String ACTFullcontrolDelete = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[8]/a")).getText();
        String ExpFullcontrolDelete = "DELETE";
        Assert.assertEquals(ACTFullcontrolDelete, ExpFullcontrolDelete);


    }

    //User able to access control pop up for full control Shared template
    @Test(priority = 8, dependsOnMethods = "createTemplatefullControl")
    public void verifyAccessRightFromView() throws InterruptedException, IOException {

        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[4]/a")).click();
        Thread.sleep(3000);
        Driver.switchTo().frame(0);
        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/thead/tr/td[4]")).getText(), "Shared with Full Control");

        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).click();
        Thread.sleep(5000);
        Driver.switchTo().defaultContent();


    }

    @Test(priority = 9, dependsOnMethods = "createTemplatefullControl")
    public void accessingFullControlTemplate() throws IOException {


        WebElement ViewText = Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[7]"));
        Actions Act = new Actions(Driver);
        Act.moveToElement(ViewText).build().perform();
        Driver.findElement(By.xpath("//*[@id=\"divExistingTemplates\"]/div[4]/div[3]/div/div[1]/div[7]/a")).click();
        String ActLabel = Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[1]/div[2]/div[1]")).getText();
        String ExpLabel = "Template Name:";
        Assert.assertEquals(ActLabel, ExpLabel);


    }

    @Test(priority = 10, dependsOnMethods = "createTemplatefullControl")
    public void editFullControlTemplate() throws IOException {


        Boolean ActSavebuttonEnabled = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdSave_input\"]")).isEnabled();
        System.out.println(ActSavebuttonEnabled);
        Boolean ExpSavebuttonEnabled = true;
        Assert.assertEquals(ActSavebuttonEnabled, ExpSavebuttonEnabled);


    }

    @Test(priority = 11, dependsOnMethods = "createTemplatefullControl")
    public void deleteButtonFromEditView() throws InterruptedException, IOException {


        Boolean ActDeleteButton = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdDelete_input\"]")).isEnabled();
        Boolean ExpDeleteButton = true;
        Assert.assertTrue(ActDeleteButton, String.valueOf(ExpDeleteButton));

    }


    @Test(priority = 12, dependsOnMethods = "createTemplatefullControl")
    public void editButtonFromView() throws InterruptedException, IOException {

        WebElement TemplateSettings = Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[2]/div[1]"));
        Actions Act = new Actions(Driver);
        Act.moveToElement(TemplateSettings).build().perform();
        Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/div[1]/div/div/div[3]/div/div[2]/div[1]")).click();
        Thread.sleep(5000);

        String ActEdit = Driver.findElement(By.xpath("//*[@id=\"shareTemplateButton\"]/input")).getAttribute("value");
        System.out.println(ActEdit);
        String ExpEdit = "Edit";
        Assert.assertEquals(ActEdit, ExpEdit);


    }


    @Test(priority = 13, dependsOnMethods = "createTemplatefullControl")
    public void deleteFullControlTemplate() throws IOException, InterruptedException {
        String OrgninalUser = property("username");
        String OriginalPwd = property("password");


        SharingHelpers sH = new SharingHelpers();

        sH.logOutUser();

        sH.logInasOther(OrgninalUser, OriginalPwd);

        Thread.sleep(4000);

        GoTo goTo = new GoTo();
        goTo.goToTemplates();
        screenShot.deleteTemplate(ydate);
    }

}
