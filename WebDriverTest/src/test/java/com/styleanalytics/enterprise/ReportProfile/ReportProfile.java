package com.styleanalytics.enterprise.ReportProfile;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ReportProfile extends EnterpriseBaseClass {

    DateFormat dateFormat = new SimpleDateFormat("d/MM/YY hh:mm:ss");
    Date date = new Date();
    String profileName = property("ProfileName");
    public ReportProfile() throws IOException {

    }


    @Test(priority = 1)
    public void accessReportProfile() throws IOException {
        GoTo goTo = new GoTo();
        goTo.goToReportProfiles();
    }


    @Test(priority = 2)
    public void createNotSharedProfile() throws InterruptedException, IOException {

        String profileName = property("ProfileName");

        Thread.sleep(3000);

        ReportProfileHelpers.createReportProfile(profileName);

        ReportProfileHelpers.searchForReportProfile(profileName);

        String name = Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[1]")).getText();
        Assert.assertEquals(name, profileName);


    }

    @Test(priority = 3)

    public void columnsCheck(){

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[3]/a")).getText() , "No");


        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[4]/a")).getText() , "EDIT");

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[5]/a")).getText() , "DELETE");

    }



    @Test(priority = 4)
    public void editReportProfileView() throws InterruptedException {

        Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[4]/a")).click();

        Thread.sleep(3000);

        Driver.switchTo().frame(0);   // switching to frame

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"divFormRows\"]/div[2]/label")).getText(),"Sharing:" );

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"shareProfileButton\"]/input")).getAttribute("value"),"Edit" );

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butSave_input\"]")).getAttribute("value"),"Save" );

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butCancel_input\"]")).getAttribute("value"),"Cancel" );

        Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butCancel_input\"]")).click();

        Driver.switchTo().defaultContent();

    }

       @Test(priority = 5)
        public void notSharedProfileByOtherUser() throws IOException, InterruptedException {

           String profileName = property("ProfileName");

            ReportProfileHelpers.logOutUser();
            ReportProfileHelpers.logInasOther("antony.gilbert@styleresearch.com" ,"Test1234%" );
            accessReportProfile();

            ReportProfileHelpers.searchForReportProfile(profileName);

            List<WebElement> FactorSets = Driver.findElements(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div")); // verifing not sharedFactor factor set
            Assert.assertEquals(FactorSets.size(), 0);

        }


         @Test(priority = 6)
         public void EditNotSharedProfile() throws IOException, InterruptedException {

             String profileName = property("ProfileName");

             ReportProfileHelpers.logOutUser();

             ReportProfileHelpers.logInasOther("praveen.mamidi@styleresearch.com" ,"Test1234%" );

             accessReportProfile();

             Thread.sleep(4000);

             ReportProfileHelpers.searchForReportProfile(profileName);

             Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[4]/a")).click();

             Thread.sleep(3000);

             Driver.switchTo().frame(0);   // switching to frame

             Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_butCancel_input\"]")).click();

             Driver.switchTo().defaultContent();

             // Driver.switchTo().frame(1);

            // System.out.println(Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/thead/tr/td[2]")).getText());


         }

           @Test(priority = 6)
           public void editSharingFromview() throws IOException, InterruptedException {

            String profileName = property("ProfileName");

            accessReportProfile();

            ReportProfileHelpers.searchForReportProfile(profileName);

            Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[3]/a")).click();

            Thread.sleep(3000);

            Driver.switchTo().frame(0);

            Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[3]/input")).click(); // selecting Read only radio button on access rightt pop up
               Thread.sleep(3000);
               Driver.findElement(By.className("rbDecorated")).click(); //closing access right pop
               Driver.switchTo().defaultContent();
               Thread.sleep(3000);
               ReportProfileHelpers.searchForReportProfile(profileName);
               Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[3]/a")).getText() , "Yes");


           }

            @Test(priority = 7)

            public void deleteReportProfile() throws IOException, InterruptedException {

                String profileName = property("ProfileName");

                accessReportProfile();

                ReportProfileHelpers.searchForReportProfile(profileName);

                ReportProfileHelpers.deleteReportRpofile(profileName);

                ReportProfileHelpers.searchForReportProfile(profileName);

                try{
                    Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[4]/a")).getText();
                } catch (Exception e){

                    System.out.println("Delete failed");
                }


            }





}
