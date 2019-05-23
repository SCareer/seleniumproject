package dataprovider;

import Utility.ExcelUtility;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "testdata1")
    public Object[][] Authentication() throws Exception {
        Object[][] testObjArray = ExcelUtility.getTableArray("C:\\Users\\suraj\\seleniumproject\\testng-excel\\src\\test\\TestData.xlsx", "Sheet1");
        return (testObjArray);
    }

    @DataProvider(name = "testdata2")
    public Object[][] Authentication1() throws Exception {
        Object[][] testObjArray = ExcelUtility.getTableArray("C:\\Users\\suraj\\seleniumproject\\testng-excel\\src\\test\\TestData2.xlsx", "Sheet1");
        return (testObjArray);
    }

}
