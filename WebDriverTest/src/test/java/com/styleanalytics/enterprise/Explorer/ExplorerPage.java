
package com.styleanalytics.enterprise.Explorer;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.*;

public class ExplorerPage extends EnterpriseBaseClass {

    @Test(priority = 1)
    public void ExplorePage() throws InterruptedException {
        Thread.sleep(5000);
        Driver.findElement(By.id("topNav2_hlExplore")).click();
        Thread.sleep(3000);
        String ActualTitle = Driver.getTitle();
        String ExpectedTitle = "Explore Portfolio";
        assertEquals(ActualTitle, ExpectedTitle, "explore Page tiltle");
        System.out.println(ActualTitle);

    }

    @Test(priority = 2)
    public void portfolioSelection() throws InterruptedException {
        //Driver.findElement(By.id("topNav2_hlExplore")).click();
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_explorer_ctl00__0\"]/td[3]")).click();
        Thread.sleep(8000);
        // Driver.findElement(By.id("ctl00_mainContentPlaceHolder_explorer_ctl00_ctl02_ctl00_CheckboxSelectColumnSelectCheckBox")).isEnabled();

    }

    @Test(priority = 3)
    public void AccessPortfolio() {
        WebElement PortFolio = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_explorer_ctl00__0\"]/td[3]"));
        Actions Act = new Actions(Driver);
        Act.moveToElement(PortFolio).doubleClick().build().perform();

    }


    @Test(priority = 4)
    public void VerifySpotlight() throws InterruptedException {
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@class=\"RadTabStrip RadTabStrip_StyleResearch RadTabStripTop_StyleResearch\"]/div/ul/li[1]/a/span/span/span")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Spotlight_radToolbarSpotlight_i0_ddlSnapshots_Input\"]")).isDisplayed();
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Spotlight_radToolbarSpotlight\"]/div/div/div/ul/li[2]/a/span/span/span/span[1]/span")).isDisplayed();
        String SnapshotText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Spotlight_radToolbarSpotlight\"]/div/div/div/ul/li[1]/div/label")).getText();
        String ExpectedText = "Snapshot:";
        assertEquals(SnapshotText, ExpectedText, "Snapshot view");
        System.out.println(SnapshotText);

    }

    @Test(priority = 5)
    public void Verifysnapshot() throws InterruptedException {
        Thread.sleep(8000);

        WebElement Box = Driver.findElement(By.id("ctl00_mainContentPlaceHolder_ExploreDetail_radTabStripExploreDetail"));
        List<WebElement> Items = Box.findElements(By.tagName("li"));
        Items.get(1).click();

        //Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_radTabStripExploreDetail\"]/div/ul/li[2]/a/span/span/span")).click();
        Thread.sleep(5000);

        String SnapshotMenuText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radToolbarSnapshots\"]/div/div/div/ul/li[1]/a/span/span/span/span[1]")).getText();
        String ExpectedMenuText = "Snapshot";
        assertEquals(SnapshotMenuText, ExpectedMenuText, "Snapshot view");

        String viewbyMenu = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radToolbarSnapshots\"]/div/div/div/ul/li[2]/a/span/span")).getText();
        String ExpectedViewmenuText = "View by: Percent matched";
        assertEquals(viewbyMenu, ExpectedViewmenuText, "View menu taxt");

        String StatusText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[4]/a")).getText();
        String Expected = "Status";
        assertEquals(StatusText, Expected, "Status taxt");
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[4]/a")).click();
        Thread.sleep(8000);

        String Snapshotdate = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[6]")).getText();
        String ExpectedSnapshotDate = "Snapshot Date";
        assertEquals(Snapshotdate, ExpectedSnapshotDate, "Snapshit date");
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[6]")).click();
        Thread.sleep(8000);


        String Matched = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[7]")).getText();
        String ExpectedMatched = "% Matched";
        assertEquals(Matched, ExpectedMatched, "Matched text");
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[7]")).click();
        Thread.sleep(8000);

        String Securities = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[8]")).getText();
        String ExpectedSecurities = "No.Securities";
        assertEquals(Securities, ExpectedSecurities, "Securities text");
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[8]")).click();
        Thread.sleep(8000);


        String AddedOnText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[9]")).getText();
        String ExpectedAddedOn = "Added On";
        assertEquals(AddedOnText, ExpectedAddedOn, "Added on text");
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[9]")).click();
        Thread.sleep(8000);

        String AddedByText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[10]")).getText();
        String ExpectedAddedBy = "Added By";
        assertEquals(AddedByText, ExpectedAddedBy, "Added by text");
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Snapshots_portfolioStockMatch_radGridSnapshots_ctl00_Header\"]/thead/tr/th[10]")).click();
        Thread.sleep(8000);

    }

    @Test(priority = 6)
    public void VerifyReturns() throws InterruptedException {

        String ReturnsText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_radTabStripExploreDetail\"]/div/ul/li[3]/a/span/span/span")).getText();
        String ExpectedReturnsText = "RETURNS";
        assertEquals(ReturnsText, ExpectedReturnsText, "Returns text");
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_radTabStripExploreDetail\"]/div/ul/li[3]/a/span/span/span")).click();
        Thread.sleep(5000);


    }

    @Test(priority = 7)
    public void ExploreAnalyses() throws InterruptedException {
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_radTabStripExploreDetail\"]/div/ul/li[4]/a/span/span/span")).click();
        Thread.sleep(8000);
        //WebElement Box =Driver.findElement(By.id("ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_panelFilter"));
        // List<WebElement> MenuItems = Box.findElements(By.tagName("li"));
        List<WebElement> MenuItems = Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_tabStatus\"]/div/ul/li/a/span/span/span"));
        System.out.println(MenuItems.size());


        for (int i = 0; i < MenuItems.size(); i++) {
            System.out.println(MenuItems.get(i).getText());
            //MenuItems.get(i).click();
            Thread.sleep(5000);
        }
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_tabStatus\"]/div/ul/li[1]/a/span/span/span")).click();
        Thread.sleep(5000);


        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_tabStatus\"]/div/ul/li[2]/a/span/span/span")).click();
        Thread.sleep(5000);


        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_tabStatus\"]/div/ul/li[3]/a/span/span/span")).click();
        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_tabStatus\"]/div/ul/li[4]/a/span/span/span")).click();
        Thread.sleep(5000);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_tabStatus\"]/div/ul/li[5]/a/span/span/span")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void VerifySettings() throws InterruptedException {
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_radTabStripExploreDetail\"]/div/ul/li[5]/a/span/span/span")).click();

        WebElement MenuBar = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div"));
        List<WebElement> SubMenus = Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div/ul/li/a/span/span/span"));
        System.out.println(SubMenus.size());

        for (int i = 0; i < SubMenus.size(); i++) {
            System.out.println(SubMenus.get(i).getText());
            /// SubMenus.get(i).click();
            Thread.sleep(8000);
        }

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div/ul/li[1]/a/span/span/span")).click();
        Thread.sleep(5000);
        String AnalysisTasksText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div/ul/li[1]/a/span/span/span")).getText();
        String ExpectedAnalysisTasksText =  "ANALYSIS TASKS";
        assertEquals(AnalysisTasksText, AnalysisTasksText, "Analysis Tasks");

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div/ul/li[2]/a/span/span/span")).click();
        Thread.sleep(5000);
        String SharesText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div/ul/li[2]/a/span/span/span")).getText();
        String ExpectedSharesText =  "SHARES";
        assertEquals(SharesText, ExpectedSharesText, "Shares Text");

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div/ul/li[3]/a/span/span/span")).click();
        Thread.sleep(5000);
        String LabelsText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div/ul/li[3]/a/span/span/span")).getText();
        String ExpectedLabelsText =  "LABELS";
        assertEquals(LabelsText, ExpectedLabelsText, "Labels Text");

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div/ul/li[4]/a/span/span/span")).click();
        Thread.sleep(5000);
        String FundCodeText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div/ul/li[4]/a/span/span/span")).getText();
        String ExpeFundCodes =  "FUND CODES";
        assertEquals(FundCodeText, ExpeFundCodes, "Fund Codes Text");






    }


}







