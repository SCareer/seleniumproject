package com.styleanalytics.enterprise.TemplateBuilder;

import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.SharingTests.TemplateLandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;


import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ExcelTemplatePage {


    WebDriver driver;

    @FindBy(id = "ctl00_mainContentPlaceHolder_txtTemplateName")
    WebElement excelTemplateNameInput;

    @FindAll(@FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_tvTemplate\"]/ul/li"))
    List<WebElement> widgetList;

    @FindBy(id="ctl00_mainContentPlaceHolder_dialogSave_input")
    WebElement save;

    @FindBy(id="ctl00_mainContentPlaceHolder_cmdSaveAs_input")
    WebElement saveAs;

    @FindBy(id="ctl00_mainContentPlaceHolder_dialogcancel_input")
    WebElement cancel;


    public void setSave() {
        save.click();
    }

    public void setSaveAs() {
        saveAs.click();
    }

    public void setCancel() {
        cancel.click();
    }

    public void setTemplateName(String templateName){

        excelTemplateNameInput.sendKeys(templateName);

    }

    public void selectWidgets(){

        for(int i=0;i<widgetList.size();i++){

            List<WebElement> checkBox = widgetList.get(i).findElements(By.tagName("span"));

            checkBox.get(2).click();
        }

    }

    public ExcelTemplatePage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        initElements(driver, this);

    }





}
