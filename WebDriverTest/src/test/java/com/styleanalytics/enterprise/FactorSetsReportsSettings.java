package com.styleanalytics.enterprise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 05/09/2017.
 */
public class FactorSetsReportsSettings extends EnterpriseBaseClass{

    GoTo g = new GoTo();

    @Test
    public void styleExposureReportSettings() throws IOException, InterruptedException {

    g.goToReportsPage();

    Thread.sleep(10000);

    //Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_ctl00_hlSettings']")).click();

    Driver.findElement(By.xpath("//img[@id='rhsHamb']")).click();

    Thread.sleep(3000);

    Driver.findElement(By.xpath("//span[contains(text(),'Show settings')]")).click();

    Driver.switchTo().frame(0);

    WebElement viewPreference = Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_tabStripPreferences']/div/ul/li[1]/a/span/span/span"));

    Assert.assertEquals(viewPreference.getText(),"View preferences");

        findFactorTypeAndColor("Value","Book to Price per Share",2);
        findFactorTypeAndColor("Value","Book To Price (Interim)",3);
        findFactorTypeAndColor("Value","Dividend Yield",4);
        findFactorTypeAndColor("Value","Dividend Yield (Interim)",5);
        findFactorTypeAndColor("Value","IBES Div Yld",6);
        findFactorTypeAndColor("Value","Dividend Payout Ratio",7);
        findFactorTypeAndColor("Value","Net Buyback Yield",8);
        findFactorTypeAndColor("Value","Net Debt Paydown Yield",9);
        findFactorTypeAndColor("Value","Net Payout Yield",10);
        findFactorTypeAndColor("Value","Total Shareholder Yield",11);
        findFactorTypeAndColor("Value","Earnings Yield",12);
        findFactorTypeAndColor("Value","Earnings Yield (Interim)",13);
        findFactorTypeAndColor("Value","Cyclically Adjusted Earnings Yield",14);
        findFactorTypeAndColor("Value","Inverse PEG",15);
        findFactorTypeAndColor("Value","Inverse PEGY",16);
        findFactorTypeAndColor("Value","IBES Engs Yld",17);
        findFactorTypeAndColor("Value","IBES FY1 Engs Yld",18);
        findFactorTypeAndColor("Value","IBES FY2 Engs Yld",19);
        findFactorTypeAndColor("Value","Cashflow Yield",20);
        findFactorTypeAndColor("Value","Cashflow Yield (Interim)",21);
        findFactorTypeAndColor("Value","Free Cashflow Yield",22);
        findFactorTypeAndColor("Value","Free Cashflow Yield (Interim)",23);
        findFactorTypeAndColor("Value","Sales to Price",24);
        findFactorTypeAndColor("Value","Sales to Price (Interim)",25);
        findFactorTypeAndColor("Value","IBES Sales Yld",26);
        findFactorTypeAndColor("Value","EBITDA to Price",27);
        findFactorTypeAndColor("Value","Sales to EV",28);
        findFactorTypeAndColor("Value","EBITDA to EV",29);
        findFactorTypeAndColor("Value","EBIT to EV",30);

        findFactorTypeAndColor("Growth","Return on Equity",32);
        findFactorTypeAndColor("Growth","IBES ROE",33);
        findFactorTypeAndColor("Growth","Return on Invested Capital",34);
        findFactorTypeAndColor("Growth","Return on Assets",35);
        findFactorTypeAndColor("Growth","Gross Profits to Assets",36);
        findFactorTypeAndColor("Growth","Earnings Growth",37);
        findFactorTypeAndColor("Growth","5 Year Earnings Growth",38);
        findFactorTypeAndColor("Growth","Income/Sales",39);
        findFactorTypeAndColor("Growth","Operating Profit Margin",40);
        findFactorTypeAndColor("Growth","Gross Profit Margin",41);
        findFactorTypeAndColor("Growth","Sales Growth",42);
        findFactorTypeAndColor("Growth","5 Year Sales Growth",43);
        findFactorTypeAndColor("Growth","3 Year Asset Growth",44);
        findFactorTypeAndColor("Growth","5 Year Asset Growth",45);
        findFactorTypeAndColor("Growth","3 Year Capex Growth",46);
        findFactorTypeAndColor("Growth","5 Year Capex Growth",47);
        findFactorTypeAndColor("Growth","IBES 12Mth Gr",48);
        findFactorTypeAndColor("Growth","IBES 1Yr Rev",49);
        findFactorTypeAndColor("Growth","IBES 12M Earnings Rev 1M",50);
        findFactorTypeAndColor("Growth","IBES 12M Earnings Rev 3M",51);
        findFactorTypeAndColor("Growth","IBES Sales 12mth Gr",52);
        findFactorTypeAndColor("Growth","IBES Engs Long Term Gr",53);
        findFactorTypeAndColor("Growth","IBES Sales Long Term Gr",54);
        findFactorTypeAndColor("Growth","Sustainable Growth Rate",55);
        findFactorTypeAndColor("Growth","5 Year Dividend Growth",56);
        findFactorTypeAndColor("Growth","IBES Dividend Growth",57);

        findFactorTypeAndColor("Risk","Market Cap",59);
        findFactorTypeAndColor("Risk","Log Market Cap",60);
        findFactorTypeAndColor("Risk","Market Beta",61);
        findFactorTypeAndColor("Risk","Daily Volatility (1 Year)",62);
        findFactorTypeAndColor("Risk","1 Year Volatility",63);
        findFactorTypeAndColor("Risk","3 Year Volatility",64);
        findFactorTypeAndColor("Risk","5 Year Volatility",65);

        findFactorTypeAndColor("Momentum","Momentum Short Term",67);
        findFactorTypeAndColor("Momentum","Momentum Medium Term",68);
        findFactorTypeAndColor("Momentum","Momentum 12-1",69);
        findFactorTypeAndColor("Momentum","RavenPack - Company Volume Ind",70);
        findFactorTypeAndColor("Momentum","RavenPack - Stock Sentiment Ind",71);

        findFactorTypeAndColor("Other","Debt/Equity",73);
        findFactorTypeAndColor("Other","Assets to Equity",74);
        findFactorTypeAndColor("Other","Asset Turnover",75);
        findFactorTypeAndColor("Other","Foreign Sales",76);
        findFactorTypeAndColor("Other","Trading Turnover 3 Month",77);
        findFactorTypeAndColor("Other","Amihud Ratio",78);
        findFactorTypeAndColor("Other","Interest Coverage Ratio (ex-financials)",79);
        findFactorTypeAndColor("Other","Current Ratio (ex-financials)",80);
        findFactorTypeAndColor("","Quick Ratio (ex-financials)",81);
        findFactorTypeAndColor("Quality","Earnings Growth Stability",82);
        findFactorTypeAndColor("Quality","Earnings Growth Stability 5 year",83);
        findFactorTypeAndColor("Quality","Sales Growth Stability",84);
        findFactorTypeAndColor("Quality","Sales Growth Stability 5 year",85);
        findFactorTypeAndColor("Quality","Low Accruals",86);
        findFactorTypeAndColor("Quality","Low Gearing",87);
        findFactorTypeAndColor("Quality","Returns Stability",88);

        findFactorTypeAndColor("ESG","Trucost - Carbon Footprint",90);
        findFactorTypeAndColor("ESG","Trucost - Impact Ratio",91);
        findFactorTypeAndColor("ESG","MSCI - Social Responsibility",92);
        findFactorTypeAndColor("ESG","MSCI GRId - Corp Gov",93);
        findFactorTypeAndColor("ESG","MSCI GRId - Corp Gov Audit",94);
        findFactorTypeAndColor("ESG","MSCI GRId - Corp Gov Board",95);
        findFactorTypeAndColor("ESG","MSCI GRId - Corp Gov Comp",96);
        findFactorTypeAndColor("ESG","MSCI GRId - Corp Gov Shareholder",97);
        findFactorTypeAndColor("ESG","GMI - Corp Gov",98);
        findFactorTypeAndColor("ESG","GMI - Accounting",99);
        findFactorTypeAndColor("ESG","GMI - Board",100);
        findFactorTypeAndColor("ESG","GMI - Environmental",101);
        findFactorTypeAndColor("ESG","GMI - Governance",102);
        findFactorTypeAndColor("ESG","GMI - Overall",103);
        findFactorTypeAndColor("ESG","GMI - Ownership & Control",104);
        findFactorTypeAndColor("ESG","GMI - Pay",105);
        findFactorTypeAndColor("ESG","GMI - Social",106);
        findFactorTypeAndColor("ESG","GMI - Accounting & Governance Risk",107);
        findFactorTypeAndColor("ESG","GMI - Forensic Alpha Model",108);
        findFactorTypeAndColor("ESG","MSCI IVA - Business Ethics",109);
        findFactorTypeAndColor("ESG","MSCI IVA - Climate Change",110);
        findFactorTypeAndColor("ESG","MSCI IVA - Corp Gov",111);
        findFactorTypeAndColor("ESG","MSCI IVA - Environmental",112);
        findFactorTypeAndColor("ESG","MSCI IVA - Environmental Opps",113);
        findFactorTypeAndColor("ESG","MSCI IVA - ESG Overall",114);
        findFactorTypeAndColor("ESG","MSCI IVA - Governance",115);
        findFactorTypeAndColor("ESG","MSCI IVA - Gov't & Public Policy",116);
        findFactorTypeAndColor("ESG","MSCI IVA - Human Capital",117);
        findFactorTypeAndColor("ESG","MSCI IVA - Natural Resource Use",118);
        findFactorTypeAndColor("ESG","MSCI IVA - Product Safety",119);
        findFactorTypeAndColor("ESG","MSCI IVA - Social",120);
        findFactorTypeAndColor("ESG","MSCI IVA - Social Opportunites",121);
        findFactorTypeAndColor("ESG","MSCI IVA - Waste Management",122);
        findFactorTypeAndColor("ESG","oekom - ESG Overall",123);
        findFactorTypeAndColor("ESG","oekom - Environmental",124);
        findFactorTypeAndColor("ESG","oekom - Social & Governance",125);
        findFactorTypeAndColor("ESG","Exposure to GDP Growth Shock",126);
        findFactorTypeAndColor("ESG","Exposure to Currency Gain",127);
        findFactorTypeAndColor("ESG","Exposure to Inflation",128);
        findFactorTypeAndColor("ESG","Exposure to Short Rate",129);
        findFactorTypeAndColor("ESG","Exposure to Oil Return",130);
        findFactorTypeAndColor("ESG","Exposure to Gold Return",131);


    }


    public void findFactorTypeAndColor(String factorType, String factorName,int i) throws IOException, InterruptedException {


        String colour = Driver.findElement(By.xpath("//*[@id='divFactors']/div["+i+"]/div")).getAttribute("style"); //Get the colour of the factor


        //Verify the color of the factor depends on the factor type.

        if(factorType.equalsIgnoreCase("Value")){

            String valueColor = "background-color: rgb(1, 147, 207);";
            Assert.assertEquals(colour,valueColor);


        }else if (factorType.equalsIgnoreCase("Growth")){

            String growthColor = "background-color: rgb(59, 144, 103);";
            Assert.assertEquals(colour,growthColor);


        }else if(factorType.equalsIgnoreCase("Risk")){

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

            String esgColor = "background-color: darkolivegreen;";
            Assert.assertEquals(colour,esgColor);


        }else if(factorType.equalsIgnoreCase("Economic")){

            String economicColor = "background-color: slategray;";
            Assert.assertEquals(colour,economicColor);


        }else if(factorType.equalsIgnoreCase("User Defined")){

            String userDefinedColor = "background-color: slategray;";
            Assert.assertEquals(colour,userDefinedColor);


        }

    }


}
