package com.styleanalytics.enterprise.Loader;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.util.List;

public class LoadPortfolioDetails extends TestBase {

    WebDriver driver;

    @BeforeClass
    public void accessLoadPage() throws IOException {

        GoTo goTo = new GoTo();
        goTo.goToLoadPage();
        driver = getDriver();

    }


    @Test
    public void loadPortfolioDetailsTest() throws IOException, InterruptedException {

        LoadPage LP = new LoadPage(getDriver());

        SoftAssert softAssert = new SoftAssert();

        LoadHelpers loadHelpers = new LoadHelpers();

        //loadHelpers.loadingFile("//span[contains(text(),'Load Portfolio Details')]", "ctl00_mainContentPlaceHolder_portfolioDetailsUploaderfile0", "D:\\Auto\\new.csv", "//*[@id=\"ctl00_mainContentPlaceHolder_portfolioDetailsHeaderSection_cmdNext_input\"]");
        loadHelpers.loadingFile("//span[contains(text(),'Load Portfolio Details')]", "ctl00_mainContentPlaceHolder_portfolioDetailsUploaderfile0", "C:\\Selenium\\Test Data\\new.csv", "//*[@id=\"ctl00_mainContentPlaceHolder_portfolioDetailsHeaderSection_cmdNext_input\"]");

        softAssert.assertEquals(LP.loadPortfolioDetailsFileName.getText(), "File Name");

        softAssert.assertEquals(LP.loadPortfolioDetailsDelimiter.getText(), "Delimiter");

        softAssert.assertEquals(LP.loadPortfolioDetailsStatus.getText(), "Status");

        softAssert.assertEquals(LP.loadPortfolioDetailsCSVBox.getAttribute("value"), "csv");

        WebDriverWait wait = new WebDriverWait(driver, 120);

        wait.until(ExpectedConditions.elementToBeClickable(LP.loadPortfolioDetailsNextButton2)).click();

        Utility.waitForPageToBeReady();

        softAssert.assertEquals(LP.loadPortfolioDetailsSavePortfolioDetails.getText(), "Step 3: Save Portfolio Details");

        softAssert.assertEquals(LP.loadPortfolioDetailsLoadImage.getAttribute("src"), "https://staginganalyzer.styleresearch.com/Images/Tick_32.png");

        softAssert.assertAll();

    }


    @Test
    public void loadAnalysisTask() throws InterruptedException {

        LoadPage LP = new LoadPage(getDriver());

        SoftAssert softAssert = new SoftAssert();

        LoadHelpers loadHelpers = new LoadHelpers();

        //loadHelpers.loadingFile("//span[contains(text(),'Load Analysis Tasks')]", "ctl00_mainContentPlaceHolder_portfolioAnalysisTasksUploaderfile0", "D:\\Auto\\analysisTask.csv", "//*[@id=\"ctl00_mainContentPlaceHolder_portfolioAnalysisTasksHeaderSection_cmdNext_input\"]");
        loadHelpers.loadingFile("//span[contains(text(),'Load Analysis Tasks')]", "ctl00_mainContentPlaceHolder_portfolioAnalysisTasksUploaderfile0", "C:\\Selenium\\Test Data\\analysisTask.csv", "//*[@id=\"ctl00_mainContentPlaceHolder_portfolioAnalysisTasksHeaderSection_cmdNext_input\"]");

        Utility.waitForElementToDisplay(LP.loadPortfolioDetailsFileName, 20);

        softAssert.assertEquals(LP.loadPortfolioDetailsFileName.getText(), "File Name");

        softAssert.assertEquals(LP.loadPortfolioDetailsDelimiter.getText(), "Delimiter");

        softAssert.assertEquals(LP.loadPortfolioDetailsStatus.getText(), "Status");

        LP.loadAnalysisTaskDelimiterSelectBox.click();

        List<WebElement> links = driver.findElements(By.tagName("li"));

        Thread.sleep(2000);

        links.get(1).click();

        WebDriverWait wait = new WebDriverWait(driver, 120);

        wait.until(ExpectedConditions.elementToBeClickable(LP.loadAnalysisTaskNextButton2)).click();

        Thread.sleep(3000);

        softAssert.assertEquals(LP.loadAnalysisTaskStep3.getText(), "Step 3: Save Analysis Tasks");

        softAssert.assertEquals(LP.loadAnalysisTaskSuccessImage.getAttribute("src"), "https://staginganalyzer.styleresearch.com/Images/Tick_32.png");

        softAssert.assertAll();


    }

