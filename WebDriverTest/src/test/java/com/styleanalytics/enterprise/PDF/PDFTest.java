package com.styleanalytics.enterprise.PDF;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.ReportDownloadTest;
import com.styleanalytics.enterprise.Sharing.SharingHelpers;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by Viswanath on 08/11/2017.
 */
public class PDFTest extends EnterpriseBaseClass {

    GoTo goTo = new GoTo();
    Utility uT = new Utility();
    PDFUtil pdfUtil = new PDFUtil();

    public String[] templateNames = {"Sample Style Template",
            "Sample Meeting Pack Template",
            "Sample Factsheet Template",
            "All New PDF Backup 030118 -no fd ndtrails",
            "All New PDF Backup 030118 Fact Data"};

    public String portfolioName = "PDF Comparison Test-MSCI EUROPE-EUR-20160531";


    @Test(priority = 3)
    public void downloadPDFForComparison() throws IOException, InterruptedException {


        String pdfComparison = property("PDFComparisonPortfolio");

        uT.searchPortfolioInReportsPage(pdfComparison);

        uT.downloadMultipleReportFromReportsPage(templateNames);

        pdfBulkDownload();

        Thread.sleep(180000); //Wait for the templates to download

    }

    @Test(priority = 6)
    public void compareSampleStyleTemplate() throws IOException, InterruptedException {

        String pdfComparisonPath = property("PDFCompareLocation");
        String pdfDownloadPath = property("PDFDownloadLocation");


        String file1 = pdfComparisonPath + portfolioName + "-Sample Style Template.pdf";
        String file2 = pdfDownloadPath + portfolioName + "-Sample Style Template.pdf";

        File file = new File(file2);
        Boolean isPresent = file.exists();
        if (isPresent == false) {
            //uT.downloadReportsFromNotificationIcon("PDF Comparison Test-MSCI EUROPE-EUR-20160531-Sample Style Template.pdf");
          //  PDFHelper.downloadReportFromDownloadIcon(portfolioName + "-Sample Style Template.pdf");
            Thread.sleep(10000);
            try {
                comparePDF(file1, file2);
            } catch (AssertionError e) {
                System.out.println("PDF Comparison Failed: " + e);
                Assert.fail();
            }
        } else
            try {
                comparePDF(file1, file2);
            } catch (AssertionError e) {
                System.out.println("PDF Comparison Failed: " + e);
                Assert.fail();
            }


    }

    @Test(priority = 5)
    public void compareSampleMeetingPackTemplate() throws IOException, InterruptedException {

        String pdfComparisonPath = property("PDFCompareLocation");
        String pdfDownloadPath = property("PDFDownloadLocation");


        String file1 = pdfComparisonPath + portfolioName + "-Sample Meeting Pack Template.pdf";
        String file2 = pdfDownloadPath + portfolioName + "-Sample Meeting Pack Template.pdf";

        File file = new File(file2);
        Boolean isPresent = file.exists();
        if (isPresent == false) {
            //uT.downloadReportsFromNotificationIcon("PDF Comparison Test-MSCI EUROPE-EUR-20160531-Sample Meeting Pack Template.pdf");
          //  PDFHelper.downloadReportFromDownloadIcon(portfolioName + "-Sample Meeting Pack Template.pdf");
            Thread.sleep(10000);
            try {
                comparePDF(file1, file2);
            } catch (AssertionError e) {
                System.out.println("PDF Comparison Failed: " + e);
                Assert.fail();
            }
        } else
            try {
                comparePDF(file1, file2);
            } catch (AssertionError e) {
                System.out.println("PDF Comparison Failed: " + e);
                Assert.fail();
            }

    }

    @Test(priority = 4)
    public void compareSampleFactSheetTemplate() throws IOException, InterruptedException {

        String pdfComparisonPath = property("PDFCompareLocation");
        String pdfDownloadPath = property("PDFDownloadLocation");

        String file1 = pdfComparisonPath + portfolioName + "-Sample Factsheet Template.pdf";
        String file2 = pdfDownloadPath + portfolioName + "-Sample Factsheet Template.pdf";

        File file = new File(file2);
        Boolean isPresent = file.exists();
        if (isPresent == false) {
            // uT.downloadReportsFromNotificationIcon("PDF Comparison Test-MSCI EUROPE-EUR-20160531-Sample Factsheet Template.pdf");
           // PDFHelper.downloadReportFromDownloadIcon(portfolioName + "-Sample Factsheet Template.pdf");
            Thread.sleep(10000);
            try {
                comparePDF(file1, file2); //Compare the files and if it is not same then mark it and save a image.
            } catch (AssertionError e) {
                System.out.println("PDF Comparison Failed: " + e);
                Assert.fail();
            }
        } else
            try {
                comparePDF(file1, file2); //Compare the files and if it is not same then mark it and save a image.
            } catch (AssertionError e) {
                System.out.println("PDF Comparison Failed" + e);
                Assert.fail();
            }
    }


