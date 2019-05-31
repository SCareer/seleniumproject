package com.styleanalytics.enterprise.PeerInsights;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.PDF.PDFTest;
import com.styleanalytics.enterprise.PPT.PPTToPDFConverter;
import com.styleanalytics.enterprise.PortfolioLabs.PortfolioLabsHelper;
import com.styleanalytics.enterprise.Utility;
import com.itextpdf.text.DocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class PDFExports extends EnterpriseBaseClass {

    private String reportName;
    private String dataProvider;
    private String subCategory;
    private String peerGroupName;
    private String reportTemplateType;
    private String reportTemplateName;

    private String pdfDownloadPath = property("PDFDownloadLocation");
    private String pdfExpectedLocation = property("PeerInsightsPdfExpectedLocation");
    private String pptExpectedLocation = property("PeerInsightsPPTExpectedLocation");

    @Factory(dataProvider = "data")
    public PDFExports(String reportName, String dataProvider, String subCategory, String peerGroupName,String reportTemplateName,String reportTemplateType) throws IOException {


        this.reportName = reportName;

        this.dataProvider = dataProvider;

        this.subCategory = subCategory;

        this.peerGroupName = peerGroupName;

        this.reportTemplateName=reportTemplateName;

        this.reportTemplateType = reportTemplateType;

    }

    @DataProvider
    public static Object[][] data() throws IOException {

        return new Object[][]{

                   {"MorningStar Portfolio With access", "morningstar", "INST","US - Large Blend-Russell 1000-USD-20160331","Peer Insights Default","PDF"},
                    {"MorningStar Portfolio With access", "morningstar", "INST","US - Large Blend-Russell 1000-USD-20160331","Default PPT Peer Insights","PPTX"},
                    {"Lipper portflio with access", "lipper", "EU","Equity Europe ex UK-FTSE AW Europe ex UK-EUR-20160531","Default PPT Peer Insights","PDF"},

            };

    }

    @BeforeClass
    public void setupPeerInsightsExportsTest() throws IOException, InterruptedException {

        try {

            PeerInsightsHelper.openPeerGroup(reportName);


        } catch (Exception e) {

            System.out.println("Problem with PI Download Setup");
        }


    }

    @Test
    public void peerInsightsPDFComparison() throws IOException, InterruptedException, DocumentException, com.lowagie.text.DocumentException {

        if(reportTemplateType.equalsIgnoreCase("PDF")) {

            String file1 = pdfExpectedLocation + dataProvider + "-" + subCategory + " - " + peerGroupName+ "-"  + reportName+ "."+reportTemplateType;
            String file2 = pdfDownloadPath + dataProvider + "-" + subCategory + " - " + peerGroupName+ "-"  + reportName+ "."+reportTemplateType;

            System.out.println(file1);
            System.out.println(file2);
            File filex = new File(file1);
            System.out.println(filex.exists());

            try {
                File file = new File(file2);
                Boolean t = file.exists();
                System.out.println("Is file exists to Delete :" + t);
                file.delete();
            } catch (Exception e) {

                System.out.println("File not found to Delete");
            }

            downloadReport();

            PDFTest pdfTest = new PDFTest();
            Utility.isFilePresent(file2, 200);

            pdfTest.comparePDF(file1, file2);

        }else if(reportTemplateType.equalsIgnoreCase("PPTX")){

            String convertedPDFLocation = property("CreatePDF");
            String file1 = pptExpectedLocation+ dataProvider + "-" + subCategory + " - " + peerGroupName+ "-"  + reportName+".pdf";
            String file2 = pdfDownloadPath+ dataProvider + "-" + subCategory + " - " + peerGroupName+ "-"  + reportName+ "."+reportTemplateType;
            String file3 =convertedPDFLocation+"MergedFile.PDF";

            try {
                File file = new File(file2);
                Boolean t = file.exists();
                System.out.println("Is file exists to Delete :" + t);
                file.delete();
            }catch (Exception e){

                System.out.println("File not found to Delete");
            }

            downloadReport();

            PDFTest pdfTest = new PDFTest();
            Utility.isFilePresent(file2, 300);

            PortfolioLabsHelper.deleteFilesFromFolder("CreatePDF");

            PPTToPDFConverter.pptToPDFConverter(file2);


            System.out.println(file1+" vs "+file3);

            pdfTest.comparePDF(file1, file3);


        }
    }


    public void downloadReport() throws InterruptedException {

        Thread.sleep(5000);

        Driver.findElement(By.xpath("//img[@id='ctl00_mainContentPlaceHolder_Image1']")).click();

        Utility.waitForElementToDisplay("//a[text()='Download']");

        Driver.findElement(By.xpath("//a[text()='Download']")).click();

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//div[@class='ui-state-default slick-headerrow-column l0 r0']//input[@type='text']")).sendKeys(reportTemplateName + " ");

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//a[@class='download']")).click();


    }
}