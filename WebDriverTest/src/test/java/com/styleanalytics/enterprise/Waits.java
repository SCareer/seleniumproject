package com.styleanalytics.enterprise;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Viswanath on 08/03/2018.
 */
public class Waits extends EnterpriseBaseClass {

    public void fluentWait(final String waitFor) {


        Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver)
                .withTimeout(180, TimeUnit.SECONDS)
                .pollingEvery(250, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver Driver) {

                WebElement element = Driver.findElement(By.xpath(waitFor));

                if (element.isDisplayed()) {
                    System.out.println("Object Found");
                    return element;
                }else{
                    System.out.println("Object Not Found");
                }
                return null;
            }
        };
       wait.until(function);

    }

    public void explicitWaitAndClick(String xpath) {

        WebDriverWait wait = new WebDriverWait(Driver, 120);
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

        nextButton.click();



    }

    public void explicitWait(String xpath) {

        WebDriverWait wait = new WebDriverWait(Driver, 120);
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));



    }
    

    public void waitForVisibilityOfElement(WebElement xpath, int timeInSeconds) {

        WebDriverWait wait = new WebDriverWait(Driver, timeInSeconds);
        WebElement nextButton = wait.until(ExpectedConditions.visibilityOf(xpath));



    }

    public void waitForElementToBeClickable(WebElement xpath, int timeInSeconds) {

        WebDriverWait wait = new WebDriverWait(Driver, timeInSeconds);
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(xpath));



    }


    public static WebElement isElementPresent(WebDriver driver,String xpath,int time)
    {


        WebElement element = null;

        for(int i=0;i<time;i++)
        {
            try{
                element=driver.findElement(By.xpath(xpath));
                break;
            }
            catch(Exception e)
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e1)
                {
                    System.out.println("Waiting for element to appear on DOM");
                }
            }


        }
        return element;

    }



    public static void untilJqueryIsDone(WebDriver driver, Long timeoutInSeconds){
        until(driver, (d) ->
        {
            Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
            return isJqueryCallDone;
        }, timeoutInSeconds);
    }

    private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds){
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
        webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        try{
            webDriverWait.until(waitCondition);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds){
        until(driver, (d) ->
        {
            Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded) System.out.println("Document is loading");
            return isPageLoaded;
        }, timeoutInSeconds);
    }
}
