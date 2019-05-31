package com.styleanalytics.enterprise.PeerInsights;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.sql.Driver;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Viswanath on 13/06/2017.
 */
public class PeerInsightsPage {

    WebDriver driver;

    //Peer Insights Landing Page

    @FindBy(xpath = "//*[@id=\"divExistingAnalyses\"]/div[4]/div[3]/div/div[1]/div[9]/a")
    WebElement openReport ;

    @FindBy(xpath = "//div[@class='ui-state-default slick-headerrow-column l1 r1']//input[@type='text']")
    WebElement reportSearchTxtBox ;

    @FindBy(xpath = "//*[@id=\"divExistingAnalyses\"]/div[4]/div[3]/div/div[1]/div[11]/a")
    WebElement deleteReport ;

    @FindBy(xpath = "//div[@id='reportSettingsClose']//a[@href='javascript:;']")
    WebElement rightSideMenu ;


    @FindBy(xpath = "//*[@id='peerGroups']/a")
    WebElement peerInsightsTile ;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_cmdNew_input']")
    WebElement createNewPIReportButton;

    @FindBy(xpath = "//*[@id='txtAnalysisName']")
    WebElement peerReportName;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlPeerGroupProviders_Input']")
    WebElement peerProviderDropDown;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlPeerGroupProviderProducts_Input']")
    WebElement peerGroupRegion;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlPeerGroups_Input']")
    WebElement peerGroupDropDown;

