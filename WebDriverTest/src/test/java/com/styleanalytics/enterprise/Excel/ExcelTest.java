package com.styleanalytics.enterprise.Excel;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 27/12/2017.
 */
public class ExcelTest extends EnterpriseBaseClass{
@Test
    public void excelDownloadSetup() throws IOException, InterruptedException {




        GoTo goTo=new GoTo();
        goTo.goToReportsPage();

        Utility utility=new Utility();
        //utility.searchPortfolioInReportsPage("");
        utility.downloadReportFromReportsPage("Default Excel Report");

    }

    public int getCount() throws IOException {

        int i = 1;
        while (i < 100) {

            String path = property("ExcelFile" + i);
            if (path == null) {
                break;
            }
            i++;

        }
        return i - 1;
    }

    @Test
    public void count() throws IOException {

        int count = getCount();

        System.out.println(count);
    }


    @Test
    public void defaultExcelTest() throws IOException {

        for (int i = 1; i <= getCount(); i++) {

            System.out.println("-----------------------------------Round " + i + "--------------------------------------------");
            String location = property("ExcelPath");
            String fname = property("ExcelFile" + i);

            String path = location + fname;

            ExcelSummary excelSummary = new ExcelSummary(path);
            ExcelStyleExposure excelStyleExposure = new ExcelStyleExposure(path);
            ExcelSecurityLevelTilt excelSecurityLevelTilt = new ExcelSecurityLevelTilt(path);
            ExcelFactorDetails excelFactorDetails = new ExcelFactorDetails(path);
            ExcelFactorData excelFactorData = new ExcelFactorData(path);
            RiskBySecurities riskBySecurities = new RiskBySecurities(path);
            RiskPersistence riskPersistence = new RiskPersistence(path);
            RiskSummary riskSummary = new RiskSummary(path);
            SizeDistribution sizeDistribution = new SizeDistribution(path);
            StyleDistribution styleDistribution = new StyleDistribution(path);
            WeightDistributionCountry weightDistributionCountry = new WeightDistributionCountry(path);
            WeightDistributionRegion weightDistributionRegion = new WeightDistributionRegion(path);
            WeightDistributionSector weightDistributionSector = new WeightDistributionSector(path);

            try {
                excelSummary.excelSummaryColumnCount();
                excelSummary.excelSummarySheetPresent();
                excelSummary.excelSummarySheetRowCount();
            } catch (Exception e) {

                System.out.println("Issue in Summary" + e);
            }

            try {
                excelStyleExposure.excelSEColumnCount();
                excelStyleExposure.excelSEPresent();
                excelStyleExposure.excelSESheetRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in SE" + e);
            }

            try {
                excelSecurityLevelTilt.excelSecurityLevelTiltPresent();
                excelSecurityLevelTilt.excelSecurityLevelTiltColumnCount();
                excelSecurityLevelTilt.excelSecurityLevelTiltHeaders();
                excelSecurityLevelTilt.excelSecurityLevelTiltSheetRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in SecurityLevelTilt" + e);
            }

            try {
                excelFactorData.excelFactorDataPresent();
                excelFactorData.excelFactorDataColumnCount();
                excelFactorData.excelFactorDataHeaders();
                excelFactorData.excelFactorDataRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in FactorData" + e);
            }

            try {
                excelFactorDetails.excelFactorDetailsPresent();
                excelFactorDetails.excelFactorDetailsColumnCount();
                excelFactorDetails.excelFactorDetailsHeaders();
                excelFactorDetails.excelFactorDetailsSheetRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in FactorDetails" + e);
            }

            try {
                riskBySecurities.excelRiskBySecuritiesPresent();
                riskBySecurities.excelRiskBySecuritiesColumnCount();
                riskBySecurities.excelRiskBySecuritiesHeaders();
                riskBySecurities.excelRiskBySecuritiesRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in RiskBySecurities" + e);
            }

            try {
                riskPersistence.excelRiskPersistencePresent();
                riskPersistence.excelRiskPersistenceColumnCount();
                riskPersistence.excelRiskPersistenceHeaders();
                riskPersistence.excelRiskPersistenceRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in RiskPersistence" + e);
            }

            try {
                riskSummary.excelRiskSummaryPresent();
                riskSummary.excelRiskSummaryColumnCount();
                riskSummary.excelRiskSummaryHeaders();
                riskSummary.excelRiskSummaryRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in RiskSummary" + e);
            }

            try {
                sizeDistribution.excelSizeDistributionPresent();
                sizeDistribution.excelSizeDistributionColumnCount();
                sizeDistribution.excelSizeDistributionHeaders();
                sizeDistribution.excelSizeDistributionRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in SizeDistribution" + e);
            }
            try {
                styleDistribution.excelStyleDistributionPresent();
                styleDistribution.excelStyleDistributionColumnCount();
                styleDistribution.excelStyleDistributionHeaders();
                styleDistribution.excelStyleDistributionRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in StyleDistribution" + e);
            }
            try{
            weightDistributionCountry.excelWeightDistributionCountryPresent();
            weightDistributionCountry.excelWeightDistributionCountryColumnCount();
            weightDistributionCountry.excelWeightDistributionCountryHeaders();
            weightDistributionCountry.excelWeightDistributionCountryRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in WeightDistributionCountry" + e);
            }
            try{
            weightDistributionRegion.excelWeightDistributionRegionPresent();
            weightDistributionRegion.excelWeightDistributionRegionColumnCount();
            weightDistributionRegion.excelWeightDistributionRegionHeaders();
            weightDistributionRegion.excelWeightDistributionRegionRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in WeightDistributionRegion" + e);
            }

            try{
            weightDistributionSector.excelWeightDistributionSectorPresent();
            weightDistributionSector.excelWeightDistributionSectorColumnCount();
            weightDistributionSector.excelWeightDistributionSectorHeaders();
            weightDistributionSector.excelWeightDistributionSectorRowCount();
            } catch (AssertionError e) {

                System.out.println("Issue in WeightDistributionSector" + e);
            }
        }
    }

}
