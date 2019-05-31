package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 04/12/2017.
 */
public class RiskBySecurities {


    public Xls_Reader reader;

    public RiskBySecurities(String path){

        reader = new Xls_Reader(path);

    }


    @Test
    public void excelRiskBySecuritiesPresent(){

        Assert.assertTrue(reader.isSheetExist("Risk By Securities"));

    }
    @Test
    public void excelRiskBySecuritiesRowCount(){

        Assert.assertEquals(reader.getRowCount("Risk By Securities"),605);
    }

    @Test
    public void excelRiskBySecuritiesColumnCount(){

        Assert.assertEquals(reader.getColumnCount("Risk By Securities"),25);
    }
    @Test
    public void excelRiskBySecuritiesHeaders() throws IOException {

        String[] colHeaders= {"Original Code","ISIN","User Security Identifier","Security Name","Market","Sector","Style","Portfolio Weight","Benchmark Weight","Active Weight","Style CoVariance","Marginal Risk","TV Contrib","CurrencyRisk","MarketRiskX","MarketRisk","SectorRiskX","SectorRisk","StyleRiskX","StyleRisk","EquityRiskX","EquityRisk","Beta (Ex Ante)","1 Month Return (EUR)","3 Month Return (EUR)"};

        for(int i=0;i<colHeaders.length;i++){

            String header = reader.getCellData("Risk By Securities",i,1);

            //System.out.println(header);

            Assert.assertEquals(header,colHeaders[i]);
        }
    }
}
