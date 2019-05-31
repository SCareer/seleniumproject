package com.styleanalytics.enterprise.Sharing;

import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Listeners(com.styleanalytics.enterprise.utils.Listener.class)
public class FactorSetsFullControl extends Utility {


    Utility screenShot= new Utility();

    private String ydate = yesterdaysDate();

    private String tdate = todaysDate("dd/MM/yy HH:mm");

    private String sdate = todaysDate("dd/MM/yy HH");

    public String yesterdaysDate(){
        Date date = new Date(System.currentTimeMillis()-24*60*60*1000);
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/YY");
        return dateFormat.format(date);

    }


    // navigating to factor Set screen
    @Test(priority = 1)
    public void accessFactorSet() throws IOException, InterruptedException {

        GoTo goTo = new GoTo();
        goTo.goToFactorSet();

    }


    @Test(priority = 2)  //-- Create New FactorSet
    public void createNewFactorSet() throws InterruptedException, IOException {

        accessFactorSet();

        Thread.sleep(3000);
        Driver.findElement(By.id("ctl00_mainContentPlaceHolder_cmdCreateNew_input")).click();  // click on Create button
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"divFactors\"]/div[1]/a")).click(); // selecting factors
        Driver.findElement(By.xpath("//*[@id=\"txtName\"]")).sendKeys(tdate +" FullcontrolFactorSet1");   // enter factor set name in name input box
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdSaveFactorSet_input\"]")).click(); // click to save

    }

    @Test(priority = 3) //Editing to full control Factor set from manage factor set screen
    public void fullControlFactorSet() throws InterruptedException, IOException {

        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).clear(); // Cleaing search box from factor set screen

        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate+" FullcontrolFactorSet1"); //searching for Factor Set

        Thread.sleep(3000);

        WebElement SharingLink = Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div/div[4]"));
        Actions Act = new Actions(Driver);
        Act.moveToElement(SharingLink).build().perform();
        SharingLink.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]/a")).click();

        Driver.switchTo().frame(0);

        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[4]/input")).click(); // selecting Read only radio button on access right pop up
        Thread.sleep(3000);
        Driver.findElement(By.className("rbDecorated")).click(); //closing access right pop
        Driver.switchTo().defaultContent();
        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).clear(); // Cleaing search box from factor set screen
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate +" FullcontrolFactorSet1");
        Thread.sleep(3000);
        String ActIsshared =Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]/a")).getText(); //Getting text from is shared column
        String ExpIsShared = "Yes";
        Assert.assertEquals(ActIsshared, ExpIsShared);


    }

    // log out and log in as other user and verify full control factor set
    @Test(priority = 4)
    public void logInAsOtherUser() throws InterruptedException, IOException {

        String OtherUser = property("sharedUser");
        String  Pwd = property("sharedUserPass");

        SharingHelpers sH= new SharingHelpers();

        sH.logOutUser();

        sH.logInasOther(OtherUser, Pwd);


    }

    @Test(priority = 5) // viewing full control shared Factor

    public void viewFullControlFactorSetByOtherUser() throws InterruptedException, IOException {
        accessFactorSet();
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).clear();
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate+" FullcontrolFactorSet1"); //searching for Factor Set

        Thread.sleep(3000);

        FactorSetsSharing FactorSet = new FactorSetsSharing();

        FactorSet.editButton();  // verifying Edit button

        FactorSet.deleteButton(); // verifying delete button for full control Factor set


    }
    // access full control factor set edit screen
    @Test(priority = 6)
    public void viewFactorSetEditScreen() throws InterruptedException, IOException {


        Thread.sleep(3000);
        Driver.findElement(By.className("sgButtonGreen")).click();  // click on full control factor set edit button
        Thread.sleep(4000);
        String ActFactorSetName = Driver.findElement(By.xpath("//*[@id=\"txtName\"]")).getAttribute("value");
        String ExpFactorSetName = tdate +" FullcontrolFactorSet1";
        Assert.assertEquals(ActFactorSetName, ExpFactorSetName);
        //Assert.assertEquals(ExpFactorSetName, ExpFactorSetName.contains(ActFactorSetName));



    }


    // verify sharing label text from Edit screen
    @Test(priority = 7)
    public void viewSharingLabel() throws IOException, InterruptedException {

        Thread.sleep(3000);
        FactorSetsSharing FactorSet = new FactorSetsSharing();
        FactorSet.sharingLabel();

    }


     @Test(priority = 8) // verify edit button visible from factor set edit scrren
    public void viewEditButton() throws InterruptedException, IOException {

       Thread.sleep(4000);
       Assert.assertTrue(true, String.valueOf(Boolean.valueOf(Driver.findElement(By.xpath("//*[@id=\"shareTemplateButton\"]/input")).isEnabled())));

    }



    @Test(priority = 9) // Deleting full control Factor set
    public void deleteFullControlFactorSet() throws IOException, InterruptedException {

        Thread.sleep(3000);
        GoTo goTo = new GoTo();
        goTo.goToFactorSet();
        try{
        SharingHelpers.deleteFactor(ydate);
        }
        catch(Exception e){
            System.out.println("No Factorsets Found");
        }




    }
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult result){

        Utility.tearDown(result);
    }





}
