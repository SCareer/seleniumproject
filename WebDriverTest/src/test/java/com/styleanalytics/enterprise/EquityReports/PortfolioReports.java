package com.styleanalytics.enterprise.EquityReports;

import com.styleanalytics.enterprise.DataDriven.DataDrivenSetup;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.enterprise.automation.JsonCompare;
import com.styleanalytics.pages.PortfolioReportsPage;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class PortfolioReports extends TestBase {

    String portfolioName;
    SoftAssert softAssert;
    WebDriver driver;
    Setup setup;
    LoginPage loginPage;
    PortfolioReportsPage reportsPage;
    ReportsHelper reportsHelper;
    private int reportSectionZero = 0;
    private int reportOrderZero = 0;
    private int reportSectionOne = 1;
    private int reportOrderOne = 1;
    private int reportSectionTwo = 2;
    private int reportOrderTwo = 2;
    private int reportOrderThree = 3;
    private int reportSectionThree = 3;
    private int reportOrderFour = 4;

    @Factory(dataProvider = "data")
    public PortfolioReports(String portfolioName) {

        this.portfolioName = portfolioName;

    }

    @DataProvider
    public static Object[][] data() throws IOException {

        String testDataFile = Setup.property("TestData");

        Object[][] arrayObject = DataDrivenSetup.readFromExcel(testDataFile, "PortfolioReports");

        return arrayObject;
    }


    @BeforeClass
    public void PortfolioReportsTest() throws Exception {

        softAssert = new SoftAssert();
        loginPage = new LoginPage(getDriver());

        String user = setup.property("ExistingReportsTestUser");
        String pass = setup.property("ExistingReportsTestUserPass");

        loginPage.login(user, pass);

        reportsPage = new PortfolioReportsPage(getDriver());

        reportsHelper = new ReportsHelper(getDriver());

        String url = setup.property("URL");
        reportsPage.goToReportsPage(url);

        driver = getDriver();

    }

    @Test
    public void portfolioWebReports() throws Exception {

        //Thread.sleep(180000);

        reportsPage.selectPortfolio(portfolioName);
        //reportsPage.selectSnapshot("30 Apr 2016");

        System.out.println("Scenario Started: " + portfolioName);
        softAssert.assertTrue(overviewSE(), "overviewSE");
        softAssert.assertTrue(overviewRegionDistribution(), "overviewRegionDistribution");
        softAssert.assertTrue(overviewSectorDistribution(), "overviewSectorDistribution");
        softAssert.assertTrue(overviewStyleDistribution(), "overviewStyleDistribution");
        softAssert.assertTrue(overviewSizeDistribution(), "overviewSizeDistribution");
        softAssert.assertTrue(overviewRiskEstimates(), "overviewRiskEstimates");
        softAssert.assertTrue(overviewRiskAttribution(), "overviewRiskAttribution");
        softAssert.assertTrue(overviewTop10Risk(), "overviewTop10Risk");
        softAssert.assertTrue(overviewContributionToRisk(), "overviewContributionToRisk");
        softAssert.assertTrue(overviewLiquidity(), "overviewLiquidity");
        softAssert.assertTrue(summarySEUA(), "summarySEUA");
        softAssert.assertTrue(summarySESA(), "summarySESA");
        softAssert.assertTrue(summarySECA(), "summarySECA");
        softAssert.assertTrue(summarySESACA(), "summarySESACA");
        softAssert.assertTrue(seRegionSkyline(), "seRegionSkyline");
        softAssert.assertTrue(seSectorSkyline(), "seSectorSkyline");
        softAssert.assertTrue(seCountrySkyline(), "seCountrySkyline");
        softAssert.assertTrue(seHistoryRange(), "seHistoryRange");
        softAssert.assertTrue(seHistoryTrails(), "seHistoryTrails");
        softAssert.assertTrue(seTiltHeatMap(), "seTiltHeatMap");
        softAssert.assertTrue(seFactorDataValue(), "seFactorDataValue");
        softAssert.assertTrue(regionDistOverview(), "regionDistOverview");
        softAssert.assertTrue(regionDistRange(), "regionDistRange");
        softAssert.assertTrue(regionDistHistory(), "regionDistHistory");
        softAssert.assertTrue(sectorOverview(), "sectorOverview");
        softAssert.assertTrue(sectorRange(), "sectorRange");
        softAssert.assertTrue(sectorHistory(), "sectorHistory");
        softAssert.assertTrue(countryOverview(), "countryOverview");
        softAssert.assertTrue(countryRange(), "countryRange");
        softAssert.assertTrue(countryHistory(), "countryHistory");
        softAssert.assertTrue(sizeOverview(), "sizeOverview");
        softAssert.assertTrue(sizeRange(), "sizeRange");
        softAssert.assertTrue(sizeHistory(), "sizeHistory");
        softAssert.assertTrue(styleOverview(), "styleOverview");
        softAssert.assertTrue(styleRange(), "styleRange");
        softAssert.assertTrue(styleHistory(), "styleHistory");
        softAssert.assertTrue(distributionHeatMap(), "distributionHeatMap");
        softAssert.assertTrue(sectorHeatMap(), "sectorHeatMap");
        softAssert.assertTrue(countryHeatmap(), "countryHeatmap");
        softAssert.assertTrue(riskOverview(), "riskOverview");
        softAssert.assertTrue(sectorBreakdown(), "sectorBreakdown");
        softAssert.assertTrue(riskPersistence(), "riskPersistence");
        softAssert.assertTrue(riskRange(), "riskRange");
        softAssert.assertTrue(riskAttribution(), "riskAttribution");
        softAssert.assertTrue(riskOtherTrails(), "riskOtherTrails");
        softAssert.assertTrue(riskBySecurities(), "riskBySecurities");
        softAssert.assertTrue(riskDecompositionByGroup(), "riskDecompositionByGroup");
        softAssert.assertTrue(riskSummary(), "riskSummary");
        softAssert.assertTrue(riskSubFundStat(), "riskSubFundStat");
        softAssert.assertTrue(riskNumberOfDifferentStocks(), "riskNumberOfDifferentStocks");
        softAssert.assertTrue(liquiditySummary(), "liquiditySummary");
        softAssert.assertTrue(liquidityHistory(), "liquidityHistory");
        softAssert.assertTrue(liquiditySecurityDetails(), "liquiditySecurityDetails");
        softAssert.assertTrue(performanceSummary(), "performanceSummary");
        softAssert.assertTrue(performanceByMarket(), "performanceByMarket");
        softAssert.assertTrue(performanceBySector(), "performanceBySector");
        softAssert.assertTrue(performanceByStyle(), "performanceByStyle");
        softAssert.assertTrue(performanceByHierarchy(), "performanceByHierarchy");
        softAssert.assertTrue(fofPerformance(), "fofPerformance");
        softAssert.assertTrue(fofPerformanceDetails(), "fofPerformanceDetails");
        softAssert.assertTrue(styleMinePerformance(), "styleMinePerformance");

        softAssert.assertTrue(subFundGallerySE(), "subFundGallerySE");
        softAssert.assertTrue(subFundGalleryRisk(), "subFundGalleryRisk");
        softAssert.assertTrue(subFundGalleryRiskOther(), "subFundGalleryRiskOther");
        softAssert.assertTrue(subFundGalleryRegion(), "subFundGalleryRegion");
        softAssert.assertTrue(subFundGallerySector(), "subFundGallerySector");
        softAssert.assertTrue(subFundGallerySize(), "subFundGallerySize");
        softAssert.assertTrue(subFundGalleryStyle(), "subFundGalleryStyle");
        softAssert.assertTrue(subFundGalleryFOFWeight(), "subFundGalleryFOFWeight");
        softAssert.assertTrue(labsStyleScatter(), "labsStyleScatter");
        softAssert.assertTrue(labsXYSnailTrails(), "labsXYSnailTrails");
        softAssert.assertAll();
        System.out.println("Scenario Completed: " + portfolioName);

    }

    private Boolean overviewSE() throws IOException {

        try {

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "PORTFOLIO STYLE SKYLINE" + "\u2122", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            //JsonCompare.jsonDownload(reportSectionZero,reportOrderZero,"overviewSE",getDriver());

            //JsonCompare.getJsonFromChart(reportSectionZero,reportOrderZero,"overviewSE",portfolioName,driver);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            String element = "//*[@id=\"ctl00_mainContentPlaceHolder_lblAdjustmentType\"]";

            reportsHelper.verifyContentsInDrillDown(element, "Standard Tilt:", softAssert);
            return true;

        } catch (Exception e) {

            System.out.println("overviewSE :" + e);
            takeScreenShotOnFailure("overviewSE");
            return false;
        }

    }

    private boolean overviewRegionDistribution() throws IOException {

        try {

            reportsHelper.verifyTitle(reportSectionZero, reportOrderOne, "REGION DISTRIBUTION", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderOne);

            //JsonCompare.jsonDownload(reportSectionZero,reportOrderOne,"overviewRegionDistribution");

            //JsonCompare.getJsonFromChart(reportSectionZero,reportOrderOne,"overviewRegionDistribution",portfolioName,driver);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderOne);

            //reportsHelper.verifyTitle(reportSection, orderOfReport, "COUNTRY DISTRIBUTION",softAssert);

            return true;

        } catch (Exception e) {
            System.out.println("overviewRegionDistribution :" + e);
            takeScreenShotOnFailure("overviewSE");
            return false;
        }

    }

    private boolean overviewSectorDistribution() throws IOException {

        try {

            reportsHelper.verifyTitle(reportSectionZero, reportOrderTwo, "SECTOR DISTRIBUTION", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderTwo);

            //JsonCompare.jsonDownload(reportSectionZero,reportOrderTwo,"overviewSectorDistribution");

            //JsonCompare.getJsonFromChart(reportSectionZero,reportOrderTwo,"overviewSectorDistribution",portfolioName,driver);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderTwo);

            String element = "//*[@id=\"aspnetForm\"]/div[3]/table/tbody/tr[1]/th[1]";

            reportsHelper.verifyContentsInDrillDown(element, "Security", softAssert);
            return true;

        } catch (Exception e) {

            System.out.println("overviewRegionDistribution :" + e);
            takeScreenShotOnFailure("overviewSE");

            return false;
        }

    }

    private Boolean overviewStyleDistribution() throws IOException {

        try {

            reportsHelper.verifyTitle(reportSectionZero, reportOrderThree, "STYLE DISTRIBUTION", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderThree);

            //JsonCompare.jsonDownload(reportSectionZero,reportOrderThree,"overviewStyleDistribution");

            //JsonCompare.getJsonFromChart(reportSectionZero,reportOrderThree,"overviewStyleDistribution",portfolioName,driver);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderThree);

            String element = "//*[@id=\"ctl00_mainContentPlaceHolder_ctl00_labTitle\"]";

            reportsHelper.verifyContentsInFormDrillDown(element, "STYLE DISTRIBUTION DETAILS", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("overviewRegionDistribution");
            return false;
        }

    }

    private boolean overviewSizeDistribution() throws IOException {

        try {

            reportsHelper.verifyTitle(reportSectionZero, reportOrderFour, "SIZE DISTRIBUTION", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderFour);

            // JsonCompare.jsonDownload(reportSectionZero,reportOrderFour,"overviewSizeDistribution");

            //JsonCompare.getJsonFromChart(reportSectionZero,reportOrderFour,"overviewSizeDistribution",portfolioName,driver);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderFour);

            String element = "//*[@id=\"ctl00_mainContentPlaceHolder_ctl00_labTitle\"]";

            //Verifying top 10 from the drill down
            reportsHelper.verifyContentsInFormDrillDown(element, "SIZE DISTRIBUTION DETAILS", softAssert);
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("overviewSizeDistribution");
            return false;
        }
    }

    private boolean overviewRiskEstimates() throws IOException {

        try {

            reportsHelper.verifyTitle(reportSectionOne, reportOrderZero, "RISK ESTIMATES", softAssert);

            reportsHelper.isGridDisplayed(reportSectionOne, reportOrderZero);

            reportsHelper.getGridData(reportSectionOne,reportOrderZero); //Get the values and copy into Excel file

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("overviewRiskEstimates");

            return false;
        }

    }

    private boolean overviewRiskAttribution() throws IOException {

        try {

            reportsHelper.verifyTitle(reportSectionOne, reportOrderOne, "RISK ATTRIBUTION", softAssert);

            reportsHelper.isReportDisplayed(reportSectionOne, reportOrderOne);

            // JsonCompare.jsonDownload(reportSectionOne,reportOrderOne,"overviewRiskAttribution");

            //JsonCompare.getJsonFromChart(reportSectionOne,reportOrderOne,"overviewRiskAttribution",portfolioName,driver);

            reportsHelper.openDrillDowns(reportSectionOne, reportOrderOne);

            String element = "//*[@id=\"ctl00_mainContentPlaceHolder_ctl00_labTitle\"]";

            reportsHelper.verifyContentsInFormDrillDown(element, "CONTRIBUTION TO TRACKING ERROR", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("overviewRiskAttribution");
            return false;
        }

    }
    private boolean overviewTop10Risk() throws IOException {

        try {

            reportsHelper.verifyTitle(reportSectionOne, reportOrderTwo, "TOP 10 RISK CONTRIBUTORS", softAssert);

            reportsHelper.isGridDisplayed(reportSectionOne, reportOrderTwo);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("overviewTop10Risk");
            return false;
        }

    }

    private boolean overviewContributionToRisk() throws IOException {

        try {

            reportsHelper.verifyTitle(reportSectionOne, reportOrderThree, "CONTRIBUTION TO RISK BY STYLE", softAssert);

            reportsHelper.isGridDisplayed(reportSectionOne, reportOrderThree);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("overviewContributionToRisk");
            return false;
        }

    }
    private Boolean overviewLiquidity() throws IOException {

        try {

            reportsHelper.verifyTitle(reportSectionTwo, reportOrderZero, "LIQUIDITY", softAssert);

            reportsHelper.isReportDisplayed(reportSectionTwo, reportOrderZero);

            //JsonCompare.jsonDownload(reportSection,orderOfReport,"overviewLiquidity");

            //JsonCompare.getJsonFromChart(reportSectionTwo,reportOrderZero,"overviewLiquidity",portfolioName,driver);

           return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("overviewLiquidity");
            return false;
        }

    }
    private Boolean summarySEUA() throws IOException {

        try {

            reportsPage.getStyleExposureSummary();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "PORTFOLIO STYLE SKYLINE" + "\u2122", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            String element = "//*[@id=\"ctl00_mainContentPlaceHolder_factorTabularData\"]/div[1]/table/tbody/tr[2]/td[1]";

            reportsHelper.verifyContentsInFormDrillDown(element, "Portfolio Wtd Avg:", softAssert);

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("summarySEUA");
            return false;
        }

    }

    private Boolean summarySESA() throws IOException {

        try {
            reportsPage.getStyleExposureSummary();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderOne, "PORTFOLIO STYLE SKYLINE" + "\u2122" + " SECTOR ADJUSTED", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderOne);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderOne);

            String element = "//*[@id=\"ctl00_mainContentPlaceHolder_factorTabularData\"]/div[1]/table/tbody/tr[2]/td[1]";

            reportsHelper.verifyContentsInFormDrillDown(element, "Portfolio Wtd Avg:", softAssert);
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("summarySESA");
            return false;
        }

    }

    private boolean summarySECA() throws IOException {

        try {
            reportsHelper.verifyTitle(reportSectionOne, reportOrderZero, "PORTFOLIO STYLE SKYLINE" + "\u2122" + " COUNTRY ADJUSTED", softAssert);

            reportsHelper.isReportDisplayed(reportSectionOne, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionOne, reportOrderZero);

            String element = "//*[@id=\"ctl00_mainContentPlaceHolder_factorTabularData\"]/div[1]/table/tbody/tr[2]/td[1]";

            reportsHelper.verifyContentsInFormDrillDown(element, "Portfolio Wtd Avg:", softAssert);

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("summarySECA");
            return false;
        }

    }

    private Boolean summarySESACA() throws IOException {

        try {

            reportsHelper.verifyTitle(reportSectionOne, reportOrderOne, "PORTFOLIO STYLE SKYLINE" + "\u2122" + " COUNTRY AND SECTOR ADJUSTED", softAssert);

            reportsHelper.isReportDisplayed(reportSectionOne, reportOrderOne);

            reportsHelper.openDrillDowns(reportSectionOne, reportOrderOne);
            String element = "//*[@id=\"ctl00_mainContentPlaceHolder_factorTabularData\"]/div[1]/table/tbody/tr[2]/td[1]";

            reportsHelper.verifyContentsInFormDrillDown(element, "Portfolio Wtd Avg:", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("summarySESACA");
            return false;
        }

    }

    private boolean seRegionSkyline() throws IOException {

        try {

            reportsPage.getRegionSkyline();

            // String value = driver.findElement(By.id("ctl00_mainContentPlaceHolder_report_hidFirstPageLoaded")).getAttribute("value");

            // System.out.println(value);

            // reportsHelper.verifyTitle1(reportSectionZero, reportOrderOne, "EUROPE");

            reportsHelper.findAllReportsTitleInPage(1, softAssert);

            reportsHelper.findAllChartsInPage(1, softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("seRegionSkyline");
            return false;
        }

    }

    private boolean seSectorSkyline() throws IOException {

        try {

            reportsPage.getSectorSkyline();

            reportsHelper.verifyTitle1(reportSectionZero, reportOrderOne, "ENERGY", softAssert);

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderZero);

            reportsHelper.findAllReportsTitleInPage(10, softAssert);
            reportsHelper.findAllChartsInPage(10, softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("seSectorSkyline");
            return false;
        }

    }

    private boolean seCountrySkyline() throws IOException {

        try {
            reportsPage.getCountrySkyline();

            // reportsHelper.verifyTitle1(reportSectionZero, reportOrderOne, "UK");

            List<WebElement> title = driver.findElements(By.className("chartTitle"));

            System.out.println(title.size());

            if (title.size() < 1) {

                System.out.print("Country Skyline Reports not Displayed");
                Assert.fail();
            } else {
                System.out.print("Country Skyline Reports are Displayed");

            }

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("seCountrySkyline");
            return false;
        }

    }

    private boolean seHistoryRange() throws IOException {

        try {
            reportsPage.getStyleExposureRange();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "STYLE SKYLINE" + "\u2122" + " RANGE", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            reportsHelper.verifyChartInDrillDown();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("seHistoryRange");
            return false;
        }

    }

    private boolean seHistoryTrails() throws IOException {

        try {

            reportsPage.getStyleExposureTrails();

            reportsHelper.findAllReportsTitleInPage(20, softAssert); //need to refactor this to find how many factors selected.

            reportsHelper.findAllChartsInPage(20, softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("seHistoryTrails");
            return false;
        }

    }

    private boolean seTiltHeatMap() throws IOException {

        try {
            reportsPage.getTiltHeatMap();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "STYLE SKYLINE" + "\u2122", softAssert);

            reportsHelper.verifyHeatmapDisplayed();

            driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap\"]/tbody/tr[4]/td[1]/div")).click();

            Thread.sleep(3000);

            String element = "//*[@id=\"ctl00_mainContentPlaceHolder_factorTabularData\"]/div[1]/table/tbody/tr[2]/td[1]";

            reportsHelper.verifyContentsInFormDrillDown(element, "Portfolio Wtd Avg:", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("seTiltHeatMap");
            return false;
        }


    }

    private boolean seFactorDataValue() throws IOException {

        try {

            reportsPage.getFactorData();

            Wait.waitForSquareBoxesToDisappear(driver, 45);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "FACTOR DATA VALUES", softAssert);

            //rp.seFactorDataValueReport.isDisplayed();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("seFactorDataValue");
            return false;
        }


    }

    private boolean regionDistOverview() throws IOException {

        try {

            reportsPage.getRegionOverivew();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "REGION DISTRIBUTION", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero); //Need to add code to drill into sector and country
            Thread.sleep(2000);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "COUNTRY DISTRIBUTION", softAssert);

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("regionDistOverview");
            return false;
        }
    }

    private boolean regionDistRange() throws IOException {

        try {

            reportsPage.getRegionRange();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "DISTRIBUTION HISTORY", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            reportsHelper.verifyChartInDrillDown();

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("regionDistRange");
            return false;
        }
    }

    private boolean regionDistHistory() throws IOException {

        try {

            reportsPage.getRegionhistory();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "REGION WEIGHTS", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            reportsHelper.verifyChartInDrillDown();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("regionDistHistory");
            return false;
        }
    }

    private Boolean sectorOverview() throws IOException {

        try {

            reportsPage.getSectorOverview();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "SECTOR DISTRIBUTION CHART", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            reportsHelper.verifyTop10SecurityDrillDown();

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("sectorOverview");
            return false;
        }

    }

    private boolean sectorRange() throws IOException {

        try {
            reportsPage.getSectorRange();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "DISTRIBUTION HISTORY", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            reportsHelper.verifyChartInDrillDown();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("sectorRange");
            return false;
        }
    }

    private boolean sectorHistory() throws IOException {

        try {

            reportsPage.getSectorHistory();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "SECTOR WEIGHTS", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            // verifyGridInDrillDown();

            reportsHelper.verifyTop10SecurityDrillDown();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("sectorHistory");
            return false;
        }
    }

    private boolean countryOverview() throws IOException {

        try {
            reportsPage.getCountryOverview();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "COUNTRY DISTRIBUTION CHART", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            Thread.sleep(2000);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "SECTOR DISTRIBUTION CHART", softAssert);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            reportsHelper.verifyTop10SecurityDrillDown();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("countryOverview");
            return false;
        }
    }

    private boolean countryRange() throws IOException {

        try {

            reportsPage.getCountryRange();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "DISTRIBUTION HISTORY", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            reportsHelper.verifyChartInDrillDown();

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("countryRange");
            return false;
        }
    }

    private boolean countryHistory() throws IOException {

        try {
            reportsPage.getCountryHistory();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "COUNTRY WEIGHTS - TOP 10", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            List<WebElement> charts = driver.findElements(By.xpath("//area[contains(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00')]"));

            charts.get(0).click();

            reportsHelper.verifyTop10SecurityDrillDown();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("countryHistory");
            return false;
        }
    }

    private boolean sizeOverview() throws IOException {

        try {
            reportsPage.getSizeOverview();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "SIZE DISTRIBUTION CHART", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero); //Need to add code to drill into sector and country

            Thread.sleep(2000);

            reportsHelper.verifyGridInDrillDown();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("sizeOverview");
            return false;
        }
    }


    private boolean sizeRange() throws IOException {

        try {
            reportsPage.getSizeRange();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "DISTRIBUTION HISTORY", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            reportsHelper.verifyChartInDrillDown();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("sizeRange");
            return false;
        }
    }

    private boolean sizeHistory() throws IOException {

        try {
            reportsPage.getSizeHistory();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "SIZE DISTRIBUTION HISTORY", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            reportsHelper.verifySecuritylListDrillDown();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderOne, "SIZE DISTRIBUTION HISTORY SA", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderOne);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderOne);

            reportsHelper.verifySecuritylListDrillDown();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderTwo, "SIZE DISTRIBUTION HISTORY CA", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderTwo);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderTwo);

            reportsHelper.verifySecuritylListDrillDown();

            reportsHelper.verifyTitle(reportSectionOne, reportOrderZero, "SIZE DISTRIBUTION HISTORY CASA", softAssert);

            reportsHelper.isReportDisplayed(reportSectionOne, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionOne, reportOrderZero);

            reportsHelper.verifySecuritylListDrillDown();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("sizeHistory");
            return false;
        }
    }

    private Boolean  styleOverview() throws IOException {
        try {
            reportsPage.getStyleOverview();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "STYLE DISTRIBUTION", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            reportsHelper.verifySecuritylListDrillDown();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderOne, "DISTRIBUTION DETAIL", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderOne);

            reportsHelper.verifyTitle(reportSectionOne, reportOrderZero, "STYLE DISTRIBUTION SA", softAssert);

            reportsHelper.isReportDisplayed(reportSectionOne, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionOne, reportOrderZero);

            reportsHelper.verifySecuritylListDrillDown();

            reportsHelper.verifyTitle(reportSectionOne, reportOrderOne, "DISTRIBUTION DETAIL", softAssert);
            reportsHelper.isGridDisplayed(reportSectionOne, reportOrderOne);

            reportsHelper.verifyTitle(reportSectionTwo, reportOrderZero, "STYLE DISTRIBUTION CA", softAssert);

            reportsHelper.isReportDisplayed(reportSectionTwo, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionTwo, reportOrderZero);

            reportsHelper.verifySecuritylListDrillDown();

            reportsHelper.verifyTitle(reportSectionTwo, reportOrderOne, "DISTRIBUTION DETAIL", softAssert);
            reportsHelper.isGridDisplayed(reportSectionTwo, reportOrderOne);

            reportsHelper.verifyTitle(reportSectionThree, reportOrderZero, "STYLE DISTRIBUTION CASA", softAssert);

            reportsHelper.isReportDisplayed(reportSectionThree, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionThree, reportOrderZero);

            reportsHelper.verifySecuritylListDrillDown();

            reportsHelper.verifyTitle(reportSectionThree, reportOrderOne, "DISTRIBUTION DETAIL", softAssert);
            reportsHelper.isGridDisplayed(reportSectionThree, reportOrderOne);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("styleOverview");
            return false;
        }
    }

    private Boolean styleRange() throws IOException {

        try {

            reportsPage.getStyleRange();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "DISTRIBUTION HISTORY", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            reportsHelper.verifyChartInDrillDown();

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("styleRange");
            return false;
        }
    }

    private Boolean styleHistory() throws IOException {

        try {

            reportsPage.getStyleHistory();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "STYLE DISTRIBUTION HISTORY", softAssert);
            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);
            reportsHelper.verifySecuritylListDrillDown();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderOne, "STYLE DISTRIBUTION HISTORY SA", softAssert);
            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderOne);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderTwo, "STYLE DISTRIBUTION HISTORY CA", softAssert);
            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderTwo);

            reportsHelper.verifyTitle(reportSectionOne, reportOrderZero, "STYLE DISTRIBUTION HISTORY CASA", softAssert);
            reportsHelper.isReportDisplayed(reportSectionOne, reportOrderZero);


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("styleHistory");
            return false;
        }

    }

    private Boolean distributionHeatMap() throws IOException {

        try {

            reportsPage.getDistributionHeatMap();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "DISTRIBUTION HEAT MAP", softAssert);

            reportsPage.getDistributionHeatMapReport().isDisplayed();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("distributionHeatMap");
            return false;

        }
    }

    private boolean sectorHeatMap() throws IOException {

        try {

            reportsPage.getSectorHeatMap();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "SECTOR HEAT MAP", softAssert);

            reportsPage.getSectorHeatMapReport().isDisplayed();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("sectorHeatMap");
            return false;

        }
    }

    private boolean countryHeatmap() throws IOException {

        try {
            reportsPage.getCountryHeatMap();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "COUNTRY HEAT MAP", softAssert);

            reportsPage.getCountryHeatMapReport().isDisplayed();


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("countryHeatmap");
            return false;

        }
    }

    private boolean sectorBreakdown() throws IOException {

        try {
            reportsPage.getSectorBreakdown();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_labBreadcrumb\"]")).getText(), "SECTOR BREAKDOWN");

            driver.findElement(By.className("zingChartWidget")).isDisplayed();


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("sectorBreakdown");
            return false;

        }
    }

    private Boolean riskOverview() throws IOException {

        try {

            reportsPage.getRiskOverview();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "RISK ATTRIBUTION", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderOne, "RISK", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderOne);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderTwo, "TOP 10 RISK CONTRIBUTORS", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderTwo);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("riskOverview");
            return false;

        }
    }

    private boolean riskPersistence() throws IOException {

        try {
            reportsPage.getPersistence();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "ANNUALIZED TRACKING ERROR", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            return true;


        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("riskPersistence");
            return false;
        }

    }

    private boolean riskRange() throws IOException {
        try {
            reportsPage.getRiskRange();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderOne, "RISK ATTRIBUTION HISTORY", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderOne);

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderOne);

            reportsHelper.verifyChartInDrillDown();

            reportsHelper.openDrillDowns(reportSectionZero, reportOrderZero);

            Thread.sleep(2000);

            reportsHelper.verifyChartInDrillDown();


            return true;


        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("riskRange");
            return false;

        }

    }


    private boolean riskAttribution() throws IOException {

        try {

            reportsPage.getRiskAttribution();

            softAssert.assertEquals(reportsPage.getRiskAttributionTitle().getText(), "RISK HISTORY - TRAILS");

            List<WebElement> titles = driver.findElements(By.xpath("//*[contains(@id,'_labTitle')]"));

            System.out.println(titles.size());

            for (int i = 0; i < titles.size(); i++) {

                softAssert.assertTrue(titles.get(i).isDisplayed());

            }

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("riskAttribution");
            return false;

        }
    }

    private boolean riskOtherTrails() throws IOException {

        try {

            reportsPage.getOtherRiskTrails();

            softAssert.assertEquals(reportsPage.getRiskOtherTrailsTitle().getText(), "RISK HISTORY - OTHER TRAILS");

            List<WebElement> titles = driver.findElements(By.xpath("//*[contains(@id,'_labTitle')]"));

            System.out.println(titles.size());

            for (int i = 0; i < titles.size(); i++) {

                softAssert.assertTrue(titles.get(i).isDisplayed());

            }

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("riskOtherTrails");
            return false;

        }
    }

    private boolean riskBySecurities() throws IOException {
        try {

            reportsPage.getRiskBySecurities();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "RISK BY SECURITIES", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("riskBySecurities");
            return false;
        }
    }

    private boolean riskDecompositionByGroup() throws IOException {

        try {
            reportsPage.getRiskDecompositionByGroup();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "RISK DECOMPOSITION BY GROUP", softAssert);

            reportsHelper.verifyHeatMapDisplayed("RISK DECOMPOSITION BY GROUP");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("riskDecompositionByGroup");
            return false;

        }
    }

    private boolean riskSummary() throws IOException {

        try {

            reportsPage.getFofRiskSummary();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            softAssert.assertEquals(reportsPage.getRiskSummaryTitle().getText(), "FUND OF FUNDS SUMMARY");

            softAssert.assertTrue(reportsPage.getRiskSummaryTable().isDisplayed(), "FUND OF FUNDS SUMMARY Grid not displyed");


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("riskSummary");
            return false;

        }

    }

    private boolean riskSubFundStat() throws IOException {

        try {

            reportsPage.getSubFundRiskStatistics();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            softAssert.assertEquals(reportsPage.getRiskSubFundStatsTitle().getText(), "SUB FUND RISK STATISTICS");

            softAssert.assertTrue(reportsPage.getRiskSubFundStatsReport().isDisplayed());


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("riskSubFundStat");
            return false;
        }

    }

    private boolean riskNumberOfDifferentStocks() throws IOException {

        try {

            reportsPage.getNumberOfDifferentStocks();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            softAssert.assertEquals(reportsPage.getRiskNumberOfDifferentStocksTitle().getText(), "NUMBER OF DIFFERENT STOCKS");

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("riskNumberOfDifferentStocks");
            return false;

        }

    }

    private boolean liquiditySummary() throws IOException {

        try {
            reportsPage.getLiquiditySummary();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "LIQUIDITY SUMMARY", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderOne, "TOP 10 ILLIQUID PORTFOLIO STOCKS (TRADE TO CASH)", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderOne);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderTwo, "TOP 10 ILLIQUID PORTFOLIO STOCKS (TRADE TO BENCHMARK)", softAssert);
            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderTwo);

            reportsHelper.verifyTitle(reportSectionOne, reportOrderZero, "TOP 10 ILLIQUID BENCHMARK STOCKS (TRADE TO BENCHMARK)", softAssert);
            reportsHelper.isGridDisplayed(reportSectionOne, reportOrderZero);


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("liquiditySummary");
            return false;

        }

    }

    private boolean liquidityHistory() throws IOException {

        try {
            reportsPage.getLiquidityHistory();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "TRADE TO CASH HISTORY", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);


            reportsHelper.verifyTitle(reportSectionZero, reportOrderOne, "TRADE TO BENCHMARK HISTORY", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderOne);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderTwo, "PORTFOLIO VALUES", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderTwo);


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("liquidityHistory");
            return false;

        }

    }

    private boolean liquiditySecurityDetails() throws IOException {

        try {

            reportsPage.getLiquiditySecurityDetails();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "LIQUIDITY SECURITY DETAILS", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("liquiditySecurityDetails");
            return false;
        }

    }

    private Boolean performanceSummary() throws IOException {

        try {

            reportsPage.getPerformanceSummary();

            reportsHelper.verifyTitle1(reportSectionZero, reportOrderOne, "PERFORMANCE SUMMARY", softAssert);

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderZero);

            reportsHelper.verifyTitle1(reportSectionOne, reportOrderOne, "TOP 10 STOCK CONTRIBUTORS TO ACTIVE RETURN", softAssert);

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderOne);

            //reportsHelper.verifyTitle1(reportSectionOne, reportOrderZero, "BOTTOM 10 STOCK CONTRIBUTORS TO ACTIVE RETURN", softAssert);
            reportsHelper.isReportDisplayed1(reportSectionOne, reportOrderZero);


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("performanceSummary");
            return false;
        }

    }

    private boolean performanceByMarket() throws IOException {

        try {

            reportsPage.getPerormanceByMarket();

            reportsHelper.verifyTitle1(reportSectionZero, reportOrderOne, "BRINSON ATTRIBUTION BY MARKET", softAssert);

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderZero);

            reportsHelper.verifyTitle1(reportSectionOne, reportOrderOne, "CONTRIBUTIONS BY MARKET", softAssert);

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderOne);

            List<WebElement> x = driver.findElements(By.xpath("//area[contains(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl01')]"));

            System.out.println(x.size());
            x.get(1).click();

            reportsHelper.verifyTop10SecurityDrillDown();


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("performanceByMarket");
            return false;

        }
    }

    private boolean performanceBySector() throws IOException {

        try {

            reportsPage.getPerformaceBySector();

            reportsHelper.verifyTitle1(reportSectionZero, reportOrderOne, "BRINSON ATTRIBUTION BY SECTOR", softAssert);

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderZero);

            reportsHelper.verifyTitle1(reportSectionOne, reportOrderOne, "CONTRIBUTIONS BY SECTOR", softAssert);

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderOne);

            List<WebElement> charts = driver.findElements(By.xpath("//area[contains(@id,'_chartDiv-graph-id0-plotset-plot-0-node-1')]"));

            System.out.println(charts.size());

            charts.get(1).click();

            Thread.sleep(4000);

            reportsHelper.verifySecuritylListDrillDown();


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("performanceBySector");
            return false;
        }


    }

    private boolean performanceByStyle() throws IOException {

        try {

            reportsPage.getPerformanceByStyle();

            reportsHelper.verifyTitle1(reportSectionZero, reportOrderOne, "BRINSON ATTRIBUTION BY STYLE", softAssert);

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderZero);

            reportsHelper.verifyTitle1(reportSectionOne, reportOrderOne, "CONTRIBUTIONS BY STYLE", softAssert);

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderOne);

            List<WebElement> charts = driver.findElements(By.xpath("//area[contains(@id,'_chartDiv-graph-id0-plotset-plot-0-node-1')]"));

            charts.get(1).click();

            Thread.sleep(4000);

            reportsHelper.verifySecuritylListDrillDown();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("performanceByStyle");
            return false;
        }

    }

    private boolean performanceByHierarchy() throws IOException {

        try {
            reportsPage.getPerformanceByHierarchy();

            Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")).getText(), "PERFORMANCE BY HIERARCHY");

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderZero);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("performanceByHierarchy");
            return false;
        }


    }

    private boolean fofPerformance() throws IOException {

        try {
            reportsPage.getFofPerformace();

            reportsHelper.verifyTitle1(reportSectionZero, reportOrderOne, "FUND OF FUNDS PERFORMANCE", softAssert);

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderOne);

            reportsHelper.verifyTitle1(reportSectionOne, reportOrderOne, "CONTRIBUTIONS BY FUND", softAssert);

            reportsHelper.isReportDisplayed1(reportSectionZero, reportOrderOne);

            List<WebElement> charts = driver.findElements(By.xpath("//area[contains(@id,'_chartDiv-graph-id3-plotset-plot-0-node-0')]"));

            charts.get(0).click();

            Thread.sleep(4000);

            reportsHelper.verifySecuritylListDrillDown();


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("fofPerformance");
            return false;
        }


    }

    private Boolean fofPerformanceDetails() throws IOException {

        try {
            reportsPage.getFofPerformaceDetails();
            Wait.waitForSquareBoxesToDisappear(driver, 30);

            //reportsHelper.subFundGalleryTitle(reportsPage.getSubFundGalleryReportsTitle(), "FUND OF FUNDS PERFORMANCE DETAIL", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("fofPerformanceDetails");
            return false;
        }


    }


    private boolean styleMinePerformance() throws IOException {

        try {
            reportsPage.getStyleMinePerformance();

            Wait.waitForSquareBoxesToDisappear(driver, 60);

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "FACTOR PERFORMANCE IMPACT", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            List<WebElement> grid = driver.findElements(By.xpath("//div[contains(@class,'slick-cell l0 r0')]"));

            grid.get(0).click();

            driver.switchTo().frame(0);

            // Utility.waitForElementToDisplay(rp.styleMinePerformanceDrilldownTitle,10);

            // softAssert.assertEquals(rp.styleMinePerformanceDrilldownTitle.getText(),"BRINSON ATTRIBUTION BY BOOK TO PRICE");


            reportsHelper.closePopup();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("styleMinePerformance");
            return false;
        }


    }

    private boolean subFundGallerySE() throws IOException {

        try {
            reportsPage.getSubFundStyleExposure();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.subFundGalleryTitle(reportsPage.getSubFundGalleryReportsTitle(), "SUB FUND GALLERY - STYLE EXPOSURES", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("subFundGallerySE");
            return false;
        }


    }

    private boolean subFundGalleryRisk() throws IOException {

        try {
            reportsPage.getSubFundStyleRisk();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.subFundGalleryTitle(reportsPage.getSubFundGalleryReportsTitle(), "SUB FUND GALLERY - RISK", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("subFundGalleryRisk");
            return false;
        }
    }

    private boolean subFundGalleryRiskOther() throws IOException {

        try {
            reportsPage.getSubFundStyleRiskOther();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.subFundGalleryTitle(reportsPage.getSubFundGalleryReportsTitle(), "SUB FUND GALLERY - RISK OTHER", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("subFundGalleryRiskOther");
            return false;
        }


    }

    private boolean subFundGalleryRegion() throws IOException {

        try {
            reportsPage.getSubFundRegionDistribution();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.subFundGalleryTitle(reportsPage.getSubFundGalleryReportsTitle(), "SUB FUND GALLERY - REGION DISTRIBUTION", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("subFundGalleryRegion");
            return false;
        }

    }

    private boolean subFundGallerySector() throws IOException {

        try {
            reportsPage.getSubFundSectorDistribution();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.subFundGalleryTitle(reportsPage.getSubFundGalleryReportsTitle(), "SUB FUND GALLERY - SECTOR DISTRIBUTION", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("subFundGallerySector");
            return false;
        }

    }

    private boolean subFundGallerySize() throws IOException {

        try {

            reportsPage.getSubFundSizeDistribtuion();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.subFundGalleryTitle(reportsPage.getSubFundGalleryReportsTitle(), "SUB FUND GALLERY - SIZE DISTRIBUTION", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("subFundGallerySize");
            return false;
        }

    }

    private boolean subFundGalleryStyle() throws IOException {

        try {

            reportsPage.getSubFundStyledistribution();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);

            reportsHelper.subFundGalleryTitle(reportsPage.getSubFundGalleryReportsTitle(), "SUB FUND GALLERY - STYLE DISTRIBUTION", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("subFundGalleryStyle");
            return false;
        }


    }

    private boolean subFundGalleryFOFWeight() throws IOException {
        try {
            reportsPage.getSubFundSecurityWeight();

            Wait.waitForSquareBoxesToDisappear(driver, 30);

            reportsHelper.subFundGalleryTitle(reportsPage.getSubFundGalleryFoFSecurityWeightsTitle(), "FUND OF FUNDS SECURITY WEIGHTS", softAssert);

            reportsHelper.isGridDisplayed(reportSectionZero, reportOrderZero);


            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("subFundGalleryFOFWeight");
            return false;
        }


    }

    private boolean labsAssetTree() throws Exception {

        try {

            reportsPage.getAssetTree();

            reportsHelper.subFundGalleryTitle(reportsPage.getLabsAssetTreeReportTitle(), "PORTFOLIO BREAKDOWN", softAssert);

            reportsHelper.isReportDisplayed(reportSectionZero, reportOrderZero);

            return true;
        }catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("labsAssetTree");
            return false;
        }

    }

    private boolean labsStyleScatter() throws IOException {

        try {
            reportsPage.getStyleScatter();

            reportsHelper.verifyTitle(reportSectionZero, reportOrderZero, "STYLE DISTRIBUTION ACTIVE WEIGHTS", softAssert);

            softAssert.assertTrue(driver.findElement(By.xpath("//*[contains(@id,'_chartDiv')]")).isDisplayed());

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("labsStyleScatter");
            return false;
        }


    }

    private boolean labsXYSnailTrails() throws IOException {

        try {

            reportsPage.getTiltXySnailTrails();

            reportsHelper.isLabsReportDisplayed(reportSectionZero, reportOrderZero);

            softAssert.assertEquals(reportsPage.getLabsTiltXYSnailTrailTitle().getText(), "SNAIL TRAIL");

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("labsXYSnailTrails");
            return false;
        }


    }


}
