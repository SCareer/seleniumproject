package com.styleanalytics.enterprise.AnalysisPages;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.pages.PortfolioExplorerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class AnalysisPageHelper extends EnterpriseBaseClass {

    public void filterAnalysisByPortfolio(String portfolioName) throws InterruptedException, IOException {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> x=  Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_tabStatus\"]/div/ul/li/a/span/span/span"));

        x.get(3).click();

        List<WebElement> y =   Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th/a"));


        y.get(5).click();

        Thread.sleep(3000);

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearchBenchmark_radComboBoxPortfolioQuickSearch_Input\"]")).getAttribute("value"), "select portfolio(s)");

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input\"]")).click();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input\"]")).sendKeys(portfolioName);

        Driver.findElement(By.xpath("//*[@id=\"quickSearchItem\"]/span[2]")).click();

        Thread.sleep(4000);

        y = Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th/a"));

        y.get(5).click();

        Thread.sleep(3000);

        System.out.println(Driver.findElement(By.id("ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input")).getAttribute("value"));

        softAssert.assertEquals(Driver.findElement(By.id("ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input")).getAttribute("value"), portfolioName);

        softAssert.assertAll();


    }

    public static void deleteCompletedAnalysisFromAnalysisPage(String portfolioName) throws InterruptedException, IOException {

        GoTo.goToAnalysisPage();

        deleteAnalysisFromAnalysisPage(portfolioName);


    }

    public static void deleteCompleteAnalysisFromExplorerPage(String portfolioName) throws IOException, InterruptedException {

        Utility.portfolioQuickSearchInExplorer(portfolioName);

        Thread.sleep(8000);

        PortfolioExplorerPage explorerPage = new PortfolioExplorerPage(Driver);
        explorerPage.explorerSettingsView("Tasks");
        Thread.sleep(8000);

        try{

            Driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).isDisplayed();
            Driver.findElement(By.xpath("//span[contains(text(),'No rows found')]")).isDisplayed();

            System.out.println("Found the msg");
        }catch (Exception e){

            WebElement tickbox;

            tickbox = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_ctl02_ctl01_CheckboxSelectColumnSelectCheckBox\"]"));

            tickbox.click();

            Actions actions = new Actions(Driver);
            actions.moveToElement(tickbox);
            actions.contextClick(tickbox).build().perform();  /* this will perform right click */
            WebElement elementOpen = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_contextMenuGridAnalysis_detached\"]/ul/li[6]/a/span")); /*This will select menu after right click */
            Thread.sleep(5000);
            elementOpen.click();

            Thread.sleep(10000);


            Utility.clickOnConfirmPopup();

            Thread.sleep(10000);


        }



    }


    public static void deleteCompletedAnalysis(String[] portfolioName) throws InterruptedException, IOException {

        GoTo.goToAnalysisPage();


        for(int i=0;i<portfolioName.length;i++) {

            deleteAnalysisFromAnalysisPage(portfolioName[i]);

        }

    }

    public static void deleteAnalysisFromAnalysisPage(String portfolioName) throws InterruptedException {

        Utility utility = new Utility();
        utility.isElementPresentAndClick("//*[@id='ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_Header']/thead/tr/th[13]/a[1]",3);

        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input']")).sendKeys(" "+portfolioName);

        // utility.isElementPresent("//span[contains(text(),'"+portfolioName+"')]",2);
        Thread.sleep(10000);
        Driver.findElement(By.xpath("//*[@id='quickSearchItem']/span[2]")).click();
        Thread.sleep(15000);

        try {

            Driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).isDisplayed();

        }catch (Exception e){

            Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_ctl02_ctl01_CheckboxSelectColumnSelectCheckBox']")).click();
            Thread.sleep(3000);
            Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_gridAnalysis_radToolbarAnalysisViewList']/div/div/div/ul/li[1]/a/span/span/span/span[1]")).click();
            Thread.sleep(3000);
            Driver.findElement(By.xpath("//*[@id='aspnetForm']/div[1]/div/ul/li[2]/a/span")).click();
            Thread.sleep(3000);

            Driver.findElement(By.xpath("html/body/div[2]/form/div[1]/table/tbody/tr[2]/td[2]/div/div/div[2]/a[1]/span/span")).click();

            Thread.sleep(7000);


        }

    }

}
