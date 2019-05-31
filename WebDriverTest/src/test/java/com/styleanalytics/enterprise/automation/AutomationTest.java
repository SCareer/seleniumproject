package com.styleanalytics.enterprise.automation;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.styleanalytics.enterprise.Setup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutomationTest extends SFTP {

    public AutomationTest() throws IOException {
    }

    @BeforeClass
    public void automationTestSetup() throws SftpException, JSchException, InterruptedException, IOException {

        String user = Setup.property("sftpUSer");
        String password = Setup.property("sftpPass");

        connectSftp(user,password);

        deleteFilesInSFTPFolder(reportsFolder);

        deleteFilesInSFTPFolder(logFolder);

        deleteFilesInSFTPFolder(archiveSuccess);

        deleteFilesInSFTPFolder(archiveFailed);

        //renameFilesInFolder(holdingsFolder);

        deleteFilesInSFTPFolder(fundsFolder);

        getFilesAndMoveToSftp(holdingsFolder, fundsFolder);

        reNameFilesInSFTP(fundsFolder);

        setFileNames(fundsFolder);

        Thread.sleep(600000);

    }

    @Test
    public void verifySuccessScenario() throws Exception {

        try {
            System.out.println(successScenario);

            isFilePresent(logFolder + successScenario + ".Success", "Success Log is not present: ");

            isFilePresent(logFolder + successScenario + ".XML", "XML Log is not present: ");

            isFilePresent(archiveSuccess + successScenario + ".xlsx", "File not moved to Archive Success: ");

        } catch (Exception ex) {
            throw new Exception("verifySuccessScenario Failed " + ex);
        }
    }

    @Test
    public void verifyFailureScenario() throws Exception {

        try {

            isFilePresent(logFolder + failedScenario + ".Fail", "Failed Log is not present: ");

            // isFilePresent(logFolder + failedScenario + ".XML", "XML Log is not present: ");

            isFilePresent(archiveFailed + failedScenario + ".xlsx", "File not moved to Archive Failed: ");


        } catch (Exception ex) {
            throw new Exception("verifyFailureScenario Failed " + ex);
        }
    }

    @Test
    public void verifyPartialSuccessScenario() throws Exception {

        try {

            isFilePresent(logFolder + partialScenario + ".PartialSuccess", "Partial Success Log is not present: ");

            isFilePresent(logFolder + partialScenario + ".XML", "XML Log is not present: ");

            isFilePresent(archiveSuccess + partialScenario + ".xlsx", "File not moved to Archive Success: ");

        } catch (Exception ex) {
            throw new Exception("verifyPartialSuccessScenario Failed " + ex);
        }
    }

    @Test
    public void verifyXMLReport() throws Exception {

        try {

            getFilesInSFTPFolderAndVerify(reportsFolder, "Automation", ".zip");

        } catch (Exception ex) {
            throw new Exception("verifyXMLReport Failed " + ex);
        }
    }

    @Test
    public void verifyPDFReport() throws Exception {

        try {

            getFilesInSFTPFolderAndVerify(reportsFolder, "Automation", ".PDF");

        } catch (Exception ex) {
            throw new Exception("verifyPDFReport Failed " + ex);
        }
    }

    @Test
    public void verifyExcelReport() throws Exception {

        try {

            getFilesInSFTPFolderAndVerify(reportsFolder, "Automation", ".XLSX");

        } catch (Exception ex) {
            throw new Exception("verifyExcelReport Failed " + ex);
        }
    }

    @Test
    public void verifyPPTReport() throws Exception {

        try {
            getFilesInSFTPFolderAndVerify(reportsFolder, "Automation", ".PPTX");

        } catch (Exception ex) {
            throw new Exception("verifyPPTReport Failed " + ex);
        }
    }

    //@Test
    public void verifyJsonReport() throws Exception {

        try {
            getFilesInSFTPFolderAndVerify(reportsFolder, "Success", ".Json");

        } catch (Exception ex) {
            throw new Exception("verifyJsonReport Failed " + ex);
        }
    }

    @AfterClass
    public void tearDown() {

        disconnectSftp();


    }


}
