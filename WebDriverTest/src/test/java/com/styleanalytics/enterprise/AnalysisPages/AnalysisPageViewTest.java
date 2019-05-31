package com.styleanalytics.enterprise.AnalysisPages;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class AnalysisPageViewTest extends EnterpriseBaseClass {


    @BeforeClass
    public void accessPage() throws IOException, InterruptedException {


        GoTo goTo = new GoTo();
        goTo.goToAnalysisPage();

        Thread.sleep(5000);

    }

    @Test(priority = 1)

    public void verifyHeaders() {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> x = Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_tabStatus\"]/div/ul/li/a/span/span/span"));

        String[] LabelName = new String[5];

        LabelName[0] = "WAITING FOR DATA";
        LabelName[1] = "PENDING";
        LabelName[2] = "RUNNING";
        LabelName[3] = "COMPLETE";
        LabelName[4] = "FAILED";


        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i).getText());
            String labelText = x.get(i).getText();
            softAssert.assertEquals(true, labelText.contains(LabelName[i]));
        }


        softAssert.assertAll();

    }


    @Test(priority = 2)
    public void verifyColumnLables() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th[6]")).getText(), "Audit");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_ctl02_ctl01_labRunAt\"]")).getText(), "Run At");

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_ctl02_ctl01_panFilterBenchmark\"]/a")).getText(), "Benchmark");


        List<WebElement> y = Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th/a"));

        String[] ColumnName = new String[11];

        ColumnName[0] = "Matched";
        ColumnName[1] = "Turnover";
        ColumnName[2] = "Analysis Date";
        ColumnName[3] = "";
        ColumnName[4] = "Report Profile";
        ColumnName[5] = "Analysed Portfolio";
        ColumnName[6] = "";
        ColumnName[7] = "";
        ColumnName[8] = "Universe";
        ColumnName[9] = "Class";
        ColumnName[10] = "Currency";


        for (int a = 0; a < y.size(); a++) {

            softAssert.assertEquals(y.get(a).getText(), ColumnName[a]);
        }

        softAssert.assertAll();


    }


    @Test(priority = 3)
    public void filterByBenchmaark() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> x = Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_tabStatus\"]/div/ul/li/a/span/span/span"));

        x.get(3).click();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_ctl02_ctl01_imgFilteredBenchmark\"]")).click();

        Thread.sleep(5000);

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearchBenchmark_radComboBoxPortfolioQuickSearch_Input\"]")).getAttribute("value"), "select portfolio(s)");

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearchBenchmark_radComboBoxPortfolioQuickSearch_Input\"]")).sendKeys(" MSCI AC AMERICAS");

        Thread.sleep(4000);

        softAssert.assertAll();

    }


    @Test(priority = 4)
    public void filterByAnalysedPortfolio() throws InterruptedException, IOException {


        String portfolioName = property("AnalysisTaskPortfolio");

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> x = Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_tabStatus\"]/div/ul/li/a/span/span/span"));

        x.get(3).click();

        List<WebElement> y = Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th/a"));


        y.get(5).click();

        Thread.sleep(3000);

        softAssert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearchBenchmark_radComboBoxPortfolioQuickSearch_Input\"]")).getAttribute("value"), "select portfolio(s)");

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input\"]")).click();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input\"]")).sendKeys(portfolioName);

        Driver.findElement(By.xpath("//*[@id=\"quickSearchItem\"]/span[2]")).click();

        Thread.sleep(4000);

        y = Driver.findElements(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridAnalysis_gridAnalysis_ctl00_Header\"]/thead/tr/th/a"));

        y.get(5).click();

        Thread.sleep(3000);

        System.out.println(Driver.findElement(By.id("ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input")).getAttribute("value"));

        softAssert.assertEquals(Driver.findElement(By.id("ctl00_mainContentPlaceHolder_gridAnalysis_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input")).getAttribute("value"), portfolioName);


        softAssert.assertAll();


    }


}
