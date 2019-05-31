package com.styleanalytics.enterprise;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class ReportOldTemplateTest extends EnterpriseBaseClass {

    GoTo goTo = new GoTo();

    @Test(priority = 1)
    public void ImageTemplateCreate() throws InterruptedException, IOException {


        goTo.goToTemplates();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//input[@id='ctl00_mainContentPlaceHolder_cmdShowNew_input']")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//a[contains(text(),'Portfolio Image Template')]")).click();
        //Driver.switchTo().frame(0);
        //Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_radToolbar']/div/div/div/ul/li[1]/a/span/span/span/span")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[1]/div/span[3]")).click();
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[5]/div/span[3]")).click();
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[3]/div/span[3]")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtTemplateName']")).sendKeys(dateFormat.format(date) + " IMG -Test auto template");
        Thread.sleep(5000);
        Driver.findElement(By.cssSelector("#ctl00_mainContentPlaceHolder_dialogSave_input")).click();
        try {
            Driver.findElement(By.cssSelector("#ctl00_mainContentPlaceHolder_dialogcancel_input")).click();
        } catch (Exception e) {
        }

        //Driver.switchTo().defaultContent();
    }


    @Test(priority = 2)
    public void PDFTemplateCreate() throws InterruptedException {

        Driver.findElement(By.xpath("//input[@id='ctl00_mainContentPlaceHolder_cmdShowNew_input']")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//a[contains(text(),'Legacy Portfolio PDF')]")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[1]/div/span[3]")).click();
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[5]/div/span[3]")).click();
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[3]/div/span[3]")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtTemplateName']")).sendKeys(dateFormat.format(date) + " PDF -Test auto template");
        Thread.sleep(5000);
        Driver.findElement(By.cssSelector("#ctl00_mainContentPlaceHolder_dialogSave_input")).click();
        try {

            Driver.findElement(By.cssSelector("#ctl00_mainContentPlaceHolder_dialogcancel_input")).click();

        } catch (Exception e) {
        }

        //Driver.switchTo().defaultContent();

    }


    @Test(priority = 3)
    public void ExcelTemplateCreate() throws InterruptedException {


        Driver.findElement(By.xpath("//input[@id='ctl00_mainContentPlaceHolder_cmdShowNew_input']")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//a[contains(text(),'Portfolio Excel Template')]")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[1]/div/span[3]")).click();
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[5]/div/span[3]")).click();
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[3]/div/span[3]")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtTemplateName']")).sendKeys(dateFormat.format(date) + " Excel -Test auto template");
        Thread.sleep(5000);
        Driver.findElement(By.cssSelector("#ctl00_mainContentPlaceHolder_dialogSave_input")).click();
        try {

            Driver.findElement(By.cssSelector("#ctl00_mainContentPlaceHolder_dialogcancel_input")).click();

        } catch (Exception e) {
        }

        //Driver.switchTo().defaultContent();

    }


    @Test(priority = 4)
    public void XMLTemplateCreate() throws InterruptedException {


        Driver.findElement(By.xpath("//input[@id='ctl00_mainContentPlaceHolder_cmdShowNew_input']")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//a[contains(text(),'Portfolio XML Template')]")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[1]/div/span[3]")).click();
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[2]/div/span[3]")).click();
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tvTemplate']/ul/li[3]/div/span[3]")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtTemplateName']")).sendKeys(dateFormat.format(date) + " XML -Test auto template");
        Thread.sleep(5000);
        Driver.findElement(By.cssSelector("#ctl00_mainContentPlaceHolder_dialogSave_input")).click();
        try {

            Driver.findElement(By.cssSelector("#ctl00_mainContentPlaceHolder_dialogcancel_input")).click();

        } catch (Exception e) {
        }

        Driver.switchTo().defaultContent();

    }

    //@Test (priority=5)need to refactor
    public void VerifyAddedTemplate() {

        Driver.switchTo().frame(0);
        String tname = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_gridDownloadSettings_ctl00__3']/td[2]/a")).getText();
        Assert.assertEquals(tname, "XML -Test auto template");

        System.out.println("Verified Template Creation");
        Driver.switchTo().defaultContent();

    }

    //@Test(priority = 0)
    public void DeleteTemplate() throws InterruptedException, IOException {

        goTo.goToTemplates();
        Thread.sleep(3000);
        //Create a Image Template

        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_Image1']")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_aManageTemplates']/span[1]")).click();
        Thread.sleep(3000);

        Driver.switchTo().frame(0);

        Thread.sleep(10000);

        List<WebElement> elementsRoot = Driver.findElements(By.className("rgRow"));

        System.out.println(elementsRoot.size());

        for (int i = 0; i < elementsRoot.size(); ++i) {
            WebElement checkbox = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridDownloadSettings_ctl00__0\"]/td[1]"));

            checkbox.click();

            //driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridDownloadSettings_ctl00_ctl04_gbcDeleteColumn\"]")).click();

            Thread.sleep(2000);

            // Click on the confirmation popup

            String dynamicID = Driver.findElement(By.xpath("//iframe[contains(@name,'confirm')]")).getAttribute("name");
            Driver.findElement(By.xpath("//*[@id='" + dynamicID + "_content']/div/div[2]/a[1]/span/span")).click();
            Thread.sleep(5000);

        }

    }


}
