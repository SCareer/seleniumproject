package dataprovider;

import Utility.ExcelUtility;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "testdata1")
    public Object[][] Authentication() throws Exception {
        Object[][] testObjArray = ExcelUtility.getTableArray("C:\\Users\\suraj\\seleniumproject\\testng-excel-extentreport\\src\\test\\resources\\TestData.xlsx", "Sheet1");
        return (testObjArray);
    }

    @DataProvider(name = "testdata2")
    public Object[][] Authentication1() throws Exception {
        Object[][] testObjArray = ExcelUtility.getTableArray("C:\\Users\\suraj\\seleniumproject\\testng-excel-extentreport\\src\\test\\TestData2.xlsx", "Sheet1");
        return (testObjArray);
    }

    @DataProvider(name = "ExpediaTestData")
    public Object[][] ExpediaTestData() throws Exception {
        Object[][] testObjArray = ExcelUtility.getTableArray("C:\\Users\\suraj\\seleniumproject\\testng-excel-extentreport\\src\\test\\resources\\ExpediaTestData.xlsx", "Sheet1");
        return (testObjArray);
    }

    @DataProvider(name = "ExpediaTestData1")
    public Object[][] ExpediaTestData1() throws Exception {
        Object[][] testObjArray = ExcelUtility.getTableArray("C:\\Users\\suraj\\seleniumproject\\testng-excel-extentreport\\src\\test\\resources\\ExpediaTestData.xlsx", "Sheet2");
        return (testObjArray);
    }
}
