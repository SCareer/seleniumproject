package com.styleanalytics.enterprise.DispatchAnalysis;

import com.styleanalytics.enterprise.EnterpriseBaseClass;

import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.enterprise.automation.AutomationTest;
import com.styleanalytics.pages.AnalysisTaskPage;
import com.styleanalytics.pages.PortfolioExplorerPage;
import com.styleanalytics.pages.SearchPage;
import com.styleanalytics.setup.TestBase;


import java.io.IOException;


/**
 * Created by Viswanath on 31/08/2017.
 */
public class DispatchAnalysisHelper extends TestBase {


    public void fromExplorer(String portfolioName) throws Exception {

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.explorePortfolioFromQuickSearch(portfolioName);
        PortfolioExplorerPage explorerPage = new PortfolioExplorerPage(getDriver());
        explorerPage.explorerSettingsView("Tasks");
        AnalysisTaskPage analysisTaskPage = new AnalysisTaskPage(getDriver());
        analysisTaskPage.runAutomatedTask();

    }






}
