package com.styleanalytics.enterprise.Sharing;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SharingHelpers extends EnterpriseBaseClass {


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

    public void logInasOther(String Uname, String Pword){

        Driver.findElement(By.id("UserLogin_UserName")).sendKeys(Uname);
        Driver.findElement(By.id("UserLogin_Password")).sendKeys(Pword);
        Driver.findElement(By.id("UserLogin_LoginButton")).click();

    }




    public static void deleteFactor(String date) throws InterruptedException{

        Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(date);
        Thread.sleep(3000);

        List<WebElement> deleteButton = Driver.findElements(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div/div[6]/a"));

        System.out.print(deleteButton.size());

        if(deleteButton.size()!=0) {

            for (int i = 0; i < deleteButton.size(); i++) {

                //Driver.findElement(By.cssSelector(".sgButtonRed")).click();
                deleteButton.get(i).click();
                Thread.sleep(3000);
                String dynamicID = Driver.findElement(By.xpath("//iframe[contains(@name,'confirm')]")).getAttribute("name");  //
                Thread.sleep(5000);
                Driver.findElement(By.xpath("//*[@id='"+dynamicID+"_content']/div/div[2]/a/span/span")).click();
                Thread.sleep(3000);
                Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).clear();
                Driver.findElement(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(date);//searching for Factor Set
                deleteButton = Driver.findElements(By.xpath("//*[@id=\"divFactorSets\"]/div[4]/div[3]/div/div/div[6]/a"));
                Thread.sleep(3000);


            }

        }else
            System.out.print("No FactorSets to Delete");

    }

}
