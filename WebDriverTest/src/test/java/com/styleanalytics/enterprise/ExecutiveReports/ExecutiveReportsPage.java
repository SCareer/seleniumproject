package com.styleanalytics.enterprise.ExecutiveReports;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ExecutiveReportsPage {


    WebDriver driver;



    @FindBy(xpath = "//div[@id='pagination']//a[1]")
    WebElement execReportStyleSkylineSummaryPageNav;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_labName\"]")
    WebElement execReportStyleSkylineSummaryTitle;


    ///styleSkylineSummaryReportTitle


    @FindBy(xpath = "//*[contains(@id,'ctl00_labTitle')]")
    WebElement execReportStyleSkylineSummaryReportTitle;




    ///styleSkylineSummaryReport Column Headers


    @FindBy(xpath = "//div[@id='pagination']//a[2]")
    WebElement execReportRiskPageNav;

    @FindBy(xpath = "//span[contains(text(),'Book to Price')]")
    WebElement execReportStyleSkylineSummaryBookToPrice;

    @FindBy(xpath = "//span[contains(text(),'Dividend Yield')]")
    WebElement execReportStyleSkylineSummaryDividendYield;


    @FindBy(xpath = "//span[contains(text(),'Return on Equity')]")
    WebElement execReportStyleSkylineSummaryReturnonEquity;


    @FindBy(xpath = "//span[contains(text(),'Earnings Growth')]")
    WebElement execReportStyleSkylineSummaryEarningsGrowth;


    @FindBy(xpath = "//span[contains(text(),'Market Cap')]")
    WebElement execReportStyleSkylineSummaryMarketCap;


    @FindBy(xpath = "//span[contains(text(),'Debt to Equity')]")
    WebElement execReportStyleSkylineSummaryDebtToEquity;




   //styleSummaryReportSearch


    @FindBy(xpath = "//div[@title='Ticker Test']")
    WebElement execReportSearchReport;

    @FindBy(className = "rwCloseButton")
    WebElement execReportPopUpcloseButton;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]")
    WebElement execReportPopVerify;




    ///sRisk summary page

    //Title


    @FindBy(xpath = "//span[contains(text(),'Risk Summary')]")
    WebElement execReportRiskSummaryTitle;

    //Column headers

    @FindBy(xpath = "//span[contains(text(),'Tracking Error')]")
    WebElement execReportRiskSummaryTrackingError;

    @FindBy(xpath = "//span[contains(text(),'Coverage')]")
    WebElement execReportRiskSummaryCoverage;


    @FindBy(xpath = "//span[@class='slick-column-name'][contains(text(),'Currency')]")
    WebElement execReportRiskSummaryCurrency;


    @FindBy(xpath = "//span[contains(text(),'Market Xterms')]")
    WebElement execReportRiskSummaryMarketXterms;

    @FindBy(xpath = "//span[@class='slick-column-name'][contains(text(),'Market')]")
    WebElement execReportRiskSummaryMarket;

    @FindBy(xpath = "//span[contains(text(),'Sector Xterms')]")
    WebElement execReportRiskSummarySectorXterms;

    @FindBy(xpath = "//span[@class='slick-column-name'][contains(text(),'Sector')]")
    WebElement execReporttRiskSummarySector;

    @FindBy(xpath = "//span[contains(text(),'Style Xterms')]")
    WebElement execReportRiskSummaryStyleXterms;

    @FindBy(xpath = "//span[@class='slick-column-name'][contains(text(),'Style')]")
    WebElement execReportRiskSummaryStyle;

    @FindBy(xpath = " //span[contains(text(),'Equity Xterms')]")
    WebElement execReportRiskSummaryEquityXtrems;

    @FindBy(xpath = "//span[@class='slick-column-name'][contains(text(),'Equity')]")
    WebElement execReportRiskSummaryEquity;


    //page 3


    @FindBy(xpath = "//div[@id='pagination']//a[3]")
    WebElement execReportRiskRangeTiltPageNav;




    @FindBy(className = "chartTitle")
    WebElement execReportStyleExposureTiltRangeTitle;


    //Risk averages

    @FindBy(xpath = "//div[@id='pagination']//a[4]")
    WebElement execReportRiskAveragePageNav;


    @FindBy(xpath = "//div[@id='pagination']//a[4]")
    WebElement execReportRiskAverageGraphId;



    //page 5

    @FindBy(xpath = "//div[@id='pagination']//a[5]")
    WebElement execReportPortfolioChangesPageNav;


    @FindBy(className = "chartTitle")
    WebElement execReportPortfolioChangesReportTitle;



   //page 6

    @FindBy(xpath = "//div[@id='pagination']//a[6]")
    WebElement execReportPortfolioWeightPageNav;


    //Page 7 LiquidityRange


    @FindBy(xpath = "//div[@id='pagination']//a[7]")
    WebElement execReportPortfolioLiquidityRangePageNav;


    @FindBy(xpath = " //*[contains(@id,'chartDiv-graph-id0-plotset-plot-1-node-0')]")
    WebElement execReportPortfolioLiquidityRangeDrilldown;



    @FindBy(xpath = "//*[contains(@id, 'SummaryGrid_panGridSummaryLiquidity')]")
    WebElement execReportPortfolioLiquiditySummaryVisible;




    //Page 8 LiquidityRange page

    @FindBy(xpath = "//div[@id='pagination']//a[8]")
    WebElement execReportPortfolioLiquidityRangeReportPageNav;


    @FindBy(xpath = "//*[contains(@id,'chartDiv-graph-id0-plotset-plot-1-node-0')]")
    WebElement execReportLiquidityRangeTradeToCashDrillDowns;


    @FindBy(xpath = "//*[contains(@id,'chartDiv-graph-id0-plotset-plot-1-node-0')]")
    WebElement execReportLiquidityRangeTradeToBenchmarkDrillDowns;



   //Page 9 Sector Portfolio Weight

    @FindBy(xpath = "//div[@id='pagination']//a[9]")
    WebElement execReportSectorPortfolioWeightPageNav;



    //Page 10 COUNTRY Portfolio Weight

    @FindBy(xpath = "//div[@id='pagination']//a[10]")
    WebElement execReportCountryPortfolioWeightPageNav;



    //Page 11 sIZE AND sECTRO DISTRIBUTIONt

    @FindBy(xpath = "//div[@id='pagination']//a[11]")
    WebElement execReportDistributionPageNav;


    ///NAV Report


  //  page 2 Risk average



    @FindBy(xpath = "//div[@id='pagination']//a[2]")
    WebElement navReportRiskAveragePageNav;


    //  page 3 SectorWeight



    @FindBy(xpath = "//div[@id='pagination']//a[3]")
    WebElement navReportSectorWeightPageNav;



    //  page 4 SectorWeight

    @FindBy(xpath = "//div[@id='pagination']//a[4]")
    WebElement navReportCountryWeightPageNav;


    //  page 5 Distribution

    @FindBy(xpath = "//div[@id='pagination']//a[5]")
    WebElement navReportDistributionPageNav;

    //  page 6 Distribution

    @FindBy(xpath = "//div[@id='pagination']//a[6]")
    WebElement navReportStyleDistributionPageNav;


    //  page 7 Liquidity

    @FindBy(xpath = "//div[@id='pagination']//a[7]")
    WebElement navReportLiquidityPageNav;




    //  page 7 Liquidity

    @FindBy(xpath = "//div[@id='pagination']//a[8]")
    WebElement navReporWeightPageNav;



    //Returns Template

    // page 1


    @FindBy(xpath = "//div[@id='pagination']//a[1]")
    WebElement returnsTemplatePage1;


    @FindBy(xpath = "//*[contains(@id,'_ctl00_labTitle')]")
    WebElement returnsTemplatePerformenceReturnsTitel;

    @FindBy(xpath = "//div[@class='slick-viewport slick-viewport-top slick-viewport-right']")
    WebElement returnsTemplatePerformenceReportGrid;


    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]")
    WebElement returnsTemplatePerformenceReportPopUP;


    //active Performence Returns  page 2


    @FindBy(xpath = "//div[@id='pagination']//a[2]")
    WebElement returnsTemplatePage2;

    @FindBy(xpath = "//*[contains(@id,'ctl00_labTitle')]")
    WebElement returnsTemplateActivePerformenceReportTitle;


    @FindBy(xpath = "//div[@class='slick-viewport slick-viewport-top slick-viewport-right']")
    WebElement returnsTemplateActivePerformenceReportGrid;



    // Performence range absoulate page 3


    @FindBy(xpath = "//div[@id='pagination']//a[3]")
    WebElement returnsTemplatePage3;

    @FindBy(xpath = "//*[contains(@id,'_1000_chartDiv-graph-id0-plotset-plot-3-node-0')]")
    WebElement returnsTemplatePerformenceRangeAbsoluteReportGrid1;

    @FindBy(xpath = "//div[@class='slick-viewport slick-viewport-top slick-viewport-right']")
    WebElement returnsTemplatePerformenceRangeAbsoluteReportGrid2;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]")
    WebElement returnsTemplatePerformenceRangeMapPopup;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]")
    WebElement returnsTemplatePerformenceReturnHeatMapPopUp;



    //page 4 performence Range Active

    @FindBy(xpath = "//div[@id='pagination']//a[4]")
    WebElement returnsTemplatePage4;


    @FindBy(xpath = "//div[@class='slick-viewport slick-viewport-top slick-viewport-right']")
    WebElement returnsTemplatePerformenceRangePage4Grid2;


    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]")
    WebElement returnsTemplatePerformenceRangeAbsoluteDrilldownPopUP;

    //page 5 RangeAbsoluteTitelPage


    @FindBy(xpath = "//div[@id='pagination']//a[5]")
    WebElement returnsTemplatePage5;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]")
    WebElement returnsPerformenceRangePage5DrillDown1PioUP;

    @FindBy(xpath = "//*[contains(@id,'_1000_chartDiv-graph-id0-plotset-plot-3-node-0')]")
    WebElement returnsTemplatePerformenceRangeAbsolutePage5Grid1;


    @FindBy(xpath = "//*[contains(@id,'_1001_chartDiv-graph-id0-plotset-plot-3-node-0')]")
    WebElement returnsTemplatePerformenceRangeAbsolutePage5Grid2;

    @FindBy(xpath = "//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]")
    WebElement returnsPerformenceRangePage5DrillDown2PioUP;


    //Changes Template

    //page 1

    @FindBy(xpath = "//div[@id='pagination']//a[1]")
    WebElement changesTemplatePage1;

    @FindBy(xpath = "//*[contains(@id,'ctl00_labTitle')]")
    WebElement changesTemplatePortfolioChangesTitel;

    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-right']")
    WebElement changesTemplatePortfolioChangesGrid;

    @FindBy(xpath = "//*[contains(@id,'aspnetForm')]")
    WebElement changesTemplatePortfolioChangesPopUp;


    //page 2

    @FindBy(xpath = "//div[@id='pagination']//a[2]")
    WebElement changesTemplatePage2;


    @FindBy(xpath = "//*[contains(@id,'ctl00_labTitle')]")
    WebElement changesTemplateStyleExposureChangesTitle;

    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-right']")
    WebElement changesTemplateStyleExposureChangesGrid;


    //page 3


    @FindBy(xpath = "//div[@id='pagination']//a[3]")
    WebElement changesTemplatePage3;

    @FindBy(xpath = "//*[contains(@id,'ctl00_labTitle')]")
    WebElement changesTemplateSizeDistributionTitle;


    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-right']")
    WebElement changesTemplateSizeDistributionGrid;


    //page 4


    @FindBy(xpath = "//div[@id='pagination']//a[4]")
    WebElement changesTemplatePage4;

    @FindBy(xpath = "//*[contains(@id,'ctl00_labTitle')]")
    WebElement changesTemplateStyleDistributionTitle;


    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-right']")
    WebElement changesTemplateStyleDistributionGrid;


    //page 5


    @FindBy(xpath = "//div[@id='pagination']//a[5]")
    WebElement changesTemplatePage5;

    @FindBy(xpath = "//*[contains(@id,'ctl00_labTitle')]")
    WebElement changesTemplateSectorChangeTitle;


    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-right']")
    WebElement changesTemplateSectorChangeGrid;


    //page 6


    @FindBy(xpath = "//div[@id='pagination']//a[6]")
    WebElement changesTemplatePage6;

    @FindBy(xpath = "//*[contains(@id,'ctl00_labTitle')]")
    WebElement changesTemplateCountryChangeTitle;


    @FindBy(xpath = "//div[@class='grid-canvas grid-canvas-top grid-canvas-right']")
    WebElement changesTemplateCountryChangeGrid;




  // Nav Template


    @FindBy(xpath = "//div[@id='pagination']//a[1]")
    WebElement navTemplateStyleExposurePageNav;




    @FindBy(xpath = "//ul[@class='rwControlButtons']")
    WebElement popupClose_btn;


    /*********
     * sync
     */

    @FindBy(xpath = "//div[contains(@class,'chartLoading')]")
    WebElement loading_Squares;




    public ExecutiveReportsPage(WebDriver driver){

        this.driver = driver;

        initElements(driver,this);
    }
}
