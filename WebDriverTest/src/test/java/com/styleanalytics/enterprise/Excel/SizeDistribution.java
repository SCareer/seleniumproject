package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 04/12/2017.
 */
public class SizeDistribution {


    public Xls_Reader reader;

    public SizeDistribution(String path){

        reader = new Xls_Reader(path);

    }
    @Test
    public void excelSizeDistributionPresent(){

        Assert.assertTrue(reader.isSheetExist("Size Distribution"));

    }
    @Test
    public void excelSizeDistributionRowCount(){

        Assert.assertEquals(reader.getRowCount("Size Distribution"),41);
    }

    @Test
    public void excelSizeDistributionColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Size Distribution"),11);
    }
    @Test
    public void excelSizeDistributionHeaders() throws IOException {



        String[] colHeaders= {"Description","Portfolio Name","Snapshot Date","Setting","Excluded","Cash","Mega","Large","Mid","Small","Micro"};

        for(int i=0;i<colHeaders.length;i++){

            String header = reader.getCellData("Size Distribution",i,1);

           // System.out.println(header);

            Assert.assertEquals(header,colHeaders[i]);
        }
    }
}
