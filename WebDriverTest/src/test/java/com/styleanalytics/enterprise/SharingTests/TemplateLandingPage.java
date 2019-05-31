package com.styleanalytics.enterprise.SharingTests;

import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.enterprise.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.PageFactory.initElements;

public class TemplateLandingPage {


    WebDriver driver;

    //Factor set home page

    @FindBy(xpath = "//input[contains(@id,'ctl00_mainContentPlaceHolder_cmdShowNew_input')]")
    WebElement createNewTemplate_btn;

    @FindBy(xpath = "//a[contains(text(),'Portfolio PDF')]")
    WebElement portfolioPDF;

    @FindBy(xpath = "//a[contains(text(),'Portfolio PowerPoint')]")
    WebElement portfolioPPT;

    @FindBy(xpath = "//a[contains(text(),'Portfolio Image Template')]")
    WebElement portfolioImg;

    @FindBy(xpath = "//a[contains(text(),'Portfolio Excel Template')]")
    WebElement portfolioExcel;

    @FindBy(xpath = "//a[contains(text(),'Portfolio XML Template')]")
    WebElement portfolioXML;

    @FindBy(xpath = "//a[contains(text(),'Peer Insights PDF')]")
    WebElement peerInsightsPDF;

    @FindBy(xpath = "//a[contains(text(),'Peer Insights PowerPoint')]")
    WebElement peerInsightsPPT;

    @FindBy(xpath = "//a[contains(text(),'Legacy Portfolio PDF')]")
    WebElement legacyPDF;


    @FindBy(xpath = "//a[contains(@class,'sgButtonGreen')]")
    WebElement view_btn;

    @FindBy(xpath = "//a[contains(@class,'sgButtonRed')]")
    WebElement deleteButton;

    @FindBy(xpath = "//div[@class='ui-state-default slick-headerrow-column l0 r0']//input[@type='text']")
    WebElement templateNameSearchBox;

    @FindBy(xpath = "//div[@class='ui-state-default slick-headerrow-column l1 r1']//input[@type='text']")
    WebElement docTypeSearchBox;

    @FindBy(xpath = "//div[@class='ui-state-default slick-headerrow-column l4 r4']//input[@type='text']")
    WebElement userSearchBox;

    @FindBy(xpath = "//a[contains(@class,'gridLink')]")
    WebElement onTemplate;

    //pdf template Creation page

    @FindBy(id = "ctl00_mainContentPlaceHolder_cmdSave_input")
    WebElement saveButton;

    @FindBy(id = "ctl00_mainContentPlaceHolder_cmdPreview_input")
    WebElement previewButton;

    @FindBy(id = "ctl00_mainContentPlaceHolder_cmdClose_input")
    WebElement closeButton;

    @FindBy(xpath = "//input[contains(@id,'templateName')]")
    WebElement templateName_input;

    @FindBy(xpath = "//input[contains(@id,'pageName')]")
    WebElement pageName_input;

    @FindBy(xpath = "//div[contains(@class,'slidingSettingsHeader')]")
    WebElement templateSettingsHeader;

    @FindBy(xpath = "//div[contains(@class,'radButton accessRightsButton')]")
    WebElement templateEditButton;


    public void templatesLandingPage() throws IOException {

        String url = Setup.property("URL");

        driver.get(url+"/Reporting/BlockTemplateList.aspx");

        Wait.forGridToLoad(driver,15);
    }

    public void clickOnView(){

        view_btn.click();
    }

    public void setNewTemplate(String templateType){

        createNewTemplate_btn.click();

        if(templateType.equalsIgnoreCase("PDF")){
            portfolioPDF.click();
        }else if(templateType.equalsIgnoreCase("PPT")){
            portfolioPPT.click();
        }else if(templateType.equalsIgnoreCase("Image")){
            portfolioImg.click();
        }else if(templateType.equalsIgnoreCase("Excel")){
            portfolioExcel.click();
        }else if(templateType.equalsIgnoreCase("XML")){
            portfolioXML.click();
        }else if(templateType.equalsIgnoreCase("PIPDF")){
            peerInsightsPDF.click();
        }else if(templateType.equalsIgnoreCase("PIPPT")){
            peerInsightsPPT.click();
        }else if(templateType.equalsIgnoreCase("legacyPDF")){
            legacyPDF.click();
        }

    }


    public void deleteTemplate(String templateName) throws IOException, InterruptedException {

        templatesLandingPage();
        Wait.waitForElementToDisplay(driver,templateNameSearchBox,10);
        templateNameSearchBox.sendKeys(templateName);
        deleteButton.click();
        confirmDelete();

    }

    public Boolean searchAndVerifyTemplate(String templateName){

        templateNameSearchBox.sendKeys(templateName);
        try {
            driver.findElement(By.xpath(" //a[contains(text(),'" + templateName + "')]"));
            return true;
        }catch (Exception e){

            return false;
        }
    }

    public void confirmDelete() throws InterruptedException {

        driver.switchTo().frame(0);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        driver.findElement(By.cssSelector(".rwInnerSpan")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
    }

    public TemplateLandingPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        initElements(driver, this);

    }





}
