package com.styleanalytics.enterprise.ExecutiveReports;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.util.List;


public class ChangesTemplate extends TestBase {

    private ExecReportHelpers EH;

    private ExecutiveReportsPage executiveReportsPage ;

    WebDriver driver;


    @BeforeClass
    public void openExecutiveReports() throws InterruptedException, IOException {


        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();

        driver = getDriver();
        EH = new ExecReportHelpers(getDriver());
        executiveReportsPage = new ExecutiveReportsPage(getDriver());

         Thread.sleep(3000);

        // Utility.isElementPresentAndDisplayed("//span[contains(text(),'Dashboard')]",10);

        driver.findElement(By.xpath("//div[@class='reportTile execReportTile ui-sortable-handle']//div[@class='tileName'][contains(text(),'Changes Report')]")).click();


    }


    @Test(priority = 1)
    public void portfolioChanges() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        Wait.waitForElementToDisappear(driver,60,executiveReportsPage.loading_Squares);

        softAssert.assertTrue(executiveReportsPage.changesTemplatePortfolioChangesTitel.getText().contains("PORTFOLIO CHANGES"));

        softAssert.assertTrue(executiveReportsPage.changesTemplatePortfolioChangesGrid.isDisplayed());

        softAssert.assertTrue(changesTemplatePortfolioChangesDrillDown());

        softAssert.assertAll();

    }



    public Boolean changesTemplatePortfolioChangesDrillDown() {


        SoftAssert softAssert = new SoftAssert();


        List<WebElement> x = driver.findElements(By.className("slick-cell"));

        x.get(100).click();

        //Wait.waitForElementToDisplayByclassName("rwCloseButton", 100);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.changesTemplatePortfolioChangesPopUp.isDisplayed());

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

        softAssert.assertAll();

        return true;

    }


    @Test(priority = 2)
    public void styleExposureChanges() {

        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.changesTemplatePage2.click();

        Wait.waitForElementToDisappear(driver,60,executiveReportsPage.loading_Squares);

        softAssert.assertTrue(executiveReportsPage.changesTemplateStyleExposureChangesTitle.getText().contains("STYLE EXPOSURE CHANGES"));

        softAssert.assertTrue(executiveReportsPage.changesTemplateStyleExposureChangesGrid.isDisplayed());

        softAssert.assertAll();


    }


    @Test(priority = 3)
    public void sizeDistribution() {

        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.changesTemplatePage3.click();

        Wait.waitForElementToDisappear(driver,60,executiveReportsPage.loading_Squares);

        softAssert.assertTrue(executiveReportsPage.changesTemplateSizeDistributionTitle.getText().contains("SIZE DISTRIBUTION"));

        softAssert.assertTrue(executiveReportsPage.changesTemplateSizeDistributionGrid.isDisplayed());

        softAssert.assertAll();

    }


    @Test(priority = 4)
    public void styleDistribution() {

        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.changesTemplatePage4.click();

        Wait.waitForElementToDisappear(driver,60,executiveReportsPage.loading_Squares);

        softAssert.assertTrue(executiveReportsPage.changesTemplateStyleDistributionTitle.getText().contains("STYLE DISTRIBUTION"));

        softAssert.assertTrue(executiveReportsPage.changesTemplateStyleDistributionGrid.isDisplayed());

        softAssert.assertAll();

    }


    @Test(priority = 5)
    public void sectorChanges() {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.changesTemplatePage5.click();

        Wait.waitForElementToDisappear(driver,60,executiveReportsPage.loading_Squares);

        softAssert.assertTrue(executiveReportsPage.changesTemplateSectorChangeTitle.getText().contains("SECTOR CHANGES"));

        softAssert.assertTrue(executiveReportsPage.changesTemplateSectorChangeGrid.isDisplayed());

        softAssert.assertAll();

    }


    @Test(priority = 6)
    public void countryChangesTitle() {

        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.changesTemplatePage6.click();

        Wait.waitForElementToDisappear(driver,60,executiveReportsPage.loading_Squares);

        softAssert.assertTrue(executiveReportsPage.changesTemplateCountryChangeTitle.getText().contains("COUNTRY CHANGES"));

        softAssert.assertTrue(executiveReportsPage.changesTemplateCountryChangeGrid.isDisplayed());

        softAssert.assertAll();
    }
    @AfterMethod
    public void teardown(ITestResult reuslt){

        Utility.tearDown(reuslt);
    }


}








