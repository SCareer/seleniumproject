package com.styleanalytics.enterprise.AnalysisPages;

import com.styleanalytics.enterprise.DataDriven.DataDrivenSetup;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 05/07/2017.
 */
public class DeleteAnalysisTest extends TestBase {

    private String portfolioName;
    LoginPage loginPage;

    @Factory(dataProvider = "data")
    public DeleteAnalysisTest(String portfolioName) {

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

        loginPage = new LoginPage(getDriver());

        String user = property("ExistingReportsTestUser");
        String pass = property("ExistingReportsTestUserPass");

        loginPage.login(user,pass);

    }

    @Test
    public void deleteAnalysis() throws InterruptedException, IOException {


        AnalysisPageHelper.deleteCompleteAnalysisFromExplorerPage(portfolioName);


    }

}
