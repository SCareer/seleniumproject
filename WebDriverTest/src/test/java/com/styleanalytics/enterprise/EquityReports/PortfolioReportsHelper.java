package com.styleanalytics.enterprise.EquityReports;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class PortfolioReportsHelper extends EnterpriseBaseClass {

    public static void verifyTitle(int reportSection, int order, String expected,SoftAssert softAssert) {

        JavascriptExecutor jse = (JavascriptExecutor) Driver;
        WebElement title = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_ctl00_labTitle']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", title);
        softAssert.assertEquals(title.getText(), expected);

    }

    public static void isReportDisplayed(int reportSection, int order) {

        String part11 = "//img[contains(@id,'_chartDiv-img') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order;
        String part22 = "_panContainer')]";
        Driver.findElement(By.xpath(part11 + part22)).isDisplayed();

    }

    public static void openDrillDowns(int reportSection, int order) {

        String part0 = "//area[contains(@id,'chartDiv-graph-id0-plotset-plot-0-node-";
        String part1 = "//area[contains(@id,'chartDiv-graph-id1-plotset-plot-0-node-";
        String part2 = "') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]";

        int count = 0;

        turnOffImplicitWaits();

        try {
            Driver.findElement(By.xpath(part1 + 1 + part2)).click();
            //Driver.findElement(By.xpath(part0 + 0 + part2)).click();

        } catch (Exception e) {

            count++;
        }
        try {
            if (count == 1) {

                //Driver.findElement(By.xpath(part0 + 1 + part2)).click();
                Driver.findElement(By.xpath(part0 + 0 + part2)).click();
            }

        } catch (Exception e) {

            count++;
        }

        try {
            if (count == 2) {

                Driver.findElement(By.xpath(part0 + 1 + part2)).click();
            }

        } catch (Exception e1) {


            count++;
        }

        if (count == 3) {

            System.out.println("Can't find the element to drilldown");

        }

        turnOnImplicitWaits();

    }

    public static void verifyContentsInDrillDown(String element, String verifyText,SoftAssert softAssert) {

        Driver.switchTo().frame(0);
        Utility.isElementPresent(element, 3);
        WebElement stilt = Driver.findElement(By.xpath(element));
        String actual = stilt.getText();
        softAssert.assertEquals(actual, verifyText);

        closePopup();



    }


    public static void goToSeSummary() throws InterruptedException {

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_panChapters\"]/div[2]")).click();
        Thread.sleep(2000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl00_rptChapterSubPages_ctl00_hlPage\"]")).click();
        Thread.sleep(3000);


    }

    public static void verifyContentsInFormDrillDown(String element, String verifyText, SoftAssert softAssert) throws InterruptedException {


        Driver.switchTo().frame(0);
        Utility.isElementPresent(element, 3);
        WebElement stilt = Driver.findElement(By.xpath(element));
        String actual = stilt.getText();
        softAssert.assertEquals(actual, verifyText);
        closePopup();






    }

    public static void verifyChartInDrillDown() {


        Driver.switchTo().frame(0);
        Driver.findElement(By.className("zingChartWidget")).isDisplayed();

        closePopup();


    }

    public static void verifySecuritylListDrillDown() throws InterruptedException {


        Driver.switchTo().frame(0);
        Thread.sleep(4000);
        Driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl00_labTitle")).isDisplayed();

        closePopup();

            //gljhjklgj


    }

    public static void subFundGalleryTitle(WebElement elemenet, String Title,SoftAssert softAssert) {

        softAssert.assertEquals(elemenet.getText(), Title);
    }


    public static void isGridDisplayed(int reportSection, int order) {

        String part22 = "_panContainer')]";
        String part33 = "//div[contains(@id,'_html') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order;


        Driver.findElement(By.xpath(part33 + part22)).isDisplayed();

    }

    public static void isLabsReportDisplayed(int reportSection, int orderOfReport){


        String part11 = "//div[contains(@id,'_chartDiv') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + orderOfReport;
        String part22 = "')]";
        Driver.findElement(By.xpath(part11 + part22)).isDisplayed();
    }

    public static void isReportDisplayed1(int reportSection, int order) throws InterruptedException {

        String part11 = "//img[contains(@id,'_chartDiv-img') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order;
        String part22 = "')]";
        Driver.findElement(By.xpath(part11 + part22)).isDisplayed();


    }


    public static void verifyTitle1(int reportSection, int order, String expected,SoftAssert softAssert) throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) Driver;
        WebElement title = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl0" + reportSection + "_ctl0" + order + "_labTitle']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", title);
        softAssert.assertEquals(title.getText(), expected);
        Thread.sleep(2000);
    }

    public static void verifyHeatMapDisplayed(String heatMapName) {


        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap\"]")).isDisplayed();

    }

    public static void verifyHeatmapDisplayed() {


        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap\"]")).isDisplayed();

    }


    public static void verifyGridInDrillDown() throws InterruptedException {


        Driver.switchTo().frame(0);

        // Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[3]/table/tbody")).isDisplayed();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ctl00_labTitle\"]")).isDisplayed();


        closePopup();


    }

    public static void verifyTop10SecurityDrillDown() throws InterruptedException {


        Driver.switchTo().frame(0);
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[3]/div[1]")).isDisplayed();

        closePopup();


    }

    public static void closePopup() {

        Driver.switchTo().defaultContent();
        int count = 0;
        try {
            Driver.findElement(By.xpath("//a[@title='Close']")).click();
        } catch (Exception e) {
            count++;

        }
        try {
            if (count == 1)
                Driver.findElement(By.className("rwCloseButton")).click();

        } catch (Exception e) {
            System.out.println("Can't close popup in Second attempt");

        }

//*[@id="RadWindowWrapper_ctl00_mainContentPlaceHolder_report_RadWindowManager11537446092951"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li/a
    }

    public static void findAllChartsInPage(int expectedNumberOfReports,SoftAssert softAssert) {

        List<WebElement> title = Driver.findElements(By.className("chartTitle"));

        System.out.println(title.size());

        if (title.size() < expectedNumberOfReports) {

            System.out.print("All the trails Reports are not Displayed");
            softAssert.fail();
        } else {
            System.out.print("All the trails Reports are  are Displayed");

        }
    }


    public static void findAllReportsTitleInPage(int expectedNumberOfReportsTitles,SoftAssert softAssert) {

        List<WebElement> title = Driver.findElements(By.className("chartTitle"));

        System.out.println(title.size());

        if (title.size() < expectedNumberOfReportsTitles) {

            System.out.print("All the trails Reports are not Displayed");
            softAssert.fail();
        } else {
            System.out.print("All the trails Reports are  are Displayed");

        }
    }


    public static void accessReport(WebElement mainSection, WebElement reportMenu, int waitForReportInSeconds) throws InterruptedException {

        try {
            Driver.switchTo().defaultContent();

            Actions actions = new Actions(Driver);
            actions.moveToElement(mainSection).build().perform();
            //mainSection.click();
            Utility.waitForElementToDisplay(reportMenu, 3);
            reportMenu.click();
            Utility.waitForReportsToLoad(waitForReportInSeconds);
        }catch (Exception e){
            System.out.println("Error in Accessing the Report: "+e);
            //mainSection.click();
            Driver.navigate().refresh();
            Actions actions = new Actions(Driver);
            actions.moveToElement(mainSection).build().perform();
            Utility.waitForElementToDisplay(reportMenu, 3);
            reportMenu.click();
            Utility.waitForReportsToLoad(waitForReportInSeconds);
        }

    }


    public static void accessReport(WebElement mainSection, WebElement reportMenu) throws InterruptedException {

        try {
            Driver.switchTo().defaultContent();

            Actions actions = new Actions(Driver);
            actions.moveToElement(mainSection).build().perform();
            Utility.waitForElementToDisplay(reportMenu, 3);
            reportMenu.click();

        }catch (Exception e){
            System.out.println("Error in Accessing the Report: "+e);
            //mainSection.click();
            Driver.navigate().refresh();
            Actions actions = new Actions(Driver);
            actions.moveToElement(mainSection).build().perform();
            Utility.waitForElementToDisplay(reportMenu, 3);
            reportMenu.click();

        }

    }

}
