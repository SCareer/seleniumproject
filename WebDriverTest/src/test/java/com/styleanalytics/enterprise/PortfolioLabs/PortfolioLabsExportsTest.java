package com.styleanalytics.enterprise.PortfolioLabs;

import com.styleanalytics.enterprise.DataDriven.DataDrivenSetup;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.PDF.PDFTest;
import com.styleanalytics.enterprise.PPT.PPTToPDFConverter;
import com.styleanalytics.enterprise.Utility;
import com.itextpdf.text.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class PortfolioLabsExportsTest extends EnterpriseBaseClass {

    private String snapshotDate = property("LabsSnapshotDate");
    private String pdfDownloadPath = property("PDFDownloadLocation");
    private String pdfExpectedLocation = property("LabsPdfExpectedLocation");
    private String pptExpectedLocation = property("LabsPPTExpectedLocation");

    public PortfolioLabsExportsTest() throws IOException {
    }


    @DataProvider
    public static Object[][] data() throws IOException {

        String testDataFile = property("TestData");

        Object[][] arrayObject = DataDrivenSetup.readFromExcel(testDataFile, "LabsExport");

        return arrayObject;

    }


    @Test(dataProvider = "data")
    public void labsPDFComparison(String portfolioName, String reportName, String reportTemplateName, String reportTemplateType, String testExecution) throws IOException, InterruptedException, DocumentException, com.lowagie.text.DocumentException {

       System.out.println("Labs PDF Comparison :"+reportTemplateName);

        if (testExecution.equalsIgnoreCase("No")) {
            throw new SkipException("Test skipped as data is:" + reportName);
        }

        GoTo.portfolioLabs();

        Thread.sleep(5000);

        PortfolioLabsHelper.findLabsReport(portfolioName);

        if (reportTemplateType.equalsIgnoreCase("PDF")) {

            String file1 = pdfExpectedLocation + reportName + "-" + snapshotDate + "-" + reportTemplateName + "." + reportTemplateType;
            String file2 = pdfDownloadPath + reportName + "-" + snapshotDate + "-" + reportTemplateName + "." + reportTemplateType;
            try {
                File file = new File(file2);
                Boolean t = file.exists();
                System.out.println("Is file exists to Delete :" + t);
                file.delete();
            } catch (Exception e) {

                System.out.println("File not found to Delete");
            }

            PortfolioLabsHelper.downloadReport(reportTemplateName);

            PDFTest pdfTest = new PDFTest();
            Utility.isFilePresent(file2, 60);
            pdfTest.comparePDF(file1, file2);

        } else if (reportTemplateType.equalsIgnoreCase("PPTX")) {

            String convertedPDFLocation = property("CreatePDF");
            String file1 = pptExpectedLocation + reportName + "-" + snapshotDate + "-" + reportTemplateName + ".pdf";
            String file2 = pdfDownloadPath + reportName + "-" + snapshotDate + "-" + reportTemplateName + "." + reportTemplateType;
            String file3 = convertedPDFLocation + "MergedFile.PDF";

            try {
                File file = new File(file2);
                Boolean t = file.exists();
                System.out.println("Is file exists to Delete :" + t);
                file.delete();
            } catch (Exception e) {

                System.out.println("File not found to Delete");
            }

            PortfolioLabsHelper.downloadReport(reportTemplateName);

            PDFTest pdfTest = new PDFTest();
            Utility.isFilePresent(file2, 60);

            PortfolioLabsHelper.deleteFilesFromFolder("CreatePDF");

            PPTToPDFConverter.pptToPDFConverter(file2);


            System.out.println(file1 + " vs " + file3);

            pdfTest.comparePDF(file1, file3);


        }
    }

}