    @Test
    public void loadShares() throws InterruptedException {

        LoadPage LP = new LoadPage(getDriver());

        SoftAssert softAssert = new SoftAssert();

        LoadHelpers loadHelpers = new LoadHelpers();

       // loadHelpers.loadingFile("//span[contains(text(),'Load Shares')]", "ctl00_mainContentPlaceHolder_portfolioSharesUploaderfile0", "D:\\Auto\\analysisTask.csv", "//input[@id='ctl00_mainContentPlaceHolder_portfolioSharesHeaderSection_cmdNext_input']");
        loadHelpers.loadingFile("//span[contains(text(),'Load Shares')]", "ctl00_mainContentPlaceHolder_portfolioSharesUploaderfile0", "C:\\Selenium\\Test Data\\analysisTask.csv", "//input[@id='ctl00_mainContentPlaceHolder_portfolioSharesHeaderSection_cmdNext_input']");

        Utility.waitForElementToDisplay(LP.loadPortfolioDetailsFileName, 20);

        softAssert.assertEquals(LP.loadPortfolioDetailsFileName.getText(), "File Name");

        softAssert.assertEquals(LP.loadPortfolioDetailsDelimiter.getText(), "Delimiter");

        softAssert.assertEquals(LP.loadPortfolioDetailsStatus.getText(), "Status");

        Utility.waitForElementToDisplay(LP.loadSharesDelimiterSelectBox, 20);

        LP.loadSharesDelimiterSelectBox.click();

        List<WebElement> links = driver.findElements(By.tagName("li"));

        Thread.sleep(2000);

        links.get(1).click();

        WebDriverWait wait = new WebDriverWait(driver, 120);

        wait.until(ExpectedConditions.elementToBeClickable(LP.loadSharesNextButton2)).click();

        Thread.sleep(3000);

        Utility.waitForPageToBeReady();

        softAssert.assertEquals(LP.loadSharesStep3.getText(), "Step 3: Save Shares");

        softAssert.assertEquals(LP.loadSharesSuccessImage.getAttribute("src"), "https://staginganalyzer.styleresearch.com/Images/Tick_32.png");

        softAssert.assertAll();

    }


    @Test
    public void loadLabels() throws InterruptedException {

        LoadPage LP = new LoadPage(getDriver());

        SoftAssert softAssert = new SoftAssert();

        LoadHelpers loadHelpers = new LoadHelpers();

        loadHelpers.loadingFile("//span[contains(text(),'Load Labels')]", "ctl00_mainContentPlaceHolder_portfolioLabelsUploaderfile0", "D:\\Auto\\analysisTask.csv", "//input[@id='ctl00_mainContentPlaceHolder_portfolioLabelsHeaderSection_cmdNext_input']");

        Utility.waitForElementToDisplay(LP.loadPortfolioDetailsFileName, 20);

        softAssert.assertEquals(LP.loadPortfolioDetailsFileName.getText(), "File Name");

        softAssert.assertEquals(LP.loadPortfolioDetailsDelimiter.getText(), "Delimiter");

        softAssert.assertEquals(LP.loadPortfolioDetailsStatus.getText(), "Status");

        Utility.waitForElementToDisplay(LP.loadLabelDelimiterSelectBox, 20);

        LP.loadLabelDelimiterSelectBox.click();

        List<WebElement> links = driver.findElements(By.tagName("li"));

        Thread.sleep(2000);

        links.get(1).click();

        WebDriverWait wait = new WebDriverWait(driver, 120);

        wait.until(ExpectedConditions.elementToBeClickable(LP.loadLabelsNextButton2)).click();

        Thread.sleep(3000);

        Utility.waitForPageToBeReady();

        softAssert.assertEquals(LP.loadLabelsStep3.getText(), "Step 3: Save Labels");

        softAssert.assertEquals(LP.loadLabelsSuccessImage.getAttribute("src"), "https://staginganalyzer.styleresearch.com/Images/Tick_32.png");

        softAssert.assertAll();


    }


