package com.styleanalytics.sumo;

import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.ParseException;

public class SumoTest extends TestBase {

    SoftAssert softAssert;
    SumoPage sumoPage;

    @BeforeClass
    public void testSetup() throws IOException {

        sumoPage = new SumoPage(getDriver());
        softAssert = new SoftAssert();
        sumoPage.getLoginPage();
        sumoPage.login();
    }
    @Test
    public void verifyEndToEndTest() throws ParseException {

        sumoPage.newSearchByID(11024466);
        int waitingForData = sumoPage.getResultsFromColumn(2);
        int rowCount = sumoPage.getRowCount();
        softAssert.assertTrue(waitingForData<rowCount,"Jobs sitting in waiting for data");

        int failed = sumoPage.getResultsFromColumn(3);
        softAssert.assertTrue(failed==0,"Jobs are Failed");

        int completed = sumoPage.getResultsFromColumn(4);
        softAssert.assertTrue(completed==(rowCount*2769),"Completed Analysis count mismatch");

        softAssert.assertAll();
    }
}
