package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 04/12/2017.
 */
public class WeightDistributionSector {


    public Xls_Reader reader;


    public WeightDistributionSector(String path){

     reader = new Xls_Reader(path);

    }

    @Test
    public void excelWeightDistributionSectorPresent(){

        Assert.assertTrue(reader.isSheetExist("Weight Distribution-Sector"));

    }
    @Test
    public void excelWeightDistributionSectorRowCount(){

        Assert.assertEquals(reader.getRowCount("Weight Distribution-Sector"),12);
    }

    @Test
    public void excelWeightDistributionSectorColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Weight Distribution-Sector"),15);
    }
    @Test
    public void excelWeightDistributionSectorHeaders() throws IOException {


        String[] colHeaders= {"Description","Portfolio Name","Snapshot Date","Setting","Cash","Energy","Materials","Industrials","Consumer Discretionary","Consumer Staples","Health Care","Financials","Information Technology","Telecommunication Services","Utilities"};
        for(int i=0;i<colHeaders.length;i++){

            String header = reader.getCellData("Weight Distribution-Sector",i,1);

            //System.out.println(header);

            Assert.assertEquals(header,colHeaders[i]);
        }
    }
}
