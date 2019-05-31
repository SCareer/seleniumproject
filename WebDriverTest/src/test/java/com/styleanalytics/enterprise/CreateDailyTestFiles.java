package com.styleanalytics.enterprise;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.codehaus.plexus.util.FileUtils.copyFile;

public class CreateDailyTestFiles {

    public void printDatesInMonth(int year, int month) throws IOException, ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("ddMMyyyy");
        Date today = new Date();
        Date todayWithZeroTime = fmt.parse(fmt.format(today));
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, 1);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < daysInMonth; i++) {
            System.out.println(fmt.format(cal.getTime()));


            cal.add(Calendar.DAY_OF_MONTH, 1);

            File source=new File("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Equity Portfolios\\26022019.xlsx");
            File destination=new File("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Equity Portfolios\\Daily Portfolios\\"+fmt.format(cal.getTime())+".xlsx");

            copyFile(source,destination);
        }
    }
    @Test
    public void createFiles() throws IOException, ParseException {

        for(int i =2016; i<2019;i++) {

            for (int j = 1; j <= 12; j++) {
                printDatesInMonth(i, j);

            }
        }
    }

    //@Test
    public void copySheet() throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Equity Portfolios\\26022019 - Copy.xlsx");
        int totalRecords = 5;
        for (int i = 0; i < totalRecords - 1; i++) {
            workbook.cloneSheet(1);
        }
        for (int i = 1; i <= totalRecords; i++) {
            workbook.setSheetName(i, "S" + i);
        }
    }

    public static void mergeExcelFiles(File file, List<FileInputStream> list) throws IOException {
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet(file.getName());

        for (FileInputStream fin : list) {
            HSSFWorkbook b = new HSSFWorkbook(fin);
            for (int i = 0; i < b.getNumberOfSheets(); i++) {
                copySheets(book, sheet, b.getSheetAt(i));
            }
        }

        try {
            writeFile(book, file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected static void writeFile(HSSFWorkbook book, File file) throws Exception {
        FileOutputStream out = new FileOutputStream(file);
        book.write(out);
        out.close();
    }

    private static void copySheets(HSSFWorkbook newWorkbook, HSSFSheet newSheet, HSSFSheet sheet){
        copySheets(newWorkbook, newSheet, sheet, true);
    }

    private static void copySheets(HSSFWorkbook newWorkbook, HSSFSheet newSheet, HSSFSheet sheet, boolean copyStyle){
        int newRownumber = newSheet.getLastRowNum() + 1;
        int maxColumnNum = 0;
        Map<Integer, HSSFCellStyle> styleMap = (copyStyle) ? new HashMap<Integer, HSSFCellStyle>() : null;

        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            HSSFRow srcRow = sheet.getRow(i);
            HSSFRow destRow = newSheet.createRow(i + newRownumber);
            if (srcRow != null) {
                copyRow(newWorkbook, sheet, newSheet, srcRow, destRow, styleMap);
                if (srcRow.getLastCellNum() > maxColumnNum) {
                    maxColumnNum = srcRow.getLastCellNum();
                }
            }
        }
        for (int i = 0; i <= maxColumnNum; i++) {
            newSheet.setColumnWidth(i, sheet.getColumnWidth(i));
        }
    }

    public static void copyRow(HSSFWorkbook newWorkbook, HSSFSheet srcSheet, HSSFSheet destSheet, HSSFRow srcRow, HSSFRow destRow, Map<Integer, HSSFCellStyle> styleMap) {
        destRow.setHeight(srcRow.getHeight());
        for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {
            HSSFCell oldCell = srcRow.getCell(j);
            HSSFCell newCell = destRow.getCell(j);
            if (oldCell != null) {
                if (newCell == null) {
                    newCell = destRow.createCell(j);
                }
                copyCell(newWorkbook, oldCell, newCell, styleMap);
            }
        }
    }

    public static void copyCell(HSSFWorkbook newWorkbook, HSSFCell oldCell, HSSFCell newCell, Map<Integer, HSSFCellStyle> styleMap) {
        if(styleMap != null) {
            int stHashCode = oldCell.getCellStyle().hashCode();
            HSSFCellStyle newCellStyle = styleMap.get(stHashCode);
            if(newCellStyle == null){
                newCellStyle = newWorkbook.createCellStyle();
                newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
                styleMap.put(stHashCode, newCellStyle);
            }
            newCell.setCellStyle(newCellStyle);
        }
        switch(oldCell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                newCell.setCellValue(oldCell.getRichStringCellValue());
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                newCell.setCellValue(oldCell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                newCell.setCellType(HSSFCell.CELL_TYPE_BLANK);
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                newCell.setCellValue(oldCell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                newCell.setCellErrorValue(oldCell.getErrorCellValue());
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                newCell.setCellFormula(oldCell.getCellFormula());
                break;
            default:
                break;
        }
    }
}
