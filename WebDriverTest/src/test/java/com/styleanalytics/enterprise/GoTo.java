package com.styleanalytics.enterprise;

import java.io.IOException;

/**
 * Created by Viswanath on 08/09/2017.
 */
public class GoTo extends EnterpriseBaseClass {

    public static void goToExplorerPage() throws IOException {

        String url = property("URL");
        Driver.get(url+"/Portfolio/explore.aspx");

    }
    public void goToExplorerPage1() throws IOException {

        String url = property("URL");
        Driver.get(url+"/Portfolio/explore.aspx");

    }

    public static void goToReportsPage() throws IOException {

        String url = property("URL");

        Driver.get(url+"/analysis/viewReports.aspx");

        //Utility.waitForReportsToLoad(10);

    }

    public void goToLoadPage() throws IOException {

        String url = property("URL");

        Driver.get(url+"/Portfolio/loadPortfoliosSelect.aspx");//

    }


    public void goToFactorCategory() throws IOException {

        String url = property("URL");

        Driver.get(url+"/analysis/FactorCategoriesList.aspx");

    }

    public void goToFactorSet() throws IOException {

        String url = property("URL");

        Driver.get(url+"/analysis/factorsetlist.aspx");

    }


    public void goToImportMonitor() throws IOException {

        String url = property("URL");

        Driver.get(url+"/Automation/ImportMonitor.aspx");

    }

    public void goToTemplates() throws IOException {

        String url = property("URL");

        Driver.get(url+"/Reporting/BlockTemplateList.aspx");

    }

    public void goToReportProfiles() throws IOException {

        String url = property("URL");

        Driver.get(url+"/settings/reportprofileslist.aspx");

    }

    public static void dataMart() throws IOException {

        String url = property("URL");

        Driver.get(url+"/datamart/datamartselector.aspx");
    }


    public static void goToDashboard() throws IOException {

        String url = property("URL");

        Driver.get(url+"/default.aspx");

    }
    public static void goToExplore() throws IOException {

        String url = property("URL");

        Driver.get(url+"/Portfolio/explore.aspx");

    }

    public static void taskActivity() throws IOException {

        String URL = property("URL");

        Driver.get(URL + "/activity/taskexplorer.aspx");
    }

    public static void goToAnalysisPage() throws InterruptedException, IOException {

        String URL = property("URL");
        Driver.get(URL + "/Analysis/viewAnalysis.aspx");
    }



    public static void goToExecutiveReportsPage() throws InterruptedException, IOException {

        String URL = property("URL");
        Driver.get(URL + "/Reporting/DashboardReportList.aspx");
    }


    public void gotToFactorSets() throws IOException {

        String url = property("URL"); //Get the url from config file

        Driver.get(url + "/analysis/factorsetlist.aspx"); //Go to factor sets page
    }

    public static void peerInsights() throws IOException {

        String url = property("URL"); //Get the url from config file

        Driver.get(url + "/PeerGroups/PeerGroupSelector.aspx"); //Go to Peer Insights Landing Page


    }



    public static void portfolioLabs() throws IOException {

        String url = property("URL"); //Get the url from config file

        Driver.get(url + "/portfolioscenario/portfolioScenarioOpen.aspx"); //Go to Portfolio Labs landing Page

    }





    }
