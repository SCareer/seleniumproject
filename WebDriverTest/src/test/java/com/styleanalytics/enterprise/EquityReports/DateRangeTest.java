package com.styleanalytics.enterprise.EquityReports;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Utility;
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
public class DateRangeTest extends TestBase {

    static WebDriver driver;

    @BeforeClass
    public void dateRangeTestSetup() throws IOException, InterruptedException {

        driver = getDriver();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();

       //PortfolioReportsTest portfolioReportsTest = new PortfolioReportsTest();

       //portfolioReportsTest.PortfolioReportsTest();

        Utility.logInAsDiffUser("ExistingReportsTestUser","ExistingReportsTestUserPass");

        PortfolioReportsPage rp = new PortfolioReportsPage(getDriver());

        rp.styleMine.click();

        Thread.sleep(2000);

        rp.styleMinePerformance.click();

        Thread.sleep(5000);


    }


    @Test
    public void dateRangeInStyleMine2Year() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebElement title2years = selectDateRange("Last 2 Year");

        softAssert.assertEquals(title2years.getText(),"31 MAY 2014 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 MAY 2014 - 31 MAY 2016");

        WebElement title1year = selectDateRange("Last 1 Year");

        softAssert.assertEquals(title1year.getText(),"31 MAY 2015 - 31 MAY 2016");

        WebElement title10years = selectDateRange("Last 10 Years");

        softAssert.assertEquals(title10years.getText(),"31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title15years = selectDateRange("Last 15 Years");

        softAssert.assertEquals(title15years.getText(),"31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title5years = selectDateRange("Last 5 Years");

        softAssert.assertEquals(title5years.getText(),"31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title3years = selectDateRange("Last 3 Years");

        softAssert.assertEquals(title3years.getText(),"31 MAY 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 MAY 2013 - 31 MAY 2016");

        WebElement title4years = selectDateRange("Last 4 Years");

        softAssert.assertEquals(title4years.getText(),"31 JAN 2013 - 31 MAY 2016");

        //verifyDateRangeInTitle("31 JAN 2013 - 31 MAY 2016");

        WebElement title1month = selectDateRange("Last 1 Month");

        softAssert.assertEquals(title1month.getText(),"30 APR 2016 - 31 MAY 2016");

        //verifyDateRangeInTitle("30 APR 2016 - 31 MAY 2016");

        WebElement title3month = selectDateRange("Last 3 Month");

        softAssert.assertEquals(title3month.getText(),"29 FEB 2016 - 31 MAY 2016");

        //verifyDateRangeInTitle("29 FEB 2016 - 31 MAY 2016");

        WebElement title6months =selectDateRange("Last 6 Month");

        softAssert.assertEquals(title6months.getText(),"30 NOV 2015 - 31 MAY 2016");

        //verifyDateRangeInTitle("30 NOV 2015 - 31 MAY 2016");

        softAssert.assertAll();




    }

    public static void verifyDateRangeInTitle(String dateRange){

        SoftAssert softAssert = new SoftAssert();

        WebElement dateRangeTitle = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_ucSnapshotDateFilter_lblDate\"]"));

        softAssert.assertEquals(dateRangeTitle.getText(),dateRange);
    }


    public static WebElement selectDateRange(String dateRange) throws InterruptedException {


        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_ucSnapshotDateFilter_ddlSnapshotFilter_Input\"]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//li[@class='rcbItem'][contains(text(),'"+dateRange+"')]")).click();

        Thread.sleep(15000);

        WebElement dateRangeTitle = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_ucSnapshotDateFilter_lblDate\"]"));

        return dateRangeTitle;

    }
}
