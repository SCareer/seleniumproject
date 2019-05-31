package com.styleanalytics.enterprise.automation;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.utils.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class EndToEndTest extends SFTP {

    String user = Setup.property("sftpDailyUSer");
    String password = Setup.property("sftpDailyPass");
    String holdingsFolder = Setup.property("sftpDailyHoldingsFolder");
    String tasksFolder = Setup.property("sftpDailyTasksFolder");
    String sftpTaskFolder = Setup.property("sftpTaskFolder");

    public EndToEndTest() throws IOException {

    }


    @BeforeClass
    public void endToEndTestSetup() throws JSchException {

        connectSftp(user,password);

    }

    @Test
    public void runMultipleCalcScenario() throws SftpException,InterruptedException, IOException, InvalidFormatException {


        getFilesAndMoveToSftp(holdingsFolder, fundsFolder,"PortfolioFiteenYrsNYSMultiCalc_11.xlsx");

        reNameFilesInSFTP(fundsFolder,"PortfolioFiteenYrsNYSMultiCalc_11.xlsx");

        FileUtils.deleteFilesWithSpecificExtension(tasksFolder,".csv");

        createTaskFile(tasksFolder,"MultiCalc_Task.xlsx","PortfolioName",portfolioName);

        getFilesAndMoveToSftp(tasksFolder, sftpTaskFolder,taskFileName);


    }

    //@Test
    public void runSingleCalcScenario() throws SftpException,InterruptedException, IOException, InvalidFormatException {


        getFilesAndMoveToSftp(holdingsFolder, fundsFolder,"PortfolioFiteenYrsNYS_11.xlsx");

        reNameFilesInSFTP(fundsFolder,"PortfolioFiteenYrsNYS_11.xlsx");

        FileUtils.deleteFilesWithSpecificExtension(tasksFolder,".csv");

        createTaskFile(tasksFolder,"SingleCalc_Task.xlsx","PortfolioName",portfolioName);

        getFilesAndMoveToSftp(tasksFolder, sftpTaskFolder,taskFileName);


    }

    //@Test
    public void reRunMultipleCalcWithoutDeletionScenario() throws SftpException, IOException, InvalidFormatException, JSchException {


        connectSftp("DailyPortfolioUser10","Test12345!");

        getFilesAndMoveToSftp(holdingsFolder, fundsFolder,"PortfolioFiteenYrsNYSRerun_11.xlsx");

        setPortfolioName("PortfolioFiteenYrsNYSRerun_11");

        FileUtils.deleteFilesWithSpecificExtension(tasksFolder,".csv");

        createTaskFile(tasksFolder,"RerunCalc_Task.xlsx","PortfolioName",portfolioName);

        getFilesAndMoveToSftp(tasksFolder, sftpTaskFolder,taskFileName);


    }

    //@Test
    public void renAnalysisWithDailyAndNonDailyCalcs() throws SftpException, IOException, InvalidFormatException, JSchException, InterruptedException {


        getFilesAndMoveToSftp(holdingsFolder, fundsFolder,"PortfolioFifteenYrsNYSDailyAndNonDailyCalcs_11.xlsx");

        reNameFilesInSFTP(fundsFolder,"PortfolioFifteenYrsNYSDailyAndNonDailyCalcs_11.xlsx");

        FileUtils.deleteFilesWithSpecificExtension(tasksFolder,".csv");

        createTaskFile(tasksFolder,"MultiCalc_Daily&NonDaily.xlsx","PortfolioName",portfolioName);

        getFilesAndMoveToSftp(tasksFolder, sftpTaskFolder,taskFileName);


    }



    @AfterClass
    public void tearDown(){

        disconnectSftp();
    }

}
