package com.styleanalytics.enterprise.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class DataTables {

    NumberFormat format = NumberFormat.getInstance(Locale.UK);
    Number number;

    public void getData(WebElement table){

        //WebElement tbl = driver.findElement(By.id("tbr"));

        //check all row, identification with 'tr' tag
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for(int i=0; i<rows.size(); i++) {
            //check column each in row, identification with 'td' tag
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

            for(int j=0; j<cols.size(); j++) {
              System.out.println(cols.get(j).getText());
            }

        }
    }

    public int getColumnValue(WebElement table,int column) throws ParseException {

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int totalCount = 0;

        for(int i=0; i<rows.size(); i++) {
            //check  each column in row, identification with 'td' tag
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

            for(int j=0; j<cols.size(); j++) {
                if(j==column) {
                    if(!cols.get(j).getText().equals(" ")) {
                        number = format.parse(cols.get(j).getText());
                        totalCount = totalCount + number.intValue();
                    }
                }
            }
        }
        return totalCount;
    }

    public void getRowValue(WebElement table,int row) throws ParseException {

        List<WebElement> rows = table.findElements(By.tagName("tr"));


        for(int i=0; i<rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

            for(int j=0;j<cols.size();j++){
                if(j==2&&i==0)
                System.out.println(cols.get(j).getText());
            }


        }

    }

    public int getNumberOfRows(WebElement table){

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        int numberOfRows= rows.size();

        return numberOfRows;
    }

    public int getNumberOfColumns(WebElement table){

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));

        int numberOfColumns = cols.size();

        return numberOfColumns;


    }

    public int getFormattedNumber(String stringNumber) throws ParseException {

        number = format.parse(stringNumber);

        return number.intValue();
    }
}
