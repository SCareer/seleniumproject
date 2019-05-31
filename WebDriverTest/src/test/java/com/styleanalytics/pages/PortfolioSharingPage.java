package com.styleanalytics.pages;

import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PortfolioSharingPage {

    WebDriver driver;

    @FindBy(xpath = " //span[contains(text(),'Share')]")
    WebElement shareDropdown;

    @FindBy(xpath = "//span[@class='rtbText'][contains(text(),'New...')]")
    WebElement createNew;

    @FindBy(xpath = "//span[@class='rtbText'][contains(text(),'Delete')]")
    WebElement delete;

    @FindBy(id = "ctl00_mainContentPlaceHolder_sharingEditWindow_C_portfolioSharingEdit_radButtonTrusteeTypeAllUsers")
    WebElement everyone;

    @FindBy(id = "ctl00_mainContentPlaceHolder_sharingEditWindow_C_portfolioSharingEdit_divUserGroups")
    WebElement specificGroup;

    @FindBy(id = "ctl00_mainContentPlaceHolder_sharingEditWindow_C_portfolioSharingEdit_radButtonTrusteeTypeUser")
    WebElement individualUsers;

    @FindBy(id = "ctl00_mainContentPlaceHolder_sharingEditWindow_C_portfolioSharingEdit_radButtonAccessTypeRead")
    WebElement readAccess;

    @FindBy(id = "ctl00_mainContentPlaceHolder_sharingEditWindow_C_portfolioSharingEdit_radButtonAccessTypeModify")
    WebElement modifyAccess;

    @FindBy(id = "ctl00_mainContentPlaceHolder_sharingEditWindow_C_portfolioSharingEdit_radButtonAccessTypeFullControl")
    WebElement fullControlAcceess;

    @FindBy(id = "ctl00_mainContentPlaceHolder_sharingEditWindow_C_portfolioSharingEdit_btnSave")
    WebElement save_btn;

    @FindBy(xpath = "//span[contains(@class,'rwInnerSpan')][contains(text(),'Close')]")
    WebElement close_btn_alertPopup;

    @FindBy(id = "ctl00_mainContentPlaceHolder_ExploreDetail_Sharing_gridSharing_radGridPortfolioSharing_ctl00_ctl02_ctl00_CheckboxSelectColumnSelectCheckBox")
    WebElement selectAll;

    @FindAll(@FindBy( xpath = "//table[@id='ctl00_mainContentPlaceHolder_ExploreDetail_Sharing_gridSharing_radGridPortfolioSharing_ctl00']//tbody"))
    List<WebElement> sharesGrid;





    public void setShareDropdown() {

        Wait.waitForElementToDisplay(driver,shareDropdown,10);
        shareDropdown.click();

    }

    public void setCreateNew() throws InterruptedException {

        Thread.sleep(3000);
        createNew.click();
        driver.switchTo().defaultContent();
        Wait.waitForElementToDisplay(driver,everyone,60);

    }

    public int getSharesGridCount(){

        int count = sharesGrid.size();
        return count;

    }

    public void setEveryone() {

        everyone.click();

    }

    public void setSelectAll() {

        selectAll.click();
    }

    public void setDelete() throws InterruptedException {

        Thread.sleep(3000);
        delete.click();
        driver.navigate().refresh();
    }

    public void setSpecificGroup() {

    }

    public void setIndividualUsers() {

    }

    public void setReadAccess() {

        readAccess.click();

    }

    public void setModifyAccess() {

        modifyAccess.click();

    }

    public void setFullControlAcceess() {

        fullControlAcceess.click();

    }

    public void setSave_btn() {

        save_btn.click();

    }

    public void setClose_btn_alertPopup(){
        Wait.waitForElementToDisplay(driver,close_btn_alertPopup,10);
        close_btn_alertPopup.click();
    }

    public void createShare() throws Exception {
        try {
            setShareDropdown();
            setCreateNew();
            setFullControlAcceess();
            setSave_btn();
            setClose_btn_alertPopup();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Failed to Create Share");
        }

    }

    public void deleteShare() throws Exception {

        try {
            //setSelectAll();
            setShareDropdown();
            setDelete();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Failed to Delete Share");
        }

    }


    public PortfolioSharingPage(WebDriver driver){

        this.driver = driver;
        initElements(driver, this);

    }

}
