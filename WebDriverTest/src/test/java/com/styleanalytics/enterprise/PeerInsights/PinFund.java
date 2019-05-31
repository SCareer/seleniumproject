package com.styleanalytics.enterprise.PeerInsights;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 29/05/2018.
 */
public class PinFund extends TestBase {


    @BeforeClass
    public void testSetup() throws IOException {

        GoTo.peerInsights();

    }
    @Test
    public void openPIReport() throws IOException, InterruptedException {

       // PeerInsightsTest peerInsightsTest =new PeerInsightsTest();
       // peerInsightsTest.openExistingReport();
        PeerInsightsPage peerInsightsPage = new PeerInsightsPage(getDriver());
        peerInsightsPage.openReport.click();

        //Utility.waitForElementToLoad("//h2[@class='mainHeader']");

        peerInsightsPage.rightSideMenu.click();

    }


}
