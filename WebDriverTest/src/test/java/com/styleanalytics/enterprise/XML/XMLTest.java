package com.styleanalytics.enterprise.XML;

import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.enterprise.PDF.PDFTest;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.pages.DownloadPage;
import com.styleanalytics.pages.PortfolioReportsPage;
import com.styleanalytics.setup.TestBase;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.List;


/**
 * Created by Viswanath on 16/11/2017.
 */
public class XMLTest extends TestBase {

    Utility utility = new Utility();
    String downloadedZipFileName="PDF Comparison Test-MSCI EUROPE-EUR-20160531-XML Default.zip";
    String downloadedFileName="PDF Comparison Test-MSCI EUROPE-EUR-20160531.xml";


    @BeforeClass
    public void XMLTestSetup() throws IOException, InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login();


    }


   //@Test(priority = 0) we need to do some work
    public void xmlFileCleanUp() throws IOException {

        String[] deleteFiles = {"PDF Comparison Test-MSCI EUROPE-EUR-20160531-XML Default.zip","PDF Comparison Test-MSCI EUROPE-EUR-20160531.xml"};

        PDFTest pTest = new PDFTest();
        pTest.fileCleanUp(deleteFiles); //Delete the existing files

    }
    @Test(priority = 1)
    public void downloadXML() throws Exception {


        String portfolioName =property("XMLComparisonPortfolio");

        PortfolioReportsPage portfolioReportsPage = new PortfolioReportsPage(getDriver());

        portfolioReportsPage.goToReportsPage(getURL());

        portfolioReportsPage.selectPortfolio(portfolioName);

        DownloadPage downloadPage = new DownloadPage(getDriver());

        downloadPage.openDownloadsPopup();

        downloadPage.downloadReportFromReportsPage("XML Default");

        Thread.sleep(20000);


    }


    public void unzipDownloadedXMLFile(String zipFileLocation, String destinationDirectory){


        UnzipUtility unzipper = new UnzipUtility();
        try {
            unzipper.unzip(zipFileLocation, destinationDirectory);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
    }


    @Test(priority = 2)
    public void xmlSchemaValidation() throws IOException, SAXException, InterruptedException {

        String xsdPath=property("XSDLocation");
        String downloadLocation =property("DownloadLocation");

        //String xsdPath = "D:\\StyleResearch\\EnterpriseTesting\\trunk\\Test Data\\XML\\Style Research Report XSD.xsd";

        String xmlPath =downloadLocation+downloadedZipFileName;

        String finalDestination = downloadLocation+downloadedFileName;

        File file = new File(xmlPath);

        if(file.exists()) {

            unzipDownloadedXMLFile(xmlPath,downloadLocation); //Unzip the file

            Boolean validation = validateSchema(xsdPath, finalDestination);

            System.out.println("Is the XML Matches the Schema:" + validation);

        }else{

            utility.downloadReportsFromNotificationIcon(downloadedZipFileName);

            unzipDownloadedXMLFile(xmlPath,downloadLocation); //Unzip the file

            Boolean validation = validateSchema(xsdPath, finalDestination);

            System.out.println("Is Schema of the file Changed:" + validation);

        }
    }



    public static boolean validateSchema(String xsd, String testFile) throws SAXException, IOException {

        try {

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema = factory.newSchema(new File(xsd));

            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File(testFile)));

        }catch (SAXException e){

            System.out.println("Exception:"+e);

            return false;
        }

        return  true;
    }
}



