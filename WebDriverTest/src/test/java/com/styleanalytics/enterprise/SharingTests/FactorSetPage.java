package com.styleanalytics.enterprise.SharingTests;

import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;


public class FactorSetPage {


    WebDriver driver;

    //Factor set home page

    @FindBy(xpath = "//input[contains(@id, 'ctl00_mainContentPlaceHolder_cmdCreateNew_input')]")
    WebElement createNew_Btn;

    @FindBy(xpath = "//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")
    WebElement searchByName;

    @FindBy(xpath = "//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div/div[1]")
    WebElement factorSetName;

    @FindBy(xpath = "//a[contains(@class,'sgButtonGreen')]")
    WebElement editButtonFrom_View;

    @FindBy(xpath = "//a[contains(@class,'sgButtonRed')]")
    WebElement deleteButtonFrom_View;


    @FindBy(xpath = "//*[@id=\"divFactors\"]/div[1]/a")
    WebElement selectFactorsonCreate;


    @FindBy(xpath = "//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div/div[4]/a")
    WebElement sharingLinkFromView;

    @FindBy(xpath = "//span[@class='accessRightsLabel']")
    WebElement sharedWithText;


    //Create Factor Screen

    @FindBy(xpath = "//input[contains(@id, 'txtName')]")
    WebElement nameInputBox;

    @FindBy(xpath = "//input[contains(@value,'Edit')]")
    WebElement editButtonFrom_EditView;

    @FindBy(id = "ctl00_mainContentPlaceHolder_cmdSaveFactorSet_input")
    WebElement saveButton;

    @FindBy(xpath = "//input[contains(@id, 'ctl00_mainContentPlaceHolder_cmdSaveAsFactorSet_input')]")
    WebElement saveAsButton;

    @FindBy(xpath = "//input[contains(@id, 'ctl00_mainContentPlaceHolder_cmdCancelFactorSet_input')]")
    WebElement cancelButton;

    @FindBy(xpath = "//input[contains(@id, 'ctl00_mainContentPlaceHolder_fss_ddlDefaults_Input')]")
    WebElement factorSetDropDown;

    @FindBy(id = "ctl00_mainContentPlaceHolder_butSave_input")
    WebElement saveAccessButton;

    @FindBy(xpath = "///div[contains(@class,'chartLoading')]")
    WebElement factorSetEditPageSpinner;




    @FindBy(xpath = "//a[contains(text(),'add')]")
    WebElement selectFactorsFromList;

    // pop up

    @FindBy(xpath = "//input[contains(@id,'ctl00_mainContentPlaceHolder_butSave_input')]")
    WebElement saveButton_popUp;

    @FindBy(xpath = "//input[contains(@id,'ctl00_mainContentPlaceHolder_butCancel_input')]")
    WebElement cancelButton_popUp;

    @FindBy(xpath = "//input[contains(@class,'rwCloseButton')]")
    WebElement closePopUp;


    @FindBy(xpath = " //*[@id=\"tableRoles\"]/tbody/tr[1]/td[4]/input")
    WebElement fullControlRadioButton;

    @FindAll(@FindBy(xpath = " //*[@id=\"tableRoles\"]/tbody/tr"))
    List<WebElement> tRow;

    //*[@id="tableRoles"]/tbody/tr[1]/td[3]/input
    @FindBy(xpath = " //*[@id=\"tableRoles\"]/tbody/tr[1]/td[3]/input")
    WebElement readOnlylRadioButton;


    @FindBy(xpath = "//div[contains(text(),'Yes')]")
    WebElement yesSharingLink;


    //Edit view

    @FindBy(xpath = "//label[contains(text(),'Sharing:')]")
    WebElement sharingLable;

