package com.styleanalytics.enterprise.Search;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class MetaDataPageObject extends EnterpriseBaseClass{

        // Portfolio search Icon

        @FindBy(xpath = "//*[@id='iconSearch']")
        WebElement searchIcon;

        // Portfolio search Textbox

        @FindBy(xpath = "//*[@id='txtPortfolioSearch']")
        WebElement searchTextBlock;

        // First search result

        @FindBy(xpath = "//*[@id='portfolioSearchPortfolioList']/div[4]/div[3]/div/div[1]/div[2]")
        WebElement firstSearchResult;

        // button/Link to Portfolio explorer

        @FindBy(linkText ="View in Portfolio Explorer")
        WebElement portfolioExplorerLink;

        // Portfolio Text on Panel
        @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/h2")
        WebElement portfolioTextOnPanel;



        // User Reference label Text
        @FindBy(xpath ="//span[contains(text(),'User Reference:')]")
        WebElement userReferenceText;


        // User Reference Data
        @FindBy(xpath ="//html//div[@class='detailsContent']/div[1]/div[1]")
        WebElement userReferenceData;




      // Ticker label Text
      @FindBy(xpath ="//span[contains(text(),'Ticker:')]")
       WebElement tickerText;


       // Ticker Data
      @FindBy(xpath ="//span[contains(text(),'FDL')]")
      WebElement tickerData;



       // ISIN label Text
        @FindBy(xpath ="//span[contains(text(),'ISIN:')]")
        WebElement isinText;


       // ISIN Data
        @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[1]/div[3]/span[2]")
        WebElement isinData;

        // Last Snapshot label text Text
        @FindBy(xpath ="//span[contains(text(),'Last Snapshot Date:')]")
        WebElement lastSnapshotLabelText;

       // Last Snapshot Data
        @FindBy(xpath ="/html[1]/body[1]/div[2]/div[4]/div[1]/div[2]/div[1]/span[2]")
        WebElement lastSnapshotData;

        // Organisation label text
        @FindBy(xpath ="//span[contains(text(),'Organization:')]")
        WebElement organisationLabelText;

      // Organisation Data
       @FindBy(xpath ="//span[contains(text(),'Morningstar Data')]")
       WebElement organisationdata;



    //Registration Label Text
        @FindBy(xpath ="//*[@id=\"portfolioRegistrationHeader\"]")
        WebElement registrationLabelText;


        //Investment Strategy label Text
        @FindBy(xpath ="//span[contains(text(),'Investment Strategy:')]")
        WebElement investmentStrategyText;


        //BenchMark label Text

        @FindBy(xpath ="//span[contains(text(),'Benchmark:')]")
        WebElement benchmarkLabelText;

        @FindBy(xpath ="//span[contains(text(),'Morningstar Dividend Leaders TR USD')]")
        WebElement benchmarkData;

        //Company label Text

        @FindBy(xpath ="//span[contains(text(),'Company:')]")
        WebElement companyLabelText;

       @FindBy(xpath ="//div[@class='portfolioInfo']//span[contains(text(),'First Trust')]")
       WebElement companyData;


        //Legal structure label Text

        @FindBy(xpath ="//span[contains(text(),'Legal Structure:')]")
        WebElement legalStructureLabelText;

        @FindBy(xpath ="//span[contains(text(),'Open Ended Investment Company')]")
        WebElement legalStructureData;


      //Domicile label Text

        @FindBy(xpath ="//span[contains(text(),'Domicile:')]")
        WebElement domicileLabelText;

       @FindBy(xpath ="//span[contains(text(),'United States')]")
       WebElement domicileLabelData;


        //Classification label Text


        @FindBy(xpath ="//h3[@id='portfolioClassificationHeader']")
        WebElement classificationLabelText;


        //MorningStar Category label Text

        @FindBy(xpath ="//span[contains(text(),'Morningstar Category:')]")
          WebElement morningStarCategoryLabelText;

      @FindBy(xpath ="//span[contains(text(),'Large Value')]")
       WebElement morningStarCategoryData;


        //Global Category label Text

        @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[7]/div[2]/span[1]")
        WebElement eTFLabelText;

       @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[7]/div[2]/span[2]")
       WebElement eTFData;



        //Index fund

        @FindBy(xpath ="//span[contains(text(),'Index Fund:')]")
        WebElement indexFundLabelText;

       @FindBy(xpath ="//div[@class='portfolioDetails']//div[3]//span[2]")
       WebElement indexFundData;


    //Ex report label

        @FindBy(xpath ="//*[@id=\"portfolioSearchExecReportsHeader\"]")
        WebElement executiveReports;


         // executive report Template label

        @FindBy(xpath ="//div[contains(@id,'Report')]/span[1]")
        WebElement execReportLabel;



        //Exec report Template label
        @FindBy(xpath ="//span[@class='slick-column-name'][contains(text(),'Template')]")
        WebElement execTemplatetLabel;



        //Exec report label label
        @FindBy(xpath ="//span[@class='slick-column-name'][contains(text(),'Labels')]")
        WebElement execReportLabelsLabel;


        //Exec report Currency label
        @FindBy(xpath ="//span[@class='slick-column-name'][contains(text(),'Currency')]")
        WebElement execCurrencyLabel;


        //Peer insight label report label

        @FindBy(xpath ="//*[@id=\"portfolioSearchPeerInsightsHeader\"]")
        WebElement peerInsightsLabel;


        //Peer group  label

        @FindBy(xpath ="//span[@class='slick-column-name'][contains(text(),'Peer Group')]")
        WebElement peerGroupLabel;

        //Peer Provider  label

        @FindBy(xpath ="//span[@class='slick-column-name'][contains(text(),'Provider')]")
        WebElement providerLabel;

        //BenchMark  label

        @FindBy(xpath ="//span[@class='slick-column-name'][contains(text(),'Benchmark')]")
        WebElement peerBenchmarkLabel;

        //Report label

        @FindBy(xpath ="//span[@class='slick-column-name'][contains(text(),'Report')]")
        WebElement peerReportLabel;



        //pop up Database labels-- user reference


          @FindBy(xpath ="//div[contains(@class,'portfolioInfoContainer')]")
          WebElement popUpUserReference;


        //pop up Database labels-- last snapshot date

         @FindBy(xpath ="//*[@id=\"aspnetForm\"]/div[3]/div/div[2]/div[1]")
          WebElement popUpLastSnapShotDate;


        //pop up Database labels-- last snapshot date

        @FindBy(xpath ="//*[@id=\"aspnetForm\"]/div[3]/div/div[2]/div[2]")
         WebElement popUpOrganization;

        @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_panChapters']/div[2]")
        WebElement styleExposureMainMenu;

        @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_panChapters']/div[3]")
        WebElement sTyleDistributionMainMenu;


        @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_panChapters']/div[4]")
        WebElement peerInsightRiskMainMenu;








        @FindBy(linkText = "View in Task Activity")
        WebElement taskActivityLink;



        public MetaDataPageObject(){
            //This initElements method will create all WebElements


            initElements(Driver, this);

        }

    }


