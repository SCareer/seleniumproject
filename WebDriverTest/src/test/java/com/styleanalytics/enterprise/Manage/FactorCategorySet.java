package com.styleanalytics.enterprise.Manage;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Viswanath on 19/10/2017.
 */
public class FactorCategorySet extends EnterpriseBaseClass {

    /*
    Test Data
    1. Factor Category Administrator Product
     */

    GoTo goTo = new GoTo();
    DateFormat dateFormat = new SimpleDateFormat("d/MM/YY hh:mm:ss");
    Date date = new Date();


    @Test
    public void createFactorCategory() throws IOException, InterruptedException {

        goTo.goToFactorCategory();

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdCreateNew_input\"]")).click();

        Driver.findElement(By.xpath("//*[@id=\"txtName\"]")).sendKeys(dateFormat.format(date)+"Automated Factor Category Set");

        Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[1]/div[3]/div/div[2]/div[2]/div/div/input")).sendKeys("dividend yield");

        WebElement factorSearchResult = Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[2]"));

        System.out.print(factorSearchResult.getText());

        Thread.sleep(10000);

    }


}
