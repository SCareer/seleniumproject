package com.styleanalytics.enterprise.ReportProfile;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.openqa.selenium.By;

import java.io.IOException;

public class ReportProfileHelpers extends EnterpriseBaseClass {

    public static void createReportProfile(String profileName ) throws InterruptedException, IOException {

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdNewProfile_input\"]")).click();  //clcicking on Add new button
        Thread.sleep(3000);
        Driver.switchTo().frame(0);   // switching to frame
        Driver.findElement(By.xpath("//*[@id=\"txtName\"]")).sendKeys(profileName);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).click();  // click on save button
        Driver.switchTo().defaultContent();
        Thread.sleep(3000);

    }

    public static void createReadOnlyProfile(String ReadOnlyProfile) throws InterruptedException, IOException {

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdNewProfile_input\"]")).click();  //clcicking on Add new button
        Thread.sleep(3000);
        Driver.switchTo().frame(0);   // switching to frame
        Driver.findElement(By.xpath("//*[@id=\"txtName\"]")).sendKeys(ReadOnlyProfile);
        Driver.findElement(By.xpath("//*[@id=\"shareProfileButton\"]/input")).click();
        Driver.switchTo().defaultContent();
        Driver.switchTo().frame(0);
        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[3]/input")).click(); // selecting Read only radio button on access rightt pop up
        Thread.sleep(3000);
        Driver.findElement(By.className("rbDecorated")).click(); //closing access right pop
        Thread.sleep(5000);
        Driver.switchTo().defaultContent();
        Driver.switchTo().frame(1);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).click();  // click on save button
        Driver.switchTo().defaultContent();

    }



    public static void createFullcontrolProfile(String FullcontrolProfile) throws InterruptedException, IOException {

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_cmdNewProfile_input\"]")).click();  //clcicking on Add new button
        Thread.sleep(3000);
        Driver.switchTo().frame(0);   // switching to frame
        Driver.findElement(By.xpath("//*[@id=\"txtName\"]")).sendKeys(FullcontrolProfile);
        Driver.findElement(By.xpath("//*[@id=\"shareProfileButton\"]/input")).click();
        Driver.switchTo().defaultContent();
        Driver.switchTo().frame(0);
        Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[4]/input")).click(); // selecting Read only radio button on access rightt pop up
        Thread.sleep(3000);
        Driver.findElement(By.className("rbDecorated")).click(); //closing access right pop
        Thread.sleep(5000);
        Driver.switchTo().defaultContent();
        Driver.switchTo().frame(1);
        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).click();  // click on save button
        Driver.switchTo().defaultContent();

    }



    public static void searchForReportProfile(String profileName) throws InterruptedException {
        Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input")).clear();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input")).sendKeys(profileName);

    }

    public static void logOutUser(){

        try {

            String url = property("URL");//Get the URL info from config file.

            Driver.get(url + "/authentication/srlogout.aspx");
            Thread.sleep(3000);
            System.out.print("Logout Successfully");

        }catch (Exception e){

            System.out.print("Logout Failed");
        }

    }

    public static void logInasOther(String Uname, String Pword){

        Driver.findElement(By.id("UserLogin_UserName")).sendKeys(Uname);
        Driver.findElement(By.id("UserLogin_Password")).sendKeys(Pword);
        Driver.findElement(By.id("UserLogin_LoginButton")).click();

    }



    public static void deleteReportRpofile(String profileName) throws InterruptedException {

        Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input")).clear();
        Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input")).sendKeys(profileName);

        Driver.findElement(By.className("sgButtonRed")).click(); // clicking on Delete button
        Thread.sleep(3000);
        String dynamicID = Driver.findElement(By.xpath("//iframe[contains(@name,'confirm')]")).getAttribute("name");  //
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id='"+dynamicID+"_content']/div/div[2]/a/span/span")).click();
        /*
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input")).clear();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[1]/div[3]/div/div[2]/div[1]/div/div/input")).sendKeys(profileName);
        try{
            Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[4]/a")).getText();
        } catch (Exception e){

            System.out.println("Delete failed");
        }*/




    }

}
