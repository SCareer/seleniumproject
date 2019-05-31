package com.styleanalytics.pages;

import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PortfolioLabelsPage {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='rtbText'][contains(text(),'Label')]")
    WebElement labelsDropdown;

    @FindBy(xpath = "//span[@class='rtbText'][contains(text(),'New...')]")
    WebElement createNew;

    @FindBy(xpath = "//span[@class='rtbText'][contains(text(),'Delete')]")
    WebElement delete;

    @FindBy(id = "ctl00_mainContentPlaceHolder_tagEditWindow_C_portfolioTagEditContent_radTextBoxTag")
    WebElement newLabelTextBox;

    @FindBy(id = "ctl00_mainContentPlaceHolder_tagEditWindow_C_portfolioTagEditContent_btnSave_input")
    WebElement save_btn;

    @FindBy(xpath = " //span[@class='rwInnerSpan'][contains(text(),'Close')]")
    WebElement close_btn;




    public void setLabelsDropdown() {

        Wait.waitForElementToDisplay(driver,labelsDropdown,60);
        labelsDropdown.click();
    }

    public void setCreateNew() throws InterruptedException {

        Thread.sleep(3000);
        createNew.click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();

    }

    public void setDelete() throws InterruptedException {

        Thread.sleep(3000);
        delete.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        driver.navigate().refresh();

    }

    public void setNewLabelTextBox(String labelName) {

        Wait.waitForElementToDisplay(driver,newLabelTextBox,60);
        newLabelTextBox.sendKeys(labelName);

    }

    public void setSave_btn() {

        save_btn.click();

    }

    public void setClose_btn(){

        Wait.waitForElementToDisplay(driver,close_btn,60);
        close_btn.click();
    }


    public void createLabel(String labelName) throws Exception {
        try {
            setLabelsDropdown();
            setCreateNew();
            setNewLabelTextBox(labelName);
            setSave_btn();
            setClose_btn();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Failed to Create Label");
        }


    }

    public void deleteLabel() throws Exception {
        try {
            setLabelsDropdown();
            setDelete();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Failed to Delete Label");
        }

    }

    public PortfolioLabelsPage(WebDriver driver){

        this.driver = driver;
        initElements(driver, this);

    }

}
