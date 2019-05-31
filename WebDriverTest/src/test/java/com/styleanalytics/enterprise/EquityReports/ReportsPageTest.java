package com.styleanalytics.enterprise.EquityReports;


import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

/**
 * Created by Viswanath on 15/05/2018.
 */
public class ReportsPageTest extends TestBase {

    WebDriver driver;
    PortfolioReportsPage portfolioReportsPage;


    @BeforeClass
    public void testSetup() throws Exception {

        String userName = property("ExistingReportsTestUser");
        String pass = property("ExistingReportsTestUserPass");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(userName,pass);
        driver=getDriver();

        com.styleanalytics.pages.PortfolioReportsPage reportsPage = new com.styleanalytics.pages.PortfolioReportsPage(getDriver());
        reportsPage.goToReportsPage(getURL());
        reportsPage.selectPortfolio("EQUITYREPORTSTEST");

        portfolioReportsPage = new PortfolioReportsPage(getDriver());

    }

    @Test
    public void verifyContentsOfReportsPageDropDown() throws InterruptedException, IOException {



        Utility.searchPortfolioInReportsPage("EQUITYREPORTSTEST");

        Thread.sleep(5000);

        portfolioReportsPage.portfolioNameInTitle.click();

        Thread.sleep(5000);

        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals(portfolioReportsPage.portfolioNameInTitle.getText(),"EQUITYREPORTSTEST");

        softAssert.assertEquals(portfolioReportsPage.BMNameInTitle.getText(),"MSCI AC EUROPE");

        softAssert.assertEquals(portfolioReportsPage.snapshotDateInTitle.getText(),"31 MAY 2016");

        softAssert.assertEquals(portfolioReportsPage.portfolioLabel.getText(),"PORTFOLIO:");

        String pName = portfolioReportsPage.portfolioValue.getAttribute("Value");

        softAssert.assertEquals(pName,"EQUITYREPORTSTEST");

        softAssert.assertEquals(portfolioReportsPage.BMLabel.getText(),"BENCHMARK:");

        softAssert.assertEquals(portfolioReportsPage.BMValue.getText(),"MSCI AC EUROPE");

        softAssert.assertEquals(portfolioReportsPage.universeLabel.getText(),"UNIVERSE:");

        softAssert.assertEquals(portfolioReportsPage.universeValue.getText(),"Developed (ICB)");

        softAssert.assertEquals(portfolioReportsPage.analysisDateLabel.getText(),"ANALYSIS DATE:");

        String aDate = portfolioReportsPage.analysisDateValue.getAttribute("Value");

        softAssert.assertEquals(aDate,"31 May 2016");

        softAssert.assertEquals(portfolioReportsPage.currencyLabel.getText(),"CURRENCY:");

        softAssert.assertEquals(portfolioReportsPage.currencyValue.getText(),"EUR");

        softAssert.assertEquals(portfolioReportsPage.classificationLabel.getText(),"CLASSIFICATION:");

        softAssert.assertEquals(portfolioReportsPage.classificationValue.getText(),"GICS");

        softAssert.assertEquals(portfolioReportsPage.reportProfileLabel.getText(),"REPORT PROFILE:");

        softAssert.assertEquals(portfolioReportsPage.reportProfileValue.getText(),"Organization");

        softAssert.assertEquals(portfolioReportsPage.slideOutTitle.getText(),"RECENT REPORTS:");

        //softAssert.assertEquals(portfolioReportsPage.recentReport.getText(),"EQUITYREPORTSTEST");

        GoTo.goToReportsPage();

        softAssert.assertAll();






    }

    @Test
    public void portfolioDropDown() throws InterruptedException, IOException {



        portfolioReportsPage.portfolioNameInTitle.click();

        Utility.isElementPresentAndClick( portfolioReportsPage.portfolioValue,2);

        Thread.sleep(3000);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(portfolioReportsPage.portfolioNameHeader.getText(),"PORTFOLIO NAME");

        softAssert.assertEquals(portfolioReportsPage.userReferenceHeader.getText(),"USER REFERENCE");

        softAssert.assertEquals(portfolioReportsPage.labelsHeader.getText(),"LABELS");

        String count = portfolioReportsPage.portfolioCount.getText();

        softAssert.assertTrue(count.contains("Portfolio(s)"));

        Utility.isElementPresentAndClick( portfolioReportsPage.portfolioValue,2);

        GoTo.goToReportsPage();

        softAssert.assertAll();




    }

