package com.styleanalytics.enterprise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Viswanath on 21/06/2017.
 */
public class Browser {

    static WebDriver Driver;
    @Test
    @Parameters("browser")
    public void setup(String browserName) throws Exception{

        if (browserName.equalsIgnoreCase("Firefox")) {

            Driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("Chrome")) {

            System.setProperty("webdriver.chrome.driver", "C:/Selenium/Chrome Driver/chromedriver.exe");
            Driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("ie")) {

            System.setProperty("webdriver.ie.driver",
                    "C:/Users/MSTEMP/Downloads/Softwares/IEDriverServer/IEDriverServer.exe");
            Driver = new InternetExplorerDriver();
        }
        else {

            throw new Exception("Browser is not correct");
        }
        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
