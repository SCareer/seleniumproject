package com.styleanalytics.enterprise;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataProvider extends EnterpriseBaseClass {


    private String user;
    private String pass;


   @Factory(dataProvider = "data")
    public DataProvider(String user,String pass) {

        this.user = user;
        this.pass = pass;

    }

    @org.testng.annotations.DataProvider
    public static Object[][] data() {

    return new Object[][] {{"viswanath.selvaraj@styleresearch.com ","Test1234%"},{"antony.gilbert@styleresearch.com","Test1234%"}};

    }



    @Test
    public void login() throws Exception {

        browserSetup();

        environment();

        Thread.sleep(3000);

        //Get the user details from config file

        try {
            Driver.findElement(By.xpath("//*[@id='UserLogin_UserName']")).sendKeys(user);
        }catch (NoSuchElementException e){

            Driver.quit();
            browserSetup();
            environment();
            Driver.findElement(By.xpath("//*[@id='UserLogin_UserName']")).sendKeys(user);
        }
        Driver.findElement(By.xpath("//*[@id='UserLogin_Password']")).sendKeys(pass);
        Driver.findElement(By.xpath("//*[@id='UserLogin_LoginButton']")).click();

        Thread.sleep(3000);

        System.out.println("Logged in to Enterprise");
        try {
            //turnOffImplicitWaits();
            WebElement splashScreen = Driver.findElement(By.xpath("//*[@id=\"splashDiv\"]/div/div/input[2]"));
            if (splashScreen.isDisplayed()) {

                Driver.findElement(By.xpath("//*[@id=\"splashDiv\"]/div/div/input[1]")).click();



            } else System.out.println("SplashScreen Not Found");
        } catch (Exception e){

        }
       // turnOnImplicitWaits();
    }



    }



