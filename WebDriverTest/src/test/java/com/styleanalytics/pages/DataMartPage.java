package com.styleanalytics.pages;

import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class DataMartPage {

    WebDriver driver;

    public void dataMart(String url){

        driver.get(url+"/datamart/datamartselector.aspx");
        Wait.untilJqueryIsDone(driver);
    }


    public DataMartPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }
}
