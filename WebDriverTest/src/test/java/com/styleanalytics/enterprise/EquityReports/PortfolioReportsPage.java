package com.styleanalytics.enterprise.EquityReports;


import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Viswanath on 24/11/2017.
 */
public class PortfolioReportsPage extends EnterpriseBaseClass {


    WebDriver driver;

    //OverView

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_panChapters\"]/div[1]")
    WebElement overview;

    //StyleMine

    @FindBy(xpath = "//div[@title='Style Mine']")
    WebElement styleMine;

    @FindBy(xpath = "//em[contains(text(),'Style Mine Performance')]")
    WebElement styleMinePerformance;


    @FindBy(xpath = "  //*[@id=\"ctl00_mainContentPlaceHolder_panChart\"]/div[1]/div[2]")
    WebElement styleMinePerformanceDrilldownTitle;






    //Style Exposure

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_panChapters\"]/div[2]")
    WebElement styleExposure;

    @FindBy(xpath = "   //*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl00_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement seSummary;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl00_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement seRegionSkyline;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl00_rptChapterSubPages_ctl02_hlPage\"]")
    WebElement seSectorSkyline;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl00_rptChapterSubPages_ctl03_hlPage\"]")
    WebElement seCountrySkyline;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl02_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement seRange;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl02_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement seTrails;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl02_rptChapterSubPages_ctl02_hlPage\"]")
    WebElement seTiltHeatmap;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl02_rptChapterSubPages_ctl04_hlPage\"]")
    WebElement seStyleMine;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl02_rptChapterSubPages_ctl03_hlPage\"]")
    WebElement seNewStyleMine;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl01_rptChapterPages_ctl01_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement seFactorDataValue;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_FactordataWidgetGrid_panGrid\"]")
    WebElement seFactorDataValueReport;



    //Distributions

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_panChapters\"]/div[3]")
    WebElement distribution;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement regionOverview;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement regionRange;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl02_hlPage\"]")
    WebElement regionHistory;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement countryOverview;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement countryRange;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl02_hlPage\"]")
    WebElement countryHistory;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement sectorOverview;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement sectorRange;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl02_hlPage\"]")
    WebElement sectorHistory;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement sizeOverview;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement sizeRange;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl02_hlPage\"]")
    WebElement sizeHistory;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl04_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement styleOverview;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl04_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement styleRange;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl04_rptChapterSubPages_ctl02_hlPage\"]")
    WebElement styleHistory;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl05_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement distributionHeatMap;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap\"]")
    WebElement distributionHeatMapReport;



    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl06_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement sectorHeatMap;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap\"]")
    WebElement sectorHeatMapReport;




    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl06_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement countryHeatMap;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap\"]")
    WebElement countryHeatMapReport;



    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl02_rptChapterPages_ctl07_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement sectorBreakdown;

    //Risk
    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_panChapters\"]/div[4]")
    WebElement risk;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl00_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement riskOverview;

    @FindBy(xpath = "//*[@id=\'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl01_ctl00_labTitle']")
    WebElement riskTitle;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_panContainer')]")
    WebElement riskAtributionReport;


     @FindBy(xpath = "//area[contains(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl01_panContainer')]")
    WebElement riskDrillDown;

    @FindBy(xpath = "//*[@id=\'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl02_ctl00_labTitle']")
    WebElement riskTop10ContributorsTitle;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl02')]")
    WebElement riskTop10ContributorsReport;


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl00_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement riskPersistence;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl01_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement riskRange;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl01_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement riskAttribution;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement riskAttributionTitle;


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl01_rptChapterSubPages_ctl02_hlPage\"]")
    WebElement riskOtherTrails;


    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement riskOtherTrailsTitle;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl02_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement riskBySecurities;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl02_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement riskDecompositionByGroup;

      @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl03_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement riskSummary;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement riskSummaryTitle;


    @FindBy(xpath = "//table[@class='reportTable']")
    WebElement riskSummaryTable;



    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl03_rptChapterSubPages_ctl01_hlPage\"]")
    WebElement riskSubFundStats;


    @FindBy(xpath = "//div[@class='chartTitle h2']")
    WebElement riskSubFundStatsTitle;


    @FindBy(xpath = "//table[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap']")
    WebElement riskSubFundStatsReport;



    //table[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_heatmap']



    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl03_rptChapterPages_ctl03_rptChapterSubPages_ctl02_hlPage\"]")
    WebElement riskNumberOfDifferentStocks;


    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement riskNumberOfDifferentStocksTitle;
    //Liquidity

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_panChapters\"]/div[5]")
    WebElement liquidity;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl04_rptChapterPages_ctl00_hlPage\"]")
    WebElement liquiditySummary;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl04_rptChapterPages_ctl01_hlPage\"]")
    WebElement liquidityHistory;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl04_rptChapterPages_ctl02_rptChapterSubPages_ctl00_hlPage\"]")
    WebElement liquiditySecurityDetails;

    //Performance

    @FindBy(xpath = "//div[@title='Performance']")
    WebElement performance;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl00_hlPage\"]")
    WebElement performanceSummary;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl01_hlPage\"]")
    WebElement performanceByMarket;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl02_hlPage\"]")
    WebElement performanceBySector;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl03_hlPage\"]")
    WebElement performanceByStyle;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl04_hlPage\"]")
    WebElement performanceByHierarchy;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl05_hlPage\"]")
    WebElement fofPerformance;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl06_hlPage\"]")
    WebElement performanceFOFDetails;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptChapters_ctl05_rptChapterPages_ctl07_hlPage\"]")
    WebElement performanceStyleMine;


    //Sub Fund Gallery

    @FindBy(xpath = "//div[@title='Fund of Funds']")
    WebElement subFundGallery;

    @FindBy(xpath = "//em[contains(text(),'Sub Fund Gallery - Style Exposures')]")
    WebElement subFundGallerySE;

    @FindBy(xpath = "//em[contains(text(),'Sub Fund Gallery - Risk')]")
    WebElement subFundGalleryRisk;

    @FindBy(xpath = "//em[contains(text(),'Sub Fund Gallery - Risk Other')]")
    WebElement subFundGalleryRiskOther;

    @FindBy(xpath = "//em[contains(text(),'Sub Fund Gallery - Region Distribution')]")
    WebElement subFundGalleryRegion;

    @FindBy(xpath = "//em[contains(text(),'Sub Fund Gallery - Sector Distribution')]")
    WebElement subFundGallerySector;

    @FindBy(xpath = "//em[contains(text(),'Sub Fund Gallery - Size Distribution')]")
    WebElement subFundGallerySize;

    @FindBy(xpath = "//em[contains(text(),'Sub Fund Gallery - Style Distribution')]")
    WebElement subFundGalleryStyle;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement subFundGalleryReportsTitle;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_ctl00_labTitle']")
    WebElement subFundGalleryFoFSecurityWeightsTitle;


    @FindBy(xpath = "//em[contains(text(),'Fund of Funds Security Weights')]")
    WebElement subFundGalleryFOFSecurityWeight;

    //Labs

    @FindBy(xpath = "//div[@title='LABS']")
    WebElement labs;

    @FindBy(xpath = "//em[contains(text(),'Asset Tree')]")
    WebElement labsAssetTree;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_ctl00_labTitle']")
    WebElement labsAssetTreeReportTitle;

    @FindBy(xpath = "//em[contains(text(),'Style Scatter')]")
    WebElement labsStyleScatter;

    @FindBy(xpath = "//em[contains(text(),'Tilt XY Snail Trail')]")
    WebElement labsTiltXYSnailTrail;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement labsTiltXYSnailTrailTitle;





    @FindBy(xpath = "//*[@id=\"iconSearch\"]")
    WebElement search;


    //Reports Page

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_labPortfolioName\"]")
    WebElement portfolioNameInTitle;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_labBenchmarkName\"]")
    WebElement BMNameInTitle;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_labSnapshotDate\"]")
    WebElement snapshotDateInTitle;

    @FindBy(xpath = "//div[@class='slideOutLabel twoColumn'][contains(text(),'Portfolio:')]")
    WebElement portfolioLabel;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input\"]")
    WebElement portfolioValue;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_panBenchmark\"]/span[1]")
    WebElement BMLabel;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_labAnalysis\"]")
    WebElement BMValue;

    @FindBy(xpath = "//div[@class='slideOutLabel twoColumn'][contains(text(),'Analysis date:')]")
    WebElement analysisDateLabel;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlSnapshots_Input\"]")
    WebElement analysisDateValue;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_panUniverse\"]/div[1]/span[1]")
    WebElement universeLabel;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_labUniverse\"]")
    WebElement universeValue;

    @FindBy(xpath = "//span[@class='slideOutLabel'][contains(text(),'Currency:')]")
    WebElement currencyLabel;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labCurrency']")
    WebElement currencyValue;

    @FindBy(xpath = "//span[@class='slideOutLabel'][contains(text(),'Classification:')]")
    WebElement classificationLabel;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labClassification']")
    WebElement classificationValue;

    @FindBy(xpath = "//span[@class='slideOutLabel'][contains(text(),'Report Profile:')]")
    WebElement reportProfileLabel;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_report_labReportProfile']")
    WebElement reportProfileValue;

    @FindBy(xpath = "//div[@class='slideOutTitle']")
    WebElement slideOutTitle;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_rptRecent_ctl00_hlRecentPortfolio\"]/span")
    WebElement recentReport;

    //Portfolio Drop Down in reports page

    @FindBy(xpath = "//span[@class='h1']")
    WebElement portfolioNameHeader;

    @FindBy(xpath = "//span[@class='h2']")
    WebElement userReferenceHeader;

    @FindBy(xpath = "//span[@class='h3']")
    WebElement labelsHeader;

    @FindBy(xpath = "//div[@id='ctl00_mainContentPlaceHolder_report_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_MoreResultsBox']//span")
    WebElement portfolioCount;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlSnapshots_DropDown\"]/div/ul/li")
    WebElement analysisDropDownList;

    @FindBy(xpath = "//*[@id='quickSearchItem']/span[2]")
    WebElement firstSearchResult;

    //BM Drop Down in Reports Page


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlAnalysis_Header\"]/span[1]")
    WebElement BMDdReportProfile;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlAnalysis_Header\"]/span[2]")
    WebElement BMDdBM;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlAnalysis_Header\"]/span[3]")
    WebElement BMDdUniverse;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlAnalysis_Header\"]/span[4]")
    WebElement BMDdClass;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlAnalysis_Header\"]/span[5]")
    WebElement BMDdCurrency;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlAnalysis_Input\"]")
    WebElement BMDropdown;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlAnalysis_DropDown\"]/div[2]/ul/li[2]/span[2]")
    WebElement BMDropdownItem;

    public PortfolioReportsPage(WebDriver driver){

        this.driver = driver;

        initElements(Driver, this);
    }


}
