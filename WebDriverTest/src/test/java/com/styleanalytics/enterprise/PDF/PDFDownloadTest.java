package com.styleanalytics.enterprise.PDF;

import com.styleanalytics.enterprise.DataDriven.DataDrivenSetup;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.pages.DownloadPage;
import com.styleanalytics.pages.PortfolioReportsPage;
import com.styleanalytics.setup.TestBase;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class PDFDownloadTest extends TestBase {

    private int count = 0;


    @DataProvider
    public static Object[][] data() throws IOException {

        String testDataFile = property("TestData");

        Object[][] arrayObject = DataDrivenSetup.readFromExcel(testDataFile, "PDF");

        return arrayObject;
    }

    @BeforeClass
    public void pdfTestSetup() throws IOException, InterruptedException {

        String user = property("PDFTestUser");
        String pass = property("PDFTestPass");

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(user, pass);


    }

    @Test(dataProvider = "data", priority = 1)
    public void deleteExistingFiles(String portfolioName, String templateName, String testExecution) throws IOException {

        PDFHelper.fileCleanUp(portfolioName, templateName);

    }

    @Test(dataProvider = "data", priority = 2)
    public void downloadPDFExports(String portfolioName, String templateName, String testExecution) throws Exception {


        if (testExecution.equalsIgnoreCase("No")) {

            throw new SkipException("Scenario skipped: " + templateName);
        }

        String pName[] = portfolioName.split("-");

        String trimmedPortfolioName = pName[pName.length - 4];

        PortfolioReportsPage portfolioReportsPage = new PortfolioReportsPage(getDriver());

        portfolioReportsPage.goToReportsPage(getURL());

        portfolioReportsPage.selectPortfolio(trimmedPortfolioName);

        DownloadPage downloadPage = new DownloadPage(getDriver());

        downloadPage.openDownloadsPopup();

        downloadPage.downloadReportFromReportsPage(templateName);

    }

    @Test(dataProvider = "data", priority = 3)
    public void comparePDFReports(String portfolioName, String templateName, String testExecution) throws Exception {

        if(count==0){
            System.out.println("Count ="+count);
            Thread.sleep(600000);
            count = count+1;
        }

        System.out.println("Compare PDF :" + templateName);

        if (testExecution.equalsIgnoreCase("No")) {

            throw new SkipException("Scenario skipped: " + templateName);
        }
        String pdfComparisonPath = property("PDFCompareLocation");
        String pdfDownloadPath = property("PDFDownloadLocation");


        String file1 = pdfComparisonPath + portfolioName + "-" + templateName + ".pdf";
        String file2 = pdfDownloadPath + portfolioName + "-" + templateName + ".pdf";

        File file = new File(file2);
        Boolean isPresent = file.exists();

       // Utility.isFilePresent(file2, 3);
        if (isPresent == false) {

            PDFHelper pdfHelper = new PDFHelper(getDriver());
            pdfHelper.downloadReportFromDownloadIcon(portfolioName + "-" + templateName + ".pdf");
            Thread.sleep(10000);

        }
        PDFHelper.comparePDF(file1, file2);

    }
}
