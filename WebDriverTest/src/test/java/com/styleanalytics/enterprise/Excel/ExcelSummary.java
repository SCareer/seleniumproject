package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

import static org.junit.Assert.assertThat;


/**
 * Created by Viswanath on 16/11/2017.
 */
public class ExcelSummary {


    public Xls_Reader reader;


    public ExcelSummary(String path) throws IOException {

        //String path =property("ExcelPath");
        reader = new Xls_Reader(path);

    }

    @Test
    public void excelSummarySheetPresent() {

        Assert.assertTrue(reader.isSheetExist("Summary"));

    }

    @Test
    public void excelSummarySheetRowCount(){

        Assert.assertEquals(reader.getColumnCount("Summary"),2);
    }

    @Test
    public void excelSummaryColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Summary"),2);
    }





}
