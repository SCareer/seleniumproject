package com.styleanalytics.enterprise.PortfolioReports;

import com.styleanalytics.enterprise.AnalysisPages.AnalysisPageHelper;
import com.styleanalytics.enterprise.DispatchAnalysis.DispatchAnalysisHelper;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Notification.NotificationHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PortfolioWebReportTest extends EnterpriseBaseClass {

    @Test
    public void standardMonthlyPortfolioTest() throws Exception {

      AnalysisPageHelper.deleteCompletedAnalysisFromAnalysisPage("Automated - Notification Test");

       int completedJobCountBefore = NotificationHelper.getAnalysisCompletedCount();

        DispatchAnalysisHelper dispatchAnalysisHelper = new DispatchAnalysisHelper();

        dispatchAnalysisHelper.fromExplorer("Automated - Notification Test");

        int completedJobCountAfter=0;

       for(int i=0;i<10;i++) {

            completedJobCountAfter = NotificationHelper.getAnalysisCompletedCount();

           if (completedJobCountAfter == completedJobCountBefore) {

               Thread.sleep(3000);

           }else if (completedJobCountAfter==completedJobCountBefore+40){

               break;

           }else if(completedJobCountAfter<completedJobCountBefore+40){

               Thread.sleep(3000);
           }

       }
       if(completedJobCountAfter!=completedJobCountBefore+40){

           Assert.fail("Jobs not completed");

           }









    }
}

