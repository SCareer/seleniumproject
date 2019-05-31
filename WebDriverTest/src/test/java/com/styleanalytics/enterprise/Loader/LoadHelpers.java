package com.styleanalytics.enterprise.Loader;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadHelpers extends EnterpriseBaseClass{



    public  void loadingFile(String LoadSectionXpath , String SelectXpath, String Filepath , String NextButtonXPath ) throws InterruptedException {


        Driver.findElement(By.xpath(LoadSectionXpath)).click();

        Thread.sleep(4000);

        //File file = new File("D:\\Auto\\new.csv");

        Driver.findElement(By.id(SelectXpath)).sendKeys(Filepath);

        //softAssert.assertTrue(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioDetailsUploaderrow0\"]/input")).isDisplayed());

        WebDriverWait wait = new WebDriverWait(Driver, 120);

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NextButtonXPath)));

        nextButton.click();


    }


}
