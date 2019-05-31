package com.styleanalytics.enterprise;

import com.styleanalytics.enterprise.PortfolioLabs.PortfolioLabsTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class Ticker extends EnterpriseBaseClass {



    @Test(priority = 1)
    public void tickerSearchGlobal() throws InterruptedException, IOException {

        String tickerPortfolio = property("TickerPortfolio");

        String tickerId = property("TickerName");

        SoftAssert softAssert = new SoftAssert();

        Driver.findElement(By.id("iconSearch")).click();

        Driver.findElement(By.id("txtPortfolioSearch")).sendKeys(tickerId);

        Thread.sleep(4000);

        String portfolioName = Driver.findElement(By.xpath("//*[@id=\"portfolioSearchPortfolioList\"]/div[4]/div[3]/div/div/div[2]/span")).getText();

        softAssert.assertEquals(portfolioName, tickerPortfolio);

        softAssert.assertAll();

    }




    @Test(priority = 2)
    public void tickerReportSearch() throws IOException, InterruptedException {

        String tickerPortfolio = property("TickerPortfolio");

        String tickerId = property("TickerName");

        SoftAssert softAssert = new SoftAssert();

        Thread.sleep(4000);

        WebElement Box = Driver.findElement(By.xpath("//*[@id=\"headerLinks\"]"));

        Box.findElement(By.id("topNav2_hlReports")).click();

        Thread.sleep(4000);

        Driver.findElement(By.id("ctl00_mainContentPlaceHolder_report_panPortfolioName")).click();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input\"]")).sendKeys(tickerId);

        Thread.sleep(3000);

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"quickSearchHeader\"]/span[5]")).getText(), "TICKER");


        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"quickSearchHeader\"]/span[6]")).getText(), "ISIN");

        softAssert.assertAll();


    }


    @Test(priority = 3)
    public void tickerSearchPortfolioBuilderByEquities() throws IOException, InterruptedException {

        String tickerPortfolio = property("TickerPortfolio");

        String tickerId = property("TickerName");

        String tickerSecurity = property("TickerSecurity");

        SoftAssert softAssert = new SoftAssert();

        GoTo goTo = new GoTo();

        goTo.goToLoadPage();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabImportType\"]/div/ul/li[2]/a/span/span")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_windowAddAnother_C_txtNewPortfolio\"]")).click();


        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_windowAddAnother_C_txtNewPortfolio\"]")).sendKeys("sss");

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_windowAddAnother_C_btnAddPortfolio_input\"]")).click();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_gridPortfolios_ctl00_ctl06_gridSnapshots_ctl00_ctl04_labMatchedSecurityName\"]")).click();

        Thread.sleep(4000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_portfolioStockMatchPopup_winStockMatch_C_ddlAssetType\"]")).click();

        Thread.sleep(4000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_portfolioStockMatchPopup_winStockMatch_C_ddlAssetType_DropDown\"]/div/ul/li[1]")).click();


        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")).click();

        Thread.sleep(4000);


        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[16]")).getText(), "Ticker");


        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")).sendKeys(tickerSecurity);

        Thread.sleep(4000);

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchItem\"]/span[8]")).getText(), "BUDI");


        softAssert.assertAll();


    }


    @Test(priority = 4)
    public void tickerSearchByPortfolioPortfolioBuilder() throws IOException, InterruptedException {

        String tickerPortfolio = property("TickerPortfolio");

        String tickerId = property("TickerName");


        SoftAssert softAssert = new SoftAssert();

        GoTo goTo = new GoTo();

        goTo.goToLoadPage();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabImportType\"]/div/ul/li[2]/a/span/span")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_windowAddAnother_C_txtNewPortfolio\"]")).click();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_windowAddAnother_C_txtNewPortfolio\"]")).sendKeys("sss");

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_windowAddAnother_C_btnAddPortfolio_input\"]")).click();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_gridPortfolios_ctl00_ctl06_gridSnapshots_ctl00_ctl04_labMatchedSecurityName\"]")).click();

        Thread.sleep(4000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_portfolioStockMatchPopup_winStockMatch_C_ddlAssetType\"]")).click();

        Thread.sleep(4000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_portfolioStockMatchPopup_winStockMatch_C_ddlAssetType_DropDown\"]/div/ul/li[2]")).click();


        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")).click();

        Thread.sleep(4000);

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[16]")).getText(), "Ticker");


        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_manualImport_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")).sendKeys(tickerId);

        Thread.sleep(4000);

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchItem\"]/span[6]")).getText(), "TICK1");

        softAssert.assertAll();


    }

    @Test(priority = 5)
    public void tickerLabelsPeerInsight() throws IOException, InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        GoTo.peerInsights();

        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_cmdNew\"]")).click();

        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlHighlight_Input\"]")).click();

        Thread.sleep(5000);

        String TickerText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlHighlight_Header\"]/div/div[3]")).getText();

        softAssert.assertEquals(TickerText, "Ticker");

        Thread.sleep(5000);

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlHighlight_Header\"]/div/div[4]")).getText(), "ISIN");

        softAssert.assertAll();
    }


    @Test(priority = 6)
    public void tickerSearchPeerInsight() throws IOException, InterruptedException {

        String peerTickerId = property("TickerPeerInsight");

        SoftAssert softAssert = new SoftAssert();

        GoTo.peerInsights();

        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_cmdNew\"]")).click();

        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlPeerGroupProviders_Input\"]")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlPeerGroupProviders_DropDown\"]/div/ul/li[2]")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlPeerGroupProviderProducts_Input\"]")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlPeerGroupProviderProducts_DropDown\"]/div/ul/li[2]")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlTreeViewPeerGroups\"]/span/span[1]")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlTreeViewPeerGroups_EmbeddedTree\"]/ul/li[1]/div/span[3]")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlTreeViewPeerGroups_EmbeddedTree\"]/ul/li[1]/ul/li/div/span[2]")).click();


        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlHighlight_Input\"]")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlHighlight_Input\"]")).sendKeys(peerTickerId);

        Thread.sleep(3000);

        String TickerText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_PeerGroupSelectorControl_analysisProperties_ddlHighlight_Header\"]/div/div[3]")).getText();

        softAssert.assertEquals(TickerText, "Ticker");

        Thread.sleep(5000);

       // String piPortName = property("TickerPeerInsightPortfolio");

       // String textPName = Driver.findElement(By.xpath("//div[@class='veryWideCol'][contains(text(),'" + piPortName + "')]")).getText();

       // softAssert.assertEquals(textPName, piPortName);

        String textTicker = Driver.findElement(By.xpath("//html//div[3]/em[1]")).getText();

        softAssert.assertEquals(textTicker, peerTickerId);

        softAssert.assertAll();

        //div[@class='veryWideCol'][contains(text(),'iShares Asia 50 ETF (AU)')]


    }

    @Test(priority = 7)
    public void tickerSearchPLabs() throws IOException, InterruptedException {

        String tickerId = property("TickerName");

        String tickerSecurity = property("TickerSecurity");

        SoftAssert softAssert = new SoftAssert();

        GoTo.portfolioLabs();

        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"divExistingScenariosGrid\"]/div[4]/div[3]/div/div[1]/div[5]/a")).click();

        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdBuySecurity_input\"]")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")).sendKeys(tickerSecurity);

        Thread.sleep(5000);

        WebElement Box = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_Header\"]"));

        softAssert.assertEquals(Box.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[16]")).getText(), "Ticker");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchItem\"]/span[8]")).getText(), "BUDI");

        Driver.findElement(By.xpath("//*[@id=\"radBuySecurityAssetType_4\"]")).click();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")).clear();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")).sendKeys(tickerId);

        Thread.sleep(3000);

        Box = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_securityQuickSearch_ddlSecurityQuickSearch_Header\"]"));

        softAssert.assertEquals(Box.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[16]")).getText(), "Ticker");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchItem\"]/span[6]")).getText(), "TICK1");

        softAssert.assertAll();


    }

    @Test(priority = 8)
    public void tickerLabelPLabs() throws IOException, InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        GoTo.portfolioLabs();

        Driver.findElement(By.xpath("//*[@id=\"divExistingScenariosGrid\"]/div[4]/div[3]/div/div[1]/div[5]/a")).click();

        Thread.sleep(5000);

        WebElement Header = Driver.findElement(By.xpath("//*[@id=\"divGridScenarioEditor\"]/div[2]/div/div"));

        List<WebElement> links = Header.findElements(By.tagName("div"));

        softAssert.assertEquals(links.get(4).getText(), "ISIN");

        softAssert.assertEquals(links.get(6).getText(), "SEDOL");

        softAssert.assertEquals(links.get(8).getText(), "Ticker");

        softAssert.assertEquals(links.get(10).getText(), "Security");

        softAssert.assertAll();

    }


    @Test(priority = 9)
    public void pLabSecuritySearchByTicker() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        GoTo.portfolioLabs();

        Driver.findElement(By.xpath("//*[@id=\"divExistingScenariosGrid\"]/div[4]/div[3]/div/div[1]/div[5]/a")).click();

        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"divGridScenarioEditor\"]/div[4]/div[1]/div[2]/div[5]/input")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"divGridScenarioEditor\"]/div[4]/div[1]/div[2]/div[5]/input")).sendKeys("INFY");

        Thread.sleep(3000);

        softAssert.assertTrue(Driver.findElement(By.xpath("//*[@id=\"divGridScenarioEditor\"]/div[4]/div[3]/div/div[1]/div[5]")).isDisplayed(), "True");

        softAssert.assertAll();

    }


    @Test(priority = 10)
    public void pLabSecuritySearchBySEDOL() throws IOException, InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        GoTo.portfolioLabs();

        Driver.findElement(By.xpath("//*[@id=\"divExistingScenariosGrid\"]/div[4]/div[3]/div/div[1]/div[5]/a")).click();

        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"divGridScenarioEditor\"]/div[4]/div[1]/div[2]/div[4]/input")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"divGridScenarioEditor\"]/div[4]/div[1]/div[2]/div[4]/input")).sendKeys("6461593");

        Thread.sleep(3000);

        softAssert.assertTrue(Driver.findElement(By.xpath("//*[@id=\"divGridScenarioEditor\"]/div[4]/div[3]/div/div[1]/div[5]")).isDisplayed(), "True");

        softAssert.assertAll();

    }


    public void accessStockMatch() throws IOException, InterruptedException {

        GoTo goTo = new GoTo();

        GoTo.goToExplorerPage();

        String portfolioName = property("TickerPortfolio");

        Utility.portfolioQuickSearchInExplorer(portfolioName);

       // Utility.waitForElementToDisplayByXpath("//span[@id='ctl00_mainContentPlaceHolder_ExploreDetail_portfolioName']",10000);

         Thread.sleep(10000);

        WebElement box =Driver.findElement(By.xpath("//span[contains(text(),'Snapshots')]"));

       // Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_radTabStripExploreDetail\"]/div/ul/li[2]/a/span/span/span")).click();

        Actions action = new Actions(Driver);

        action.moveToElement(box).doubleClick().perform();

        Thread.sleep(10000);

        Actions act = new Actions(Driver);

        WebElement stockMatchLink = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_ctl04_labPercentage\"]"));

        act.moveToElement(stockMatchLink).doubleClick().build().perform();

        Thread.sleep(5000);

    }


    @Test(priority = 11)
    public void tickerSearchByEquitiesStockMatch() throws IOException, InterruptedException {

        String tickerSecurity = property("TickerSecurity");

        accessStockMatch();

        SoftAssert softAssert = new SoftAssert();

        Driver.switchTo().frame(0);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00_ctl04_labMatchedSecurityName\"]")).click();

        Thread.sleep(4000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")).clear();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")).sendKeys("GTPR");

        Thread.sleep(4000);

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[16]")).getText(), "Ticker");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[8]")).getText(), "Share Type");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[7]")).getText(), "ADR");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[6]")).getText(), "Last Market Cap.");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[5]")).getText(), "Country");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[4]")).getText(), "Sector");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[2]")).getText(), "Security");

        softAssert.assertTrue(Driver.findElement(By.xpath("//*[@id=\"stockMatchItem\"]/span[8]")).isDisplayed(), "True");

        Driver.switchTo().defaultContent();

        softAssert.assertAll();

    }


    @Test(priority = 12)

    public void tickerSearchByPortfoliosStockMatch() throws InterruptedException, IOException {

        String tickerId = property("TickerName");

        accessStockMatch();

        SoftAssert softAssert = new SoftAssert();

        Driver.switchTo().frame(0);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00_ctl04_labMatchedSecurityName\"]")).click();

        Thread.sleep(4000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_ddlAssetType\"]/table/tbody/tr/td[1]")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_ddlAssetType_DropDown\"]/div/ul/li[2]")).click();

        Thread.sleep(2000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")).clear();


        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_portfolioStockMatchPopup_winStockMatch_C_securityQuickSearch_ddlSecurityQuickSearch_Input\"]")).sendKeys(tickerId);

        Thread.sleep(4000);

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[16]")).getText(), "Ticker");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[15]")).getText(), "SEDOL");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[14]")).getText(), "ISIN");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[6]")).getText(), "Last Snapshot");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[2]")).getText(), "Security");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[17]")).getText(), "User Ref.");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchHeader\"]/span[18]")).getText(), "Organization");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"stockMatchItem\"]/span[6]")).getText(), "TICK1");

        Driver.switchTo().defaultContent();

        softAssert.assertAll();

    }




}

