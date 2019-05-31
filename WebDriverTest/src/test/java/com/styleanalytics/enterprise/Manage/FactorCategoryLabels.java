package com.styleanalytics.enterprise.Manage;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 30/11/2017.
 */
public class FactorCategoryLabels extends EnterpriseBaseClass {

    @Test
    public void findLabel() throws IOException, InterruptedException {

        GoTo goTo = new GoTo();

        goTo.goToReportsPage();

        String part1 = "//area[contains(@id,'chartDiv-graph-id0-plotset-plot-0-node-0";
        String part2 = "') and starts-with(@id,'ctl00_mainContentPlaceHolder_report_rptReportPages_ctl00_rptReportItems_ctl00_panContainer')]";


        WebElement label = Driver.findElement(By.xpath(part1+part2));

        System.out.print(label.getText());



    }
}
