package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 04/12/2017.
 */
public class RiskSummary {


    public Xls_Reader reader;

    public RiskSummary(String path){

         reader = new Xls_Reader(path);

    }


    @Test
    public void excelRiskSummaryPresent(){

        Assert.assertTrue(reader.isSheetExist("Risk Summary"));

    }
    @Test
    public void excelRiskSummaryRowCount(){

        Assert.assertEquals(reader.getRowCount("Risk Summary"),52);
    }

    @Test
    public void excelRiskSummaryColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Risk Summary"),5);
    }
    @Test
    public void excelRiskSummaryHeaders() throws IOException {



        String[] colHeaders= {"Description","Portfolio Name","Snapshot Date","Setting","Value"};

        for(int i=0;i<colHeaders.length;i++){

            String header = reader.getCellData("Risk Summary",i,1);

           // System.out.println(header);

            Assert.assertEquals(header,colHeaders[i]);
        }
    }
}
