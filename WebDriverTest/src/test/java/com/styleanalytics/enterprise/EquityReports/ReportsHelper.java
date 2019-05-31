package com.styleanalytics.enterprise.EquityReports;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.Utility;

import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class ReportsHelper extends TestBase{

     WebDriver driver;

    public ReportsHelper(WebDriver driver){
        this.driver = driver;
    }

    public void verifyTitle(int reportSection, int order, String expected, SoftAssert softAssert) throws Exception {

        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement title = driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_ctl00_labTitle']"));
            jse.executeScript("arguments[0].scrollIntoView(true);", title);
            softAssert.assertEquals(title.getText(), expected);
        }catch (Exception e){
            throw new Exception("Can't verify the report title :"+expected);
        }

    }

    public void isReportDisplayed(int reportSection, int order) throws Exception {

        String part11 = "//img[contains(@id,'_chartDiv-img') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order;
        String part22 = "_panContainer')]";
        try {
            driver.findElement(By.xpath(part11 + part22)).isDisplayed();
        }catch (Exception e){
             new Exception("Report not Displayed ").getStackTrace()[1].getMethodName();
        }

    }

    public void openDrillDowns(int reportSection, int order) throws Exception {

        String part0 = "//area[contains(@id,'chartDiv-graph-id0-plotset-plot-0-node-";
        String part1 = "//area[contains(@id,'chartDiv-graph-id1-plotset-plot-0-node-";
        String part2 = "') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]";

        int count = 0;

        turnOffImplicitWaits(driver);

        try {
            driver.findElement(By.xpath(part1 + 1 + part2)).click();
            //driver.findElement(By.xpath(part0 + 0 + part2)).click();

        } catch (Exception e) {

            count++;
        }
        try {
            if (count == 1) {

                //driver.findElement(By.xpath(part0 + 1 + part2)).click();
                driver.findElement(By.xpath(part0 + 0 + part2)).click();
            }

        } catch (Exception e) {

            count++;
        }

        try {
            if (count == 2) {

                driver.findElement(By.xpath(part0 + 1 + part2)).click();
            }

        } catch (Exception e1) {


            count++;
        }

        if (count == 3) {
            throw new Exception("Can't find the element to drilldown");

        }
        turnOnImplicitWaits(driver);

    }

    public void verifyContentsInDrillDown(String element, String verifyText, SoftAssert softAssert) throws Exception {

        try {
            driver.switchTo().frame(0);
            Utility.isElementPresent(element, 3);
            WebElement stilt = driver.findElement(By.xpath(element));
            String actual = stilt.getText();
            softAssert.assertEquals(actual, verifyText);
            closePopup();
        }catch (Exception e){
            throw new Exception("Failed to verifyContentsInDrillDown");
        }

    }



    public void verifyContentsInFormDrillDown(String element, String verifyText, SoftAssert softAssert) throws Exception {
        try {
            driver.switchTo().frame(0);
            Utility.isElementPresent(element, 3);
            WebElement stilt = driver.findElement(By.xpath(element));
            String actual = stilt.getText();
            softAssert.assertEquals(actual, verifyText);
            closePopup();
        }catch (Exception e){
            throw new Exception("Failed to verifyContentsInFormDrillDown");
        }

        }

    public void verifyChartInDrillDown() throws Exception {

        try {
            driver.switchTo().frame(0);
            driver.findElement(By.className("zingChartWidget")).isDisplayed();
            closePopup();
        }catch (Exception e){
            throw new Exception("Failed to verifyChartInDrillDown");
        }

    }

    public void verifySecuritylListDrillDown() throws Exception {

        try {
            driver.switchTo().frame(0);
            Thread.sleep(4000);
            driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl00_labTitle")).isDisplayed();
            closePopup();
        }catch (Exception e){
            throw new Exception("Failed to verifySecuritylListDrillDown");
        }

    }

    public void subFundGalleryTitle(WebElement elemenet, String Title, SoftAssert softAssert) {

        softAssert.assertEquals(elemenet.getText(), Title);
    }


    public void isGridDisplayed(int reportSection, int order) throws Exception {
        try {
            String part22 = "_panContainer')]";
            String part33 = "//div[contains(@id,'_html') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order;
            driver.findElement(By.xpath(part33 + part22)).isDisplayed();
        }catch (Exception e){
            throw new Exception("Failed to Display Grid");
        }

    }
    public void getGridData(int reportSection, int order) {

        String tableXpath1 = "//div[contains(@id,'_html') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order+"_panContainer')]";
        String tableXpath2 = "/div[4]/table";

        String tableRowXpath1 = "/div[4]/table/tbody/tr[2]/td";
         // Grab the table
        WebElement table = driver.findElement(By.xpath(tableXpath1+tableXpath2));

        //Get number of rows in table
        int numOfRow = table.findElements(By.tagName("tr")).size();

        System.out.println(numOfRow);

       //Get number of columns In table.
        int numOfCol = driver.findElements(By.xpath(tableXpath1+tableRowXpath1)).size();

        System.out.println(numOfCol);

        //divided Xpath In three parts to pass Row_count and Col_count values.
        String first_part = "/div[4]/table/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        //take the second column values
        int j=2;

        //List to store the second column
        List<String> secondColumnList=new ArrayList<String>();

        //Loop through the rows and get the second column and put it in a list

        for (int i=1; i<=numOfRow; i++) {

            if (i == 8 || i == 9 || i == 12 || i == 13 || i == 14) continue;

            //Prepared final xpath of specific cell as per values of i and j.
            String final_xpath = tableXpath1 + first_part + i + second_part + j + third_part;
            //Will retrieve value from located cell and print It.
            String test_name = driver.findElement(By.xpath(final_xpath)).getText();
            secondColumnList.add(test_name);
            System.out.println(test_name);
            Xls_Reader reader = new Xls_Reader("C:\\Selenium\\Build Outputs\\Json Expected\\Excel Worksheet.xlsx");
            reader.setCellData("Risk","Risk Estimates",i+1,test_name);

        }
    }

    public void isLabsReportDisplayed(int reportSection, int orderOfReport) {

        String part11 = "//div[contains(@id,'_chartDiv') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + orderOfReport;
        String part22 = "')]";
        driver.findElement(By.xpath(part11 + part22)).isDisplayed();
    }

    public void isReportDisplayed1(int reportSection, int order) throws InterruptedException {

        String part11 = "//img[contains(@id,'_chartDiv-img') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order;
        String part22 = "')]";
        driver.findElement(By.xpath(part11 + part22)).isDisplayed();

        }


    public void verifyTitle1(int reportSection, int order, String expected, SoftAssert softAssert) throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement title = driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl0" + reportSection + "_ctl0" + order + "_labTitle']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", title);
        softAssert.assertEquals(title.getText(), expected);
        Thread.sleep(2000);
    }

    public void verifyHeatMapDisplayed(String heatMapName) {

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap\"]")).isDisplayed();

    }

    public void verifyHeatmapDisplayed() {

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap\"]")).isDisplayed();

    }


    public void verifyGridInDrillDown() throws Exception {

        try {
            driver.switchTo().frame(0);
            driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ctl00_labTitle\"]")).isDisplayed();
            closePopup();
        }catch (Exception e){
            throw new Exception("Failed; verifyGridInDrillDown");
        }


    }

    public void verifyTop10SecurityDrillDown() throws Exception {
        try {
            driver.switchTo().frame(0);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[3]/div[1]")).isDisplayed();
            closePopup();
        }catch (Exception e){
            throw new Exception("Failed verifyTop10SecurityDrillDown");
        }


    }

    public void closePopup() throws Exception {
        driver.switchTo().defaultContent();
        int count = 0;
        try {
            driver.findElement(By.xpath("//a[@title='Close']")).click();
        } catch (Exception e) {
            count++;

        }
        try {
            if (count == 1)
                driver.findElement(By.className("rwCloseButton")).click();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Can't close popup");
        }

    }

    public void findAllChartsInPage(int expectedNumberOfReports, SoftAssert softAssert) throws Exception {

        List<WebElement> title = driver.findElements(By.className("chartTitle"));

        if (title.size() < expectedNumberOfReports) {
            throw new Exception("Failed to Find findAllChartsInPage");
        }
    }


    public void findAllReportsTitleInPage(int expectedNumberOfReportsTitles, SoftAssert softAssert) throws Exception {

        List<WebElement> title = driver.findElements(By.className("chartTitle"));

        if (title.size() < expectedNumberOfReportsTitles) {

           throw new Exception(" Failed to find findAllReportsTitleInPage");
        }
    }



}


