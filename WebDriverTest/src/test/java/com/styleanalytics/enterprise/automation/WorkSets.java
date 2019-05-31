package com.styleanalytics.enterprise.automation;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class WorkSets {

    private String fileName;
    private String dataSource;
    private String loadStatus;
    private String analysisStatus;
    private String exportStatus;
    private String distributionStatus;
    private String workSetProgress;
    private double failedCount;
    private double portfolioCount;
    private double snapshotCount;
    private double analysisDispatchedCount;
    private double waitingForData;
    private double analysisPendingCount;
    private double analysisCompletedCount;
    private double analysisFailedCount;
    private double exportDispatchedCount;
    private double exportPendingCount;
    private double exportCompletedCount;
    private double exportFailedCount;
    private double distributionDispatchCount;
    private double distributionPendingCount;
    private double distributionCompletedCount;
    private double distributionFailedCount;

    private JSonReader jSonReader;


    public WorkSets(String jsonFile) throws IOException, ParseException {

        jSonReader = new JSonReader(new File(jsonFile));

    }

    public String getWorkSetProgress() {

        workSetProgress= jSonReader.readStringJSonObject("WorksetProgress");
        return workSetProgress;
    }

    public double getFailedCount() {

        failedCount= jSonReader.readDoubleJSonObject("FailedCount");
        return failedCount;
    }

    public String getLoadStatus() {

         loadStatus= jSonReader.readStringJSonObject("Summary","Load","Status");
         return loadStatus;
    }

    public String getAnalysisStatus() {

        analysisStatus= jSonReader.readStringJSonObject("Summary","Analysis","Status");
        return analysisStatus;
    }

    public String getExportStatus() {

         exportStatus= jSonReader.readStringJSonObject("Summary","Export","Status");

        return exportStatus;
    }

    public String getDistributionStatus() {

        distributionStatus= jSonReader.readStringJSonObject("Summary","Distribution","Status");
        return distributionStatus;
    }

    public String getFileName() {

        fileName= jSonReader.readStringJSonObject("FileDetail","FileName");
        return fileName;
    }

    public String getDataSource() {

        dataSource= jSonReader.readStringJSonObject("FileDetail","Datasource");
        return dataSource;
    }

    public double getPortfolioCount() {

        portfolioCount= jSonReader.readDoubleJSonObject("Summary","Load","PortfolioCount");
        return portfolioCount;
    }

    public double getSnapshotCount() {

        snapshotCount= jSonReader.readDoubleJSonObject("Summary","Load","SnapshotCount");
        return snapshotCount;
    }

    public double getAnalysisDipachedCount() {

        analysisDispatchedCount= jSonReader.readDoubleJSonObject("Summary","Analysis","DispatchedCount");
        return analysisDispatchedCount;
    }

    public double getWaitingForData() {

        waitingForData= jSonReader.readDoubleJSonObject("Summary","Analysis","WaitingForData");
        return waitingForData;
    }

    public double getAnalysisPendingCount() {

        analysisPendingCount= jSonReader.readDoubleJSonObject("Summary","Analysis","Pending");
        return analysisPendingCount;
    }

    public double getAnalysisCompletedCount() {

        analysisCompletedCount= jSonReader.readDoubleJSonObject("Summary","Analysis","Completed");
        return analysisCompletedCount;
    }

    public double getAnalysisFailedCount() {

        analysisFailedCount= jSonReader.readDoubleJSonObject("Summary","Analysis","Failed");
        return analysisFailedCount;
    }

    public double getExportDipatchedCount() {

        exportDispatchedCount= jSonReader.readDoubleJSonObject("Summary","Export","DispatchedCount");
        return exportDispatchedCount;
    }

    public double getExportPendingCount() {

        exportPendingCount= jSonReader.readDoubleJSonObject("Summary","Export","Pending");
        return exportPendingCount;
    }

    public double getExportCompletedCount() {

        exportCompletedCount= jSonReader.readDoubleJSonObject("Summary","Export","Completed");
        return exportCompletedCount;
    }

    public double getExportFailedCount() {

        exportFailedCount= jSonReader.readDoubleJSonObject("Summary","Export","Failed");
        return exportFailedCount;
    }

    public double getDistribtuionDispatchcount() {

        distributionDispatchCount= jSonReader.readDoubleJSonObject("Summary","Distribution","DispatchedCount");
        return distributionDispatchCount;
    }

    public double getDistributionPendingCount() {

        distributionPendingCount= jSonReader.readDoubleJSonObject("Summary","Distribution","Pending");
        return distributionPendingCount;
    }

    public double getDistributionCompletedCount() {

        distributionCompletedCount= jSonReader.readDoubleJSonObject("Summary","Distribution","Completed");
        return distributionCompletedCount;
    }

    public double getDistributionFailedCount() {

        distributionFailedCount= jSonReader.readDoubleJSonObject("Summary","Distribution","Failed");
        return distributionFailedCount;
    }
}
