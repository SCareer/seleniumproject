package com.styleanalytics.enterprise.SharingTests;

import com.styleanalytics.enterprise.Login.LoginPage;

import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.Wait;
import com.styleanalytics.enterprise.utils.ConfirmationPopUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;




public class FactorSetTest{

    WebDriver driver;
    FactorSetPage factorSetPage;
    LoginPage loginPage;
    Setup setup;
    ConfirmationPopUp confirmationPopUp;
    SharingAccessRightsPopup sharingAccessRightsPopup;


    public String FullControlFactorSet = "FullControlFactorSetTest";

    public String ReadOnlyFactorSet = "ReadOnlyFactorSetTest";

    public String NotSharedFactorSet = "NotSharedFactorSetTest";




    @BeforeClass
    public void testSetup() throws Exception {

        setup = new Setup(driver);

        driver=setup.browserSetupToLogin();

        loginPage = new LoginPage(driver);

        loginPage.login();

        factorSetPage = new FactorSetPage(driver);

        confirmationPopUp =  new ConfirmationPopUp(driver);

        sharingAccessRightsPopup = new SharingAccessRightsPopup(driver);

       // factorSetPage.accessFactorSetLandingPage();

    }



    @BeforeMethod
    public void accessFactorSet() throws IOException, InterruptedException {

    factorSetPage.accessFactorSetLandingPage();

    }


    @Test(priority = 1)// creating fullcontrol factor set
    public void createFullControlFactorSetTest() throws Exception {


        if(factorSetPage.isFactorSetPresent(FullControlFactorSet)){
            factorSetPage.clickOnDeleteFactorSet();
            confirmationPopUp.clickOnConfirmPopup();

        }

        factorSetPage.createFactorSet(FullControlFactorSet);

        sharingAccessRightsPopup.setAccessRights("Test","Full Control");

        factorSetPage.clickOnSave();

       Wait.waitForSpinnerToDisappear(driver,10);

       Assert.assertEquals(factorSetPage.verifyFactorSet(FullControlFactorSet) , FullControlFactorSet);

     }


     @Test(priority = 2)  // verifying fullcontrol factor set

      public void verifyFullControlFactorSet() throws Exception {

         factorSetPage.searchFactorSet(FullControlFactorSet);

         Assert.assertTrue(factorSetPage.verifyEditButton());

         Assert.assertTrue(factorSetPage.verifyDeleteButton());

         Assert.assertEquals(factorSetPage.verifySharingLinkFromView() ,"Yes");
     }



     @Test(priority = 3) // Editing Access rights from landing Page

     public void editAccessRightsFromLandingPage() throws Exception {

        factorSetPage.editAccessRightsFromFactorSetLandingPage(FullControlFactorSet);

        sharingAccessRightsPopup.editAccessRightsFromLandingPage("Test","Read Access");

        //factorSetPage.editAccessRightsFromView(FullControlFactorSet , "Test", "Read Access");

        factorSetPage.switchToDefaultContent();

        factorSetPage.searchFactorSet(FullControlFactorSet);

        Assert.assertEquals(factorSetPage.sharingLinkFromView.getText(),"Yes");

    }


     @Test(priority = 6)  // Verifying FactorSet from dropdown list

     public void verifyFactorSetFromDropList() throws Exception {

         factorSetPage.clickOnEditFromView(FullControlFactorSet);

         factorSetPage.searchDropDownArrowButton.click();

         Thread.sleep(3000);

         factorSetPage.searchDropDown.sendKeys(FullControlFactorSet);

         Thread.sleep(3000);

         Assert.assertTrue(factorSetPage.verifyFactorSetFromDropDown(FullControlFactorSet));

     }



     @Test(priority = 7)   // Create Read only factor set

     public void createReadOnlyFactorSet() throws Exception {

         if(factorSetPage.isFactorSetPresent(ReadOnlyFactorSet)){
             factorSetPage.clickOnDeleteFactorSet();
             confirmationPopUp.clickOnConfirmPopup();

         }

         factorSetPage.createFactorSet(ReadOnlyFactorSet);

         sharingAccessRightsPopup.setAccessRights("Test","Read Access");

         factorSetPage.clickOnSave();

         Assert.assertEquals(factorSetPage.verifyFactorSet(ReadOnlyFactorSet) , ReadOnlyFactorSet);


     }



