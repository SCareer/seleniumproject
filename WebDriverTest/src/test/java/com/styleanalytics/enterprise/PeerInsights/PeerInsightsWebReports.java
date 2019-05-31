package com.styleanalytics.enterprise.PeerInsights;

import com.styleanalytics.enterprise.DataDriven.DataDrivenSetup;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class PeerInsightsWebReports extends TestBase {

    private PeerInsightsHelper pH;

    private PeerInsightsPage PI;

    private SoftAssert softAssert;

    static WebDriver driver;


    @DataProvider
    public static Object[][] data() throws IOException {

        String testDataFile = property("TestData");

        Object[][] arrayObject = DataDrivenSetup.readFromExcel(testDataFile, "PIWebReports");

        return arrayObject;

    }

    @BeforeClass
    public void setupPeerInsightsWebReportTest() throws IOException, InterruptedException {

        pH = new PeerInsightsHelper(getDriver());

        PI = new PeerInsightsPage(getDriver());

        LoginPage loginPage = new LoginPage( getDriver());
        loginPage.login();

        driver = getDriver();


    }

    @Test(dataProvider = "data")
    public void peerInsightsWebReportTest(String reportName, String testExecution) throws Exception {

        if (testExecution.equalsIgnoreCase("No")) {

            throw new SkipException("Scenario skipped: " + reportName);
        }

        PI.goToPeerInsightLandingPage(getURL());
        PI.accessPeerInsight(reportName);

        Thread.sleep(10000);

        softAssert = new SoftAssert();

        softAssert.assertTrue(verifyPeerGroupOverVew(), "verifyPeerGroupOverVew");
        softAssert.assertTrue(verifyPeerGroupMedian(), "verifyPeerGroupMedian");
        softAssert.assertTrue(verifyCountryDistribution(), "verifyCountryDistribution");
        softAssert.assertTrue(verifyCountryDistributionFundLevel(), "verifyCountryDistributionFundLevel");
        softAssert.assertTrue(verifyCountryDistributionFundLevelHeatMap(), "verifyCountryDistributionFundLevelHeatMap");
        //softStyleSkylineFundLevelHeatMapAssert.assertTrue(verifyCountryDistributionHistoryTitle(), "verifyCountryDistributionHistoryTitle");
        softAssert.assertTrue(verifyPeerRiskAttribution(), "verifyPeerRiskAttribution");
        softAssert.assertTrue(verifyPeerRiskAttributionFundLevel(), "verifyPeerRiskAttributionFundLevel");
        softAssert.assertTrue(verifyPeerRiskAttributionFundLevelHeatMap(), "verifyPeerRiskAttributionFundLevelHeatMap");
        softAssert.assertTrue(verifyPeerRiskHistoryTitle(), "verifyPeerRiskHistoryTitle");
        softAssert.assertTrue(verifyPeerRiskMeasuresFundLevelHeatMap(), "verifyPeerRiskMesuresFundLevelHeatMap");
        softAssert.assertTrue(verifyPeerSizeDistribution(), "verifyPeerSizeDistribution");
        softAssert.assertTrue(verifyPeerStyleDistributions(), "verifyPeerStyleDistributions");
        softAssert.assertTrue(verifyPeerStyleDistributionsFundLevel(), "verifyPeerStyleDistributionsFundLevel");
        softAssert.assertTrue(verifyPeerStyleDistributionsFundLevelHeatMap(), "verifyPeerStyleDistributionsFundLevelHeatMap");
        softAssert.assertTrue(verifyPerformanceRank(), "verifyPerformanceRank");
        softAssert.assertTrue(verifyPortfolioReturns(), "verifyPortfolioReturns");
        softAssert.assertTrue(verifyPortfolioRiskRank(), "verifyPortfolioRiskRank");
        softAssert.assertTrue(verifySectorDistribution(), "verifySectorDistribution");
        softAssert.assertTrue(verifySectorDistributionFundLevel(), "verifySectorDistributionFundLevel");
        softAssert.assertTrue(verifySectorDistributionFundLevelHeatMap(), "verifySectorDistributionFundLevelHeatMap");
        softAssert.assertTrue(verifySectorDistributionHistoryTitle(), "verifySectorDistributionHistoryTitle");
        softAssert.assertTrue(verifySizeDistributionFundLevel(), "verifySizeDistributionFundLevel");
        softAssert.assertTrue(verifySizeDistributionFundLevelHeatMap(), "verifySizeDistributionFundLevelHeatMap");
        softAssert.assertTrue(verifySizeDistributionHistoryTitle(), "verifySizeDistributionHistoryTitle");
        softAssert.assertTrue(verifyStyleDistributionHistory(), "verifyStyleDistributionHistory");
        softAssert.assertTrue(verifyStyleExposureFundLevel(), "verifyStyleExposureFundLevel");
        softAssert.assertTrue(verifyStyleExposureFundLevelHeatMap(), "verifyStyleExposureFundLevelHeatMap");
        softAssert.assertTrue(verifyStyleExposureSkyline(), "verifyStyleExposureSkyline");
        softAssert.assertTrue(verifyStyleSkylineHistory(), "verifyStyleSkylineHistory");

        softAssert.assertAll();
    }

    public Boolean verifyPeerGroupOverVew() throws InterruptedException, IOException {

        try {
            PI.goToPeerInsightsReportsMenu("PeerGroupOverview", PI.piPeerGroupOverViewMenu);

            String[] reportTitel = {"PEER STYLE SKYLINE" + "\u2122", "PERFORMANCE RANK", "PORTFOLIO RISK RANK", "PEER SECTOR DISTRIBUTION ACTIVE WEIGHT", "PEER STYLE DISTRIBUTION ACTIVE WEIGHT",
                    "PEER SIZE DISTRIBUTION ACTIVE WEIGHT"};

            PeerInsightsHelper.verifyMutilpeReportOnPage(reportTitel, softAssert);

            pH.verifyPeerOverviewReports();

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPeerGroupOverVew");
            return false;
        }
    }


    public Boolean verifyPeerGroupMedian() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerGroupOverviewMedian", PI.piPeerGroupMedianMenu);

            String[] reportTitel = {"STYLE SKYLINE" + "\u2122" + " MEDIAN", "STYLE DISTRIBUTION MEDIAN", "SIZE DISTRIBUTION MEDIAN", "REGION DISTRIBUTION MEDIAN", "SECTOR DISTRIBUTION MEDIAN",
                    "KEY RISK ATTRIBUTES", "RISK MEDIAN", "SUMMARY", "PORTFOLIO COUNT"};

            pH.verifyMutilpleReportOnPage(reportTitel, softAssert);

            pH.verifyPeerOverviewReportsMedian(7);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPeerGroupOverVew");
            return false;
        }

    }

    public Boolean verifyStyleExposureSkyline() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerStyleSkyline", PI.piStyleExposureStyleSkyLineMenu);

            softAssert.assertEquals(pH.titleAndReport(pH.title(), PI.piStyleSkylineReport, softAssert), "PEER STYLE SKYLINE" + "\u2122");

            pH.distributionDrillDown("//*[contains(@id,'1000_chartDiv-graph-id1-plotset-plot-3-node-0')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyStyleExposureSkyline");
            return false;
        }
    }

    public Boolean verifyStyleSkylineHistory() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerStyleSkylineHistory", PI.piStyleExposureStyleSkyLineHistoryMenu);

            String[] styleSkylineHistoryTrails = {"BOOK TO PRICE", "DIVIDEND YIELD", "EARNINGS YIELD", "CASH FLOW YIELD", "SALES TO PRICE",
                    "EBITDA TO EV", "RETURN ON EQUITY", "NET PROFIT MARGIN", "FORECAST GROWTH 12M", "LOW GEARING", "EARNINGS GROWTH STABILITY", "SALES GROWTH STABILITY",
                    "MARKET CAP", "MARKET BETA", "MOMENTUM ST"};

            pH.historyDrillDowns("//area[contains(@id,'chartDiv-graph-id0-plotset-plot-4-node-9--area')]");

            List<WebElement> chartslist = driver.findElements(By.className("chartTitle"));

            //System.out.println(chartslist.size());

            for (int i = 0; i < styleSkylineHistoryTrails.length; i++) {

                // System.out.println(chartslist.get(i).getText());

                softAssert.assertEquals(chartslist.get(i).getText(), styleSkylineHistoryTrails[i]);

            }

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyStyleSkylineHistory");
            return false;
        }

    }


    public Boolean verifyStyleExposureFundLevel() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("StyleSkylineFundLevel", PI.piStyleExposureFundLevelMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piStyleSkylineFunLevelTitel, PI.piStyleSkylineFundLevelReport, softAssert), "STYLE SKYLINE" + "\u2122" + " FUND LEVEL");

            pH.fundLevelHeatMapDrillDown("//*[contains(@class,'slick-cell l5 r5')]", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyStyleExposureFundLevel");
            return false;
        }
    }


    public Boolean verifyStyleExposureFundLevelHeatMap() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("StyleSkylineFundLevelHeatMap", PI.piStyleExposureFundLevelHeatMapMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piStyleSkylineFunLevelHeatMapTitel, PI.piStyleSkylineFundLeveHeatMaplReport, softAssert), "STYLE SKYLINE™ FUND LEVEL HEATMAP");

            // pH.fundLevelHeatMapDrillDown("//*[contains(@class,'slick-cell l5 r5')]");

            pH.fundLevelHeatMapDrillDown2("//*[contains(@class,'slick-cell l4 r4')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyStyleExposureFundLevelHeatMap");
            return false;
        }
    }


    public Boolean verifyPeerStyleDistributions() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerStyleDistribution", PI.piStyleDistributionMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piDistributionActiveWeightTitel, PI.piDistributionActiveWeightReport, softAssert), "PEER STYLE DISTRIBUTION ACTIVE WEIGHT");

            pH.distributionDrillDown("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-0-node-0')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPeerStyleDistributions");
            return false;
        }
    }


    public Boolean verifyStyleDistributionHistory() throws InterruptedException, IOException {

        try {
            PI.goToPeerInsightsReportsMenu("PeerStyleDistributionHistory", PI.piStyleDistributionHistoryReportMenu);

            String[] styleDistributionHistoryTrails = {"LARGE VALUE ACTIVE WEIGHT", "LARGE GROWTH ACTIVE WEIGHT", "MID VALUE ACTIVE WEIGHT", "MID GROWTH ACTIVE WEIGHT",
                    "SMALL VALUE ACTIVE WEIGHT", "SMALL GROWTH ACTIVE WEIGHT", "CASH ACTIVE WEIGHT"};

            //verifyReportTitles(styleDistributionHistoryTrails, softAssert);

            pH.historyDrillDowns("//area[contains(@id,'chartDiv-graph-id0-plotset-plot-3-node-5--area')]");


            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyStyleDistributionHistory");
            return false;
        }

    }

    public Boolean verifyPeerStyleDistributionsFundLevel() throws InterruptedException, IOException {

        try {
            PI.goToPeerInsightsReportsMenu("PeerStyleDistributionFundLevel", PI.piStyleDistributionFundLevelReportMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piDistributionFundLevelTitel, PI.piDistributionFundLevelReport, softAssert), "STYLE DISTRIBUTION FUND LEVEL ACTIVE WEIGHT");

            pH.fundLevalDrillDown("ShowWeightHistoryPopup", 0);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPeerStyleDistributionsFundLevel");
            return false;
        }

    }

    public Boolean verifyPeerStyleDistributionsFundLevelHeatMap() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerStyleDistributionFundLevelHeatMap", PI.piStyleDistributionFundLevelHeatMapReportMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piDistributionFundLevelHeatMapTitel, PI.piDistributionFundLevelHeatMapReport, softAssert), "STYLE DISTRIBUTION PEER GROUP HEATMAP ACTIVE WEIGHT");

            pH.fundLevelHeatMapDrillDown("//*[contains(@class,'slick-cell l4 r4')]", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPeerStyleDistributionsFundLevelHeatMap");
            return false;
        }

    }

    public Boolean verifyPeerSizeDistribution() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerSizeDistribution", PI.piSizeDistributionMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piSizeDistributionTitel, PI.piSizeDistributionReport, softAssert), "PEER SIZE DISTRIBUTION ACTIVE WEIGHT");

            pH.distributionDrillDown("//*[contains(@id, '1000_chartDiv-graph-id0-plotset-plot-0-node-0')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPeerSizeDistribution");
            return false;
        }

    }

    public Boolean verifySizeDistributionHistoryTitle() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerSizeDistributionHistory", PI.piSectorDistributionHistoryMenu);

            //"MEGA ACTIVE WEIGHT",

            String[] sizeDistributionHistoryTrails = {"LARGE ACTIVE WEIGHT", "MID ACTIVE WEIGHT", "SMALL ACTIVE WEIGHT", "MICRO ACTIVE WEIGHT", "CASH ACTIVE WEIGHT"};

           // verifySizeDistributionReportTitle(sizeDistributionHistoryTrails);

            pH.historyDrillDowns("//area[contains(@id,'chartDiv-graph-id0-plotset-plot-3-node-5--area')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifySizeDistributionHistoryTitle");
            return false;
        }

    }

    public Boolean verifySizeDistributionFundLevel() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerSizeDistributionFundLevel", PI.piSizeDistributionFundLevelReportMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piSizeDistributionFundLevelTitel, PI.piSizeDistributionFundLevelReport, softAssert), "SIZE DISTRIBUTION FUND LEVEL ACTIVE WEIGHT");

            pH.fundLevalDrillDown("javascript:ShowWeightHistoryPopup", 0);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifySizeDistributionFundLevel");
            return false;
        }

    }
    public Boolean verifySizeDistributionFundLevelHeatMap() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerSizeDistributionFundLevelHeatMap", PI.piSizeDistributionFundLevelHeatMapReportMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piSizeDistributionFundLevelHeatMapTitel, PI.piSizeDistributionFundLevelHeatMapReport, softAssert), "SIZE DISTRIBUTION PEER GROUP HEATMAP ACTIVE WEIGHT");

            pH.fundLevelHeatMapDrillDown("//*[contains(@class,'slick-cell l5 r5')]", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifySizeDistributionFundLevelHeatMap");
            return false;
        }

    }

    public Boolean verifyCountryDistribution() throws InterruptedException, IOException {
        try {

            PI.goToPeerInsightsReportsMenu("PeerCountryDistribution", PI.piCountryDistributionMenu);

            softAssert.assertEquals(pH.titleAndReport(pH.title(), report(), softAssert), "PEER GROUP COUNTRY TOP 10 BY ACTIVE WEIGHT");

            pH.distributionDrillDown("//*[contains(@id, '1000_chartDiv-graph-id0-plotset-plot-3-node-7')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyCountryDistribution");
            return false;
        }

    }
    public WebElement report() {

        String rep = driver.findElement(By.className("zc-img")).getAttribute("id");

        WebElement report = driver.findElement(By.xpath(" //img[@id='" + rep + "']"));

        //System.out.println(report);

        return report;

    }
    public void test() throws InterruptedException {

        PI.goToPeerInsightsReportsMenu("PeerCountryDistribution", PI.piCountryDistributionMenu);

        String a = driver.findElement(By.className("zc-img")).getAttribute("id");

        // System.out.println(a);

        softAssert.assertEquals(pH.titleAndReport(PI.piCountryDistributionTitel, PI.piCountryDistributionReport, softAssert), "PEER GROUP COUNTRY TOP 10 BY ACTIVE WEIGHT");

        pH.distributionDrillDown("//*[contains(@id, '1000_chartDiv-graph-id0-plotset-plot-3-node-7')]");

    }
    public Boolean verifyCountryDistributionHistoryTitle() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerCountryDistributionHistory", PI.piCountryDistributionHistoryMenu);

            String[] CountryDistributionHistoryTrails = {"JAPAN ACTIVE WEIGHT", "UK ACTIVE WEIGHT", "GERMANY ACTIVE WEIGHT", "CANADA ACTIVE WEIGHT", "SOUTH KOREA ACTIVE WEIGHT", "ITALY ACTIVE WEIGHT",
                    "SWEDEN ACTIVE WEIGHT", "CHINA ACTIVE WEIGHT", "AUSTRALIA ACTIVE WEIGHT", "NORWAY ACTIVE WEIGHT"};

            // verifyCountryDistributionReportTitle(CountryDistributionHistoryTrails);

            //Need to Verify the reports---code missing

            pH.historyDrillDowns("//area[contains(@id,'chartDiv-graph-id0-plotset-plot-4-node-18--area')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyCountryDistributionHistoryTitle");
            return false;
        }

    }
    public Boolean verifyCountryDistributionFundLevel() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerCountryDistributionFundLevel", PI.piCountryDistributionFundLevelReportMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piCountryDistributionFundLevelTitel, PI.piCountryDistributionFundLevelReport, softAssert), "COUNTRY DISTRIBUTION FUND LEVEL ACTIVE WEIGHT");

            pH.fundLevalDrillDown("javascript:ShowWeightHistoryPopup", 0);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyCountryDistributionFundLevel");
            return false;
        }

    }

    public Boolean verifyCountryDistributionFundLevelHeatMap() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerCountryDistributionFundLevelHeatMap", PI.piCountryDistributionFundLevelHeatMapReportMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piCountryDistributionFundLevelHeatMapTitel, PI.piCountryDistributionFundLevelHeatMapReport, softAssert), "COUNTRY DISTRIBUTION FUND LEVEL HEATMAP ACTIVE WEIGHT");

            pH.fundLevelHeatMapDrillDown("//*[contains(@class,'slick-cell l11 r11')]", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyCountryDistributionFundLevelHeatMap");
            return false;
        }
    }

    public Boolean verifySectorDistribution() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerSectorDistribution", PI.piSectorDistributionMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piSectorDistributionTitel, PI.piSectorDistributionReport, softAssert), "PEER SECTOR DISTRIBUTION ACTIVE WEIGHT");

            pH.distributionDrillDown("//*[contains(@id, '1000_chartDiv-graph-id0-plotset-plot-3-node-0')]");

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifySectorDistribution");
            return false;
        }

    }

    public Boolean verifySectorDistributionHistoryTitle() throws InterruptedException, IOException {
        try {

            PI.goToPeerInsightsReportsMenu("PeerSectorDistributionHistory", PI.piSectorDistributionHistoryMenu);

            String[] sectorDistributionHistoryTrails = {"INDUSTRIALS ACTIVE WEIGHT", "CONS DISC ACTIVE WEIGHT", "MATERIALS ACTIVE WEIGHT",
                    "REAL ESTATE ACTIVE WEIGHT", "UTILITIES ACTIVE WEIGHT", "TELECOMS ACTIVE WEIGHT",
                    "CONS STAPLES ACTIVE WEIGHT", "ENERGY ACTIVE WEIGHT", "INFO TECH ACTIVE WEIGHT",
                    "FINANCIALS ACTIVE WEIGHT", "HEALTH CARE ACTIVE WEIGHT"};

            //verifySectorDistributionReportTitle(sectorDistributionHistoryTrails);

            pH.historyDrillDowns("//area[contains(@id,'chartDiv-graph-id0-plotset-plot-4-node-18--area')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifySectorDistributionHistoryTitle");
            return false;
        }
    }
    public Boolean verifySectorDistributionFundLevel() throws IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerSectorDistributionFundLevel", PI.piSectorDistributionFundLevelReportMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piSectorDistributionFundLevelTitel, PI.piSectorDistributionFundLevelReport, softAssert), "SECTOR DISTRIBUTION FUND LEVEL ACTIVE WEIGHT");

            pH.fundLevalDrillDown("javascript:ShowWeightHistoryPopup", 0);

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifySectorDistributionFundLevel");
            return false;
        }

    }


    public Boolean verifySectorDistributionFundLevelHeatMap() throws IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerSectorDistributionFundLevelHeatMap", PI.piSectorDistributionFundLevelHeatMapReportMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piSectorDistributionFundLevelHeatMapTitel, PI.piSectorDistributionFundLevelHeatMapReport, softAssert), "SECTOR DISTRIBUTION FUND LEVEL HEATMAP ACTIVE WEIGHT");

            pH.fundLevelHeatMapDrillDown("//*[contains(@class, 'slick-cell l8 r8')]", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifySectorDistributionFundLevelHeatMap");
            return false;
        }

    }

    public Boolean verifyPortfolioRiskRank() throws IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PortfolioRiskRank", PI.piPortfolioRiskRankReportMainMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piPortfolioRiskRankTitel, PI.piPortfolioRiskRankReport, softAssert), "PORTFOLIO RISK RANK");

            pH.distributionDrillDown("//*[contains(@id, '1000_chartDiv-graph-id0-plotset-plot-1-node-0')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPortfolioRiskRank");
            return false;
        }

    }


    public Boolean verifyPeerRiskAttribution() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerRiskAttribution", PI.piPortfolioRiskAtributionReportMenu);

            Utility.moveToElement(PI.piPeerRiskAttributionTitel);

            softAssert.assertEquals(pH.titleAndReport(PI.piPeerRiskAttributionTitel, PI.piPeerRiskAttributionReport, softAssert), "PEER RISK ATTRIBUTION");

            pH.distributionDrillDown("//*[contains(@id, '1000_chartDiv-graph-id0-plotset-plot-1-node-0')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPeerRiskAttribution");
            return false;
        }

    }

    public Boolean verifyPeerRiskHistoryTitle() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PeerRiskHistory", PI.piPortfolioRiskHistoryReportMen);

            String[] peerRiskHistoryTrails = {"TRACKING ERROR", "CURRENCY", "MARKET XTERMS", "MARKET", "SECTOR XTERMS", "SECTOR", "STYLE XTERMS", "STYLE", "EQUITY XTERMS", "EQUITY"};

            pH.verifyPeerRiskHistoryReportTitle(peerRiskHistoryTrails, softAssert);

            pH.historyDrillDowns("//area[contains(@id,'chartDiv-graph-id0-plotset-plot-4-node-27--area')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPeerRiskHistoryTitle");
            return false;
        }

    }

    public Boolean verifyPeerRiskAttributionFundLevel() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("RiskAttributionFundLevel", PI.piPortfolioRiskAtributionFundLevel);

            Utility.moveToElement(PI.piRiskAttributionFundLevelTitel);

            softAssert.assertEquals(pH.titleAndReport(PI.piRiskAttributionFundLevelTitel, PI.piRiskAttributionFundLevelReport, softAssert), "RISK ATTRIBUTION FUND LEVEL");

            pH.fundLevelHeatMapDrillDown("//*[contains(@class, 'slick-cell l8 r8')]", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPeerRiskAttributionFundLevel");
            return false;
        }

    }


    public Boolean verifyPeerRiskMeasuresFundLevelHeatMap() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("RiskMeasuresFundLevelHeatMap", PI.piPortfolioRisMesuresFundLevelHeatMenu);

            Utility.moveToElement(PI.piRiskMesuresFundLevelHeatMapTitel);

            softAssert.assertEquals(pH.titleAndReport(PI.piRiskMesuresFundLevelHeatMapTitel, PI.piRiskMesuresFundLevelHeatMapReport, softAssert), "RISK MEASURES FUND LEVEL HEATMAP");

            pH.fundLevelHeatMapDrillDown("//*[contains(@class,'slick-cell l8 r8')]", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPeerRiskMeasuresFundLevelHeatMap");
            return false;
        }

    }


    public Boolean verifyPeerRiskAttributionFundLevelHeatMap() throws InterruptedException, IOException {

        try {

            PI.goToPeerInsightsReportsMenu("RiskAttributionFundLevelHeatMap", PI.piPortfolioRiskAtributionFundLevelHeatMap);

            Utility.moveToElement(PI.piRiskAttributionFundLevelHeatMapTitel);

            softAssert.assertEquals(pH.titleAndReport(PI.piRiskAttributionFundLevelHeatMapTitel, PI.piRiskAttributionFundLevelHeatMapReport, softAssert), "RISK ATTRIBUTION FUND LEVEL HEATMAP");

            pH.fundLevelHeatMapDrillDown("//*[contains(@class,'slick-cell l10 r10')]", softAssert);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPeerRiskAttributionFundLevelHeatMap");
            return false;
        }
    }


    public Boolean verifyPerformanceRank() throws IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PerformanceRank", PI.piPerformenceRiskRankReportMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piPerformenceRankTitel, PI.piPerformenceRankReport, softAssert), "PERFORMANCE RANK");

            pH.distributionDrillDown("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-3-node-0')]");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPerformanceRank");
            return false;
        }


    }

    public Boolean verifyPortfolioReturns() throws IOException {

        try {

            PI.goToPeerInsightsReportsMenu("PortfolioReturns", PI.piPortfolioReturnsReportMenu);

            softAssert.assertEquals(pH.titleAndReport(PI.piPerformenceReturnsTitel, PI.piPerformenceReturnsReport, softAssert), "PORTFOLIO RETURNS");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            takeScreenShotOnFailure("verifyPortfolioReturns");
            return false;
        }


    }


}












