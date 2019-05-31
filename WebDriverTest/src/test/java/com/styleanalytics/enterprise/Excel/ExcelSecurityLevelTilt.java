package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Viswanath on 01/12/2017.
 */
public class ExcelSecurityLevelTilt {


    public Xls_Reader reader;


    public ExcelSecurityLevelTilt(String path){

        reader = new Xls_Reader(path);

    }

    @Test
    public void excelSecurityLevelTiltPresent(){

        Assert.assertTrue(reader.isSheetExist("Security Level Tilt Contrib"));


    }
    @Test
    public void excelSecurityLevelTiltSheetRowCount(){

        Assert.assertEquals(reader.getRowCount("Security Level Tilt Contrib"),606);
    }

    @Test
    public void excelSecurityLevelTiltColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Security Level Tilt Contrib"),32);
    }
    @Test
    public void excelSecurityLevelTiltHeaders(){

        String colHeaders[]={"Original Code","ISIN","User Security Identifier","SecurityName","Country","Sector","Book to Price","Dividend Yield","Dividend Payout Ratio","Earnings Yld","C'Flow Yield","Sales to Price","EBITDA to Price","Rtn on Equity","Earnings Growth","Income/Sales","Sales Growth","IBES 12Mth Gr","IBES 1Yr Rev","Value Blend","Dupe2","Market Cap","Market Beta","Momentum ST","Momentum MT","Debt/Equity","Foreign Sales","MSCI IVA - Climate Change","MSCI IVA - Corp Gov","MSCI IVA - Envir","Positive factor","Negative Factor"};

            for(int i=0;i<colHeaders.length;i++){

            String header = reader.getCellData("Security Level Tilt Contrib",i,8);

            //System.out.println(header);

            Assert.assertEquals(header,colHeaders[i]);
        }
    }
}
