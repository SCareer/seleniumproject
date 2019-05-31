package com.styleanalytics.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickLinksPage {

    WebDriver driver;

    @FindBy(id = "iconQuickLinks")
    WebElement quickLink;

    @FindBy(id = "masthead")
    WebElement logo_Home;

    @FindBy(id = "topNav2_hlPortfolioReports")
    WebElement portfolioReports;

    @FindBy(id = "topNav2_hlLoad")
    WebElement load;

    @FindBy(id = "topNav2_hlExplore")
    WebElement explorer;

    @FindBy(id = "topNav2_hlLabs")
    WebElement labs;

    @FindBy(id = "topNav2_hlExecReports")
    WebElement excutiveReports;

    @FindBy(id = "topNav2_hlPeerInsights")
    WebElement peerInsights;

    @FindBy(id = "topNav2_hlCustomPeerGroups")
    WebElement customPeerGroup;

    @FindBy(id = "topNav2_hlSupport")
    WebElement support;

    @FindBy(id = "appCuesWidget")
    WebElement tutorials;

    public void setLogo_Home() {

        logo_Home.click();
    }

    public void setQuickLink() {


        quickLink.click();
    }

    public void setPortfolioReports() throws InterruptedException {

        setQuickLink();
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", portfolioReports);
        portfolioReports.click();
    }

    public void setLoad(){

        setQuickLink();
        load.click();
    }

    public void setExplorer(){

        setQuickLink();
        explorer.click();
    }

    public void setLabs(){

        setQuickLink();
        labs.click();
    }

    public void setExcutiveReports(){

        setQuickLink();
        excutiveReports.click();
    }


    public QuickLinksPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }
}
