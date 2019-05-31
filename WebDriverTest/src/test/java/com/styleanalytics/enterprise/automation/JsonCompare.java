package com.styleanalytics.enterprise.automation;

import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;

/**
 * Created by Viswanath on 15/03/2018.
 */
public class JsonCompare extends TestBase {

    static String jsonDownloadPath;

    static {
        try {
            jsonDownloadPath = property("jsonDownloadPath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getJsonFromChart(int reportSection, int order, String fileName,String portfolioNameFolder, WebDriver driver) throws IOException, InterruptedException {


        Utility.isElementPresent("//img[contains(@id,'_chartDiv-img') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]", 10);

        WebElement rightClick = driver.findElement(By.xpath("//img[contains(@id,'_chartDiv-img') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]"));

        Actions actions = new Actions(driver).contextClick(rightClick);  //Right Click on the report
        actions.build().perform();

        Thread.sleep(5000);

        //Click on the Right click menu

        try {

            WebElement viewSource = driver.findElement(By.xpath("//div[contains(text(),'View Source') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]"));

            viewSource.click();

        } catch (NoSuchElementException e) {

            e.printStackTrace();
        }

        Thread.sleep(5000);

        WebElement jsonEle = driver.findElement(By.xpath("//textarea[contains(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]"));


        jsonEle.sendKeys(Keys.chord(Keys.CONTROL, "a"));  //Select all
        jsonEle.sendKeys(Keys.chord(Keys.CONTROL, "c"));  //Copy to Clipboard

        String content = getClipBoard();

        //System.out.println(content);

        File file0 = new File(jsonDownloadPath+portfolioNameFolder+"\\"+fileName + ".csv");

        try {
            file0.delete();  //Delete the file if already exists
        } catch (Exception e) {
            System.out.println("File not found to Delete");
        }

        FileUtils.writeStringToFile(new File(jsonDownloadPath+portfolioNameFolder+"\\"+fileName + ".csv"), content, "UTF-8"); //Create a new file and Copy the content from clipboard

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[contains(@id,'_chartDiv-viewsource-close') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]")).click();

    }


    public static void jsonDownload(int reportSection, int order, String expectedFileName, WebDriver driver) throws IOException, InterruptedException {


        Utility.isElementPresent("//img[contains(@id,'_chartDiv-img') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]", 10);

        WebElement rightClick = driver.findElement(By.xpath("//img[contains(@id,'_chartDiv-img') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]"));

        Actions actions = new Actions(driver).contextClick(rightClick);  //Right Click on the report
        actions.build().perform();

        Thread.sleep(5000);

        //Click on the Right click menu

        try {

            WebElement viewSource = driver.findElement(By.xpath("//div[contains(text(),'View Source') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]"));

            viewSource.click();

        } catch (NoSuchElementException e) {

            System.out.println(e);
        }

        Thread.sleep(5000);

        WebElement jsonEle = driver.findElement(By.xpath(" //textarea[contains(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]"));


        jsonEle.sendKeys(Keys.chord(Keys.CONTROL, "a"));  //Select all
        jsonEle.sendKeys(Keys.chord(Keys.CONTROL, "c"));  //Copy to Clipboard

        String content = getClipBoard();

        //System.out.println(content);

        File file0 = new File("C:\\Selenium\\json.csv");

        try {
            file0.delete();  //Delete the file if already exists
        } catch (Exception e) {

            System.out.println("File not found to Delete");
        }

        FileUtils.writeStringToFile(new File("C:\\Selenium\\json.csv"), content, "UTF-8"); //Create a new file and Copy the content from clipboard

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[contains(@id,'_chartDiv-viewsource-close') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl0" + reportSection + "_rptReportItems_ctl0" + order + "_panContainer')]")).click();


        File file1 = new File("C:\\Selenium\\json.csv");

        File file2 = new File("C:\\Selenium\\Build Outputs\\Json Expected\\" + expectedFileName + ".csv");


        compareCSVFile(file1, file2); //Compare content of 2 files


        //Thread.sleep(10000);


    }


    public static String getClipBoard() {
        try {
            return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (HeadlessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedFlavorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }


    public static void compareCSVFile(File file1, File file2) throws IOException {

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));

        BufferedReader reader2 = new BufferedReader(new FileReader(file2));

        String line1 = reader1.readLine();

        String line2 = reader2.readLine();

        boolean areEqual = true;

        int lineNum = 1;

        while (line1 != null || line2 != null) {
            if (line1 == null || line2 == null) {
                areEqual = false;

                break;
            } else if (!line1.equalsIgnoreCase(line2)) {
                areEqual = false;

                break;
            }

            line1 = reader1.readLine();

            line2 = reader2.readLine();

            lineNum++;
        }

        if (areEqual) {
            System.out.println("Two files have same content.");
        } else {
            System.out.println("Two files have different content. They differ at line " + lineNum);

            System.out.println("File1 has " + line1 + " and File2 has " + line2 + " at line " + lineNum);

            Assert.fail();
        }

        reader1.close();

        reader2.close();
    }


}
