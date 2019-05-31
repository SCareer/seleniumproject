package com.styleanalytics.enterprise.DispatchAnalysis;

import com.styleanalytics.enterprise.DataDriven.DataDrivenSetup;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.IOException;

public class DispatchFromExplorerTest extends EnterpriseBaseClass {

    private String portfolioName;

    @Factory(dataProvider = "data")
    public DispatchFromExplorerTest(String portfolioName) {

        this.portfolioName = portfolioName;

    }

    @DataProvider
    public static Object[][] data() throws IOException {

        String testDataFile = property("TestData");

        Object[][] arrayObject = DataDrivenSetup.readFromExcel(testDataFile, "PortfolioReports");

        return arrayObject;
    }

    @BeforeClass
    public void dispatchSetup() throws IOException, InterruptedException {

        LogoutTest();

        String user = property("ExistingReportsTestUser");
        String pass = property("ExistingReportsTestUserPass");

        logInAsDiffUser(user, pass);
    }

    @Test
    public void dispatchAnalysisFromExplorerTest() throws Exception {

        DispatchAnalysisHelper dispatchAnalysisHelper = new DispatchAnalysisHelper();
        dispatchAnalysisHelper.fromExplorer(portfolioName);


    }





}
