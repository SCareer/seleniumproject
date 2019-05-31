package com.styleanalytics.enterprise.SharingTests;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class FactorSetReadOnly {

    WebDriver driver;
    FactorSetPage factorSetPage;
    LoginPage loginPage;
    Setup setup;

    @BeforeClass
    public void testSetup() throws Exception {

        setup = new Setup(driver);

        driver=setup.browserSetupToLogin();

        loginPage = new LoginPage(driver);

        loginPage.login();

        factorSetPage = new FactorSetPage(driver);

    }




    @BeforeMethod
    public void accessFactorSet() throws IOException {

        factorSetPage.accessFactorSetLandingPage();

    }

    @Test
    public void createReadOnlyFactorSet() throws Exception {

       //  factorSetPage.createFactorSet("ReadOnlyFactorSet");

        Assert.assertEquals(factorSetPage.verifyFactorSet("ReadOnlyFactorSet") , "ReadOnlyFactorSet");

    }

    @Test
    public void verifyEditButton() throws Exception {

        factorSetPage.searchFactorSet("ReadOnlyFactorSet");

        Assert.assertTrue(factorSetPage.verifyEditButton());
    }


    @Test
    public void verifyDeleteButton() throws Exception {

        factorSetPage.searchFactorSet("ReadOnlyFactorSet");

        Assert.assertTrue(factorSetPage.verifyDeleteButton());
    }


    @Test
    public void verifyYesLink() throws Exception {

        factorSetPage.searchFactorSet("ReadOnlyFactorSet");

        Assert.assertEquals(factorSetPage.verifySharingLinkFromView() ,"No");
    }



    public void editReadOnlyFactorSet() throws Exception {

        factorSetPage.searchFactorSet("ReadOnlyFactorSet");

        factorSetPage.editButtonFrom_View.click();



    }
}
