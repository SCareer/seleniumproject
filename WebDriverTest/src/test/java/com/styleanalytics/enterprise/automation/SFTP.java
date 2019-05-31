package com.styleanalytics.enterprise.automation;

import com.styleanalytics.enterprise.DataDriven.Xls_Reader;
import com.styleanalytics.enterprise.Setup;
import com.jcraft.jsch.*;
import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.utils.ConvertExcelToCSV;
import com.styleanalytics.enterprise.utils.DateUtils;
import com.styleanalytics.setup.TestBase;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;


public class SFTP {


    public String host = Setup.property("sftpHost");
    public String port = Setup.property("sftpPort");
    public String fundsFolder = Setup.property("sftpFundsFolder");
    public String holdingsFolder = Setup.property("sftpHoldingsFolder");
    public String logFolder = Setup.property("sftpLogFolder");
    public String archiveSuccess = Setup.property("sftpArchiveSuccessFolder");
    public String archiveFailed = Setup.property("sftpArchiveFailedFolder");
    public String reportsFolder = Setup.property("sftpReportsFolder");
    public Session session;
    public ChannelSftp sftpChannel;
    public String successScenario;
    public String partialScenario;
    public String failedScenario;
    public String portfolioName;
    public String taskFileName;

    public SFTP() throws IOException {

    }

    public void setPortfolioName(String portfolioName){

        this.portfolioName = portfolioName;
    }

    public void setTaskFileName(String taskFileName){

        this.taskFileName = taskFileName;
    }


    public void connectSftp(String user,String password) throws JSchException {

        JSch jsch = new JSch();
        session = jsch.getSession(user, host, Integer.parseInt(port));
        session.setPassword(password);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        sftpChannel = (ChannelSftp) session.openChannel("sftp");
        sftpChannel.connect();
        System.out.println("Connected to SFTP");


    }

    public void disconnectSftp() {

        sftpChannel.disconnect();
        session.disconnect();

    }

    public String getFileNameWithoutExtension(String fileName){

        String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.')); //File name without extension

        return fileNameWithoutExtension;

    }

    public String getFileNameWithoutNumerics(String fileName){

        String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.')); //File name without extension
        String numInString = fileNameWithoutExtension.replaceAll("[\\P{L}]", "");
        return numInString;
    }

    public String getExtensionOfFile(String fileName){

        String fileExtension = fileName.substring(fileName.lastIndexOf('.'), fileName.length()); //just extension
        return fileExtension;
    }

    public String getNumericsInFileName(String fileName){

        String numInString = fileName.replaceAll("[^\\.0123456789]", "");
        return numInString;
    }



    public void isFilePresent(String file, String logMsg) throws Exception {

        try {
            sftpChannel.lstat(file);
        } catch (Exception e) {
            throw new Exception(logMsg + e);
        }
    }

