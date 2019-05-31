package com.styleanalytics.enterprise;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.pages.DashboardPage;
import com.styleanalytics.setup.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DashboardTest extends TestBase {

    DashboardPage dashboardPage;

    @BeforeClass
    public void dashboardSetup() throws IOException {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
        dashboardPage = new DashboardPage(getDriver());

    }
    @Test
    public void goToLoadFromDashboard() throws Exception {


        dashboardPage.setDashboard();
        dashboardPage.setLoad_btn();
        if(!getDriver().getTitle().equalsIgnoreCase("Load Data")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }

    }
    @Test
    public void goToPortfolioReportsFromDashboard() throws Exception {
        dashboardPage.setDashboard();
        dashboardPage.setPortfolioReports_btn();
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Reports")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void goToExplorerFromDashboard() throws Exception {
        dashboardPage.setDashboard();
        dashboardPage.setExplorer_btn();
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Portfolio")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void goToPortfolioLabsDashboard() throws Exception {
        dashboardPage.setDashboard();
        dashboardPage.setPortfolioLabs_btn();
        if(!getDriver().getTitle().equalsIgnoreCase("Portfolio Lab")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void goToExecutiveReportsDashboard() throws Exception {
        dashboardPage.setDashboard();
        dashboardPage.setExecutiveReports_btn();
        if(!getDriver().getTitle().equalsIgnoreCase("Executive Reports")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void goToPeerInsightsDashboard() throws Exception {
        dashboardPage.setDashboard();
        dashboardPage.setPeerInsights_btn();
        if(!getDriver().getTitle().equalsIgnoreCase("Peer Group Report")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void goToCustomPeerGroupDashboard() throws Exception {
        dashboardPage.setDashboard();
        dashboardPage.setPeerInsights_btn();
        if(!getDriver().getTitle().equalsIgnoreCase("Peer Group Report")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }
}
