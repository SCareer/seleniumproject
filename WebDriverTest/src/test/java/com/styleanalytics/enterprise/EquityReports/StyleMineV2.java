package com.styleanalytics.enterprise.EquityReports;



import com.styleanalytics.enterprise.Loader.LoadPage;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Utility;


import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;


/**
 * Created by viswanath on 25/04/2018.
 */
public class StyleMineV2 extends TestBase {

    static WebDriver driver;
    PortfolioReportsPage rp;

    @BeforeClass
    public void testSetup() throws Exception {

         rp = new PortfolioReportsPage(getDriver());

         String user = property("ExistingReportsTestUser");
        String pass = property("ExistingReportsTestUserPass");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(user,pass);
        com.styleanalytics.pages.PortfolioReportsPage portfolioReportsPage = new com.styleanalytics.pages.PortfolioReportsPage(getDriver());
        portfolioReportsPage.goToReportsPage(getURL());
        //PortfolioReportsHelper.accessReport(rp.styleMine,rp.styleMinePerformance,25);

    }


    public static void closeSettings() throws InterruptedException {

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//ul[@class='rwControlButtons']//li//a[@href='javascript:void(0);']")).click();

        Thread.sleep(3000);

        driver.switchTo().defaultContent();
    }

    @Test(priority = 2)
    public void styleMineSettingsStockSelectionInclude() throws IOException, InterruptedException {

        openSettings();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbStockSelectionInc\"]/span[1]")).click();

        Thread.sleep(3000);

        closeSettings();

        Thread.sleep(3000);

        String Id = findSlickGridId();


        WebElement interaction;

        try {
            interaction = driver.findElement(By.xpath("//*[@id=\"" + Id + "col4\"]/span[1]"));
            Assert.assertEquals(interaction.getText(), "Interaction");
        }catch (Exception e){

            System.out.println("Interaction Not displayed: Unexpected" +e);
            Assert.fail();
        }

    }
    @Test(priority = 3)
    public void styleMineSettingsStockSelectionExclude() throws InterruptedException, IOException {

        openSettings();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbStockSelectionExc\"]/span[2]")).click();

        Thread.sleep(3000);

        closeSettings();

        Thread.sleep(3000);

        String Id = findSlickGridId();

        WebElement interaction=null;

        try {
            interaction = driver.findElement(By.xpath("//*[@id=\"" + Id + "col4\"]/span[1]"));
            if(interaction!=null){
                Assert.fail();
            }

        }catch (Exception e){

            System.out.println("Interaction not Displayed as Expected.");
        }
    }

    @Test(priority = 5)
    public void AverageActiveWeightInclude() throws InterruptedException, IOException {

        openSettings();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbActiveWeightInc\"]/span[2]")).click();

        Thread.sleep(3000);

        closeSettings();

        Thread.sleep(3000);

        String Id = findSlickGridId();

        WebElement interaction;

        try {
            interaction = driver.findElement(By.xpath("//*[@id=\"" + Id + "col0\"]/span[1]"));
            Assert.assertEquals(interaction.getText(), "Factor Active Weight (Q1-Q4)");
        }catch (Exception e){

            System.out.println("Interaction Not displayed: Unexpected" +e);
            Assert.fail();
        }
    }

    @Test
    public void AverageActiveWeightExclude() throws InterruptedException, IOException {

        openSettings();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbActiveWeightExc\"]/span[2]")).click();

        Thread.sleep(3000);

        closeSettings();

        Thread.sleep(3000);

        String Id = findSlickGridId();
        WebElement interaction;

        try {
            interaction = driver.findElement(By.xpath("//*[@id=\"" + Id + "col0\"]/span[1]"));
            //Assert.assertEquals(interaction.getText(), "Factor Active Weight (Top 50%)");
            Assert.assertNotEquals(interaction.getText(),"Factor Active Weight (Top 50%)");

        }catch (Exception e) {

            System.out.println("Interaction not Displayed as Expected.");
        }

    }

    @Test
    public void verifyLabels() throws InterruptedException, IOException {

        openSettings();

        WebElement stockSelection5 = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_RadPageView2\"]/div[1]/div[5]/div[1]"));

        Assert.assertEquals(stockSelection5.getText(),"Selection Impact:");

        WebElement stockSelection0 = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_RadPageView2\"]/div[1]/div[1]/div[1]"));

        Assert.assertEquals(stockSelection0.getText(),"Stock Selection by:");

        WebElement selection = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_RadPageView2\"]/div[1]/div[4]/div[1]"));

        Assert.assertEquals(selection.getText(),"Allocation Impact:");

        WebElement selection1 = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_RadPageView2\"]/div[1]/div[3]/div[1]"));

        //*[@id="ctl00_mainContentPlaceHolder_RadPageView2"]/div[1]/div[3]/div[1]

        Assert.assertEquals(selection1.getText(),"Cumulative Relative Returns:");


        WebElement stockSelection1 = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_RadPageView2\"]/div[1]/div[2]/div[1]"));

        Assert.assertEquals(stockSelection1.getText(),"Average Active Weight:");

        closeSettings();

    }

    @Test
    public void CumulativeRelativeReturnsInclude() throws InterruptedException, IOException {

        openSettings();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbCumRelReturnsInc\"]/span[2]")).click();

        Thread.sleep(3000);

        closeSettings();

        Thread.sleep(3000);

        String Id = findSlickGridId();

        WebElement interaction;

        try {
            interaction = driver.findElement(By.xpath("//*[@id=\"" + Id + "col1\"]/span[1]"));
            Assert.assertEquals(interaction.getText(), "Relative Return (Q1-Q4)");
        }catch (Exception e){

            System.out.println("Interaction Not displayed: Unexpected" +e);
            Assert.fail();
        }
    }

    @Test
    public void CumulativeRelativeReturnsExclude() throws InterruptedException, IOException {

        openSettings();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbCumRelReturnsExc\"]/span[2]")).click();

        Thread.sleep(3000);

        closeSettings();

        Thread.sleep(3000);

        String Id = findSlickGridId();

