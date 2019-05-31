package com.styleanalytics.enterprise.AnalysisPages;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class AnalysisSettings extends EnterpriseBaseClass {

GoTo goTo;

    @BeforeClass
    public void accessPortfolio() throws IOException, InterruptedException {

        GoTo goTo=new GoTo();

        goTo.goToExplorerPage();

        String portfolioName = property("AnalysisTaskPortfolio");

        Utility.portfolioQuickSearchInExplorer(portfolioName);

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_radTabStripExploreDetail\"]/div/ul/li[4]/a/span/span/span")).click();

        Thread.sleep(8000);
    }


    @Test(priority = 1)
    public void verifyAnalysisLabels() throws InterruptedException {


     SoftAssert softAssert = new SoftAssert();

    // ExplorerPage Ep= new ExplorerPage();

     //Ep.ExplorePage();

     //Ep.portfolioSelection();

    // Ep.AccessPortfolio();

    // Thread.sleep(3000);

   //  Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_radTabStripExploreDetail\"]/div/ul/li[4]/a/span/span/span")).click();

   //  Thread.sleep(4000);

    boolean checkBox = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_ctl02_ctl01_CheckboxSelectColumnSelectCheckBox\"]")).isDisplayed();

    softAssert.assertEquals(checkBox, true);

    softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[6]")).getText(), "Audit");

    softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[7]")).getText(), "Matched");

    softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[8]")).getText(), "Turnover");

    softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[10]")).getText(), "Analysis Date");

    softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[11]")).getText(), "Run At");

    softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[12]/a")).getText(),"Report Profile" );

    softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[13]/a")).getText(),"Benchmark");

    softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[14]/a")).getText(), "Universe" );

    softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[15]/a")).getText(), "Class");

    softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[16]/a")).getText(), "Currency");

    softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[17]/a")).getText(), "Submitted By");

    softAssert.assertAll();

    }

    @Test(priority = 2)
    public void verifyHeaders(){


        SoftAssert softAssert = new SoftAssert();

        String WaitingForDataText= Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_tabStatus\"]/div/ul/li[1]/a/span/span/span")).getText();


        softAssert.assertEquals(true, WaitingForDataText.contains("WAITING FOR DATA"));


        String PendingText = Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_tabStatus\"]/div/ul/li[2]/a/span/span/span")).getText();

        softAssert.assertEquals(true, PendingText.contains("PENDING"));


        String runningText= Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_tabStatus\"]/div/ul/li[3]/a/span/span/span")).getText();

        softAssert.assertEquals(true, runningText.contains("RUNNING"));


        String completeText= Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_tabStatus\"]/div/ul/li[4]/a/span/span/span")).getText();

        softAssert.assertEquals(true, completeText.contains("COMPLETE"));


        String failedText= Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_tabStatus\"]/div/ul/li[5]/a/span/span/span")).getText();

        softAssert.assertEquals(true, failedText.contains("FAILED"));

        softAssert.assertAll();


    }

           @Test(priority = 3)

           public void sortByMatched() throws InterruptedException {

           System.out.println(Driver.findElement((By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00__0\"]/td[7]"))).getText());

           Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[7]/a")).click();

           Thread.sleep(10000);

           System.out.println(Driver.findElement((By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00__0\"]/td[7]"))).getText());


       }


            @Test(priority = 4)
            public void sortByTurnover() throws InterruptedException {

             String turnOverTextBeforeSort= Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00__0\"]/td[8]")).getText();

             System.out.println(turnOverTextBeforeSort);

             Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[8]/a")).click();

             Thread.sleep(5000);

             String turnOverTextAfterSort= Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_ExploreDetail_AnalysisCompleted_gridAnalysis_gridAnalysis_ctl00__0\"]/td[8]")).getText();

             System.out.println(turnOverTextAfterSort);




            }




}
