package com.styleanalytics.enterprise.PeerInsights;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class FundReportDrillDowns extends TestBase {


    public PeerInsightsPage peerInsightsPage;
    public SoftAssert softAssert;

    private String peerInsightsReport;
    private String portfolioName;
    private  String scenario;

    WebDriver driver;


    @Factory(dataProvider = "data")
    public FundReportDrillDowns(String peerInsightsReport, String portfolioName, String scenario) {

        this.peerInsightsReport = peerInsightsReport;

        this.portfolioName = portfolioName;

        this.scenario = scenario;

    }


    @DataProvider
    public static Object[][] data() {

        return new Object[][]{
               {"MorningStar Portfolio With access", "Advisory Research Intl Small Cap Value", "morningStar"},
              {"Lipper portflio with access", "Transamerica Global Equity", "Lipper"},
               {"MorningStar Portfolio WithoutAccess", "BonaVista Canadian Equity", "MorningStarWithOutAccess"}
    };

    }


    @BeforeClass
    public void openPeerGroupReport() throws IOException, InterruptedException {

        // Utility.logInAsDiffUser();

        GoTo.peerInsights();

        try {
            if (!scenario.equalsIgnoreCase("MorningStarWithOutAccess")) {

                PeerInsightsHelper.openPeerGroup(peerInsightsReport);
                PeerInsightsHelper.openFundReport(portfolioName);

            } else {

                FundReport peerInsightsFundReport = new FundReport();
                peerInsightsFundReport.logInAsWithoutAccessUser();
                //logInAsDiffUser();
                //Refactor the code above---------------------------------------------------------------
                PeerInsightsHelper.openPeerGroup(peerInsightsReport);
                PeerInsightsHelper.openFundReport(portfolioName);
            }
        }catch (Exception e){

            System.out.println("Problem with the setup :"+e);
        }

        peerInsightsPage = new PeerInsightsPage(getDriver());
        driver = getDriver();

    }

    @Test
    public void fundReportDrillDownTest() throws IOException, InterruptedException {



        if (scenario.equalsIgnoreCase("MorningStar") || scenario.equalsIgnoreCase("yourOwnSuccess")||scenario.equalsIgnoreCase("MyOwnWithOutAccess")) {

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(styleSkylineDrillDownPopUp(true));
            softAssert.assertTrue(styleDistributionDrillDowns(true));
            softAssert.assertTrue(sizeDistributionDrillDowns(true));
            softAssert.assertTrue(riskAttributionDrillDowns(true));
            softAssert.assertTrue(sectorDistributionDrillDowns(true));
            softAssert.assertTrue(riskRangeDrillDowns(true));
            softAssert.assertTrue(riskTrackingErrorDrilldown(true));
            softAssert.assertTrue(styleExRangeDrillDown(true));
            softAssert.assertAll();

        }else if (scenario.equalsIgnoreCase("Lipper")||scenario.equalsIgnoreCase("MorningStarWithOutAccess")) {

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(styleSkylineDrillDownPopUp(false));
            softAssert.assertTrue(styleDistributionDrillDowns(false));
            softAssert.assertTrue(sizeDistributionDrillDowns(false));
            softAssert.assertTrue(riskAttributionDrillDowns(false));
            softAssert.assertTrue(sectorDistributionDrillDowns(false));
            softAssert.assertTrue(riskRangeDrillDowns(true));
            softAssert.assertTrue(riskTrackingErrorDrilldown(true));
            softAssert.assertTrue(styleExRangeDrillDown(true));
            softAssert.assertAll();

        }else if (scenario.equalsIgnoreCase("yourOwnFailure")) {

        }




    }



    //@Test(priority = 1)
    public Boolean styleSkylineDrillDownPopUp(Boolean IsDrillDownAvailable) throws InterruptedException, IOException {

        try {

            SoftAssert softAssert = new SoftAssert();

            openDrillDownPopup(peerInsightsPage.overViewStyleSkylineDrilldown);

            Utility.waitForElementToDisplay(peerInsightsPage.styleSkylineDrilldownTiltContributionTitle, 5);

            softAssert.assertEquals(peerInsightsPage.styleSkylineDrilldownTiltContributionTitle.getText(), "TILT CONTRIBUTIONS");

            softAssert.assertEquals(peerInsightsPage.styleSkylineDrilldownFactorReturnTitle.getText(), "FACTOR RETURNS");

            softAssert.assertEquals(peerInsightsPage.styleSkylineDrilldownFactorDisperisionTitle.getText(), "FACTOR DISPERSION");

            softAssert.assertEquals(peerInsightsPage.styleSkylineDrilldownTop10Bottom10Title.getText(), "TOP 10 BOTTOM 10");

            closePopup();

            softAssert.assertAll();

            afterMethod();

            return true;

        }catch (Exception e){

            System.out.println("styleSkylineDrillDownPopUp Test Failed "+e);

            if(IsDrillDownAvailable == false){
                afterMethod();
                return true;
            }

            return false;
        }


    }


    //@Test(priority = 2)
    public Boolean styleDistributionDrillDowns(Boolean IsDrillDownAvailable) throws InterruptedException, IOException {

       try {

           SoftAssert softAssert = new SoftAssert();

           openDrillDownPopup(peerInsightsPage.styleDistributionDrillDown);

           Utility.waitForElementToDisplay(peerInsightsPage.styleDistributionDetailsReport, 20);

           softAssert.assertEquals(peerInsightsPage.styleDistributionTitle.getText(), "STYLE DISTRIBUTION DETAILS");

           softAssert.assertTrue(peerInsightsPage.styleDistributionDetailsReport.isDisplayed());

           softAssert.assertEquals(peerInsightsPage.styleDistributionSecuritiesInLargeValueTitle.getText(), "SECURITIES IN LARGE VALUE");

           softAssert.assertTrue(peerInsightsPage.styleDistributiontop10Bottom10Report.isDisplayed());

           closePopup();

           softAssert.assertAll();

           afterMethod();

           return true;

       }catch (Exception e){

           System.out.println("styleDistributionDrillDowns Test Failed "+e);

           if(IsDrillDownAvailable == false){
               afterMethod();
               return true;
           }

           return false;
       }

    }


    //@Test(priority = 3)
    public Boolean sizeDistributionDrillDowns(Boolean IsDrillDownAvailable) throws InterruptedException, IOException {

        try {

            SoftAssert softAssert = new SoftAssert();

            openDrillDownPopup(peerInsightsPage.sizeDistributionDrillDown);

            Utility.waitForElementToDisplay(peerInsightsPage.sizeDistributionDetailsReport, 20);

            softAssert.assertEquals(peerInsightsPage.sizeDistributionTitle.getText(), "SIZE DISTRIBUTION DETAILS");

            softAssert.assertTrue(peerInsightsPage.sizeDistributionDetailsReport.isDisplayed());

            softAssert.assertEquals(peerInsightsPage.sizeDistributionSecuritiesInMegaTitle.getText(), "SECURITIES IN MEGA");

            softAssert.assertTrue(peerInsightsPage.sizeDistributionTop10Bottom10Report.isDisplayed());

            closePopup();

            softAssert.assertAll();

            afterMethod();

            return true;

        }catch (Exception e){

            System.out.println("sizeDistributionDrillDowns Test Failed "+e);

            if(IsDrillDownAvailable == false) {
                afterMethod();
                return true;
            }

            return false;
        }

    }


    //@Test(priority = 4)
    public Boolean riskAttributionDrillDowns(Boolean IsDrillDownAvailable) throws InterruptedException, IOException {

        try {

            SoftAssert softAssert = new SoftAssert();

            openDrillDownPopup(peerInsightsPage.riskAttributionDrillDown);

            Utility.waitForElementToDisplay(peerInsightsPage.riskAttributionContributionToTrackingErrorTitle, 20);

            softAssert.assertEquals(peerInsightsPage.riskAttributionContributionToTrackingErrorTitle.getText(), "CONTRIBUTION TO TRACKING ERROR");

            softAssert.assertEquals(peerInsightsPage.riskAttributionContributionToCurrencyRiskTitle.getText(), "CONTRIBUTION TO CURRENCY RISK");

            softAssert.assertEquals(peerInsightsPage.riskAttributionContributionActiveWeightTitle.getText(), "ACTIVE WEIGHT");

            closePopup();

            softAssert.assertAll();

            afterMethod();

            return true;

        }catch (Exception e){

            System.out.println("riskAttributionDrillDowns Test Failed "+e);

            if(IsDrillDownAvailable == false) {

                afterMethod();
                return true;
            }

            return false;
        }

    }

    //@Test(priority = 5)
    public Boolean sectorDistributionDrillDowns(Boolean IsDrillDownAvailable) throws InterruptedException, IOException {


        try{
        SoftAssert softAssert = new SoftAssert();

        openDrillDownPopup(peerInsightsPage.sectorDistributionDrilldown);

        Utility.waitForElementToDisplay(peerInsightsPage.sectorDistributionReport, 20);


        softAssert.assertEquals(peerInsightsPage.sectorDistributionConsDiscTitle.getText(), "SECTOR: CONS DISC");

        softAssert.assertTrue(peerInsightsPage.sectorDistributionReport.isDisplayed());

        closePopup();

        softAssert.assertAll();

        afterMethod();

        return true;

    }catch (Exception e){

        System.out.println("sectorDistributionDrillDowns Test Failed "+e);

            if(IsDrillDownAvailable == false) {
                afterMethod();
                return true;
            }

        return false;
    }


    }


    public void accessReportMenus(String Xpath1, String Xpath2) throws InterruptedException {

        driver.findElement(By.xpath(Xpath1)).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath(Xpath2)).click();

        Thread.sleep(5000);

        Actions moveCusorToHideMenu = new Actions(driver);

        moveCusorToHideMenu.moveToElement(driver.findElement(By.xpath("//*[@id=\"labSnapshotDate\"]"))).build().perform();

        Thread.sleep(10000);


    }


   // @Test(priority = 8)

    public Boolean styleExRangeDrillDown(Boolean IsDrillDownAvailable) throws InterruptedException, IOException {

        try{

        SoftAssert softAssert = new SoftAssert();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);

        accessReportMenus("//*[@id=\"spanShowMegaMenu\"]/div/div[2]", "//*[@id=\"divMegaMenu\"]/div[2]/div[3]/a/em");

        peerInsightsPage.StyleExposureRangeDrillDown.click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);

        Utility.waitForElementToDisplay(peerInsightsPage.StyleExposureRangeReport, 20);

        softAssert.assertTrue(peerInsightsPage.StyleExposureRangeReport.isDisplayed());

        driver.switchTo().parentFrame();

        driver.findElement(By.className("rwCloseButton")).click();

        softAssert.assertAll();

        afterMethod();

        return true;

    }catch (Exception e){

        System.out.println("styleExRangeDrillDown Test Failed "+e);

            if(IsDrillDownAvailable == false){

                afterMethod();
                return true;
            }

        return false;
    }

    }

    //@Test(priority = 6)
    public Boolean riskRangeDrillDowns(Boolean IsDrillDownAvailable) throws InterruptedException, IOException {

        try{

        SoftAssert softAssert = new SoftAssert();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);

        accessReportMenus("//*[@id=\"spanShowMegaMenu\"]/div/div[4]", "//*[@id=\"divMegaMenu\"]/div[4]/div[2]/a/em");

        peerInsightsPage.riskRangeDrillDown.click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);

        Utility.waitForElementToDisplay(peerInsightsPage.riskRangeReport, 20);

        softAssert.assertTrue(peerInsightsPage.riskRangeReport.isDisplayed());

        driver.switchTo().parentFrame();

        driver.findElement(By.className("rwCloseButton")).click();

        softAssert.assertAll();

        afterMethod();

        return true;

    }catch (Exception e){

        System.out.println("riskRangeDrillDowns Test Failed "+e);

            if(IsDrillDownAvailable == false){

                afterMethod();
                return true;
            }

        return false;
    }

    }


    //@Test(priority = 7)
    public Boolean riskTrackingErrorDrilldown(Boolean IsDrillDownAvailable) throws InterruptedException, IOException {

        try{
        SoftAssert softAssert = new SoftAssert();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);

        accessReportMenus("//*[@id=\"spanShowMegaMenu\"]/div/div[4]", "//*[@id=\"divMegaMenu\"]/div[4]/div[2]/a/em");

        peerInsightsPage.riskTrackingErrorDrillDown.click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);

        Utility.waitForElementToDisplay(peerInsightsPage.riskTrackingErrorReport, 20);

        softAssert.assertTrue(peerInsightsPage.riskTrackingErrorReport.isDisplayed());

        closePopup();

        softAssert.assertAll();

        afterMethod();

        return true;

    }catch (Exception e){

        System.out.println("riskTrackingErrorDrilldown Test Failed" +e);

            if(IsDrillDownAvailable == false) {

                afterMethod();
                return true;
            }

        return false;
    }

    }

    public void closePopup(){

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();


    }


    public void openDrillDownPopup(WebElement reportToDrillDown) throws InterruptedException {


        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);

        reportToDrillDown.click();

        Thread.sleep(5000);

        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);

    }

   // @AfterMethod
    public void afterMethod() throws IOException, InterruptedException {

        driver.navigate().refresh();

        PeerInsightsHelper.openFundReport(portfolioName);

    }


}