//*[@id="slickgrid_965173col1"]/span[1]
        WebElement interaction;

        try {
            interaction = driver.findElement(By.xpath("//*[@id=\"" + Id + "col1\"]/span[1]"));
            //Assert.assertEquals(interaction.getText(), "Factor Active Weight (Top 50%)");
            Assert.assertNotEquals(interaction.getText(),"Relative Return (Top 50%)");

        }catch (Exception e){

            System.out.println("Interaction not Displayed as Expected.");
        }

        }


    public void horizontal_scroll() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.querySelector('table th:last-child').scrollIntoView();");
    }

    @Test
    public void AllocationImpactInclude() throws InterruptedException, IOException {

        openSettings();

        System.out.println("Open settings in Allocation Impact Include");


        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbAllocImpactInc\"]/span[2]")).click();

        System.out.println("Clicked on radio button");

        Thread.sleep(3000);

        closeSettings();

        System.out.println("Closed popup");

        Thread.sleep(3000);

        String Id = findSlickGridId();

        WebElement interaction;

        try {
            interaction = driver.findElement(By.xpath("//*[@id=\"" + Id + "col2\"]/span[1]"));
            Assert.assertEquals(interaction.getText(), "Asset Allocation");
            System.out.println("Verified");
        }catch (Exception e){

            System.out.println("Interaction Not displayed: Unexpected" +e);
            Assert.fail();
        }
    }

    @Test
    public void AllocationImpactExclude() throws InterruptedException, IOException {

        openSettings();
        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbAllocImpactExc\"]/span[2]")).click();

        Thread.sleep(3000);

        closeSettings();

        Thread.sleep(3000);

        String Id = findSlickGridId();

        horizontal_scroll();

        WebElement interaction;

        try {
            interaction = driver.findElement(By.xpath("//*[@id=\"" + Id + "col2\"]/span[1]"));
            //Assert.assertEquals(interaction.getText(), "Factor Active Weight (Top 50%)");
            Assert.assertNotEquals(interaction.getText(),"Asset Allocation");

        }catch (Exception e){

            System.out.println("Interaction not Displayed as Expected.");
        }
    }


    @Test
    public void SelectionImpactInclude() throws InterruptedException, IOException {

        openSettings();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbSelImpactInc\"]/span[2]")).click();

        Thread.sleep(3000);

        closeSettings();

        Thread.sleep(3000);

        String Id = findSlickGridId();

        WebElement interaction;

        try {
            interaction = driver.findElement(By.xpath("//*[@id=\"" + Id + "col3\"]/span[1]"));
            Assert.assertEquals(interaction.getText(), "Stock Selection");
        }catch (Exception e){

            System.out.println("Interaction Not displayed: Unexpected" +e);
            Assert.fail();
        }
    }

    @Test
    public void SelectionImpactExclude() throws InterruptedException, IOException {

        openSettings();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbSelImpactExc\"]/span[2]")).click();

        Thread.sleep(3000);

        closeSettings();

        Thread.sleep(3000);

        String Id = findSlickGridId();

        WebElement interaction;

        try {
            interaction = driver.findElement(By.xpath("//*[@id=\"" + Id + "col3\"]/span[1]"));
            //Assert.assertEquals(interaction.getText(), "Factor Active Weight (Top 50%)");
            Assert.assertNotEquals(interaction.getText(),"Stock Selection");

        }catch (Exception e) {

            System.out.println("Interaction not Displayed as Expected.");
        }
    }

    @Test
    public void verifySummarySettings() throws InterruptedException, IOException {

        openSettings();

        WebElement stockSelection = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_RadPageView2\"]/div[1]/div[6]/div[1]"));

        Assert.assertEquals(stockSelection.getText(),"Summary Setting:");

        closeSettings();

    }


    public static String findSlickGridId(){

        String className = driver.findElement(By.xpath("//*[contains(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_divStyleMineGrid_')]")).getAttribute("class");

        String slickGirdID = className.substring(17,33);

        //System.out.println(className+"....."+slickGirdID);

        return slickGirdID;


    }

    public void openSettings() throws InterruptedException, IOException {

        PortfolioReportsHelper.accessReport(rp.styleMine,rp.styleMinePerformance,25);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_Image1\"]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"rtvSettingsContainer\"]/div/div[2]/div/a[1]/span[1]")).click();

        Thread.sleep(3000);

        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabStripSettings\"]/div/ul/li[9]/a/span/span/span")).click();





        //Utility.moveToElement("//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_ctl00_labTitle\"]");
        //driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_ctl00_labTitle\"]")).click();

       // Actions actions = new Actions(driver);
        //WebElement ele = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_ctl00_labTitle\"]"));
        //actions.moveToElement(ele).build().perform();
        //ele.sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));

       /* try {
            WebElement settings = driver.findElement(By.id("ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_ctl00_hlSettings"));

            settings.click();
        }catch (NoSuchElementException e){

            System.out.println("Cannot Find Setting button to Click");
        }

        System.out.println("Clicked on settings");

        Thread.sleep(2000);

        driver.switchTo().frame(0);
*/
        System.out.println("Moved inside frame");

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbStockSelectionInc\"]/span[1]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbActiveWeightInc\"]/span[2]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbCumRelReturnsInc\"]/span[2]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbAllocImpactInc\"]/span[2]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_rbSelImpactInc\"]/span[2]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_ddlSummarySetting_Input\"]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_prefs_StyleMine_ddlSummarySetting_DropDown\"]/div/ul/li[3]"));

        Thread.sleep(3000);

    }

    public void openStyleMineSettings() throws InterruptedException {

        //openStyleMine();

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_Image1\"]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"rtvSettingsContainer\"]/div/div[2]/div/a[1]/span[1]")).click();

        Thread.sleep(3000);

        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_tabStripSettings\"]/div/ul/li[9]/a/span/span/span")).click();

    }



   @AfterMethod
    public void takeScreenShotOnFailure(ITestResult result) throws Exception {

        Utility.tearDown(result);

    }


}
