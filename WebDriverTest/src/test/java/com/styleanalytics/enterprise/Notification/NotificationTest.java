package com.styleanalytics.enterprise.Notification;

import com.styleanalytics.enterprise.*;

import com.styleanalytics.enterprise.AnalysisPages.AnalysisPageHelper;
import com.styleanalytics.enterprise.DispatchAnalysis.DispatchAnalysisHelper;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 02/06/2017.
 */
public class NotificationTest extends EnterpriseBaseClass {

    private NotificationPage nPage;

    private String portfolio = property("NotificationPortfolio");

    GoTo goTo = new GoTo();

    public NotificationTest() throws IOException {
    }


    @BeforeClass
    public void NotificationTest() throws InterruptedException {

        nPage = new NotificationPage();


    }

    public void searchAndSubmit(String portfolioName) throws Exception {

        DispatchAnalysisHelper dispatchAnalysisHelper = new DispatchAnalysisHelper();
        dispatchAnalysisHelper.fromExplorer(portfolioName);


    }


   //@Test(priority = 1)
    public void checkWaitingForData() throws InterruptedException {

        Thread.sleep(5000); //we need to wait for the notification to be loaded

        Utility.isElementPresentAndClick(nPage.analysisNotificationIcon, 2);

        Utility.isElementPresentAndClick(nPage.waitingForData, 2);

        Utility.isElementPresentAndClick(nPage.linkFromWaitingForDataToAnalysisPage, 2);

        WebElement reasonsColumnInWaitingForData =  Utility.isElementPresent("//*[@id='ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_Header']/thead/tr/th[15]/a",10);

        Utility.isElementPresent("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_ctl04_CheckboxSelectColumnSelectCheckBox\"]",3);

        System.out.println(reasonsColumnInWaitingForData.getText());

       // Assert.assertEquals(reasonsColumnInWaitingForData.getText(), "Reason");


    }

   @Test(priority = 2)
    public void checkPending() throws Exception {

        goTo.goToExplorerPage();

        searchAndSubmit(portfolio); //submit the analysis before checking pending jobs

        Utility.isElementPresentAndClick(nPage.analysisNotificationIcon, 2);

        Utility.isElementPresentAndClick(nPage.pending, 2);


    }

   @Test(priority = 3)
    public void checkRunning() throws Exception {

        goTo.goToExplorerPage();

        searchAndSubmit(portfolio); //submit the analysis before checking running jobs

        Utility.isElementPresentAndClick(nPage.analysisNotificationIcon, 2);

        Utility.isElementPresentAndClick(nPage.running, 2);


    }

    @Test(priority = 4)
    public void checkCompleted() throws InterruptedException, IOException {

        goTo.goToDashboard();

        Thread.sleep(5000); //we need to wait for the notification to be loaded

        Utility.isElementPresentAndClick(nPage.analysisNotificationIcon, 2);

        //nPage.setCompleted();

        try {
            WebElement com = Driver.findElement(By.xpath("//*[@id=\"html\"]/body/div/div/div[4]"));
            com.click();
        } catch (Exception e) {
            System.out.println("Can't find and click on completed:" + e);
            Driver.findElement(By.xpath("//*[@id=\"html\"]/body/div/div/div[4]")).click();
        }


        Utility.isElementPresentAndClick(nPage.linkFromCompletedToRepotsPage, 3);

        WebElement verifyReportsPageNavigation_Overview = Utility.isElementPresent("//*[@id=\"ctl00_mainContentPlaceHolder_report_labBreadcrumb\"]",3);

        //Assert.assertEquals(verifyReportsPageNavigation_Overview.getText(), "OVERVIEW");


    }

    @Test(priority = 5)
    public void checkFailed() throws Exception {

        goTo.goToExplorerPage();

        searchAndSubmit(portfolio); //submit the analysis before checking failed jobs

        Utility.isElementPresentAndClick(nPage.analysisNotificationIcon, 4);

        Utility.isElementPresentAndClick(nPage.failed, 3);

        Utility.isElementPresentAndClick(nPage.linkFromFailedToAnalysisPage, 3);

        WebElement errorTypeColumnInAnalysis =  Utility.isElementPresent("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[15]/a",10);

        Utility.isElementPresent("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_ctl04_CheckboxSelectColumnSelectCheckBox\"]",5);

        System.out.println(errorTypeColumnInAnalysis.getText());

        //Assert.assertEquals(errorTypeColumnInAnalysis.getText(), "Error Type");

    }

    @Test(priority = 6)
    public void checkDownloadNotification() throws InterruptedException, IOException {

        goTo.goToDashboard();

        Thread.sleep(5000);

        Utility.isElementPresentAndClick(nPage.downloadNotificationIcon, 2);

        //Utility.isElementPresentAndClick(nPage.downloadReportFromList, 5);


    }

    @Test(priority = 7)
    public void cleanUpAnalysis() throws InterruptedException, IOException {


        GoTo.goToAnalysisPage();

        WebElement cur =  Utility.isElementPresent("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[17]/a",3);

        Utility.isElementPresent("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_ctl04_CheckboxSelectColumnSelectCheckBox\"]",3);

       // Assert.assertEquals(cur.getText(),"Currency");

       // AnalysisPageTest.deleteCompletedAnalysis(portfolio);

        AnalysisPageHelper.deleteCompletedAnalysisFromAnalysisPage(portfolio);
    }


    @AfterMethod
    public void tearDown(ITestResult result) {

       Utility.tearDown(result);

    }



}
