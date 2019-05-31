package com.styleanalytics.pages;

import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.List;

public class AnalysisTaskPage {

    WebDriver driver;

    /***
     *Items in the Tasks Tab
     */

    @FindBy(xpath = "//span[contains(text(),'Automated Task')]")
    WebElement automatedTaskDropDown;

    @FindBy(xpath = "//span[contains(text(),'Manage CalcSets')]")
    WebElement manageCalcSetButton;

    @FindBy(xpath = "//span[contains(text(),'New...')]")
    WebElement newAutomatedTask;

    @FindBy(xpath = "//span[contains(text(),'Edit')]")
    WebElement editAutomatedTask;

    @FindBy(xpath = "//span[contains(text(),'Run Selected Task')]")
    WebElement runAutomatedTask;

    @FindBy(xpath = "//span[contains(text(),'Delete Selected Task')]")
    WebElement deleteAutomatedTask;

    @FindBy(xpath = "//span[contains(text(),'Batch Update...')]")
    WebElement batchUpdateAutomatedTask;

    /***
     *
     *Inside the popup
     */

    @FindBy(xpath = "//div[contains(@id,'ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radTabStripAutomatedAnalysisTask')]//span[contains(text(),'General')]")
    WebElement general;
    @FindBy(xpath = "//div[contains(@id,'ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radTabStripAutomatedAnalysisTask')]//span[contains(text(),'Sharing')]")
    WebElement sharing;
    @FindBy(xpath = "//div[contains(@id,'ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radTabStripAutomatedAnalysisTask')]//span[contains(text(),'Advanced')]")
    WebElement advanced;
    @FindBy(xpath = "//div[contains(@id,'ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radTabStripAutomatedAnalysisTask')]//span[contains(text(),'Export')]")
    WebElement export;

    @FindBy(id = "ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboBenchmark_radComboBoxPortfolioQuickSearch_Input")
    WebElement benchmark;
    @FindBy(id = "ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboUniverse_radComboBoxPortfolioQuickSearch_Input")
    WebElement universe;
    @FindBy(id = "ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboCurrency_Input")
    WebElement currency;

    @FindBy(id = "ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboSectorClassificationType_Input")
    WebElement classification;
    @FindBy(id = "ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboCalcSet_radComboCalcSet_Input")
    WebElement calcset;
    @FindBy(id = "ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_ddlReportProfile_ddlReportProfile_Input")
    WebElement reportProfile;

    @FindBy(id = "ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_txtTaskName")
    WebElement taskName;

    @FindBy(id = "ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_btnSave_input")
    WebElement save_btn;

    @FindBy(id = "ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_btnClose_input")
    WebElement close_btn;

