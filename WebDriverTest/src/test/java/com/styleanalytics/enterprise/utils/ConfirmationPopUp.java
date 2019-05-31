package com.styleanalytics.enterprise.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ConfirmationPopUp {

    WebDriver driver;

    public ConfirmationPopUp(WebDriver driver){

        this.driver=driver;
    }


    public void clickOnConfirmPopup() throws InterruptedException {



        String dynamicID = driver.findElement(By.xpath("//iframe[contains(@name,'confirm')]")).getAttribute("name");

        //Utility.isElementPresentAndClick("//*[@id='"+dynamicID+"_content']/div/div[2]/a[1]/span/span",5);
        driver.findElement(By.xpath("//*[@id='"+dynamicID+"_content']/div/div[2]/a[1]/span/span")).click();



    }


    public void clickOnDeletePopUp() throws InterruptedException {

        String dynamicID = driver.findElement(By.xpath("//iframe[contains(@name,'confirm')]")).getAttribute("name");  //
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='"+dynamicID+"_content']/div/div[2]/a/span/span")).click();
        Thread.sleep(3000);
    }



    public void deleteFactorSet(String fullControlFactorSet) throws InterruptedException{


       // driver.findElement(By.xpath("//*[@id='divExistingTemplates']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(FactorSetName);
       // Thread.sleep(3000);

        List<WebElement> deleteButton = driver.findElements(By.cssSelector(".sgButtonRed"));

        System.out.print(deleteButton.size());

        if(deleteButton.size()!=0) {

            for (int i = 0; i < deleteButton.size(); i++) {

                driver.findElement(By.cssSelector(".sgButtonRed")).click();
                Thread.sleep(3000);

                for (String winHandle : driver.getWindowHandles()) {
                    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
                }
                driver.findElement(By.cssSelector(".rwInnerSpan")).click();
                Thread.sleep(3000);
                driver.switchTo().defaultContent();

                //driver.findElement(By.xpath("//*[@id='divExistingTemplates']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(FactorSetName);//dateFormat1.format(date)
               // Thread.sleep(3000);
            }

        }else
            System.out.print("No Templates to Delete");

    }



}
