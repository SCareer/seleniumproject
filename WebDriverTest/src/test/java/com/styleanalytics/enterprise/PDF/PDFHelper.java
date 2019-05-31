package com.styleanalytics.enterprise.PDF;


import com.styleanalytics.setup.TestBase;
import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFHelper extends TestBase {

    WebDriver driver;

    public PDFHelper(WebDriver driver){
        this.driver = driver;
    }


    public void downloadReportFromDownloadIcon(String reportName) throws InterruptedException, IOException {

        driver.navigate().refresh();

        Thread.sleep(10000);

        driver.findElement(By.xpath("//span[@id='iconDownloads']")).click();

        Thread.sleep(5000);

        WebElement slickBox = driver.findElement(By.xpath("//*[@id=\"topNavDownloadsList\"]/div[4]/div[3]/div"));

        List<WebElement> temp = slickBox.findElements(By.xpath("//*[contains(@class,'slick-cell')]"));

        for (int i = 0; i < temp.size(); i++) {

            if (temp.get(i).getText().equals(reportName) && temp.get(i + 1).getText().equals("Complete")) {
                fileCleanUp(temp.get(i).getText());
                driver.findElement(By.xpath("//*[contains(text(),'" + reportName + "')]")).click();
                driver.findElement(By.xpath("//span[@id='iconDownloads']")).click();
                Thread.sleep(5000);
                break;
            } else if (temp.get(i).getText().equals(reportName) && temp.get(i + 1).getText().equals("Running")) {
                System.out.println(" Exports Still Running");
                break;
            } else if (temp.get(i).getText().equals(reportName) && temp.get(i + 1).getText().equals("Pending")) {
                System.out.println(" Exports are pending");
                break;
            } else if (temp.get(i).getText().equals(reportName) && temp.get(i + 1).getText().equals("Failed")) {
                System.out.println(" Exports Failed");
                break;
            }else
                System.out.println(temp.get(i).getText()+" " +temp.get(i + 1).getText()+ "  --Exports not match");
                i=i+2;
        }
    }

    public static void fileCleanUp(String portfolioName,String templateName) throws IOException {

        String pdfDownloadPath = property("PDFDownloadLocation");

        String file2 = pdfDownloadPath + portfolioName + "-" + templateName + ".pdf";

        File file = new File(file2);

        Boolean t = file.exists();
        System.out.println(file2+" Is it Exist: "+t);
        file.delete();


    }

    public static void fileCleanUp(String fileName) throws IOException {

        String pdfDownloadPath = property("PDFDownloadLocation");

        String file2 = pdfDownloadPath + fileName;

       // String file2 = pdfDownloadPath + portfolioName + "-" + templateName + ".pdf";

        System.out.println(file2);

        File file = new File(file2);

        Boolean t = file.exists();
        System.out.println(file2+" Is it Exist: "+t);
        file.delete();


    }

    public static void comparePDF(String file1, String file2) throws Exception {

        PDFUtil pdfUtil = new PDFUtil();

        pdfUtil.setCompareMode(CompareMode.VISUAL_MODE); //Compare pixel by pixel

        pdfUtil.highlightPdfDifference(true); //Highlight the difference

        String pdfErrorPath = property("PDFErrorLocation");

        //String fPath = "C:\\Selenium\\Build Outputs\\PDF Comparison Errors";
        pdfUtil.setImageDestinationPath(pdfErrorPath); //Save a Image


        int numOfPages = pdfUtil.getPageCount(file1);

        int numOfPages1 = pdfUtil.getPageCount(file2);

        if(numOfPages!=numOfPages1){

            throw new Exception("Number of Pages didn't match");
        }

        System.out.println(numOfPages);


        Boolean b = true;
        Boolean c = true;
        for (int i = 1; i <= numOfPages; i++) {

            // Boolean a = pdfUtil.compare(file1, file2, i, i); // Compare the file

            Boolean a = pdfUtil.compare(file1, file2, i, i, true, true);

            if (a == false) {
                b = false;
            }
        }
        Assert.assertEquals(b, c);

        System.out.println("Comparision Passed");


    }

}

