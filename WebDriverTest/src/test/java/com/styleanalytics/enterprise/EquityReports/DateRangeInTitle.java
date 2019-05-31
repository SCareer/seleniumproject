package com.styleanalytics.enterprise.EquityReports;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.pages.PortfolioReportsPage;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.io.IOException;

/**
 * Created by viswanath on 30/04/2018.
 */
public class DateRangeInTitle extends TestBase {

    static WebDriver driver;
    PortfolioReportsPage reportsPage;


    @BeforeClass
    public void dateRangeTestSetup() throws Exception {
        String user = property("ExistingReportsTestUser");
        String pass = property("ExistingReportsTestUserPass");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(user, pass);
        driver = getDriver();


        reportsPage = new PortfolioReportsPage(getDriver());

        String portfolioName = property("EquityPortfolio");

        reportsPage.goToReportsPage(getURL());

        reportsPage.selectPortfolio(portfolioName);



    }

    @Test
    public void styleMineDateRangeInTitleTest() throws Exception {

        reportsPage.getStyleMinePerformance();

        verifyDateRangeInTitle();

    }

    @Test
    public void perfSummaryDateRangeInTitleTest() throws Exception {

        reportsPage.getPerformanceSummary();

        verifyDateRangeInTitle();
    }

    @Test
    public void fofPerfSummaryDateRangeInTitleTest() throws Exception {

        reportsPage.getFofPerformace();

        verifyDateRangeInTitle();
    }


    @Test
    public void styleExposureRangeDateRangeInTitleTest() throws Exception {

        reportsPage.getStyleExposureRange();

        verifyDateRangeInTitle1();
    }


    public void verifyDateRangeInTitle() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebElement title2years = selectDateRange("Last 2 Years");

        System.out.println(title2years.getText());

        softAssert.assertEquals(title2years.getText(), "31 MAY 2014 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 MAY 2014 - 31 MAY 2016");

        WebElement title1year = selectDateRange("Last 1 Year");

        softAssert.assertEquals(title1year.getText(), "31 MAY 2015 - 31 MAY 2016");

        WebElement title10years = selectDateRange("Last 10 Years");

        softAssert.assertEquals(title10years.getText(), "31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title15years = selectDateRange("Last 15 Years");

        softAssert.assertEquals(title15years.getText(), "31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title5years = selectDateRange("Last 5 Years");

        softAssert.assertEquals(title5years.getText(), "31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title3years = selectDateRange("Last 3 Years");

        softAssert.assertEquals(title3years.getText(), "31 MAY 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 MAY 2013 - 31 MAY 2016");

        WebElement title4years = selectDateRange("Last 4 Years");

        softAssert.assertEquals(title4years.getText(), "31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title1month = selectDateRange("Last 1 Month");

        softAssert.assertEquals(title1month.getText(), "30 APR 2016 - 31 MAY 2016");

        //verifyDateRangeInTitle("30 APR 2016 - 31 MAY 2016");

        WebElement title3month = selectDateRange("Last 3 Months");

        softAssert.assertEquals(title3month.getText(), "29 FEB 2016 - 31 MAY 2016");

        //verifyDateRangeInTitle("29 FEB 2016 - 31 MAY 2016");

        WebElement title6months = selectDateRange("Last 6 Months");

        softAssert.assertEquals(title6months.getText(), "30 NOV 2015 - 31 MAY 2016");

        //verifyDateRangeInTitle("30 NOV 2015 - 31 MAY 2016");

        softAssert.assertAll();


    }

    public void verifyDateRangeInTitle1() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebElement title2years = selectDateRange("Last 2 Year");

        softAssert.assertEquals(title2years.getText(), "30 JUN 2014 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 MAY 2014 - 31 MAY 2016");

        WebElement title1year = selectDateRange("Last 1 Year");

        softAssert.assertEquals(title1year.getText(), "30 JUN 2015 - 31 MAY 2016");

        WebElement title10years = selectDateRange("Last 10 Years");

        softAssert.assertEquals(title10years.getText(), "31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title15years = selectDateRange("Last 15 Years");

        softAssert.assertEquals(title15years.getText(), "31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title5years = selectDateRange("Last 5 Years");

        softAssert.assertEquals(title5years.getText(), "31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title3years = selectDateRange("Last 3 Years");

        softAssert.assertEquals(title3years.getText(), "30 JUN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 MAY 2013 - 31 MAY 2016");

        WebElement title4years = selectDateRange("Last 4 Years");

        softAssert.assertEquals(title4years.getText(), "31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title1month = selectDateRange("Last 1 Month");

        softAssert.assertEquals(title1month.getText(), "31 MAY 2016 - 31 MAY 2016");

        //verifyDateRangeInTitle("30 APR 2016 - 31 MAY 2016");

        WebElement title3month = selectDateRange("Last 3 Month");

        softAssert.assertEquals(title3month.getText(), "31 MAR 2016 - 31 MAY 2016");

        //verifyDateRangeInTitle("29 FEB 2016 - 31 MAY 2016");

        WebElement title6months = selectDateRange("Last 6 Month");

        softAssert.assertEquals(title6months.getText(), "31 DEC 2015 - 31 MAY 2016");

        //verifyDateRangeInTitle("30 NOV 2015 - 31 MAY 2016");

        softAssert.assertAll();


    }


    public static void verifyDateRangeInTitle(String dateRange) {

        SoftAssert softAssert = new SoftAssert();

        WebElement dateRangeTitle = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_ucSnapshotDateFilter_lblDate\"]"));

        softAssert.assertEquals(dateRangeTitle.getText(), dateRange);
    }


    public static WebElement selectDateRange(String dateRange) throws InterruptedException {

        String currentDateRange = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_ucSnapshotDateFilter_ddlSnapshotFilter_Input\"]")).getAttribute("value");

        //String dateRange = currentDateRange.getText();

        System.out.println(currentDateRange);

        if (currentDateRange.equalsIgnoreCase(dateRange)) {

            WebElement dateRangeTitle = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_ucSnapshotDateFilter_lblDate\"]"));

            return dateRangeTitle;


        } else {

            driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_ucSnapshotDateFilter_ddlSnapshotFilter_Input\"]")).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath("//li[@class='rcbItem'][contains(text(),'" + dateRange + "')]")).click();

            //Utility.waitForReportsToLoad(30);

            Wait.waitForSquareBoxesToDisappear(driver,60);
            Wait.waitForSpinnerToDisappear(driver,60);

            //Thread.sleep(15000);

            WebElement dateRangeTitle = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_ucSnapshotDateFilter_lblDate\"]"));

            return dateRangeTitle;

        }


    }
}
