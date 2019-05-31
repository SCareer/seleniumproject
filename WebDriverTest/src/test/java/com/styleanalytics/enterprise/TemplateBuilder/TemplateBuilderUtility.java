package com.styleanalytics.enterprise.TemplateBuilder;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Viswanath on 20/07/2017.
 */
public class TemplateBuilderUtility extends EnterpriseBaseClass {


    public void createTemplate(String tName)throws InterruptedException{


        //Driver.findElement(By.xpath("//*[@id='ctl00_topNav2_navSiteMap1_rptMenu_ctl03_rptSubMenu_ctl03_hlMenu']")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdShowNew_input']")).click();
        Thread.sleep(2000);
        Driver.findElement(By.xpath("//*[@id='divNewOptions']/a[2]")).click();
        Thread.sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY");
        //get current date time with Date()
        Date date = new Date();
        Driver.findElement(By.xpath("//*[@id='templateName']")).sendKeys(dateFormat.format(date)+" "+tName); //Need to Uncomment this *************
        Thread.sleep(2000);
        //Driver.switchTo().defaultContent();
        Thread.sleep(2000);
        Driver.findElement(By.xpath("//*[contains(text(),'Style Skyline')]")).click();
        Thread.sleep(2000);
        Driver.findElement(By.xpath("//*[contains(text(),'Style Skyline Range')]")).click();
        Thread.sleep(2000);
        //Driver.findElement(By.xpath("//*[@id='pageListIcons']/div[2]")).click();
        Thread.sleep(2000);
        //Driver.findElement(By.xpath("//*[@id='aspnetForm']/div[6]/div[1]/div/div/div[3]/div/div[4]/div[1]/div/div[4]/div[2]")).click();
        Thread.sleep(2000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdSave_input']")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdClose_input']")).click();
        Thread.sleep(5000);

    }

    public void openNewTemplate(String tName)throws InterruptedException{

        //Driver.findElement(By.xpath("//*[@id='ctl00_topNav2_navSiteMap1_rptMenu_ctl03_rptSubMenu_ctl03_hlMenu']")).click();
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdShowNew_input']")).click();
        Thread.sleep(2000);
        Driver.findElement(By.xpath("//*[@id='divNewOptions']/a[2]")).click();
        Thread.sleep(2000);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY");
        //get current date time with Date()
        Date date = new Date();
        Driver.findElement(By.xpath("//*[@id='templateName']")).sendKeys(dateFormat.format(date)+" "+tName); //Need to Uncomment this *************
        Thread.sleep(2000);
        //Driver.switchTo().defaultContent();
        Thread.sleep(2000);
        Driver.findElement(By.xpath("//*[contains(text(),'Style Skyline')]")).click();
        Thread.sleep(2000);
        Driver.findElement(By.xpath("//*[contains(text(),'Style Skyline Range')]")).click();
        Thread.sleep(2000);


    }


    //To find the hidden text

    public void findAndVerifyContent(WebElement element, String label){

        String content = (String) ((JavascriptExecutor) Driver).executeScript("return arguments[0].innerHTML", element);
        System.out.println(content);

        Assert.assertEquals(content,label);

    }

    public void deleteTemplate(String templateName) throws InterruptedException, IOException {

        TemplateBuilderTest temp = new TemplateBuilderTest();

        temp.navigateToTemplateBuilder();

        Driver.findElement(By.xpath("//*[@id='divExistingTemplates']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(templateName);

        Driver.findElement(By.cssSelector(".sgButtonRed")).click();
        Thread.sleep(3000);

        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Driver.findElement(By.cssSelector(".rwInnerSpan")).click();
        Thread.sleep(3000);
        Driver.switchTo().defaultContent();
    }

    public void createCustomTemplate(String editTemplateName, String newTemplateName, String property, String key) throws InterruptedException, IOException {

        TemplateBuilderTest temp = new TemplateBuilderTest();

        temp.navigateToTemplateBuilder();

        Driver.findElement(By.xpath("//*[@id='divExistingTemplates']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(editTemplateName);

        Driver.findElement(By.cssSelector(".sgButtonGreen")).click();

        Driver.findElement(By.xpath("//*[contains(text(),'Formatting')] ")).click();

        Thread.sleep(7000);

        WebElement input = Driver.findElement(By.xpath(property));

        input.sendKeys(key);


        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdSaveAs_input']")).click();

        Driver.findElement(By.xpath("//*[contains(@value,'Sample Factsheet Template')]")).click();
        Driver.findElement(By.xpath("//*[contains(@value,'Sample Factsheet Template')]")).clear();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY");
        //get current date time with Date()
        Date date = new Date();
        Driver.findElement(By.xpath("//*[contains(@value,'Sample Factsheet Template')]")).sendKeys(dateFormat.format(date)+" "+newTemplateName); //Need to Uncomment this *************
        Thread.sleep(2000);

        Driver.findElement(By.xpath("//*[@class='rwInnerSpan']")).click();

        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdClose_input']")).click();


    }


    public void fileSizeComparisionForCustom(String fName1, String fName2){

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY");
        Date date=new Date();

        File file = new File(fName1);
        File file1 = new File(fName2);

        if(file.exists() && file1.exists()){

            double size = file.length();
            double size1 = file1.length();
            System.out.print(size/1024+"KB");
            System.out.print(size1/1024+"KB");
            System.out.print(dateFormat.format(date));
            Assert.assertTrue(size<size1);

            file.delete();
            file1.delete();

        }else{

            Assert.fail("File not Exist in the Downloads");

        }

    }

    public void fileSizeComparisionForDefault(String fName1, String fName2){

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY");
        Date date=new Date();

        File file = new File(fName1);
        File file1 = new File(fName2);

        if(file.exists() && file1.exists()){

            double size = file.length();
            double size1 = file1.length();
            System.out.print(size/1024+"KB");
            System.out.print(size1/1024+"KB");
            System.out.print(dateFormat.format(date));
            Assert.assertTrue(size==size1);

            file.delete();
            file1.delete();

        }else{

            Assert.fail("File not Exist in the Downloads");

        }

    }


}