    @FindBy(xpath ="//*[@id='divButtons']/input[2]")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id='divPeerGroupReportSettings']/div/div/div[4]/div[1]")
    WebElement clickOutside;



    /*
    Peer Insights Reports Menu Element Id's

    */


    @FindBy(xpath = "//div[@title='Overview']")
    WebElement piOverviewMainMenu;

    @FindBy(id = "ctl00_mainContentPlaceHolder_rptChapters_ctl00_rptChapterPages_ctl00_hlPage")
    WebElement piOverviewReports;

    @FindBy(id = "ctl00_mainContentPlaceHolder_rptChapters_ctl00_rptChapterPages_ctl01_hlPage")
    WebElement piOverviewMedian;

    @FindBy(xpath = "//div[@title='Style Exposures']")
    WebElement piStyleExposureMainMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl01_rptChapterPages_ctl00_hlPage']")
    WebElement piStyleSkylineMenu;

    @FindBy(xpath = "//*[contains(@id,'_1000_chartDiv-map')]")
    WebElement piStyleSkylineReport;

    @FindBy(xpath = "//body//form//div[1]/div[3]/div/div/div[2]/span")
    WebElement piStyleSkylineReportTitle;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl01_rptChapterPages_ctl01_hlPage']")
    WebElement piSkylineHistoryReportMenu;


    //PeerInsight Menus


    //OverView

    @FindBy(xpath = "//div[@title='Overview']")
    WebElement piOverView;

    @FindBy(id = "ctl00_mainContentPlaceHolder_rptChapters_ctl00_rptChapterPages_ctl00_hlPage")
    WebElement piPeerGroupOverViewMenu;

    @FindBy(id = "ctl00_mainContentPlaceHolder_rptChapters_ctl00_rptChapterPages_ctl01_hlPage")
    WebElement piPeerGroupMedianMenu;



    ///StyleExposureSkyline



    @FindBy(xpath = "//*[contains(@id,'ctl00_labTitle')]")
    WebElement piStyleSkylineTitle;


    @FindBy(xpath = "//div[@title='Style Exposures']")
    WebElement piStyleExposureReportMainMenu;

    @FindBy(id = "ctl00_mainContentPlaceHolder_rptChapters_ctl01_rptChapterPages_ctl00_hlPage")
    WebElement piStyleExposureStyleSkyLineMenu;


    @FindBy(id = "ctl00_mainContentPlaceHolder_rptChapters_ctl01_rptChapterPages_ctl01_hlPage")
    WebElement piStyleExposureStyleSkyLineHistoryMenu;

    @FindBy(id = "ctl00_mainContentPlaceHolder_rptChapters_ctl01_rptChapterPages_ctl02_hlPage")
    WebElement piStyleExposureFundLevelMenu;


    @FindBy(id = "ctl00_mainContentPlaceHolder_rptChapters_ctl01_rptChapterPages_ctl03_hlPage")
    WebElement piStyleExposureFundLevelHeatMapMenu;


   // Distributions


    @FindBy(xpath = "//div[@title='Distributions']")
    WebElement piDistributionReportMainMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl00_hlPage')]")
    WebElement piStyleDistributionMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl01_hlPage')]")
    WebElement piStyleDistributionHistoryMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl02_hlPage')]")
    WebElement piStyleDistributionFundLevelReportMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl03_hlPage')]")
    WebElement piStyleDistributionFundLevelHeatMapReportMenu;



    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl00_hlPage')]")
    WebElement piSizeDistributionMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl01_hlPage')]")
    WebElement piSizeDistributionHistoryMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl02_hlPage')]")
    WebElement piSizeDistributionFundLevelReportMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl03_hlPage')]")
    WebElement piSizeDistributionFundLevelHeatMapReportMenu;



    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl00_hlPage')]")
    WebElement piCountryDistributionMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl01_hlPage')]")
    WebElement piCountryDistributionHistoryMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl02_hlPage')]")
    WebElement piCountryDistributionFundLevelReportMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl03_hlPage')]")
    WebElement piCountryDistributionFundLevelHeatMapReportMenu;



    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl00_hlPage')]")
    WebElement piSectorDistributionMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl01_hlPage')]")
    WebElement piSectorDistributionHistoryMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl02_hlPage')]")
    WebElement piSectorDistributionFundLevelReportMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl03_hlPage')]")
    WebElement piSectorDistributionFundLevelHeatMapReportMenu;



    ///Risk


    @FindBy(xpath = "//div[@title='Risk']")
    WebElement piRiskReportMainMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl00_hlPage')]")
    WebElement piPortfolioRiskRankReportMainMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl01_hlPage')]")
    WebElement piPortfolioRiskAtributionReportMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl02_hlPage')]")
    WebElement piPortfolioRiskHistoryReportMen;


    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl03_hlPage')]")
    WebElement piPortfolioRiskAtributionFundLevel;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl04_hlPage')]")
    WebElement piPortfolioRisMesuresFundLevelHeatMenu;


    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl05_hlPage')]")
    WebElement piPortfolioRiskAtributionFundLevelHeatMap;



    /// Performance


    @FindBy(xpath = "//div[@title='Performance']")
    WebElement piPerformanceReportMainMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl04_rptChapterPages_ctl00_hlPage')]")
    WebElement piPerformenceRiskRankReportMenu;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_rptChapters_ctl04_rptChapterPages_ctl01_hlPage')]")
    WebElement piPortfolioReturnsReportMenu;


    //styleSkylineFundlevel


    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piStyleSkylineFunLevelTitel;

    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piStyleSkylineFundLevelReport;


    //styleSkylineFundlevel Heat map


    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piStyleSkylineFunLevelHeatMapTitel;

    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piStyleSkylineFundLeveHeatMaplReport;




    //Distributions
    //Style distribution
    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_panChapters']/div[3]")
    WebElement piDistributionMainMenu;

    //*[@id="ctl00_mainContentPlaceHolder_report_panChapters"]/div[3]



    //PEER STYLE DISTRIBUTION ACTIVE WEIGHT


    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piDistributionActiveWeightTitel;


    @FindBy(xpath = "//*[contains(@id,'_1000_chartDiv-img')]")
    WebElement piDistributionActiveWeightReport;

    //PEER STYLE DISTRIBUTION FundLevel WEIGHT


    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piDistributionFundLevelTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piDistributionFundLevelReport;


   //STYLE DISTRIBUTION PEER GROUP HEATMAP ACTIVE WEIGHT

    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piDistributionFundLevelHeatMapTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piDistributionFundLevelHeatMapReport;



    //Size DISTRIBUTION PEER GROUP HEATMAP ACTIVE WEIGHT

    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piSizeDistributionTitel;


    @FindBy(xpath = "//*[contains(@id,'_1000_chartDiv-img')]")
    WebElement piSizeDistributionReport;



    //Size DISTRIBUTION Fund level

    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piSizeDistributionFundLevelTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piSizeDistributionFundLevelReport;


    //Size DISTRIBUTION Fund level Heat map

    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piSizeDistributionFundLevelHeatMapTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piSizeDistributionFundLevelHeatMapReport;


    //Country DISTRIBUTION
    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piCountryDistributionTitel;


    @FindBy(xpath = "//*[contains(@id,'_1000_chartDiv-img')]")
    WebElement piCountryDistributionReport;




    //Country DISTRIBUTION Fund level

    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piCountryDistributionFundLevelTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piCountryDistributionFundLevelReport;


    //Country DISTRIBUTION Fund level heat map
    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piCountryDistributionFundLevelHeatMapTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piCountryDistributionFundLevelHeatMapReport;



    //Sector DISTRIBUTION
    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piSectorDistributionTitel;


    @FindBy(xpath = "//*[contains(@id,'_1000_chartDiv-img')]")
    WebElement piSectorDistributionReport;


    //Country DISTRIBUTION Fund level

    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piSectorDistributionFundLevelTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piSectorDistributionFundLevelReport;


    //Country DISTRIBUTION Fund level heat map
    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piSectorDistributionFundLevelHeatMapTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piSectorDistributionFundLevelHeatMapReport;

    //Risk Portfolio risk Rank


    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piPortfolioRiskRankTitel;


    @FindBy(xpath = "//*[contains(@id,'_1000_chartDiv-graph-id0-plotset-plot-3-node-0')]")
    WebElement piPortfolioRiskRankReport;



    //Risk Peer Risk Attribution


    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piPeerRiskAttributionTitel;


    @FindBy(xpath = "//*[contains(@id,'_1000_chartDiv-graph-id0-plotset-plot-7-node-3')]")
    WebElement piPeerRiskAttributionReport;


    //Risk Attribution fund level

    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piRiskAttributionFundLevelTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piRiskAttributionFundLevelReport;



    //Risk Attribution fund level heat map

    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piRiskMesuresFundLevelHeatMapTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piRiskMesuresFundLevelHeatMapReport;

    //Risk Attribution fund level heat map-2

    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piRiskAttributionFundLevelHeatMapTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piRiskAttributionFundLevelHeatMapReport;



    //performence Rank

    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piPerformenceRankTitel;


    @FindBy(xpath = "//*[contains(@id,'_1000_chartDiv-graph-id0-plotset-plot-3-node-0')]")
    WebElement piPerformenceRankReport;


    //PerformenceReturns
    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement piPerformenceReturnsTitel;


    @FindBy(xpath = "//*[contains(@class,'slick-viewport slick-viewport-top slick-viewport-right')]")
    WebElement piPerformenceReturnsReport;



    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl00_hlPage']")
    WebElement piStyleDistributionOverview;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl01_hlPage']")
    WebElement piStyleDistributionHistoryReportMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl02_hlPage']")
    WebElement piStyleDistributionFundLevelMenu;

    @FindBy(xpath = "//span[contains(@id,'_ctl00_labTitle')]")
    WebElement piStyleDistributionFundLevelTitle;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl00_rptChapterSubPages_ctl03_hlPage']")
    WebElement piStyleDistribtionFundLevelHeatmapMenu;

    //Size Distribution

    @FindBy(xpath ="//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl00_hlPage']")
    WebElement piSizeDistributionOverview;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl01_hlPage']")
    WebElement piSizeDistributionHistoryReportMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl02_hlPage']")
    WebElement piSizeDistributionFundLevelMenu;

    @FindBy(xpath = "//span[contains(@id,'_ctl00_labTitle')]")
    WebElement piSizeDistributionFundLevelTitle;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl01_rptChapterSubPages_ctl03_hlPage']")
    WebElement piSizeDistribtionFundLevelHeatmapMenu;

    //Country Distribution

    @FindBy(xpath ="//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl00_hlPage']")
    WebElement piCountryDistributionOverview;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl01_hlPage']")
    WebElement piCountryDistributionHistoryReportMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl02_hlPage']")
    WebElement piCountryDistributionFundLevelMenu;

    @FindBy(xpath = "//span[contains(@id,'_ctl00_labTitle')]")
    WebElement piCountryDistributionFundLevelTitle;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl02_rptChapterSubPages_ctl03_hlPage']")
    WebElement piCountryDistributionFundLevelHeatmapMenu;

    //Country Distribution

    @FindBy(xpath ="//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl00_hlPage']")
    WebElement piSectorDistributionOverview;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl01_hlPage']")
    WebElement piSectorDistributionHistoryReportMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl02_hlPage']")
    WebElement piSectorDistributionFundLevelMenu;

    @FindBy(xpath = "//span[contains(@id,'_ctl00_labTitle')]")
    WebElement piSectorDistributionFundLevelTitle;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl02_rptChapterPages_ctl03_rptChapterSubPages_ctl03_hlPage']")
    WebElement piSectorDistributionFundLevelHeatmapMenu;

    //Risk

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_panChapters']/div[4]")
    WebElement piRiskMainMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl00_hlPage']")
    WebElement piPortfolioRiskRankMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl01_hlPage']")
    WebElement piRiskAttributionMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl02_hlPage']")
    WebElement piRiskHistoryMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl03_hlPage']")
    WebElement piRiskAttributionFundLevelMenu;

    @FindBy(xpath = "//span[contains(@id,'_ctl00_labTitle')]")
    WebElement piRiskFundLevelTitle;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl04_hlPage']")
    WebElement piRiskMeasureFundLevelHeatmapMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl03_rptChapterPages_ctl05_hlPage']")
    WebElement piRiskAttributionFundLevelHeatmapMenu;

    //Performance

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_panChapters']/div[5]")
    WebElement piPerformanceMainMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl04_rptChapterPages_ctl00_hlPage']")
    WebElement piPerformanceRankMenu;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_rptChapters_ctl04_rptChapterPages_ctl01_hlPage']")
    WebElement piPortfolioReturnsMenu;

    @FindBy(xpath = "//span[contains(@id,'_ctl00_labTitle')]")
    WebElement piPerformanceTitle;



    /// Fund Report Page

    @FindBy(xpath = "//*[@id=\"pagePane0\"]/div[1]")
    WebElement piFundReportStyleExposureMenus;


    //*[@id="spanShowMegaMenu"]/div/div[2]

    //Fund report Overview title

    @FindBy(xpath = "//*[@id=\"pagePane0\"]/div[1]")
    WebElement piFundReportOverviewTitle;

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock0\"]/div[2]")
    WebElement piFundReportStyleSkyLineTitle;


    @FindBy(xpath = "//*[@id=\"pagePane0_divContent0-img\"]")
    WebElement piFundReportStyleSkyLineReport;


    //Fund report Overview Region distribution

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock1\"]/div[2]")
    WebElement piFundReportRegionDistributionTitle;


    @FindBy(xpath = "//*[@id=\"pagePane0_divContent1-img\"]")
    WebElement piFundReportRegionDistributionReport;


    //Fund report Overview Sector distribution

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock2\"]/div[2]")
    WebElement piFundReportSectorDistributionTitle;

    @FindBy(xpath = "//*[@id=\"pagePane0_divContent2\"]")
    WebElement piFundReportSectorDistributionReport;


    //Fund report Overview Style distribution


    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock3\"]/div[2]")
    WebElement piFundReportStyleDistributionTitle;

    @FindBy(xpath = "//*[@id=\"pagePane0_divContent3-img\"]")
    WebElement piFundReportStyleDistributionReport;



    //Fund report Overview Size distribution


    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock4\"]/div[2]")
    WebElement piFundReportSizeDistributionTitle;

    @FindBy(xpath = "//*[@id=\"pagePane0_divContent4-img\"]")
    WebElement piFundReportSizeDistributionReport;


    //Fund report Overview Risk Attribution

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock6\"]/div[2]")
    WebElement piFundReportRiskAttributionTitle;

    @FindBy(xpath = "//*[@id=\"pagePane0_divContent6-img\"]")
    WebElement piFundReportRiskAttributionReport;


    //Fund report Overview Risk Estimates

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock5\"]/div[2]")
    WebElement piFundReportRiskEstimatesTitle;

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock5\"]")
    WebElement piFundReportRiskEstimatesReport;

    //Fund report Overview Top Risk Contributors

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock8\"]/div[2]")
    WebElement piFundReportTopRiskContributorsTitle;

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock8\"]")
    WebElement piFundReportTopRiskContributorsReport;


    //Fund report Overview Holdings by assets

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock7\"]/div[2]")
    WebElement piFundReportHoldingsByAssetTitle;

    @FindBy(xpath = "//*[@id=\"pagePane0_divContent7\"]/table")
    WebElement piFundReportHoldingsByAssetReport;



    //Fund report Largest OverWeights

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock9\"]/div[2]")
    WebElement piFundReportLargestOverWeightsTitle;

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock9\"]")
    WebElement piFundReportLargestOverWeightsReport;


    //Fund report Largest UnderWeights

    @FindBy(xpath = "//*[@id=\"pagePane0_divBlock10\"]/div[2]")
    WebElement piFundReportLargestUnderWeightsTitle;

    @FindBy(xpath = "//*[@id=\"pagePane0_divContent10\"]")
    WebElement piFundReportLargesUnderWeightsReport;



    // Style exposure icon menu
    @FindBy(xpath = "//*[@id=\"spanShowMegaMenu\"]/div/div[2]")
    WebElement piFundReportstyleExposureMainMenu;


    // Style exposure Summary menu
    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[2]/div[2]/a")
    WebElement piFundReportStyleExposureSummaryMenu;

    // Style exposure  PORTFOLIO STYLE SKYLINE Title
    @FindBy(xpath = "//*[@id=\"pagePane1_divBlock0\"]/div[2]")
    WebElement piFundReportStyleExposurePortfolioStyleSkylineTitle;


    // Style exposure  PORTFOLIO STYLE SKYLINE Report
    @FindBy(xpath = "//*[@id=\"pagePane1_divContent0-img\"]")
    WebElement piFundReportStyleExposurePortfolioStyleSkylineBlock;


    // Style exposure  PORTFOLIO STYLE SKYLINE SECTOR ADJUSTED Title
    @FindBy(xpath = "//*[@id=\"pagePane1_divBlock1\"]/div[2]")
    WebElement piFundReportStyleExposurePortfolioStyleSkylineSectorAdjustedTitle;


    // Style exposure  PORTFOLIO STYLE SKYLINE SECTOR ADJUSTED Report
    @FindBy(xpath = "//*[@id=\"pagePane1_divContent1-img\"]")
    WebElement piFundReportStyleExposurePortfolioStyleSkylineSectorAdjustedBlock;



    // Style exposure  PORTFOLIO STYLE SKYLINE Country ADJUSTED Title
    @FindBy(xpath = "//*[@id=\"pagePane1_divBlock2\"]/div[2]")
    WebElement piFundReportStyleExposurePortfolioStyleSkylineCountryAdjustedTitle;


    // Style exposure  PORTFOLIO STYLE SKYLINE Country ADJUSTED Report
    @FindBy(xpath = "//*[@id=\"pagePane1_divContent2-img\"]")
    WebElement piFundReportStyleExposurePortfolioStyleSkylineCountryAdjustedBlock;


    // Style exposure  PORTFOLIO STYLE SKYLINE Sector and Country ADJUSTED Title
    @FindBy(xpath = "//*[@id=\"pagePane1_divBlock3\"]/div[2]")
    WebElement piFundReportStyleExposurePortfolioStyleSkylineSectorAndCountryAdjustedTitle;


    // Style exposure  PORTFOLIO STYLE SKYLINE Sector and Country ADJUSTED Report
    @FindBy(xpath = "//*[@id=\"pagePane1_divContent3-img\"]")
    WebElement piFundReportStyleExposurePortfolioStyleSkylineSectorAndCountryAdjustedBlock;


    //Style Skyline Range Title


    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[2]/div[3]/a")
    WebElement piFundReportStyleExposureStyleSkylineRangeMenu;

    @FindBy(xpath = "//*[@id=\"pagePane2_divBlock0\"]/div[2]")
    WebElement piFundReportStyleExposureStyleSkylineRangeTitle;

    @FindBy(xpath = "//*[@id=\"pagePane2_divContent0-img\"]")
    WebElement piFundReportStyleExposureStyleSkylineRangeBlock;


    //Style Tilt Heat Map


    @FindBy(xpath = "//*[@id=\"pagePane3\"]/div[1]")
    WebElement piFundReportStyleTiltHeatMapTitle;

    @FindBy(xpath = "//*[@id=\"pagePane3_divBlock0\"]")
    WebElement piFundReportStyleTiltHeatMapBlock;



    //PI Fund Report style distribution menu

    @FindBy(xpath = "//*[@id=\"spanShowMegaMenu\"]/div/div[3]")
    WebElement piFundReportDistributionMenu;

    //*[@id="spanShowMegaMenu"]/div/div[3]



    //Fund Report REGION DISTRIBUTION
    @FindBy(xpath = "//*[@id=\"pagePane4_divBlock0\"]/div[2]")
    WebElement piFundReportDistributionRegionDistributionTitle;


    @FindBy(xpath = "//*[@id=\"pagePane4_divContent0-img\"]")
    WebElement piFundReportDistributionRegionDistributionBlock;



    //Fund Report REGION Range
    @FindBy(xpath = "//*[@id=\"pagePane4_divBlock1\"]/div[2]")
    WebElement piFundReportDistributionRegionRangeTitle;


    @FindBy(xpath = "//*[@id=\"pagePane4_divContent1-img\"]")
    WebElement piFundReportDistributionRegionRangeBlock;


    //Fund Report REGION Trails
    @FindBy(xpath = "//*[@id=\"pagePane4_divBlock2\"]/div[2]")
    WebElement piFundReportDistributionRegionTrailsTitle;


    @FindBy(xpath = "//*[@id=\"pagePane4_divContent2-img\"]")
    WebElement piFundReportDistributionRegionTrailsBlock;


    //Fund Report Country distribution

    @FindBy(xpath = "//*[@id=\"pagePane5_divBlock0\"]/div[2]")
    WebElement piFundReportDistributionCountryDistributionTitle;


    @FindBy(xpath = "//*[@id=\"pagePane5_divContent0-img\"]")
    WebElement piFundReportDistributionCountryDistributionBlock;


    //Fund Report Country Range

    @FindBy(xpath = "//*[@id=\"pagePane5_divBlock1\"]/div[2]")
    WebElement piFundReportDistributionCountryRangeTitle;


    @FindBy(xpath = "//*[@id=\"pagePane5_divContent1-img\"]")
    WebElement piFundReportDistributionCountryRangeBlock;


    //Fund Report Country Trails

    @FindBy(xpath = "//*[@id=\"pagePane5_divBlock2\"]/div[2]")
    WebElement piFundReportDistributionCountryTrailsTitle;


    @FindBy(xpath = "//*[@id=\"pagePane5_divContent2-img\"]")
    WebElement piFundReportDistributionCountryTrailsBlock;


    //Fund Report Sector distribution

    @FindBy(xpath = "//*[@id=\"pagePane6_divBlock0\"]/div[2]")
    WebElement piFundReportDistributionSectorDistributionTitle;


    @FindBy(xpath = "//*[@id=\"pagePane6_divContent0-img\"]")
    WebElement piFundReportDistributionSectorDistributionBlock;


    //Fund Report sector Range

    @FindBy(xpath = "//*[@id=\"pagePane6_divBlock1\"]/div[2]")
    WebElement piFundReportDistributionSectorRangeTitle;


    @FindBy(xpath = "//*[@id=\"pagePane6_divContent1-img\"]")
    WebElement piFundReportDistributionSectorRangeBlock;


    //Fund Report Sector Trails

    @FindBy(xpath = "//*[@id=\"pagePane6_divBlock2\"]/div[2]")
    WebElement piFundReportDistributionSectorTrailsTitle;


    @FindBy(xpath = "//*[@id=\"pagePane6_divContent2-img\"]")
    WebElement piFundReportDistributionSectorTrailsBlock;



    //Fund Report Size distribution

    @FindBy(xpath = "//*[@id=\"pagePane7_divBlock0\"]/div[2]")
    WebElement piFundReportSizeDistributionSizeDistributionTitle;


    @FindBy(xpath = "//*[@id=\"pagePane7_divContent0-img\"]")
    WebElement piFundReportSizeDistributionSizeDistributionBlock;


    //Fund Report Size distribution Details

    @FindBy(xpath = "//*[@id=\"pagePane7_divBlock1\"]/div[2]")
    WebElement piFundReportSizeDistributionDistributionDetailsTitle;


    @FindBy(xpath = "//*[@id=\"pagePane7_divBlock1\"]")
    WebElement piFundReportSizeDistributionDistributionDetailsBlock;


    //Fund Report Size distribution Sector Adjusted

    @FindBy(xpath = "//*[@id=\"pagePane7_divBlock2\"]/div[2]")
    WebElement piFundReportSizeDistributionSectorAdjustedTitle;


    @FindBy(xpath = "//*[@id=\"pagePane7_divContent2-img\"]")
    WebElement piFundReportSizeDistributionSectorAdjustedBlock;


    //Fund Report Size distribution DETails SA

    @FindBy(xpath = "//*[@id=\"pagePane7_divBlock3\"]/div[2]")
    WebElement piFundReportSizeDistributionDistributionDetailsSATitle;


    @FindBy(xpath = "//*[@id=\"pagePane7_divContent3\"]/table")
    WebElement piFundReportSizeDistributionDistributionDetailsSABlock;


    //Fund Report Size distribution Country Adjusted

    @FindBy(xpath = "//*[@id=\"pagePane7_divBlock4\"]/div[2]")
    WebElement piFundReportSizeDistributionSizeDistributionCountryAdjustedTitle;


    @FindBy(xpath = "//*[@id=\"pagePane7_divContent4-img\"]")
    WebElement piFundReportSizeDistributionSizeDistributionCountryAdjustedBlock;


    //Fund Report Size distribution Details CA

    @FindBy(xpath = "//*[@id=\"pagePane7_divBlock5\"]/div[2]")
    WebElement piFundReportSizeDistributionSizeDistributionDetailsCATitle;


    @FindBy(xpath = "//*[@id=\"pagePane7_divContent5\"]/table")
    WebElement piFundReportSizeDistributionSizeDistributionDetailsCABlock;


    //Fund Report Size distribution  Country andSector Adjusted

    @FindBy(xpath = "//*[@id=\"pagePane7_divBlock6\"]/div[2]")
    WebElement piFundReportSizeDistributionSizeDistributionCountrySectorAdjustedTitle;


    @FindBy(xpath = "//*[@id=\"pagePane7_divContent6-img\"]")
    WebElement piFundReportSizeDistributionSizeDistributionCountrySectorAdjustedBlock;


    //Fund Report Size distribution Details CASA

    @FindBy(xpath = "//*[@id=\"pagePane7_divBlock7\"]/div[2]")
    WebElement piFundReportSizeDistributionSizeDistributionDetailsCASATitle;


    @FindBy(xpath = "//*[@id=\"pagePane7_divContent7\"]/table")
    WebElement piFundReportSizeDistributionSizeDistributionDetailsCASABlock;


    //*****Fund Report Size distribution History****


    //Fund Report SIZE DISTRIBUTION TRAILS

    @FindBy(xpath = "//*[@id=\"pagePane8_divBlock0\"]/div[2]")
    WebElement piFundReportSizeDistributionHistorySizeDistributionTrailsTitle;


    @FindBy(xpath = "//*[@id=\"pagePane8_divContent0-img\"]")
    WebElement piFundReportSizeDistributionHistorySizeDistributionTrailsBlock;



    //Fund Report SIZE DISTRIBUTION Sector Adjusted

    @FindBy(xpath = "//*[@id=\"pagePane8_divBlock1\"]/div[2]")
    WebElement piFundReportSizeDistributionHistorySizeDistributionTrailsSectorAdjustedTitle;


    @FindBy(xpath = "//*[@id=\"pagePane8_divContent1-img\"]")
    WebElement piFundReportSizeDistributionHistorySizeDistributionTrailsSectorAdjustedBlock;


    //Fund Report SIZE DISTRIBUTION Country Adjusted

    @FindBy(xpath = "//*[@id=\"pagePane8_divBlock2\"]/div[2]")
    WebElement piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAdjustedTitle;


    @FindBy(xpath = "//*[@id=\"pagePane8_divContent2-img\"]")
    WebElement piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAdjustedBlock;


    //Fund Report SIZE DISTRIBUTION Country and Sector Adjusted

    @FindBy(xpath = "//*[@id=\"pagePane8_divBlock3\"]/div[2]")
    WebElement piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAndSectorAdjustedTitle;


    @FindBy(xpath = "//*[@id=\"pagePane8_divContent3-img\"]")
    WebElement piFundReportSizeDistributionHistorySizeDistributionTrailsCountryAndSectorAdjustedBlock;



    ///*****--- STYLE DISTRIBUTION OVERVIEW ----******/////


    //Fund Report Style DISTRIBUTION

    @FindBy(xpath = "//*[@id=\"pagePane9_divBlock0\"]/div[2]")
    WebElement piFundReportStyleDistributionOverViewStyleDistributionTitle;


    @FindBy(xpath = "//*[@id=\"pagePane9_divContent0-img\"]")
    WebElement piFundReportStyleDistributionOverViewStyleDistributionBlock;



    //Fund Report Style DISTRIBUTION Details

    @FindBy(xpath = "//*[@id=\"pagePane9_divBlock1\"]/div[2]")
    WebElement piFundReportStyleDistributionOverViewDistributionDetailsTitle;


    @FindBy(xpath = "//*[@id=\"pagePane9_divContent1\"]/table")
    WebElement piFundReportStyleDistributionOverViewDistributionDetailsBlock;


    //Fund Report Style DISTRIBUTION Sector Adjusted

    @FindBy(xpath = "//*[@id=\"pagePane9_divBlock2\"]/div[2]")
    WebElement piFundReportStyleDistributionOverViewStyleDistributionSectorAdjustedTitle;


    @FindBy(xpath = "//*[@id=\"pagePane9_divContent2-img\"]")
    WebElement piFundReportStyleDistributionOverViewStyleDistributionSectorAdjustedBlock;


    //Fund Report Style DISTRIBUTION Details SA


    @FindBy(xpath = "//*[@id=\"pagePane9_divBlock3\"]/div[2]")
    WebElement piFundReportStyleDistributionOverViewDistributionDetailsSATitle;


    @FindBy(xpath = "//*[@id=\"pagePane9_divContent3\"]/table")
    WebElement piFundReportStyleDistributionOverViewDistributionDetailsSABlock;


    //Fund Report Style DISTRIBUTION Details Country Adjusted

    @FindBy(xpath = "//*[@id=\"pagePane9_divBlock4\"]/div[2]")
    WebElement piFundReportStyleDistributionOverViewStyleDistributionCountryAdjustedTitle;


    @FindBy(xpath = "//*[@id=\"pagePane9_divContent4-img\"]")
    WebElement piFundReportStyleDistributionOverViewStyleDistributionCountryAdjustedBlock;


    //Fund Report Style DISTRIBUTION  Details CA

    @FindBy(xpath = "//*[@id=\"pagePane9_divBlock5\"]/div[2]")
    WebElement piFundReportStyleDistributionOverViewDistributionDetailsCATitle;


    @FindBy(xpath = "//*[@id=\"pagePane9_divContent5\"]/table")
    WebElement piFundReportStyleDistributionOverViewDistributionDetailsCABlock;


    //Fund Report Style DISTRIBUTION  COUNTRY AND SECTOR ADJUSTED

    @FindBy(xpath = "//*[@id=\"pagePane9_divBlock6\"]/div[2]")
    WebElement piFundReportStyleDistributionOverViewStyleDistributionCountryAndSectorAdjustedTitle;


    @FindBy(xpath = "//*[@id=\"pagePane9_divContent6-img\"]")
    WebElement piFundReportStyleDistributionOverViewStyleDistributionCountryAndSectorAdjustedBlock;

   //Fund Report Style DISTRIBUTION Details CASA

    @FindBy(xpath = "//*[@id=\"pagePane9_divBlock7\"]/div[2]")
    WebElement piFundReportStyleDistributionOverViewDistributionDetailsCASATitle;


    @FindBy(xpath = "//*[@id=\"pagePane9_divContent7\"]/table")
    WebElement piFundReportStyleDistributionOverViewDistributionDetailsCASABlock;



    ////*** //Fund Report Style Risk---****////



    @FindBy(xpath = "//*[@id=\"spanShowMegaMenu\"]/div/div[4]")
    WebElement piFundReportRiskMenu;



    //Fund ReportRisk Attribution

    @FindBy(xpath = "//*[@id=\"pagePane10_divBlock1\"]/div[2]")
    WebElement piFundReportRiskRiskAttributionTitle;


    @FindBy(xpath = "//*[@id=\"pagePane10_divContent1-img\"]")
    WebElement piFundReportRiskRiskAttributionBlock;


    //Fund ReportRisk Estimates

    @FindBy(xpath = "//*[@id=\"pagePane10_divBlock0\"]/div[2]")
    WebElement piFundReportRiskRiskEstimatesTitle;


    @FindBy(xpath = "//*[@id=\"pagePane10_divContent0\"]/table")
    WebElement piFundReportRiskRiskEstimatesBlock;


    //Fund ReportRisk Holdings by Asset

    @FindBy(xpath = "//*[@id=\"pagePane10_divBlock2\"]/div[2]")
    WebElement piFundReportRiskHoldingsByAssetTitle;

    @FindBy(xpath = "//*[@id=\"pagePane10_divContent2\"]/table")
    WebElement piFundReportRiskHoldingsByAssetBlock;


    //Fund ReportRisk Tracking Error

    @FindBy(xpath = "//*[@id=\"pagePane10_divBlock4\"]/div[2]")
    WebElement piFundReportRiskTrackingErrorTitle;

    @FindBy(xpath = "//*[@id=\"pagePane10_divContent4-img\"]")
    WebElement piFundReportRiskTrackingErrorBlock;


    //Fund Report Risk Range History

    @FindBy(xpath = "//*[@id=\"pagePane10_divBlock3\"]/div[2]")
    WebElement piFundReportRiskRangeHistoryTitle;

    @FindBy(xpath = "//*[@id=\"pagePane10_divContent3-img\"]")
    WebElement piFundReportRiskRangeHistoryBlock;



    //Fund Report Risk By Style

    @FindBy(xpath = "//*[@id=\"pagePane10_divBlock5\"]/div[2]")
    WebElement piFundReportRiskByStyleTitle;

    @FindBy(xpath = "//*[@id=\"pagePane10_divContent5\"]/table")
    WebElement piFundReportRiskByStyleBlock;


    //Fund Report Risk TOP RISK CONTRIBUTORS


    @FindBy(xpath = "//*[@id=\"pagePane10_divBlock6\"]/div[2]")
    WebElement piFundReportRiskTopRiskContributorsTitle;

    @FindBy(xpath = "//*[@id=\"pagePane10_divContent6\"]/table")
    WebElement piFundReportRiskTopRiskContributorsBlock;



    //Fund Report  Security Details ///


    //Fund Report Security LARGEST ABSOLUTE WEIGHT

    @FindBy(xpath = "//*[@id=\"pagePane11_divBlock0\"]/div[2]")
    WebElement piFundReportRiskSecurityLargestAbsoluteWeightTitle;

    @FindBy(xpath = "//*[@id=\"pagePane11_divContent0\"]/table")
    WebElement piFundReportRiskSecurityLargestAbsoluteWeightBlock;


    //Fund Report Security LARGEST Over WEIGHT

    @FindBy(xpath = "//*[@id=\"pagePane11_divBlock1\"]/div[2]")
    WebElement piFundReportRisSecurityLargestOverWeightTitle;

    @FindBy(xpath = "//*[@id=\"pagePane11_divContent1\"]/table")
    WebElement piFundReportRiskSecurityLargestOverWeightBlock;


    //Fund Report Security LARGEST Under WEIGHT

    @FindBy(xpath = "//*[@id=\"pagePane11_divBlock2\"]/div[2]")
    WebElement piFundReportRiskSecurityLargestUnderWeightTitle;

    @FindBy(xpath = "//*[@id=\"pagePane11_divContent2\"]/table")
    WebElement piFundReportRiskSecurityLargestUnderWeightBlock;


    // Report Menus

    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[2]/div[2]/a/em")
    WebElement styleExposureSummaryReport;

    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[2]/div[3]/a")
    WebElement styleExposureRangeReport;

    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[2]/div[4]/a")
    WebElement styleExposureTiltHeatMapReport;

    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[3]/div[2]/a")
    WebElement distribtuionRegionOverview;

