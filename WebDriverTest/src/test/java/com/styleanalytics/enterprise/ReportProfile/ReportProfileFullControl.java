package com.styleanalytics.enterprise.ReportProfile;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReportProfileFullControl extends EnterpriseBaseClass {

    public void accessReportProfile() throws IOException {
        GoTo goTo = new GoTo();
        goTo.goToReportProfiles();

    }


    @Test(priority =1)
    public void createFullControlProfile() throws IOException, InterruptedException {

        String FullControlProfileName = property("FullControlProfileName");

        accessReportProfile();

        ReportProfileHelpers.createFullcontrolProfile(FullControlProfileName);
        Thread.sleep(3000);

        ReportProfileHelpers.searchForReportProfile(FullControlProfileName);

        Thread.sleep(3000);

        String name = Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[1]")).getText();
        Assert.assertEquals(name, FullControlProfileName);



    }

    @Test(priority = 2)
    public void isSharedText() throws IOException, InterruptedException {

        String FullControlProfileName = property("FullControlProfileName");

        accessReportProfile();

        ReportProfileHelpers.searchForReportProfile(FullControlProfileName);

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[3]/a")).getText(), "Yes");

    }

    @Test(priority = 3)
    public void columnsCheck() throws IOException, InterruptedException {

        String FullControlProfileName = property("FullControlProfileName");

        accessReportProfile();

        ReportProfileHelpers.searchForReportProfile(FullControlProfileName);

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[4]/a")).getText() , "EDIT");

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[5]/a")).getText() , "DELETE");



    }


    @Test(priority = 4)

    public void fullControlProfileByotherUser() throws IOException, InterruptedException {

        String FullControlProfileName = property("FullControlProfileName");

        ReportProfileHelpers.logOutUser();

        ReportProfileHelpers.logInasOther("antony.gilbert@styleresearch.com", "Test1234%");

        accessReportProfile();

        ReportProfileHelpers.searchForReportProfile(FullControlProfileName);

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[3]/a")).getText(), "Yes");



    }


    @Test(priority = 5)

    public void editViewByOtherUser() throws IOException, InterruptedException {

        accessReportProfile();

        String FullControlProfileName = property("FullControlProfileName");

        ReportProfileHelpers.searchForReportProfile(FullControlProfileName);

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[4]/a")).click();

        Thread.sleep(3000);

        Driver.switchTo().frame(0);

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"shareProfileButton\"]/span")).getText(),"Shared with everyone" );

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"shareProfileButton\"]/input")).getAttribute("value"),"Edit" );

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).getAttribute("value"),"Save" );

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butCancel_input\"]")).getAttribute("value"),"Cancel" );

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butCancel_input\"]")).click();

        Driver.switchTo().defaultContent();
    }


       @Test(priority = 6)

       public void editFullControlProfileByOtherUser() throws IOException, InterruptedException {


           String FullControlProfileName = property("FullControlProfileName");

           ReportProfileHelpers.searchForReportProfile(FullControlProfileName);

           Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[4]/a")).click();

           Thread.sleep(3000);

           Driver.switchTo().frame(0);

           Driver.findElement(By.xpath("//*[@id=\"shareProfileButton\"]/input")).click();

           Driver.switchTo().defaultContent();

           Driver.switchTo().frame(0);

           Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[3]/input")).click(); // selecting Read only radio button on access rightt pop up
           Thread.sleep(3000);
           Driver.findElement(By.className("rbDecorated")).click(); //closing access right pop
           Thread.sleep(5000);
           Driver.switchTo().defaultContent();
           Driver.switchTo().frame(0);
           Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).click();  // click on save button
           Driver.switchTo().defaultContent();

           ReportProfileHelpers.searchForReportProfile(FullControlProfileName);

           Thread.sleep(3000);



       }

    @Test(priority = 7)

    public void deleteFullControlProfile() throws IOException, InterruptedException {


        String FullControlProfileName = property("FullControlProfileName");

        ReportProfileHelpers.logOutUser();

        ReportProfileHelpers.logInasOther("praveen.mamidi@styleresearch.com", "Test1234%");

        accessReportProfile();

        ReportProfileHelpers.searchForReportProfile(FullControlProfileName);

        ReportProfileHelpers.deleteReportRpofile(FullControlProfileName);

        Thread.sleep(3000);

        try{
            Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[4]/a")).getText();
        } catch (Exception e){

            System.out.println("Delete failed");
        }


    }

}
