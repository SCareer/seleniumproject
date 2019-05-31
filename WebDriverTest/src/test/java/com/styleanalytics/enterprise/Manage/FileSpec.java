package com.styleanalytics.enterprise.Manage;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Loader.LoadPage;
import com.styleanalytics.enterprise.Loader.LoadTest;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.Loader.LoadPage;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Viswanath on 17/10/2017.   t
 */
public class FileSpec extends TestBase {

    GoTo goTo = new GoTo();
    WebDriver driver;

    @BeforeClass
    public void fileSpecSetup(){

        driver = getDriver();
    }

    @Test
    public void checkADRMap() throws IOException, InterruptedException {


        try {
            goTo.goToLoadPage();
            LoadPage loadPage = new LoadPage(getDriver());
            loadPage.uploadFile("C:\\Selenium\\ADRs for Vish.xlsx");

            Thread.sleep(3000);

            //Verify selected fileSpec
            String fileSpec = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridFiles_ctl00_ctl04_ddlFileSpec_Input\"]")).getAttribute("value");
            Assert.assertEquals(fileSpec, "With ADR Map");

            //Open the file Spec

            driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridFiles_ctl00_ctl04_imgPreview\"]")).click();
            Thread.sleep(5000);


            //Verify Map ADR checkbox

            driver.switchTo().frame("radWindowDefault");

            WebElement adrCheckBoxLabel = driver.findElement(By.xpath("--//*[@id=\"ctl00_mainContentPlaceHolder_FileSpecificationSummary_FileSpecificationSummary\"]/div[7]/label"));
            Assert.assertEquals(adrCheckBoxLabel.getText(), "Map ADR to underlying security:");

            driver.switchTo().defaultContent();

            driver.findElement(By.xpath("//*[@id=\"RadWindowWrapper_ctl00_mainContentPlaceHolder_radWindowDefault\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li/a")).click();


            //Add the snapshot date
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridFiles_ctl00_ctl04_dateSnapshot_dateInput\"]")).sendKeys("01/01/2017");
            driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridFiles_ctl00_ctl04_dateSnapshot_popupButton\"]")).click();

            //Add a Portfolio a Name
            //get current date time with Date()
            DateFormat dateFormat = new SimpleDateFormat("d/MM/YY hh:mm:ss");
            Date date = new Date();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridFiles_ctl00_ctl04_radComboPortfolioName_radComboBoxPortfolioQuickSearch_Input\"]")).sendKeys(" " + dateFormat.format(date) + " - With ADR Map");
            driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_gridFiles_ctl00\"]/thead/tr/th[8]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("/*//*[@id='ctl00_mainContentPlaceHolder_header_cmdNext_input']")).click();
            Thread.sleep(20000);

            //Show all Securities

            driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_radMenuStockMatching\"]/ul/li/a/img")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_radMenuStockMatching\"]/ul/li/div/ul/li[2]/a/span")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_radMenuStockMatching\"]/ul/li/div/ul/li[2]/div/ul/li[1]/a/span")).click();
            Thread.sleep(9000);

            //*[@id="ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00__0"]/td[11]
            //*[@id="ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00__1"]/td[11]

            WebElement isAdr0 = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00__0\"]/td[11]"));
            Assert.assertEquals(isAdr0.getText(), "yes");
            WebElement isAdr1 = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_portfolioStockMatch_radGridSecurities_ctl00__1\"]/td[11]"));
            Assert.assertEquals(isAdr1.getText(), "no");
        }catch(Exception e)

        {
            Utility ut = new Utility();
            ut.takeScreenshotOnError("checkADRMap","ADRMap",e);

        }
    }
}
