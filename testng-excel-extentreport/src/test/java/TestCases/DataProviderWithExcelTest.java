package TestCases;

import dataprovider.TestDataProvider;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class DataProviderWithExcelTest {
    WebDriver driver;

    public static final Logger log= Logger.getLogger(DataProviderWithExcelTest.class.getName());

    @BeforeMethod
    public void beforeMethod() throws Exception {

    }

    @Test(groups = "SmokeTest", priority=1, enabled=true, dataProvider = "testdata1", dataProviderClass = TestDataProvider.class)
    public void Test1(String sUserName, String sPassword, String cComments) throws Exception {
        System.out.println(sUserName+"-------------"+sPassword+"------------"+cComments);
    }

    @Test(groups = "SIT", priority=1, enabled=true, dataProvider = "testdata2", dataProviderClass = TestDataProvider.class)
    public void Test2(String sUserName, String sPassword, String cComments) throws Exception {
        System.out.println(sUserName+"-------------"+sPassword+"------------"+cComments);
    }

    @AfterMethod
    public void afterMethod() {
//        driver.close();
    }

    @AfterTest
    public void EndTest() {
//        driver.quit();
    }
}
