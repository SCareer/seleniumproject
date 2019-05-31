package com.styleanalytics.enterprise.PortfolioLabs;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.pages.PortfolioReportsPage;
import com.styleanalytics.setup.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LabsTest extends TestBase {

    PortfolioLabsPage labsPage;
    LoginPage loginPage;


    @BeforeClass
    public void testSetup() throws Exception {

        loginPage = new LoginPage(getDriver());
        loginPage.login("viswanath.selvaraj@styleresearch.com","Test1234%");
        labsPage = new PortfolioLabsPage(getDriver());

        PortfolioReportsPage portfolioReportsPage = new PortfolioReportsPage(getDriver());
        portfolioReportsPage.goToReportsPage(getURL());

        labsPage.createScenario();

    }
    @Test(priority = 1)
    public void createNewScenarioAndVerifyReports() throws InterruptedException {

        labsPage.verifyAllReports();
    }
    @Test(priority = 2)
    public void increaseNavAndVerifyReports() throws InterruptedException {

        labsPage.increaseNav(5000000);
        labsPage.verifyAllReports();

    }
    @Test(priority = 3)
    public void increaseCashAndVerifyReports() throws InterruptedException {

        labsPage.increaseCash(50000);
        labsPage.verifyAllReports();

    }
    @Test(priority = 4)
    public void buyEquityAndVerifyReports() throws InterruptedException {

        labsPage.buyEquity("APPLE FINANCE LIMITED","5");
        labsPage.verifyAllReports();

    }
    @Test(priority = 5)
    public void buyPortfolioAndVerifyReports() throws InterruptedException {

        labsPage.buyPortfolio("MSCI AC EUROPE","5");
        labsPage.verifyAllReports();

    }

    @Test(priority = 6)
    public void buyCashAndVerifyReports() throws InterruptedException {

        labsPage.buyCash("US Dollars","5");
        labsPage.verifyAllReports();

    }

}