    public void comparePDF(String file1, String file2) throws IOException {

        pdfUtil.setCompareMode(CompareMode.VISUAL_MODE); //Compare pixel by pixel

        pdfUtil.highlightPdfDifference(true); //Highlight the difference

        String pdfErrorPath = property("PDFErrorLocation");

        //String fPath = "C:\\Selenium\\Build Outputs\\PDF Comparison Errors";
        pdfUtil.setImageDestinationPath(pdfErrorPath); //Save a Image


        int numOfPages = pdfUtil.getPageCount(file1);

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


    public void fileCleanUp(String[] tName) throws IOException {

        String pdfDownloadPath = property("PDFDownloadLocation");

        for (int i = 0; i < tName.length; i++) {


            String file2 = pdfDownloadPath + portfolioName + "-" + tName[i] + ".pdf";

            System.out.println(file2);


            File file = new File(file2);

            Boolean t = file.exists();
            System.out.println(file2 + " Is it Exist: " + t);
            file.delete();


        }

    }

    @Test(priority = 1)
    public void imageCleanup() throws IOException {

        String pdfErrorPath = property("PDFErrorLocation");

        //String path ="C:\\Selenium\\Build Outputs\\PDF Comparison Errors";
        File file = new File(pdfErrorPath);
        for (File f : file.listFiles()) {
            f.delete();
        }

    }

    @Test(priority = 2)
    public void pdfDownloadCleanup() throws IOException {

        fileCleanUp(templateNames); //Delete file from the downloads if the file already exists


    }

    @BeforeClass
    public void pdfTestSetup() throws IOException, InterruptedException {

        LogoutTest();

        String user = property("PDFTestUser");
        String pass = property("PDFTestPass");

        logInAsDiffUser(user, pass);

    }


    //@Test(priority = 7)
    public void pdfBulkDownload() throws IOException, InterruptedException {

        Xls_Reader reader = new Xls_Reader("C:\\Selenium\\Test Data\\PDFTestdata.xlsx");

        int numberOfPortfolio = reader.getRowCount("Portfolios");

        System.out.print(numberOfPortfolio);

        int numberOfTemplates = reader.getRowCount("Templates");

        System.out.print(numberOfTemplates);


        for (int i = 2; i <= numberOfPortfolio; i++) {

            uT.searchPortfolioInReportsPage(reader.getCellData("Portfolios", "PortfolioName", i));
            System.out.println(reader.getCellData("Portfolios", "PortfolioName", i));

            for (int j = 2; j <= numberOfTemplates; j++) {

                uT.downloadReportFromReportsPage(reader.getCellData("Templates", "TemplateNames", j));

                System.out.println(reader.getCellData("Templates", "TemplateNames", j));
            }
        }
    }

    @Test(priority = 8)
    public void pdfBulkVerify() throws IOException, InterruptedException {

        Xls_Reader reader = new Xls_Reader("C:\\Selenium\\Test Data\\PDFTestdata.xlsx");

        int numberOfPortfolio = reader.getRowCount("Portfolios");

        System.out.print(numberOfPortfolio);

        int numberOfTemplates = reader.getRowCount("Templates");

        System.out.print(numberOfTemplates);


        for (int i = 1; i < numberOfTemplates; i++) {

            for (int j = 2; j <= numberOfPortfolio; j++) {

                String fileName = reader.getCellData("Templates", i, j);

                System.out.println("File Name:" + fileName);


                String expectedFile = "C:\\Selenium\\Build Outputs\\PDF Comparison Files\\" + fileName;
                String actualFile = "C:\\Users\\viswanath.STYLEDOMAIN\\Downloads\\" + fileName;

                File f = new File("C:\\Users\\viswanath.STYLEDOMAIN\\Downloads\\" + fileName);

                int timeout = 3;

                //for(int k=0;k<timeout;i++) {

                if (f.exists() == true) {

                    comparePDF(expectedFile, actualFile);
                    System.out.println("Success");

                } else {

                    System.out.println("File not downloaded");
                    Thread.sleep(1000);
                }

                // }

            }

        }
    }


}
