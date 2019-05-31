package com.styleanalytics.enterprise;

import com.styleanalytics.enterprise.DataDriven.DataDrivenSetup;
import com.styleanalytics.enterprise.Login.LoginPage;

import com.styleanalytics.pages.DashboardPage;
import com.styleanalytics.pages.SiteMapPage;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SiteMapTest extends TestBase {

    SiteMapPage siteMapPage;
    LoginPage loginPage;


   @BeforeClass
   public void setup() throws IOException {
       siteMapPage = new SiteMapPage(getDriver());
       loginPage = new LoginPage(getDriver());
       loginPage.login();

   }
   @AfterMethod
   public void tearDown(){

       DashboardPage dashboardPage = new DashboardPage(getDriver());
       try {
           dashboardPage.setDashboard();
       }catch (Exception e){
           e.printStackTrace();
           getDriver().navigate().refresh();
       }
   }


    public void siteMapMenuTest(String element, String title) throws Exception {

        //siteMapPage.setSiteMenu(element);
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase(title)){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }

    }

    @Test
    public void portfolios() throws Exception {

        siteMapPage.setPortfolios();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Portfolio")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }

    }

    @Test
    public void explore() throws Exception {

        siteMapPage.setExplore();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Portfolio")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }

    }

    @Test
    public void dataMart() throws Exception {

        siteMapPage.setDataMart();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Data Mart")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }

    }

    @Test
    public void importMonitor() throws Exception {

        siteMapPage.setImportMonitor();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Import Monitor")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }

    }

    @Test
    public void automation() throws Exception {

        siteMapPage.setAutomation();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Auto Data Source")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }

    }

    @Test
    public void reports() throws Exception {

        siteMapPage.setReports();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Reports")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void portfolioReports() throws Exception {

        siteMapPage.setPortfolioReports();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Reports")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void peerInsights() throws Exception {

        siteMapPage.setPeerInsights();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Peer Group Report")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void exportedReports() throws Exception {

        siteMapPage.setExportedReports();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Exported Reports")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void executiveReports() throws Exception {

        siteMapPage.setExecutiveReports();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Executive Reports")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void load() throws Exception {

        siteMapPage.setLoad();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Load Data")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void analyses() throws Exception {

        siteMapPage.setAnalyses();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Analysis")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }
    @Test
    public void activity() throws Exception {

        siteMapPage.setActivity();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Task Activity")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void taskActivity() throws Exception {

        siteMapPage.setTaskActivity();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Task Activity")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void fileActivity() throws Exception {

        siteMapPage.setFileActivity();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void portfolioLabs() throws Exception {

        siteMapPage.setPortfolioLabs();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Portfolio Lab")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void templates() throws Exception {

        siteMapPage.setTemplates();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Templates")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void manage() throws Exception {

        siteMapPage.setManage();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Style Analytics Enterprise")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    //@Test
    public void manageCalcset() throws Exception {

        siteMapPage.setManageCalcset();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Style Analytics Enterprise")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void fileSpecification() throws Exception {

        siteMapPage.setFileSpecifications();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("File Specifications")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void factorSets() throws Exception {

        siteMapPage.setFactorSets();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Factor Sets")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void factorCategorySets() throws Exception {

        siteMapPage.setFactorCategorySets();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Factor Category Sets")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void userDefinedFactors() throws Exception {

        siteMapPage.setUserDefinedFactors();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Assets")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    //@Test
    public void upgradeFactorAnalysis() throws Exception {

        siteMapPage.setUpgradeFactorAnalysis();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Assets")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void assets() throws Exception {

        siteMapPage.setAssets();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Assets")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }
    @Test
    public void equities() throws Exception {

        siteMapPage.setEquities();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Assets")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void userDefinedBonds() throws Exception {

        siteMapPage.setUserDefinedBonds();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Assets")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void userDefinedMBS() throws Exception {

        siteMapPage.setUserDefinedMBS();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Assets")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void currencies() throws Exception {

        siteMapPage.setCurrencies();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Assets")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void funds() throws Exception {

        siteMapPage.setFunds();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Assets")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void manualStockMatchHistory() throws Exception {

        siteMapPage.setManualStockMatchHistory();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Assets")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void newsAndEvents() throws Exception {

        siteMapPage.setNewsEvents();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void fundsAnalyzer() throws Exception {

        siteMapPage.setFundsAnalyzer();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Funds Analyzer")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void preferences() throws Exception {

        siteMapPage.setPreferences();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Explore Preferences")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    //@Test
    public void support() throws Exception {

        siteMapPage.setSupport();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Support")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void documents() throws Exception {

        siteMapPage.setDocuments();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Style Analytics Enterprise - Help")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void about() throws Exception {

        siteMapPage.setAbout();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Portfolio Analyzer - About")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void updateSchedule() throws Exception {

        siteMapPage.setUpdateSchedule();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Style Analytics Enterprise - Update Schedule")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }

    @Test
    public void changePassword() throws Exception {

        siteMapPage.setChangePassword();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Style Analytics Change Password")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
        getDriver().navigate().back();
    }

    @Test
    public void serviceRequest() throws Exception {

        siteMapPage.setServiceRequest();
        System.out.println(getDriver().getTitle());
        if(!getDriver().getTitle().equalsIgnoreCase("Service Requests")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }
    }




}
