package com.styleanalytics.enterprise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 12/07/2017.
 */
public class TaskActivityTest extends EnterpriseBaseClass {

    @BeforeClass
    public void setup() throws IOException {

        GoTo.taskActivity();
        Wait.untilJqueryIsDone(Driver);
    }

    @Test(priority = 1)
    public void goTOTaskActivity() throws InterruptedException, IOException {


        Thread.sleep(3000);

        WebElement title = Driver.findElement(By.xpath("//*[@id='ctl00_topNav2_labBreadcrumb']"));

        Assert.assertEquals(title.getText(), "Task Activity");

        WebElement portfolio = Driver.findElement(By.xpath("//span[contains(text(),'Portfolio')]"));

        Assert.assertEquals(portfolio.getText(), "Portfolio");

        WebElement bm = Driver.findElement(By.xpath("//span[contains(text(),'Benchmark')]"));

        Assert.assertEquals(bm.getText(), "Benchmark");

        WebElement task = Driver.findElement(By.xpath("//span[@class='ag-header-cell-text'][contains(text(),'Task')]"));

        Assert.assertEquals(task.getText(), "Task");

        WebElement showSummary = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_butSummary_input']"));

        //Assert.assertEquals(showSummary.getText(),"Show Summary");


    }

    //@Test(priority = 2)
    public void portfolioFilters() throws InterruptedException {

        String pFilter = "//div[@class='ag-header-cell ag-column-hover']//input[@class='ag-floating-filter-input']";


        String firstPortfolio = "//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value ag-cell-focus ag-column-hover']";

        searchAndVerify(pFilter, firstPortfolio, "Automated - Notification Test"); //Verify portfolio filter

        Driver.findElement(By.xpath("//div[contains(text(),'Portfolio')]")).click(); //clear the portfolio filter


    }

   // @Test(priority = 3)
    public void bmFilter() throws InterruptedException {

        String bmFilter = "//*[@id='center']/div/div[1]/div[1]/div[3]/div[2]/div/div/input";

        String firstBM = "//*[@id='center']/div/div[4]/div[1]/div/div[2]/div[2]";

        searchAndVerify(bmFilter, firstBM, "MSCI AC EUROPE");

        Driver.findElement(By.xpath("//*[@id='divFilterLabels']/div[1]")).click(); //clear the BM filter
    }

   // @Test(priority = 4)
    public void taskFilter() throws InterruptedException {

        String bmFilter = "//*[@id='center']/div/div[1]/div[1]/div[3]/div[3]/div/div/input";

        String firstBM = "//*[@id='center']/div/div[4]/div[1]/div/div[3]/div[3]";

        searchAndVerify(bmFilter, firstBM, "Developed Europe (GICS) EUR GICS (Organization)");

        Driver.findElement(By.xpath("//*[@id='divFilterLabels']/div[1]")).click(); //clear the task filter


    }


    public void searchAndVerify(String portfolioFilter, String portfolioFilterResult, String pName) throws InterruptedException {

        WebElement pFilter = Driver.findElement(By.xpath(portfolioFilter));

        pFilter.sendKeys(pName);

        Thread.sleep(10000);

        WebElement firstPortfolio = Driver.findElement(By.xpath(portfolioFilterResult));

        Assert.assertEquals(firstPortfolio.getText(), pName);
    }


}
