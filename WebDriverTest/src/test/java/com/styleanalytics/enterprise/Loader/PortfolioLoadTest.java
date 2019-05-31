package com.styleanalytics.enterprise.Loader;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.setup.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PortfolioLoadTest extends TestBase {

    DateFormat dateFormat = new SimpleDateFormat("d/MM/YY hh:mm:ss");
    Date date = new Date();

    @BeforeClass
    public void loadSetup() throws IOException {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();

        }

    @Test
    public void loadPortfolioWithRunTimeName() throws IOException, InterruptedException {

        LoadPage loadPage = new LoadPage(getDriver());
        String file = property("loadFile");

        try {

            loadPage.loadPortfolioWithSpecifyNameOnRuntime(file, " " + dateFormat.format(date) + " - Sanity automation");

        }catch (Exception e){

            e.printStackTrace();

            takeScreenShotOnFailure("Loader");

            Assert.fail("Portfolio Load Failed");
        }
    }
}
