package com.styleanalytics.enterprise.Manage;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.pages.PortfolioExplorerPage;
import com.styleanalytics.pages.PortfolioLabelsPage;
import com.styleanalytics.pages.SearchPage;
import com.styleanalytics.setup.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PortfolioLabelsTest extends TestBase {

    @BeforeClass
    public void setupPortfolioLabelsTest() throws IOException, InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();

    }

    @BeforeMethod
    public void beforeTest() throws InterruptedException {

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.explorePortfolioFromQuickSearch("Analysis Task");
        PortfolioExplorerPage explorerPage = new PortfolioExplorerPage(getDriver());
        explorerPage.explorerSettingsView("Labels");
    }

    @Test
    public void create() throws Exception {

        PortfolioLabelsPage portfolioLabelsPage = new PortfolioLabelsPage(getDriver());
        portfolioLabelsPage.createLabel("Automated Test");


    }
    @Test
    public void verify() {

        //TODO
    }
    @Test
    public void delete() throws Exception {

        PortfolioLabelsPage portfolioLabelsPage = new PortfolioLabelsPage(getDriver());
        portfolioLabelsPage.deleteLabel();


    }
}
