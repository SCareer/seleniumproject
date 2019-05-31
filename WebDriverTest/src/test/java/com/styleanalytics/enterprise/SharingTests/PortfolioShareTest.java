package com.styleanalytics.enterprise.SharingTests;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.pages.PortfolioExplorerPage;
import com.styleanalytics.pages.PortfolioSharingPage;
import com.styleanalytics.pages.SearchPage;
import com.styleanalytics.setup.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PortfolioShareTest extends TestBase {


    @BeforeClass
    public void setupPortfolioShare() throws IOException, InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();

    }

    @BeforeMethod
    public void beforeTest() throws InterruptedException {

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.explorePortfolioFromQuickSearch("Analysis Task");
        PortfolioExplorerPage explorerPage = new PortfolioExplorerPage(getDriver());
        explorerPage.explorerSettingsView("Sharing");
    }

    @Test
    public void create() throws Exception {

        PortfolioSharingPage portfolioSharingPage = new PortfolioSharingPage(getDriver());
        portfolioSharingPage.createShare();

    }
    @Test
    public void verify() {

        //TODO
    }
    @Test
    public void delete() throws Exception {

        PortfolioSharingPage portfolioSharingPage = new PortfolioSharingPage(getDriver());
        portfolioSharingPage.deleteShare();

    }
}
