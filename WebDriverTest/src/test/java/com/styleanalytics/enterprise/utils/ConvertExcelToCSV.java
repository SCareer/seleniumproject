package com.styleanalytics.enterprise.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertExcelToCSV {

    static private Pattern rxquote = Pattern.compile("\"");

    static private String encodeValue(String value) {
        boolean needQuotes = false;
        if ( value.indexOf(',') != -1 || value.indexOf('"') != -1 ||
                value.indexOf('\n') != -1 || value.indexOf('\r') != -1 )
            needQuotes = true;
        Matcher m = rxquote.matcher(value);
        if ( m.find() ) needQuotes = true; value = m.replaceAll("\"\"");
        if ( needQuotes ) return "\"" + value + "\"";
        else return value;
    }

    public void excelToCSV(String ExcelFile, String CSVFile) throws IOException, InvalidFormatException {


        Workbook wb = new XSSFWorkbook(new File(ExcelFile));
       /* int sheetNo = Integer.parseInt(args[index++]);
        FormulaEvaluator fe = null;
        if (index < args.length ) {
            fe = wb.getCreationHelper().createFormulaEvaluator();
        }*/
        DataFormatter formatter = new DataFormatter();
        PrintStream out = new PrintStream(new FileOutputStream(CSVFile),
                true, "UTF-8");
        byte[] bom = {(byte)0xEF, (byte)0xBB, (byte)0xBF};
        out.write(bom);
        {
            Sheet sheet = wb.getSheetAt(0);
            for (int r = 0, rn = sheet.getLastRowNum() ; r <= rn ; r++) {
                Row row = sheet.getRow(r);
                if ( row == null ) { out.println(','); continue; }
                boolean firstCell = true;
                for (int c = 0, cn = row.getLastCellNum() ; c < cn ; c++) {
                    Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    if ( ! firstCell ) out.print(',');
                    if ( cell != null ) {
                       // if ( fe != null ) cell = fe.evaluateInCell(cell);
                        String value = formatter.formatCellValue(cell);
                        if ( cell.getCellTypeEnum() == CellType.FORMULA ) {
                            value = "=" + value;
                        }
                        out.print(encodeValue(value));
                    }
                    firstCell = false;
                }
                out.println();
            }
        }
    }
}
