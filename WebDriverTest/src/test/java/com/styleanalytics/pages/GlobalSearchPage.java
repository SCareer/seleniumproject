package com.styleanalytics.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.styleanalytics.enterprise.Wait;



public class GlobalSearchPage {

    WebDriver driver;

    /**
     * Global quick Search in the top right corner of the app
     */

    @FindBy(id = "iconSearch")
    WebElement globalSearch;

    @FindBy(id = "txtPortfolioSearch")
    WebElement searchTextBox;

    @FindBy(xpath = "//*[@id=\"portfolioSearchPortfolioList\"]/div[4]/div[3]/div/div[1]/div[2]")
    WebElement firstSearchResult;

    @FindBy(xpath = "//*[@id=\"portfolioSearchPortfolioList\"]/div[9]")
    WebElement searchResultSpinner;

    @FindBy(xpath = "//*[@id=\"ctl00_mainMasterBody\"]/div[5]/div[4]/div/div")
    WebElement viewPortfolioSummarySpinner;



    @FindBy(xpath = "//a[contains(text(),'View in Portfolio Explorer')]")
    WebElement viewInPortfolioExplorer;

    @FindBy(xpath = "//a[contains(text(),'View in Task Activity')]")
    WebElement viewInTaskActivity;



    public WebElement getGlobalSearch() {
        return globalSearch;
    }

    public WebElement getSearchTextBox() {
        return searchTextBox;
    }

    public WebElement getFirstSearchResult() {
        return firstSearchResult;
    }

    public void searchPortfolio(String portfolioName){

        getGlobalSearch().click();
        getSearchTextBox().sendKeys(portfolioName);
        Wait.waitForElementToDisappear(driver,10,searchResultSpinner);

    }

    public void viewInPortfolioExplorer(String portfolioName){

        searchPortfolio(portfolioName);
        getFirstSearchResult().click();
        Wait.waitForElementToDisappear(driver,10,viewPortfolioSummarySpinner);
        viewInPortfolioExplorer.click();

    }

    public void viewInTaskActivity(String portfolioName){

        searchPortfolio(portfolioName);
        getFirstSearchResult().click();
        Wait.waitForElementToDisappear(driver,10,viewPortfolioSummarySpinner);
        viewInTaskActivity.click();

    }

    public GlobalSearchPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }
}
