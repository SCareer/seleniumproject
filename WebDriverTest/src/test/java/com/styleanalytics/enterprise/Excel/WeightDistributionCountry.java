package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 04/12/2017.
 */
public class WeightDistributionCountry {


    private Xls_Reader reader;


    public WeightDistributionCountry(String path) throws IOException {

        reader = new Xls_Reader(path);
    }


    @Test
    public void excelWeightDistributionCountryPresent(){

        Assert.assertTrue(reader.isSheetExist("Weight Distribution-Country"));

    }
    @Test
    public void excelWeightDistributionCountryRowCount(){

        Assert.assertEquals(reader.getRowCount("Weight Distribution-Country"),12);
    }

    @Test
    public void excelWeightDistributionCountryColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Weight Distribution-Country"),39);
    }
    @Test
    public void excelWeightDistributionCountryHeaders() throws IOException {


        String[] colHeaders= {"Description","Portfolio Name","Snapshot Date","Setting","Cash","Australia","Austria","Belgium","Switzerland","China","Czech Republic","Germany","Denmark","Spain","Finland","France","UK","Greece","Hong Kong","Hungary","India","Ireland","Italy","Japan","South Korea","Netherlands","Norway","Philippines","Poland","Portugal","Russia","Singapore","Sweden","Thailand","Turkey","Taiwan","USA","Bermuda","Ukraine"};
        for(int i=0;i<colHeaders.length;i++){

            String header = reader.getCellData("Weight Distribution-Country",i,1);

           // System.out.println(header);

            Assert.assertEquals(header,colHeaders[i]);
        }
    }
}
