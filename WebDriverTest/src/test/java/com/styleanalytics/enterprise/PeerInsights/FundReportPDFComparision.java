package com.styleanalytics.enterprise.PeerInsights;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.PDF.PDFTest;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.PDF.PDFTest;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FundReportPDFComparision extends TestBase {

    private String peerInsightsReport;
    private String portfolioName;
    private String scenario;
    public PeerInsightsPage peerInsightsPage;


    @Factory(dataProvider = "data")
    public FundReportPDFComparision(String peerInsightsReport, String portfolioName, String scenario) {

        this.peerInsightsReport = peerInsightsReport;

        this.portfolioName = portfolioName;

        this.scenario = scenario;

    }

    @DataProvider
    public static Object[][] data() {


        return new Object[][]{
                {"MorningStar Portfolio With access", "Advisory Research Intl Small Cap Value", "morningStar"},
                {"Lipper portflio with access", "Transamerica Global Equity", "Lipper"},
                {"MorningStar Portfolio WithoutAccess", "BonaVista Canadian Equity", "MorningStarWithOutAccess"}
        };

    }

    @BeforeClass
    public void openPeerGroupReport() throws IOException, InterruptedException {


        GoTo.peerInsights();

        try {
            if (!scenario.equalsIgnoreCase("MorningStarWithOutAccess")) {

                PeerInsightsHelper.openPeerGroup(peerInsightsReport);
                PeerInsightsHelper.openFundReport(portfolioName);

            } else {

                FundReport peerInsightsFundReport = new FundReport();
                peerInsightsFundReport.logInAsWithoutAccessUser();
                //logInAsDiffUser();
                //Refactor the code above---------------------------------------------------------------
                PeerInsightsHelper.openPeerGroup(peerInsightsReport);
                PeerInsightsHelper.openFundReport(portfolioName);
            }
        } catch (Exception e) {

            System.out.println("Problem with the setup :" + e);
        }

        peerInsightsPage = new PeerInsightsPage(getDriver());

    }


    @Test
    public void fundReportPDFCompareMStarPortfolio() throws IOException, InterruptedException {

        String snapshotDate =property("snapshotDate");
        String pdfDownloadPath = property("PDFDownloadLocation");
        String pdfExpectedLocation =  property("pdfExpectedLocation");
        String file1 = pdfExpectedLocation+portfolioName+"-"+snapshotDate+"-Peer Insights Fund Report PDF.pdf";
        String file2 = pdfDownloadPath+portfolioName+"-"+snapshotDate+"-Peer Insights Fund Report PDF.pdf";
        try {
            File file = new File(file2);
            Boolean t = file.exists();
            System.out.println("Is file exists to Delete :" + t);
            file.delete();
        }catch (Exception e){

            System.out.println("File not found to Delete");
        }

        //Download the report
        peerInsightsPage.fundReportDownloadIcon.click();

        Thread.sleep(4000);

        peerInsightsPage.fundReportDownloadTemplateSearch.sendKeys("PDF");

        Thread.sleep(4000);

        peerInsightsPage.fundreportDownloadButton.click();


        PDFTest pdfTest = new PDFTest();
        Utility.isFilePresent(file2, 60);
        pdfTest.comparePDF(file1, file2);


    }

}
