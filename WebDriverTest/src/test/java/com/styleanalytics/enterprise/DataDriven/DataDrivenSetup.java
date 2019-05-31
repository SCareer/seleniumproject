package com.styleanalytics.enterprise.DataDriven;

public class DataDrivenSetup {

    public static String[][] readFromExcel(String fileName, String sheetName) {
        String[][] arrayExcelData = null;
        try {

            Xls_Reader reader = new Xls_Reader(fileName);

            int totalNoOfCols = reader.getColumnCount(sheetName);
            int totalNoOfRows = reader.getRowCount(sheetName);

            //System.out.println(totalNoOfRows+" "+totalNoOfCols);

            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];


            for (int i= 1 ; i < totalNoOfRows; i++) {

                for (int j=0; j < totalNoOfCols; j++) {

                    arrayExcelData[i-1][j] = reader.getCellData(sheetName,j,i+1);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayExcelData;
    }


}
