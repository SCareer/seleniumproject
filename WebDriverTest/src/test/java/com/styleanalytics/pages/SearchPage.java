
package com.styleanalytics.pages;

import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;


public class SearchPage  {

    WebDriver driver;

    // Portfolio search Icon

    @FindBy(id = "iconSearch")
    WebElement searchIcon;

    // Portfolio search Textbox

    @FindBy(id = "txtPortfolioSearch")
    WebElement searchTextBlock;

    // First search result

    @FindBy(xpath = "//*[@id=\"portfolioSearchPortfolioList\"]/div[4]/div[3]/div/div[1]/div[2]")
    WebElement firstSearchResult;

    // button/Link to Portfolio explorer

    @FindBy(xpath ="//a[contains(text(),'View in Portfolio Explorer')]")
    WebElement portfolioExplorerLink;

    // Portfolio Text on Panel
    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/h2")
    WebElement portfolioTextOnPanel;

    // User Reference label Text
    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[1]/div[1]/span")
    WebElement userReferenceText;

    // ISIN label Text
    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[1]/div[2]/span")
    WebElement isinText;


    // Ticker label Text
    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[1]/div[3]/span")
    WebElement tickerText;

    // Last Snapshot label text Text
    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[2]/div[1]/span")
    WebElement lastSnapshotLabelText;

    // Organisation label text
    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[2]/div[2]/span")
    WebElement organisationLabelText;


    //Registration Label Text

    @FindBy(xpath ="//*[@id=\"portfolioRegistrationHeader\"]")
    WebElement registrationLabelText;

    //Investment Strategy label Text

    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[3]/span[1] ")
    WebElement  investmentStrategyLabelText;


    //BenchMark Strategy label Text

    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[3]/span[2] ")
    WebElement benchmarkLabelText;

    //Company label Text

    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[3]/span[3] ")
    WebElement companyLabelText;


    //Legal structure label Text

    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[3]/span[4] ")
    WebElement legalStructureLabelText;

    //Domicile label Text

    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[3]/span[5] ")
    WebElement domicileLabelText;


    //Classification label Text

    @FindBy(xpath ="//*[@id=\"portfolioClassificationHeader\"]")
    WebElement classificationLabelText;


   //MorningStar Category label Text

    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[5]/span[1]")
    WebElement morningStarCategoryLabelText;


    //Global Category label Text

    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[5]/span[2]")
    WebElement globalStarCategoryLabelText;

    //Index fund label Text

    @FindBy(xpath ="//*[@id=\"html\"]/body/div[2]/div[4]/div/div[5]/span[3]")
    WebElement indexFundLabelText;


    @FindBy(xpath = "//a[contains(text(),'View in Task Activity')]")
    WebElement taskActivityLink;


    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_panChapters']/div[2]")
    WebElement piStyleExposureMainMenu;

    /***
     * Sync
     */

    @FindBy(xpath = "//div[contains(@class,'chartLoading')]")
    WebElement loading_squares;



    public void setSearchIcon(){
        Wait.waitForElementToDisplay(driver,searchIcon,60);
        searchIcon.click();
    }

    public void setSearchTextBlock(String searchKey){

        searchTextBlock.sendKeys(searchKey);
        Wait.waitForElementToDisappear(driver,60,loading_squares);
    }

    public void setFirstSearchResult(){

        firstSearchResult.click();
        Wait.waitForElementToDisappear(driver,60,loading_squares);
    }

    public  void setPortfolioExplorerLink(){

        portfolioExplorerLink.click();
    }

    public void setTaskActivityLink(){

        taskActivityLink.click();
    }

    public void portfolioQuickSearch(String portfolioName){

        setSearchIcon();
        setSearchTextBlock(portfolioName);
        setFirstSearchResult();

    }

    public void explorePortfolioFromQuickSearch(String portfolioName){

        portfolioQuickSearch(portfolioName);
        setPortfolioExplorerLink();
    }

    public SearchPage(WebDriver driver){

        this.driver = driver;
        initElements(driver, this);

    }

}
