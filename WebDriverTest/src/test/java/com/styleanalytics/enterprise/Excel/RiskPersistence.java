package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 04/12/2017.
 */
public class RiskPersistence {



    public Xls_Reader reader;

    public RiskPersistence(String path){

        reader = new Xls_Reader(path);

    }


    @Test
    public void excelRiskPersistencePresent(){

        Assert.assertTrue(reader.isSheetExist("Risk Persistence"+"\u2122"));

    }
    @Test
    public void excelRiskPersistenceRowCount(){

        Assert.assertEquals(reader.getRowCount("Risk Persistence"+"\u2122"),11);
    }

    @Test
    public void excelRiskPersistenceColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Risk Persistence"+"\u2122"),7);
    }
    @Test
    public void excelRiskPersistenceHeaders() throws IOException {



        String[] colHeaders= {"Period","Portfolio Name","Analysis Date","Description","5 years to Analysis Date 1 Year Ago","5 years to Analysis Date","Over 3 years"};

        for(int i=0;i<colHeaders.length;i++){

            String header = reader.getCellData("Risk Persistence"+"\u2122",i,1);

            //System.out.println(header);

            Assert.assertEquals(header,colHeaders[i]);
        }
    }
}
