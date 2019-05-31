package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Viswanath on 01/12/2017.
 */
public class ExcelStyleExposure {


    public Xls_Reader reader;

    public ExcelStyleExposure(String path){

     reader = new Xls_Reader(path);

    }

    @Test
    public void excelSEPresent(){

        Assert.assertTrue(reader.isSheetExist("Style Exposure"));


    }
    @Test
    public void excelSESheetRowCount(){

        Assert.assertEquals(reader.getRowCount("Style Exposure"),33);
    }

    @Test
    public void excelSEColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Style Exposure"),30);
    }

}
