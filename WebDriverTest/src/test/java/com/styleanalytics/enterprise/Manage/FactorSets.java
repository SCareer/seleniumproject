package com.styleanalytics.enterprise.Manage;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Viswanath on 04/09/2017.
 */
public class FactorSets extends EnterpriseBaseClass {

    DateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-YYYY hh:mm");
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
    Date date = new Date();
    GoTo goTo=new GoTo();

    //Create new factor Set

    @Test
    public void createFactorSet() throws IOException, InterruptedException {


        goTo.goToFactorSet();

        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdCreateNew_input']")).click(); //Click on the Create new button

        Driver.findElement(By.xpath("//*[@id='txtName']")).sendKeys(dateTimeFormat.format(date) + " Factor Set");

        //*[@id='divFactors']/div[1]/a
        Thread.sleep(5000);
        Driver.findElement(By.linkText("Value")).click();
        Driver.findElement(By.linkText("Growth")).click();
        Driver.findElement(By.linkText("Volatility")).click();
        Driver.findElement(By.linkText("Momentum")).click();
        Driver.findElement(By.linkText("Other")).click();
        Driver.findElement(By.linkText("Quality")).click();
        Driver.findElement(By.linkText("ESG")).click();
        Driver.findElement(By.linkText("Economic")).click();
        Driver.findElement(By.linkText("User Defined")).click();
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdSaveFactorSet_input']")).click();

        Thread.sleep(5000);
    }

