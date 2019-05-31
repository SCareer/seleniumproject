package com.styleanalytics.enterprise.json;

import com.styleanalytics.enterprise.DataDriven.DataDrivenSetup;
import com.styleanalytics.enterprise.EquityReports.ReportsHelper;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.automation.JSonReader;
import com.styleanalytics.pages.PortfolioReportsPage;
import com.styleanalytics.setup.TestBase;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.styleanalytics.setup.TestBase.property;

public class NumberChecking {

    WebDriver driver;
    LoginPage loginPage;
    PortfolioReportsPage reportsPage;
    String filePath = property("jsonDownloadPath");
    String portfolioName;

    public NumberChecking() throws IOException {
    }

    //@BeforeClass
    public void  NumberCheckingTestSetup() throws IOException, InterruptedException {

      //  loginPage = new LoginPage(getDriver());

        String user = property("ExistingReportsTestUser");
        String pass = property("ExistingReportsTestUserPass");

        loginPage.login(user, pass);

      ///  reportsPage = new PortfolioReportsPage(getDriver());

        //reportsHelper = new ReportsHelper(getDriver());

        String url = property("URL");
        reportsPage.goToReportsPage(url);

       // driver = getDriver();
    }

    @Factory(dataProvider = "data")
    public NumberChecking(String portfolioName) throws IOException {

        this.portfolioName = portfolioName;

    }

    @DataProvider
    public static Object[][] data() throws IOException {

        String testDataFile = Setup.property("TestData");

        Object[][] arrayObject = DataDrivenSetup.readFromExcel(testDataFile, "PortfolioReports");

        return arrayObject;
    }

    @Test
    public void SkylineTiltTest() throws IOException, ParseException {

        JSonReader actualJson = new JSonReader(new File(filePath+portfolioName+"\\"+"overviewSE.csv"));

        String[] col ={"Values Actual"};
        actualJson.readArrayJSonObject1("graphset","series","values","StyleExposure",col,"Excel Worksheet.xlsx");

        actualJson.readArrayJSonObject2("graphset","scale-x","values","StyleExposure","Factors","Excel Worksheet.xlsx");

        }
    @Test
    public void regionDistributionTest() throws IOException, ParseException {

        JSonReader actualJson = new JSonReader(new File(filePath+"overviewRegionDistribution.csv"));

        String[] col ={"Portfolio","Benchmark","Coverage"};

        actualJson.readArrayJSonObject1("graphset","series","values","RegionDistribution",col,"Excel Worksheet.xlsx");

        actualJson.readArrayJSonObject2("graphset","scale-x","values","RegionDistribution","Region","Excel Worksheet.xlsx");

        }

    @Test
    public void sectorDistributionTest() throws IOException, ParseException {

        JSonReader actualJson = new JSonReader(new File(filePath+"overviewSectorDistribution.csv"));

        String[] col ={"Portfolio","Benchmark","Coverage"};

        actualJson.readArrayJSonObject1("graphset","series","values","SectorDistribution",col,"Excel Worksheet.xlsx");

        actualJson.readArrayJSonObject2("graphset","scale-x","values","SectorDistribution","Sectors","Excel Worksheet.xlsx");

        }

    @Test
    public void sizeDistributionTest() throws IOException, ParseException {

        JSonReader actualJson = new JSonReader(new File(filePath+"overviewSizeDistribution.csv"));

        String[] col ={"Portfolio","Benchmark","Coverage","Market"};

        actualJson.readArrayJSonObject1("graphset","series","values","SizeDistribution",col,"Excel Worksheet.xlsx");

        actualJson.readArrayJSonObject2("graphset","scale-x","values","SizeDistribution","Size","Excel Worksheet.xlsx");

        }


    @Test
    public void styleDistributionTest() throws IOException, ParseException {

        JSonReader actualJson = new JSonReader(new File(filePath+"overviewStyleDistribution.csv"));

        String[] col ={"Portfolio","Benchmark","Coverage","Market"};

        actualJson.readArrayJSonObject1("graphset","series","values","StyleDistribution",col,"Excel Worksheet.xlsx");

        actualJson.readArrayJSonObject2("graphset","scale-x","values","StyleDistribution","Style","Excel Worksheet.xlsx");

        }

    @Test
    public void riskAttributionTest() throws IOException, ParseException {

        JSonReader actualJson = new JSonReader(new File(filePath+"overviewRiskAttribution.csv"));

        String[] col ={"Values Actual"};

        actualJson.readArrayJSonObject1("graphset","series","values","Risk",col,"Excel Worksheet.xlsx");

        actualJson.readArrayJSonObject2("graphset","scale-x","values","Risk","RiskAttribution","Excel Worksheet.xlsx");

        }

    @Test
    public void liquidityTest() throws IOException, ParseException {

        JSonReader actualJson = new JSonReader(new File(filePath+"overviewLiquidity.csv"));

        String[] col ={"Trade to Cash","Trade to BM"};

        actualJson.readArrayJSonObject1("graphset","series","values","Liquidity",col,"Excel Worksheet.xlsx");

        actualJson.readArrayJSonObject2("graphset","scale-x","values","Liquidity","Trading Days","Excel Worksheet.xlsx");


    }
    @Test
    public void riskEstimatesTest() throws IOException, InterruptedException {



    }




}
