package com.styleanalytics.enterprise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.styleanalytics.enterprise.Setup.exists;

public class StartEnvironment{

    WebDriver driver;

    public StartEnvironment(WebDriver driver){

        this.driver = driver;
    }

    //@Test
    public void start(String environment) throws InterruptedException {

        driver.get("https://sskpcovixe.execute-api.eu-west-1.amazonaws.com/Prod");

        Thread.sleep(2000);

        if(environment.equalsIgnoreCase("Test")) {

            driver.findElement(By.xpath("//input[@value='systemtest']")).click();
        }

        Thread.sleep(2000);

        if(environment.equalsIgnoreCase("Stage")) {

            driver.findElement(By.xpath("//input[@value='staging']")).click();

        }

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@value='Submit Request']")).click();

        Thread.sleep(2000);



    }

    public void starting(String url, String environmentName) throws InterruptedException {

        if (exists(url)) {

            driver.get(url);

        } else {

            start(environmentName);

            for (int i = 0; i < 7; i++) {

                if (exists(url)) {
                    driver.get(url);
                    break;
                } else {

                    Thread.sleep(300000);
                }
            }

        }
    }
}
