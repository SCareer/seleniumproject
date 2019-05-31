package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 04/12/2017.
 */
public class StyleDistribution {



    public Xls_Reader reader;


    public StyleDistribution(String path){

         reader = new Xls_Reader(path);

    }

    @Test
    public void excelStyleDistributionPresent(){

        Assert.assertTrue(reader.isSheetExist("Style Distribution"));

    }
    @Test
    public void excelStyleDistributionRowCount(){

        Assert.assertEquals(reader.getRowCount("Style Distribution"),41);
    }

    @Test
    public void excelStyleDistributionColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Style Distribution"),12);
    }
    @Test
    public void excelStyleDistributionHeaders() throws IOException {


        String[] colHeaders= {"Description","Portfolio Name","Snapshot Date","Setting","Excluded","Cash","Large Value","Large Growth","Mid Value","Mid Growth","Small Value","Small Growth"};

        for(int i=0;i<colHeaders.length;i++){

            String header = reader.getCellData("Style Distribution",i,1);

            //System.out.println(header);

            Assert.assertEquals(header,colHeaders[i]);
        }
    }
}
