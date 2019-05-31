package com.styleanalytics.enterprise.automation;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.utils.ConvertExcelToCSV;
import com.styleanalytics.enterprise.utils.DateUtils;
import com.styleanalytics.enterprise.utils.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import java.io.IOException;

public class DailyAutomationTest extends SFTP{

    String user = Setup.property("sftpDailyUSer");
    String password = Setup.property("sftpDailyPass");
    String holdingsFolder = Setup.property("sftpDailyHoldingsFolder");
    String tasksFolder = Setup.property("sftpDailyTasksFolder");
    String sftpTaskFolder = Setup.property("sftpTaskFolder");
    public DailyAutomationTest() throws IOException {
    }

    @Test
    public void automationTestSetup() throws SftpException, JSchException, InterruptedException, IOException, InvalidFormatException {

        connectSftp(user,password);

        getFilesAndMoveToSftp(holdingsFolder, fundsFolder);

        reNameFilesInSFTP(fundsFolder);

        FileUtils.deleteFilesWithSpecificExtension(tasksFolder,".csv");

        writeItTOFile(portfolioName);

        setFileNames(fundsFolder);

        getFilesAndMoveToSftp(tasksFolder, sftpTaskFolder);


    }


    public void verifyLoad() throws Exception {

        try {

            isFilePresent(logFolder + portfolioName + ".Success", "Success Log is not present: ");

            //isFilePresent(logFolder + successScenario + ".XML", "XML Log is not present: ");

            isFilePresent(archiveSuccess + portfolioName + ".xlsx", "File not moved to Archive Success: ");

        } catch (Exception ex) {
            throw new Exception("Portfolio Failed to Load " + ex);
        }
    }

    public void writeItTOFile(String portfolioName) throws IOException, InvalidFormatException, JSchException, SftpException {

        System.out.println("New Portfolio Name to Write: "+portfolioName);
        String taskFile = Setup.property("sftpDailyTasksFolder");
        Xls_Reader reader  = new Xls_Reader(taskFile+"Test_Task.xlsx");
        reader.setCellData("Sheet1","PortfolioName",2,portfolioName);

        ConvertExcelToCSV ctoCSV = new ConvertExcelToCSV();
        ctoCSV.excelToCSV(taskFile+"Test_Task.xlsx",taskFile+"Test_Task_"+String.valueOf(DateUtils.getDateTime("YYYY-MM-dd HH-mm-ss"))+".csv");


    }


}
