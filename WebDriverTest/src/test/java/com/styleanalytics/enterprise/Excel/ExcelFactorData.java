package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Viswanath on 01/12/2017.
 */
public class ExcelFactorData {


    public Xls_Reader reader;

    public ExcelFactorData(String path){

      reader = new Xls_Reader(path);

    }

    @Test
    public void excelFactorDataHeaders(){

        String colHeader[] = {"Original Code","ISIN","User Security Identifier","SecurityName","Market","Sector","PortfolioWeight","BenchmarkWeight","Book to Price","Dividend Yield","Dividend Payout Ratio","Earnings Yld","C'Flow Yield","Sales to Price","EBITDA to Price","Rtn on Equity","Earnings Growth","Income/Sales","Sales Growth","IBES 12Mth Gr","IBES 1Yr Rev","Value Blend","Dupe2","MCap Mill (EUR)","Market Beta","Momentum ST","Momentum MT","Debt/Equity","Foreign Sales","MSCI IVA - Climate Change","MSCI IVA - Corp Gov","MSCI IVA - Envir","Positive factor","Negative Factor"};

        for(int i=0;i<colHeader.length;i++){

            String header = reader.getCellData("Factor Data",i,1);

            //System.out.println(header);

            Assert.assertEquals(header,colHeader[i]);
        }
    }

    @Test
    public void excelFactorDataPresent(){

        Assert.assertTrue(reader.isSheetExist("Factor Data"));


    }
    @Test
    public void excelFactorDataRowCount(){

        Assert.assertEquals(reader.getRowCount("Factor Data"),599);
    }

    @Test
    public void excelFactorDataColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Factor Data"),34);
    }
}