    @Test
    public void loadFundSize() throws InterruptedException {

        LoadPage LP = new LoadPage(getDriver());

        SoftAssert softAssert = new SoftAssert();

        LoadHelpers loadHelpers = new LoadHelpers();

        loadHelpers.loadingFile("//span[contains(text(),'Load Fund Size')]", "ctl00_mainContentPlaceHolder_fundSizeFileUploaderfile0", "D:\\Auto\\analysisTask.csv", "//input[@id='ctl00_mainContentPlaceHolder_fundSizeHeaderSection_cmdNext_input']");

        Utility.waitForElementToDisplay(LP.loadPortfolioDetailsFileName, 20);

        softAssert.assertEquals(LP.loadPortfolioDetailsFileName.getText(), "File Name");

        softAssert.assertEquals(LP.loadPortfolioDetailsDelimiter.getText(), "Delimiter");

        softAssert.assertEquals(LP.loadPortfolioDetailsStatus.getText(), "Status");

        Utility.waitForElementToDisplay(LP.loadFundSizeDelimiterSelectBox, 20);

        LP.loadFundSizeDelimiterSelectBox.click();

        List<WebElement> links = driver.findElements(By.tagName("li"));

        Thread.sleep(2000);

        links.get(1).click();

        WebDriverWait wait = new WebDriverWait(driver, 120);

        wait.until(ExpectedConditions.elementToBeClickable(LP.loadFundSizeNextButton2)).click();

        Utility.waitForPageToBeReady();

        softAssert.assertEquals(LP.loadFundSizeStep3.getText(), "Step 3: Save Portfolio Returns");

        softAssert.assertEquals(LP.loadFundSizeSuccessImage.getAttribute("src"), "https://staginganalyzer.styleresearch.com/Images/Tick_32.png");

        softAssert.assertAll();


    }


    @Test
    public void loadDataAudit() throws InterruptedException {

        LoadPage LP = new LoadPage(getDriver());

        SoftAssert softAssert = new SoftAssert();

        LoadHelpers loadHelpers = new LoadHelpers();

        loadHelpers.loadingFile("//span[contains(text(),'Load Data Audit')]", "ctl00_mainContentPlaceHolder_snapshotEmbargoFileUploaderfile0", "D:\\Auto\\analysisTask.csv", "//input[@id='ctl00_mainContentPlaceHolder_snapshotEmbargoHeaderSection_cmdNext_input']");

        Utility.waitForElementToDisplay(LP.loadPortfolioDetailsFileName, 20);

        softAssert.assertEquals(LP.loadPortfolioDetailsFileName.getText(), "File Name");

        softAssert.assertEquals(LP.loadPortfolioDetailsDelimiter.getText(), "Delimiter");

        softAssert.assertEquals(LP.loadPortfolioDetailsStatus.getText(), "Status");

        Utility.waitForElementToDisplay(LP.loadDataAuditDelimiterSelectBox, 20);

        LP.loadDataAuditDelimiterSelectBox.click();

        List<WebElement> links = driver.findElements(By.tagName("li"));

        Thread.sleep(2000);

        links.get(1).click();

        WebDriverWait wait = new WebDriverWait(driver, 200);

        wait.until(ExpectedConditions.elementToBeClickable(LP.loadDataAuditNextButton2)).click();

        Thread.sleep(3000);

        Utility.waitForPageToBeReady();

        softAssert.assertEquals(LP.loadDataAuditStep3.getText(), "Step 3: Save Data Audit");

        softAssert.assertEquals(LP.loadDataAuditSuccessImage.getAttribute("src"), "https://staginganalyzer.styleresearch.com/Images/Tick_32.png");

        softAssert.assertAll();
    }


    @Test

