package com.styleanalytics.enterprise.TemplateBuilder;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.Waits;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.io.IOException;
import java.util.List;

import static com.styleanalytics.enterprise.automation.JsonCompare.getClipBoard;

/**
 * Created by Viswanath on 01/06/2018.
 */
public class PDFBlockSettings extends EnterpriseBaseClass {

    TemplateBuilderPage templateBuilderPage;
    GoTo goTo=new GoTo();
    SoftAssert softAssert;

    @BeforeClass
    public void testSetup() throws IOException, InterruptedException {

        goTo.goToTemplates();

        templateBuilderPage = new TemplateBuilderPage();

        softAssert = new SoftAssert();

        templateBuilderPage.newTemplateButton.click();

        templateBuilderPage.newPDFTemplateForPortfolios.click();


    }

    @Test
    public void styleSkyline() {

        SoftAssert softAssert = new SoftAssert();

        expandStyleExposure();

        openBlockAndVerifyTitle("Style Skyline");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(factors("23 factors selected"));

        softAssert.assertTrue(dataSeries());

        softAssert.assertTrue(showFactorCategoryLabels());

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void styleRange() {

        SoftAssert softAssert = new SoftAssert();

        expandStyleExposure();

        openBlockAndVerifyTitle("Style Skyline Range");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(factors("23 factors selected"));

        softAssert.assertTrue(dataSeries());

        softAssert.assertTrue(verifyLabelAndCheckBox("Append date range to page title:",
                templateBuilderPage.appendDateRangeOnTitle,
                templateBuilderPage.appendDateRangeOnTitleCheckBox,
                false));

        softAssert.assertTrue(showFactorCategoryLabels());

        softAssert.assertTrue(formatting());

        softAssert.assertAll();



    }

    public void openBlockAndVerifyTitle(String blockTitle){

        templateBuilderPage = new TemplateBuilderPage();

        Driver.findElement(By.xpath("//*[contains(text(),'"+blockTitle+"')]")).click();

        templateBuilderPage.block.click();

        templateBuilderPage.openBlockProperties.click();

        Waits waits = new Waits();

        waits.waitForVisibilityOfElement(templateBuilderPage.blockTitleLabel, 5);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(blockTitleCheck(blockTitle));

        softAssert.assertAll();

    }

    @Test
    public void factorDataValue(){

        SoftAssert softAssert = new SoftAssert();

        expandStyleExposure();

        openBlockAndVerifyTitle("Factor Data Values");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(factors("23 factors selected"));

        softAssert.assertTrue(formatting());

        softAssert.assertTrue(includeBMOnlySecurities());

        softAssert.assertTrue(includeSectorGroups());

        softAssert.assertAll();


    }

    @Test
    public void subFundGalleryStyleExposure(){

        SoftAssert softAssert = new SoftAssert();

        expandStyleExposure();

        openBlockAndVerifyTitle("Sub Fund Gallery - Style Exposures");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(factors("6 factors selected"));

        softAssert.assertTrue(formatting());

        softAssert.assertTrue(restrictGridToBlockSize());

        softAssert.assertTrue(sortBy());

        softAssert.assertAll();


    }

    @Test
    public void subFundGalleryRegionDistribution(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Sub Fund Gallery - Region Distribution");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(formatting());

        softAssert.assertTrue(restrictGridToBlockSize());

        softAssert.assertTrue(sortBy());


        softAssert.assertAll();


    }

    @Test
    public void subFundGallerySectorDistribution(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Sub Fund Gallery - Sector Distribution");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(restrictGridToBlockSize());

        softAssert.assertTrue(sortBy());

        softAssert.assertTrue(formatting());


        softAssert.assertAll();


    }

    @Test
    public void subFundGalleryStyleDistribution(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Sub Fund Gallery - Style Distribution");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(restrictGridToBlockSize());

        softAssert.assertTrue(sortBy());

        softAssert.assertTrue(formatting());


        softAssert.assertAll();


    }

    @Test
    public void subFundGallerySizeDistribution(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Sub Fund Gallery - Size Distribution");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(restrictGridToBlockSize());

        softAssert.assertTrue(sortBy());

        softAssert.assertTrue(formatting());


        softAssert.assertAll();


    }




    @Test
    public void styleHeatMap() {

        SoftAssert softAssert = new SoftAssert();

        expandStyleExposure();

        openBlockAndVerifyTitle("Style Tilt Heat Map");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(factors("23 factors selected"));

        softAssert.assertTrue(dataSeries());

        softAssert.assertTrue(verifyLabelAndCheckBox("Append date range to page title:",
                templateBuilderPage.appendDateRangeOnTitle,
                templateBuilderPage.appendDateRangeOnTitleCheckBox,false));

        softAssert.assertTrue(verifyLabelAndCheckBox("Make block full page in PDF:",
                templateBuilderPage.makeBlockFullPageInPDF,
                templateBuilderPage.makeBlockFullPageInPDFCheckBox,
                false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();



    }
    //@Test this is removed part of i42
    public void styleMineLegacy() {

        SoftAssert softAssert = new SoftAssert();

        expandStyleExposure();

        openBlockAndVerifyTitle("Style Mine Legacy");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(factors("23 factors selected"));

       // softAssert.assertTrue(dataSeries());

        softAssert.assertTrue(showFactorCategoryLabels());

        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }
    @Test
    public void styleExposureTrails(){

        SoftAssert softAssert = new SoftAssert();

        expandStyleExposure();

        openBlockAndVerifyTitle("Style Exposure Trails");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Factors

        softAssert.assertTrue(verifyLabelAndCheckBox("Append date range to page title:",
                templateBuilderPage.appendDateRangeOnTitle,
                templateBuilderPage.appendDateRangeOnTitleCheckBox,
                false));

        softAssert.assertTrue(verifyLabelAndCheckBox("Repeat header if block spans pages:",
                templateBuilderPage.repeatHeaderInAllPages,
                templateBuilderPage.repeatHeaderInAllPagesCheckBox,
                false));

        //Number of blocks per row

        softAssert.assertTrue(verifyLabelAndCheckBox("Equalise y-axis scales across all blocks:",
                templateBuilderPage.equlaiseYAxis,
                templateBuilderPage.equlaiseYAxisCheckBox,
                false));

        //Default y-axis

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }
    @Test
    public void regionDistribution() {

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Region Distribution");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(dataSeriesInDistribution());

        softAssert.assertTrue(weightbasis());

        //softAssert.assertTrue(regionSet());

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void countryRangeDistribution() {

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Country Range");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(weightbasis());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void sectorRangeDistribution() {

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Sector Range");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(weightbasis());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void sizeDistributionDetails() {

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Size Distribution Details");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(dataSeriesInDistribution());

        softAssert.assertTrue(weightbasis());

        //adjustments

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void styleDistributionDetails() {

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Style Distribution Details");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(dataSeriesInDistribution());

        softAssert.assertTrue(weightbasis());

        //adjustments

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void sectorDistribution(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Sector Distribution");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(dataSeriesInDistribution());

        softAssert.assertTrue(weightbasis());

        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }
    @Test
    public void styleDistribution(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Style Distribution");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(dataSeriesInDistribution());

        softAssert.assertTrue(weightbasis());

        //Adjustments

        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }

    @Test
    public void sizeDistribution(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Size Distribution");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(dataSeriesInDistribution());

        softAssert.assertTrue(weightbasis());

        //Adjustments

        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }

    @Test
    public void regionRange(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Region Range");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(weightbasis());

        //softAssert.assertTrue(regionSet());

        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }

    @Test
    public void countryDistribution(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Country Distribution");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(dataSeriesInDistribution());

        softAssert.assertTrue(weightbasis());


        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }

    @Test
    public void regionTrails(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Region Trails");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(weightbasis());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        //Region set

        //softAssert.assertTrue(regionSet());


        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }

    @Test
    public void countryTrails(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Country Trails");

        softAssert.assertTrue(dataSeriesInDistributionTrails());

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(weightbasis());

        softAssert.assertTrue(appendDateRangeInTitle(false));


        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }

    @Test
    public void sizeDistributionTrails(){

        SoftAssert softAssert = new SoftAssert();

        expandDistributionMenu();

        openBlockAndVerifyTitle("Size Distribution Trails");

        softAssert.assertTrue(dataSeriesInDistributionTrails());

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(weightbasis());

        //Adjustments

        softAssert.assertTrue(appendDateRangeInTitle(false));


        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }

    @Test
    public void riskAttribution() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Risk Attribution");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());


        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void riskEstimates() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Risk Estimates");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void largestOverweights() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Largest Overweights");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(verifyLabelAndCheckBox("Restrict grid to block size:",templateBuilderPage.restrictGridToBlockSize,templateBuilderPage.restrictGridToBlockSizeCheckBox,
                false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void largestUnderweights() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Largest Underweights");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(verifyLabelAndCheckBox("Restrict grid to block size:",templateBuilderPage.restrictGridToBlockSize,templateBuilderPage.restrictGridToBlockSizeCheckBox,
                false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void riskRangeHistory() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Risk Range History");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void trackingErrorHistory() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Tracking Error History");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void marketXRiskHistory() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("MarketX Risk History");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void marketRiskHistory() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Market Risk History");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void sectorXRiskHistory() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("SectorX Risk History");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void sectorRiskHistory() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Sector Risk History");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void styleXRiskHistory() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("StyleX Risk History");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void styleRiskHistory() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Style Risk History");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void equityXRiskHistory() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("EquityX Risk History");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void equityRiskHistory() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Equity Risk History");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void currencyRiskHistory() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Currency Risk History");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void subFundGalleryRisk() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Sub Fund Gallery - Risk");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(restrictGridToBlockSize());

        softAssert.assertTrue(sortBy());

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void subFundGalleryRiskOther() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Sub Fund Gallery - Risk Other");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(restrictGridToBlockSize());

        softAssert.assertTrue(sortBy());

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    //@Test
    public void otherRiskTrails() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Tracking Error"); //Title in the web is wrong

        softAssert.assertTrue(showBlockTitleInFrame());

        //Data Series

        softAssert.assertTrue(appendDateRangeInTitle(false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void riskByStyle() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Risk By Style");

        softAssert.assertTrue(showBlockTitleInFrame());


        softAssert.assertTrue(riskDecomposition());

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void holdingByAssets() {

        SoftAssert softAssert = new SoftAssert();

        expandRisk();

        openBlockAndVerifyTitle("Holdings By Asset");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

   // @Test
    public void liquidity() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        expandLiquidity();

        Utility.waitForPageToBeReady();



        openBlockAndVerifyTitle("Liquidity");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Percentage Volume tradable

        softAssert.assertTrue(verifyValueInTextBox(templateBuilderPage.percentageVolTradableLabel,
                templateBuilderPage.percentageVolTradableValue,"Percent Volume Tradable:",20));

        //Sample Period

        softAssert.assertTrue(verifyValueInTextBox(templateBuilderPage.avgVolSamplePeriodLabel,
                templateBuilderPage.avgVolSamplePeriodValue,"Avg Vol Sample Period(Months):",12));


        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }

    @Test
    public void liquidityHistory() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        expandLiquidity();

        Utility.waitForPageToBeReady();

        openBlockAndVerifyTitle("Liquidity History");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Percentage Volume tradable

        softAssert.assertTrue(verifyValueInTextBox(templateBuilderPage.percentageVolTradableLabel,
                templateBuilderPage.percentageVolTradableValue,"Percent Volume Tradable:",20));

        //Sample Period

        softAssert.assertTrue(verifyValueInTextBox(templateBuilderPage.avgVolSamplePeriodLabel,
                templateBuilderPage.avgVolSamplePeriodValue,"Avg Vol Sample Period(Months):",12));


        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }


    @Test
    public void liquidityHistoryBM() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        expandLiquidity();

        Utility.waitForPageToBeReady();

        openBlockAndVerifyTitle("Liquidity History Benchmark");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Percentage Volume tradable

        softAssert.assertTrue(verifyValueInTextBox(templateBuilderPage.percentageVolTradableLabel,
                templateBuilderPage.percentageVolTradableValue,"Percent Volume Tradable:",20));

        //Sample Period

        softAssert.assertTrue(verifyValueInTextBox(templateBuilderPage.avgVolSamplePeriodLabel,
                templateBuilderPage.avgVolSamplePeriodValue,"Avg Vol Sample Period(Months):",12));


        softAssert.assertTrue(formatting());

        softAssert.assertAll();


    }

    @Test
    public void fofPerformanceSummary() {

        SoftAssert softAssert = new SoftAssert();

        expandFOFPerformance();

        openBlockAndVerifyTitle("Fund of Funds Performance Summary");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Series

        softAssert.assertTrue(appendDateRangeInTitle(true));

        //softAssert.assertTrue(verifyLabelAndCheckBox("Annualise returns:",templateBuilderPage.annualisedReturns,
          //      templateBuilderPage.annualisedReturnsValue,false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void fofContributionByFund() {

        SoftAssert softAssert = new SoftAssert();

        expandFOFPerformance();

        openBlockAndVerifyTitle("Contribution By Fund");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Series

        softAssert.assertTrue(appendDateRangeInTitle(true));





        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void fofPerformanceSummaryGrid() {

        SoftAssert softAssert = new SoftAssert();

        expandFOFPerformance();

        openBlockAndVerifyTitle("Fund Of Funds Performance Summary Grid");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Series

        //TimeFrame

        softAssert.assertTrue(appendDateRangeInTitle(true));

        softAssert.assertTrue(verifyLabelAndCheckBox("Annualise returns:",templateBuilderPage.annualisedReturns,
                templateBuilderPage.annualisedReturnsValue,false));



        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void performanceSummary(){

        SoftAssert softAssert = new SoftAssert();

        expandPerforamnce();

        openBlockAndVerifyTitle("Performance Summary");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Series

        softAssert.assertTrue(appendDateRangeInTitle(true));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void performanceSummaryGrid(){

        SoftAssert softAssert = new SoftAssert();

        expandPerforamnce();

        openBlockAndVerifyTitle("Performance Summary Grid");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Series

        //TimeFrame

        softAssert.assertTrue(appendDateRangeInTitle(true));

        softAssert.assertTrue(verifyLabelAndCheckBox("Annualise returns:",templateBuilderPage.annualisedReturns,
                templateBuilderPage.annualisedReturnsValue,false));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void stockContributionToReturns(){

        SoftAssert softAssert = new SoftAssert();

        expandPerforamnce();

        openBlockAndVerifyTitle("Stock Contributors to Return");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Series

        softAssert.assertTrue(appendDateRangeInTitle(false));

        //Stock filter

        //Sort by

        //Sort Order

        //Top n

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void styleMine(){

        SoftAssert softAssert = new SoftAssert();

        expandStyleMine();

        openBlockAndVerifyTitle("Style Mine Performance");

        softAssert.assertTrue(showBlockTitleInFrame());

        softAssert.assertTrue(factors("23 factors selected"));

        softAssert.assertTrue(appendDateRangeInTitle(false));

        //Sort by

        //Sort Order

        //Top n

        //Stock return

        // Avg active weight

        //Cumulative relative return

        //Allocation

        // selection Impact

        //Summary settings

        //Restrict grid


        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void brinsonPerformanceSummary(){

        SoftAssert softAssert = new SoftAssert();

        expandPerforamnce();

        openBlockAndVerifyTitle("Brinson Performance Summary");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Series

        softAssert.assertTrue(appendDateRangeInTitle(true));

        //grouping

        //Stock returns

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void brinsonDetailChart(){

        SoftAssert softAssert = new SoftAssert();

        expandPerforamnce();

        openBlockAndVerifyTitle("Brinson Detail Chart");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Series

        softAssert.assertTrue(appendDateRangeInTitle(false));

        //grouping

        //Stock returns

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }

    @Test
    public void performanceByHierarchy(){

        SoftAssert softAssert = new SoftAssert();

        expandPerforamnce();

        openBlockAndVerifyTitle("Performance by Hierarchy");

        softAssert.assertTrue(showBlockTitleInFrame());

        //Series

        softAssert.assertTrue(appendDateRangeInTitle(true));

        softAssert.assertTrue(formatting());

        softAssert.assertAll();

    }




    public void expandPerforamnce(){

        if(!templateBuilderPage.performanceSummary.isDisplayed()){

            templateBuilderPage.expandPerformance.click();
            Utility.waitForPageToBeReady();

        }



    }

    public void expandStyleMine(){

        if(!templateBuilderPage.styleMinePerformance.isDisplayed()){

            templateBuilderPage.expandStyleMine.click();
            Utility.waitForPageToBeReady();

        }



    }




    public void expandFOFPerformance(){

        if(!templateBuilderPage.fofPerformanceSumamry.isDisplayed()){

            templateBuilderPage.expandFOFPerformance.click();
            Utility.waitForPageToBeReady();

        }



    }



    public Boolean verifyValueInTextBox(WebElement label, WebElement value, String labelName, int defaultValue){


        templateBuilderPage = new TemplateBuilderPage();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(label.getText(), labelName);

        WebElement blockTitle =value;

        blockTitle.sendKeys(Keys.chord(Keys.CONTROL, "a"));  //Select all
        blockTitle.sendKeys(Keys.chord(Keys.CONTROL, "c"));  //Copy to Clipboard

        String content = getClipBoard();

        int v = Integer.parseInt(content);


        System.out.println(content);

        softAssert.assertEquals(v, defaultValue);

        softAssert.assertAll();

        return true;



    }

    public void expandLiquidity(){

        if(!templateBuilderPage.liquidityHistoryBM.isDisplayed()){

            templateBuilderPage.expandLiquidity.click();
            Utility.waitForPageToBeReady();

        }


    }


    public void expandRisk(){

        if(!templateBuilderPage.riskAttribution.isDisplayed()){

            templateBuilderPage.expandRisk.click();
            Utility.waitForPageToBeReady();

        }


    }

    public Boolean riskDecomposition(){
        SoftAssert softAssert = new SoftAssert();

        String riskDecompositionValues[] = {"Tracking Error","Tracking Variance"};

        softAssert.assertTrue(verifyDropDownSelection("Risk Decomposition:",
                templateBuilderPage.riskDecompositionLabel,"//*[@id=\"ctl00_mainContentPlaceHolder_winProps_C_ddlRiskDecomposition_DropDown\"]",
                templateBuilderPage.riskDecompositionDefault,"Tracking Error",riskDecompositionValues));

        softAssert.assertAll();
        return true;
    }



        public Boolean appendDateRangeInTitle(Boolean isTicked){

            SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(verifyLabelAndCheckBox("Append date range to page title:",
                templateBuilderPage.appendDateRangeOnTitle,
                templateBuilderPage.appendDateRangeOnTitleCheckBox, isTicked));

        softAssert.assertAll();
        return true;
    }



    public Boolean dataSeriesInDistribution(){

        SoftAssert softAssert = new SoftAssert();

        String dataSeries [] = {"Standard","Long/Short","130/30","Active"};

        softAssert.assertTrue(verifyDropDownSelection("Data Series:",templateBuilderPage.dataSeriesLabel,
                "//*[@id=\"ctl00_mainContentPlaceHolder_winProps_C_ddlDataSeries_DropDown\"]",
                templateBuilderPage.dataSeriesValue,"Standard",dataSeries));

        softAssert.assertAll();

        return true;


    }

    public Boolean dataSeriesInDistributionTrails(){

        SoftAssert softAssert = new SoftAssert();

        String dataSeries [] = {"Portfolio Weight","Active Weight"};

        softAssert.assertTrue(verifyDropDownSelection("Data Series:",templateBuilderPage.dataSeriesLabel,
                "//*[@id=\"ctl00_mainContentPlaceHolder_winProps_C_ddlDataSeries_DropDown\"]",
                templateBuilderPage.dataSeriesValue,"Portfolio Weight",dataSeries));

        softAssert.assertAll();

        return true;


    }

   public Boolean weightbasis(){

       SoftAssert softAssert = new SoftAssert();

       String weightBasisExpected[] ={"Total Portfolio","Equity Only"};

       softAssert.assertTrue(verifyDropDownSelection("Weight Basis:",templateBuilderPage.weightBasisLabel,
               "//*[@id=\"ctl00_mainContentPlaceHolder_winProps_C_ddlDistWeightBasis_DropDown\"]",
               templateBuilderPage.weightBasisDefault,
               "Total Portfolio",weightBasisExpected));

        softAssert.assertAll();

        return true;

   }

   public Boolean regionSet(){

       SoftAssert softAssert = new SoftAssert();

       String regionSet [] = {"Style Research Default",};

       softAssert.assertTrue(verifyDropDownSelection("Region set:",templateBuilderPage.regionSetLabel,"//*[@id=\"ctl00_mainContentPlaceHolder_winProps_C_ddlRegionSets_DropDown\"]",
               templateBuilderPage.regionSetDefault,"Style Research Default",regionSet));

       softAssert.assertAll();

       return true;

   }


    public void expandDistributionMenu(){

        if(!templateBuilderPage.regionDistribution.isDisplayed()){

            templateBuilderPage.expandDistribution.click();
            Utility.waitForPageToBeReady();

        }

    }

    public void expandStyleExposure(){

        if(!templateBuilderPage.styleSkyline.isDisplayed()){

            templateBuilderPage.expandStyleExposure.click();
            Utility.waitForPageToBeReady();

        }


    }

    @AfterMethod(alwaysRun = true)
    public void closeOpenBlock(ITestResult result) throws IOException {

        if(!result.isSuccess()){

            Utility.tearDown(result);  //take screenshot on failure

            goTo.goToTemplates();

            templateBuilderPage.newTemplateButton.click();

            templateBuilderPage.newPDFTemplateForPortfolios.click();


        }else {

            templateBuilderPage.deleteBlock.click();

            }

        Utility.waitForPageToBeReady();


    }


    public Boolean blockTitleCheck(String blockName ) {


        SoftAssert softAssert = new SoftAssert();

        templateBuilderPage = new TemplateBuilderPage();

        softAssert.assertEquals(templateBuilderPage.blockTitle.getText(), "Block Title:");

        WebElement blockTitle =templateBuilderPage.blockTitleValue;

        blockTitle.sendKeys(Keys.chord(Keys.CONTROL, "a"));  //Select all
        blockTitle.sendKeys(Keys.chord(Keys.CONTROL, "c"));  //Copy to Clipboard

        String content = getClipBoard();

        System.out.println(content);

        softAssert.assertEquals(content, blockName);


        return true;

    }
    public Boolean showBlockTitleInFrame(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(templateBuilderPage.showBlockTitleAndFrameLabel.getText(), "Show block title and frame in report:");

        if(!templateBuilderPage.showBlockTitleCheckBox.isSelected()) {

            softAssert.fail();
        }

        softAssert.assertAll();

        return true;


    }

    public Boolean includeBMOnlySecurities(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(templateBuilderPage.includeBMOnlySecurities.getText(), "Include benchmark-only securities:");

        if(templateBuilderPage.includeBMOnlySecuritiesCheckBox.isSelected()) {

            softAssert.fail();
        }

        softAssert.assertAll();

        return true;
    }

    public Boolean includeSectorGroups(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(templateBuilderPage.includeSectorGroupings.getText(), "Include sector groupings:");

        if(!templateBuilderPage.includeSectorGroupingsCheckBox.isSelected()) {

            softAssert.fail();
        }

        softAssert.assertAll();

        return true;


    }

    public Boolean restrictGridToBlockSize(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(templateBuilderPage.restrictGridToBlockSize.getText(), "Restrict grid to block size:");

        if(!templateBuilderPage.restrictGridToBlockSizeCheckBox.isSelected()) {

            softAssert.fail();
        }

        softAssert.assertAll();

        return true;
    }

    public Boolean verifyLabelAndCheckBox(String labelName,WebElement label, WebElement checkBox,Boolean checkBoxChecked){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(label.getText(), labelName);

        if(checkBox.isSelected()!=checkBoxChecked) {

            System.out.println("Default Checkbox selection Incorrect");

            softAssert.fail();
        }


        softAssert.assertAll();
        return true;
    }

    public Boolean factors(String factorsSelected){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(templateBuilderPage.factorsLabel.getText(), "Factors:");

        softAssert.assertEquals(templateBuilderPage.factorsValue.getText(), factorsSelected);

        softAssert.assertAll();

        return true;


    }

    public Boolean dataSeries(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(templateBuilderPage.dataSeriesLabel.getText(), "Data Series:");

        //softAssert.assertEquals(templateBuilderPage.dataSeriesValue.getText(), "Standard");

        List<WebElement> adjustments = Driver.findElements(By.xpath("//div[@id='ctl00_mainContentPlaceHolder_winProps_C_ddlDataSeries_DropDown']//li"));

        System.out.println(adjustments.size());

                String adjustmentsExpected []= {"Standard","CA","SA","CASA"};

                for(int i=0;i<adjustments.size();i++){

                    System.out.println(adjustments.get(i).getAttribute("innerHTML"));

                    softAssert.assertEquals(adjustments.get(i).getAttribute("innerHTML"),adjustmentsExpected[i]);
                }


        softAssert.assertAll();

                return true;

    }

    public Boolean verifyDropDownSelection(String labelName,WebElement label, String dropDownList, WebElement defaultSelection , String defaultValue ,String dropDownItemsExpected[]){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(label.getText(), labelName);

        softAssert.assertEquals(defaultSelection.getAttribute("value"), defaultValue);

        List<WebElement> adjustments = Driver.findElements(By.xpath(dropDownList+"//li"));

        System.out.println(adjustments.size());

        //String adjustmentsExpected []= {"Standard","CA","SA","CASA"};

        for(int i=0;i<adjustments.size();i++){

            System.out.println(adjustments.get(i).getAttribute("innerHTML"));

            softAssert.assertEquals(adjustments.get(i).getAttribute("innerHTML"),dropDownItemsExpected[i]);
        }


        softAssert.assertAll();

        return true;

    }

    public Boolean sortBy(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(templateBuilderPage.sortByLabel.getText(), "Sort by:");

        softAssert.assertEquals(templateBuilderPage.sortByValue.getAttribute("value"), "Portfolio Name");

        List<WebElement> adjustments = Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_winProps_C_ddlSubFundGallerySort_DropDown\"]/div/ul/li"));

        System.out.println(adjustments.size());

        String adjustmentsExpected []= {"Portfolio Name","Weight"};

        for(int i=0;i<adjustments.size();i++){

            System.out.println(adjustments.get(i).getAttribute("innerHTML"));

            softAssert.assertEquals(adjustments.get(i).getAttribute("innerHTML"),adjustmentsExpected[i]);
        }


        softAssert.assertAll();




        return true;
    }

    public Boolean showFactorCategoryLabels(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(templateBuilderPage.factorCategoryLabel.getText(), "Factor Category Labels:");

        List<WebElement> adjustments = Driver.findElements(By.xpath("//div[@id='ctl00_mainContentPlaceHolder_winProps_C_ddlShowCategoryLabels_DropDown']//li"));

        String adjustmentsExpected []= {"Always Hide","Always Show","Dynamic"};

        for(int i=0;i<adjustments.size();i++){

            softAssert.assertEquals(adjustments.get(i).getAttribute("innerHTML"),adjustmentsExpected[i]);
        }

        softAssert.assertAll();

        return true;


    }

    public boolean formatting(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(templateBuilderPage.formattingLabel.getText(), "Formatting:");

        softAssert.assertEquals(templateBuilderPage.setBlockFormat.getText(), "set block format");

        softAssert.assertAll();

        return true;



    }



}





