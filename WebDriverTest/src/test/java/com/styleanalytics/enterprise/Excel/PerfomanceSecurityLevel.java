package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;

/**
 * Created by Viswanath on 04/12/2017.
 */
public class PerfomanceSecurityLevel {

    public Xls_Reader reader;

    public PerfomanceSecurityLevel(String path){

        reader = new Xls_Reader(path);

    }
}
