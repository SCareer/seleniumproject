package com.styleanalytics.enterprise.Search;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.PeerInsights.PeerInsightsPage;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.enterprise.PeerInsights.PeerInsightsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class MetaDataTest extends EnterpriseBaseClass {


    public MetaDataPageObject metaDataPageObject;

    public PeerInsightsPage peerInsightsPage;

    String iSInLabel = property("isinLabel");

    String iSInData = property("isinData");

    String tickerLabel = property("tickerLabel");

    String tickerData = property("tickerData");

    String lastSnapshotText = property("snapShotDateText");

    String lastSnapshotData = property("snapShotDate");

    String organizationText = property("orglabelText");

    String organizationData = property("orgaizationData");

    String userReferenceData = property("userReferenceData");

    String metaDataPortfolio = property("metaDataPortfolio");

    public MetaDataTest() throws IOException {
    }


    @BeforeClass
    public void runner() throws InterruptedException, IOException {

        metaDataPageObject = new MetaDataPageObject();

        String metaDataPortfolio = property("metaDataPortfolio");

        Utility.portfolioGlobalSearch(metaDataPortfolio);


    }


    //This test is to Verifying  Database
    @Test(priority = 1)
    public void verifyDatabase() throws InterruptedException, IOException {

        SoftAssert softAssert = new SoftAssert();

        Wait.waitForSpinnerToDisappear(Driver,60);

        String pname = Driver.findElement(By.xpath("//*[@id=\"portfolioSearchPortfolioList\"]/div[4]/div[3]/div/div/div[2]")).getText();

        softAssert.assertTrue(pname.equalsIgnoreCase(metaDataPortfolio));

        softAssert.assertEquals(metaDataPortfolio, metaDataPageObject.portfolioTextOnPanel.getText(), "Portfolio Name");

        softAssert.assertEquals(metaDataPageObject.userReferenceText.getText(), "User Reference:", "User Reference Label");

        softAssert.assertEquals(userReferenceData, metaDataPageObject.userReferenceData.getText(), "User Reference data");

        softAssert.assertEquals(metaDataPageObject.isinText.getText(), "ISIN:", "ISIN label");

        softAssert.assertEquals(iSInData, metaDataPageObject.isinData.getText(), "ISIN data");

        softAssert.assertEquals(tickerLabel, metaDataPageObject.tickerText.getText(), "Ticker Label");

        softAssert.assertEquals(tickerData, metaDataPageObject.tickerData.getText(), "Ticker Data");

        softAssert.assertEquals(lastSnapshotText, metaDataPageObject.lastSnapshotLabelText.getText(), "Last snapshot Label");

        softAssert.assertEquals(lastSnapshotData, metaDataPageObject.lastSnapshotData.getText(), "Last snapshot data");

        softAssert.assertEquals(organizationText, metaDataPageObject.organisationLabelText.getText(), "Organization label");

        softAssert.assertEquals(organizationData, metaDataPageObject.organisationdata.getText(), "Organization data");

        softAssert.assertAll();

    }


    //This test is to Verifying Registration Data
    @Test(priority = 3)
    public void verifyRegistration() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(metaDataPageObject.registrationLabelText.getText(), "Registration");

        //softAssert.assertEquals(metaDataPageObject.investmentStrategyText.getText(),"Investment Strategy:");

        softAssert.assertEquals(metaDataPageObject.benchmarkLabelText.getText(), "Benchmark:");

        softAssert.assertEquals(metaDataPageObject.benchmarkData.getText(), "Morningstar Dividend Leaders TR USD");

        softAssert.assertEquals(metaDataPageObject.companyLabelText.getText(), "Company:");

        softAssert.assertEquals(metaDataPageObject.companyData.getText(), "First Trust");

        softAssert.assertEquals(metaDataPageObject.legalStructureLabelText.getText(), "Legal Structure:");

        softAssert.assertEquals(metaDataPageObject.legalStructureData.getText(), "Open Ended Investment Company");

        softAssert.assertEquals(metaDataPageObject.domicileLabelText.getText(), "Domicile:");

        softAssert.assertEquals(metaDataPageObject.domicileLabelData.getText(), "United States");

        String expectedRegistrationData = "The investment seeks investment results that correspond generally to the price and yield (before the fund's fees and expenses) of an equity index called the Morningstar® Dividend Leaders IndexSM. The fund will normally invest at least 90% of its net assets (including investment borrowings) in common stocks that comprise the index. The objective of the index is to offer investors a benchmark for dividend portfolios as well as a means to invest in a portfolio of stocks that have a consistent record of growing dividends as well as the ability to sustain them. It is non-diversified.";

        String actualRegistrationData = Driver.findElement(By.xpath("//*[@id=\"html\"]/body/div[2]/div[4]/div/div[3]/div/span[2]")).getText();

        softAssert.assertEquals(expectedRegistrationData, actualRegistrationData);

        softAssert.assertAll();
    }


    //This test is to verifying Classification Data
    @Test(priority = 4)
    public void verifyClassification() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(metaDataPageObject.classificationLabelText.getText(), "Classification");

        softAssert.assertEquals(metaDataPageObject.morningStarCategoryLabelText.getText(), "Morningstar Category:");

        // softAssert.assertEquals(metaDataPageObject.morningStarCategoryData.getText(),"Large Value");

        softAssert.assertEquals(metaDataPageObject.eTFLabelText.getText(), "ETF:");

        softAssert.assertEquals(metaDataPageObject.eTFData.getText(), "Yes");

        softAssert.assertEquals(metaDataPageObject.indexFundLabelText.getText(), "Index Fund:");

        softAssert.assertEquals(metaDataPageObject.indexFundData.getText(), "Yes");

        softAssert.assertAll();

    }


    @Test(priority = 5)
    public void verifyPeerInsightFromSearch() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(metaDataPageObject.peerInsightsLabel.getText(), "Peer Insights");

        softAssert.assertEquals(metaDataPageObject.peerGroupLabel.getText(), "Peer Group");

        softAssert.assertEquals(metaDataPageObject.providerLabel.getText(), "Provider");

        softAssert.assertEquals(metaDataPageObject.peerBenchmarkLabel.getText(), "Benchmark");

        softAssert.assertEquals(metaDataPageObject.peerReportLabel.getText(), "Report");

        softAssert.assertAll();

    }


    // @Test

    public void verifyExecutiveReports() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(metaDataPageObject.executiveReports.getText(), "Executive Reports");

        softAssert.assertEquals(metaDataPageObject.execReportLabel.getText(), "Report");

        softAssert.assertEquals(metaDataPageObject.execTemplatetLabel.getText(), "Template");

        softAssert.assertEquals(metaDataPageObject.execReportLabelsLabel.getText(), "Labels");

        softAssert.assertEquals(metaDataPageObject.execCurrencyLabel.getText(), "Currency");

        softAssert.assertAll();


    }


    // this test is to verify meta data from peer insight drill down pop up window
    @Test(priority = 7)

    public void verifyMetaDataPeerInsightOverview() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        Utility.accessPeerInsight("MetaDataTest");

        accessDrillDownPopUp();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_SummaryGrid_panGridSummaryStyleExposures\"]/div[4]/div[1]/div[2]/div/input")).sendKeys("NT QUALITY SCC US FUND - NON-LENDING");

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_SummaryGrid_panGridSummaryStyleExposures\"]/div[5]/div[3]/div/div[1]/div[1]/a")).click();

        Driver.switchTo().defaultContent();

        Driver.switchTo().frame(0);

        Thread.sleep(5000);

        String expPopUp = "NT QUALITY SCC US FUND - NON-LENDING\n" +
                "User Reference: INST-1420273\n" +
                "Last Snapshot Date: 31-Mar-2018\n" +
                "Organization: Morningstar Data\n" +
                "Registration\n" +
                "Investment Strategy: The Fund will be maintained by the Trustee with the objective of achieving long term capital appreciation. Under normal circumstances, the Fund will focus on small capitalization stocks, with some representation of microcap stocks. The Trustee will attempt to meet the Fund's return objective by investing in the instruments described herein.  To achieve its objective, the Fund employs a replication technique which generally seeks to hold each index constituent in its proportional index weight. The Fund may make limited use of futures and/or options for the purpose of maintaining equity exposure. This Fund may not participate in securities lending.\n" +
                "Benchmark: MSCI USA Small Cap GR USD\n" +
                "Company: Northern Trust\n" +
                "Legal Structure: Separate Account\n" +
                "Domicile: United States\n" +
                "Classification\n" +
                "Morningstar Category: Small Blend\n" +
                "ETF: No\n" +
                "Index Fund: No";



        String actPopUpInfo = Driver.findElement(By.xpath("//*[@id='aspnetForm']/div[3]")).getText();

        softAssert.assertEquals(expPopUp, actPopUpInfo);

        Driver.switchTo().defaultContent();

        Driver.findElement(By.xpath("//a[@class='rwCloseButton']")).click();

        softAssert.assertAll();


    }


    //This test is to Veryfing meta data from StyleSkylineFundLevel
    @Test(priority = 8)
    public void verifyMetaDataStyleSkylineFundLevel() throws IOException, InterruptedException {


        accessReportAndVerify(metaDataPageObject.styleExposureMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl01_rptChapterPages_ctl02_hlPage']");

    }


    //This test is to Veryfing meta data from StyleSkylineFundLevelHeatMap
    @Test(priority = 9)
    public void verifyMetaDataStyleSkylineFundLevelHeatMap() throws IOException, InterruptedException {


        accessReportAndVerify(metaDataPageObject.styleExposureMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl01_rptChapterPages_ctl03_hlPage']");

    }


    // This test to verifying Meta data Style Distribution Fund leval
    @Test(priority = 10)
    public void verifyMetaDataStyleDistributionFundLeval() throws IOException, InterruptedException {

        accessReportAndVerify(metaDataPageObject.sTyleDistributionMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl02_hlPage']");

    }


    // This test to verifying Meta data Size Distribution fund leval HeatMap
    @Test(priority = 11)
    public void verifyMetaDataStyleDistributionFundLevalHeatMap() throws IOException, InterruptedException {

        accessReportAndVerify(metaDataPageObject.sTyleDistributionMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl03_hlPage']");

    }


    // This test to verifying Meta data Size Distribution Fund Leval
    @Test(priority = 12)
    public void verifyMetaDataSizeDistributionFundLaval() throws IOException, InterruptedException {

        accessReportAndVerify(metaDataPageObject.sTyleDistributionMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl02_hlPage']");
    }


    // This test to verifying Meta data Size Distribution HeatMap
    @Test(priority = 13)
    public void verifyMetaDataSizeDistributionFundLavalHeatMaps() throws IOException, InterruptedException {

        accessReportAndVerify(metaDataPageObject.sTyleDistributionMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl03_hlPage']");

    }


    // This test to verifying Meta data Country Distribution
    @Test(priority = 14)
    public void verifyMetaDataCountryDistribution() throws IOException, InterruptedException {

        accessReportAndVerify(metaDataPageObject.sTyleDistributionMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl02_hlPage']");


    }


    // This test to verifying Meta data Country Distribution HeatMap
    @Test(priority = 15)
    public void verifyMetaDataCountryDistributionHeatMap() throws IOException, InterruptedException {

        accessReportAndVerify(metaDataPageObject.sTyleDistributionMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl03_hlPage']");

    }


    // This test to verifying Meta data Sector Distribution drill downs
    @Test(priority = 16)
    public void verifyMetaDataSectorDistribution() throws IOException, InterruptedException {

        accessReportAndVerify(metaDataPageObject.sTyleDistributionMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl02_hlPage']");

    }


    // This test to verifying Meta data Sector Distribution HeatMap
    @Test(priority = 17)
    public void verifyMetaDataSectorDistributionHeatMap() throws IOException, InterruptedException {

        accessReportAndVerify(metaDataPageObject.sTyleDistributionMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl03_hlPage']");

    }


    //This Test is to verify Meta data from RiskAtribution FundLeval drill down pop up
    @Test(priority = 18)
    public void verifyRiskAtributionFundLeval() throws IOException, InterruptedException {

        accessReportAndVerify(metaDataPageObject.peerInsightRiskMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl03_hlPage']");

    }


    //This Test is to verify Risk measures FundLeval HeatMap drill down pop up
    @Test(priority = 19)
    public void verifyRiskMeasuresFundLevalHeatMap() throws IOException, InterruptedException {

        accessReportAndVerify(metaDataPageObject.peerInsightRiskMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl04_hlPage']");

    }

    //This Test is to verify RiskAtribution FundLeval HeatMap drill down pop up
    @Test(priority = 20)
    public void verifyRiskAtributionFundLevalHeatMap() throws IOException, InterruptedException {


        accessReportAndVerify(metaDataPageObject.peerInsightRiskMainMenu,"//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl05_hlPage']");

    }



    public void accessReportAndVerify(WebElement element,String xpath) throws IOException, InterruptedException {



        SoftAssert softAssert = new SoftAssert();

        accessToReport(element,xpath);

        List<WebElement> infoList = Driver.findElements(By.xpath("//div[contains(@class,'r1 ')]/a"));

        softAssert.assertEquals(infoList.get(0).isDisplayed(), true); //Verifying Icon

        infoList.get(0).click();

        Driver.switchTo().frame(0);

        Thread.sleep(5000);

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[3]/h2")).getText(), "ATLAS ENHANCED 500");

        String expMetaData = "ATLAS ENHANCED 500\n" +
                "User Reference: INST-1077713\n" +
                "Last Snapshot Date: 31-Mar-2018\n" +
                "Organization: Morningstar Data\n" +
                "Registration\n" +
                "Investment Strategy: The Atlas Enhanced 500 portfolio is an enhanced index comprised of only those names within each sector of the S&P 500 that score highest based on Atlas's factor model analysis. Value, momentum, and short-term reversal are the factors used. Size limitations combat the problems inherent to cap-weighted indexes. The e500 strategy stands out in that it is a multi-factor strategy; there is careful choice of which factors to include and how these factors are defined. Factors are applied at both stock and sector level, over-concentration in stocks or sectors is avoided; trading costs are managed; and tax is optimized for taxable investors.\n" +
                "Benchmark:\n" +
                "Company: Atlas Capital Advisors\n" +
                "Legal Structure: Separate Account\n" +
                "Domicile: United States\n" +
                "Classification\n" +
                "Morningstar Category: Large Blend\n" +
                "ETF: No\n" +
                "Index Fund: No";

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[3]")).getText(), expMetaData);

        Driver.switchTo().defaultContent();

        Driver.findElement(By.xpath("//a[@class='rwCloseButton']")).click();

        softAssert.assertAll();

    }

    //This is reusable test Script to access Peerinsight overview drill down pop up

    public void accessDrillDownPopUp() throws IOException, InterruptedException {


        Driver.findElement(By.xpath("//area[contains(@id,'_1000_chartDiv-graph-id1-plotset-plot-1-node-0')]")).click();

        Wait.waitForSquareBoxesToDisappear(Driver,60);

        Driver.switchTo().frame(0);

    }


    public void accessToReport() throws IOException, InterruptedException {


        metaDataPageObject.styleExposureMainMenu.click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//a[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl01_rptChapterPages_ctl03_hlPage']")).click();

        Wait.forGridToLoad(Driver,60);



    }

    public void accessToReport(WebElement mainMenu,String xpathForSubMenu) throws InterruptedException {


        Actions actions = new Actions(Driver);

        actions.moveToElement(mainMenu).build().perform();

        Thread.sleep(3000);

        Driver.findElement(By.xpath(xpathForSubMenu)).click();

        Utility.moveToElement("//*[@id=\"iconSearch\"]");

        Wait.forGridToLoad(Driver,60);

    }






}





