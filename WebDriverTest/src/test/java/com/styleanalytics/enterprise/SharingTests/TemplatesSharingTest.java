package com.styleanalytics.enterprise.SharingTests;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.TemplateBuilder.ExcelTemplatePage;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TemplatesSharingTest {


    WebDriver driver;
    Setup setup;
    LoginPage loginPage;
    TemplateLandingPage templateLandingPage;
    ExcelTemplatePage excelTemplatePage;
    SharingAccessRightsPopup sharingAccessRightsPopup;
    private String fullControlTemplateName ="Excel Template Sharing - Full Control";
    private String readAccessTemplateName ="Excel Template Sharing - Full Control";
    private String notSharedTemplateName ="Excel Template Sharing - Full Control";

    @BeforeClass
    public void testSetup() throws Exception {

        setup = new Setup(driver);
        driver = setup.browserSetupToLogin();
        loginPage = new LoginPage(driver);
        loginPage.login();
        templateLandingPage = new TemplateLandingPage(driver);
        excelTemplatePage = new ExcelTemplatePage(driver);
        sharingAccessRightsPopup = new SharingAccessRightsPopup(driver);

    }
    @Test(priority = 1)
    public void templateSharingFullControlTest() throws IOException, InterruptedException {

        templateLandingPage.templatesLandingPage();

        if(templateLandingPage.searchAndVerifyTemplate(fullControlTemplateName)){

            templateLandingPage.deleteTemplate(fullControlTemplateName);
        }

        templateLandingPage.setNewTemplate("Excel");
        excelTemplatePage.setTemplateName(fullControlTemplateName);
        excelTemplatePage.selectWidgets();
        sharingAccessRightsPopup.setAccessRights("Test","Full Control");
        excelTemplatePage.setSave();

        Assert.assertTrue(templateLandingPage.searchAndVerifyTemplate(fullControlTemplateName),"Template Created Not Found");


    }

    @Test(priority = 2)
    public void templateSharingReadAccessTest() throws IOException, InterruptedException {

        templateLandingPage.templatesLandingPage();

        if(templateLandingPage.searchAndVerifyTemplate(readAccessTemplateName)){

            templateLandingPage.deleteTemplate(readAccessTemplateName);
        }

        templateLandingPage.setNewTemplate("Excel");
        excelTemplatePage.setTemplateName(readAccessTemplateName);
        excelTemplatePage.selectWidgets();
        sharingAccessRightsPopup.setAccessRights("Test","Read Access");
        excelTemplatePage.setSave();

        Assert.assertTrue(templateLandingPage.searchAndVerifyTemplate(readAccessTemplateName),"Template Created Not Found");


    }

    @Test(priority = 2)
    public void templateSharingNotSharedTest() throws IOException, InterruptedException {

        templateLandingPage.templatesLandingPage();

        if(templateLandingPage.searchAndVerifyTemplate(notSharedTemplateName)){

            templateLandingPage.deleteTemplate(notSharedTemplateName);
        }

        templateLandingPage.setNewTemplate("Excel");
        excelTemplatePage.setTemplateName(notSharedTemplateName);
        excelTemplatePage.selectWidgets();
        sharingAccessRightsPopup.setAccessRights("Test","Not Shared");
        excelTemplatePage.setSave();

        Assert.assertTrue(templateLandingPage.searchAndVerifyTemplate(notSharedTemplateName),"Template Created Not Found");


    }

    @Test
    public void verifyTemplateSharingFullControlTest() throws Exception {

        setup.LogoutTest();
        loginPage.login("automatedtest3","Test1234%");
        templateLandingPage.templatesLandingPage();

        if(!templateLandingPage.searchAndVerifyTemplate(notSharedTemplateName)){

            throw new Exception("Shared Full control template not found in the other user");
        }

        templateLandingPage.clickOnView();
        Assert.assertTrue(sharingAccessRightsPopup.getAccessRights("Test","Full Control"),"Access Rights Selection is incorrect");



    }

    @AfterClass
    public void tDown(){

        driver.quit();
    }





}
