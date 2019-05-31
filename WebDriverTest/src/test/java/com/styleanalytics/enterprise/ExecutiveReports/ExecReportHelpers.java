package com.styleanalytics.enterprise.ExecutiveReports;


import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ExecReportHelpers extends TestBase {


    WebDriver driver;

    public ExecReportHelpers(WebDriver driver){
        this.driver = driver;
    }


    public void ExReportSearch(String ReportName) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> inputBox = driver.findElements(By.xpath("//div[@class='ui-state-default slick-headerrow-column l0 r0']//input[@type='text']"));

        inputBox.get(inputBox.size()-1).sendKeys(ReportName);

        //driver.findElement(By.xpath("//div[@class='ui-state-default slick-headerrow-column l0 r0']//input[@type='text']")).sendKeys(ReportName);

        Thread.sleep(3000);

        softAssert.assertAll();

    }


    public void drillDownInslickGrid(String onClickStartText, int elementListNumber){

        List<WebElement> list =driver.findElements(By.xpath("//div[contains(@onclick,'"+onClickStartText+"')]"));

        String a = list.get(elementListNumber).getAttribute("onclick");

        String b = "//div[@onclick="+"\""+a+"\""+"]";

       // System.out.println(b);

        WebElement element = driver.findElement(By.xpath(b));

        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", element);
    }





    public void drillDownInslickGridChamgesReport(String getDashboardFundChanges, int elementListNumber){

        List<WebElement> list =driver.findElements(By.xpath("//div[contains(@href,'"+getDashboardFundChanges+"')]"));

        String a = list.get(elementListNumber).getAttribute("href");

        String b = "//div[@href="+"\""+a+"\""+"]";

        // System.out.println(b);

        WebElement element = driver.findElement(By.xpath(b));

        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", element);
    }








      public void WaitForTitle(String Xpath, int i) {

          WebDriverWait wait = new WebDriverWait(driver, i);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));

      }

    public String getSlickGridID() throws InterruptedException {


        //Thread.sleep(5000);

        // Utility.isElementPresentAndDisplayed("//div[@id='divCustomPeerGroups']",5);

        String slickGridClass= driver.findElement(By.xpath("//div[contains(@id,'_SummaryGrid_panGridSummaryPortfolioChanges')]")).getAttribute("class");  //Find the Slick Grid ID

        System.out.println(slickGridClass);

        String slickGridID = slickGridClass.substring(36,42);

        //System.out.println(slickGridID);

        return slickGridID;
    }




}