    @Test(priority = 8)  // verify Readonly factor set from landing page

    public void verifyReadOnlyFactorSet() throws Exception {

        factorSetPage.searchFactorSet(ReadOnlyFactorSet);

        Assert.assertTrue(factorSetPage.verifyEditButton());

        Assert.assertTrue(factorSetPage.verifyDeleteButton());

        Assert.assertEquals(factorSetPage.verifySharingLinkFromView() ,"Yes");
    }





    @Test(priority = 9) // Edit Read only factor set  Access rights from landing page
    public void editReadOnlyFactorSetFromLandingPage() throws Exception {

        factorSetPage.editAccessRightsFromFactorSetLandingPage(ReadOnlyFactorSet);

        sharingAccessRightsPopup.setAccessRights("Test", "Full control");

        factorSetPage.clickOnSave();

        factorSetPage.searchFactorSet(ReadOnlyFactorSet);

        Assert.assertEquals(factorSetPage.verifySharingLinkFromView() ,"Yes");

    }




        @Test(priority = 11)  // Create Not shared FactorSet
         public void createNotSharedFactorSet() throws Exception {

            if(factorSetPage.isFactorSetPresent(NotSharedFactorSet)){
                factorSetPage.clickOnDeleteFactorSet();
                confirmationPopUp.clickOnConfirmPopup();

            }

        factorSetPage.createFactorSet(NotSharedFactorSet);

        sharingAccessRightsPopup.setAccessRights("Test", "Not Shared");

        factorSetPage.clickOnSave();

         Assert.assertEquals(factorSetPage.verifyFactorSet(NotSharedFactorSet) , NotSharedFactorSet);

    }


    @Test(priority = 12)  // verify not Shared factor set
    public void verifyNotSharedFactorSet() throws Exception {

        factorSetPage.searchFactorSet(NotSharedFactorSet);

        Assert.assertTrue(factorSetPage.verifyEditButton());

        Assert.assertTrue(factorSetPage.verifyDeleteButton());

        Assert.assertEquals(factorSetPage.verifySharingLinkFromView() ,"No");
    }


    // log in as different user

    // Verify full control factor set

    @Test(priority = 13)
    public void verifyFullcontrolFactorSetByOtherUser() throws Exception {

        setup.LogoutTest();

        loginPage.login("automatedtest3","Test1234%");


        factorSetPage.searchFactorSet(FullControlFactorSet);

        Assert.assertTrue(factorSetPage.verifyEditButton());

        Assert.assertTrue(factorSetPage.verifyDeleteButton());

        Assert.assertEquals(factorSetPage.verifySharingLinkFromView() ,"Yes");


    }

    // log in as different user

    // Edit access rights for full control factor set from landing page


    @Test(priority = 14)
    public void editFullControlFactorSetByOtherUserFromLandingPage() throws Exception {





        factorSetPage.editAccessRightsFromFactorSetLandingPage(FullControlFactorSet);

        sharingAccessRightsPopup.setAccessRights("Test", "Read Access");

        factorSetPage.clickOnSave();

        factorSetPage.searchFactorSet(FullControlFactorSet);

        Assert.assertFalse(factorSetPage.isElementPresent(factorSetPage.editButtonFrom_View));

        Assert.assertFalse(factorSetPage.isElementPresent(factorSetPage.deleteButtonFrom_View));

    }


    // log in as different user

    // Verify Read only factor set by other user

    @Test(priority = 15)
    public void validateReadOnlyFactorSetByOtherUser() throws Exception {



        factorSetPage.searchFactorSetAfterDelete(ReadOnlyFactorSet);

         Assert.assertFalse(factorSetPage.isElementPresent(factorSetPage.editButtonFrom_View));

         Assert.assertFalse(factorSetPage.isElementPresent(factorSetPage.deleteButtonFrom_View));


    }



    //log in as different user

    // Verify Not shared factor set by other user

    @Test(priority = 16)
    public void validateNotSharedSetByOtherUser() throws Exception {


        factorSetPage.searchFactorSetAfterDelete(NotSharedFactorSet);

        Assert.assertFalse(factorSetPage.isElementPresent(factorSetPage.editButtonFrom_View));

        Assert.assertFalse(factorSetPage.isElementPresent(factorSetPage.deleteButtonFrom_View));

    }


    @AfterClass
     public void tearDown(){

         driver.quit();
     }

}