    @Test
    public void analysisDateDropDownTest() throws InterruptedException, IOException {


        Thread.sleep(3000);

        portfolioReportsPage.portfolioNameInTitle.click();

        Thread.sleep(3000);

        portfolioReportsPage.analysisDateValue.click();

        Thread.sleep(3000);

        List<WebElement> snapshotList = driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlSnapshots_DropDown\"]/div/ul/li"));

        System.out.println(snapshotList.size());

        SoftAssert softAssert =new SoftAssert();

        softAssert.assertEquals(snapshotList.size(),41);

        String analysisDate[]= {
                "31 May 2016",
                "30 Apr 2016",
                "31 Mar 2016",
                "29 Feb 2016",
                "31 Jan 2016",
                "31 Dec 2015",
                "30 Nov 2015",
                "31 Oct 2015",
                "30 Sep 2015",
                "31 Aug 2015",
                "31 Jul 2015",
                "30 Jun 2015",
                "31 May 2015",
                "30 Apr 2015",
                "31 Mar 2015",
                "28 Feb 2015",
                "31 Jan 2015",
                "31 Dec 2014",
                "30 Nov 2014",
                "31 Oct 2014",
                "30 Sep 2014",
                "31 Aug 2014",
                "31 Jul 2014",
                "30 Jun 2014",
                "31 May 2014",
                "30 Apr 2014",
                "31 Mar 2014",
                "28 Feb 2014",
                "31 Jan 2014",
                "31 Dec 2013",
                "30 Nov 2013",
                "31 Oct 2013",
                "30 Sep 2013",
                "31 Aug 2013",
                "31 Jul 2013",
                "30 Jun 2013",
                "31 May 2013",
                "30 Apr 2013",
                "31 Mar 2013",
                "28 Feb 2013",
                "31 Jan 2013",
        };

        for(int i=0; i<snapshotList.size(); i++){

                softAssert.assertEquals(snapshotList.get(i).getText(), analysisDate[i]);

        }
        GoTo.goToReportsPage();
        softAssert.assertAll();


    }

    @Test
    public void changeAnalysisDateTest() throws InterruptedException, IOException {

        GoTo.goToReportsPage();

        portfolioReportsPage.portfolioNameInTitle.click();

        Thread.sleep(3000);

        portfolioReportsPage.analysisDateValue.click();

        Thread.sleep(3000);

        List<WebElement> snapshotList = driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlSnapshots_DropDown\"]/div/ul/li"));

        for(int i=1; i<3; i++){



            List<WebElement> snapshotList1 = driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_ddlSnapshots_DropDown\"]/div/ul/li"));
            String dateInDropDown = snapshotList1.get(i).getText();

            System.out.println(dateInDropDown);


            snapshotList1.get(i).click();

            Thread.sleep(10000);

            String actualSnapshotDate = portfolioReportsPage.snapshotDateInTitle.getText();

            System.out.println(actualSnapshotDate);

            //Assert.assertEquals(snapshotList.get(i).getText(), actualSnapshotDate);

            Assert.assertTrue(actualSnapshotDate.equalsIgnoreCase(dateInDropDown));

            portfolioReportsPage.portfolioNameInTitle.click();

            Thread.sleep(3000);

            portfolioReportsPage.analysisDateValue.click();

            Thread.sleep(3000);

        }

        GoTo.goToReportsPage();

    }

    @Test
    public void changePortfolioName() throws InterruptedException, IOException {


        Utility.searchPortfolioInReportsPage("ReportsPageTest");

        Assert.assertEquals(portfolioReportsPage.portfolioNameInTitle.getText(),"REPORTSPAGETEST"); //Add the portfolio name


    }

    @Test
    public void changeBmName() throws IOException, InterruptedException {

        Utility.searchPortfolioInReportsPage("ReportsPageTest");

        portfolioReportsPage.portfolioNameInTitle.click();

        Thread.sleep(2000);

        portfolioReportsPage.BMDropdown.click();

        Thread.sleep(5000);

        portfolioReportsPage.BMDropdownItem.click();

        Thread.sleep(5000);


        Assert.assertEquals(portfolioReportsPage.BMNameInTitle.getText(),"MSCI EUROPE");




    }

    @Test
    public void verifyContentsInBMDropdown() throws InterruptedException, IOException {

        Utility.searchPortfolioInReportsPage("ReportsPageTest");

        portfolioReportsPage.portfolioNameInTitle.click();

        Thread.sleep(2000);

        portfolioReportsPage.BMDropdown.click();

        Thread.sleep(5000);

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> BMdetails = driver.findElements(By.className("ddlAnalysisColumn"));

        System.out.println(BMdetails.size());

        String itemsValue[] = {
                "Report Profile",
                "Benchmark",
                "Universe",
                "Class.",
                "CCY",
                "Organization",
                "MSCI AC EUROPE",
                "Developed (ICB)",
                "GICS",
                "EUR",
                "Private",
                "MSCI EUROPE",
                "Developed (ICB)",
                "ICB",
                "GBP"
        };

        for(int i=0;i<BMdetails.size();i++) {

            System.out.println(BMdetails.get(i).getText());

            softAssert.assertEquals(BMdetails.get(i).getText(),itemsValue[i]);
        }


        softAssert.assertAll();


    }




}
