package com.styleanalytics.enterprise.SharingTests;

import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SharingAccessRightsPopup {

    WebDriver driver;

    @FindAll(@FindBy(xpath = " //*[@id=\"tableRoles\"]/tbody/tr"))
    List<WebElement> tRow;

    @FindBy(xpath = "//*[@id=\"shareTemplateButton\"]/input")
    WebElement editButtonFrom_EditView;

    @FindBy(id = "ctl00_mainContentPlaceHolder_butSave_input")
    WebElement saveAccessButton;

    @FindBy(xpath = "//*[@id=\"groups\"]/div")
    WebElement accessRightPopUpSpinner;

    @FindBy(xpath = "//td[contains(@class,'rwWindowContent rwExternalContent rwLoading')]")
    WebElement accessRightSquareBox;


    public void setAccessRights(String userGroup, String accessRights) throws InterruptedException {


        accessRightWindowFromEdit();

        for(int i=0;i<tRow.size();i++){

            if(tRow.get(i).getText().equalsIgnoreCase(userGroup)){

                if(accessRights.equalsIgnoreCase("Not Shared")){
                    setAccessRadioButton(i,1);
                }else if(accessRights.equalsIgnoreCase("Read Access")){
                    setAccessRadioButton(i,2);
                }else if(accessRights.equalsIgnoreCase("Full Control")){
                    setAccessRadioButton(i,3);
                }else {
                    System.out.println("Access Rights Keyword --"+accessRights+" Not Valid");
                }
            }else{

                System.out.println("User Group Name --"+userGroup+" Not Valid");
            }
        }

        saveAccessRights();


    }

    public Boolean getAccessRights(String userGroup, String accessRights) throws InterruptedException {

        accessRightWindowFromEdit();

        Boolean isSelected=null;

        for(int i=0;i<tRow.size();i++){

            if(tRow.get(i).getText().equalsIgnoreCase(userGroup)) {

                if (accessRights.equalsIgnoreCase("Not Shared")) {
                    isSelected = getAccessRightsRadioButton(i, 1);
                } else if (accessRights.equalsIgnoreCase("Read Access")) {
                    isSelected= getAccessRightsRadioButton(i, 2);
                } else if (accessRights.equalsIgnoreCase("Full Control")) {
                     isSelected=getAccessRightsRadioButton(i, 3);
                } else {
                    System.out.println("Access Rights Keyword --" + accessRights + " Not Valid");
                    isSelected=false;
                }
                break;
            }else{

                System.out.println("User Group Name --"+userGroup+" Not Valid");
                isSelected=false;
            }

        }
        saveAccessRights();
        return isSelected;
    }



    public Boolean getAccessRightsRadioButton(int row, int column){


        List<WebElement> allRadios = tRow.get(row).findElements(By.tagName("td"));
        System.out.println(allRadios.size());

        String isSelected = allRadios.get(column).getAttribute("name");

        System.out.println(isSelected+" Hello");

        if(isSelected.equalsIgnoreCase("checked")){
            return true;
        }else {
            return false;
        }

    }






    public void editAccessRightsFromLandingPage(String userGroup, String accessRights) throws InterruptedException {

        Wait.waitForElementToDisappear(driver, 10, accessRightSquareBox);

        driver.switchTo().frame(0);

        Wait.waitForElementToDisappear(driver, 10, accessRightPopUpSpinner);

        for(int i=0;i<tRow.size();i++){

            if(tRow.get(i).getText().equalsIgnoreCase(userGroup)){

                if(accessRights.equalsIgnoreCase("Not Shared")){
                    setAccessRadioButton(i,1);
                }else if(accessRights.equalsIgnoreCase("Read Access")){
                    setAccessRadioButton(i,2);
                }else if(accessRights.equalsIgnoreCase("Full Control")){
                    setAccessRadioButton(i,3);
                }else {
                    System.out.println("Access Rights Keyword --"+accessRights+" Not Valid");
                }
            }else{

                System.out.println("User Group Name --"+userGroup+" Not Valid");
            }
        }

        saveAccessRights();
    }



    public void accessRightWindowFromEdit() throws InterruptedException {

        editButtonFrom_EditView.click();

        Wait.waitForElementToDisappear(driver,10,accessRightSquareBox);

        driver.switchTo().frame(0);

        Wait.waitForElementToDisappear(driver,10,accessRightPopUpSpinner);

    }

    public void setAccessRadioButton(int row, int column) {

        List<WebElement> allRadios = tRow.get(row).findElements(By.tagName("td"));

        allRadios.get(column).click();

    }

    public void saveAccessRights(){

        saveAccessButton.click();
        driver.switchTo().defaultContent();
    }



    public SharingAccessRightsPopup(WebDriver driver) {

        this.driver = driver;

        initElements(driver, this);

    }
}
