package com.styleanalytics.enterprise;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class ReleaseNotesTest extends EnterpriseBaseClass {


    @Test(priority = 1)
    public void alertsTest() {

        try {
            //finding Alerts pop up window
            Driver.findElement(By.xpath("//*[@id=\"splashDiv\"]/div/div/input[2]"));
            Thread.sleep(2000);
            System.out.println("Release notes Alert found");
            //closing alert pop up window
            Driver.findElement(By.xpath("//*[@id=\"splashDiv\"]/div/div/input[2]")).click();

            }catch (Exception e){

            System.out.print("No Release notes Alertfound ");
        }

    }
}









