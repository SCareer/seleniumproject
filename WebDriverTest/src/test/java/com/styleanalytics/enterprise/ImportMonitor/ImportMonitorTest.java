package com.styleanalytics.enterprise.ImportMonitor;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Login.LoginPage;
import com.styleanalytics.pages.ImportMonitorPage;
import com.styleanalytics.setup.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Viswanath on 05/06/2017.
 */
public class ImportMonitorTest extends TestBase {

    ImportMonitorPage importMonitorPage;

    @BeforeClass
    public void importMonitorSetup() throws IOException {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
        importMonitorPage = new ImportMonitorPage(getDriver());

    }

    @Test
    public void checkImportMonitorPage() throws Exception {

        importMonitorPage.goToImportMonitorPage(getURL());
        if(!getDriver().getTitle().equalsIgnoreCase("Import Monitor")){
            throw new Exception("Navigation Failed, went to :"+getDriver().getTitle());
        }


    }

}
