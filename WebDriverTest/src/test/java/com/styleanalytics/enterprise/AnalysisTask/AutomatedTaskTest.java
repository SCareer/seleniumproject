package com.styleanalytics.enterprise.AnalysisTask;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.pages.AnalysisTaskPage;
import com.styleanalytics.pages.PortfolioExplorerPage;
import com.styleanalytics.pages.SearchPage;
import com.styleanalytics.setup.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutomatedTaskTest extends TestBase {

    @BeforeClass
    public void setupAutomatedTask() throws IOException, InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();

    }
    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.explorePortfolioFromQuickSearch("Analysis Task");
        PortfolioExplorerPage explorerPage = new PortfolioExplorerPage(getDriver());
        explorerPage.explorerSettingsView("Tasks");
    }
    @Test(priority =1)
    public void create() throws Exception {

        AnalysisTaskPage analysisTaskPage = new AnalysisTaskPage(getDriver());
        analysisTaskPage.createAutomatedTask("MSCI EUROPE",
                " Developed Europe (GICS)",
                "US Dollars",
                "ICB",
                "Style Research Default",
                "Test");
    }

    @Test(priority = 2)
    public void run() throws Exception {

        AnalysisTaskPage analysisTaskPage = new AnalysisTaskPage(getDriver());
        analysisTaskPage.runAutomatedTask();

    }
    @Test(priority = 3)
    public void delete() throws Exception {

        AnalysisTaskPage analysisTaskPage = new AnalysisTaskPage(getDriver());
        analysisTaskPage.deleteAutomatedTask();

    }


}
