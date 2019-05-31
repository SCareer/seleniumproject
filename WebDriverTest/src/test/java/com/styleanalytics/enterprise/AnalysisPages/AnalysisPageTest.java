package com.styleanalytics.enterprise.AnalysisPages;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.utils.DataTables;
import com.styleanalytics.pages.*;
import com.styleanalytics.setup.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.Format;
import java.text.ParseException;

public class AnalysisPageTest extends TestBase {

    AnalysisPage analysisPage;
    SiteMapPage siteMapPage;
    SoftAssert softAssert;
    DataTables dataTables;

    @BeforeClass
    public void analysisPageSetup() throws IOException {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
        analysisPage = new AnalysisPage(getDriver());

    }
    @AfterMethod
    public void resetTest(){

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.setDashboard();
    }
    @Test
    public void isTheGridLoadedWithAllExpectedColumns(){

        siteMapPage = new SiteMapPage(getDriver());
        siteMapPage.setAnalyses();
        softAssert = new SoftAssert();
        verifyColumnsInCompleted();
        analysisPage.setFailed();
        verifyColumnsInRestOfTheTabs();
        analysisPage.setPending();
        verifyColumnsInRestOfTheTabs();
        analysisPage.setRunning();
        verifyColumnsInRestOfTheTabs();
        analysisPage.setWaitingForData();
        verifyColumnsInRestOfTheTabs();
        softAssert.assertAll();

    }

    @Test
    public void deleteAllAnalysisFromFailed() throws ParseException {
        siteMapPage = new SiteMapPage(getDriver());
        siteMapPage.setAnalyses();
        System.out.println(analysisPage.getWaitingForDataCount());
        System.out.println(analysisPage.getRunningCount());
        System.out.println(analysisPage.getFailedCount());
        System.out.println(analysisPage.getPendingCount());
        System.out.println(analysisPage.getCompletedCount());

    }

    @Test
    public void isTheGridDisplayedFromExplorerPage() throws InterruptedException {

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.portfolioQuickSearch("Sanity");
        searchPage.setFirstSearchResult();
        searchPage.setPortfolioExplorerLink();

        PortfolioExplorerPage portfolioExplorerPage = new PortfolioExplorerPage(getDriver());
        portfolioExplorerPage.explorerSettingsView("Analyses");
        softAssert = new SoftAssert();
        verifyColumnsInCompleted();
        analysisPage.setFailed();
        verifyColumnsInRestOfTheTabs();
        analysisPage.setPending();
        verifyColumnsInRestOfTheTabs();
        analysisPage.setRunning();
        verifyColumnsInRestOfTheTabs();
        analysisPage.setWaitingForData();
        verifyColumnsInRestOfTheTabs();

        softAssert.assertAll();
        getDriver().switchTo().defaultContent();

    }

    public void verifyColumnsInCompleted(){


        softAssert.assertTrue(analysisPage.getWaitingForData().getText().contains("Waiting for Data"),"Waiting for Data");
        softAssert.assertTrue(analysisPage.getPending().getText().contains("Pending"),"Pending");
        softAssert.assertTrue(analysisPage.getRunning().getText().contains("Running"),"Running");
        softAssert.assertTrue(analysisPage.getComplete().getText().contains("Complete"),"Complete");
        softAssert.assertTrue(analysisPage.getFailed().getText().contains("Failed"),"Failed");


        //softAssert.assertTrue(analysisPage.getEmbargo().getText().equals("Embargo"),"Embargo");
        softAssert.assertTrue(analysisPage.getAudit().getText().equals("Audit"),"Audit");
        softAssert.assertTrue(analysisPage.getMatched().getText().equals("Matched"),"Matched");
        softAssert.assertTrue(analysisPage.getTrunover().getText().equals("Turnover"),"Turnover");
        softAssert.assertTrue(analysisPage.getAnalysisDate().getText().equals("Analysis Date"),"Analysis Date");
        softAssert.assertTrue(analysisPage.getRunAt().getText().equals("Run At"),"Run At");
        softAssert.assertTrue(analysisPage.getReportProfile().getText().equals("Report Profile"),"Report Profile");
        softAssert.assertTrue(analysisPage.getAnalyzedPortfolio().getText().equals("Portfolio"),"Portfolio");
        softAssert.assertTrue(analysisPage.getBenchmark().getText().equals("Benchmark"),"Benchmark");
        softAssert.assertTrue(analysisPage.getUniverse().getText().equals("Universe"),"Universe");
        softAssert.assertTrue(analysisPage.getExchangeCalender().getText().equals("Exchange Calendar"),"Exchange Calendar");
        softAssert.assertTrue(analysisPage.getSubmittedBy().getText().equals("Submitted By"),"Submitted By");


    }

    public void verifyColumnsInRestOfTheTabs(){


        softAssert.assertTrue(analysisPage.getWaitingForData().getText().contains("Waiting for Data"),"Waiting for Data");
        softAssert.assertTrue(analysisPage.getPending().getText().contains("Pending"),"Pending");
        softAssert.assertTrue(analysisPage.getRunning().getText().contains("Running"),"Running");
        softAssert.assertTrue(analysisPage.getComplete().getText().contains("Complete"),"Complete");
        softAssert.assertTrue(analysisPage.getFailed().getText().contains("Failed"),"Failed");


        //softAssert.assertTrue(analysisPage.getEmbargo().getText().equals("Embargo"),"Embargo");
        //softAssert.assertTrue(analysisPage.getAudit().getText().equals("Audit"),"Audit");
        //softAssert.assertTrue(analysisPage.getMatched().getText().equals("Matched"),"Matched");
       // softAssert.assertTrue(analysisPage.getTrunover().getText().equals("Turnover"),"Turnover");
        softAssert.assertTrue(analysisPage.getAnalysisDate().getText().equals("Analysis Date"),"Analysis Date");
        softAssert.assertTrue(analysisPage.getRunAt().getText().equals("Run At"),"Run At");
        softAssert.assertTrue(analysisPage.getReportProfile().getText().equals("Report Profile"),"Report Profile");
        softAssert.assertTrue(analysisPage.getAnalyzedPortfolio().getText().equals("Portfolio"),"Portfolio");
        softAssert.assertTrue(analysisPage.getBenchmark().getText().equals("Benchmark"),"Benchmark");
        softAssert.assertTrue(analysisPage.getUniverse().getText().equals("Universe"),"Universe");
        softAssert.assertTrue(analysisPage.getExchangeCalender().getText().equals("Exchange Calendar"),"Exchange Calendar");
        softAssert.assertTrue(analysisPage.getSubmittedBy().getText().equals("Submitted By"),"Submitted By");


    }




}
