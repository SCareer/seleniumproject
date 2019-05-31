package com.styleanalytics.enterprise.ExecutiveReports;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class DefaultTemplate extends TestBase {

    private ExecutiveReportsPage executiveReportsPage;

    private ExecReportHelpers EH;

    private WebDriver driver;


    @BeforeClass
    public void defaultTemplateSetup() throws IOException, InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();

        driver = getDriver();

        executiveReportsPage = new ExecutiveReportsPage(getDriver());

        EH = new ExecReportHelpers(getDriver());

        Thread.sleep(3000);

        //Utility.isElementPresentAndDisplayed("//span[contains(text(),'Dashboard')]",10);

        driver.findElement(By.xpath("//div[@class='reportTile execReportTile ui-sortable-handle']//div[@class='tileName'][contains(text(),'Default report')]")).click();


        // driver.findElement(By.xpath("//div[contains(text(),'Default report')]")).click();


    }

    @AfterMethod
    public void teardown(ITestResult reuslt) {

        Utility.tearDown(reuslt);
    }


    @Test(priority = 1)
    public void styleSkylineSummaryReportTitle() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        Wait.forGridToLoad(driver, 60);

        softAssert.assertEquals(executiveReportsPage.execReportStyleSkylineSummaryReportTitle.getText(), "STYLE SKYLINE" + "\u2122" + " SUMMARY");

        softAssert.assertEquals(driver.findElement(By.className("chartTitle")).getText(), "STYLE SKYLINE" + "\u2122" + " SUMMARY");

        softAssert.assertAll();

    }

    @Test(priority = 2)
    public void styleSummaryReportColumnHeaders() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(executiveReportsPage.execReportStyleSkylineSummaryBookToPrice.getText(), "Book to Price");

        softAssert.assertEquals(executiveReportsPage.execReportStyleSkylineSummaryDividendYield.getText(), "Dividend Yield");

        softAssert.assertEquals(executiveReportsPage.execReportStyleSkylineSummaryReturnonEquity.getText(), "Return on Equity");

        softAssert.assertEquals(executiveReportsPage.execReportStyleSkylineSummaryEarningsGrowth.getText(), "Earnings Growth");

        softAssert.assertEquals(executiveReportsPage.execReportStyleSkylineSummaryMarketCap.getText(), "Market Cap");

        softAssert.assertEquals(executiveReportsPage.execReportStyleSkylineSummaryDebtToEquity.getText(), "Debt to Equity");

        softAssert.assertAll();


    }

    @Test(priority = 3)
    public void styleSummaryReportDrillDown() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        EH.ExReportSearch("Demo - Premier Monthly Inc A Net Inc");

        EH.drillDownInslickGrid("ShowStyleExposureTiltHistoryPopup", 0);

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();
    }


    @Test(priority = 4)
    public void riskSummaryTitle() {

        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.execReportRiskPageNav.click();

        Wait.forGridToLoad(driver, 60);

        softAssert.assertEquals(executiveReportsPage.execReportRiskSummaryTitle.getText(), "RISK SUMMARY");

        softAssert.assertAll();

    }


    @Test(priority = 5)
    public void riskSummaryDrillDown() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        //EH.ExReportSearch("Demo - Premier Monthly Inc A Net Inc");

        EH.drillDownInslickGrid("ShowRiskTiltHistoryPopup", 0);

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();

    }


    @Test(priority = 6)
    public void styleExposureTiltRange() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.execReportRiskRangeTiltPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        //Utility.waitForPageToBeReady();

        // Utility.waitForElementToDisplay(executiveReportsPage.execReportStyleExposureTiltRangeTitle, 20);

        softAssert.assertEquals(executiveReportsPage.execReportStyleExposureTiltRangeTitle.getText(), "STYLE EXPOSURE TILT RANGE");

        softAssert.assertAll();

    }


    @Test(priority = 7)
    public void styleExposureTiltRangeDrillDown() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        List<WebElement> chartList = driver.findElements(By.xpath("//*[contains(@id,'graph-id1-plotset-plot-1-node-0')]"));

        System.out.println(chartList.size());

        chartList.get(1).click();

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();


    }

    @Test(priority = 8)
    public void riskAverageTitles() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.execReportRiskAveragePageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> graphTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        System.out.println(graphTitle.size());

        softAssert.assertEquals(graphTitle.get(0).getText(), "RISK AVERAGES: EQUAL WEIGHT");

        softAssert.assertEquals(graphTitle.get(1).getText(), "TRACKING ERROR");

        softAssert.assertEquals(graphTitle.get(2).getText(), "RISK RANGE");

        softAssert.assertAll();


    }

    @Test(priority = 9)

    public void riskAveragesDrillDowns() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.execReportRiskAveragePageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> graphs = driver.findElements(By.xpath("//*[contains(@id,'chartDiv-graph-id0-plotset-plot-0-node-0-path')]"));

        System.out.println(graphs.size());

        graphs.get(1).click();

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();


    }

    //page 5
    @Test(priority = 10)
    public void portfolioChangesReport() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.execReportPortfolioChangesPageNav.click();

        Wait.forGridToLoad(driver, 60);

        softAssert.assertTrue(executiveReportsPage.execReportPortfolioChangesReportTitle.getText().contains("PORTFOLIO CHANGES"));

       // EH.ExReportSearch("Demo - Premier Monthly Inc A Net Inc");

        EH.drillDownInslickGrid("ShowStyleExposureTiltHistoryPopup", 0);

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();


    }

    //@Test(priority = 11)
    public void portfolioWeightReport() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.execReportPortfolioWeightPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> chartTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        softAssert.assertEquals(chartTitle.get(0).getText(), "EQUAL WEIGHT; PORTFOLIO WEIGHT");

        softAssert.assertEquals(chartTitle.get(1).getText(), "EQUAL WEIGHT; ACTIVE WEIGHT");

        /*EH.drillDownInslickGrid("showSecuritySummaryDrilldown", 0);

       Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        Driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        Driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();
*/
        softAssert.assertAll();


    }

    @Test(priority = 11)
    public void liquidityRangeTitles() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.execReportPortfolioLiquidityRangePageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> chartTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        softAssert.assertEquals(chartTitle.get(0).getText(), "LIQUIDITY RANGE");

        softAssert.assertEquals(chartTitle.get(1).getText(), "LIQUIDITY SUMMARY");

        softAssert.assertAll();


    }

    @Test(priority = 12)
    public void liquidityRangeDrillDowns() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        List<WebElement> charts = driver.findElements(By.xpath("//*[contains(@id,'chartDiv-graph-id0-plotset-plot-1-node-0')]"));

        charts.get(1).click();

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();
    }


    @Test(priority = 13)
    public void liquiditySummary() {


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(executiveReportsPage.execReportPortfolioLiquiditySummaryVisible.isDisplayed());

        softAssert.assertAll();

    }

    @Test(priority = 14)
    public void liquidityRangePageTitle() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.execReportPortfolioLiquidityRangeReportPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> chartTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        List<WebElement> subTitle = driver.findElements(By.xpath("//*[contains(@id,'tl00_labSubTitle')]"));

        softAssert.assertEquals(chartTitle.get(0).getText(), "LIQUIDITY RANGE");

        softAssert.assertEquals(subTitle.get(0).getText(), "TRADE TO CASH; DEFAULT LIQUIDTY VALUE ($100M)");

        softAssert.assertEquals(chartTitle.get(1).getText(), "LIQUIDITY RANGE");

        softAssert.assertEquals(subTitle.get(1).getText(), "TRADE TO BENCHMARK; DEFAULT LIQUIDTY VALUE ($100M)");

        softAssert.assertAll();

    }


    @Test(priority = 15)
    public void liquidityRangeTradeToCashDrillDowns() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> chartlist = driver.findElements(By.xpath("//*[contains(@id,'chartDiv-graph-id0-plotset-plot-1-node-0')]"));

        chartlist.get(1).click();

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();


    }


    @Test(priority = 15)
    public void liquidityRangeTradeToBenchmarkDrillDowns() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        List<WebElement> chartlist = driver.findElements(By.xpath("//*[contains(@id,'1001_chartDiv-graph-id0-plotset-plot-1-node-0')]"));

        chartlist.get(1).click();

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();


    }

    @Test(priority = 16)
    public void sectorPortfolioWeightTitle() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.execReportSectorPortfolioWeightPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> chartTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        softAssert.assertEquals(chartTitle.get(0).getText(), "SECTOR PORTFOLIO WEIGHT");

        softAssert.assertEquals(chartTitle.get(1).getText(), "SECTOR ACTIVE WEIGHT");

        softAssert.assertAll();

    }


    @Test(priority = 17)
    public void sectorPortfolioWeightDrillDown() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        List<WebElement> chartList = driver.findElements(By.xpath("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-1-node-0')]"));

        System.out.println(chartList.size());

        chartList.get(1).click();

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();

    }


    @Test(priority = 18)
    public void sectorActiveWeightDrillDown() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> chartList = driver.findElements(By.xpath("//*[contains(@id,'_1001_chartDiv-graph-id0-plotset-plot-1-node-0')]"));

        chartList.get(1).click();

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();


    }

    @Test(priority = 19)
    public void countryWeightsReportTitles() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.execReportCountryPortfolioWeightPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> chartTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        softAssert.assertEquals(chartTitle.get(0).getText(), "COUNTRY PORTFOLIO WEIGHT");

        softAssert.assertEquals(chartTitle.get(1).getText(), "COUNTRY ACTIVE WEIGHT");

        softAssert.assertAll();


    }


    @Test(priority = 20)
    public void countryPortfolioWeightDrillDown() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> chartList = driver.findElements(By.xpath("//*[contains(@id,'_1000_chartDiv-graph-id0-plotset-plot-0-node-9')]"));

        System.out.println(chartList.size());

        chartList.get(1).click();

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();

    }


    @Test(priority = 21)
    public void countryActiveWeightDrillDown() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> chartList = driver.findElements(By.xpath("//*[contains(@id,'_1001_chartDiv-graph-id0-plotset-plot-0-node-9')]"));

        chartList.get(1).click();

        Thread.sleep(5000);

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();


    }


    @Test(priority = 22)
    public void distributionReportTitles() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.execReportDistributionPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> chartTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        softAssert.assertEquals(chartTitle.get(0).getText(), "SIZE DISTRIBUTION");

        softAssert.assertEquals(chartTitle.get(1).getText(), "STYLE DISTRIBUTION");

        softAssert.assertAll();


    }


    @Test(priority = 23)
    public void sizeDistributionDrillDown() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> chartList = driver.findElements(By.xpath("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-1-node-0')]"));

        System.out.println(chartList.size());

        chartList.get(1).click();

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();

    }


    @Test(priority = 24)
    public void styleDistributionDrillDown() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> chartList = driver.findElements(By.xpath("//*[contains(@id,'_1001_chartDiv-graph-id0-plotset-plot-1-node-0')]"));

        chartList.get(1).click();

        Wait.waitForElementToDisplay(driver, executiveReportsPage.popupClose_btn, 10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();


    }


}














