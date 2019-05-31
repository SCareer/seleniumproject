package com.styleanalytics.pages;

import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiteMapPage {

    WebDriver driver;

    @FindBy(xpath="//div[@class='sitemapTitle']")
    WebElement siteMapTitle;

    @FindBy(id = "sitemapHamburger")
    WebElement siteMapLink;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl00_hlMenu")
    WebElement portfolios;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl00_rptSubMenu_ctl00_hlMenu")
    WebElement explore;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl00_rptSubMenu_ctl01_hlMenu")
    WebElement dataMart;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl00_rptSubMenu_ctl02_hlMenu")
    WebElement importMonitor;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl00_rptSubMenu_ctl03_hlMenu")
    WebElement automation;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl01_hlMenu")
    WebElement reports;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl01_rptSubMenu_ctl00_hlMenu")
    WebElement portfolioReports;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl01_rptSubMenu_ctl01_hlMenu")
    WebElement peerInsights;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl01_rptSubMenu_ctl02_hlMenu")
    WebElement exportedReports;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl01_rptSubMenu_ctl03_hlMenu")
    WebElement executiveReports;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl02_hlMenu")
    WebElement load;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl03_hlMenu")
    WebElement analyses;

    @FindBy(xpath = "//a[contains(text(),'Activity')]")
    WebElement activity;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl04_rptSubMenu_ctl00_hlMenu")
    WebElement taskActivity;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl04_rptSubMenu_ctl01_hlMenu")
    WebElement fileActivity;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl05_hlMenu")
    WebElement portfolioLabs;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl06_hlMenu")
    WebElement templates;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl07_hlMenu")
    WebElement manage;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl07_rptSubMenu_ctl00_hlMenu")
    WebElement manageCalcset;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl07_rptSubMenu_ctl01_hlMenu")
    WebElement reportProfile;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl07_rptSubMenu_ctl02_hlMenu")
    WebElement fileSpecifications;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl07_rptSubMenu_ctl03_hlMenu")
    WebElement factorSets;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl07_rptSubMenu_ctl04_hlMenu")
    WebElement factorCategorySets;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl07_rptSubMenu_ctl05_hlMenu")
    WebElement userDefinedFactors;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl07_rptSubMenu_ctl06_hlMenu")
    WebElement upgradeFactorAnalysis;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl08_hlMenu")
    WebElement assets;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl08_rptSubMenu_ctl00_hlMenu")
    WebElement equities;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl08_rptSubMenu_ctl01_hlMenu")
    WebElement userDefinedBonds;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl08_rptSubMenu_ctl02_hlMenu")
    WebElement userDefinedMBS;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl08_rptSubMenu_ctl03_hlMenu")
    WebElement currencies;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl08_rptSubMenu_ctl04_hlMenu")
    WebElement funds;

    @FindBy(id = "topNav2_navSiteMap1_rptMenu_ctl08_rptSubMenu_ctl01_hlMenu")
    WebElement manualStockMatchHistory;

    @FindBy(xpath = "//a[contains(text(),'News & Events')]")
    WebElement newsEvents;

    @FindBy(xpath = "//a[contains(text(),'Funds Analyzer')]")
    WebElement fundsAnalyzer;

    @FindBy(xpath = "//a[contains(text(),'Preferences')]")
    WebElement preferences;

    @FindBy(xpath = "//a[contains(text(),'Management Reports')]")
    WebElement managementReports;

    @FindBy(xpath = "//a[contains(text(),'Administration')]")
    WebElement administration;

    @FindBy(xpath = "//a[contains(text(),'My Organization')]")
    WebElement myOrganization;

    @FindBy(xpath = "//a[contains(text(),'Organizations')]")
    WebElement organizations;

    @FindBy(xpath = "//a[contains(text(),'Users')]")
    WebElement users;

    @FindBy(xpath = "//a[contains(text(),'User Groups')]")
    WebElement userGroup;

    @FindBy(xpath = "//a[contains(text(),'Locations')]")
    WebElement locations;

    @FindBy(xpath = "//a[contains(text(),'User Activity')]")
    WebElement userActivity;

    @FindBy(xpath = "//a[contains(text(),'User Provision')]")
    WebElement userProvision;

    @FindBy(xpath = "//a[contains(text(),'Bundles')]")
    WebElement bundles;

    @FindBy(xpath = "//a[contains(text(),'Account Managers')]")
    WebElement accountManagers;

    @FindBy(xpath = "//a[contains(text(),'User Deletion Requests')]")
    WebElement userDeletionRequest;

    @FindBy(xpath = "//a[contains(text(),'Support')]")
    WebElement support;

    @FindBy(xpath = "//a[contains(text(),'Documents')]")
    WebElement documents;

    @FindBy(xpath = "//a[contains(text(),'About')]")
    WebElement about;

    @FindBy(xpath = "//a[contains(text(),'Update Schedule')]")
    WebElement updateSchedule;

    @FindBy(xpath = "//a[contains(text(),'Change Password')]")
    WebElement changePassword;

    @FindBy(xpath = "//a[contains(text(),'Service Requests')]")
    WebElement serviceRequest;



    public WebElement getSiteMapTitle() {
        setSiteMapLink();
        return siteMapTitle;

    }

    public void setSiteMapLink() {

        siteMapLink.click();
        Wait.waitForElementToDisplay(driver,siteMapTitle,60);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void setSiteMenu(WebElement element){

        setSiteMapLink();
        element.click();
    }

    public WebElement getElement(WebElement element){
        return element;
    }

    public void setPortfolios() {

        setSiteMapLink();
        portfolios.click();
        //Wait.untilJqueryIsDone(driver);
        Wait.waitForSquareBoxesToDisappear(driver,60);

    }

    public void setExplore() {

        setSiteMapLink();
        explore.click();

    }

    public void setDataMart() {

        setSiteMapLink();
        dataMart.click();
        Wait.untilJqueryIsDone(driver);


    }

    public void setImportMonitor() {

        setSiteMapLink();
        importMonitor.click();
        Wait.untilJqueryIsDone(driver);

    }

    public void setAutomation() {

        setSiteMapLink();
        automation.click();

    }
    public void setReports() {

        setSiteMapLink();
        reports.click();
        Wait.untilJqueryIsDone(driver);

    }

    public void setPortfolioReports() {
        setSiteMapLink();
        portfolioReports.click();
        Wait.untilJqueryIsDone(driver);

    }

    public void setPeerInsights() {
        setSiteMapLink();
        peerInsights.click();
        Wait.untilJqueryIsDone(driver);

    }

    public void setExportedReports() {

        setSiteMapLink();
        exportedReports.click();

    }

    public void setExecutiveReports() {

        setSiteMapLink();
        executiveReports.click();

    }

    public void setLoad() {

        setSiteMapLink();
        load.click();

    }

    public void setAnalyses() {

        setSiteMapLink();
        analyses.click();
        Wait.untilJqueryIsDone(driver);
    }

    public void setActivity() {

        setSiteMapLink();
        activity.click();
        Wait.untilJqueryIsDone(driver);

    }

    public void setTaskActivity() {

        setSiteMapLink();
        taskActivity.click();
        Wait.untilJqueryIsDone(driver);

    }

    public void setFileActivity() {

        setSiteMapLink();
        fileActivity.click();
        Wait.untilJqueryIsDone(driver);

    }

    public void setPortfolioLabs() {

        setSiteMapLink();
        portfolioLabs.click();

    }

    public void setTemplates() {

        setSiteMapLink();
        templates.click();
        Wait.untilJqueryIsDone(driver);

    }

    public void setManage() {

        setSiteMapLink();
        manage.click();

    }

    public void setManageCalcset() {

        setSiteMapLink();
        manageCalcset.click();

    }

    public void setReportProfile() {

        setSiteMapLink();
        reportProfile.click();

    }

    public void setFileSpecifications() {

        setSiteMapLink();
        fileSpecifications.click();

    }

    public void setFactorSets() {

        setSiteMapLink();
        factorSets.click();

    }

    public void setFactorCategorySets() {

        setSiteMapLink();
        factorCategorySets.click();

    }

    public void setUserDefinedFactors() {

        setSiteMapLink();
        userDefinedFactors.click();

    }

    public void setUpgradeFactorAnalysis() {

        setSiteMapLink();
        upgradeFactorAnalysis.click();

    }

    public void setAssets() {

        setSiteMapLink();
        assets.click();

    }

    public void setEquities() {

        setSiteMapLink();
        equities.click();
        Wait.untilJqueryIsDone(driver);

    }

    public void setUserDefinedBonds() {

        setSiteMapLink();
        userDefinedBonds.click();

    }

    public void setUserDefinedMBS() {

        setSiteMapLink();
        userDefinedMBS.click();

    }

    public void setCurrencies() {
        setSiteMapLink();
        currencies.click();
        Wait.untilJqueryIsDone(driver);
    }

    public void setFunds() {
        setSiteMapLink();
        funds.click();
        Wait.untilJqueryIsDone(driver);
    }

    public void setManualStockMatchHistory() {
        setSiteMapLink();
        manualStockMatchHistory.click();
    }

    public void setNewsEvents() {
        setSiteMapLink();
        newsEvents.click();
    }

    public void setFundsAnalyzer(){
        setSiteMapLink();
        fundsAnalyzer.click();
    }

    public void setPreferences(){

        setSiteMapLink();
        preferences.click();
    }

    public void setManagementReports(){

        setSiteMapLink();
        managementReports.click();
    }

    public void setSupport() {
        setSiteMapLink();
        Wait.moveToElement(support,driver);
        support.click();
    }

    public void setDocuments() {
        setSiteMapLink();
        documents.click();
    }

    public void setAbout() {
        setSiteMapLink();
        about.click();
    }

    public void setUpdateSchedule() {
        setSiteMapLink();
        updateSchedule.click();
    }

    public void setChangePassword() {
        setSiteMapLink();
        changePassword.click();
    }

    public void setServiceRequest() {
        setSiteMapLink();
        serviceRequest.click();
    }

    public SiteMapPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }
}

