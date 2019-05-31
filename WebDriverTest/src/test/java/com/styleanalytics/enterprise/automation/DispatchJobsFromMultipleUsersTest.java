package com.styleanalytics.enterprise.automation;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.styleanalytics.enterprise.DataDriven.DataDrivenSetup;
import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.utils.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.styleanalytics.enterprise.Setup.property;

public class DispatchJobsFromMultipleUsersTest extends SFTP {

    String holdingsFolder = Setup.property("sftpDailyHoldingsFolder");
    String tasksFolder = Setup.property("sftpDailyTasksFolder");
    String sftpTaskFolder = Setup.property("sftpTaskFolder");

    public DispatchJobsFromMultipleUsersTest() throws IOException {
    }

    @DataProvider
    public static Object[][] data() throws IOException {

        String testDataFile = property("TestData");

        Object[][] arrayObject = DataDrivenSetup.readFromExcel(testDataFile, "DispatchTestUsers");

        return arrayObject;
    }

    @Test(dataProvider = "data")
    public void connectToSftp(String userName, String pass) throws JSchException, SftpException, InterruptedException, IOException, InvalidFormatException {

        connectSftp(userName,pass);

        getFilesAndMoveToSftp(holdingsFolder, fundsFolder,"PortfolioFiteenYrsNYSMultiCalc_11.xlsx");

        reNameFilesInSFTP(fundsFolder,"PortfolioFiteenYrsNYSMultiCalc_11.xlsx");

        FileUtils.deleteFilesWithSpecificExtension(tasksFolder,".csv");

        createTaskFile(tasksFolder,"MultiCalc_Task.xlsx","PortfolioName",portfolioName);

        getFilesAndMoveToSftp(tasksFolder, sftpTaskFolder,taskFileName);

        disconnectSftp();


    }




}
