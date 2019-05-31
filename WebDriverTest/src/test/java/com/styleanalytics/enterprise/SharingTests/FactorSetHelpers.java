package com.styleanalytics.enterprise.SharingTests;

import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class FactorSetHelpers extends com.styleanalytics.enterprise.SharingTests.FactorSetPage {


    public com.styleanalytics.enterprise.SharingTests.FactorSetPage FactorSetPage;

    public FactorSetHelpers(WebDriver Driver)
    {
        super(Driver);
    }


    @Test
    public void createFactorSet(int i, String FactorSetName) throws Exception {

        //clickO();

        Utility.waitForElementToDisplay(saveButton, 10);

        enterName(FactorSetName);

        selectFactors();

       // openAccessRightsWindow();

        Utility.waitForElementToDisplay(saveButton_popUp, 10);

        selectRadioButton(i);

        clickSaveFromPopUp();

        switchToDefaultContent();

        clickOnSave();

        searchFactorSet(FactorSetName);

        }



      public void selectFactors(String FactorSetName){

          factorSetDropDown.clear();

          factorSetDropDown.sendKeys("FactorSetName");

          List<WebElement> factorSetList = driver.findElements(By.xpath("//a[contains(text(),'add')]"));

          factorSetList.get(0).click();
      }



}







