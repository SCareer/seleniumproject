package com.styleanalytics.enterprise.PeerInsights;

import com.styleanalytics.enterprise.DataDriven.DataDrivenSetup;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Sharing.SharingHelpers;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Sharing.SharingHelpers;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class FundReport extends TestBase {

    public PeerInsightsPage peerInsightsPage;
    public SoftAssert softAssert;
    private String peerInsightsReport;
    private String portfolioName;
    private String scenario;
    private String testExecution;

    private String OtherUser = property("sharedUser");
    private String Pwd = property("sharedUserPass");

    WebDriver driver;


    @Factory(dataProvider = "data")
    public FundReport(String peerInsightsReport, String portfolioName, String scenario, String testExecution) throws IOException {

        this.peerInsightsReport = peerInsightsReport;

        this.portfolioName = portfolioName;

        this.scenario = scenario;

        this.testExecution = testExecution;

    }

    public FundReport() throws IOException {

    }

    @DataProvider
    public static Object[][] data() throws IOException {

        String testDataFile = property("TestData");

        Object[][] arrayObject = DataDrivenSetup.readFromExcel(testDataFile, "PIFundReport");

        return arrayObject;

    }


    public void checkExecution() {

        if (testExecution.equalsIgnoreCase("No")) {
            throw new SkipException("Test skipped as data is:" + scenario);
        }


    }


    @BeforeClass
    public void openPeerGroup() throws IOException, InterruptedException {

        System.out.println("----" + peerInsightsReport + " " + portfolioName + " " + scenario + " " + testExecution + "-----");

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login();

        peerInsightsPage = new PeerInsightsPage(getDriver());

        driver = getDriver();

    }


    public void goToFundReportsMenu(String mainMenu, WebElement reportSubMenu) throws InterruptedException {

        Actions actions = new Actions(driver);

        if (mainMenu.equalsIgnoreCase("Overview")) {

            actions.moveToElement(peerInsightsPage.overViewMenu).build().perform();
            //peerInsightsPage.overViewMenu.click();

        } else if (mainMenu.equalsIgnoreCase("StyleExposureTiltHeatMap") || mainMenu.equalsIgnoreCase("StyleExposureSummary") || mainMenu.equalsIgnoreCase("StyleExposureRange")) {

            actions.moveToElement(peerInsightsPage.piFundReportstyleExposureMainMenu).build().perform();
            //peerInsightsPage.piFundReportstyleExposureMainMenu.click();

        } else if (mainMenu.equalsIgnoreCase("DistributionRegion") ||
                mainMenu.equalsIgnoreCase("DistributionCountry") ||
                mainMenu.equalsIgnoreCase("DistributionSector") ||
                mainMenu.equalsIgnoreCase("DistributionSize") ||
                mainMenu.equalsIgnoreCase("DistributionSizeHistory") ||
                mainMenu.equalsIgnoreCase("DistributionStyle")) {

            actions.moveToElement(peerInsightsPage.piFundReportDistributionMenu).build().perform();

            //peerInsightsPage.piFundReportDistributionMenu.click();

        } else if (mainMenu.equalsIgnoreCase("RiskOverview") || mainMenu.equalsIgnoreCase("RiskSecurityDetails")) {

            actions.moveToElement(peerInsightsPage.piFundReportRiskMenu).build().perform();

            //peerInsightsPage.piFundReportRiskMenu.click();
        }

        Thread.sleep(3000);

        reportSubMenu.click();

        Thread.sleep(20000);

        // Utility.waitForElementToDisplay("pageTitle");

        Actions moveCursorToHideMenu = new Actions(driver);

        moveCursorToHideMenu.moveToElement(driver.findElement(By.xpath("//*[@id=\"labSnapshotDate\"]"))).build().perform();

    }


    public boolean verifyFundReportBlock(String reportSection, WebElement reportsSubMenu, String title, WebElement actualTitle, WebElement actualReport) throws IOException, InterruptedException {

        if (reportSection.equalsIgnoreCase("StyleExposureSummary")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "Summary");

        } else if (reportSection.equalsIgnoreCase("StyleExposureRange")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "Range");

        } else if (reportSection.equalsIgnoreCase("StyleExposureTiltHeatMap")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "TILT HEATMAP");

        } else if (reportSection.equalsIgnoreCase("DistributionRegion")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "REGION OVERVIEW");

        } else if (reportSection.equalsIgnoreCase("DistributionCountry")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "COUNTRY OVERVIEW");

        } else if (reportSection.equalsIgnoreCase("DistributionSector")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "SECTOR OVERVIEW");

        } else if (reportSection.equalsIgnoreCase("DistributionSize")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "SIZE DISTRIBUTION OVERVIEW");

        } else if (reportSection.equalsIgnoreCase("DistributionStyle")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "STYLE DISTRIBUTION OVERVIEW");

        } else if (reportSection.equalsIgnoreCase("DistributionSizeHistory")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "SIZE DISTRIBUTION HISTORY");

        } else if (reportSection.equalsIgnoreCase("RiskOverview")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "RISK OVERVIEW");

        } else if (reportSection.equalsIgnoreCase("RiskSecurityDetails")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "SECURITY DETAIL");

        } else if (reportSection.equalsIgnoreCase("Overview")) {

            checkNavigateToReport(reportSection, reportsSubMenu, "Overview");

        }

        try {

            softAssert.assertEquals(actualTitle.getText(), title);

            softAssert.assertTrue(actualReport.isEnabled());

            return true;

        } catch (Exception e) {

            System.out.println("Failed to Display Report tile & Report for: " + reportSection);

            return false;
        }


    }


    public void checkNavigateToReport(String reportSection, WebElement reportsSubMenu, String pageTitle) throws InterruptedException {

        String pTitle = driver.findElement(By.className("pageTitle")).getText();

        if (!pTitle.equalsIgnoreCase(pageTitle)) {
            goToFundReportsMenu(reportSection, reportsSubMenu);
        }

    }
    

    @Test
    public void verifyMorningStarPortfolio() throws Exception {

        checkExecution();

        if ((scenario.equalsIgnoreCase("MorningStarWithOutAccessNoStockLevel"))
                || (scenario.equalsIgnoreCase("YouOwnPortfolioWithOutAccess"))
                || (scenario.equalsIgnoreCase("MorningStarWithOutAccessStockLevel"))) {

            logInAsWithoutAccessUser();

            peerInsightsPage.goToPeerInsightLandingPage(getURL());
            peerInsightsPage.accessPeerInsight(peerInsightsReport);
            peerInsightsPage.openFundReport(portfolioName);

        } else {

            peerInsightsPage.goToPeerInsightLandingPage(getURL());
            peerInsightsPage.accessPeerInsight(peerInsightsReport);
            peerInsightsPage.openFundReport(portfolioName);
        }

        if (testExecution.equalsIgnoreCase("Yes")) {

            if (scenario.equalsIgnoreCase("MorningStarWithAccess")
                    || scenario.equalsIgnoreCase("YouOwnPortfolioWithAccess")
                    || scenario.equalsIgnoreCase("MorningStarWithOutAccessStockLevel")
                    || scenario.equalsIgnoreCase("YouOwnPortfolioWithOutAccess")) {

                System.out.println("Scenario Started: " + peerInsightsReport);
                softAssert = new SoftAssert();
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "STYLE SKYLINE" + "\u2122", peerInsightsPage.piFundReportStyleSkyLineTitle, peerInsightsPage.piFundReportStyleSkyLineReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "REGION DISTRIBUTION", peerInsightsPage.piFundReportRegionDistributionTitle, peerInsightsPage.piFundReportRegionDistributionReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "SECTOR DISTRIBUTION", peerInsightsPage.piFundReportSectorDistributionTitle, peerInsightsPage.piFundReportSectorDistributionReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "STYLE DISTRIBUTION", peerInsightsPage.piFundReportStyleDistributionTitle, peerInsightsPage.piFundReportStyleDistributionReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "SIZE DISTRIBUTION", peerInsightsPage.piFundReportSizeDistributionTitle, peerInsightsPage.piFundReportSizeDistributionReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "RISK ESTIMATES", peerInsightsPage.piFundReportRiskEstimatesTitle, peerInsightsPage.piFundReportRiskEstimatesReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "RISK ATTRIBUTION", peerInsightsPage.piFundReportRiskAttributionTitle, peerInsightsPage.piFundReportRiskAttributionReport));

                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "HOLDINGS BY ASSET", peerInsightsPage.piFundReportHoldingsByAssetTitle, peerInsightsPage.piFundReportHoldingsByAssetReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "TOP RISK CONTRIBUTORS", peerInsightsPage.piFundReportTopRiskContributorsTitle, peerInsightsPage.piFundReportTopRiskContributorsReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "LARGEST OVERWEIGHTS", peerInsightsPage.piFundReportLargestOverWeightsTitle, peerInsightsPage.piFundReportLargestOverWeightsReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "LARGEST UNDERWEIGHTS", peerInsightsPage.piFundReportLargestUnderWeightsTitle, peerInsightsPage.piFundReportLargesUnderWeightsReport));

                softAssert.assertTrue(verifyFundReportBlock("StyleExposureSummary", peerInsightsPage.styleExposureSummaryReport, "PORTFOLIO STYLE SKYLINE" + "\u2122", peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineTitle, peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineBlock));
                softAssert.assertTrue(verifyFundReportBlock("StyleExposureSummary", peerInsightsPage.styleExposureSummaryReport, "PORTFOLIO STYLE SKYLINE" + "\u2122" + " SECTOR ADJUSTED", peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineSectorAdjustedTitle, peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineSectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("StyleExposureSummary", peerInsightsPage.styleExposureSummaryReport, "PORTFOLIO STYLE SKYLINE" + "\u2122" + " COUNTRY ADJUSTED", peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineCountryAdjustedTitle, peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineCountryAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("StyleExposureSummary", peerInsightsPage.styleExposureSummaryReport, "PORTFOLIO STYLE SKYLINE" + "\u2122" + " COUNTRY AND SECTOR ADJUSTED", peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineSectorAndCountryAdjustedTitle, peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineSectorAndCountryAdjustedBlock));

                softAssert.assertTrue(verifyFundReportBlock("StyleExposureRange", peerInsightsPage.styleExposureRangeReport, "STYLE SKYLINE" + "\u2122" + " RANGE", peerInsightsPage.piFundReportStyleExposureStyleSkylineRangeTitle, peerInsightsPage.piFundReportStyleExposureStyleSkylineRangeBlock));
                softAssert.assertTrue(verifyFundReportBlock("StyleExposureTiltHeatMap", peerInsightsPage.styleExposureTiltHeatMapReport, "TILT HEATMAP", peerInsightsPage.piFundReportStyleTiltHeatMapTitle, peerInsightsPage.piFundReportStyleTiltHeatMapBlock));

                softAssert.assertTrue(verifyFundReportBlock("DistributionRegion", peerInsightsPage.distribtuionRegionOverview, "REGION DISTRIBUTION", peerInsightsPage.piFundReportDistributionRegionDistributionTitle, peerInsightsPage.piFundReportDistributionRegionDistributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionRegion", peerInsightsPage.distribtuionRegionOverview, "REGION RANGE", peerInsightsPage.piFundReportDistributionRegionRangeTitle, peerInsightsPage.piFundReportDistributionRegionRangeBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionRegion", peerInsightsPage.distribtuionRegionOverview, "REGION TRAILS", peerInsightsPage.piFundReportDistributionRegionTrailsTitle, peerInsightsPage.piFundReportDistributionRegionTrailsBlock));

                softAssert.assertTrue(verifyFundReportBlock("DistributionCountry", peerInsightsPage.distribtuionCountryOverview, "COUNTRY DISTRIBUTION", peerInsightsPage.piFundReportDistributionCountryDistributionTitle, peerInsightsPage.piFundReportDistributionCountryDistributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionCountry", peerInsightsPage.distribtuionCountryOverview, "COUNTRY RANGE", peerInsightsPage.piFundReportDistributionCountryRangeTitle, peerInsightsPage.piFundReportDistributionCountryRangeBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionCountry", peerInsightsPage.distribtuionCountryOverview, "COUNTRY TRAILS", peerInsightsPage.piFundReportDistributionCountryTrailsTitle, peerInsightsPage.piFundReportDistributionCountryTrailsBlock));

                softAssert.assertTrue(verifyFundReportBlock("DistributionSector", peerInsightsPage.distribtuionSectorOverview, "SECTOR DISTRIBUTION", peerInsightsPage.piFundReportDistributionSectorDistributionTitle, peerInsightsPage.piFundReportDistributionSectorDistributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSector", peerInsightsPage.distribtuionSectorOverview, "SECTOR RANGE", peerInsightsPage.piFundReportDistributionSectorRangeTitle, peerInsightsPage.piFundReportDistributionSectorRangeBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSector", peerInsightsPage.distribtuionSectorOverview, "SECTOR TRAILS", peerInsightsPage.piFundReportDistributionSectorTrailsTitle, peerInsightsPage.piFundReportDistributionSectorTrailsBlock));

                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "SIZE DISTRIBUTION", peerInsightsPage.piFundReportSizeDistributionSizeDistributionTitle, peerInsightsPage.piFundReportSizeDistributionSizeDistributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "DISTRIBUTION DETAILS", peerInsightsPage.piFundReportSizeDistributionDistributionDetailsTitle, peerInsightsPage.piFundReportSizeDistributionDistributionDetailsBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "SIZE DISTRIBUTION SECTOR ADJUSTED", peerInsightsPage.piFundReportSizeDistributionSectorAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionSectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "DISTRIBUTION DETAILS SA", peerInsightsPage.piFundReportSizeDistributionDistributionDetailsSATitle, peerInsightsPage.piFundReportSizeDistributionDistributionDetailsSABlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "SIZE DISTRIBUTION COUNTRY ADJUSTED", peerInsightsPage.piFundReportSizeDistributionSizeDistributionCountryAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionSizeDistributionCountryAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "DISTRIBUTION DETAILS CA", peerInsightsPage.piFundReportSizeDistributionSizeDistributionDetailsCATitle, peerInsightsPage.piFundReportSizeDistributionSizeDistributionDetailsCABlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "SIZE DISTRIBUTION COUNTRY AND SECTOR ADJUSTED", peerInsightsPage.piFundReportSizeDistributionSizeDistributionCountrySectorAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionSizeDistributionCountrySectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "SIZE DISTRIBUTION DETAILS CASA", peerInsightsPage.piFundReportSizeDistributionSizeDistributionDetailsCASATitle, peerInsightsPage.piFundReportSizeDistributionSizeDistributionDetailsCASABlock));

                softAssert.assertTrue(verifyFundReportBlock("DistributionSizeHistory", peerInsightsPage.distribtuionSizeHistoryOverview, "SIZE DISTRIBUTION TRAILS", peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsTitle, peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSizeHistory", peerInsightsPage.distribtuionSizeHistoryOverview, "SIZE DISTRIBUTION TRAILS SECTOR ADJUSTED", peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsSectorAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsSectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSizeHistory", peerInsightsPage.distribtuionSizeHistoryOverview, "SIZE DISTRIBUTION TRAILS COUNTRY ADJUSTED", peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSizeHistory", peerInsightsPage.distribtuionSizeHistoryOverview, "SIZE DISTRIBUTION TRAILS COUNTRY AND SECTOR ADJUSTED", peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAndSectorAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAndSectorAdjustedBlock));

                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "STYLE DISTRIBUTION", peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionTitle, peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "DISTRIBUTION DETAILS", peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsTitle, peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "STYLE DISTRIBUTION SECTOR ADJUSTED", peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionSectorAdjustedTitle, peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionSectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "DISTRIBUTION DETAILS SA", peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsSATitle, peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsSABlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "STYLE DISTRIBUTION COUNTRY ADJUSTED", peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionCountryAdjustedTitle, peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionCountryAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "DISTRIBUTION DETAILS CA", peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsCATitle, peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsCABlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "STYLE DISTRIBUTION COUNTRY AND SECTOR ADJUSTED", peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionCountryAndSectorAdjustedTitle, peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionCountryAndSectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "DISTRIBUTION DETAILS CASA", peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsCASATitle, peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsCASABlock));

                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "RISK ATTRIBUTION", peerInsightsPage.piFundReportRiskRiskAttributionTitle, peerInsightsPage.piFundReportRiskRiskAttributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "RISK ESTIMATES", peerInsightsPage.piFundReportRiskRiskEstimatesTitle, peerInsightsPage.piFundReportRiskRiskEstimatesBlock));
                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "HOLDINGS BY ASSET", peerInsightsPage.piFundReportRiskHoldingsByAssetTitle, peerInsightsPage.piFundReportRiskHoldingsByAssetBlock));
                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "TRACKING ERROR HISTORY", peerInsightsPage.piFundReportRiskTrackingErrorTitle, peerInsightsPage.piFundReportRiskTrackingErrorBlock));

                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "RISK RANGE HISTORY", peerInsightsPage.piFundReportRiskRangeHistoryTitle, peerInsightsPage.piFundReportRiskRangeHistoryBlock));

                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "RISK BY STYLE", peerInsightsPage.piFundReportRiskByStyleTitle, peerInsightsPage.piFundReportRiskByStyleBlock));
                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "TOP RISK CONTRIBUTORS", peerInsightsPage.piFundReportRiskTopRiskContributorsTitle, peerInsightsPage.piFundReportRiskTopRiskContributorsBlock));

                softAssert.assertTrue(verifyFundReportBlock("RiskSecurityDetails", peerInsightsPage.riskSecurityDetailsReport, "LARGEST ABSOLUTE WEIGHT", peerInsightsPage.piFundReportRiskSecurityLargestAbsoluteWeightTitle, peerInsightsPage.piFundReportRiskSecurityLargestAbsoluteWeightBlock));
                softAssert.assertTrue(verifyFundReportBlock("RiskSecurityDetails", peerInsightsPage.riskSecurityDetailsReport, "LARGEST OVERWEIGHT", peerInsightsPage.piFundReportRisSecurityLargestOverWeightTitle, peerInsightsPage.piFundReportRiskSecurityLargestOverWeightBlock));
                softAssert.assertTrue(verifyFundReportBlock("RiskSecurityDetails", peerInsightsPage.riskSecurityDetailsReport, "LARGEST UNDERWEIGHT", peerInsightsPage.piFundReportRiskSecurityLargestUnderWeightTitle, peerInsightsPage.piFundReportRiskSecurityLargestUnderWeightBlock));
                softAssert.assertAll();

                System.out.println("Scenario Completed: " + peerInsightsReport);

            } else if (scenario.equalsIgnoreCase("LipperWithAccess")
                    || scenario.equalsIgnoreCase("MorningStarWithOutAccessNoStockLevel")
                    || scenario.equalsIgnoreCase("LipperWithoutAccess")) {

                System.out.println("Scenario Started: " + peerInsightsReport);
                softAssert = new SoftAssert();
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "STYLE SKYLINE" + "\u2122", peerInsightsPage.piFundReportStyleSkyLineTitle, peerInsightsPage.piFundReportStyleSkyLineReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "REGION DISTRIBUTION", peerInsightsPage.piFundReportRegionDistributionTitle, peerInsightsPage.piFundReportRegionDistributionReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "SECTOR DISTRIBUTION", peerInsightsPage.piFundReportSectorDistributionTitle, peerInsightsPage.piFundReportSectorDistributionReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "STYLE DISTRIBUTION", peerInsightsPage.piFundReportStyleDistributionTitle, peerInsightsPage.piFundReportStyleDistributionReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "SIZE DISTRIBUTION", peerInsightsPage.piFundReportSizeDistributionTitle, peerInsightsPage.piFundReportSizeDistributionReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "RISK ESTIMATES", peerInsightsPage.piFundReportRiskEstimatesTitle, peerInsightsPage.piFundReportRiskEstimatesReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "RISK ATTRIBUTION", peerInsightsPage.piFundReportRiskAttributionTitle, peerInsightsPage.piFundReportRiskAttributionReport));
                softAssert.assertTrue(verifyFundReportBlock("Overview", peerInsightsPage.overViewSubMenu, "HOLDINGS BY ASSET", peerInsightsPage.piFundReportHoldingsByAssetTitle, peerInsightsPage.piFundReportHoldingsByAssetReport));

                softAssert.assertTrue(verifyFundReportBlock("StyleExposureSummary", peerInsightsPage.styleExposureSummaryReport, "PORTFOLIO STYLE SKYLINE" + "\u2122", peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineTitle, peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineBlock));
                softAssert.assertTrue(verifyFundReportBlock("StyleExposureSummary", peerInsightsPage.styleExposureSummaryReport, "PORTFOLIO STYLE SKYLINE" + "\u2122" + " SECTOR ADJUSTED", peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineSectorAdjustedTitle, peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineSectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("StyleExposureSummary", peerInsightsPage.styleExposureSummaryReport, "PORTFOLIO STYLE SKYLINE" + "\u2122" + " COUNTRY ADJUSTED", peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineCountryAdjustedTitle, peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineCountryAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("StyleExposureSummary", peerInsightsPage.styleExposureSummaryReport, "PORTFOLIO STYLE SKYLINE" + "\u2122" + " COUNTRY AND SECTOR ADJUSTED", peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineSectorAndCountryAdjustedTitle, peerInsightsPage.piFundReportStyleExposurePortfolioStyleSkylineSectorAndCountryAdjustedBlock));

                softAssert.assertTrue(verifyFundReportBlock("StyleExposureRange", peerInsightsPage.styleExposureRangeReport, "STYLE SKYLINE" + "\u2122" + " RANGE", peerInsightsPage.piFundReportStyleExposureStyleSkylineRangeTitle, peerInsightsPage.piFundReportStyleExposureStyleSkylineRangeBlock));
                softAssert.assertTrue(verifyFundReportBlock("StyleExposureTiltHeatMap", peerInsightsPage.styleExposureTiltHeatMapReport, "TILT HEATMAP", peerInsightsPage.piFundReportStyleTiltHeatMapTitle, peerInsightsPage.piFundReportStyleTiltHeatMapBlock));

                softAssert.assertTrue(verifyFundReportBlock("DistributionRegion", peerInsightsPage.distribtuionRegionOverview, "REGION DISTRIBUTION", peerInsightsPage.piFundReportDistributionRegionDistributionTitle, peerInsightsPage.piFundReportDistributionRegionDistributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionRegion", peerInsightsPage.distribtuionRegionOverview, "REGION RANGE", peerInsightsPage.piFundReportDistributionRegionRangeTitle, peerInsightsPage.piFundReportDistributionRegionRangeBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionRegion", peerInsightsPage.distribtuionRegionOverview, "REGION TRAILS", peerInsightsPage.piFundReportDistributionRegionTrailsTitle, peerInsightsPage.piFundReportDistributionRegionTrailsBlock));


                softAssert.assertTrue(verifyFundReportBlock("DistributionCountry", peerInsightsPage.distribtuionCountryOverview, "COUNTRY DISTRIBUTION", peerInsightsPage.piFundReportDistributionCountryDistributionTitle, peerInsightsPage.piFundReportDistributionCountryDistributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionCountry", peerInsightsPage.distribtuionCountryOverview, "COUNTRY RANGE", peerInsightsPage.piFundReportDistributionCountryRangeTitle, peerInsightsPage.piFundReportDistributionCountryRangeBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionCountry", peerInsightsPage.distribtuionCountryOverview, "COUNTRY TRAILS", peerInsightsPage.piFundReportDistributionCountryTrailsTitle, peerInsightsPage.piFundReportDistributionCountryTrailsBlock));


                softAssert.assertTrue(verifyFundReportBlock("DistributionSector", peerInsightsPage.distribtuionSectorOverview, "SECTOR DISTRIBUTION", peerInsightsPage.piFundReportDistributionSectorDistributionTitle, peerInsightsPage.piFundReportDistributionSectorDistributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSector", peerInsightsPage.distribtuionSectorOverview, "SECTOR RANGE", peerInsightsPage.piFundReportDistributionSectorRangeTitle, peerInsightsPage.piFundReportDistributionSectorRangeBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSector", peerInsightsPage.distribtuionSectorOverview, "SECTOR TRAILS", peerInsightsPage.piFundReportDistributionSectorTrailsTitle, peerInsightsPage.piFundReportDistributionSectorTrailsBlock));


                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "SIZE DISTRIBUTION", peerInsightsPage.piFundReportSizeDistributionSizeDistributionTitle, peerInsightsPage.piFundReportSizeDistributionSizeDistributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "DISTRIBUTION DETAILS", peerInsightsPage.piFundReportSizeDistributionDistributionDetailsTitle, peerInsightsPage.piFundReportSizeDistributionDistributionDetailsBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "SIZE DISTRIBUTION SECTOR ADJUSTED", peerInsightsPage.piFundReportSizeDistributionSectorAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionSectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "DISTRIBUTION DETAILS SA", peerInsightsPage.piFundReportSizeDistributionDistributionDetailsSATitle, peerInsightsPage.piFundReportSizeDistributionDistributionDetailsSABlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "SIZE DISTRIBUTION COUNTRY ADJUSTED", peerInsightsPage.piFundReportSizeDistributionSizeDistributionCountryAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionSizeDistributionCountryAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "DISTRIBUTION DETAILS CA", peerInsightsPage.piFundReportSizeDistributionSizeDistributionDetailsCATitle, peerInsightsPage.piFundReportSizeDistributionSizeDistributionDetailsCABlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "SIZE DISTRIBUTION COUNTRY AND SECTOR ADJUSTED", peerInsightsPage.piFundReportSizeDistributionSizeDistributionCountrySectorAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionSizeDistributionCountrySectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSize", peerInsightsPage.distribtuionSizeOverview, "SIZE DISTRIBUTION DETAILS CASA", peerInsightsPage.piFundReportSizeDistributionSizeDistributionDetailsCASATitle, peerInsightsPage.piFundReportSizeDistributionSizeDistributionDetailsCASABlock));


                softAssert.assertTrue(verifyFundReportBlock("DistributionSizeHistory", peerInsightsPage.distribtuionSizeHistoryOverview, "SIZE DISTRIBUTION TRAILS", peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsTitle, peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSizeHistory", peerInsightsPage.distribtuionSizeHistoryOverview, "SIZE DISTRIBUTION TRAILS SECTOR ADJUSTED", peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsSectorAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsSectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSizeHistory", peerInsightsPage.distribtuionSizeHistoryOverview, "SIZE DISTRIBUTION TRAILS COUNTRY ADJUSTED", peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionSizeHistory", peerInsightsPage.distribtuionSizeHistoryOverview, "SIZE DISTRIBUTION TRAILS COUNTRY AND SECTOR ADJUSTED", peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAndSectorAdjustedTitle, peerInsightsPage.piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAndSectorAdjustedBlock));

                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "STYLE DISTRIBUTION", peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionTitle, peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "DISTRIBUTION DETAILS", peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsTitle, peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "STYLE DISTRIBUTION SECTOR ADJUSTED", peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionSectorAdjustedTitle, peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionSectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "DISTRIBUTION DETAILS SA", peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsSATitle, peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsSABlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "STYLE DISTRIBUTION COUNTRY ADJUSTED", peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionCountryAdjustedTitle, peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionCountryAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "DISTRIBUTION DETAILS CA", peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsCATitle, peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsCABlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "STYLE DISTRIBUTION COUNTRY AND SECTOR ADJUSTED", peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionCountryAndSectorAdjustedTitle, peerInsightsPage.piFundReportStyleDistributionOverViewStyleDistributionCountryAndSectorAdjustedBlock));
                softAssert.assertTrue(verifyFundReportBlock("DistributionStyle", peerInsightsPage.distribtuionStyleOverview, "DISTRIBUTION DETAILS CASA", peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsCASATitle, peerInsightsPage.piFundReportStyleDistributionOverViewDistributionDetailsCASABlock));

                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "RISK ATTRIBUTION", peerInsightsPage.piFundReportRiskRiskAttributionTitle, peerInsightsPage.piFundReportRiskRiskAttributionBlock));
                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "RISK ESTIMATES", peerInsightsPage.piFundReportRiskRiskEstimatesTitle, peerInsightsPage.piFundReportRiskRiskEstimatesBlock));
                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "HOLDINGS BY ASSET", peerInsightsPage.piFundReportRiskHoldingsByAssetTitle, peerInsightsPage.piFundReportRiskHoldingsByAssetBlock));
                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "TRACKING ERROR HISTORY", peerInsightsPage.piFundReportRiskTrackingErrorTitle, peerInsightsPage.piFundReportRiskTrackingErrorBlock));
                softAssert.assertTrue(verifyFundReportBlock("RiskOverview", peerInsightsPage.riskOverviewReport, "RISK BY STYLE", peerInsightsPage.piFundReportRiskByStyleTitle, peerInsightsPage.piFundReportRiskByStyleBlock));
                softAssert.assertAll();

                System.out.println("Scenario Completed: " + peerInsightsReport);

            } else if (scenario.equalsIgnoreCase("yourOwnFailure")) {

                try {
                    WebElement failureMsgElement = driver.findElement(By.xpath("//*[@id=\"divReportPane\"]/div"));
                    Assert.assertEquals(failureMsgElement.getText(), "There is no analysis for this portfolio at the requested date. This could be because there are no holdings available for this portfolio at this particular point in time.");
                } catch (Exception e) {

                    System.out.println("Failed to display the Message: " + e);
                }

            }
        }
    }


    public void logInAsWithoutAccessUser() throws IOException, InterruptedException {


        String OtherUser = property("sharedUser");
        String Pwd = property("sharedUserPass");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logout();
        loginPage.login(OtherUser, Pwd);


    }


}















































