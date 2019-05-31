package com.styleanalytics.enterprise.EquityReports;

import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import static org.testng.Assert.assertTrue;


public class StyleMineTest extends TestBase {

    WebDriver driver;
    @BeforeClass
    public void accessStyleMine() throws Exception {

        PortfolioReportsPage rp = new PortfolioReportsPage(getDriver());


        LogoutTest();

        String user = property("ExistingReportsTestUser");
        String pass = property("ExistingReportsTestUserPass");

        logInAsDiffUser(user, pass);

        GoTo.goToReportsPage();

        PortfolioReportsHelper.accessReport(rp.styleMine,rp.styleMinePerformance,25);
    }

    @AfterMethod
    public void tearDown() {

        driver.switchTo().defaultContent();


    }


    @Test(priority = 1)
    public void verifyLabels() {

        driver.findElement(By.xpath("//*[@id=\"divReturns\"]/table[1]/tbody/tr[1]/th[2]")).getText();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"divReturns\"]/table[1]/tbody/tr[1]/th[2]")).getText(), "Portfolio");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"divReturns\"]/table[1]/tbody/tr[1]/th[3]")).getText(), "Benchmark");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"divReturns\"]/table[1]/tbody/tr[1]/th[4]")).getText(), "Active");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"divReturns\"]/table[2]/tbody/tr[1]/th[2]")).getText(), "Currency");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"divReturns\"]/table[2]/tbody/tr[1]/th[3]")).getText(), "Cash");


    }

    // verifying Active Value
    @Test(priority = 2)

    public void verifyActiveValue() {

        //getting  PortfolioValue
        double portfolioValue = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"divReturns\"]/table[1]/tbody/tr[2]/td[2]")).getText());

        System.out.println(portfolioValue);
        //getting  benchmarkValue
        double benchmarkValue = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"divReturns\"]/table[1]/tbody/tr[2]/td[3]")).getText());

        System.out.println(benchmarkValue);
        //getting  activeValue
        double activeValue = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"divReturns\"]/table[1]/tbody/tr[2]/td[4]")).getText());

        System.out.println(activeValue);
        // verifying Active Value

        //DecimalFormat decimalFormat = new DecimalFormat("###.#");
        //String formattedValue = decimalFormat.format(activeValue);*/


        Double activeReturns = portfolioValue - benchmarkValue;


        activeReturns =Math.round(activeReturns*100)/100.0d;


        System.out.println(activeReturns);


        double tempPositiveValue = activeReturns + 0.01;
        double tempNegativeValue = activeReturns - 0.01;

        if (activeValue == tempPositiveValue) {

            System.out.println("Active return has a positive difference of 0.01");

        } else if (activeValue == tempNegativeValue) {

            System.out.println("Active return has a Negative difference of 0.01");

        }else if (activeValue == activeReturns) {

            System.out.println("Active return has a difference of 0.00");

        } else {

            System.out.println("Active return is incorrect");
            Assert.fail();
        }

    }


    @Test(priority = 3)

    public void columnHeaders() {

        StyleMineV2 styleMineV2 = new StyleMineV2();

        String slickid = styleMineV2.findSlickGridId();

        //  Verifying Factor label
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"" + slickid + "FactorName\"]")).getText(), "Factor");


        //  Verifying Factor active label
        assertTrue(driver.findElement(By.xpath("//*[@id=\"" + slickid + "col0\"]")).getText().contains("Factor Active Weight"));


        //  Verifying Relative Returns label
        assertTrue(driver.findElement(By.xpath("//*[@id=\"" + slickid + "col1\"]")).getText().contains("Relative Return"));


        //  Verifying Assert Allocation label
        assertTrue(driver.findElement(By.xpath("//*[@id=\"" + slickid + "col3\"]")).getText().contains("Stock Selection"));

        ////  Verifying Stock Selelction label
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"" + slickid + "col4\"]")).getText(), ("Interaction"));

        //  Verifying Stock interaction label
        //  Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"" + slickid + "col4\"]")).getText(), "Asset Allocation");


    }


    @Test(priority = 4)
    public void factorSelection() throws InterruptedException {

        StyleMineV2 styleMineV2 = new StyleMineV2();

        styleMineV2.openStyleMineSettings();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_fss_ddlDefaults\"]/table/tbody/tr/td[1]")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_fss_ddlDefaults_DropDown\"]/div[2]/ul/li[1]/div/div[3]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_fss_ddlDefaults_DropDown\"]/div[2]/ul/li[1]/div/div[4]/a")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//*[@id=\"RadWindowWrapper_ctl00_mainContentPlaceHolder_report_radWindowAnalysisSettings\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li/a")).click();

        Thread.sleep(3000);

        List<WebElement> ele = driver.findElements(By.xpath("//div[contains(@class,'slick-cell l0 r0 styleMineGridFactorCol')]"));

        System.out.println(ele.size());

        Assert.assertEquals(ele.size(), 23);

        String[] factorName = new String[23];
        factorName[0] = "Book to Price";
        factorName[1] = "Earnings Yield";
        factorName[2] = "Cash Flow Yield";
        factorName[3] = "Sales to Price";
        factorName[4] = "EBITDA to EV";
        factorName[5] = "Dividend Yield";
        factorName[6] = "Shareholder Yield";
        factorName[7] = "Dividend Growth 5Y";
        factorName[8] = "Earnings Growth 5Y";
        factorName[9] = "Sales Growth 5Y";
        factorName[10] = "Forecast Growth 12M";
        factorName[11] = "Return on Equity";
        factorName[12] = "Net Profit Margin";
        factorName[13] = "Low Gearing";
        factorName[14] = "Earnings Growth Stability";
        factorName[15] = "Sales Growth Stability";
        factorName[16] = "Market Cap";
        factorName[17] = "Market Beta";
        factorName[18] = "Daily Volatility 1Y";
        factorName[19] = "Volatility 3Y";
        factorName[20] = "Momentum ST";
        factorName[21] = "Momentum 12-1";
        factorName[22] = "Forecast 12M Revisions";


        for (int i = 0; i < ele.size(); i++) {
            System.out.println(ele.get(i).getText());
            Assert.assertEquals(ele.get(i).getText(), factorName[i]);
        }

    }


    @Test(priority = 5)

    public void verifySummarySettingsTop50() throws InterruptedException, IOException {

        StyleMineV2 styleMineV2 = new StyleMineV2();

        styleMineV2.openSettings();
        Thread.sleep(5000);

        WebElement DropList = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_ddlSummarySetting_Input\"]"));
        Actions act = new Actions(driver);
        act.moveToElement(DropList).build().perform();
        act.moveToElement(DropList).click().perform();
        Thread.sleep(3000);

        WebElement Box = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_ddlSummarySetting_DropDown\"]"));

        Thread.sleep(5000);

        List<WebElement> options = Box.findElements(By.tagName("li"));

        System.out.println(options.size());

        options.get(0).click();
        options.get(0).submit();

        Thread.sleep(8000);

        driver.switchTo().defaultContent();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"RadWindowWrapper_ctl00_mainContentPlaceHolder_report_radWindowAnalysisSettings\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li/a")).click();

        Thread.sleep(8000);

        String slickid = styleMineV2.findSlickGridId();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"" + slickid + "col0\"]")).getText(), "Factor Active Weight (Top 50%)");


        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"" + slickid + "col1\"]")).getText(), "Relative Return (Top 50%)");


    }


    @Test(priority = 6)
    public void verifySummarySettingsQ1() throws InterruptedException, IOException {

        StyleMineV2 styleMineV2 = new StyleMineV2();


        styleMineV2.openSettings();
        Thread.sleep(5000);

        WebElement DropList = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_ddlSummarySetting_Input\"]"));
        Actions act = new Actions(driver);
        act.moveToElement(DropList).build().perform();
        act.moveToElement(DropList).click().perform();
        Thread.sleep(3000);

        WebElement Box = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_ddlSummarySetting_DropDown\"]"));

        Thread.sleep(5000);

        List<WebElement> options = Box.findElements(By.tagName("li"));

        System.out.println(options.size());

        options.get(1).click();
        options.get(1).submit();


        Thread.sleep(8000);

        driver.switchTo().defaultContent();


        driver.findElement(By.xpath("//*[@id=\"RadWindowWrapper_ctl00_mainContentPlaceHolder_report_radWindowAnalysisSettings\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li/a")).click();

        Thread.sleep(8000);

        String slickid = styleMineV2.findSlickGridId();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"" + slickid + "col0\"]")).getText(), "Factor Active Weight (Q1)");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"" + slickid + "col1\"]")).getText(), "Relative Return (Q1)");

    }


    @Test(priority = 7)
    public void verifySettingsTopBottomDifference() throws InterruptedException, IOException {

        StyleMineV2 styleMineV2 = new StyleMineV2();
        styleMineV2.openSettings();
        Thread.sleep(5000);

        WebElement DropList = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_ddlSummarySetting_Input\"]"));
        Actions act = new Actions(driver);
        act.moveToElement(DropList).build().perform();
        act.moveToElement(DropList).click().perform();
        Thread.sleep(3000);

        WebElement Box = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_ddlSummarySetting_DropDown\"]"));

        Thread.sleep(5000);

        List<WebElement> options = Box.findElements(By.tagName("li"));

        System.out.println(options.size());
        Thread.sleep(4000);

        options.get(2).click();

        options.get(2).submit();


        Thread.sleep(3000);


        driver.switchTo().defaultContent();


        driver.findElement(By.xpath("//*[@id=\"RadWindowWrapper_ctl00_mainContentPlaceHolder_report_radWindowAnalysisSettings\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li/a")).click();

        Thread.sleep(8000);

        String slickid = styleMineV2.findSlickGridId();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"" + slickid + "col0\"]")).getText(), "Factor Active Weight (Q1-Q4)");


        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"" + slickid + "col1\"]")).getText(), "Relative Return (Q1-Q4)");


    }


    @Test(priority = 8)
    public void verifyDrillDownTitles() throws InterruptedException {

        //accessDrillDown();
        driver.findElement((By.xpath("//div[contains(@class,'styleMineGridBarContainer')]"))).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        String BRINSONATTRIBUTION = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl01_labTitle")).getText();

        assertTrue(BRINSONATTRIBUTION.contains("BRINSON ATTRIBUTION"));

        String CUMULATIVECONTRIBUTIONS = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl02_labTitle")).getText();

        assertTrue(CUMULATIVECONTRIBUTIONS.contains("CUMULATIVE CONTRIBUTIONS"));

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();


        Thread.sleep(10000);


    }


    @Test(priority = 9)

    public void allocationTrails() throws InterruptedException {

        //accessDrillDown();

        driver.findElement((By.xpath("//div[contains(@class,'styleMineGridBarContainer')]"))).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabTrailsOrDecomposition\"]/div/ul/li[2]/a/span/span/span")).click();

        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ctl00_labTitle\"]")).getText(), "FACTOR ACTIVE WEIGHT");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ctl01_labTitle\"]")).getText(), "CUM. RELATIVE RETURN");

        Assert.assertEquals(driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl02_labTitle")).getText(), "CUM. ASSET ALLOCATION");

        Assert.assertEquals(driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl03_labTitle")).getText(), "CUM. STOCK SELECTION");

        Assert.assertEquals(driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl04_labTitle")).getText(), "CUM. INTERACTION");

        Assert.assertEquals(driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl05_labTitle")).getText(), "CUM. CURRENCY");

        driver.switchTo().defaultContent();
        driver.findElement(By.className("rwCloseButton")).click();


    }

    @Test(priority = 10)
    public void allocationTrailsSelection() throws InterruptedException {

        driver.findElement((By.xpath("//div[contains(@class,'styleMineGridBarContainer')]"))).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabTrailsOrDecomposition\"]/div/ul/li[2]/a/span/span/span")).click();

        Thread.sleep(3000);

        String Weight = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[1]")).getText();

        System.out.println(Weight);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[1]")).click();

        Thread.sleep(3000);

        String Disable = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[1]")).getAttribute("class");

        System.out.println(Disable);

        Assert.assertEquals(Disable, "toggledOff");

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[2]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[2]")).getAttribute("class"), "toggledOff");

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[3]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[3]")).getAttribute("class"), "toggledOff");

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[4]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[4]")).getAttribute("class"), "toggledOff");

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[5]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[5]")).getAttribute("class"), "toggledOff");

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[6]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[6]")).getAttribute("class"), "toggledOff");


        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panToggleChartsLinksIncInteraction\"]/a[1]")).click();

        Assert.assertEquals(driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl00_labTitle")).getText(), "FACTOR ACTIVE WEIGHT");

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

    }


    @Test(priority = 11)
    public void allocationTrailsLegends() throws InterruptedException {


        driver.findElement((By.xpath("//div[contains(@class,'styleMineGridBarContainer')]"))).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabTrailsOrDecomposition\"]/div/ul/li[2]/a/span/span/span")).click();

        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panSeriesToggle\"]/div[1]/a[1]")).getText(), "Q1 (High)");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panSeriesToggle\"]/div[1]/a[2]")).getText(), "Q2");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panSeriesToggle\"]/div[1]/a[3]")).getText(), "Q3");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_panSeriesToggle\"]/div[1]/a[4]")).getText(), "Q4 (Low)");

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();


    }

    @Test(priority = 12)
    public void allocationTrailsLegendsSelection() throws InterruptedException {

        //Weight
        driver.findElement((By.xpath("//div[contains(@class,'styleMineGridBarContainer')]"))).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabTrailsOrDecomposition\"]/div/ul/li[2]/a/span/span/span")).click();

        Thread.sleep(3000);

        boolean WeightEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl00_labTitle")).isDisplayed();

        softAssert.assertEquals(WeightEnabled, true);

        driver.findElement(By.id("swatchT1")).click();

        Thread.sleep(2000);

        boolean WeightDisabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl00_labTitle")).isDisplayed();

        softAssert.assertEquals(WeightDisabled, false);

        driver.findElement(By.id("swatchT1")).click();

        Thread.sleep(2000);

        System.out.println(driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl00_labTitle")).getText());

        boolean WeightENABLED = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl00_labTitle")).isDisplayed();

        softAssert.assertEquals(WeightENABLED, true);

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();
    }


    @Test(priority = 13)
    public void allocatonTrailsRelativeReturns() throws InterruptedException {

        //// Cum relative return

        driver.findElement((By.xpath("//div[contains(@class,'styleMineGridBarContainer')]"))).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabTrailsOrDecomposition\"]/div/ul/li[2]/a/span/span/span")).click();

        Thread.sleep(3000);

        boolean RelativeReturnsEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl01_labTitle")).isDisplayed();

        softAssert.assertEquals(RelativeReturnsEnabled, true);

        driver.findElement(By.id("swatchT2")).click();

        Thread.sleep(2000);

        RelativeReturnsEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl01_labTitle")).isDisplayed();

        softAssert.assertEquals(RelativeReturnsEnabled, false);

        driver.findElement(By.id("swatchT2")).click();

        Thread.sleep(2000);

        System.out.println(driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl01_labTitle")).getText());

        RelativeReturnsEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl01_labTitle")).isDisplayed();

        softAssert.assertEquals(RelativeReturnsEnabled, true);

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();

    }


    @Test(priority = 14)
    public void assetAllocation() throws InterruptedException {


        driver.findElement((By.xpath("//div[contains(@class,'styleMineGridBarContainer')]"))).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabTrailsOrDecomposition\"]/div/ul/li[2]/a/span/span/span")).click();

        Thread.sleep(3000);

        boolean AssetAllocationEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl02_labTitle")).isDisplayed();

        softAssert.assertEquals(AssetAllocationEnabled, true);

        driver.findElement(By.id("swatchT3")).click();

        Thread.sleep(2000);

        boolean AssetAllocationdisabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl02_labTitle")).isDisplayed();

        softAssert.assertEquals(AssetAllocationdisabled, false);

        driver.findElement(By.id("swatchT3")).click();

        Thread.sleep(2000);

        System.out.println(driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl02_labTitle")).getText());

        AssetAllocationEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl02_labTitle")).isDisplayed();

        softAssert.assertEquals(AssetAllocationEnabled, true);

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();


    }


    @Test(priority = 15)
    public void stockSellection() throws InterruptedException {

        driver.findElement((By.xpath("//div[contains(@class,'styleMineGridBarContainer')]"))).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabTrailsOrDecomposition\"]/div/ul/li[2]/a/span/span/span")).click();

        Thread.sleep(3000);

        boolean StockSelectionEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl03_labTitle")).isDisplayed();

        softAssert.assertEquals(StockSelectionEnabled, true);

        driver.findElement(By.id("swatchT4")).click();

        Thread.sleep(2000);

        StockSelectionEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl03_labTitle")).isDisplayed();

        softAssert.assertEquals(StockSelectionEnabled, false);

        driver.findElement(By.id("swatchT4")).click();

        Thread.sleep(2000);

        System.out.println(driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl03_labTitle")).getText());

        StockSelectionEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl03_labTitle")).isDisplayed();

        softAssert.assertEquals(StockSelectionEnabled, true);

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();
    }


    @Test(priority = 16)

    public void currency() throws InterruptedException {

        driver.findElement((By.xpath("//div[contains(@class,'styleMineGridBarContainer')]"))).click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabTrailsOrDecomposition\"]/div/ul/li[2]/a/span/span/span")).click();

        Thread.sleep(3000);

        boolean CurrencyEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl04_labTitle")).isDisplayed();

        softAssert.assertEquals(CurrencyEnabled, true);

        driver.findElement(By.id("swatchT5")).click();

        Thread.sleep(2000);

        CurrencyEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl04_labTitle")).isDisplayed();

        softAssert.assertEquals(CurrencyEnabled, false);

        driver.findElement(By.id("swatchT3")).click();

        Thread.sleep(2000);

        System.out.println(driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl04_labTitle")).getText());

        CurrencyEnabled = driver.findElement(By.id("ctl00_mainContentPlaceHolder_ctl00_labTitle")).isDisplayed();

        softAssert.assertEquals(CurrencyEnabled, true);

        driver.switchTo().defaultContent();

        driver.findElement(By.className("rwCloseButton")).click();


    }


    @Test(priority = 17)
    public void sorting() throws InterruptedException {

        StyleMineV2 styleMineV2 = new StyleMineV2();

        String slickid = styleMineV2.findSlickGridId();

        //  Verifying Factor label
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"" + slickid + "FactorName\"]")).getText(), "Factor");

        List<WebElement> ele = driver.findElements(By.xpath("//div[contains(@class,'slick-cell l0 r0 styleMineGridFactorCol')]"));

        String BeforeSort = ele.get(0).getText();

        System.out.println(BeforeSort);

        driver.findElement(By.xpath("//*[@id=\"" + slickid + "col0\"]")).click();

        Thread.sleep(2000);

        ele = driver.findElements(By.xpath("//div[contains(@class,'slick-cell l0 r0 styleMineGridFactorCol')]"));

        String AfterSort = ele.get(0).getText();

        System.out.println(AfterSort);

        Assert.assertNotSame(BeforeSort, AfterSort);


    }


}