    public void reNameFilesInSFTP(String FolderName) throws SftpException, InterruptedException {

        Vector fileList = sftpChannel.ls(FolderName);

        for (int i = 1; i < fileList.size(); i++) {

            ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) fileList.get(i);
            System.out.println("File to Rename: "+entry.getFilename());
            if(!entry.getFilename().equalsIgnoreCase("archive")
                    && !entry.getFilename().equalsIgnoreCase("Log")) {
                sftpChannel.rename(FolderName + entry.getFilename(), FolderName + renameFile(entry.getFilename())); //Move the file
            }
            }

    }

    public void reNameFilesInSFTP(String FolderName, String fileName) throws SftpException, InterruptedException {

        Vector fileList = sftpChannel.ls(FolderName);

        for (int i = 1; i < fileList.size(); i++) {

            ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) fileList.get(i);
            System.out.println("File to Rename: "+entry.getFilename());
            if(!entry.getFilename().equalsIgnoreCase("archive")
                    && !entry.getFilename().equalsIgnoreCase("Log")) {
                if(entry.getFilename().equals(fileName)){
                sftpChannel.rename(FolderName + entry.getFilename(), FolderName + renameFile(entry.getFilename())); //Move the file
            }
            }

        }

    }


    public void renameFilesInFolder(String folderPath) {

        String newFileName;
        File[] files = new File(folderPath).listFiles();

        for (File file : files) {

            String fileName = file.getName();  //File Name

            String fileWithOutExtension = getFileNameWithoutExtension(fileName);

           // String numInString = fileWithOutExtension.replaceAll("[^\\.0123456789]", "");

            String numInString =getNumericsInFileName(fileWithOutExtension);

            //int newNumber = Integer.parseInt(numInString) + 1; //Increment number by one
            newFileName = fileName.replaceAll(numInString, String.valueOf(DateUtils.getDateTime("hms")));

            System.out.println("Old File Name: " + fileName + "****** New File Name : " + newFileName);

            file.renameTo(new File(folderPath + newFileName));

        }

    }

    public String renameFile(String fileName) throws InterruptedException {

        String newFileName;

        String fileWithOutExtension = getFileNameWithoutExtension(fileName);

        // String numInString = fileWithOutExtension.replaceAll("[^\\.0123456789]", "");

        String numInString =getNumericsInFileName(fileWithOutExtension);

        //int newNumber = Integer.parseInt(numInString) + 1; //Increment number by one
        newFileName = fileName.replaceAll(numInString, String.valueOf(DateUtils.getDateTime("YYYY-MM-dd HH-mm-ss")));

        System.out.println("Old File Name: " + fileName + "****** New File Name : " + newFileName);

        //file.renameTo(new File(folderPath + newFileName));

        this.portfolioName = getFileNameWithoutExtension(newFileName);

        return newFileName;


    }

    public void deleteFilesInSFTPFolder(String folder) throws JSchException, SftpException {

        Vector fileList = sftpChannel.ls(folder);

        for (int i = 1; i < fileList.size(); i++) {

            ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) fileList.get(i);
            System.out.println(entry.getFilename());
            if(!entry.getFilename().equalsIgnoreCase("Log")&&!entry.getFilename().equalsIgnoreCase("archive")) {
                System.out.println(folder + entry.getFilename());

                sftpChannel.rm(folder + entry.getFilename());
            }
        }

    }

    public void getFilesInSFTPFolderAndVerify(String folder, String fName, String fileType) throws Exception {


        Vector fileList = sftpChannel.ls(folder);

        int count=0;

        for (int i = 1; i < fileList.size(); i++) {

            ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) fileList.get(i);
            System.out.println(entry.getFilename());

            String fileName = entry.getFilename();  //File Name

            String fileExtension = getExtensionOfFile(fileName);

            System.out.println(fileExtension);

            if (fileExtension.equalsIgnoreCase(fileType)) {
                Assert.assertTrue(fileName.contains(fName));
                count++;
            }

        }

        if(count<1){
            throw new Exception("File not found");
        }else if(count>1){
            throw new Exception("Too many files found");
        }

    }

    public void getFilesAndMoveToSftp(String sourceFolder, String destFolder) throws SftpException, JSchException {


        List<String> results = new ArrayList<String>();

        File[] files = new File(sourceFolder).listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null.

        for (File file : files) {
            if (file.isFile()) 
			{
				results.add(file.getName());
				System.out.println(file.getName());
				sftpChannel.put(sourceFolder + file.getName(), destFolder); //Move the file
				System.out.println("File Moved");				
				if(file.delete())
				{
					System.out.println("File deleted successfully");	
				}
            }
        }

    }

    public void getFilesAndMoveToSftp(String sourceFolder, String destFolder,String fileName) throws SftpException{


        List<String> results = new ArrayList<String>();

        File[] files = new File(sourceFolder).listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null.

        for (File file : files) {
            if (file.isFile()) {

                results.add(file.getName());
                if(file.getName().equals(fileName)) {
                    sftpChannel.put(sourceFolder + file.getName(), destFolder); //Move the file
                    System.out.println("File Moved: "+file.getName());
                }
            }
        }

    }

    public void createTaskFile(String taskFileFolder,String fileName, String colName, String colValue) throws IOException, InvalidFormatException{

        System.out.println("Write this to excel: "+colValue);
        Xls_Reader reader  = new Xls_Reader(taskFileFolder+fileName);
        reader.setCellData("Sheet1",colName,2,colValue);

        ConvertExcelToCSV ctoCSV = new ConvertExcelToCSV();
        String taskFileNameWithOutExtension = getFileNameWithoutExtension(fileName);
        String taskFileName = taskFileNameWithOutExtension+"_"+String.valueOf(DateUtils.getDateTime("YYYY-MM-dd HH-mm-ss"))+".csv";
        ctoCSV.excelToCSV(taskFileFolder+fileName,taskFileFolder+taskFileName);

        this.taskFileName = taskFileName;


    }

    public void getFilesFromSftp(String fileName, String downloadLocation) throws SftpException {

        sftpChannel.get(fileName,downloadLocation);
    }

    public void setFileNames(String folderName) throws SftpException {

        Vector fileList = sftpChannel.ls(folderName);

        for (int i = 1; i < fileList.size(); i++) {

            ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) fileList.get(i);
            System.out.println(entry.getFilename());

            if (!entry.getFilename().equalsIgnoreCase("Log") && !entry.getFilename().equalsIgnoreCase("archive")) {
                String fileName = entry.getFilename();
                String fileWithOutExtension = getFileNameWithoutExtension(fileName);
                System.out.println(fileWithOutExtension);
                if (fileWithOutExtension.contains("PartialSuccess")) {

                    this.partialScenario = fileWithOutExtension;
                } else if (fileWithOutExtension.contains("Failure")) {

                    this.failedScenario = fileWithOutExtension;
                } else if (fileWithOutExtension.contains("Success")) {

                    this.successScenario = fileWithOutExtension;
                }
            }

        }


    }}



