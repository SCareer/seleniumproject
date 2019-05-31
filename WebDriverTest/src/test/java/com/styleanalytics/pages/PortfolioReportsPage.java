package com.styleanalytics.pages;

import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PortfolioReportsPage {

    WebDriver driver;
    Actions actions;

    /***
     * Reports Portfolio Details Drop Down
     *
     */


    @FindBy(id = "ctl00_mainContentPlaceHolder_report_hlTrafficLight")
    WebElement trafficLights;
    @FindBy(id = "ctl00_mainContentPlaceHolder_report_panPortfolioName")
    WebElement reportTitle;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input")
    WebElement portfolioComboBox;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_labPortfolioName")
    WebElement portfolioNameInTitle;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_labBenchmarkName")
    WebElement benchmarkNameInTitle;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_labSnapshotDate")
    WebElement snapshotDateInTitle;




    @FindBy(id = "ctl00_mainContentPlaceHolder_report_labAnalysis")
    WebElement benchmark;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_ddlSnapshots_Input")
    WebElement snapshotDateDropDown;

    @FindAll({@FindBy( xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlSnapshots_DropDown\"]/div/ul/li")})
    List <WebElement> snapshotDropDownList;



    @FindBy(id = "ctl00_mainContentPlaceHolder_report_labUniverse")
    WebElement universe;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_labCurrency")
    WebElement currency;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_labClassification")
    WebElement classification;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_labReportProfile")
    WebElement reportProfile;


    /***
     * Reports Menu
     *
     */
    /***
     * Overview
     */
    @FindBy(xpath = "//div[@title='Overview']")
    WebElement overview;

    @FindBy(xpath = "//em[contains(text(),'Equity Overview')]")
    WebElement equityOverview;

    @FindBy(xpath = "//em[contains(text(),'Bond Overview')]")
    WebElement bondOverview;

    @FindBy(xpath = "//em[contains(text(),'Balanced Overview')]")
    WebElement balancedOverview;

    /**
     * Style Exposure
     */
    @FindBy(xpath = "//div[@title='Style Exposures']")
    WebElement styleExposure;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl00_rptChapterSubPages_ctl00_hlPage")
    WebElement styleExposureSummary;

    @FindBy(xpath = "//em[contains(text(),'Region Skylines™')]")
    WebElement regionSkyline;

    @FindBy(xpath = "//em[contains(text(),'Sector Skylines™')]")
    WebElement sectorSkyline;

    @FindBy(xpath = "//em[contains(text(),'Country Skylines™')]")
    WebElement countrySkyline;

    @FindBy(xpath = "//em[contains(text(),'Factor Data')]")
    WebElement factorData;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl02_rptChapterSubPages_ctl00_hlPage")
    WebElement styleExposureRange;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl02_rptChapterSubPages_ctl01_hlPage")
    WebElement styleExposureTrails;

    @FindBy(xpath = "//em[contains(text(),'Tilt Heat Map')]")
    WebElement tiltHeatMap;

    /**
     * Distributions
     */


    @FindBy(xpath = "//div[@title='Distributions']")
    WebElement distribution;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl00_hlPage")
    WebElement regionOverivew;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl01_hlPage")
    WebElement regionRange;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl02_hlPage")
    WebElement regionhistory;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl00_hlPage")
    WebElement countryOverview;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl01_hlPage")
    WebElement countryRange;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl02_hlPage")
    WebElement countryHistory;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl00_hlPage")
    WebElement sectorOverview;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl01_hlPage")
    WebElement sectorRange;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl02_hlPage")
    WebElement sectorHistory;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl00_hlPage")
    WebElement sizeOverview;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl01_hlPage")
    WebElement sizeRange;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl02_hlPage")
    WebElement sizeHistory;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl04_rptChapterSubPages_ctl00_hlPage")
    WebElement styleOverview;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl04_rptChapterSubPages_ctl01_hlPage")
    WebElement styleRange;


    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl04_rptChapterSubPages_ctl02_hlPage")
    WebElement styleHistory;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl05_rptChapterSubPages_ctl00_hlPage")
    WebElement distributionHeatMap;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl06_rptChapterSubPages_ctl00_hlPage")
    WebElement sectorHeatMap;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl06_rptChapterSubPages_ctl01_hlPage")
    WebElement countryHeatMap;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl07_rptChapterSubPages_ctl00_hlPage")
    WebElement sectorBreakdown;

    /****
     *  Risk
     */

    @FindBy(xpath = "//div[@title='Risk']")
    WebElement risk;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl00_rptChapterSubPages_ctl00_hlPage")
    WebElement riskOverview;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl00_rptChapterSubPages_ctl01_hlPage")
    WebElement persistence;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl01_rptChapterSubPages_ctl00_hlPage")
    WebElement riskRange;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl01_rptChapterSubPages_ctl01_hlPage")
    WebElement riskAttribution;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl01_rptChapterSubPages_ctl02_hlPage")
    WebElement otherRiskTrails;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl02_rptChapterSubPages_ctl00_hlPage")
    WebElement riskBySecurities;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl02_rptChapterSubPages_ctl01_hlPage")
    WebElement riskDecompositionByGroup;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl03_rptChapterSubPages_ctl00_hlPage")
    WebElement fofRiskSummary;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl03_rptChapterSubPages_ctl01_hlPage")
    WebElement subFundRiskStatistics;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl03_rptChapterSubPages_ctl02_hlPage")
    WebElement numberOfDifferentStocks;

    /*****
     *
     * Liquidity
     */

    @FindBy(xpath = "//div[@title='Liquidity']")
    WebElement liquidity;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl04_rptChapterPages_ctl00_hlPage")
    WebElement liquiditySummary;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl04_rptChapterPages_ctl01_hlPage")
    WebElement liquidityHistory;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl04_rptChapterPages_ctl02_rptChapterSubPages_ctl00_hlPage")
    WebElement liquiditySecurityDetails;


    /*****
     * Performance
     */

    @FindBy(xpath = "//div[@title='Performance']")
    WebElement performance;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl00_hlPage")
    WebElement performanceSummary;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl01_hlPage")
    WebElement perormanceByMarket;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl02_hlPage")
    WebElement performaceBySector;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl03_hlPage")
    WebElement performanceByStyle;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl04_hlPage")
    WebElement performanceByHierarchy;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl05_hlPage")
    WebElement fofPerformace;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl06_hlPage")
    WebElement fofPerformaceDetails;

    /****
     * Style Mine
     */

    @FindBy(xpath = "//div[@title='Style Mine']")
    WebElement styleMine;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl06_rptChapterPages_ctl00_rptChapterSubPages_ctl00_hlPage")
    WebElement styleMinePerformance;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl07_rptChapterPages_ctl01_hlPage")
    WebElement styleMineFactorCorrelation;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl06_rptChapterPages_ctl01_rptChapterSubPages_ctl01_hlPage")
    WebElement styleMineFactorCategoryCorrelation;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl06_rptChapterPages_ctl02_rptChapterSubPages_ctl00_hlPage")
    WebElement styleMineRisk;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl06_rptChapterPages_ctl02_rptChapterSubPages_ctl01_hlPage")
    WebElement styleMineRiskReturnsScatter;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl06_rptChapterPages_ctl02_rptChapterSubPages_ctl02_hlPage")
    WebElement styleMineRiskWeightScatter;

    /********
     *
     * Sub Fund Gallery
     */

    @FindBy(xpath = "//div[@title='Fund of Funds']")
    WebElement fundOfFunds;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl07_rptChapterPages_ctl00_hlPage")
    WebElement subFundStyleExposure;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl07_rptChapterPages_ctl01_hlPage")
    WebElement subFundStyleRisk;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl07_rptChapterPages_ctl02_hlPage")
    WebElement subFundStyleRiskOther;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl07_rptChapterPages_ctl03_hlPage")
    WebElement subFundRegionDistribution;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl07_rptChapterPages_ctl04_hlPage")
    WebElement subFundSectorDistribution;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl07_rptChapterPages_ctl05_hlPage")
    WebElement subFundSizeDistribtuion;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl07_rptChapterPages_ctl06_hlPage")
    WebElement subFundStyledistribution;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl07_rptChapterPages_ctl07_hlPage")
    WebElement subFundSecurityWeight;

    /***
     *
     * Labs
     */

    @FindBy(xpath = "//div[@title='LABS']")
    WebElement labs;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl08_rptChapterPages_ctl00_hlPage")
    WebElement assetTree;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl08_rptChapterPages_ctl01_hlPage")
    WebElement styleScatter;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_rptChapters_ctl08_rptChapterPages_ctl02_hlPage")
    WebElement tiltXySnailTrails;

    /***
     *
     * Fixed Income
     */

    @FindBy(id = "")
    WebElement fixedIncome;

    /**
     *
     * Balanced
     */

    @FindBy(id = "")
    WebElement balanced;

    /***
     * Sync items
     */
    @FindBy(id = "ctl00_RadAjaxLoadingPanel1formContainer")
    WebElement reportFirstLoadSquareBoxes;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_LoadingDiv")
    WebElement searchingForPortfolios;

    @FindBy(xpath = "//*[@id='quickSearchItem']/span[2]")
    WebElement firstSearchResult;

    @FindBy(id = "ctl00_mainContentPlaceHolder_report_hidFirstPageLoaded")
    WebElement isReportsLoaded;

    @FindBy(xpath = "//div[contains(text(),'Failed to load report page.')]")
    WebElement failedToLoadReports;





    @FindBy(xpath = "//div[contains(@class,'chartLoading')]")
    WebElement overiewPageLoad;
    /***
     * LeftOvers from Previous page
     */
    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement labsTiltXYSnailTrailTitle;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_ctl00_labTitle']")
    WebElement labsAssetTreeReportTitle;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap\"]")
    WebElement distributionHeatMapReport;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap\"]")
    WebElement sectorHeatMapReport;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap\"]")
    WebElement countryHeatMapReport;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement riskAttributionTitle;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement riskOtherTrailsTitle;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement riskSummaryTitle;

    @FindBy(xpath = "//table[@class='reportTable']")
    WebElement riskSummaryTable;

    @FindBy(xpath = "//div[@class='chartTitle h2']")
    WebElement riskSubFundStatsTitle;

    @FindBy(xpath = "//table[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap']")
    WebElement riskSubFundStatsReport;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement riskNumberOfDifferentStocksTitle;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement subFundGalleryReportsTitle;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_ctl00_labTitle']")
    WebElement subFundGalleryFoFSecurityWeightsTitle;




    public WebElement getSubFundGalleryFoFSecurityWeightsTitle() {
        return subFundGalleryFoFSecurityWeightsTitle;
    }

    public WebElement getDistributionHeatMapReport() {
        return distributionHeatMapReport;
    }

    public WebElement getSectorHeatMapReport() {
        return sectorHeatMapReport;
    }

    public WebElement getCountryHeatMapReport() {
        return countryHeatMapReport;
    }

    public WebElement getRiskAttributionTitle() {
        return riskAttributionTitle;
    }

    public WebElement getRiskOtherTrailsTitle() {
        return riskOtherTrailsTitle;
    }

    public WebElement getRiskSummaryTitle() {
        return riskSummaryTitle;
    }

    public WebElement getRiskSummaryTable() {
        return riskSummaryTable;
    }

    public WebElement getRiskSubFundStatsTitle() {
        return riskSubFundStatsTitle;
    }

    public WebElement getRiskSubFundStatsReport() {
        return riskSubFundStatsReport;
    }

    public WebElement getRiskNumberOfDifferentStocksTitle() {
        return riskNumberOfDifferentStocksTitle;
    }

    public WebElement getSubFundGalleryReportsTitle() {
        return subFundGalleryReportsTitle;
    }

    public WebElement getLabsAssetTreeReportTitle() {
        return labsAssetTreeReportTitle;
    }

    public WebElement getLabsTiltXYSnailTrailTitle() {
        return labsTiltXYSnailTrailTitle;
    }

    public void getReport(WebElement reportSection, WebElement report) throws Exception {

        try {
            driver.switchTo().defaultContent();
            actions = new Actions(driver);
            actions.moveToElement(reportSection).build().perform();
            Wait.waitForElementToDisplay(driver, report, 3);
            report.click();
            Wait.waitForElementToDisappear(driver,60,reportFirstLoadSquareBoxes);
        }catch (Exception e){
            throw new Exception("Failed to Access Report: "+report.getText());
        }
    }

    public void goToReportsPage(String url) throws InterruptedException {

        driver.get(url+"/analysis/viewReports.aspx");
        Wait.waitForElementToDisappear(driver,120,overiewPageLoad);

        Wait.until(driver, (d) ->
        {
            Boolean reportsLoad =true ;
            try {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                failedToLoadReports.isDisplayed();
                Thread.sleep(10000);
                driver.get(url+"/analysis/viewReports.aspx");
                Wait.waitForElementToDisappear(driver,120,overiewPageLoad);
                return false;
            } catch (Exception e) {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                return reportsLoad;
            }
        }, 180);
    }



    public void selectPortfolio(String portfolioName) throws Exception {

        String selectedPortfolio = portfolioNameInTitle.getText();

        System.out.println(selectedPortfolio);

        if(!selectedPortfolio.equalsIgnoreCase(portfolioName)) {
            try {
                reportTitle.click();
                Wait.waitForElementToDisplay(driver,portfolioComboBox,5);
                portfolioComboBox.sendKeys(" " + portfolioName);
                Thread.sleep(3000);
                Wait.waitForElementToDisappear(driver,60,searchingForPortfolios);
                Wait.waitForTextToBeVisible(driver,20,firstSearchResult,portfolioName);
                firstSearchResult.click();
                Thread.sleep(6000);
                Wait.waitForElementToDisappear(driver,60,overiewPageLoad);
                Actions actions =new Actions(driver);
                actions.moveToElement(trafficLights).build().perform();

            }catch (Exception e){

                throw new Exception("Failed to select and select portfolio: "+portfolioName);
            }

        }
    }

    public void selectSnapshot(String snapshotDate) throws Exception {

        String selectedAnalysisDate = snapshotDateInTitle.getText();

        System.out.println(selectedAnalysisDate);

       // reportTitle.click();

       // Wait.waitForElementToDisplay(driver,portfolioComboBox,5);

       // String analysisDate = snapshotDateDropDown.getAttribute("value");

       // System.out.println(analysisDate);

        if(!selectedAnalysisDate.equalsIgnoreCase(snapshotDate)) {
            try {
                reportTitle.click();
                Wait.waitForElementToDisplay(driver,portfolioComboBox,5);
                snapshotDateDropDown.click();
                System.out.println(snapshotDropDownList.size());

               for(int i=0;i<snapshotDropDownList.size();i++){
                   System.out.println(snapshotDropDownList.get(i).getText());
                   if(snapshotDropDownList.get(i).getText().equalsIgnoreCase(snapshotDate)){
                       snapshotDropDownList.get(i).click();
                   }
               }
                Thread.sleep(6000);
                Wait.waitForElementToDisappear(driver,60,overiewPageLoad);

            }catch (Exception e){

                throw new Exception("Failed to select snapshot: "+snapshotDate);
            }

        }
    }

    public String getTitle(WebElement element){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        return element.getText();
    }

    public void waitForReportsToLoad(int waitTime) throws InterruptedException {

        for(int i=0;i<waitTime;i++) {

            String value = isReportsLoaded.getAttribute("value");

            if(value.equalsIgnoreCase("")){

                value="0";
            }
            int val = Integer.valueOf(value);

            if (val != 1) {

                Thread.sleep(1000);
            } else {
                break;
            }
        }
    }

    public void getEquityOverview() throws Exception {

        getReport(overview,equityOverview);
    }

    public void getBondOverview() throws Exception {

        getReport(overview,bondOverview);
    }

    public void getBalancedOverview() throws Exception {

        getReport(overview,balancedOverview);
    }

    public void getStyleExposureSummary() throws Exception {

        getReport(styleExposure,styleExposureSummary);
    }

    public void getRegionSkyline() throws Exception {
        getReport(styleExposure,regionSkyline);
    }

    public void getSectorSkyline() throws Exception {
        getReport(styleExposure,sectorSkyline);
    }

    public void getCountrySkyline() throws Exception {
        getReport(styleExposure,countrySkyline);
    }

    public void getFactorData() throws Exception {
        getReport(styleExposure,factorData);
    }

    public void getStyleExposureRange() throws Exception {
        getReport(styleExposure,styleExposureRange);
    }

    public void getStyleExposureTrails() throws Exception {
        getReport(styleExposure,styleExposureTrails);
    }

    public void getTiltHeatMap() throws Exception {
        getReport(styleExposure,tiltHeatMap);
    }


    public void getRegionOverivew() throws Exception {
        getReport(distribution,regionOverivew);
    }

    public void getRegionRange() throws Exception {
        getReport(distribution,regionRange);
    }

    public void getRegionhistory() throws Exception {
        getReport(distribution,regionhistory);
    }

    public void getCountryOverview() throws Exception {
        getReport(distribution,countryOverview);
    }

    public void getCountryRange() throws Exception {
        getReport(distribution,countryRange);
    }

    public void getCountryHistory() throws Exception {
        getReport(distribution,countryHistory);
    }

    public void getSectorOverview() throws Exception {
        getReport(distribution,sectorOverview);
    }

    public void getSectorRange() throws Exception {
        getReport(distribution,sectorRange);
    }

    public void getSectorHistory() throws Exception {
        getReport(distribution,sectorHistory);
    }

    public void getSizeOverview() throws Exception {
        getReport(distribution,sizeOverview);
    }

    public void getSizeRange() throws Exception {
        getReport(distribution,sizeRange);
    }

    public void getSizeHistory() throws Exception {
        getReport(distribution,sizeHistory);
    }

    public void getStyleOverview() throws Exception {
        getReport(distribution,styleOverview);
    }

    public void getStyleRange() throws Exception {
        getReport(distribution,styleRange);
    }

    public void getStyleHistory() throws Exception {
        getReport(distribution,styleHistory);
    }

    public void getDistributionHeatMap() throws Exception {
        getReport(distribution,distributionHeatMap);
    }

    public void getSectorHeatMap() throws Exception {
        getReport(distribution,sectorHeatMap);
    }

    public void getCountryHeatMap() throws Exception {
        getReport(distribution,countryHeatMap);
    }

    public void getSectorBreakdown() throws Exception {
        getReport(distribution,sectorBreakdown);
    }


    public void getRiskOverview() throws Exception {
        getReport(risk,riskOverview);
    }

    public void getPersistence() throws Exception {
        getReport(risk,persistence);
    }

    public void getRiskRange() throws Exception {
        getReport(risk,riskRange);
    }

    public void getRiskAttribution() throws Exception {
        getReport(risk,riskAttribution);
    }

    public void getOtherRiskTrails() throws Exception {
        getReport(risk,otherRiskTrails);
    }

    public void getRiskBySecurities() throws Exception {
        getReport(risk,riskBySecurities);
    }

    public void getRiskDecompositionByGroup() throws Exception {
        getReport(risk,riskDecompositionByGroup);
    }

    public void getFofRiskSummary() throws Exception {
        getReport(risk,fofRiskSummary);
    }

    public void getSubFundRiskStatistics() throws Exception {
        getReport(risk,subFundRiskStatistics);
    }

    public void getNumberOfDifferentStocks() throws Exception {
        getReport(risk,numberOfDifferentStocks);
    }

    public void getLiquiditySummary() throws Exception {
        getReport(liquidity,liquiditySummary);
    }

    public void getLiquidityHistory() throws Exception {
        getReport(liquidity,liquidityHistory);
    }

    public void getLiquiditySecurityDetails() throws Exception {
        getReport(liquidity,liquiditySecurityDetails);
    }



    public void getPerformanceSummary() throws Exception {
        getReport(performance,performanceSummary);
    }

    public void getPerormanceByMarket() throws Exception {
        getReport(performance,perormanceByMarket);
    }

    public void getPerformaceBySector() throws Exception {
        getReport(performance,performaceBySector);
    }

    public void getPerformanceByStyle() throws Exception {
        getReport(performance,performanceByStyle);
    }

    public void getPerformanceByHierarchy() throws Exception {
        getReport(performance,performanceByHierarchy);
    }

    public void getFofPerformace() throws Exception {
        getReport(performance,fofPerformace);
    }

    public void getFofPerformaceDetails() throws Exception {
        getReport(performance,fofPerformaceDetails);
    }


    public void getStyleMinePerformance() throws Exception {
        getReport(styleMine,styleMinePerformance);
    }

    public void getStyleMineFactorCorrelation() throws Exception {
        getReport(styleMine,styleMineFactorCorrelation);
    }

    public void getStyleMineFactorCategoryCorrelation() throws Exception {
        getReport(styleMine,styleMineFactorCategoryCorrelation);
    }

    public void getStyleMineRisk() throws Exception {
        getReport(styleMine,styleMineRisk);
    }

    public void getStyleMineRiskReturnsScatter() throws Exception {
        getReport(styleMine,styleMineRiskReturnsScatter);
    }

    public void getStyleMineRiskWeightScatter() throws Exception {
        getReport(styleMine,styleMineRiskWeightScatter);
    }



    public void getSubFundStyleExposure() throws Exception {
        getReport(fundOfFunds,subFundStyleExposure);
    }

    public void getSubFundStyleRisk() throws Exception {
        getReport(fundOfFunds,subFundStyleRisk);
    }

    public void getSubFundStyleRiskOther() throws Exception {
        getReport(fundOfFunds,subFundStyleRiskOther);
    }

    public void getSubFundRegionDistribution() throws Exception {
        getReport(fundOfFunds,subFundRegionDistribution);
    }

    public void getSubFundSectorDistribution() throws Exception {
        getReport(fundOfFunds,subFundSectorDistribution);
    }

    public void getSubFundSizeDistribtuion() throws Exception {
        getReport(fundOfFunds,subFundSizeDistribtuion);
    }

    public void getSubFundStyledistribution() throws Exception {
        getReport(fundOfFunds,subFundStyledistribution);
    }

    public void getSubFundSecurityWeight() throws Exception {
        getReport(fundOfFunds,subFundSecurityWeight);
    }


    public void getAssetTree() throws Exception {
        getReport(labs,assetTree);
    }

    public void getStyleScatter() throws Exception {
        getReport(labs,styleScatter);
    }

    public void getTiltXySnailTrails() throws Exception {
        getReport(labs,tiltXySnailTrails);
    }


    public PortfolioReportsPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }
}
