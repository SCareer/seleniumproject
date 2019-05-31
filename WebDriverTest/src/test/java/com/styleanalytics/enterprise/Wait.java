package com.styleanalytics.enterprise;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wait {

    private int timeoutInSeconds = 60;

    public static void untilJqueryIsDone(WebDriver driver) {
        untilJqueryIsDone(driver, 60);
    }

    public static void untilJqueryIsDone(WebDriver driver, int timeoutInSeconds) {
        until(driver, (d) ->
        {
            Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone)
                System.out.println("JQuery call is in Progress");
            return isJqueryCallDone;
        }, timeoutInSeconds);
    }



    public static void waitForSquareBoxesToDisappear(WebDriver driver, int seconds) {
        until(driver, (d) ->
        {
            Boolean isAjaxFinished = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");

            try {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                driver.findElement(By.xpath("//div[@id='ctl00_RadAjaxLoadingPanel1formContainer']")).isDisplayed();
                return false;
            } catch (Exception e) {

                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                return isAjaxFinished;
            }

        }, seconds);
    }


    public static void waitForSpinnerToDisappear(WebDriver driver, int seconds) {
        until(driver, (d) ->
        {
            Boolean isAjaxFinished = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            try {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                driver.findElement(By.xpath("//div[contains(@class,'carouselBlock withLoadingPane')]")).isDisplayed();
                return false;
            } catch (Exception e) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                return isAjaxFinished;
            }
        }, seconds);
    }

    private static void waitForSpinnerToDisappearOnGrids(WebDriver driver, int seconds) {
        until(driver, (d) ->
        {
            Boolean isAjaxFinished = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            try {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                driver.findElement(By.xpath("//div[contains(@class,'gridLoadingPane')]")).isDisplayed();

                return false;
            } catch (Exception e) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                return isAjaxFinished;
            }
        }, seconds);
    }

    public static void waitForElementToDisappear(WebDriver driver, int seconds,WebElement element) {
        until(driver, (d) ->
        {
            Boolean isAjaxFinished = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            try {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                element.isDisplayed();

                return false;
            } catch (Exception e) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                return isAjaxFinished;
            }
        }, seconds);
    }

    public static void waitForTextToBeVisible(WebDriver driver, int seconds,WebElement element, String text) {
        until(driver, (d) ->
        {
           try {
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                element.isDisplayed();
                element.getText().equalsIgnoreCase(text);

                return true;
            } catch (Exception e) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                return false;
            }
        }, seconds);
    }

    public static void forGridToLoad(WebDriver driver, int seconds){

        waitForSpinnerToDisappear(driver,seconds);

        waitForSpinnerToDisappearOnGrids(driver,seconds);


    }


    public static void untilPageLoadComplete(WebDriver driver) {
        untilPageLoadComplete(driver, 60);
    }

    public static void untilPageLoadComplete(WebDriver driver, int timeoutInSeconds) {
        until(driver, (d) ->
        {
            Boolean isPageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded) System.out.println("Document is loading");
            return isPageLoaded;
        }, timeoutInSeconds);
    }

    public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition) {
        until(driver, waitCondition, 60);
    }


    public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, int timeoutInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
        webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        try {
            webDriverWait.until(waitCondition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void waitForElementToDisplay(WebDriver driver,WebElement element, int timeOutInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));


    }

    public static void waitForElementToDisplayByXpath(WebDriver driver,String Xpath, int timeOutInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));

    }


    public static void moveToElement(WebElement element,WebDriver driver){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);


    }

}


