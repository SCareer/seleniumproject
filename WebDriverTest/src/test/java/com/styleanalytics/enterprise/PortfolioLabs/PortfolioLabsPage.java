package com.styleanalytics.enterprise.PortfolioLabs;

import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class PortfolioLabsPage {

    WebDriver driver;
    String addedSecurityName;

    @FindBy(xpath = "//div[@class='chartLoading chartLoadingMessage']")
    WebElement loading_Main;

    @FindBy(id ="rhsHamb")
    WebElement rightSideMenuCog;

    @FindBy(xpath ="//*[@id='ctl00_mainContentPlaceHolder_report_aCreateScenario']/span[1]")
    WebElement createScenario;

    @FindBy(xpath ="//*[@id='scenarioName']")
    WebElement scenarioName;

    @FindBy(xpath ="//a[@id='btnChange']")
    WebElement changeIcon;

    @FindBy(xpath ="//a[@id='btnBeforeAfter']")
    WebElement beforeAfterIcon;

    @FindBy(xpath ="//a[@id='btnAfter'] ")
    WebElement afterIcon;

    @FindBy(xpath ="//a[@id='btnBefore']")
    WebElement beforeIcon;

    @FindBy(xpath ="//input[@id='ctl00_mainContentPlaceHolder_cmdGroupByMarket_input']")
    WebElement groupByMarket;

    @FindBy(xpath ="//input[@id='ctl00_mainContentPlaceHolder_cmdBuySecurity_input']")
    WebElement buy;

    @FindBy(xpath ="//input[@id='ctl00_mainContentPlaceHolder_RadButton2_input']")
    WebElement increaseCash;

    @FindBy(xpath ="//input[@id='ctl00_mainContentPlaceHolder_RadButton1_input']")
    WebElement updateNav;

    @FindBy(xpath ="//input[@id='ctl00_mainContentPlaceHolder_cmdSaveAs_input']")
    WebElement saveAs;

    @FindBy(xpath ="//input[@id='ctl00_mainContentPlaceHolder_cmdApplyChanges_input']")
    WebElement applyChanges;

    @FindBy(xpath ="//input[@id='ctl00_mainContentPlaceHolder_cmdToggleReports_input']")
    WebElement toggle;

    @FindBy(xpath ="//div[@class='widgetNav nextWidget']")
    WebElement rightArrow;

    @FindBy(xpath ="//img[@id='pagePane0_divContent0-img']")
    WebElement skylineReport;

    @FindBy(xpath ="//img[@id='pagePane0_divContent1-img']")
    WebElement riskReport;

    @FindBy(xpath ="//div[@id='pagePane0_divBlock2']")
    WebElement keyData;

    @FindBy(xpath ="//img[@id='pagePane1_divContent0-img']")
    WebElement regionReport;

    @FindBy(xpath ="//img[@id='pagePane1_divContent1-img']")
    WebElement sectorReport;

    @FindBy(xpath ="//img[@id='pagePane2_divContent0-img']")
    WebElement styleReport;

    @FindBy(xpath ="//img[@id='pagePane2_divContent1-img']")
    WebElement sizeReport;

    @FindBy(id = "txtUpdateNAV")
    WebElement inputNav;

    @FindBy(xpath = "//input[@id='btnUpdateNav']")
    WebElement addNav;

    @FindBy(xpath = "//span[@id='spanNav']")
    WebElement navValue;

    @FindBy(xpath ="//input[@id='txtAddCashNAV']" )
    WebElement inputCash;

    @FindBy(xpath ="//input[@id='btnAddCash']" )
    WebElement addCash;

    @FindBy(id ="spanCash" )
    WebElement cashValue;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_Input']")
    WebElement inputSecurity;

    @FindBy(xpath = "//*[@id=\"stockMatchItem\"]/span[2]")
    WebElement securitySearchResult;

    @FindBy(id = "txtBuyWeight")
    WebElement inputWeight;

    @FindBy(id = "btnBuy")
    WebElement buySecurity;

    @FindBy(xpath = "//a[@class='gridLink']")
    WebElement addedSecurity;

    @FindBy(xpath ="//div[contains(text(),'Style Distribution')]" )
    WebElement styleDistributionTitle;

    @FindBy(xpath = "//label[@for='radBuySecurityAssetType_4']")
    WebElement portfolio;

    @FindBy(xpath = "//label[@for='radBuySecurityAssetType_2']")
    WebElement cash;

    @FindBy(xpath = "//label[@for='radBuySecurityAssetType_0']")
    WebElement equities;

    @FindBy(xpath = "//*[@class=\"chartLoading chartLoadingMessage\"]")
    WebElement reportMainLoadSpinner;

    @FindBy(xpath = "//div[contains(@class,'chartLoading')]")
    WebElement reportChartSpinner;


    /***
     * Sync
     */
     //div[contains(@class,'chartLoading chartLoadingMessage')]

    //div[contains(@class,'chartLoading')]


    public void waitUntilMainReportsLoad(){

        Wait.waitForElementToDisappear(driver,180,reportMainLoadSpinner);
        Wait.waitForElementToDisappear(driver,20,reportChartSpinner);
    }

    public void waitUntilChartsLoad(){

        Wait.waitForElementToDisappear(driver,20,reportChartSpinner);
    }


    public void setRightArrow(){
        rightArrow.click();
        waitUntilChartsLoad();

    }

    public Boolean isDisplayed(WebElement report){
        report.isDisplayed();
        return true;
    }

    public void setRightSideMenuCog() {
        rightSideMenuCog.click();
    }



    public void createScenario() throws InterruptedException {

        setRightSideMenuCog();
        Wait.waitForElementToDisplay(driver,createScenario,5);
        createScenario.click();
        waitUntilMainReportsLoad();

    }

    public void increaseNav(double value){
        updateNav.click();
        inputNav.clear();
        inputNav.sendKeys(String.valueOf(value));
        addNav.click();
        String exp = this.navValue.getText();
        String nExp = exp.replaceAll(",","");
        Assert.assertEquals(value,Double.parseDouble(nExp),"Increase Nav Value did not Match");
        applyChanges.click();
        waitUntilMainReportsLoad();
    }

    public void increaseCash(int value){

        increaseCash.click();
        inputCash.clear();
        String inputValue = String.valueOf(value)+getCashValue();
        inputCash.sendKeys(inputValue);
        addCash.click();
        Assert.assertEquals(getCashValue(),inputValue,"Increase Cash Value did not Match");
        applyChanges.click();
        waitUntilMainReportsLoad();

    }

    public String getCashValue(){

        String exp = cashValue.getText();
        String nExp = exp.replaceAll(",","");
        return nExp;
    }

    public void buyEquity(String equityName,String weight) throws InterruptedException {

        buy.click();
        equities.click();
        inputSecurity.sendKeys(equityName);
        Wait.waitForElementToDisplay(driver,securitySearchResult,60);
        securitySearchResult.click();
        Wait.waitForElementToDisappear(driver,10,inputWeight);
        inputWeight.sendKeys(weight);
        buySecurity.click();
        String actual = addedSecurity.getAttribute("innerText");
        Assert.assertEquals(actual,equityName,"Added Security did not match");
        applyChanges.click();
        waitUntilMainReportsLoad();

    }

    public void buyPortfolio(String portfolioName,String weight) throws InterruptedException {

        buy.click();
        portfolio.click();
        inputSecurity.sendKeys(portfolioName);
        Wait.waitForElementToDisplay(driver,securitySearchResult,60);
        securitySearchResult.click();
        Wait.waitForElementToDisappear(driver,10,inputWeight);
        inputWeight.sendKeys(weight);
        buySecurity.click();
        String actual = addedSecurity.getAttribute("innerText");
        Assert.assertEquals(actual,portfolioName,"Added Security did not match");
        applyChanges.click();
        waitUntilMainReportsLoad();

    }

    public void buyCash(String cashName,String weight) throws InterruptedException {

        buy.click();
        cash.click();
        inputSecurity.sendKeys(cashName);
        Wait.waitForElementToDisplay(driver,securitySearchResult,60);
        securitySearchResult.click();
        Wait.waitForElementToDisappear(driver,10,inputWeight);
        inputWeight.sendKeys(weight);
        buySecurity.click();
        String actual = addedSecurity.getAttribute("innerText");
        Assert.assertEquals(actual,cashName,"Added Security did not match");
        applyChanges.click();
        waitUntilMainReportsLoad();

    }

    public void setBeforeAfterIcon(){

        beforeAfterIcon.click();
        waitUntilChartsLoad();
    }

    public void setChangeIcon(){

        changeIcon.click();
        waitUntilChartsLoad();
    }

    public void setBeforeIcon(){

        beforeIcon.click();
        waitUntilChartsLoad();
    }

    public void setAfterIcon(){

        afterIcon.click();
        waitUntilChartsLoad();
    }

    public void verifyReports()  {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(isDisplayed(skylineReport),"Skyline not Displayed");
        softAssert.assertTrue(isDisplayed(riskReport),"Skyline not Displayed");
        softAssert.assertTrue(isDisplayed(keyData),"Skyline not Displayed");

        setRightArrow();

        softAssert.assertTrue(isDisplayed(sectorReport),"Skyline not Displayed");
        softAssert.assertTrue(isDisplayed(regionReport),"Skyline not Displayed");

        setRightArrow();

        try{

            styleDistributionTitle.isDisplayed();
        }catch (NoSuchElementException e){
            setRightArrow();
        }

        softAssert.assertTrue(isDisplayed(styleReport),"Skyline not Displayed");
        softAssert.assertTrue(isDisplayed(sizeReport),"Skyline not Displayed");

            softAssert.assertAll();


    }

    public void verifyAllReports(){

        verifyReports();
        setChangeIcon();
        verifyReports();
        setBeforeIcon();
        verifyReports();
        setAfterIcon();
        verifyReports();
        setBeforeAfterIcon();
    }

    public PortfolioLabsPage(WebDriver driver) {

        this.driver = driver;

       // PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);

        PageFactory.initElements(driver, this);

    }
}
