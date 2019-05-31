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


public class FactorSetsSharing  extends Utility {

    Utility screenShot= new Utility();

    private String ydate = yesterdaysDate("dd/MM/YY");

    private String tdate = todaysDate("dd/MM/yy HH:mm");


    @Test(priority = 1)

        public void accessFactorSet() throws IOException, InterruptedException {

            GoTo goTo = new GoTo();
            goTo.goToFactorSet();


        }


    @Test(priority = 2)///Creating new FactorSet
    public void createNewFactor() throws InterruptedException, IOException {


        Thread.sleep(3000);
        //accessFactorSet();
        Driver.findElement(By.id("ctl00_mainContentPlaceHolder_cmdCreateNew_input")).click(); //clicking on create new button from Factor Set Screen
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"divFactors\"]/div[1]/a")).click();   // clicking on name text box
        Driver.findElement(By.xpath("//*[@id=\"txtName\"]")).sendKeys(tdate + " AutoFactorSet");   // enter factor name
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdSaveFactorSet_input\"]")).click();       //Click Save button to Save factor


    }


    @Test(priority = 3)// Verifying is Default shared is No for created FctorSet
    public void defaultIsShared() throws IOException, InterruptedException {



        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).clear(); // Clearing name search box from Manage factor set screen
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + " AutoFactorSet");//searching for Factor Set
        String ActIsshared =Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]/a")).getText(); //Getting text from is shared column
        String ExpIsShared = "No";
        Assert.assertEquals(ActIsshared, ExpIsShared);


    }

    @Test(priority = 4)
    public void editButton() throws InterruptedException, IOException {   // verifing Edit button visible


        Thread.sleep(3000);
        String ActEditButtonTxt = Driver.findElement(By.className("sgButtonGreen")).getText(); //Getting Edit button text of created Facotr set
        String ExpEditButtonTxt = "EDIT";
        Assert.assertEquals(ActEditButtonTxt, ExpEditButtonTxt);


            }



    @Test(priority = 5)  // verifing Delete button visible
    public void deleteButton() throws InterruptedException, IOException {

        Thread.sleep(3000);
        String ActDeleteButtonTxt = Driver.findElement(By.className("sgButtonRed")).getText(); //Getting Delete button text of created Facotr set
        String ExpDeleteButtonTxt = "DELETE";
        Assert.assertEquals(ActDeleteButtonTxt, ExpDeleteButtonTxt);


    }

    @Test(priority = 6) // Accessing Factor set Edit screen by clicking on view
    public void viewFactorSet() throws InterruptedException, IOException {


        Thread.sleep(3000);
        Driver.findElement(By.className("sgButtonGreen")).click();   // click on Edit button agaianest factor
        Thread.sleep(4000);
        String ActFactorSetName = Driver.findElement(By.xpath("//*[@id=\"txtName\"]")).getAttribute("value"); // Getting Factor set name from edit view
        String ExpFactorSetName = tdate + " AutoFactorSet";
        Assert.assertEquals(ActFactorSetName, ExpFactorSetName);


    }


    @Test(priority = 7) // verifying sharing lable text
    public void sharingLabel() throws InterruptedException, IOException {


        Thread.sleep(3000);
        String ActSharingLable = Driver.findElement(By.xpath("//*[@id=\"divContent\"]/div[2]/label")).getText();  // get sharing label text from Edit view
        String ExpSharingLable = "Sharing:";
        Assert.assertEquals(ActSharingLable, ExpSharingLable);


       }

    @Test(priority = 8) // Verifing sharing Text
    public void sharingTextofNotSharedFactorSet() throws InterruptedException, IOException {


        Thread.sleep(3000);
        String ExpSharedTxt = Driver.findElement(By.className("accessRightsLabel")).getText();   //Getting sharing access text
        String ActSharedTxt = "Not shared";
        Assert.assertEquals(ExpSharedTxt, ActSharedTxt);



    }
    @Test(priority = 9) ///change from not sghared to Read only factor set from Edit Screen
    public void editToReadyonlyFactorSetFromEditScreen() throws InterruptedException, IOException {


        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"shareTemplateButton\"]/input")).click();  //click on Edit button
        Thread.sleep(3000);
        Driver.switchTo().frame(0);   /// accessing access right pop up window
        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[3]/input")).click();  /// Select Read only radio button
        Driver.findElement(By.className("rbDecorated")).click(); // click on save
        Driver.switchTo().defaultContent();
        Thread.sleep(5000);

        String ActSharinglblTxt = Driver.findElement(By.className("accessRightsLabel")).getText(); // getting sharing label text
        String ExpSharinglblTxt = "Shared with 1 group";
        Assert.assertEquals(ActSharinglblTxt, ExpSharinglblTxt);
        Driver.findElement(By.className("rbDecorated")).click();  // click on sve from edit scereen
        Thread.sleep(5000);


        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + " AutoFactorSet"); //searching for Factor Set
        String ActIsshared =Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]/a")).getText(); //Getting text from is shared column
        String ExpIsShared = "Yes";
        Assert.assertEquals(ActIsshared, ExpIsShared);



    }

    @Test(priority = 10)
    public void EditToFullcontrolFactorSetFromEditScreen() throws InterruptedException, IOException {


        Thread.sleep(3000);
        Driver.findElement(By.className("sgButtonGreen")).click(); // Navigating to Edit scrren from view By clicking on Edit button

        Driver.findElement(By.xpath("//*[@id=\"shareTemplateButton\"]/input")).click(); // clikcing on edit button
        Thread.sleep(3000);
        Driver.switchTo().frame(0); // access right pop up screen
        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[4]/input")).click(); // select full control radio button
        Driver.findElement(By.className("rbDecorated")).click(); // click on save button
        Driver.switchTo().defaultContent();
        Thread.sleep(5000);


        String ActSharinglblTxt = Driver.findElement(By.className("accessRightsLabel")).getText();  // verify sharing text
        System.out.println(ActSharinglblTxt);
        String ExpSharinglblTxt = "Shared with 1 group";
        Assert.assertEquals(ActSharinglblTxt, ExpSharinglblTxt);
        Driver.findElement(By.className("rbDecorated")).click(); // click save to  navigate to Manage Factor set screen
        Thread.sleep(5000);


        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + " AutoFactorSet"); //searching for Factor Set
        String ActIsshared =Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]/a")).getText(); //Getting text from is shared column
        String ExpIsShared = "Yes";
        Assert.assertEquals(ActIsshared, ExpIsShared);

    }
     /// verifing access right pop up window from manage factors set screen
     @Test(priority = 11)
      public void accessRightPopupFromFactorSetScreen() throws InterruptedException, IOException {

         Thread.sleep(3000);
         Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).clear(); // clear text from name search box
         Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + " AutoFactorSet"); //searching for Factor Set
         Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]/a")).click(); // click on sharing  link yes or no
         Driver.switchTo().frame(0);   // switching to frame
         Boolean ActSelected= Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[4]/input")).isSelected(); // verifying selected radio buttons on pop up screen
         Boolean ExpSelected =true;
         Assert.assertEquals(ActSelected, ExpSelected);

     }

        @Test(priority = 12) // Edit access right to Not shared from full control
        public void EditToNotShared() throws InterruptedException, IOException {


        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[2]/input")).click(); // // click on sharing  not shared radio button
        Thread.sleep(3000);
        Driver.findElement(By.className("rbDecorated")).click(); //closing access right pop
        Thread.sleep(3000);

        Driver.switchTo().defaultContent();  // come out of frame
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + " AutoFactorSet"); //searching for Factor Set
        System.out.println("bb");
        String ActIsshared =Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]/a")).getText(); //Getting text from is shared column
        String ExpIsShared = "No";
        Assert.assertEquals(ActIsshared, ExpIsShared);



    }


    @Test(priority = 13)/// editing Not shared Factor set to Readonly from fact set screen
    public void EditToReadonlyShared() throws InterruptedException, IOException {


        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).clear(); // Cleaing search box from factor set screen
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + " AutoFactorSet"); //searching for Factor Set
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]/a")).click(); // clikcing on is shared link

        Driver.switchTo().frame(0);

        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[3]/input")).click(); // selecting Read only radio button on access rightt pop up
        Thread.sleep(3000);
        Driver.findElement(By.className("rbDecorated")).click(); //closing access right pop
        Driver.switchTo().defaultContent();
        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).clear(); // Cleaing search box from factor set screen
        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(tdate + " AutoFactorSet"); //searching for Factor Set
        Thread.sleep(3000);
        String ActIsshared =Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div[1]/div[4]/a")).getText(); //Getting text from is shared column
        String ExpIsShared = "Yes";
        Assert.assertEquals(ActIsshared, ExpIsShared);


    }

    @Test(priority = 14)
    public void deleteReadOnlyFactorSet() throws IOException, InterruptedException {

        GoTo goTo = new GoTo();
        goTo.goToFactorSet();

        try{
            SharingHelpers.deleteFactor(ydate);
        }
        catch(Exception e){
            System.out.println("No Factorsets Found");
        }



    }





}

