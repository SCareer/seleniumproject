package com.styleanalytics.enterprise.Notification;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Viswanath on 02/06/2017.
 */
public class NotificationPage extends EnterpriseBaseClass {

    //WebDriverWait wait = new WebDriverWait(Driver,10);

    @FindBy(xpath = "//*[@id='iconAlerts']")
    WebElement analysisNotificationIcon;

    @FindBy(css = ".alertsPane.whiteGrid.topNavPopDown>h3")
    WebElement analysisNotificationTitle;

    @FindBy(css = ".alertsRow.analysisWaiting")
    WebElement waitingForData;

    @FindBy(xpath = "//*[@id='topNavAnalysisTasksGrid']/div[4]/div[3]/div/div[1]/div[1]/a")
    WebElement navigateToAnalysisPage_waitingForData;


    @FindBy(css = ".alertsRow.analysisPending")
    WebElement pending;

    @FindBy(css = ".alertsRow.analysisRunning")
    WebElement running;

    @FindBy(className ="alertsRow analysisComplete")
    WebElement completed;

    @FindBy(css = ".alertsRow.analysisFailed")
    WebElement failed;

    @FindBy(xpath = "//*[@id='topNavAnalysisTasksGrid']/div[4]/div[3]/div/div[1]/div[1]/a")
    WebElement linkFromWaitingForDataToAnalysisPage;

    @FindBy(xpath = "//*[@id='topNavAnalysisTasksGrid']/div[4]/div[3]/div/div[1]/div[1]/a")
    WebElement linkFromCompletedToRepotsPage;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_report_labBreadcrumb']")
    WebElement verifyReportsPageNavigation_Overview;

    @FindBy(xpath = "//*[@id='topNavAnalysisTasksGrid']/div[4]/div[3]/div/div[1]/div[1]/a")
    WebElement linkFromFailedToAnalysisPage;


    @FindBy(css = "#iconDownloads")
    WebElement downloadNotificationIcon;

    @FindBy(xpath = "//*[@id='topNavDownloadsList']/div[4]/div[3]/div/div[1]/div[1]/a")
    WebElement downloadReportFromList;


    public void setAnalysisNotificationIcon(){

       // wait.until(ExpectedConditions.visibilityOf(analysisNotificationIcon));
        analysisNotificationIcon.click();
    }

    public void setWaitingForData(){

        waitingForData.click();
    }

    public void setPending(){

        pending.click();
    }

    public void setRunning(){

        running.click();
    }

    public void setCompleted(){

        completed.click();
    }

    public void setFailed(){

        failed.click();
    }

    public NotificationPage(){

        initElements(Driver, this);
    }
}
