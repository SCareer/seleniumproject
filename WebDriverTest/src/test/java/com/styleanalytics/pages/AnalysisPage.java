package com.styleanalytics.pages;

import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.enterprise.utils.DataTables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;

public class AnalysisPage {

    WebDriver driver;
    DataTables dataTables;

    @FindBy(id = "ctl00_topNav2_labBreadcrumb")
    WebElement pageTitle;

    @FindBy(id = "scWaiting")
    WebElement waitingForData;

    @FindBy(id = "scPending")
    WebElement pending;

    @FindBy(id = "scRunning")
    WebElement running;

    @FindBy(id = "scComplete")
    WebElement complete;

    @FindBy(id = "scFailed")
    WebElement failed;

    @FindBy(xpath = "//a[contains(@id,'scWaiting')]//span[contains(@class,'count')]")
    WebElement waitingForDataCount;

    @FindBy(xpath = "//a[contains(@id,'scPending')]//span[contains(@class,'count')]")
    WebElement pendingCount;

    @FindBy(xpath = "//a[contains(@id,'scRunning')]//span[contains(@class,'count')]")
    WebElement runningCount;

    @FindBy(xpath = "//a[contains(@id,'scComplete')]//span[contains(@class,'count')]")
    WebElement completedCount;

    @FindBy(xpath = "//a[contains(@id,'scFailed')]//span[contains(@class,'count')]")
    WebElement failedCount;


    @FindBy(xpath = "//span[@class='rtbText'][contains(text(),'Analysis')]")
    WebElement analysisDropDown;

    @FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[1]/div/ul/li[1]/a/span")
    WebElement action_View;

    @FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[1]/div/ul/li[2]/a/span")
    WebElement action_Delete;

    @FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[1]/div/ul/li[3]/a/span")
    WebElement action_ViewReport;

    @FindBy(xpath = "//span[@class='ag-checkbox-indeterminate']//span[@class='ag-icon ag-icon-checkbox-indeterminate']")
    WebElement selectAllCheckBox;

    @FindBy(xpath = "//span[contains(text(),'Status')]")
    WebElement status;

    @FindBy(xpath = "//div[@class='ag-header-cell']//div//a[@class='sgButtonGreen Embargo'][contains(text(),'Embargo')]")
    WebElement embargo;

    @FindBy(xpath = "//span[contains(text(),'Audit')]")
    WebElement audit;

    @FindBy(xpath = "//span[contains(text(),'Matched')]")
    WebElement matched;

    @FindBy(xpath = "//span[contains(text(),'Turnover')]")
    WebElement trunover;

    @FindBy(xpath = "//span[contains(text(),'Analysis Date')]")
    WebElement analysisDate;

    @FindBy(xpath = "//span[contains(text(),'Run At')]")
    WebElement runAt;

    @FindBy(xpath = "//span[contains(text(),'Report Profile')]")
    WebElement reportProfile;

    @FindBy(xpath = "//span[@class='ag-header-cell-text'][contains(text(),'Portfolio')]")
    WebElement analyzedPortfolio;

    @FindBy(xpath = "//span[contains(text(),'Benchmark')]")
    WebElement benchmark;

    @FindBy(xpath = "//span[contains(text(),'Universe')]")
    WebElement universe;

    @FindBy(xpath = "//span[contains(text(),'Exchange Calendar')]")
    WebElement exchangeCalender;

    @FindBy(xpath = "//span[contains(text(),'Submitted By')]")
    WebElement submittedBy;

    public void setWaitingForData() {
        waitingForData.click();
        Wait.untilJqueryIsDone(driver);
    }

    public void setPending() {
        pending.click();
        Wait.untilJqueryIsDone(driver);
    }

    public void setRunning() {
        running.click();
        Wait.untilJqueryIsDone(driver);
    }

    public void setComplete() {
        complete.click();
        Wait.untilJqueryIsDone(driver);
    }

    public void setFailed() {
        failed.click();
        Wait.untilJqueryIsDone(driver);
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public void deleteAllAnalysis() {

        setSelectAllCheckBox();
        setAnalysisDropDown();
        setAction_Delete();
        }

    public void setAnalysisDropDown() {

        analysisDropDown.click();

    }

    public void setAction_View() {

        action_View.click();

    }

    public void setAction_Delete() {

        action_Delete.click();

    }

    public void setAction_ViewReport() {

        action_ViewReport.click();

    }

    public void setSelectAllCheckBox() {

        selectAllCheckBox.click();

    }

    public int getWaitingForDataCount() throws ParseException {

        dataTables = new DataTables();
        String countWithoutBrackets = rePlaceBrackets(waitingForDataCount.getText());
        int count = dataTables.getFormattedNumber(countWithoutBrackets);
        return count;

    }

    public int getPendingCount() throws ParseException {

        dataTables = new DataTables();
        String countWithoutBrackets = rePlaceBrackets(pendingCount.getText());
        int count = dataTables.getFormattedNumber(countWithoutBrackets);
        return count;
    }

    public int getRunningCount() throws ParseException {

        dataTables = new DataTables();
        String countWithoutBrackets = rePlaceBrackets(runningCount.getText());
        int count = dataTables.getFormattedNumber(countWithoutBrackets);
        return count;
    }

    public int getCompletedCount() throws ParseException {

        dataTables = new DataTables();
        String countWithoutBrackets = rePlaceBrackets(completedCount.getText());
        int count = dataTables.getFormattedNumber(countWithoutBrackets);
        return count;
    }

    public int getFailedCount() throws ParseException {

        dataTables = new DataTables();
        String countWithoutBrackets = rePlaceBrackets(failedCount.getText());
        int count = dataTables.getFormattedNumber(countWithoutBrackets);
        return count;
    }

    public String rePlaceBrackets(String textWithBracket){

        String countWithoutBrackets = textWithBracket.replaceAll("\\(","").replaceAll("\\)","");
        return countWithoutBrackets;
    }

    public WebElement getWaitingForData() { return waitingForData; }

    public WebElement getPending() {
        return pending;
    }

    public WebElement getRunning() {
        return running;
    }

    public WebElement getComplete() {
        return complete;
    }

    public WebElement getFailed() {
        return failed;
    }

    public WebElement getStatus() {
        return status;
    }

    public WebElement getEmbargo() {
        return embargo;
    }

    public WebElement getAudit() {
        return audit;
    }

    public WebElement getMatched() {
        return matched;
    }

    public WebElement getTrunover() {
        return trunover;
    }

    public WebElement getAnalysisDate() {
        return analysisDate;
    }

    public WebElement getRunAt() {
        return runAt;
    }

    public WebElement getReportProfile() {
        return reportProfile;
    }

    public WebElement getAnalyzedPortfolio() {
        return analyzedPortfolio;
    }

    public WebElement getBenchmark() {
        return benchmark;
    }

    public WebElement getUniverse() {
        return universe;
    }

    public WebElement getExchangeCalender() {
        return exchangeCalender;
    }

    public WebElement getSubmittedBy() {
        return submittedBy;
    }

    public AnalysisPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }

}
