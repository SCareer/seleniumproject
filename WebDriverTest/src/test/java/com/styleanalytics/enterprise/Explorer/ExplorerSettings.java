package com.styleanalytics.enterprise.Explorer;


import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ExplorerSettings extends EnterpriseBaseClass {


    @Test(priority = 1)
    public void AccessSettings() throws InterruptedException {
        Driver.findElement(By.id("topNav2_hlExplore")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_explorer_ctl00__0\"]/td[3]")).click();
        Thread.sleep(8000);
        WebElement PortFolio = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_explorer_ctl00__0\"]/td[3]"));
        Actions Act = new Actions(Driver);
        Act.moveToElement(PortFolio).doubleClick().build().perform();
        Thread.sleep(8000);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_radTabStripExploreDetail\"]/div/ul/li[5]/a/span/span/span")).click();

    }

    @Test(priority = 2)

    public void AnalysisTasks() throws InterruptedException {
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div/ul/li[1]/a/span/span/span")).click();
        Thread.sleep(5000);
        String AnalysisTasksText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_tabSettings\"]/div/ul/li[1]/a/span/span/span")).getText();
        String ExpectedAnalysisTasksText =  "ANALYSIS TASKS";
        assertEquals(AnalysisTasksText, AnalysisTasksText, "Analysis Tasks");


    }
    //rgMasterTable rgClipCells
    @Test(priority = 3)
    public void AnalysisColumns() throws InterruptedException, IOException {

        try {
            //Verify Type column
            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[3]/a")).click();
            Thread.sleep(5000);
            String ActualTypeTex = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[3]/a")).getText();
            String TypeText = "Type";
            assertEquals(ActualTypeTex, TypeText, "Type Text");


            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[4]/a")).click();
            Thread.sleep(5000);
            String ActualBenchMarkText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[4]/a")).getText();
            String ExpBenchMark = "Benchmark Name";
            assertEquals(ActualBenchMarkText, ExpBenchMark, "ExpBenchMark Text");


            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[5]/a")).click();
            Thread.sleep(5000);
            String ActualUniverseNameText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[5]/a")).getText();
            String ExpUniverse = "Universe Name";
            assertEquals(ActualUniverseNameText, ExpUniverse, "Universe Name");


            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[6]/a")).click();
            Thread.sleep(5000);
            String ActualCalcSetText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[6]/a")).getText();
            String ExpCalcSetText = "CalcSet";
            assertEquals(ActualUniverseNameText, ExpUniverse, "CalcSet Text");

            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[7]/a")).click();
            Thread.sleep(5000);
            String ActualClassText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[7]/a")).getText();
            String ExpClassText = "Class.";
            assertEquals(ActualClassText, ExpClassText, "Class. Text");

            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[8]/a")).click();
            Thread.sleep(5000);
            String ActualCurrencyText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[8]/a")).getText();
            String ExpCurrencyText = "Currency";
            assertEquals(ActualCurrencyText, ExpCurrencyText, "Currency Text");

            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[9]/a")).click();
            Thread.sleep(5000);
            String ActAutoText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[9]/a")).getText();
            String ExpAutoText = "Auto";
            assertEquals(ActAutoText, ExpAutoText, "Auto Text");


            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[10]/a")).click();
            Thread.sleep(5000);
            String ActualSharedText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[10]/a")).getText();
            String ExpSharedText = "Shared?";
            assertEquals(ActualSharedText, ExpSharedText, "Sahred? Text");


            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[11]/a")).click();
            Thread.sleep(5000);
            String ActualAccessText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[11]/a")).getText();
            String ExpAccessText = "Access";
            assertEquals(ActualAccessText, ExpAccessText, "Access Text");


            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[12]/a")).click();
            Thread.sleep(5000);
            String ActualExportsText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[12]/a")).getText();
            String ExpExportsText = "Exports";
            assertEquals(ActualExportsText, ExpExportsText, "Exports Text");


            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[13]/a")).click();
            Thread.sleep(5000);
            String ActualCreatedText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[13]/a")).getText();
            String ExpCreatedByText = "Created By";
            assertEquals(ActualCreatedText, ExpCreatedByText, "Createdby Text");


            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[14]/a")).click();
            Thread.sleep(5000);
            String ActualTaskName = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radGridAutomatedAnalyses_ctl00_Header\"]/thead/tr/th[14]/a")).getText();
            String ExpTaskName = "Task Name";
            assertEquals(ActualTaskName, ExpTaskName, "TaskName Text");
        }catch(Exception e)

        {
            System.out.println("LoadPortfolio Test Failed"+e);
            File scrFile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("c:\\Selenium\\Screenshots\\Errors\\screenshot_AnalysisColumns.jpg"));

        }


    }

    @Test(priority = 4)
    public void CreateAutomatedTask() throws InterruptedException, IOException {

        try {

            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_Settings_gridAnalysisSheduled_radToolbarAutomatedAnalyses\"]/div/div/div/ul/li[1]/a/span/span/span/span[1]")).click();
            Thread.sleep(5000);
            Driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[1]/div/ul/li[1]")).click();
            Thread.sleep(5000);

            String ActWindowTitle = Driver.findElement(By.xpath("//*[@id=\"RadWindowWrapper_ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/em")).getText();
            String ExpectedTitle = "Settings - Add Automated Task";
            assertEquals(ActWindowTitle, ExpectedTitle, "WindowTitle");

            Driver.findElement(By.id("ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboBenchmark_radComboBoxPortfolioQuickSearch_Input")).sendKeys(" MSCI EUROPE");
            Thread.sleep(5000);
            Driver.findElement(By.id("ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboCurrency_Input")).sendKeys(" EURO");
            Thread.sleep(5000);
            Driver.findElement(By.id("ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboCalcSet_radComboCalcSet_Input")).sendKeys(" Style Research Default");
            Thread.sleep(5000);
            Driver.findElement(By.id("ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboUniverse_radComboBoxPortfolioQuickSearch_Input")).sendKeys(" Developed Europe (ICB)");
            Thread.sleep(5000);
            Driver.findElement(By.id("ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radComboSectorClassificationType_Input")).sendKeys(" ICB");
            Thread.sleep(5000);

            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radTabStripAutomatedAnalysisTask\"]/div/ul/li[2]/a/span/span/span")).click();
            Thread.sleep(5000);

            Driver.findElement(By.id("ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_shareList_ctl01_fullControlAccess")).click();
            Thread.sleep(5000);


            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radTabStripAutomatedAnalysisTask\"]/div/ul/li[3]/a/span/span/span")).click();
            Thread.sleep(5000);


            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_rbAutomatedAnalysisTaskAutoCatchup\"]/span[1]")).click();
            Thread.sleep(5000);

            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radioAutomatedAnalysisTaskAutoGenerate\"]/span[1]")).click();
            Thread.sleep(5000);

            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_rbAutomatedAnalysisTaskPreviousSnapshot\"]/span[1]")).click();
            Thread.sleep(5000);

            Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_radButtonDispatchChildren\"]/span[1]")).click();
            Thread.sleep(5000);


            Driver.findElement(By.id("ctl00_mainContentPlaceHolder_automatedAnalysisTaskEditWindow_C_automatedTaskEditContent_btnSave_input")).click();
            Thread.sleep(5000);


            // Click on the confirmation popup

            String dynamicID = Driver.findElement(By.xpath("//iframe[contains(@name,'confirm')]")).getAttribute("name");
            Driver.findElement(By.xpath("//*[@id='" + dynamicID + "_content']/div/div[2]/a[1]/span/span")).click();
            Thread.sleep(5000);
        }catch(Exception e)

        {
            System.out.println("LoadPortfolio Test Failed"+e);
            File scrFile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("c:\\Selenium\\Screenshots\\Errors\\screenshot_CreateAutomatedTask.jpg"));

        }
    }


}