//*[@id="divMegaMenu"]/div[3]/div[2]/a/em

    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[3]/div[3]/a/em")
    WebElement distribtuionCountryOverview;

    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[3]/div[4]/a/em")
    WebElement distribtuionSectorOverview;

    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[3]/div[5]/a/em")
    WebElement distribtuionSizeOverview;

    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[3]/div[7]/a/em")
    WebElement distribtuionStyleOverview;


    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[3]/div[6]/a/em")
    WebElement distribtuionSizeHistoryOverview;

    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[4]/div[2]/a/em")
    WebElement riskOverviewReport;

    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[4]/div[3]/a/em")
    WebElement riskSecurityDetailsReport;



    //overView menu
    @FindBy(xpath = "//*[@id=\"spanShowMegaMenu\"]/div/div[1]")
    WebElement overViewMenu;

    @FindBy(xpath = "//*[@id=\"divMegaMenu\"]/div[1]/div[2]/a/em")
    WebElement overViewSubMenu;


    //Fund Report Download

    @FindBy(xpath = "//img[@id='ctl00_mainContentPlaceHolder_Image1']")
    WebElement fundReportDownloadIcon;

    @FindBy(xpath = "//*[@id=\"divTemplateList\"]/div[4]/div[1]/div[2]/div[1]/input")
    WebElement fundReportDownloadTemplateSearch;



    @FindBy(xpath = "//*[@id=\"divTemplateList\"]/div[4]/div[3]/div/div[1]/div[4]/a")
    WebElement fundreportDownloadButton;




    ///Peerinsight page fund report Drilldown

    //Style Skyline Drilldown

    @FindBy(xpath ="//*[@id=\"pagePane0_divContent0-graph-id1-plotset-plot-0-node-0\"]")
    WebElement overViewStyleSkylineDrilldown;

    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_RadTabStripFactorDecompostion\"]/div/ul/li[1]/a/span/span/span")
    WebElement styleSkylineDrilldownTiltContributionTitle;

    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_RadTabStripFactorDecompostion\"]/div/ul/li[2]/a/span/span/span")
    WebElement styleSkylineDrilldownFactorReturnTitle;

    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_RadTabStripFactorDecompostion\"]/div/ul/li[3]/a/span/span/span")
    WebElement styleSkylineDrilldownFactorDisperisionTitle;

    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_rtsSecurityView_SecurityViewTabStrip\"]/div/ul/li/a/span/span/span")
    WebElement styleSkylineDrilldownTop10Bottom10Title;


    //SectorDistribution Drilldown


    @FindBy(xpath ="//*[@id=\"pagePane0_divContent2-graph-id0-plotset-plot-0-node-0\"]")
    WebElement sectorDistributionDrilldown;

    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_labSubTitle\"]")
    WebElement sectorDistributionConsDiscTitle;


    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_lnkSecurityList\"]")
    WebElement sectorDistributionReport;


    //Style Distribution Drilldown




    @FindBy(xpath ="//*[@id=\"pagePane0_divContent3-graph-id0-plotset-plot-0-node-0\"]")
    WebElement styleDistributionDrillDown;


    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_ctl00_labTitle\"]")
    WebElement styleDistributionTitle;

    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_tblDistributionCutpoints\"]")
    WebElement styleDistributionDetailsReport;


    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_lblSecurityContextDescription\"]")
    WebElement styleDistributionSecuritiesInLargeValueTitle;


    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_panSecurities\"]")
    WebElement styleDistributiontop10Bottom10Report;




    //Style Distribution Drilldown


    @FindBy(xpath ="//*[@id=\"pagePane0_divContent4-graph-id0-plotset-plot-0-node-2\"]")
    WebElement sizeDistributionDrillDown;

    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_ctl00_labTitle\"]")
    WebElement sizeDistributionTitle;

    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_tblDistributionCutpoints\"]")
    WebElement sizeDistributionDetailsReport;


    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_lblSecurityContextDescription\"]")
    WebElement sizeDistributionSecuritiesInMegaTitle;


    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_panSecurities\"]")
    WebElement sizeDistributionTop10Bottom10Report;


    //Risk Attribution Drilldown


    //*[@id="pagePane0_divContent6-graph-id0-plotset-plot-0-node-0"]

    @FindBy(xpath ="//*[@id=\"pagePane0_divContent6-graph-id0-plotset-plot-0-node-0\"]")
    WebElement riskAttributionDrillDown;

    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_ctl00_labTitle\"]")
    WebElement riskAttributionContributionToTrackingErrorTitle;


    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_ctl01_labTitle\"]")
    WebElement riskAttributionContributionToCurrencyRiskTitle;


    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_ctl02_labTitle\"]")
    WebElement riskAttributionContributionActiveWeightTitle;


    //style Exposure Range Drill downs


    @FindBy(xpath ="//*[@id=\"pagePane2_divContent0-graph-id1-plotset-plot-0-node-4\"]")
    WebElement StyleExposureRangeDrillDown;

    @FindBy(xpath ="//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]")
    WebElement StyleExposureRangeReport;


    //Risk Range Drilldowns

    @FindBy(xpath ="//*[@id=\"pagePane10_divContent3-graph-id0-plotset-plot-0-node-8\"]")
    WebElement riskRangeDrillDown;

    @FindBy(xpath ="//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]")
    WebElement riskRangeReport;


    //Risk Tracking Error Drilldowns

    @FindBy(xpath ="//*[@id=\"pagePane10_divContent4-graph-id0-plotset-plot-0-node-0\"]")
    WebElement riskTrackingErrorDrillDown;

    @FindBy(xpath ="//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]")
    WebElement riskTrackingErrorReport;

    /****
     *Sync
     */

    @FindBy(xpath ="//*[contains(@class,'rwWindowContent rwExternalContent rwLoading')]")
    WebElement drillDownLoading;




    public void goToPeerInsightLandingPage(String url) throws IOException {

        driver.get(url+"/PeerGroups/PeerGroupSelector.aspx");

    }



    public void accessPeerInsight(String reportName) throws Exception {

        try {

            reportSearchTxtBox.sendKeys(reportName);

            openReport.click();

            Wait.untilJqueryIsDone(driver,60);

        }catch (Exception e){

            throw new Exception("Failed find report: "+e.getStackTrace());

        }

    }

    public void openFundReport(String portfolioName) throws InterruptedException {

        driver.findElement(By.xpath("//area[contains(@id,'_1000_chartDiv-graph-id1-plotset-plot-1-node-0')]")).click();

        Wait.waitForElementToDisappear(driver,20,drillDownLoading);

        driver.switchTo().frame(0);

        //WebElement pName = driver.findElement(By.cssSelector(".slick-column-name"));

        //Need to find the first portfolio displayed in the drill down

        driver.findElement(By.cssSelector(".ui-state-default.slick-headerrow-column.l0.r0>input")).sendKeys(portfolioName);

        Thread.sleep(2000);


        WebElement searhResult = driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_SummaryGrid_panGridSummaryStyleExposures']/div[4]/div[3]/div/div/div[1]"));
        String searhResultText = searhResult.getText();
        Assert.assertEquals(searhResultText, portfolioName);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_SummaryGrid_panGridSummaryStyleExposures\"]/div[5]/div[3]/div/div[1]/div[2]/a")).click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);

        Thread.sleep(10000);

    }

    public void goToPeerInsightsReportsMenu(String reportName, WebElement reportSubMenu) throws InterruptedException {

        Actions actions = new Actions(driver);


        if (reportName.equalsIgnoreCase("PeerGroupOverview") || reportName.equalsIgnoreCase("PeerGroupOverviewMedian")) {

            actions.moveToElement(piOverviewMainMenu).build().perform();
            // peerInsightsPage.piOverviewMainMenu.click();

        } else if (reportName.equalsIgnoreCase("PeerStyleSkyline")
                || reportName.equalsIgnoreCase("PeerStyleSkylineHistory")
                || reportName.equalsIgnoreCase("StyleSkylineFundLevel")
                || reportName.equalsIgnoreCase("StyleSkylineFundLevelHeatMap")) {

            actions.moveToElement(piStyleExposureMainMenu).build().perform();

            //peerInsightsPage.piStyleExposureMainMenu.click();

        } else if (reportName.equalsIgnoreCase("PeerStyleDistribution") ||
                reportName.equalsIgnoreCase("PeerStyleDistributionHistory") ||
                reportName.equalsIgnoreCase("PeerStyleDistributionFundLevel") ||
                reportName.equalsIgnoreCase("PeerStyleDistributionFundLevelHeatMap") ||

                reportName.equalsIgnoreCase("PeerSizeDistribution") ||
                reportName.equalsIgnoreCase("PeerSizeDistributionHistory") ||
                reportName.equalsIgnoreCase("PeerSizeDistributionFundLevel") ||
                reportName.equalsIgnoreCase("PeerSizeDistributionFundLevelHeatMap") ||

                reportName.equalsIgnoreCase("PeerCountryDistribution") ||
                reportName.equalsIgnoreCase("PeerCountryDistributionHistory") ||
                reportName.equalsIgnoreCase("PeerCountryDistributionFundLevel") ||
                reportName.equalsIgnoreCase("PeerCountryDistributionFundLevelHeatMap") ||

                reportName.equalsIgnoreCase("PeerSectorDistribution") ||
                reportName.equalsIgnoreCase("PeerSectorDistributionHistory") ||
                reportName.equalsIgnoreCase("PeerSectorDistributionFundLevel") ||
                reportName.equalsIgnoreCase("PeerSectorDistributionFundLevelHeatMap")) {

            actions.moveToElement(piDistributionMainMenu).build().perform();

            //peerInsightsPage.piDistributionMainMenu.click();

        } else if (reportName.equalsIgnoreCase("PortfolioRiskRank")
                || reportName.equalsIgnoreCase("PeerRiskAttribution")
                || reportName.equalsIgnoreCase("PeerRiskHistory")
                || reportName.equalsIgnoreCase("RiskAttributionFundLevel")
                || reportName.equalsIgnoreCase("RiskMeasuresFundLevelHeatMap")
                || reportName.equalsIgnoreCase("RiskAttributionFundLevelHeatMap")) {

            actions.moveToElement(piFundReportRiskMenu).build().perform();

            // peerInsightsPage.piFundReportRiskMenu.click();

        } else if (reportName.equalsIgnoreCase("PerformanceRank")
                || reportName.equalsIgnoreCase("PortfolioReturns")) {

            actions.moveToElement(piPerformanceMainMenu).build().perform();

            //peerInsightsPage.piPerformanceMainMenu.click();
        }

        //Thread.sleep(2000);

        Wait.waitForElementToDisplay(driver,reportSubMenu, 3);

        reportSubMenu.click();

        Wait.untilJqueryIsDone(driver, 30);

        Wait.waitForSquareBoxesToDisappear(driver, 30);

        Wait.waitForSpinnerToDisappear(driver, 30);

        Wait.forGridToLoad(driver, 30);

        //Thread.sleep(10000);

        moveCursorAway();

    }

    public void moveCursorAway() {

        Actions moveCusorToHideMenu = new Actions(driver);
        moveCusorToHideMenu.moveToElement(driver.findElement(By.xpath("//*[@id='iconSearch']"))).build().perform();
    }






    public PeerInsightsPage(WebDriver driver){

        this.driver=driver;

        initElements(driver,this);
    }




}