    public void loadReturns() throws InterruptedException {

        LoadPage LP = new LoadPage(getDriver());

        SoftAssert softAssert = new SoftAssert();

        LoadHelpers loadHelpers = new LoadHelpers();

        loadHelpers.loadingFile("//span[contains(text(),'Load Returns')]", "ctl00_mainContentPlaceHolder_portfolioReturnFileUploaderfile0", "D:\\Auto\\analysisTask.csv", "//input[@id='ctl00_mainContentPlaceHolder_portfolioReturnsHeaderSection_cmdNext_input']");

        Utility.waitForElementToDisplay(LP.loadPortfolioDetailsFileName, 120);

        softAssert.assertEquals(LP.loadPortfolioDetailsFileName.getText(), "File Name");

        softAssert.assertEquals(LP.loadPortfolioDetailsDelimiter.getText(), "Delimiter");

        softAssert.assertEquals(LP.loadPortfolioDetailsStatus.getText(), "Status");

        Utility.waitForElementToDisplay(LP.loadReturnsDelimiterSelectBox, 20);

        LP.loadReturnsDelimiterSelectBox.click();

        List<WebElement> links = driver.findElements(By.tagName("li"));

        Thread.sleep(2000);

        links.get(1).click();

        WebDriverWait wait = new WebDriverWait(driver, 200);

        wait.until(ExpectedConditions.elementToBeClickable(LP.loadReturnsNextButton2)).click();

        Thread.sleep(3000);

        Utility.waitForPageToBeReady();

        softAssert.assertEquals(LP.loadReturnsStep3.getText(), "Step 3: Save Portfolio Returns");

        softAssert.assertEquals(LP.loadReturnsSuccessImage.getAttribute("src"), "https://staginganalyzer.styleresearch.com/Images/Tick_32.png");

        softAssert.assertAll();


    }

     @Test
     public void portfolioBuilderCreateExisting() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        LoadPage LP = new LoadPage(getDriver());

        LP.portfolioBuilderTopNavigationButton.click();

        Utility.waitForElementToDisplay(LP.portfolioBuilderCreatePortfolioInputBox, 20);

        LP.portfolioBuilderCreateExistingChoosePortfolioDropDown.sendKeys(" LoadPortfolioBuilder");

        Utility.waitForElementToDisplay(LP.portfolioBuilderSelection, 20);

        LP.portfolioBuilderSelection.click();

        LP.portfolioBuilderClickToAddSecuritiesLink.click();

         Utility.waitForElementToDisplay(LP.portfolioBuilderSecritySearchInputBox, 20);

        LP.portfolioBuilderSecritySearchInputBox.sendKeys("APPLE FINANCE LIMITED");

         Utility.waitForElementToDisplay(LP.portfolioBuilderWaitforSecurity, 20);

         LP.portfolioBuilderWaitforSecurity.click();

         softAssert.assertEquals(LP. portfolioBuilderVerifyPortfolioName.getText(), "LoadPortfolioBuilder");

         softAssert.assertTrue(LP.portfolioBuilderNextStep.isDisplayed());

         LP.portfolioBuilderWeightInputBox.sendKeys("5");

         LP.portfolioBuilderNextStep.click();

         softAssert.assertTrue( LP.portfolioBuilderNextButtonLastStep.isDisplayed());

         softAssert.assertAll();

     }


      @Test
      public void portfolioBuilderCreateNew() throws InterruptedException {

          SoftAssert softAssert = new SoftAssert();

          LoadPage LP = new LoadPage(getDriver());

          LP.portfolioBuilderTopNavigationButton.click();

          Utility.waitForElementToDisplay(LP.portfolioBuilderCreatePortfolioInputBox, 20);

          LP.portfolioBuilderCreatePortfolioInputBox.sendKeys(" LoadPortfolioBuilderTest");

          LP.portfolioBuilderCreatePortfolioAddButton.click();

          LP.portfolioBuilderCreatePortfolioClickToAddSecuritiesLink.click();

          Utility.waitForElementToDisplay(LP.portfolioBuilderCreatePortfolioClickToAddSecuritiesInputBox, 20);

          LP.portfolioBuilderCreatePortfolioClickToAddSecuritiesInputBox.sendKeys("APPLE FINANCE LIMITED");

          Utility.waitForElementToDisplay(LP.portfolioBuilderWaitforSecurity, 20);

          LP.portfolioBuilderWaitforSecurity.click();

          softAssert.assertEquals(LP. portfolioBuilderVerifyPortfolioName2.getText(), "LoadPortfolioBuilderTest");

          softAssert.assertTrue(LP.portfolioBuilderNextStep.isDisplayed());

          LP.portfolioBuilderWeightInputBox.sendKeys("5");

          LP.portfolioBuilderNextStep.click();

          softAssert.assertTrue( LP.portfolioBuilderNextButtonLastStep.isDisplayed());

          softAssert.assertAll();

      }


}
