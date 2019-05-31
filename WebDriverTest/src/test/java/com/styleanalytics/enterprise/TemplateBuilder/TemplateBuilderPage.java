package com.styleanalytics.enterprise.TemplateBuilder;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Viswanath on 13/07/2017.
 */
public class TemplateBuilderPage extends EnterpriseBaseClass {


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_cmdShowNew_input\"]")
    WebElement newTemplateButton;

    @FindBy(xpath = "//*[@id=\"divNewOptions\"]/a[1]")
    WebElement newPDFTemplateForPortfolios;


    //Blocks

    @FindBy(xpath = "//a[@class='accordion-section-title'][contains(text(),'Style Exposure')]")
    WebElement expandStyleExposure;

    @FindBy(xpath = "//*[contains(text(),'Style Skyline')]")
    WebElement styleSkyline;



    @FindBy(xpath = "//*[@id=\"pageCanvas\"]/li/div")
    WebElement block;

    @FindBy(xpath = "//div[@class='showProps blockButton']")
    WebElement openBlockProperties;



    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_winProps_C_cmdDeleteBlock_input']")
    WebElement deleteBlock;

    @FindBy(xpath = "//*[@id=\"divBlockProperties\"]/div[1]/div[1]/label")
    WebElement blockTitle;

    @FindBy(xpath = "//*[@id=\"divBlockProperties\"]/div[1]/div[2]/label")
    WebElement showBlockTitleAndFrameLabel;

    @FindBy(xpath = "//*[@id=\"chkShowTitle\"]")
    WebElement showBlockTitleCheckBox;

    @FindBy(xpath = "//*[@id=\"lblFactorSelector\"]")
    WebElement factorsLabel;

    @FindBy(xpath = "//*[@id=\"hlSelectFactors\"]")
    WebElement factorsValue;


    @FindBy(xpath = " //*[@id=\"ddlDataSeriesLabel\"]")
    WebElement dataSeriesLabel;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_winProps_C_ddlDataSeries_Input\"]")
    WebElement dataSeriesValue;

    @FindBy(xpath = "//span[contains(text(),'Factor Category Labels:')]")
    WebElement factorCategoryLabel;



    @FindBy(xpath = "//*[@id=\"ddlBlockFormatLabel\"]")
    WebElement formattingLabel;

    @FindBy(xpath = "//*[@id=\"hlBlockFormat\"]")
    WebElement setBlockFormat;


    @FindBy(xpath = "//*[contains(text(),'Style Exposure Trails')]")
    WebElement styleExposureTrails;

    @FindBy(xpath = "//*[contains(text(),'Style Skyline Range')]")
    WebElement styleSkylineRange;


    @FindBy(xpath = "//*[@id=\"txtBlockTitle\"]")
    WebElement blockTitleValue;

    @FindBy(xpath = "//*[contains(text(),'Style Mine Legacy')]")
    WebElement styleMine;

    @FindBy(xpath = "//*[contains(text(),'Style Tilt Heat Map')]")
    WebElement styleHeatMap;

    //Factor data value



    @FindBy(xpath = "//label[@for='chkPortfolioAndBenchmark']")
    WebElement includeBMOnlySecurities;

    @FindBy(xpath = "//*[@id=\"chkPortfolioAndBenchmark\"]")
    WebElement includeBMOnlySecuritiesCheckBox;

    @FindBy(xpath = "//label[@for='chkSectorGroupings']")
    WebElement includeSectorGroupings;

    @FindBy(xpath = "//*[@id=\"chkSectorGroupings\"]")
    WebElement includeSectorGroupingsCheckBox;



    //Sub Fund Gallery Style Exposure



    @FindBy(xpath = "//label[@for='chkFlipTableAxes'][contains(text(),'Restrict grid to block size:')]")
    WebElement restrictGridToBlockSize;

    @FindBy(xpath = "//input[@id='chkCropGrid']")
    WebElement restrictGridToBlockSizeCheckBox;

    @FindBy(xpath = "//span[@id='ddlSubFundGallerySortLabel']")
    WebElement sortByLabel;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_winProps_C_ddlSubFundGallerySort_Input\"]")
    WebElement sortByValue;

    //HeatMap

    @FindBy(xpath = "//label[@for='chkDateTitle']")
    WebElement appendDateRangeOnTitle;

    @FindBy(xpath = "//input[@id='chkDateTitle']")
    WebElement appendDateRangeOnTitleCheckBox;

    @FindBy(xpath = "//label[@for='chkRepeatHeader'][contains(text(),'Make block full page in PDF:')]")
    WebElement makeBlockFullPageInPDF;

    @FindBy(xpath = "//input[@id='chkAutoSize']")
    WebElement makeBlockFullPageInPDFCheckBox;

    //Trails



    @FindBy(xpath = "//label[@for='chkRepeatHeader'][contains(text(),'Repeat header if block spans pages:')]")
    WebElement repeatHeaderInAllPages;

    @FindBy(xpath = "//input[@id='chkRepeatHeader']")
    WebElement repeatHeaderInAllPagesCheckBox;

    @FindBy(xpath = "//label[@for='chkEqualiseScales']")
    WebElement equlaiseYAxis;

    @FindBy(xpath = "//input[@id='chkEqualiseScales']")
    WebElement equlaiseYAxisCheckBox;

    //Distribution



    @FindBy(xpath = "//a[@class='accordion-section-title'][contains(text(),'Distribution')]")
    WebElement expandDistribution;

    @FindBy(xpath = "//*[contains(text(),'Region Distribution')]")
    WebElement regionDistribution;

    //Region Distribution

    @FindBy(xpath = "//span[@class='fieldLabel'][contains(text(),'Weight Basis:')]")
    WebElement weightBasisLabel;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_winProps_C_ddlDistWeightBasis_Input']")
    WebElement weightBasisDefault;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_winProps_C_ddlDistWeightBasis_DropDown\"]/div/ul/li")
    WebElement weightBasisList;

    @FindBy(xpath = "//label[@class='fieldLabel'][contains(text(),'Region set:')]")
    WebElement regionSetLabel;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_winProps_C_ddlRegionSets_Input']")
    WebElement  regionSetDefault;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_winProps_C_ddlRegionSets_DropDown\"]/div/ul/li")
    WebElement regionSetList;

    //Risk

    @FindBy(xpath = "//*[contains(text(),'Risk Attribution')]")
    WebElement riskAttribution;

    @FindBy(xpath = "//a[@class='accordion-section-title'][contains(text(),'Risk')]")
    WebElement expandRisk;

    @FindBy(xpath = "//span[@class='fieldLabel'][contains(text(),'Risk Decomposition:')]")
    WebElement riskDecompositionLabel;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_winProps_C_ddlRiskDecomposition_Input']")
    WebElement  riskDecompositionDefault;


    //Liquidity

    @FindBy(xpath = "//div[contains(text(),'Liquidity')]")
    WebElement liquidity;

    @FindBy(xpath = "//a[@class='accordion-section-title'][contains(text(),'Liquidity')]")
    WebElement expandLiquidity;

    @FindBy(xpath = "//div[@class='availableBlockLabel'][contains(text(),'Liquidity History Benchmark')]")
    WebElement liquidityHistoryBM;

    @FindBy(xpath = "//span[@class='fieldLabel'][contains(text(),'Percent Volume Tradable:')]")
    WebElement percentageVolTradableLabel;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_winProps_C_txtPercentVolumeTradable']")
    WebElement percentageVolTradableValue;

    @FindBy(xpath = "//span[@class='fieldLabel'][contains(text(),'Avg Vol Sample Period(Months):')]")
    WebElement avgVolSamplePeriodLabel;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_winProps_C_txtAvgVolTradable']")
    WebElement avgVolSamplePeriodValue;


    //FOF Performance

    @FindBy(xpath = "//a[@class='accordion-section-title'][contains(text(),'FoF Performance')]")
    WebElement expandFOFPerformance;

    @FindBy(xpath = "//label[@for='chkAnnualiseReturns']")
    WebElement annualisedReturns;

    @FindBy(xpath = "//input[@id='chkAnnualiseReturns']")
    WebElement annualisedReturnsValue;



    @FindBy(xpath = "//div[@class='availableBlockLabel'][contains(text(),'Fund of Funds Performance Summary')]")
    WebElement fofPerformanceSumamry;

    //Performance

    @FindBy(xpath = "//a[@class='accordion-section-title'][contains(text(),'Performance')]")
    WebElement expandPerformance;

    @FindBy(xpath = "//*[contains(text(),'Performance Summary')]")
    WebElement performanceSummary;


    //StyleMie

    @FindBy(xpath = "//a[@class='accordion-section-title'][contains(text(),'Style Mine')]")
    WebElement expandStyleMine;

    @FindBy(xpath = "//*[contains(text(),'Style Mine Performance')]")
    WebElement styleMinePerformance;















    @FindBy(xpath = "//*[contains(text(),'Report Title:')]")
    WebElement reportTitleLabel;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlReportTitleFontFamily_ClientState']")
    WebElement reportTitleFont;

    @FindBy(xpath = "//*[contains(text(),'Page Title:')]")
    WebElement pageTitleLabel;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlPageTitleFontFamily_ClientState']")
    WebElement pageTitleFont;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlPageTitleFontSize_ClientState']")
    WebElement pageTitleFontSize;

    @FindBy(xpath = "//*[contains(text(),'Block Title:')]")
    WebElement blockTitleLabel;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlBlockTitleFontFamily_ClientState']")
    WebElement blockTitleFont;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlBlockTitleFontSize_ClientState']")
    WebElement blockTitleFontSize;

    @FindBy(xpath = "//*[contains(text(),'Grid Data:')]")
    WebElement gridDataLabel;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlBlockDataFontFamily_ClientState']")
    WebElement gridDataFont;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlBlockDataFontSize_ClientState']")
    WebElement gridDataFontSize;

    @FindBy(xpath = "//*[contains(text(),'Legend:')]")
    WebElement legendLabel;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlLegendFontFamily_ClientState']")
    WebElement legendFont;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlLegendFontSize_ClientState']")
    WebElement legendFontSize;

    @FindBy(xpath = "//*[contains(text(),'X Axis Label:')]")
    WebElement xAxisLabel;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlXAxisLabelFamily_ClientState']")
    WebElement xAxisLabelFont;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlXAxisLabelSize_ClientState']")
    WebElement xAxisLabelFontSize;

    @FindBy(xpath = "//*[contains(text(),'X Axis Title:')]")
    WebElement xAxisTitleLabel;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlXAxisTitleFamily_ClientState']")
    WebElement xAxisTitleFont;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlXAxisTitleSize_ClientState']")
    WebElement xAxisTitleFontSize;

    @FindBy(xpath = "//*[contains(text(),'Y Axis Label:')]")
    WebElement yAxisLabel;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlYAxisLabelFamily_ClientState']")
    WebElement yAxisLabelFont;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlYAxisLabelSize_ClientState']")
    WebElement yAxisLabelFontSize;

    @FindBy(xpath = "//*[contains(text(),'Y Axis Title:')]")
    WebElement yAxisTitleLabel;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlYAxisTitleFamily_ClientState']")
    WebElement yAxisTitleFont;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlYAxisTitleSize_ClientState']")
    WebElement yAxisTitleFontSize;

    @FindBy(xpath = "//*[contains(text(),'Line Chart Thickness:')]")
    WebElement lineChartThicknessLabel;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlChartLineThickness_ClientState']")
    WebElement lineChartThicknessSize;

    @FindBy(xpath = "//*[contains(text(),'Marker Size:')]")
    WebElement markerLabel;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlChartMarkerSize_ClientState']")
    WebElement markerSize;

    @FindBy(xpath = "//*[contains(text(),'Show Data Labels:')]")
    WebElement showBarDataLabels;

    @FindBy(xpath = "//*[@id='chkShowBarDataLabels']")
    WebElement showBarDataCheck;

    public TemplateBuilderPage(){

        initElements(Driver, this);
    }



}
