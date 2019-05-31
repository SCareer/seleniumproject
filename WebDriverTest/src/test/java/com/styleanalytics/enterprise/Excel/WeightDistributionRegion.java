package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 04/12/2017.
 */
public class WeightDistributionRegion {
    public String path;
    public Xls_Reader reader;


    public WeightDistributionRegion(String path){

      reader = new Xls_Reader(path);

    }

    @Test
    public void excelWeightDistributionRegionPresent(){

        Assert.assertTrue(reader.isSheetExist("Weight Distribution-Region"));

    }
    @Test
    public void excelWeightDistributionRegionRowCount(){

        Assert.assertEquals(reader.getRowCount("Weight Distribution-Region"),11);
    }

    @Test
    public void excelWeightDistributionRegionColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Weight Distribution-Region"),9);
    }
    @Test
    public void excelWeightDistributionRegionHeaders() throws IOException {


        String[] colHeaders= {"Description","Portfolio Name","Snapshot Date","Setting","Cash","Asia","Pacific","Americas","Europe"};

        for(int i=0;i<colHeaders.length;i++){

            String header = reader.getCellData("Weight Distribution-Region",i,1);

           // System.out.println(header);

            Assert.assertEquals(header,colHeaders[i]);
        }
    }
}
