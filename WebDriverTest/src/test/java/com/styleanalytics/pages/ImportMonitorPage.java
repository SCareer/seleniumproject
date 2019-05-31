package com.styleanalytics.pages;

import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportMonitorPage {

    WebDriver driver;

    @FindBy(id="ctl00_mainContentPlaceHolder_radToolbarPortfolios_i1_periodSelector_rblPeriodType_0")
    WebElement last24Hrs;

    @FindBy(id="ctl00_mainContentPlaceHolder_radToolbarPortfolios_i1_periodSelector_rblPeriodType_1")
    WebElement last7Days;

    @FindBy(id="ctl00_mainContentPlaceHolder_radToolbarPortfolios_i1_periodSelector_rblPeriodType_2")
    WebElement lastMonth;

    @FindBy(id="ctl00_mainContentPlaceHolder_radToolbarPortfolios_i1_periodSelector_rblPeriodType_3")
    WebElement customDate;

    @FindBy(xpath="//span[contains(text(),'Refresh')]")
    WebElement refresh;



    public void goToImportMonitorPage(String url) throws InterruptedException {

        driver.get(url+"/Automation/ImportMonitor.aspx");
        Wait.waitForElementToDisplay(driver,last24Hrs,20);

    }


    public ImportMonitorPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }
}
