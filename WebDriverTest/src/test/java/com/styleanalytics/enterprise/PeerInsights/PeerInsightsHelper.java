package com.styleanalytics.enterprise.PeerInsights;


import com.styleanalytics.enterprise.ExecutiveReports.ExecReportHelpers;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.Wait;

import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class PeerInsightsHelper extends TestBase {

    static WebDriver driver;

    PeerInsightsPage peerInsightsPage;

    public PeerInsightsHelper(WebDriver driver){
        this.driver = driver;
    }

    public static void openFundReport(String portfolioName) throws InterruptedException {

        driver.findElement(By.xpath("//area[contains(@id,'_1000_chartDiv-graph-id1-plotset-plot-1-node-0')]")).click();

        driver.switchTo().frame(0);

        WebElement pName = driver.findElement(By.cssSelector(".slick-column-name"));

        Assert.assertEquals(pName.getText(), "Portfolio Name");

        //Need to find the first portfolio displayed in the drill down

        driver.findElement(By.cssSelector(".ui-state-default.slick-headerrow-column.l0.r0>input")).sendKeys(portfolioName);

        Thread.sleep(2000);
        WebElement searhResult = driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_SummaryGrid_panGridSummaryStyleExposures']/div[4]/div[3]/div/div/div"));
        String searhResultText = searhResult.getText();
        Assert.assertEquals(searhResultText, portfolioName);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_SummaryGrid_panGridSummaryStyleExposures\"]/div[5]/div[3]/div/div[1]/div[2]/a")).click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(0);

        Thread.sleep(10000);

    }

    public static void openPeerGroup(String peerGroupName) throws IOException, InterruptedException {


        Utility.accessPeerInsight(peerGroupName);

        Utility.isElementPresent("//img[contains(@id,'_1000_chartDiv-img')]", 20);

    }


    public static void switchToCurrentPopup() {

        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();

            System.out.println(subWindowHandler);
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window

        // Now you are in the popup window, perform necessary actions here

        //driver.switchTo().window(parentWindowHandler);  // switch back to parent window

        //return parentWindowHandler;
    }


    public void goToPeerInsightsReportsMenu(String reportName, WebElement reportSubMenu) throws InterruptedException {

        peerInsightsPage = new PeerInsightsPage(getDriver());

        Actions actions = new Actions(driver);


        if (reportName.equalsIgnoreCase("PeerGroupOverview") || reportName.equalsIgnoreCase("PeerGroupOverviewMedian")) {

            actions.moveToElement(peerInsightsPage.piOverviewMainMenu).build().perform();
            // peerInsightsPage.piOverviewMainMenu.click();

        } else if (reportName.equalsIgnoreCase("PeerStyleSkyline")
                || reportName.equalsIgnoreCase("PeerStyleSkylineHistory")
                || reportName.equalsIgnoreCase("StyleSkylineFundLevel")
                || reportName.equalsIgnoreCase("StyleSkylineFundLevelHeatMap")) {

            actions.moveToElement(peerInsightsPage.piStyleExposureMainMenu).build().perform();

            //peerInsightsPage.piStyleExposureMainMenu.click();

        } else if (reportName.equalsIgnoreCase("PeerStyleDistribution") ||
                reportName.equalsIgnoreCase("PeerStyleDistributionHistory") ||
                reportName.equalsIgnoreCase("PeerStyleDistributionFundLevel") ||
                reportName.equalsIgnoreCase("PeerStyleDistributionFundLevelHeatMap") ||

                reportName.equalsIgnoreCase("PeerSizeDistribution") ||
                reportName.equalsIgnoreCase("PeerSizeDistributionHistory") ||
                reportName.equalsIgnoreCase("PeerSizeDistributionFundLevel") ||
                reportName.equalsIgnoreCase("PeerSizeDistributionFundLevelHeatMap") ||

                reportName.equalsIgnoreCase("PeerCountryDistribution") ||
                reportName.equalsIgnoreCase("PeerCountryDistributionHistory") ||
                reportName.equalsIgnoreCase("PeerCountryDistributionFundLevel") ||
                reportName.equalsIgnoreCase("PeerCountryDistributionFundLevelHeatMap") ||

                reportName.equalsIgnoreCase("PeerSectorDistribution") ||
                reportName.equalsIgnoreCase("PeerSectorDistributionHistory") ||
                reportName.equalsIgnoreCase("PeerSectorDistributionFundLevel") ||
                reportName.equalsIgnoreCase("PeerSectorDistributionFundLevelHeatMap")) {

            actions.moveToElement(peerInsightsPage.piDistributionMainMenu).build().perform();

            //peerInsightsPage.piDistributionMainMenu.click();

        } else if (reportName.equalsIgnoreCase("PortfolioRiskRank")
                || reportName.equalsIgnoreCase("PeerRiskAttribution")
                || reportName.equalsIgnoreCase("PeerRiskHistory")
                || reportName.equalsIgnoreCase("RiskAttributionFundLevel")
                || reportName.equalsIgnoreCase("RiskMeasuresFundLevelHeatMap")
                || reportName.equalsIgnoreCase("RiskAttributionFundLevelHeatMap")) {

            actions.moveToElement(peerInsightsPage.piFundReportRiskMenu).build().perform();

            // peerInsightsPage.piFundReportRiskMenu.click();

        } else if (reportName.equalsIgnoreCase("PerformanceRank")
                || reportName.equalsIgnoreCase("PortfolioReturns")) {

            actions.moveToElement(peerInsightsPage.piPerformanceMainMenu).build().perform();

            //peerInsightsPage.piPerformanceMainMenu.click();
        }

        //Thread.sleep(2000);

        Utility.waitForElementToDisplay(reportSubMenu, 3);

        reportSubMenu.click();

        Wait.untilJqueryIsDone(driver, 30);

        Wait.waitForSquareBoxesToDisappear(driver, 30);

        Wait.waitForSpinnerToDisappear(driver, 30);

        Wait.forGridToLoad(driver, 30);

        //Thread.sleep(10000);

       moveCursorAway();

    }


    public static void verifyReportsDisplayedInHistory(int count) throws InterruptedException {

        Utility.isElementPresent("//img[contains(@id,'_chartDiv-img')]", 60);

        for (int chart = 1; chart < count; chart++) {


            String r1 = "html[1]/body[1]/div[2]/form[1]/div[7]/div[4]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[";
            String r2 = "]/div[3]/div[1]/div[1]/img[1]";


            WebElement report = driver.findElement(By.xpath(r1 + chart + r2));

            report.isDisplayed();

            String t1 = "html/body/div[2]/form//div[4]/div/div[1]/div/div[1]/div[3]/div/div/div[";
            String t2 = "]/div[2]/span";


            WebElement title = driver.findElement(By.xpath(t1 + chart + t2));

            title.isDisplayed();


        }


    }

    public static void accessReports(String MainReportXpath, String ReportXpath) throws InterruptedException {


        driver.findElement(By.xpath(MainReportXpath)).click();

        Thread.sleep(4000);

        driver.findElement(By.xpath(ReportXpath)).click();

        Utility.waitForPageToBeReady();


        moveCursorAway();

    }


    public static void moveCursorAway() {

        Actions moveCusorToHideMenu = new Actions(driver);
        moveCusorToHideMenu.moveToElement(driver.findElement(By.xpath("//*[@id='iconSearch']"))).build().perform();
    }


    public static void verifyMutilpeReportOnPage(String[] reportTitle, SoftAssert softAssert) {

        List<WebElement> Titels = driver.findElements(By.className("chartTitle"));

        List<WebElement> charts = driver.findElements(By.className("dashboardReportWidget"));

        for (int i = 0; i < 6; i++) {

            moveToElement1(Titels.get(i));

            String TitleName = Titels.get(i).getText();

            softAssert.assertEquals(TitleName, reportTitle[i]);
            softAssert.assertTrue(charts.get(i).isDisplayed());

        }

    }

    public static void moveToElement1(WebElement xpath){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = xpath;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void verifyReportsDisplayedOverview(int reportsCount) throws InterruptedException {

        //Utility.isElementPresent("//img[contains(@id,'_chartDiv-img')]",60);

        for (int chart = 0; chart < reportsCount; chart++) {

            String r1 = "//img[contains(@id,'_100";
            String r2 = "_chartDiv-img')]";

            WebElement report = driver.findElement(By.xpath(r1 + chart + r2));

            report.isDisplayed();

        }


    }

    public void verifyPeerOverviewReports() throws IOException, InterruptedException {

        String clickOnReport;

        verifyReportsDisplayedOverview(6); //Verify the Report and report tile displayed or not

        for (int i = 0; i < 6; i++) {

            if (i < 3) {

                clickOnReport = "//area[contains(@id,'_panContainer')and contains(@id,'_100" + i + "_chartDiv-graph-id1-plotset-plot-2-node-0')]";

            } else {

                clickOnReport = "//area[contains(@id,'_panContainer')and contains(@id,'_100" + i + "_chartDiv-graph-id0-plotset-plot-2-node-0')]";
            }

            List<WebElement> ele = driver.findElements(By.className("chartTitle"));

            WebElement tit = ele.get(i);

            moveToElement(tit);


            driver.findElement(By.xpath(clickOnReport)).click();
            insideDrillDownPopup();


        }

    }


    public void insideDrillDownPopup() throws InterruptedException {

        driver.switchTo().frame(0);
        WebElement pName = driver.findElement(By.cssSelector(".slick-column-name"));
        //System.out.print(pName.getText());
        Assert.assertEquals(pName.getText(), "Portfolio Name");

        WebElement firstPortfolio = driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_SummaryGrid_panGridSummaryStyleExposures']/div[4]/div[3]/div/div[2]/div"));
        String firstPortfolioText = firstPortfolio.getText();
        driver.findElement(By.cssSelector(".ui-state-default.slick-headerrow-column.l0.r0>input")).sendKeys(firstPortfolio.getText());
        Thread.sleep(2000);
        WebElement searhResult = driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_SummaryGrid_panGridSummaryStyleExposures']/div[4]/div[3]/div/div/div"));
        String searhResultText = searhResult.getText();
        Assert.assertEquals(searhResultText, firstPortfolioText);
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".rwCloseButton")).click();

    }


    public void verifyPeerOverviewReportsMedian(int numOfReports) throws IOException, InterruptedException {

        String clickOnReport = null;

        for (int i = 0; i < numOfReports; i++) {

            if (i == 0) {

                clickOnReport = "//area[contains(@id,'_panContainer')and contains(@id,'_100" + i + "_chartDiv-graph-id1-plotset-plot-0-node-1')]";

            } else if (i > 0 && i < 3) {

                clickOnReport = "//area[contains(@id,'_panContainer')and contains(@id,'_100" + i + "_chartDiv-graph-id0-plotset-plot-0-node-1')]";

            } else if (i == 3) {

                System.out.println("No drill down");
            } else if (i == 4) {

                clickOnReport = "//area[contains(@id,'_panContainer')and contains(@id,'_100" + i + "_chartDiv-graph-id0-plotset-plot-0-node-1')]";

            } else if (i == 5) {

                System.out.println("No drill down");
            } else {

                clickOnReport = "//area[contains(@id,'_panContainer')and contains(@id,'_100" + i + "_chartDiv-graph-id0-plotset-plot-0-node-1')]";

            }


            List<WebElement> ele = driver.findElements(By.className("chartTitle"));

            WebElement tit = ele.get(i);

            moveToElement(tit);

            driver.findElement(By.xpath(clickOnReport)).click();

            insideDrillDownPopup();

        }


    }


    public void fundLevelHeatMapDrillDown(String Xpath, SoftAssert softAssert) {


        driver.findElement(By.xpath(Xpath)).click();

        Utility.waitForElementToDisplayByclassName("rwCloseButton", 100);

        driver.switchTo().frame(0);

        softAssert.assertTrue(driver.findElement(By.xpath("//*[contains(@id,'aspnetForm')]")).isDisplayed());

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();


    }


    public void distributionDrillDown(String Xpath) throws InterruptedException {

        List<WebElement> bars = driver.findElements(By.xpath(Xpath));

        //  System.out.println(bars.size());

        bars.get(1).click();

        insideDrillDownPopup();

    }


    public void fundLevalDrillDown(String OnClickText, int elementNumber) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        ExecReportHelpers execReportHelpers = new ExecReportHelpers(driver);

        execReportHelpers.drillDownInslickGrid(OnClickText, elementNumber);

        Thread.sleep(6000);

        Utility.waitForElementToDisplayByclassName("rwCloseButton", 100);

        driver.switchTo().frame(0);

        softAssert.assertTrue(driver.findElement(By.xpath("//*[contains(@id,'aspnetForm')]")).isDisplayed());

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

        softAssert.assertAll();


    }


    public void historyDrillDowns(String Xpath) throws InterruptedException {

        List<WebElement> historyCharts = driver.findElements(By.xpath(Xpath));

        historyCharts.get(1).click();

        insideDrillDownPopup();

    }
    public WebElement report() {

        String rep = driver.findElement(By.className("zc-img")).getAttribute("id");

        WebElement report = driver.findElement(By.xpath(" //img[@id='" + rep + "']"));

        //System.out.println(report);

        return report;


    }

    public WebElement title() {


        String x = driver.findElement(By.className("dashboardReportWidget")).getAttribute("id");
        WebElement title = driver.findElement(By.xpath("//span[@id='" + x + "_ctl00_labTitle']"));
        //System.out.println(title.getText());

        return title;
    }

    public String titleAndReport(WebElement title, WebElement report, SoftAssert softAssert) {

        softAssert.assertTrue(title.isDisplayed(), title.getText());

        softAssert.assertTrue(report.isEnabled(), title.getText());

        return title.getText();
    }

    public static void verifyPeerRiskHistoryReportTitle(String titel[], SoftAssert softAssert) {


        List<WebElement> chartslist = driver.findElements(By.className("chartTitle"));

        // System.out.println(chartslist.size());

        for (int i = 0; i < 10; i++) {

            softAssert.assertEquals(chartslist.get(i).getText(), titel[i]);
        }


    }

    public static void verifyMutilpleReportOnPage(String[] reportTitle, SoftAssert softAssert) {

        List<WebElement> Titles = driver.findElements(By.className("chartTitle"));

        for (int i = 0; i < reportTitle.length; i++) {

            moveToElement1(Titles.get(i));

            String TitleName = Titles.get(i).getText();

            // System.out.println(reportTitle[i]);

            softAssert.assertEquals(TitleName, reportTitle[i], reportTitle[i]);


        }

    }



    public void historyDrillDownsForAll(String Xpath, int rpoetNumber) throws InterruptedException {

        List<WebElement> historyCharts = driver.findElements(By.xpath(Xpath));

        historyCharts.get(rpoetNumber).click();

        insideDrillDownPopup();

    }


    public void fundLevelHeatMapDrillDown2(String Xpath) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> test = driver.findElements(By.xpath("//*[contains(@class,'ui-widget-content slick-row even')]"));

        WebElement Box = test.get(1);

        Thread.sleep(3000);

        Box.findElement(By.xpath(Xpath)).click();

        Utility.waitForElementToDisplayByclassName("rwCloseButton", 100);

        driver.switchTo().frame(0);

        softAssert.assertTrue(driver.findElement(By.xpath("//*[contains(@id,'aspnetForm')]")).isDisplayed());


        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

        softAssert.assertAll();
    }


}





















