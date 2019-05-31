package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Viswanath on 04/12/2017.
 */
public class AnalysisSettingsDetails {

    public Xls_Reader reader;

    public AnalysisSettingsDetails(){

      reader = new Xls_Reader("C:\\Users\\viswanath.STYLEDOMAIN\\Downloads\\EQUITYREPORTSTEST-MSCI AC EUROPE-EUR-20160531-Default Excel Report (4).xlsx");

    }

@Test
    public void copy(){

        //reader.addSheet("Test1");

       int rows =  reader.getRowCount("Style Exposure");
       int columns = reader.getColumnCount("Style Exposure");

       for(int i=0;i<=columns;i++){

           for(int j=0;j<=rows;j++){

               System.out.println(reader.getCellData("Test1",i,j));



           }

       }


    }

    public static void main(String[] args) throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("C:\\Users\\viswanath.STYLEDOMAIN\\Downloads\\EQUITYREPORTSTEST-MSCI AC EUROPE-EUR-20160531-Default Excel Report (4).xlsx"));
        HSSFSheet sheet = workbook.getSheet("Style Exposure");
        copyRow(workbook, sheet, 0, 1);
        FileOutputStream out = new FileOutputStream("c:/output.xls");
        workbook.write(out);
        out.close();
    }

    private static void copyRow(HSSFWorkbook workbook, HSSFSheet worksheet, int sourceRowNum, int destinationRowNum) {
        // Get the source / new row
        HSSFRow newRow = worksheet.getRow(destinationRowNum);
        HSSFRow sourceRow = worksheet.getRow(sourceRowNum);

        // If the row exist in destination, push down all rows by 1 else create a new row
        if (newRow != null) {
            worksheet.shiftRows(destinationRowNum, worksheet.getLastRowNum(), 1);
        } else {
            newRow = worksheet.createRow(destinationRowNum);
        }

        // Loop through source columns to add to new row
        for (int i = 0; i < sourceRow.getLastCellNum(); i++) {
            // Grab a copy of the old/new cell
            HSSFCell oldCell = sourceRow.getCell(i);
            HSSFCell newCell = newRow.createCell(i);

            // If the old cell is null jump to next cell
            if (oldCell == null) {
                newCell = null;
                continue;
            }

            // Copy style from old cell and apply to new cell
            HSSFCellStyle newCellStyle = workbook.createCellStyle();
            newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
            ;
            newCell.setCellStyle(newCellStyle);

            // If there is a cell comment, copy
            if (oldCell.getCellComment() != null) {
                newCell.setCellComment(oldCell.getCellComment());
            }

            // If there is a cell hyperlink, copy
            if (oldCell.getHyperlink() != null) {
                newCell.setHyperlink(oldCell.getHyperlink());
            }

            // Set the cell data type
            newCell.setCellType(oldCell.getCellType());

            // Set the cell data value
            switch (oldCell.getCellType()) {
                case Cell.CELL_TYPE_BLANK:
                    newCell.setCellValue(oldCell.getStringCellValue());
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    newCell.setCellValue(oldCell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_ERROR:
                    newCell.setCellErrorValue(oldCell.getErrorCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    newCell.setCellFormula(oldCell.getCellFormula());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    newCell.setCellValue(oldCell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    newCell.setCellValue(oldCell.getRichStringCellValue());
                    break;
            }
        }

    }}