package com.styleanalytics.enterprise.TemplateBuilder;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Viswanath on 13/07/2017.
 */
public class TemplateFormatTest extends EnterpriseBaseClass {


    Utility ut = new Utility();
    TemplateBuilderUtility tempUtility = new TemplateBuilderUtility();
    TemplateBuilderPage tPage = new TemplateBuilderPage();
    TemplateBuilderTest temp = new TemplateBuilderTest();




    //@BeforeClass
    public void setup() throws InterruptedException {

        //TestBase tBase = new TestBase();
        EnterpriseBaseClass tBase = new EnterpriseBaseClass();

    }
    //@AfterClass
    public void close() throws InterruptedException{

        //TestBase testBase = new TestBase();
        //testBase.LogoutTest();
    }

    @Test(priority = 1)
     public void formattingDefaults() throws InterruptedException, IOException {

       TemplateBuilderPage tPage = new TemplateBuilderPage();
      //  TemplateBuilderTest temp = new TemplateBuilderTest();
        //TemplateBuilderUtility tempUtility = new TemplateBuilderUtility();

        temp.navigateToTemplateBuilder();


        tempUtility.openNewTemplate("Formatting Test - Automation");

        Thread.sleep(10000);

        Driver.findElement(By.xpath("//*[contains(text(),'Formatting')] ")).click();

        Thread.sleep(7000);

        tempUtility.findAndVerifyContent(tPage.reportTitleLabel,"Report Title:");

        //Assert.assertEquals(tPage.reportTitleLabel.getText(),"Report Title:");

        Assert.assertTrue(tPage.reportTitleFont.getAttribute("value").contains("Gothic"));

        System.out.print(tPage.reportTitleFont.getAttribute("value"));

        //Page Title

        Assert.assertEquals(tPage.pageTitleLabel.getText(),"Page Title:");

        Assert.assertTrue(tPage.pageTitleFont.getAttribute("value").contains("Gothic"));

        Assert.assertTrue(tPage.pageTitleFontSize.getAttribute("value").contains("11px"));

        //Block Title

        Assert.assertEquals(tPage.blockTitleLabel.getText(),"Block Title:");

        Assert.assertTrue(tPage.blockTitleFont.getAttribute("value").contains("Roboto"));

        Assert.assertTrue(tPage.blockTitleFontSize.getAttribute("value").contains("9px"));

        //Grid Data

        Assert.assertEquals(tPage.gridDataLabel.getText(),"Grid Data:");

        Assert.assertTrue(tPage.gridDataFont.getAttribute("value").contains("Gothic"));

        Assert.assertTrue(tPage.gridDataFontSize.getAttribute("value").contains("5px"));

        //Legend

        //Assert.assertEquals(tPage.legendLabel.getText(),"Legend:");

        //findAndVerifyContent(tPage.legendLabel,"Legend");

        Assert.assertTrue(tPage.legendFont.getAttribute("value").contains("Arial"));

        Assert.assertTrue(tPage.legendFontSize.getAttribute("value").contains("4px"));

        // X Axis Label

        Assert.assertEquals(tPage.xAxisLabel.getText(),"X Axis Label:");

        Assert.assertTrue(tPage.xAxisLabelFont.getAttribute("value").contains("Arial"));

        Assert.assertTrue(tPage.xAxisLabelFontSize.getAttribute("value").contains("5px"));

        //X Axis Title

        Assert.assertEquals(tPage.xAxisTitleLabel.getText(),"X Axis Title:");

        Assert.assertTrue(tPage.xAxisTitleFont.getAttribute("value").contains("Arial"));

        Assert.assertTrue(tPage.xAxisTitleFontSize.getAttribute("value").contains("5px"));

        // Y Axis Label

        Assert.assertEquals(tPage.yAxisLabel.getText(),"Y Axis Label:");

        Assert.assertTrue(tPage.yAxisLabelFont.getAttribute("value").contains("Arial"));

        Assert.assertTrue(tPage.yAxisLabelFontSize.getAttribute("value").contains("5px"));

        //Y Axis Title

        Assert.assertEquals(tPage.yAxisTitleLabel.getText(),"Y Axis Title:");

        Assert.assertTrue(tPage.yAxisTitleFont.getAttribute("value").contains("Arial"));

        Assert.assertTrue(tPage.yAxisTitleFontSize.getAttribute("value").contains("5px"));

        //Line Chart Thickness

        Assert.assertEquals(tPage.lineChartThicknessLabel.getText(),"Line Chart Thickness:");

        Assert.assertTrue(tPage.lineChartThicknessSize.getAttribute("value").contains("2px"));

        //Marker Size

        Assert.assertEquals(tPage.markerLabel.getText(),"Marker Size:");

        Assert.assertTrue(tPage.markerSize.getAttribute("value").contains("1px"));

        //Show Bar Data Labels

        Assert.assertEquals(tPage.showBarDataLabels.getText(),"Show Data Labels:");

        //Assert.assertTrue(tPage.showBarDataCheck.getAttribute("value").contains("4px"));

        tPage.showBarDataCheck.isSelected(); //need to verify this


    }

    //To find the hidden text

    public void findAndVerifyContent(WebElement element,String label){

        String content = (String) ((JavascriptExecutor) Driver).executeScript("return arguments[0].innerHTML", element);
        System.out.println(content);

        Assert.assertEquals(content,label);

    }

    @Test(priority = 2)
    public void formatPageTitleSizeTest() throws InterruptedException, IOException {

        //Navigate to template builder
        //Delete the existing template
        //Create a template with custom settings
        //Download both the templates
        //Compare the file size
        // Expected: File size should be different

       // TemplateBuilderTest temp = new TemplateBuilderTest();

        temp.navigateToTemplateBuilder(); //Go to Template builder landing page

        try{

            tempUtility.deleteTemplate("SecondReport");
        }catch(Exception e){

            System.out.print("Template is not there to Delete");
        }

        String pageTitleFontSizeXpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlPageTitleFontSize_Input']";

        tempUtility.createCustomTemplate("Sample Factsheet Template","SecondReport",pageTitleFontSizeXpath,"20px"); // Create a custom tmeplate

        ut.searchPortfolioInReportsPage("Automated - Portfolio Search Test"); //Search and select the portfolio in reports page

        ut.downloadReportFromReportsPage("Sample Factsheet Template"); //Download the templates from reports page

        ut.downloadReportFromReportsPage("SecondReport");

        Thread.sleep(25000);

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY");
        Date date=new Date();

        String fName1 = "C:\\Users\\viswanath.STYLEDOMAIN\\Downloads\\Automated - Portfolio Search Test-MSCI AC EUROPE-EUR-20160531-Sample Factsheet Template.pdf";
        String fName2 = "C:\\Users\\viswanath.STYLEDOMAIN\\Downloads\\Automated - Portfolio Search Test-MSCI AC EUROPE-EUR-20160531-"+dateFormat.format(date)+" SecondReport.pdf";

        tempUtility.fileSizeComparisionForCustom(fName1,fName2);

    }



}
