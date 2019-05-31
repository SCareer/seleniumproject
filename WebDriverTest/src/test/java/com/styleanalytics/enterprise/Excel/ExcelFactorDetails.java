package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Viswanath on 01/12/2017.
 */
public class ExcelFactorDetails {


    public Xls_Reader reader;

    public ExcelFactorDetails(String path){

      reader = new Xls_Reader(path);

    }

    @Test
    public void excelFactorDetailsPresent(){

        Assert.assertTrue(reader.isSheetExist("Factor Details"));

    }
    @Test
    public void excelFactorDetailsSheetRowCount(){

        Assert.assertEquals(reader.getRowCount("Factor Details"),36);
    }

    @Test
    public void excelFactorDetailsColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Factor Details"),18);
    }
    @Test
    public void excelFactorDetailsHeaders(){

        String colHeaders[]= {"Factor Name", "Portfolio Weighted Average", "Benchmark Weighted Average", "Universe Weighted Average", "Active Position", "Style Tilt™", "SSA", "Upper Truncation Limit", "Lower Truncation Limit", "Portfolio Weighted Standard Deviation", "Benchmark Weighted Standard Deviation", "Universe Weighted Standard Deviation", "Portfolio Stock Data Coverage (Count)", "Benchmark Stock Data Coverage (Count)", "Universe Stock Data Coverage (Count)", "Portfolio Stock Data Coverage (Weight)", "Benchmark Stock Data Coverage (Weight)", "Universe Stock Data Coverage (Weight)"
        };
        for(int i=0;i<colHeaders.length;i++){

            String header = reader.getCellData("Factor Details",i,1);

            //System.out.println(header);

            Assert.assertEquals(header,colHeaders[i]);
        }
    }
}
