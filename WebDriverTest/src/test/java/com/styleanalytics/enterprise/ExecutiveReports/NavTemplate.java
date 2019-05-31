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

public class NavTemplate extends TestBase {

    WebDriver driver;
    ExecutiveReportsPage executiveReportsPage;
    ExecReportHelpers EH;
    @BeforeClass
    public void openExecutiveReports() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
        driver = getDriver();
        executiveReportsPage = new ExecutiveReportsPage(getDriver());
        EH = new ExecReportHelpers(getDriver());

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='reportTile execReportTile ui-sortable-handle']//div[@class='tileName'][contains(text(),'Nav Report')]")).click();

       // Utility.isElementPresentAndDisplayed("//span[contains(text(),'Dashboard')]", 10);

        //driver.findElement(By.xpath("//span[contains(text(),'Nav Report')]")).click();

    }

    @AfterMethod
    public void teardown(ITestResult reuslt) {

        Utility.tearDown(reuslt);
    }


    @Test(priority = 1)
    public void styleExposurePageTitle() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.navTemplateStyleExposurePageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> chartTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        List<WebElement> subTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labSubTitle')]"));

        softAssert.assertEquals(chartTitle.get(0).getText(), "STYLE EXPOSURE AVERAGES");

        softAssert.assertEquals(subTitle.get(0).getText(), "Equal Weight ; Unadjusted ; Portfolio Count: 51");

        softAssert.assertEquals(chartTitle.get(1).getText(), "STYLE EXPOSURE AVERAGES");

        softAssert.assertEquals(subTitle.get(1).getText(), "NAV Weight ; Unadjusted ; Portfolio Count: 43");

        softAssert.assertAll();

    }


    @Test(priority = 2)
    public void styleExposureDrillDown() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.navTemplateStyleExposurePageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> chartList = driver.findElements(By.xpath("//*[contains(@id,'_1000_chartDiv-graph-id1-plotset-plot-0-node-0')]"));

        System.out.println(chartList.size());

        Thread.sleep(3000);

        chartList.get(1).click();

        Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();


    }

    @Test(priority = 3)
    public void styleExposureDrillDown2ndGraph() throws InterruptedException {

        DrillDownTest("//*[contains(@id,'1001_chartDiv-graph-id1-plotset-plot-0-node-0')]", "//div[@id='pagination']//a[1]", 1);

    }


    public void DrillDownTest(String XpathFindElements , String xpathPageNav , int i) throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.xpath(xpathPageNav)).click();

        Thread.sleep(5000);

        List<WebElement>  chartList= driver.findElements(By.xpath(XpathFindElements));

        System.out.println(chartList.size());

        chartList.get(i).click();

        Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        driver.switchTo().frame(0);

        Thread.sleep(3000);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();
    }


    @Test(priority = 4)
    public void riskAverageTitle() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.navReportRiskAveragePageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> graphTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        System.out.println(graphTitle.size());

        softAssert.assertEquals(graphTitle.get(0).getText(), "RISK AVERAGES: EQUAL WEIGHT");

        softAssert.assertEquals(graphTitle.get(1).getText(), "RISK AVERAGES: NAV WEIGHT");

        softAssert.assertAll();


    }


    @Test(priority = 5)
    public void riskAverageEqualWeightDrillDown() throws InterruptedException {


        DrillDownTest("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-0-node-1')]", "//div[@id='pagination']//a[2]", 1);

    }


    @Test(priority = 6)
    public void riskAverageActiveWeightDrillDown() throws InterruptedException {


        DrillDownTest("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-0-node-2')]", "//div[@id='pagination']//a[2]", 1);

    }

    @Test(priority = 7)
    public void sectorWeightTitle() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.navReportSectorWeightPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> graphTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        System.out.println(graphTitle.size());

        softAssert.assertEquals(graphTitle.get(0).getText(), "SECTOR ACTIVE WEIGHT");

        softAssert.assertEquals(graphTitle.get(1).getText(), "SECTOR ACTIVE WEIGHT");

        softAssert.assertAll();


    }


    @Test(priority = 8)
    public void sectorActiveWeightDrillDown() throws InterruptedException {


        DrillDownTest("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-0-node-0')]", "//div[@id='pagination']//a[3]", 1);

    }


    @Test(priority = 9)
    public void sectorActiveWeight2ndGraphDrillDown() throws InterruptedException {



        DrillDownTest("//*[contains(@id,'1001_chartDiv-graph-id0-plotset-plot-0-node-0')]", "//div[@id='pagination']//a[3]", 1);

    }


    @Test(priority = 10)
    public void countryWeightTitle() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.navReportCountryWeightPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> graphTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        System.out.println(graphTitle.size());

        softAssert.assertEquals(graphTitle.get(0).getText(), "COUNTRY ACTIVE WEIGHT");

        softAssert.assertEquals(graphTitle.get(1).getText(), "COUNTRY ACTIVE WEIGHT");

        softAssert.assertAll();


    }


    @Test(priority = 11)
    public void countryActiveWeightDrillDown() throws InterruptedException {


        DrillDownTest("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-0-node-0')]", "//div[@id='pagination']//a[4]", 1);

    }


    @Test(priority = 12)
    public void countryActiveWeight2ndGraphDrillDown() throws InterruptedException {


        DrillDownTest("//*[contains(@id,'1001_chartDiv-graph-id0-plotset-plot-0-node-0')]", "//div[@id='pagination']//a[4]", 1);

    }


    @Test(priority = 13)
    public void sizeDistributionTitle() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.navReportDistributionPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> graphTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        System.out.println(graphTitle.size());

        softAssert.assertEquals(graphTitle.get(0).getText(), "SIZE DISTRIBUTION");

        softAssert.assertEquals(graphTitle.get(1).getText(), "SIZE DISTRIBUTION");

        softAssert.assertAll();


    }


    @Test(priority = 14)
    public void sizeDistributionDrillDown() throws InterruptedException {


        DrillDownTest("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-0-node-0')]", "//div[@id='pagination']//a[5]", 1);

    }


    @Test(priority = 15)
    public void sizeDistributionDrillDown2ndGraph() throws InterruptedException {


        DrillDownTest("//*[contains(@id,'1001_chartDiv-graph-id0-plotset-plot-0-node-0')]", "//div[@id='pagination']//a[5]", 1);

    }

    @Test(priority = 16)
    public void styleDistributionTitle() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.navReportStyleDistributionPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> graphTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        System.out.println(graphTitle.size());

        softAssert.assertEquals(graphTitle.get(0).getText(), "STYLE DISTRIBUTION");

        softAssert.assertEquals(graphTitle.get(1).getText(), "STYLE DISTRIBUTION");

        softAssert.assertAll();


    }


    @Test(priority = 17)
    public void styleDistributionDrillDown() throws InterruptedException {

        DrillDownTest("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-0-node-0')]", "//div[@id='pagination']//a[6]", 1);

    }


    @Test(priority = 18)
    public void styleDistributionDrillDown2ndGraph() throws InterruptedException {

        DrillDownTest("//*[contains(@id,'1001_chartDiv-graph-id0-plotset-plot-0-node-0')]", "//div[@id='pagination']//a[6]", 1);

    }


    @Test(priority = 19)
    public void liquidity() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.navReportLiquidityPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        List<WebElement> graphTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        List<WebElement> graphList = driver.findElements(By.xpath("//img[contains(@id,'_1000_chartDiv-img')]"));

        softAssert.assertEquals(graphTitle.get(0).getText(), "LIQUIDITY AVERAGES");

        softAssert.assertEquals(graphTitle.get(1).getText(), "LIQUIDITY AVERAGES");

        softAssert.assertAll();

    }

    @Test(priority = 20)
    public void weightReportTitle() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.navReporWeightPageNav.click();

        Wait.forGridToLoad(driver, 60);

        List<WebElement> graphTitle = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        System.out.println(graphTitle.size());

        softAssert.assertEquals(graphTitle.get(0).getText(), "EQUAL WEIGHT; PORTFOLIO WEIGHT");

        softAssert.assertEquals(graphTitle.get(1).getText(), "EQUAL WEIGHT; ACTIVE WEIGHT");

        softAssert.assertEquals(graphTitle.get(2).getText(), "NAV WEIGHT; PORTFOLIO WEIGHT");

        softAssert.assertEquals(graphTitle.get(3).getText(), "NAV WEIGHT; ACTIVE WEIGHT");

        softAssert.assertAll();

    }

    // @Test
    public void navReportWeightReportDrilldown() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.navReporWeightPageNav.click();

        Wait.waitForSpinnerToDisappear(driver, 60);

        EH.drillDownInslickGrid("showSecuritySummaryDrilldown", 0);

        Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        Thread.sleep(5000);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.execReportPopVerify.isDisplayed());

        driver.switchTo().defaultContent();

        executiveReportsPage.execReportPopUpcloseButton.click();

        softAssert.assertAll();

    }


}



