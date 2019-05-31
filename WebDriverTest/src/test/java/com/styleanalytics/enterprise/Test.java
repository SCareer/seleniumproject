package com.styleanalytics.enterprise;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.pages.PortfolioReportsPage;
import com.styleanalytics.setup.TestBase;
import org.testng.annotations.BeforeClass;

public class Test extends TestBase {

    PortfolioReportsPage reportsPage;
    @BeforeClass
    public void PortfolioReportsTest() throws Exception {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login();

        reportsPage = new PortfolioReportsPage(getDriver());

    }

    @org.testng.annotations.Test
    public void portfolioWebReports() throws Exception {


        for(int i=0;i<150;i++) {

            String url = TestBase.property("URL");
            reportsPage.goToReportsPage(url);

            Thread.sleep(5000);

            //reportsPage.selectSnapshot("30 Apr 2016");

        }
    }




}
