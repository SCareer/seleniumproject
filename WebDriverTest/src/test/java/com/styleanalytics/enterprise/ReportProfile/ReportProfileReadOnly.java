package com.styleanalytics.enterprise.ReportProfile;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.GoTo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ReportProfileReadOnly extends EnterpriseBaseClass {





    @Test(priority = 1)
    public void createReadOnlyReportProfile() throws IOException, InterruptedException {

        String ReadOnlyProfileName = property("ReadOnlyProfileName");

        GoTo goTo = new GoTo();

        goTo.goToReportProfiles();

        ReportProfileHelpers.createReadOnlyProfile(ReadOnlyProfileName);

        Thread.sleep(4000);

        ReportProfileHelpers.searchForReportProfile(ReadOnlyProfileName);

        Thread.sleep(4000);

        String name = Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[1]")).getText();
        Assert.assertEquals(name, ReadOnlyProfileName);

    }

    @Test(priority = 3)
        public void isSharedText() throws IOException, InterruptedException {

        String ReadOnlyProfileName = property("ReadOnlyProfileName");

        ReportProfileHelpers.searchForReportProfile(ReadOnlyProfileName);

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[3]/a")).getText(), "Yes");

    }


      @Test(priority = 4)

       public void columnsCheck() throws IOException, InterruptedException {

          String ReadOnlyProfileName = property("ReadOnlyProfileName");

          ReportProfileHelpers.searchForReportProfile(ReadOnlyProfileName);

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[4]/a")).getText() , "EDIT");

        Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[5]/a")).getText() , "DELETE");

    }


    @Test(priority = 5)
    public void editReadOnlyProfileView() throws InterruptedException, IOException {

        String ReadOnlyProfileName = property("ReadOnlyProfileName");

        ReportProfileHelpers.searchForReportProfile(ReadOnlyProfileName);

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

    @Test(priority = 6)
    public void readOnlyProfileByOtherUser() throws IOException, InterruptedException {

        String ReadOnlyProfileName = property("ReadOnlyProfileName");

        ReportProfileHelpers.logOutUser();

        ReportProfileHelpers.logInasOther("antony.gilbert@styleresearch.com", "Test1234%");

        GoTo goTo = new GoTo();

        goTo.goToReportProfiles();

        ReportProfileHelpers.searchForReportProfile(ReadOnlyProfileName);

        List<WebElement> FactorSets = Driver.findElements(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div")); // verifing not sharedFactor factor set

        Assert.assertEquals(FactorSets.size(), 1);
    }



        @Test(priority = 7)
        public void editReadOnlyProfileFromView() throws IOException, InterruptedException {

            String ReadOnlyProfileName = property("ReadOnlyProfileName");

            ReportProfileHelpers.logOutUser();

            ReportProfileHelpers.logInasOther("praveen.mamidi@styleresearch.com" ,"Test1234%" );

            GoTo goTo = new GoTo();
            goTo.goToReportProfiles();

            Thread.sleep(4000);

            ReportProfileHelpers.searchForReportProfile(ReadOnlyProfileName);


            Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[3]/a")).click();

            Thread.sleep(3000);

            Driver.switchTo().frame(0);

            Driver.findElement(By.xpath("//*[@id=\"tableRoles\"]/tbody/tr[1]/td[4]/input")).click(); // selecting Read only radio button on access rightt pop up
            Thread.sleep(3000);
            Driver.findElement(By.className("rbDecorated")).click(); //closing access right pop
            Driver.switchTo().defaultContent();
            Thread.sleep(3000);
            ReportProfileHelpers.searchForReportProfile(ReadOnlyProfileName);
            Assert.assertEquals(Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[3]/a")).getText() , "Yes");


        }


          @Test(priority = 8)
          public void deleteReadOnlyProfile() throws IOException, InterruptedException {
          String ReadOnlyProfileName = property("ReadOnlyProfileName");


              GoTo goTo = new GoTo();
              goTo.goToReportProfiles();

              ReportProfileHelpers.searchForReportProfile(ReadOnlyProfileName);

              ReportProfileHelpers.deleteReportRpofile(ReadOnlyProfileName);

              ReportProfileHelpers.searchForReportProfile(ReadOnlyProfileName);

              try{
                  Driver.findElement(By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div/div[4]/a")).getText();
              } catch (Exception e){

                  System.out.println("Delete failed");
              }


          }






    }






