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

public class ReturnTemplate extends TestBase {


    private ExecutiveReportsPage executiveReportsPage;
    private ExecReportHelpers EH;
    WebDriver driver;


    @BeforeClass
    public void openExecutiveReports() throws IOException, InterruptedException {


        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
        driver =getDriver();
        executiveReportsPage = new ExecutiveReportsPage(getDriver());
        EH = new ExecReportHelpers(getDriver());
       // Utility.isElementPresentAndDisplayed("//span[contains(text(),'Dashboard')]",10);
        //driver.findElement(By.xpath("//span[contains(text(),'Returns Report')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@class='reportTile execReportTile ui-sortable-handle']//div[@class='tileName'][contains(text(),'Returns Report')]")).click();



    }

    @Test(priority = 1)
    public void page1() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        Wait.forGridToLoad(driver,60);

        softAssert.assertEquals(executiveReportsPage.returnsTemplatePerformenceReturnsTitel.getText(), "ABSOLUTE PERFORMANCE RETURN HEATMAP (UK POUNDS)");

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceReportGrid.isDisplayed());

        softAssert.assertTrue(performanceReturnsHeatMapDrillDown());

        softAssert.assertAll();
    }


    public Boolean performanceReturnsHeatMapDrillDown() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        List<WebElement> x = driver.findElements(By.className("slick-cell "));

        x.get(100).click();

        Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        driver.switchTo().frame(0);

        Wait.waitForElementToDisplay(driver,executiveReportsPage.returnsTemplatePerformenceReportPopUP, 20);

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceReportPopUP.isDisplayed());

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

        Thread.sleep(3000);

        softAssert.assertAll();

        return true;


    }


    @Test(priority = 2)
    public void page2() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.returnsTemplatePage2.click();

        Wait.forGridToLoad(driver,60);

        //Utility.isElementPresentAndDisplayed(executiveReportsPage.returnsTemplateActivePerformenceReportTitle, "ACTIVE PERFORMANCE RETURN HEATMAP (UK POUNDS)", 60);

        softAssert.assertTrue(executiveReportsPage.returnsTemplateActivePerformenceReportGrid.isDisplayed());

        softAssert.assertTrue(activePerformanceReturnsHeatMapDrillDown());

        softAssert.assertAll();

    }


    public Boolean activePerformanceReturnsHeatMapDrillDown() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        List<WebElement> x = driver.findElements(By.className("slick-cell"));

        moveToElement(x.get(120));

        x.get(10).click();

        Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        driver.switchTo().frame(0);

        Wait.waitForElementToDisplay(driver,executiveReportsPage.returnsTemplatePerformenceReportPopUP, 20);

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceReportPopUP.isDisplayed());

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

        Thread.sleep(3000);

        softAssert.assertAll();

        return true;

    }


    @Test(priority = 3)
    public void page3() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.returnsTemplatePage3.click();

        Wait.waitForSpinnerToDisappear(driver,60);

        Wait.waitForElementToDisplay(driver,executiveReportsPage.returnsTemplatePerformenceRangeAbsoluteReportGrid1, 60);

        Wait.waitForElementToDisplay(driver,executiveReportsPage.returnsTemplatePerformenceRangeAbsoluteReportGrid2, 60);

        List<WebElement> titles = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        softAssert.assertEquals(titles.get(0).getText(), "PERFORMANCE RANGE ABSOLUTE");

        softAssert.assertEquals(titles.get(1).getText(), "ABSOLUTE PERFORMANCE RETURN HEATMAP (UK POUNDS)");

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceRangeAbsoluteReportGrid1.isDisplayed());

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceRangeAbsoluteReportGrid2.isDisplayed());

        softAssert.assertTrue(verifyPerformanceReturnHeatMapDrillDown());

        softAssert.assertTrue(absolutePerformanceReturnsDrillDownPage3Grid2());

        softAssert.assertAll();


    }


    public Boolean verifyPerformanceReturnHeatMapDrillDown() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        List<WebElement> graphs = driver.findElements(By.xpath("//*[contains(@id,'chartDiv-graph-id0-plotset-plot-0-node-0')]"));

        System.out.println(graphs.size());

        graphs.get(1).click();

        Wait.waitForSquareBoxesToDisappear(driver,30);

        Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceRangeMapPopup.isDisplayed());

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

        Thread.sleep(3000);

        softAssert.assertAll();

        return true;

    }


    public Boolean absolutePerformanceReturnsDrillDownPage3Grid2() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        List<WebElement> y = driver.findElements(By.className("slick-cell"));

        System.out.println(y.size());

        y.get(120).click();

        Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceReturnHeatMapPopUp.isDisplayed());

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

        Thread.sleep(3000);

        softAssert.assertAll();

        return true;

    }


    @Test(priority = 4)
    public void Page4() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.returnsTemplatePage4.click();

        Wait.waitForSpinnerToDisappear(driver,60);

        Wait.forGridToLoad(driver,60);

        List<WebElement> titles = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        softAssert.assertEquals(titles.get(0).getText(), "PERFORMANCE RANGE ABSOLUTE");

        softAssert.assertEquals(titles.get(1).getText(), "ACTIVE PERFORMANCE RETURN HEATMAP (UK POUNDS)");

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceRangeAbsoluteReportGrid1.isDisplayed());

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceRangePage4Grid2.isDisplayed());

        softAssert.assertTrue(verifyPerformanceRangeAbsolutePage4DrillDown());

        softAssert.assertTrue(verifyPerformanceRangeAbsolutePage4Grid2DrillDown());

        softAssert.assertAll();

    }


    public Boolean verifyPerformanceRangeAbsolutePage4DrillDown() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> graphs = driver.findElements(By.xpath("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-0-node-0')]"));

        graphs.get(1).click();

        Wait.waitForSquareBoxesToDisappear(driver,30);

        Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        driver.switchTo().frame(0);

        EH.WaitForTitle("//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]", 60);

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceRangeAbsoluteDrilldownPopUP.isDisplayed());

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

        Thread.sleep(3000);

        softAssert.assertAll();

        return true;

    }


    public Boolean verifyPerformanceRangeAbsolutePage4Grid2DrillDown() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();


        List<WebElement> y = driver.findElements(By.xpath("//*[contains(@class,'slick-cell l1 r1')]"));

        y.get(1).click();

        Wait.waitForSquareBoxesToDisappear(driver,30);

        Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        driver.switchTo().frame(0);

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceReportPopUP.isDisplayed());

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

        Thread.sleep(3000);

        softAssert.assertAll();

        return true;

    }


    @Test(priority = 5)
    public void Page5() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();

        executiveReportsPage.returnsTemplatePage5.click();

        Wait.waitForSpinnerToDisappear(driver,60);

        List<WebElement> titles = driver.findElements(By.xpath("//*[contains(@id,'ctl00_labTitle')]"));

        softAssert.assertEquals(titles.get(0).getText(), "PERFORMANCE RANGE ABSOLUTE");

        softAssert.assertEquals(titles.get(1).getText(), "PERFORMANCE RANGE ABSOLUTE");

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceRangeAbsolutePage5Grid1.isDisplayed(),"PERFORMANCE RANGE ABSOLUTE");

        softAssert.assertTrue(executiveReportsPage.returnsTemplatePerformenceRangeAbsolutePage5Grid2.isDisplayed(),"PERFORMANCE RANGE ABSOLUTE");

        softAssert.assertTrue(verifyPerformanceRangePage5DrillDown1(),"PERFORMANCE RANGE ABSOLUTE drill down 1");

        softAssert.assertTrue(verifyPerformanceRangePage5DrillDown2(),"PERFORMANCE RANGE ABSOLUTE drill down 2");

        softAssert.assertAll();


    }


    public Boolean verifyPerformanceRangePage5DrillDown1() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();


        List<WebElement> graphs = driver.findElements(By.xpath("//*[contains(@id,'1000_chartDiv-graph-id0-plotset-plot-0-node-0')]"));

        graphs.get(1).click();

        Wait.waitForSquareBoxesToDisappear(driver,30);

        Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        driver.switchTo().frame(0);

        EH.WaitForTitle("//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]", 60);

        softAssert.assertTrue(executiveReportsPage.returnsPerformenceRangePage5DrillDown1PioUP.isDisplayed());

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

        softAssert.assertAll();

        return true;

    }


    public Boolean verifyPerformanceRangePage5DrillDown2() throws InterruptedException {


        SoftAssert softAssert = new SoftAssert();


        List<WebElement> graphs = driver.findElements(By.xpath("//*[contains(@id,'1001_chartDiv-graph-id0-plotset-plot-3-node-0')]"));

        graphs.get(1).click();

        Wait.waitForSquareBoxesToDisappear(driver,30);

        Wait.waitForElementToDisplay(driver,executiveReportsPage.popupClose_btn,10);

        driver.switchTo().frame(0);

        EH.WaitForTitle("//*[contains(@id,'ctl00_mainContentPlaceHolder_panContainer')]", 60);

        softAssert.assertTrue(executiveReportsPage.returnsPerformenceRangePage5DrillDown2PioUP.isDisplayed());

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

        softAssert.assertAll();

        return true;

    }

    @AfterMethod
    public void teardown(ITestResult reuslt) {

        Utility.tearDown(reuslt);
    }



}
