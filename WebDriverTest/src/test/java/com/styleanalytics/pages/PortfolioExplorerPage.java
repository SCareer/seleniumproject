package com.styleanalytics.pages;

import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class PortfolioExplorerPage {

    WebDriver driver;

    /**
     * Top Menu in Explorer View Portfolio Settings
     */

    @FindBy(xpath = "//span[contains(text(),'Snapshots')]")
    WebElement snapshots;

    @FindBy(xpath = "//span[contains(text(),'Analyses')]")
    WebElement analyses;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    WebElement tasks;

    @FindBy(xpath = "//span[contains(text(),'Sharing')]")
    WebElement sharing;

    @FindBy(xpath = "//span[contains(text(),'Labels')]")
    WebElement labels;

    @FindBy(xpath = "//span[contains(text(),'Fund Codes')]")
    WebElement fundCodes;

    @FindBy(xpath = "//span[contains(text(),'Returns')]")
    WebElement returns;

    @FindBy(xpath = "//span[contains(text(),'Spotlight')]")
    WebElement spotLight;

    @FindBy(xpath = "//a[@class='rtsLink rtsSelected']")
    WebElement selectedTab;






    /*****
     * Sync
     */

    @FindBy(id = "ctl00_RadAjaxLoadingPanel1aspnetForm")
    WebElement loading_squareBoxes;


    public void setSnapshots() {
        snapshots.click();
        Wait.waitForElementToDisappear(driver,20,loading_squareBoxes);
    }

    public void setAnalyses() {
        analyses.click();
        Wait.waitForElementToDisappear(driver,20,loading_squareBoxes);
    }

    public void setTasks() {

        tasks.click();
        Wait.waitForElementToDisappear(driver,20,loading_squareBoxes);
    }

    public void setShares() {
        sharing.click();
        Wait.waitForElementToDisappear(driver,20,loading_squareBoxes);
    }

    public void setLabels() {
        labels.click();
        Wait.waitForElementToDisappear(driver,20,loading_squareBoxes);
    }

    public void setFundCodes() {
        fundCodes.click();
        Wait.waitForElementToDisappear(driver,20,loading_squareBoxes);
    }

    public void setReturns() {
        returns.click();
        Wait.waitForElementToDisappear(driver,20,loading_squareBoxes);
    }

    public void setSpotLight() {
        spotLight.click();
        Wait.waitForElementToDisappear(driver,20,loading_squareBoxes);
    }

    public void explorerSettingsView(String tab) throws InterruptedException {

        driver.switchTo().frame(0);

        if (tab == "Tasks") {
            try {
                if(!selectedTab.getText().equalsIgnoreCase(tab))
                System.out.println(selectedTab.getText());
                throw new Exception("Not in Tasks");
            } catch (Exception e) {
                setTasks();
            }
        } else if (tab == "Analyses") {
            try {
                if(!selectedTab.getText().equalsIgnoreCase(tab))
                    System.out.println(selectedTab.getText());
                throw new Exception("Not in Tasks");
            } catch (Exception e) {
                setAnalyses();
            }
        } else if (tab == "Returns") {
            try {
                returns.isDisplayed();
            } catch (Exception e) {
                setReturns();
            }
        } else if (tab == "Snapshots") {
            try {
                if(!selectedTab.getText().equalsIgnoreCase(tab))
                    System.out.println(selectedTab.getText());
                throw new Exception("Not in Tasks");
            } catch (Exception e) {
                setSnapshots();
            }

        } else if (tab == "Spotlight") {

            try {
                if(!selectedTab.getText().equalsIgnoreCase(tab))
                    System.out.println(selectedTab.getText());
                throw new Exception("Not in Tasks");
            } catch (Exception e) {
                setSnapshots();

            }

        }else if (tab == "Sharing") {

            try {
                if(!selectedTab.getText().equalsIgnoreCase(tab))
                    System.out.println(selectedTab.getText());
                throw new Exception("Not in Sharing");
            } catch (Exception e) {
                setShares();

            }
        }else if (tab == "Labels") {

            try {
                if(!selectedTab.getText().equalsIgnoreCase(tab))
                    System.out.println(selectedTab.getText());
                throw new Exception("Not in Labels");
            } catch (Exception e) {
                setLabels();

            }
        }

    }



    public PortfolioExplorerPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }

}