    @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_fss_ddlDefaults_Input\"]")
    WebElement selectFactorSetDropDown;

    @FindBy(xpath = "//li[@class='rcbHovered rcbTemplate']//a[@class='sgButtonGreen'][contains(text(),'select')]")
    WebElement selectButtonFactorSetDropDown;

    @FindBy(xpath = "//div[contains(@class,'chartLoading2')]")
    WebElement templatesGridLoader;


    @FindBy(id = "ctl00_mainContentPlaceHolder_fss_ddlDefaults_Arrow")
    WebElement searchDropDownArrowButton;


    @FindBy(id = "ctl00_mainContentPlaceHolder_fss_ddlDefaults_Input")
    WebElement searchDropDown;




    public void clickOnCreateButton() {

        createNew_Btn.click();
    }

    public void enterName(String FactorSetName) {

        nameInputBox.clear();

        nameInputBox.sendKeys(FactorSetName);
    }


    public void selectFactors() {

        selectFactorsonCreate.click(); // selecting factors
    }


    public void searchFactorSet(String FactorSetName) throws Exception {

        searchByName.sendKeys(FactorSetName);
        try {
            factorSetName.getText().equalsIgnoreCase(FactorSetName);
            factorSetName.isDisplayed();

        } catch (Exception e) {

            throw new Exception("No factor displayed");
        }


    }

    public Boolean isFactorSetPresent(String FactorSetName) throws Exception {
        try {

            searchByName.sendKeys(FactorSetName);

            factorSetName.getText().equalsIgnoreCase(FactorSetName);
            factorSetName.isDisplayed();

            return true;

        } catch (Exception e) {

           return false;
        }


    }


    public void searchFactorSetAfterDelete(String FactorSetName) throws Exception {

        searchByName.sendKeys(FactorSetName);

    }


    public void clickOnEditFromView(String FactorSetName) throws Exception {

        searchFactorSet(FactorSetName);

        editButtonFrom_View.click();

        Wait.waitForElementToDisappear(driver, 10, factorSetEditPageSpinner);


    }

    public void clickOnDeleteFactorSet() {

        deleteButtonFrom_View.click();

    }

    public boolean isElementPresent(WebElement element) {

        try {
            element.isDisplayed();

            return true;

        } catch (Exception e) {

            System.out.print("Not Prestent" + e);
            return false;
        }

    }


    public void clickOnSave() {

        saveButton.click();

    }

    public void selectRadioButton(int i) {

        List<WebElement> allRadios = tRow.get(i).findElements(By.tagName("input"));

        allRadios.get(i).click();

    }

    public void selectAccessRadioButton(int row, int column) {

        List<WebElement> allRadios = tRow.get(row).findElements(By.tagName("td"));

        allRadios.get(column).click();

    }


    public void switchToFrame() {

        driver.switchTo().frame(0);

    }

    public void switchToDefaultContent() {

        driver.switchTo().defaultContent();


    }


    public void clickSaveFromPopUp() {

        saveButton_popUp.click();

    }


    public void accessFactorSetLandingPage() throws IOException {

        Setup setup = new Setup(driver);

        String url = setup.property("URL");

        driver.get(url + "/analysis/factorsetlist.aspx");

        Wait.waitForElementToDisappear(driver, 10, templatesGridLoader);

    }


    public void createFactorSet(String FactorSetName)  {


        clickOnCreateButton();

        Wait.waitForElementToDisappear(driver, 10, factorSetEditPageSpinner);

        enterName(FactorSetName);

        selectFactorsonCreate.click();


    }


    public void editAccessRightsFromFactorSetLandingPage(String FactorSetName) throws Exception {


        searchFactorSet(FactorSetName);

        sharingLinkFromView.click();


    }


    public void deleteFactorset() {

        clickOnDeleteFactorSet();

        switchToFrame();

    }


    public void saveAccessRights() {

        saveAccessButton.click();
    }


    public boolean verifyEditButton() {

        editButtonFrom_View.isDisplayed();

        return true;

    }



    public String verifySharedWith(){

      return sharedWithText.getText();
    }


    public boolean verifyDeleteButton() {

        deleteButtonFrom_View.isDisplayed();

        return true;

    }


    public String verifySharingLinkFromView() {

        return sharingLinkFromView.getText();

    }


    public String verifyFactorSet(String FactorSetName) throws Exception {

        searchFactorSet(FactorSetName);

        return factorSetName.getText();


    }


    public boolean verifySharingLable() {

        return sharingLable.isDisplayed();
    }

    public boolean verifyNameInputBox() {

        return nameInputBox.isDisplayed();
    }


    public boolean verifyFactorSetDropdown() {

        return factorSetDropDown.isDisplayed();
    }


    public boolean verifyFactorSetFromDropDown(String factorSetName) {

        return driver.findElement(By.xpath("//em[contains(text()," + factorSetName + ")]")).isDisplayed();
    }


    public FactorSetPage(WebDriver driver) {

        this.driver = driver;

        initElements(driver, this);

    }

}