    @FindAll(@FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboCurrency_DropDown\"]/div[2]/ul/li"))
    List<WebElement> currencyList;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboCalcSet_radComboCalcSet_DropDown\"]/div[2]/ul/li")
    List<WebElement> calcsetList;

    @FindBy(xpath = "//span[contains(@class,'rwInnerSpan')][contains(text(),'Close')]")
    WebElement close_btn_alertPopup;

    @FindBy(id = "ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisScheduled_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_ctl02_ctl01_CheckboxSelectColumnSelectCheckBox")
    WebElement selectAllTask;

    @FindBy(xpath = "//*[@id='aspnetForm']/div[1]/div/ul/li[4]/a/span")
    WebElement deleteSelected;

    @FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[1]/div/ul/li[3]")
    WebElement runSelectedTask;

    /**
     * Dispatch popup
     */
    @FindBy(id = "ctl00_mainContentPlaceHolder_scheduledTaskRunWindow_C_scheduledTaskRun1_rbTimePointsLatest")
    WebElement mostRecentSnapshot;

    @FindBy(id = "ctl00_mainContentPlaceHolder_scheduledTaskRunWindow_C_scheduledTaskRun1_rbTimePointsFirst")
    WebElement earlyToLatestSnapshots;

    @FindBy(id = "ctl00_mainContentPlaceHolder_scheduledTaskRunWindow_C_scheduledTaskRun1_rbTimePointsEarliestToLatest")
    WebElement allAvailableSnapshots;

    @FindBy(id = "ctl00_mainContentPlaceHolder_scheduledTaskRunWindow_C_scheduledTaskRun1_radioNoAutoGenerate")
    WebElement autoGenerateSkip;

    @FindBy(id = "ctl00_mainContentPlaceHolder_scheduledTaskRunWindow_C_scheduledTaskRun1_radioForce")
    WebElement alwaysReRun;

    @FindBy(id = "ctl00_mainContentPlaceHolder_scheduledTaskRunWindow_C_scheduledTaskRun1_btnRun")
    WebElement runAnalysis_btn;

    @FindBy(css = ".rwInnerSpan")
    WebElement okButtonOnAnalysisDispatchPopup ;

    /*****
     * Sync
     */
    @FindBy(id = "ctl00_mainContentPlaceHolder_report_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_LoadingDiv")
    WebElement searchingForPortfolios;

    @FindBy(xpath = "//*[@id='quickSearchItem']/span[2]")
    WebElement firstSearchResult;


    public void setAutomatedTaskDropDown() {

        automatedTaskDropDown.click();
    }

    public void setNewAutomatedTask() {

        Wait.waitForElementToDisplay(driver,newAutomatedTask,5);
        newAutomatedTask.click();
        driver.switchTo().defaultContent();
        Wait.waitForElementToDisplay(driver,benchmark,60);
    }


    public void setBenchmark(String benchmarkNAme) throws InterruptedException {
        benchmark.click();
        benchmark.sendKeys(benchmarkNAme);
        Thread.sleep(10000);
        Wait.waitForElementToDisappear(driver,60,searchingForPortfolios);
        Wait.waitForTextToBeVisible(driver,60,firstSearchResult,benchmarkNAme);
        firstSearchResult.click();
        Thread.sleep(2000);
    }

    public void setUniverse(String universeName) throws InterruptedException {
        universe.click();
        universe.sendKeys(universeName);
        Thread.sleep(10000);
        Wait.waitForElementToDisappear(driver,60,searchingForPortfolios);
        Wait.waitForTextToBeVisible(driver,60,firstSearchResult,universeName);
        firstSearchResult.click();
        Thread.sleep(2000);
    }

    public void setCurrency(String currencyName) {

        currency.click();

        for(int i=0;i<currencyList.size();i++){

            if(currencyList.get(i).getText().contains(currencyName)){
                Wait.moveToElement(currencyList.get(i),driver);
                currencyList.get(i).click();
                break;

            }
        }

    }

    public void setClassification(String  classificationName) {

        classification.sendKeys(classificationName);
    }

    public void setCalcset(String calcsetName) throws InterruptedException {
        Thread.sleep(3000);
        calcset.click();
        for(int i=0;i<calcsetList.size();i++){

            if(calcsetList.get(i).getText().contains(calcsetName)){
                Wait.moveToElement(calcsetList.get(i),driver);
                calcsetList.get(i).click();
                break;

            }
        }

    }

    public void setRunSelectedTask() throws InterruptedException {

        Thread.sleep(5000);
        runSelectedTask.click();
        driver.switchTo().defaultContent();
        Wait.waitForElementToDisplay(driver,runAnalysis_btn,60);

    }

    public void setTaskName(String task_Name) {

        taskName.sendKeys(task_Name);
    }

    public void setSave_btn() {

        save_btn.click();

    }

    public void setSelectAllTask() throws InterruptedException {
        Thread.sleep(5000);
        selectAllTask.click();
    }

    public void setDeleteSelected() throws InterruptedException {

       Wait.waitForElementToDisplay(driver,deleteSelected,10);
        deleteSelected.click();

    }

    public void setCloseConfirmationPopup() throws InterruptedException {

        try {
            Wait.waitForElementToDisplay(driver, close_btn_alertPopup, 10);
            close_btn_alertPopup.click();
        }catch (Exception e) {
            Thread.sleep(5000);
            okButtonOnAnalysisDispatchPopup.click();
            //String dynamicID = driver.findElement(By.xpath("//iframe[contains(@name,'alert')]")).getAttribute("name");
           // driver.findElement(By.xpath("//*[@id='" + dynamicID + "_content']/div/div[2]/a/span/span")).click();
        }

    }

    public void createAutomatedTask(String benchmark, String universe, String Currency,String classification,
                                    String calcset, String taskname) throws Exception {
        try {
            setAutomatedTaskDropDown();
            setNewAutomatedTask();
            setBenchmark(benchmark);
            setUniverse(universe);
            setCurrency(Currency);
            setClassification(classification);
            setCalcset(calcset);
            setTaskName(taskname);
            setSave_btn();
            setCloseConfirmationPopup();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Failed to Create Task");
        }

    }

    public void deleteAutomatedTask() throws Exception {

        try {
            //setSelectAllTask();
            setAutomatedTaskDropDown();
            setDeleteSelected();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            driver.navigate().refresh();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Failed to delete task");
        }

    }

    public void runAutomatedTask() throws Exception {
        try {
            //setSelectAllTask();
            setAutomatedTaskDropDown();
            setRunSelectedTask();
            allAvailableSnapshots.click();
            autoGenerateSkip.click();
            alwaysReRun.click();
            runAnalysis_btn.click();
            setCloseConfirmationPopup();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Failed to run task");

        }


    }

    public AnalysisTaskPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }
}