    //Edit Factor Set
    @Test
    public void editFactorSet() throws IOException, InterruptedException {

        goTo.goToFactorSet();

        Thread.sleep(5000);
        //Search for factor set and click edit
        Driver.findElement(By.xpath("//*[@id='divFactorSets']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(dateFormat.format(date));
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='divFactorSets']/div[4]/div[3]/div/div/div[5]/a")).click();

        //Removing couple of factor category from the existing factor set
        Driver.findElement(By.linkText("ESG")).click();
        Driver.findElement(By.linkText("Economic")).click();

        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdSaveFactorSet_input']")).click();

        Thread.sleep(5000);

    }

    //Delete factor set
    @Test(dependsOnMethods = {"createFactorSet","verifyFactorTypeAndColorForExisting"})
    public void deleteFactorSet() throws IOException, InterruptedException {

        goTo.goToFactorSet();


        Thread.sleep(5000);
        //Search for factor set and click edit
        Driver.findElement(By.xpath("//*[@id='divFactorSets']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(dateFormat.format(date));
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='divFactorSets']/div[4]/div[3]/div/div/div[6]/a")).click();
        Thread.sleep(5000);

        // Click on the confirmation popup

        String dynamicID = Driver.findElement(By.xpath("//iframe[contains(@name,'confirm')]")).getAttribute("name");
        Driver.findElement(By.xpath("//*[@id='" + dynamicID + "_content']/div/div[2]/a[1]/span/span")).click();
        Thread.sleep(5000);


    }

    @Test
    public void verifyFactorTypeAndColorForNew() throws IOException, InterruptedException {

        goTo.goToFactorSet();

        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdCreateNew_input']")).click(); //Click on the Create new button

        Thread.sleep(3000);

        verifyFactorTypeAndColor();


    }

    @Test(dependsOnMethods = "createFactorSet")
    public void verifyFactorTypeAndColorForExisting() throws IOException, InterruptedException {

        goTo.goToFactorSet();

        //Search for factor set and click edit
        Driver.findElement(By.xpath("//*[@id='divFactorSets']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(dateFormat.format(date));
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='divFactorSets']/div[4]/div[3]/div/div/div[5]/a")).click();
        Thread.sleep(3000);

        verifyFactorTypeAndColor();


    }


    public void findFactorTypeAndColor(String factorType, String factorName,int i) throws IOException, InterruptedException {

        /*Is the Factor Displayed
          Click on the factor
          Check the background color
         */

        Driver.findElement(By.xpath("//span[text()='"+factorName+"']")).isDisplayed(); //Check whether factor displayed or not

        String isSelected = Driver.findElement(By.xpath("//*[@id='divFactors']/div["+i+"]")).getAttribute("class");

        if(isSelected.equals("factorSwatch deselectedFactor")){


            Assert.assertEquals(isSelected,"factorSwatch deselectedFactor"); //Verify whether factor is deselected as default

            Driver.findElement(By.xpath("//span[text()='"+factorName+"']")).click(); //Click on the factor

        }else{

            Assert.assertEquals(isSelected,"factorSwatch"); //Verify whether factor is Selected

            Driver.findElement(By.xpath("//span[text()='"+factorName+"']")).click(); //Click on the factor

        }

        String colour = Driver.findElement(By.xpath("//*[@id='divFactors']/div["+i+"]/div")).getAttribute("style"); //Get the colour of the factor


        //Verify the color of the factor depends on the factor type.

        if(factorType.equalsIgnoreCase("Value")){

            String valueColor = "background-color: rgb(1, 147, 207);";
            Assert.assertEquals(colour,valueColor);


        }else if (factorType.equalsIgnoreCase("Growth")){

            String growthColor = "background-color: rgb(59, 144, 103);";
            Assert.assertEquals(colour,growthColor);


        }else if(factorType.equalsIgnoreCase("Volatility")){

            String riskColor = "background-color: rgb(171, 64, 48);";
            Assert.assertEquals(colour,riskColor);


        }else if(factorType.equalsIgnoreCase("Momentum")){

            String momentumColor = "background-color: rgb(42, 42, 42);";
            Assert.assertEquals(colour,momentumColor);


        }else if(factorType.equalsIgnoreCase("Other")){

            String otherColor = "background-color: rgb(201, 186, 59);";
            Assert.assertEquals(colour,otherColor);


        }else if(factorType.equalsIgnoreCase("Quality")){

            String qualityColor = "background-color: rgb(134, 36, 175);";
            Assert.assertEquals(colour,qualityColor);


        }else if(factorType.equalsIgnoreCase("ESG")){

            String esgColor = "background-color: rgb(129, 129, 69);";
            Assert.assertEquals(colour,esgColor);


        }else if(factorType.equalsIgnoreCase("Economic")){

            String economicColor = "background-color: rgb(112, 128, 144);";
            Assert.assertEquals(colour,economicColor);


        }else if(factorType.equalsIgnoreCase("User Defined")){

            String userDefinedColor = "background-color: rgb(191, 191, 191);";
            Assert.assertEquals(colour,userDefinedColor);


        }

    }

    @Test
    public void verifyDefaultFactorSets() throws IOException, InterruptedException {

        goTo.goToFactorSet();

        Thread.sleep(3000);

        String defaultsFactorSets[] = {"Economic Factors","ESG Factors","Everything","Growth Factors","Momentum Factors","Other Factors","Quality Factors","Volatility Factors","Style Research Default Factors","User Defined Factors","Value Factors"};

        for(int i=0;i<defaultsFactorSets.length;i++){

            String factorSet = defaultsFactorSets[i];
            Driver.findElement(By.xpath("//*[@id='divFactorSets']/div[4]/div[1]/div[2]/div[1]/input")).clear();
            Driver.findElement(By.xpath("//*[@id='divFactorSets']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(factorSet);
            Thread.sleep(2000);

            WebElement factorSetName  = Driver.findElement(By.xpath("//*[@id='divFactorSets']/div[4]/div[3]/div/div/div[1]"));

            Assert.assertEquals(factorSetName.getText(),factorSet); //Verifying the factor set name in the search result

            WebElement createdBy = Driver.findElement(By.xpath("//*[@id='divFactorSets']/div[4]/div[3]/div/div/div[2]"));

            Assert.assertEquals(createdBy.getText(),"administrator@SYSTEM.COM");

        }

    }

    public void verifyFactorTypeAndColor() throws IOException, InterruptedException {

       findFactorTypeAndColor("Value","Book to Price",2);
        findFactorTypeAndColor("Value","Book To Price (I)",3);
        findFactorTypeAndColor("Value","Dividend Yield",4);
        findFactorTypeAndColor("Value","Dividend Yield (I)",5);
        findFactorTypeAndColor("Value","Forecast Dividend Yield",6);
        findFactorTypeAndColor("Value","Dividend Payout Ratio",7);
        findFactorTypeAndColor("Value","Net Buyback Yield",8);
        findFactorTypeAndColor("Value","Net Debt Paydown Yield",9);
        findFactorTypeAndColor("Value","Net Payout Yield",10);
        findFactorTypeAndColor("Value","Shareholder Yield",11);
        findFactorTypeAndColor("Value","Earnings Yield",12);
        findFactorTypeAndColor("Value","Earnings Yield (I)",13);
        findFactorTypeAndColor("Value","Cyc Adj Engs Yld",14);
        findFactorTypeAndColor("Value","Inverse PEG",15);
        findFactorTypeAndColor("Value","Inverse PEGY",16);
        findFactorTypeAndColor("Value","Forecast Earnings Yield",17);
        findFactorTypeAndColor("Value","Forecast Engs Yield FY1",18);
        findFactorTypeAndColor("Value","Forecast Engs Yield FY2",19);
        findFactorTypeAndColor("Value","Cash Flow Yield",20);
        findFactorTypeAndColor("Value","Cash Flow Yield (I)",21);
        findFactorTypeAndColor("Value","Free Cash Flow Yield",22);
        findFactorTypeAndColor("Value","Free Cash Flow Yield (I)",23);
        findFactorTypeAndColor("Value","Sales to Price",24);
        findFactorTypeAndColor("Value","Sales to Price (I)",25);
        findFactorTypeAndColor("Value","Forecast Sales Yield",26);
        findFactorTypeAndColor("Value","EBITDA to Price",27);
        findFactorTypeAndColor("Value","Sales to EV",28);
        findFactorTypeAndColor("Value","EBITDA to EV",29);
        findFactorTypeAndColor("Value","EBIT to EV",30);

        findFactorTypeAndColor("Growth","Return on Equity",32);
        findFactorTypeAndColor("Growth","Forecast ROE",33);
        findFactorTypeAndColor("Growth","Return on Invested Capital",34);
        findFactorTypeAndColor("Growth","Return on Assets",35);
        findFactorTypeAndColor("Growth","Gross Profits to Assets",36);
        findFactorTypeAndColor("Growth","Sustainable Growth",37);
        findFactorTypeAndColor("Growth","Dividend Growth 5Y",38);
        findFactorTypeAndColor("Growth","Earnings Growth",39);
        findFactorTypeAndColor("Growth","Earnings Growth 5Y",40);
        findFactorTypeAndColor("Growth","Net Profit Margin",41);
        findFactorTypeAndColor("Growth","Operating Profit Margin",42);
        findFactorTypeAndColor("Growth","Gross Profit Margin",43);
        findFactorTypeAndColor("Growth","Sales Growth",44);
        findFactorTypeAndColor("Growth","Sales Growth 5Y",45);
        findFactorTypeAndColor("Growth","Asset Growth 3Y",46);
        findFactorTypeAndColor("Growth","Asset Growth 5Y",47);
        findFactorTypeAndColor("Growth","Capex Growth 3Y",48);
        findFactorTypeAndColor("Growth","Capex Growth 5Y",49);
        findFactorTypeAndColor("Growth","Forecast Growth 12M",50);
        findFactorTypeAndColor("Growth","Forecast FY1 Revisions",51);
        findFactorTypeAndColor("Growth","Forecast 12M Revisions (1M)",52);
        findFactorTypeAndColor("Growth","Forecast 12M Revisions",53);
        findFactorTypeAndColor("Growth","Forecast Sales Growth 12M",54);
        findFactorTypeAndColor("Growth","Forecast Engs Gr Long Term",55);
        findFactorTypeAndColor("Growth","Forecast Sales Gr Long Term",56);
        findFactorTypeAndColor("Growth","Forecast Dividend Growth",57);
        findFactorTypeAndColor("Growth","UDF Category",58);

        findFactorTypeAndColor("Quality","Low Gearing",60);
        findFactorTypeAndColor("Quality","Earnings Growth Stability",61);
        findFactorTypeAndColor("Quality","Sales Growth Stability",62);
        findFactorTypeAndColor("Quality","Returns Stability",63);
        findFactorTypeAndColor("Quality","Earnings Growth Stability 5Y",64);
        findFactorTypeAndColor("Quality","Sales Growth Stability 5Y",65);
        findFactorTypeAndColor("Quality","Low Accruals",66);

        findFactorTypeAndColor("Volatility","Market Cap",68);
        findFactorTypeAndColor("Volatility","Log Market Cap",69);
        findFactorTypeAndColor("Volatility","Market Beta",70);
        findFactorTypeAndColor("Volatility","Daily Volatility 1Y",71);
        findFactorTypeAndColor("Volatility","Volatility 1Y",72);
        findFactorTypeAndColor("Volatility","Volatility 3Y",73);
        findFactorTypeAndColor("Volatility","Volatility 5Y",74);

        findFactorTypeAndColor("Momentum","Momentum ST",76);
        findFactorTypeAndColor("Momentum","Momentum MT",77);
        findFactorTypeAndColor("Momentum","Momentum 12-1",78);
        //findFactorTypeAndColor("Momentum","RavenPack - Company Volume",79);
       // findFactorTypeAndColor("Momentum","RavenPack - Stock Sentiment",80); -------Removed Factors


        findFactorTypeAndColor("Other","Debt to Equity",80);
        findFactorTypeAndColor("Other","Assets to Equity",81);
        findFactorTypeAndColor("Other","Asset Turnover",82);
        findFactorTypeAndColor("Other","Foreign Sales",83);
        findFactorTypeAndColor("Other","Trading Turnover 3M",84);
        findFactorTypeAndColor("Other","Int Coverage Ratio (ex-fin)",85);
        findFactorTypeAndColor("Other","Current Ratio (ex-fin)",86);
        findFactorTypeAndColor("Other","Quick Ratio (ex-fin)",87);


        findFactorTypeAndColor("ESG","Trucost - Carbon Footprint",89);
        findFactorTypeAndColor("ESG","Trucost - Impact Ratio",90);
        findFactorTypeAndColor("ESG","MSCI - Social Resp (x)",91);
        findFactorTypeAndColor("ESG","MSCI GRId - Corp Gov (x)",92);
        findFactorTypeAndColor("ESG","MSCI GRId - Corp Gov Audit (x)",93);
        findFactorTypeAndColor("ESG","MSCI GRId - Corp Gov Board (x)",94);
        findFactorTypeAndColor("ESG","MSCI GRId - Corp Gov Comp (x)",95);
        findFactorTypeAndColor("ESG","MSCI GRId - Corp Gov Share (x)",96);
        findFactorTypeAndColor("ESG","GMI - Corp Gov",97);
        findFactorTypeAndColor("ESG","MSCI GM Accounting",98);
        findFactorTypeAndColor("ESG","MSCI GM Board",99);
        findFactorTypeAndColor("ESG","GMI - Environmental (x)",100);
        findFactorTypeAndColor("ESG","MSCI GM Corp Gov Global Rank",101);
        findFactorTypeAndColor("ESG","GMI - Overall (x)",102);
        findFactorTypeAndColor("ESG","MSCI GM Own & Contrl",103);
        findFactorTypeAndColor("ESG","MSCI GM Pay",104);
        findFactorTypeAndColor("ESG","GMI - Social (x)",105);
        findFactorTypeAndColor("ESG","MSCI AGR",106);
        findFactorTypeAndColor("ESG","GMI - Forensic Alpha (x)",107);
        findFactorTypeAndColor("ESG","MSCI ESG Corp Behavior",108);
        findFactorTypeAndColor("ESG","MSCI ESG Climate Change",109);
        findFactorTypeAndColor("ESG","MSCI ESG Corp Gov Score",110);
        findFactorTypeAndColor("ESG","MSCI ESG Envir",111);
        findFactorTypeAndColor("ESG","MSCI ESG Envir Opps",112);
        findFactorTypeAndColor("ESG","MSCI ESG Overall",113);
        findFactorTypeAndColor("ESG","MSCI ESG Governance",114);
        findFactorTypeAndColor("ESG","MSCI IVA - Gov Pub Policy (x)",115);
        findFactorTypeAndColor("ESG","MSCI ESG Human Capital",116);
        findFactorTypeAndColor("ESG","MSCI ESG Natural Capital",117);
        findFactorTypeAndColor("ESG","MSCI ESG Product Liability",118);
        findFactorTypeAndColor("ESG","MSCI ESG Social",119);
        findFactorTypeAndColor("ESG","MSCI ESG Social Opps",120);
        findFactorTypeAndColor("ESG","MSCI ESG Pollution & Waste",121);
        findFactorTypeAndColor("ESG","oekom - ESG Overall",122);
        findFactorTypeAndColor("ESG","oekom - Environmental",123);
        findFactorTypeAndColor("ESG","oekom - Social & Governance",124);

        findFactorTypeAndColor("Economic","Exposure to GDP Shock",126);
        findFactorTypeAndColor("Economic","Exposure to Currency Gain",127);
        findFactorTypeAndColor("Economic","Exposure to Inflation",128);
        findFactorTypeAndColor("Economic","Exposure to Short Rate",129);
        findFactorTypeAndColor("Economic","Exposure to Oil Return",130);
        findFactorTypeAndColor("Economic","Exposure to Gold Return",131);

        findFactorTypeAndColor("User Defined","Test UDF",133);


    }
}