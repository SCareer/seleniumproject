package com.styleanalytics.enterprise.Sharing;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FactorSetsReadOnly extends EnterpriseBaseClass {


    Utility screenShot= new Utility();
    String tDate = screenShot.todaysDate("DD-MM-YY");


    @Test(priority = 1)  // Navigate to Factor Set Screen
    public void accessFactorSet() throws IOException, InterruptedException {

          GoTo goTo = new GoTo();
          goTo.goToFactorSet();

          }

    @Test(priority = 2) // create New Factor set with Read only
    public void createNewFactorSet() throws InterruptedException, IOException {

        Driver.findElement(By.id("ctl00_mainContentPlaceHolder_cmdCreateNew_input")).click();  // click on create button
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"divFactors\"]/div[1]/a")).click();  // selecting Factors from edit screen
        Driver.findElement(By.xpath("//*[@id=\"txtName\"]")).sendKeys(tDate + " FactorSetReadOnly"); // enter factor set name
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdSaveFactorSet_input\"]")).click();   // Saving factor Set

    }


    @Test(priority = 3)
    public void readOnlyFactorSet() throws InterruptedException, IOException {

        GoTo goTo = new GoTo();
        goTo.goToFactorSet();

        String tDate1 = screenShot.todaysDate("DD-MM-YY");
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).clear(); // Cleaing search box from factor set screen
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tDate+ " FactorSetReadOnly"); // enter factor set name
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]/a")).click(); // clikcing on is shared link
        Driver.switchTo().frame(0);

        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[3]/input")).click(); // selecting Read only radio button on access rightt pop up
        Thread.sleep(3000);
        Driver.findElement(By.className("rbDecorated")).click(); //closing access right pop
        Driver.switchTo().defaultContent();
        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).clear(); // Cleaing search box from factor set screen
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tDate + " FactorSetReadOnly"); //searching for Factor Set
        Thread.sleep(3000);
        String ActIsshared =Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]/a")).getText(); //Getting text from is shared column
        String ExpIsShared = "Yes";
        Assert.assertEquals(ActIsshared, ExpIsShared);



    }


       @Test(priority = 4) // log in as other user and access read only factor set
       public void logInAsOtherUser() throws InterruptedException, IOException {

           String OtherUser = property("sharedUser");
           String  Pwd = property("sharedUserPass");

           SharingHelpers sH= new SharingHelpers();

           sH.logOutUser();

           sH.logInasOther(OtherUser, Pwd);

       }

     @Test(priority = 5) // Verify Read only Factor Set by other user
      public void viewReadonlyFactorSet() throws InterruptedException, IOException {

           GoTo goTo = new GoTo();
           goTo.goToFactorSet();
           Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).clear(); // Cleaing search box from factor set screen
           Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tDate + " FactorSetReadOnly"); //searching for Factor Set
           Thread.sleep(3000);
           String x = Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]")).getText();
           String y = "Yes";
           Assert.assertEquals(x,y);
           Assert.assertTrue(true, String.valueOf(Boolean.valueOf(Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]")).isEnabled())));

           }

    @Test(priority = 6)
    public void logBackToOriginalUser() throws Exception {

        LogoutTest();
        loginTest();

        }

    @Test(priority = 7)
    public void deleteReadOnlyFactorSet() throws IOException, InterruptedException {


        GoTo goTo = new GoTo();
        goTo.goToFactorSet();

        try{
            SharingHelpers.deleteFactor(tDate);
        }
        catch(Exception e){
            System.out.println("No Factorsets Found");
        }


    }

    }








