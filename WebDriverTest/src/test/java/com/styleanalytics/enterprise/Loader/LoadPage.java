package com.styleanalytics.enterprise.Loader;

import com.styleanalytics.enterprise.Wait;

import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class LoadPage extends TestBase {


    WebDriver driver;


    public void goToLoadPage() throws IOException {

        String url = property("URL");

        driver.get(url+"/Portfolio/loadPortfoliosSelect.aspx");//

    }

    public void uploadFile(String filePath) throws InterruptedException {

        selectFileButton.sendKeys(filePath);
        waitAndClickNext(nextStepButton);

    }

    public void addPortfolioName(String portfolioName){

        portfolioNameCombobox.sendKeys(portfolioName);
        clickOnStatus();
        Wait.waitForSquareBoxesToDisappear(driver,180);
        waitAndClickNext(nextStepButton1);
    }

    public void closeAnalysisDispatchPopup(){

        okButtonOnAnalysisDispatchPopup.click();
    }

    public void waitAndClickNext(WebElement nextStep) {

        WebDriverWait wait = new WebDriverWait(driver, 300);
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextStep));
        nextButton.click();
        Wait.waitForSquareBoxesToDisappear(driver,180);

    }

    public void waitForSignalRProgressToComplete(){

        Wait.waitForElementToDisappear(driver,180,signalRProcess);
        Wait.waitForSquareBoxesToDisappear(driver,180);
    }

    public void clickOnStatus(){

        loadStatus.click();

        }

    public void loadPortfolioWithSpecifyNameOnRuntime(String file, String portfolioName) throws IOException, InterruptedException {


        goToLoadPage();
        uploadFile(file);
        addPortfolioName(portfolioName);
        waitForSignalRProgressToComplete();
        waitAndClickNext(nextStepButton1);
        waitAndClickNext(nextStepButton1);
        waitAndClickNext(nextStepButton1);
        closeAnalysisDispatchPopup();
        waitAndClickNext(nextStepButton1);

    }

    public void loadPortfolio(String file) throws IOException, InterruptedException {


        goToLoadPage();
        uploadFile(file);
        waitAndClickNext(nextStepButton1);
        waitForSignalRProgressToComplete();
        waitAndClickNext(nextStepButton1);
        waitAndClickNext(nextStepButton1);
        waitAndClickNext(nextStepButton1);
        closeAnalysisDispatchPopup();
        waitAndClickNext(nextStepButton1);

    }




    // Portfolio/Holdings Load

    @FindBy(id = "ctl00_mainContentPlaceHolder_fileUploadfile0")
    WebElement selectFileButton ;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_loadheader_cmdNext_input']")
    WebElement nextStepButton ;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_header_cmdNext_input']")
    WebElement nextStepButton1 ;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_gridFiles_ctl00_ctl04_radComboPortfolioName_radComboBoxPortfolioQuickSearch_Input']")
    WebElement portfolioNameCombobox ;

    @FindBy(xpath = "//th[contains(text(),'Portfolio')]")
    WebElement portfolioColumnHeader ;

    @FindBy(xpath = "//div[@id='ctl00_mainContentPlaceHolder_gridFiles_ctl00_ctl04_panIndicator']")
    WebElement loadStatus ;

    @FindBy(xpath = "//*[@id=\"statusMessageDashboard\"]")
    WebElement signalRProcess ;

    @FindBy(css = ".rwInnerSpan")
    WebElement okButtonOnAnalysisDispatchPopup ;

   /* @FindBy(xpath = "//span[contains(text(),'Load Portfolio Details')]")
    WebElement okButtonOnAnalysisDispatchPopup ;

    @FindBy(xpath = "//span[contains(text(),'Load Portfolio Details')]")
    WebElement loadPortfolioDetailsMenu ;

    @FindBy(xpath = "//span[contains(text(),'Load Portfolio Details')]")
    WebElement loadPortfolioDetailsMenu ;*/








    // loadPortfolioDetails


    @FindBy(xpath = "//span[contains(text(),'Load Portfolio Details')]")
    WebElement loadPortfolioDetailsMenu ;

    @FindBy(id = "ctl00_mainContentPlaceHolder_portfolioDetailsUploaderfile0")
    WebElement loadPortfolioDetailsMenuSelectButton ;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_portfolioDetailsHeaderSection_cmdNext_input\"]")
    WebElement loadPortfolioDetailsNextButton1 ;

    @FindBy(xpath ="//*[@id=\"ctl00_mainContentPlaceHolder_radGridPortfolioFilesList_ctl00_ctl04_radComboFileType_Input\"]")
    WebElement loadPortfolioDetailsCSVBox;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_header_cmdNext_input\"]")
    WebElement loadPortfolioDetailsNextButton2;

    @FindBy(xpath = "//li[@class='current']/span")
    WebElement loadPortfolioDetailsSavePortfolioDetails;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_radGridPortfolioFilesList_ctl00_ctl04_imgIsValid\"]")
    WebElement loadPortfolioDetailsLoadImage;

    //Generic paths for all test

    @FindBy(xpath = "//th[contains(text(),'File Name')]")
    WebElement loadPortfolioDetailsFileName ;

    @FindBy(xpath = "//th[contains(text(),'Delimiter')]")
    WebElement loadPortfolioDetailsDelimiter;

    @FindBy(xpath = "//th[contains(text(),'Status')]")
    WebElement loadPortfolioDetailsStatus;


    //load analysis tasks

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_radGridAnalysisTaskFilesList_ctl00_ctl04_radComboFileDelimiter_Input\"]")
    WebElement loadAnalysisTaskDelimiterSelectBox;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_header_cmdNext_input\"]")
    WebElement loadAnalysisTaskNextButton2;


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_radGridAnalysisTaskFilesList_ctl00_ctl06_radComboFileDelimiter_DropDown\"]/div/ul/li[2]/text()")
    WebElement loadAnalysisTaskDelimiterDropDownlist;


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_radGridAnalysisTaskFilesList_ctl00_ctl04_imgIsValid\"]")
    WebElement loadAnalysisTaskImage1;

    @FindBy(xpath = "//li[@class='current']/span")
    WebElement loadAnalysisTaskStep3;


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_radGridAnalysisTaskFilesList_ctl00_ctl04_imgIsValid\"]")
    WebElement loadAnalysisTaskSuccessImage;




    //load shares


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_radGridShareFilesList_ctl00_ctl04_radComboFileDelimiter_Input\"]")
    WebElement loadSharesDelimiterSelectBox;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_header_cmdNext_input']")
    WebElement loadSharesNextButton2;


    @FindBy(xpath = "//li[@class='current']/span")
    WebElement loadSharesStep3;


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_radGridShareFilesList_ctl00_ctl04_imgIsValid\"]")
    WebElement loadSharesSuccessImage;


    //load Labels


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_radGridLabelFilesList_ctl00_ctl04_radComboFileDelimiter_Input\"]")
    WebElement loadLabelDelimiterSelectBox;


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_header_cmdNext_input\"]")
    WebElement loadLabelsNextButton2;


    @FindBy(xpath = "//li[@class='current']/span")
    WebElement loadLabelsStep3;


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_radGridLabelFilesList_ctl00_ctl04_imgIsValid\"]")
    WebElement loadLabelsSuccessImage;


    //load FundSize


    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_radGridFundSizeFileList_ctl00_ctl04_radComboFileDelimiter_Input']")
    WebElement loadFundSizeDelimiterSelectBox;


    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_loadheader_cmdNext_input']")
    WebElement loadFundSizeNextButton2;


    @FindBy(xpath = "//li[@class='current']/span")
    WebElement loadFundSizeStep3;


    @FindBy(xpath = "//img[@id='ctl00_mainContentPlaceHolder_radGridFundSizeFileList_ctl00_ctl04_imgIsValid']")
    WebElement loadFundSizeSuccessImage;



    //load DataAudit

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_radGridPortfolioSnapshotEmbargoFileList_ctl00_ctl04_radComboFileDelimiter_Input']")
    WebElement loadDataAuditDelimiterSelectBox;


    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_loadheader_cmdNext_input']")
    WebElement loadDataAuditNextButton2;


    @FindBy(xpath = "//li[@class='current']/span")
    WebElement loadDataAuditStep3;


    @FindBy(xpath = "//img[@id='ctl00_mainContentPlaceHolder_radGridPortfolioSnapshotEmbargoFileList_ctl00_ctl04_imgIsValid']")
    WebElement loadDataAuditSuccessImage;


    //load Returns

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_radGridReturnsFileList_ctl00_ctl04_radComboFileDelimiter_Input']")
    WebElement loadReturnsDelimiterSelectBox;


    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_loadheader_cmdNext_input']")
    WebElement loadReturnsNextButton2;

    @FindBy(xpath = "//li[@class='current']/span")
    WebElement loadReturnsStep3;


    @FindBy(xpath = "//img[@id='ctl00_mainContentPlaceHolder_radGridReturnsFileList_ctl00_ctl04_imgIsValid']")
    WebElement loadReturnsSuccessImage;



    // portfolio Builder existing port



    @FindBy(xpath = "//span[contains(text(),'LoadPortfolioBuilder')]")
    WebElement portfolioBuilderSelection;

    @FindBy(id = "ctl00_mainContentPlaceHolder_fileUploadfile0")
    WebElement portfolioBuilderSelectButton;


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_windowAddAnother_C_searchPortfolio_radComboBoxPortfolioQuickSearch_Input\"]")
    WebElement portfolioBuilderCreateExistingChoosePortfolioDropDown;


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_gridPortfolios_ctl00_ctl06_gridSnapshots_ctl00_ctl04_labMatchedSecurityName\"]")
    WebElement portfolioBuilderClickToAddSecuritiesLink;


    @FindBy(xpath = " //*[@id=\"ctl00_mainContentPlaceHolder_manualImport_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")
    WebElement portfolioBuilderSecritySearchInputBox;


    @FindBy(xpath = "//span[contains(text(),'APPLE FINANCE LIMITED')]")
    WebElement portfolioBuilderWaitforSecurity;


    @FindBy(xpath = "//td[contains(text(),'LoadPortfolioBuilder')]")
    WebElement portfolioBuilderVerifyPortfolioName;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_headerManual_cmdNext_input']")
    WebElement portfolioBuilderNextStep;




    // portfolio Builder Create New Portfolio


    @FindBy(xpath = "//span[contains(text(),'Portfolio Builder')]")
    WebElement portfolioBuilderTopNavigationButton;

    @FindBy(id = "ctl00_mainContentPlaceHolder_manualImport_windowAddAnother_C_txtNewPortfolio")
    WebElement portfolioBuilderCreatePortfolioInputBox;


    @FindBy(id = "ctl00_mainContentPlaceHolder_manualImport_windowAddAnother_C_btnAddPortfolio_input")
    WebElement portfolioBuilderCreatePortfolioAddButton;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_gridPortfolios_ctl00_ctl06_gridSnapshots_ctl00_ctl04_labMatchedSecurityName\"]")
    WebElement portfolioBuilderCreatePortfolioClickToAddSecuritiesLink;


    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")
    WebElement portfolioBuilderCreatePortfolioClickToAddSecuritiesInputBox;


    @FindBy(xpath = "//td[contains(text(),'LoadPortfolioBuilder')]")
    WebElement portfolioBuilderVerifyPortfolioName2;


    @FindBy(id = "ctl00_mainContentPlaceHolder_manualImport_gridPortfolios_ctl00_ctl06_gridSnapshots_ctl00_ctl06_txtWeight1")
    WebElement portfolioBuilderWeightInputBox;


    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_headerManual_cmdNext_input']")
    WebElement portfolioBuilderNextButtonLastStep;


    public LoadPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver,this);
    }


}




