package com.styleanalytics.enterprise.Notification;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import java.io.IOException;

public class NotificationHelper extends EnterpriseBaseClass {


    public static int getAnalysisCompletedCount() throws IOException, InterruptedException {

        GoTo.goToDashboard();

        NotificationPage nPage = new NotificationPage();

        Thread.sleep(8000);

        nPage.setAnalysisNotificationIcon();

        Thread.sleep(5000);

        WebElement analysisCompletedCount = Driver.findElement(By.xpath("//*[@id=\"html\"]/body/div/div/div[3]/span[2]"));

        String countText = analysisCompletedCount.getText();


        int count = Integer.parseInt(countText);

        return count;
    }

    public static int getAnalysisFailedCount() throws IOException, InterruptedException {

        GoTo.goToDashboard();

        NotificationPage nPage = new NotificationPage();

        Thread.sleep(8000);

        nPage.setAnalysisNotificationIcon();

        Thread.sleep(5000);

        WebElement analysisCompletedCount = Driver.findElement(By.xpath("//*[@id=\"html\"]/body/div/div/div[3]/span[2]"));

        String countText = analysisCompletedCount.getText();

        int count = Integer.parseInt(countText);

        return count;
    }
    @Test
    public void test() throws IOException, InterruptedException {

        int a = getAnalysisCompletedCount();

        System.out.println(a);


    }
}
