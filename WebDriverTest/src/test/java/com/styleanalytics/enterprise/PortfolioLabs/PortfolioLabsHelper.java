package com.styleanalytics.enterprise.PortfolioLabs;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class PortfolioLabsHelper extends EnterpriseBaseClass {


    public static void deleteFilesFromFolder(String LocationPropertyFromConfig) throws IOException {

        String pdfErrorPath =property(LocationPropertyFromConfig);

        //String path ="C:\\Selenium\\Build Outputs\\PDF Comparison Errors";
        File file =new File(pdfErrorPath);
        for(File f:file.listFiles()){
            f.delete();
        }

    }

    public static void findLabsReport(String labsReportName) throws InterruptedException {

        Driver.findElement(By.xpath("//div[@class='ui-state-default slick-headerrow-column l0 r0']//input[@type='text']")).sendKeys(labsReportName);

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//a[contains(@class,'sgButtonGreen')]")).click();

        Utility.waitForElementToDisplay("//div[contains(text(),'Portfolio Style Skyline ™')]");

        WebElement reportName = Driver.findElement(By.xpath("//h1[@id='scenarioName']"));

        Assert.assertTrue(reportName.getText().contains(labsReportName));
    }

    public static void downloadReport(String reportTemplateName) throws InterruptedException {

        Thread.sleep(5000);

        Driver.findElement(By.xpath("//img[@id='ctl00_mainContentPlaceHolder_Image1']")).click();

        Utility.waitForElementToDisplay("//a[text()='Download']");

        Driver.findElement(By.xpath("//a[text()='Download']")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//div[@class='ui-state-default slick-headerrow-column l0 r0']//input[@type='text']")).sendKeys(reportTemplateName+" ");

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//a[@class='sgButtonGreen']")).click();




    }
}
