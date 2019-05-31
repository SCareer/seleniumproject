package com.styleanalytics.enterprise.Search;


import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.pages.SearchPage;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 18/05/2017.
 */
public class SearchTest extends TestBase {

    private SearchPage searchP;

    WebDriver driver;

    @BeforeClass
    public void SearchTest() throws IOException {

        searchP = new SearchPage(getDriver());
        driver = getDriver();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
    }


    public void searchPortfolio() throws InterruptedException, IOException {

        String sPortfolio = property("SearchPortfolio");
        Thread.sleep(5000);
        searchP.setSearchIcon();
        searchP.setSearchTextBlock(sPortfolio);
        Wait.waitForSpinnerToDisappear(driver, 60);
        searchP.setFirstSearchResult();


    }

    public void searchPortfolio(String pName) throws InterruptedException, IOException {

        searchP.setSearchIcon();
        searchP.setSearchTextBlock(pName);
        searchP.setFirstSearchResult();
        searchP.setFirstSearchResult();

    }

    public void selectPortfolioInSearchResult() throws InterruptedException {

        searchP.setFirstSearchResult();
        Wait.waitForSpinnerToDisappear(driver,30);
        Thread.sleep(3000);

        }

    public void verifyPortfolioIsPresent(String path, String portfolioName) throws InterruptedException {

        // Verify portfolio name in respective pages
        WebElement Name = driver.findElement(By.xpath(path));
        Assert.assertEquals(Name.getText(), portfolioName);

    }

    @Test(priority = 1)
    public void navigateToExplorerPage() throws InterruptedException, IOException {

        searchPortfolio();
        selectPortfolioInSearchResult();

        searchP.setPortfolioExplorerLink();
        Thread.sleep(3000);

        verifyPortfolioIsPresent("//span[@id='selectedPortfolioName']", "Automated - Portfolio Search Test");


    }

    @Test(priority = 2)
    public void navigateToTaskActivity() throws InterruptedException, IOException {

        searchPortfolio();
        selectPortfolioInSearchResult();
        searchP.setTaskActivityLink();
        Thread.sleep(3000);

        //Verify Portfolio is selected in task activity grid
        verifyPortfolioIsPresent("//*[@id='center']/div/div[4]/div[1]/div/div/div[1]", "Automated - Portfolio Search Test");
    }

    @Test(priority = 3)
    public void navigateToPortfolioReports() throws InterruptedException, IOException {

        searchPortfolio();
        selectPortfolioInSearchResult();

        driver.findElement(By.xpath("//*[@id='divReports']/div[4]/div[3]/div/div/div[7]/a")).click();

        Thread.sleep(15000);

        //Verify Portfolio in reports page
        verifyPortfolioIsPresent("//*[@id='ctl00_mainContentPlaceHolder_report_labPortfolioName']", "Automated - Portfolio Search Test");


    }

    @Test(priority = 4)
    public void navigateToPeerInsightsReports() throws InterruptedException, IOException {

        searchPortfolio();
        selectPortfolioInSearchResult();

        driver.findElement(By.xpath("//*[@id='divPeerInsights']/div[4]/div[3]/div/div/div[5]/a")).click();
        Thread.sleep(15000);

        //Verify Peer group report name
        //verifyPortfolioIsPresent("//*[@id='ctl00_mainContentPlaceHolder_labPeerGroupName']", "EUCA000553");


    }

    @Test(priority = 5)
    public void navigateToPortfolioLabsReport() throws InterruptedException, IOException {

        searchPortfolio();
        selectPortfolioInSearchResult();


        driver.findElement(By.xpath("//*[@id='divLabs']/div[4]/div[3]/div/div[1]/div[5]/a")).click();
        Thread.sleep(20000);

        //Verify Scenario name
        verifyPortfolioIsPresent("//*[@id='scenarioName']", "SCENARIO: AUTOMATED - PORTFOLIO SEARCH TEST VS MSCI AC EUROPE @ 31 MAY 2016");
    }

    @Test(priority = 6)
    public void navigateToExecutiveReports() throws InterruptedException, IOException {

        searchPortfolio();
        selectPortfolioInSearchResult();

        driver.findElement(By.xpath("//*[@id='divExecReports']/div[4]/div[3]/div/div/div[5]/a")).click();
        Thread.sleep(3000);
    }

}
