package com.styleanalytics.enterprise.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {

    static String filePath = "c:\\Selenium\\Screenshots\\";

    public static void takeScreenShot(String methodName, WebDriver driver) {

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
