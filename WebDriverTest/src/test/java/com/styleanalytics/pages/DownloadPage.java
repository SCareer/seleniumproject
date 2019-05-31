package com.styleanalytics.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class DownloadPage {

    WebDriver driver;

    @FindBy(id="")
    WebElement dashboard;

    @FindBy(id = "")
    WebElement marketAnalyzer_btn;

    @FindBy(xpath = "")
    WebElement peerInsights_btn;

    public void downloadReportFromReportsPage(String templateName) throws InterruptedException, IOException {

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtFilter']")).sendKeys(templateName);
        driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdFilter_input']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='"+templateName+"']")).click();

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".rwCloseButton")).click();

    }

    public void openDownloadsPopup() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@id='rhsHamb']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
        Thread.sleep(3000);
    }

    public DownloadPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);


    }
}
