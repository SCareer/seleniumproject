package com.styleanalytics.enterprise.Login;

import com.styleanalytics.enterprise.Setup;
import com.styleanalytics.enterprise.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;



    public LoginTest() throws Exception {

        Setup setup = new Setup(driver);

        driver=setup.browserSetupToLogin();

        loginPage = new LoginPage(driver);




    }
    @Test
    public void loginTest() throws IOException {


        loginPage.login();

    }



    @Test
    public void loginOut() throws IOException {

        loginPage.logout();

    }

}
