package com.styleanalytics.enterprise.automation;

import com.styleanalytics.enterprise.DataDriven.DataDrivenSetup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.styleanalytics.enterprise.Setup.property;

public class WorkSetsTest {

    WorkSets workSetsActual;
    WorkSets workSetsExpected;


    @DataProvider
    public static Object[][] data() throws IOException {

        String testDataFile = property("TestData");

        Object[][] arrayObject = DataDrivenSetup.readFromExcel(testDataFile, "Worksets");

        return arrayObject;

    }

    @Factory(dataProvider ="data")
    public WorkSetsTest(String actual,String expected) throws IOException, ParseException {

        workSetsActual = new WorkSets(actual);
        workSetsExpected = new WorkSets(expected);
    }

    @Test
    public void fileName(){

        Assert.assertEquals(workSetsActual.getFileName(),workSetsExpected.getFileName());

    }
    @Test
    public void dataSource(){

        Assert.assertEquals(workSetsActual.getDataSource(),workSetsExpected.getDataSource());

        }
    @Test
    public void loadStatus(){

        Assert.assertEquals(workSetsActual.getLoadStatus(),"Complete");

    }
    @Test
    public void portfolioCount(){

        Assert.assertEquals(workSetsActual.getPortfolioCount(),workSetsExpected.getPortfolioCount());

    }
    @Test
    public void snapshotCount(){

        Assert.assertEquals(workSetsActual.getSnapshotCount(),workSetsExpected.getSnapshotCount());

    }
    @Test
    public void analysisStatus(){

        Assert.assertEquals(workSetsActual.getAnalysisStatus(),"Complete");

    }
    @Test
    public void waitingForData(){

        Assert.assertEquals(workSetsActual.getWaitingForData(),workSetsExpected.getWaitingForData());

    }
    @Test
    public void analysisDispatchedCount(){

        Assert.assertEquals(workSetsActual.getAnalysisDipachedCount(),workSetsExpected.getAnalysisDipachedCount());

    }
    @Test
    public void analysisPendingCount(){

        Assert.assertEquals(workSetsActual.getAnalysisPendingCount(),workSetsExpected.getAnalysisPendingCount());

    }
    @Test
    public void analysisCompletedCount(){

        Assert.assertEquals(workSetsActual.getAnalysisCompletedCount(),workSetsExpected.getAnalysisCompletedCount());

    }
    @Test
    public void analysisFailedCount(){

        Assert.assertEquals(workSetsActual.getAnalysisFailedCount(),workSetsExpected.getAnalysisFailedCount());

    }

    @Test
    public void exportStatus(){

        Assert.assertEquals(workSetsActual.getExportStatus(),"Complete");


    }
    @Test
    public void exportDispatchedCount(){

        Assert.assertEquals(workSetsActual.getExportDipatchedCount(),workSetsExpected.getExportDipatchedCount());

    }
    @Test
    public void exportsPendingCount(){

        Assert.assertEquals(workSetsActual.getExportPendingCount(),workSetsExpected.getExportPendingCount());

    }
    @Test
    public void exportsCompletedCount(){

        Assert.assertEquals(workSetsActual.getExportCompletedCount(),workSetsExpected.getExportCompletedCount());

    }
    @Test
    public void exportsFailedCount(){

        Assert.assertEquals(workSetsActual.getExportFailedCount(),workSetsExpected.getExportFailedCount());


    }
    @Test
    public void distributionStatus(){

        Assert.assertEquals(workSetsActual.getDistributionStatus(),"Complete");

    }
    @Test
    public void distributionDispatchedCount(){

        Assert.assertEquals(workSetsActual.getDistribtuionDispatchcount(),workSetsExpected.getDistribtuionDispatchcount());

    }
    @Test
    public void distributionPendingCount(){

        Assert.assertEquals(workSetsActual.getDistributionPendingCount(),workSetsExpected.getDistributionPendingCount());

    }
    @Test
    public void distributionCompletedCount(){

        Assert.assertEquals(workSetsActual.getDistributionCompletedCount(),workSetsExpected.getDistributionCompletedCount());

    }
    @Test
    public void distributionFailedCount(){

        Assert.assertEquals(workSetsActual.getDistributionFailedCount(),workSetsExpected.getDistributionFailedCount());

    }
    @Test
    public void workSetProgress(){

        Assert.assertEquals(workSetsActual.getWorkSetProgress(),"Complete");


    }

    @Test
    public void failedCount(){

        Assert.assertEquals(workSetsActual.getFailedCount(),workSetsExpected.getFailedCount());

    }
}
