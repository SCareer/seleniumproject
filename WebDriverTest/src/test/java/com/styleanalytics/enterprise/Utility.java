package com.styleanalytics.enterprise;

import com.styleanalytics.pages.SearchPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Viswanath on 19/07/2017.
 */
public class Utility extends EnterpriseBaseClass {


    public static void waitForElementToDisplay(String element) {

        WebDriverWait wait = new WebDriverWait(Driver, 120);
        WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        nextButton.click();

    }

    public static void waitForElementToDisplayByClass(String className ) {

        WebDriverWait wait = new WebDriverWait(Driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));

    }


    public static void waitForElementToDisplayByXpath(String Xpath, int timeOutInSeconds) {

        WebDriverWait wait = new WebDriverWait(Driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));

    }

    public static void waitForElementToDisplayByclassName(String className, int timeOutInSeconds) {

        WebDriverWait wait = new WebDriverWait(Driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));

    }



    public static void waitForElementToDisplay(WebElement element, int timeOutInSeconds) {

        WebDriverWait wait = new WebDriverWait(Driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));


    }

    public static void waitForReportsToLoad(int waitTime) throws InterruptedException {

        for(int i=0;i<waitTime;i++) {

            String value = Driver.findElement(By.id("ctl00_mainContentPlaceHolder_report_hidFirstPageLoaded")).getAttribute("value");

            if(value.equalsIgnoreCase("")){

                value="0";
            }
            int val = Integer.valueOf(value);

            if (val != 1) {

                Thread.sleep(1000);
            } else {
                break;
            }
        }
    }




    public static void searchPortfolioInReportsPage(String portfolioName) throws InterruptedException, IOException {


        GoTo.goToReportsPage();

        WebElement pName =  Driver.findElement(By.xpath("//span[contains(@id,'ctl00_mainContentPlaceHolder_report_labPortfolioName')]"));

        String selectedPortfolio = pName.getText();

        if(!selectedPortfolio.equalsIgnoreCase(portfolioName)) {
            try {

                Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_panPortfolioName']")).click();
                Thread.sleep(3000);
                Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_Input']")).sendKeys(" " + portfolioName);
                Thread.sleep(8000);
                //Wait.waitForElementToDisappear(Driver,30,Driver.findElement(By.xpath("//*[@id=\"ctl00_mainContentPlaceHolder_report_PortfolioQuickSearch_radComboBoxPortfolioQuickSearch_LoadingDiv\"]/text()")));
                Driver.findElement(By.xpath("//*[@id='quickSearchItem']/span[2]")).click();
                Utility.waitForReportsToLoad(60);

            }catch (Exception e){

                Assert.fail("Portfolio Search Failed", e);
            }

        }


    }

    public static void downloadReportFromReportsPage(String templateName) throws InterruptedException, IOException {


        GoTo.goToReportsPage();

        Thread.sleep(3000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_Image1']")).click();
        Thread.sleep(3000);
        Driver.findElement(By.xpath("//a[contains(@class,'menuOption paneDownload')]")).click();
        Thread.sleep(3000);
        Driver.switchTo().frame(0);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtFilter']")).sendKeys(templateName);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdFilter_input']")).click();
        Thread.sleep(2000);
        Driver.findElement(By.xpath("//a[@title='"+templateName+"']")).click();


        Driver.switchTo().defaultContent();
        Driver.findElement(By.cssSelector(".rwCloseButton")).click();

    }

    public void downloadMultipleReportFromReportsPage(String[] templateName) throws InterruptedException, IOException {
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_Image1']")).click();

        Thread.sleep(3000);

        WebElement downloadLink =Driver.findElement(By.xpath("//a[contains(@class,'menuOption paneDownload')]"));

        if(downloadLink.isDisplayed()) {

            Driver.findElement(By.xpath("//a[contains(@class,'menuOption paneDownload')]")).click();
        }else {

            Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_report_Image1']")).click();
            Thread.sleep(3000);
            Driver.findElement(By.xpath("//a[contains(@class,'menuOption paneDownload')]")).click();
        }
        Driver.switchTo().frame(0);

        for(int i=0;i<templateName.length;i++) {

            Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtFilter']")).clear();
            Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtFilter']")).sendKeys(templateName[i]);
            Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdFilter_input']")).click();
            Thread.sleep(5000);
            Driver.findElement(By.xpath("//a[@title='"+templateName+"']")).click();

        }

        Driver.switchTo().defaultContent();
        Driver.findElement(By.cssSelector(".rwCloseButton")).click();

    }

    public void downloadReportsFromNotificationIcon(String fName) throws InterruptedException {

        Thread.sleep(3000);

        Driver.findElement(By.xpath("//*[@id=\"iconDownloads\"]")).click();

        WebElement completedCount = Driver.findElement(By.xpath("//*[@id=\"counterCompleted\"]"));

        int count = Integer.parseInt(completedCount.getText());

        System.out.println("Number of Completed Exports:"+count);

        for(int i=1;i<=count;i++){

            WebElement reportName = Driver.findElement(By.xpath("//*[@id=\"topNavDownloadsList\"]/div[4]/div[3]/div/div["+i+"]/div[1]/a"));

            System.out.println(reportName.getText());

            Boolean findReport = reportName.getText().equalsIgnoreCase(fName);

            if(findReport){

                Driver.findElement(By.xpath("//*[@id=\"topNavDownloadsList\"]/div[4]/div[3]/div/div["+i+"]/div[1]/a")).click();

                Thread.sleep(3000);
                break;


            }


        }

    }

    public void downloadReportsFromNotificationIcon1() throws InterruptedException {

        String fName="PDF Comparison Test-MSCI EUROPE-EUR-20160531-Sample Style Template.pdf";
        //PDF Comparison Test-MSCI EUROPE-EUR-20160531-Sample Style Template.pdf

        Driver.findElement(By.xpath("//*[@id=\"iconDownloads\"]")).click();

        WebElement completedCount = Driver.findElement(By.xpath("//*[@id=\"counterCompleted\"]"));

        int count = Integer.parseInt(completedCount.getText());

        System.out.println("Number of Completed Exports:"+count);

        for(int i=1;i<=count;i++){

            WebElement reportName = Driver.findElement(By.xpath("//*[@id=\"topNavDownloadsList\"]/div[4]/div[3]/div/div["+i+"]/div[1]/a"));

            System.out.println(reportName.getText());

            Boolean findReport = reportName.getText().equalsIgnoreCase(fName);

            if(findReport){

                Driver.findElement(By.xpath("//*[@id=\"topNavDownloadsList\"]/div[4]/div[3]/div/div["+i+"]/div[1]/a")).click();

                Thread.sleep(3000);
                break;


            }


        }

    }

    public static void portfolioSearchInExplorer(String portfolioName) throws InterruptedException{


        Thread.sleep(5000);
        WebElement dropDownLabel = Driver.findElement(By.xpath("/*//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar2']/div/div/div/ul/li[4]/a/span/span/span/span[1]/span"));
        if(dropDownLabel.getText()!="Everything")
        {
            WebElement dropDownArrow = Driver.findElement(By.xpath("/*//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar2']/div/div/div/ul/li[4]/a/span/span/span/span[2]"));
            dropDownArrow.click();
            Thread.sleep(5000);
            //dropDownArrow.sendKeys("Everything");
            Driver.findElement(By.xpath("html/body/div[3]/form/div[1]/div/ul/li[1]/a")).click();
            Thread.sleep(5000);
        }
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar2_i4_explorerQuickSearch_radComboBoxPortfolioQuickSearch_Input']")).click();

        Thread.sleep(2000);
        //Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar2_i4_explorerQuickSearch_radComboBoxPortfolioQuickSearch_Input']")).sendKeys("Test Automation - Analysis Task Test");
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar2_i4_explorerQuickSearch_radComboBoxPortfolioQuickSearch_Input']")).sendKeys(portfolioName);
        Thread.sleep(5000);
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar2_i4_explorerQuickSearch_radComboBoxPortfolioQuickSearch_DropDown']/div[2]/ul/li[5]")).click();


    }

    public static void portfolioQuickSearchInExplorer(String portfolioName) throws InterruptedException, IOException {

        SearchPage sp = new SearchPage(Driver);

        sp.setSearchIcon();
        sp.setSearchTextBlock(portfolioName);
        sp.setFirstSearchResult();
        sp.setPortfolioExplorerLink();
    }

    public void searchAndSelectPortfoliosWithSimilarNameInExplorer(String portfolioName) throws InterruptedException{

        //Driver.get(URL+"/Portfolio/explore.aspx");
        Thread.sleep(5000);
        WebElement dropDownLabel = Driver.findElement(By.xpath("/*//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar2']/div/div/div/ul/li[4]/a/span/span/span/span[1]/span"));
        System.out.println(dropDownLabel.getText());
        if(dropDownLabel.getText()!="Everything")
        {
            WebElement dropDownArrow = Driver.findElement(By.xpath("/*//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar2']/div/div/div/ul/li[4]/a/span/span/span/span[2]"));
            dropDownArrow.click();
            Thread.sleep(5000);
            //dropDownArrow.sendKeys("Everything");
            Driver.findElement(By.xpath("html/body/div[3]/form/div[1]/div/ul/li[1]/a")).click();
            Thread.sleep(5000);
        }
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar2_i4_explorerQuickSearch_radComboBoxPortfolioQuickSearch_Input']")).click();

        Thread.sleep(2000);
        //Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar2_i4_explorerQuickSearch_radComboBoxPortfolioQuickSearch_Input']")).sendKeys("Test Automation - Analysis Task Test");
        Driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_explorerToolbar2_i4_explorerQuickSearch_radComboBoxPortfolioQuickSearch_Input']")).sendKeys(portfolioName);
        Thread.sleep(5000);
        try {
            Driver.findElement(By.xpath("//*[@id=\"quickSearchItem\"]/span[2]")).click();
        }catch (Exception e){

        System.out.println("No portfolios to Delete:"+e);
    }


    }

    public static void clickOnConfirmPopup() throws InterruptedException {



        String dynamicID = Driver.findElement(By.xpath("//iframe[contains(@name,'confirm')]")).getAttribute("name");

        //Utility.isElementPresentAndClick("//*[@id='"+dynamicID+"_content']/div/div[2]/a[1]/span/span",5);
        Driver.findElement(By.xpath("//*[@id='"+dynamicID+"_content']/div/div[2]/a[1]/span/span")).click();



    }

    public static String yesterdaysDate(String format){

        Date date = new Date(System.currentTimeMillis()-24*60*60*1000);
        DateFormat dateFormat=new SimpleDateFormat(format);
        return dateFormat.format(date);

    }

    public static String todaysDate(String format){

        Date date = new Date();
        DateFormat dateFormat=new SimpleDateFormat(format);
        return dateFormat.format(date);

    }

    public static void waitForPageToBeReady()
    {
        JavascriptExecutor js = (JavascriptExecutor)Driver;

        //This loop will rotate for 100 times to check If page Is ready after every 1 second.
        //You can replace your if you wants to Increase or decrease wait time.
        for (int i=0; i<120; i++)
        {
            try
            {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            //To check page ready state.

            if (js.executeScript("return document.readyState").toString().equals("complete"))
            {
                break;
            }
        }
    }



    public void deleteTemplate(String date) throws InterruptedException{


        Driver.findElement(By.xpath("//*[@id='divExistingTemplates']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(date);
        Thread.sleep(3000);

        List<WebElement> deleteButton = Driver.findElements(By.cssSelector(".sgButtonRed"));

        System.out.print(deleteButton.size());

        if(deleteButton.size()!=0) {

            for (int i = 0; i < deleteButton.size(); i++) {

                Driver.findElement(By.cssSelector(".sgButtonRed")).click();
                Thread.sleep(3000);

                for (String winHandle : Driver.getWindowHandles()) {
                    Driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
                }
                Driver.findElement(By.cssSelector(".rwInnerSpan")).click();
                Thread.sleep(3000);
                Driver.switchTo().defaultContent();

                Driver.findElement(By.xpath("//*[@id='divExistingTemplates']/div[4]/div[1]/div[2]/div[1]/input")).sendKeys(date);//dateFormat1.format(date)
                Thread.sleep(3000);
            }

        }else
            System.out.print("No Templates to Delete");

    }

    public static void moveToElement(String xpath){

        JavascriptExecutor jse = (JavascriptExecutor) Driver;
        WebElement element = Driver.findElement(By.xpath(xpath));
        jse.executeScript("arguments[0].scrollIntoView(true);", element);


    }

    public static void scrollDown(){

        JavascriptExecutor jse = (JavascriptExecutor)Driver;
        jse.executeScript("window.scrollBy(0,250)", "");

    }

    public static void scrollUp(){

        JavascriptExecutor jse = (JavascriptExecutor)Driver;
        jse.executeScript("window.scrollBy(0,-250)", "");

    }

    public static void moveToElement(WebElement xpath){

        JavascriptExecutor jse = (JavascriptExecutor) Driver;
        WebElement element = xpath;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void takeScreenshotOnError(String message,String errorFileName,Exception e) throws IOException {

        String errorLocation = property("ErrorLocation");

        System.out.println(message+":"+e);
        String fName = errorLocation+errorFileName+".jpg";
        File f = new File(fName);
        if(f.exists()){
            try {
                f.delete();
            }catch (Exception a){

                System.out.println("File Not Found to Delete:"+a);

            }
        }

        File scrFile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(fName));

        Assert.fail();



    }

    public static WebElement isElementPresent(String xpath, int time)

    {
        WebElement element = null;

        for(int i=0;i<time;i++)
        {
            try{

                element=Driver.findElement(By.xpath(xpath));
                //element.isDisplayed();
                break;
            }
            catch(Exception e)
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e1)
                {
                    System.out.println("Waiting for element to appear on DOM");
                }
            }


        }
        return element;

    }

    public static WebElement isElementPresentAndDisplayed(String xpath, int time)

    {
        WebElement element = null;

        for(int i=0;i<time;i++)
        {
            try{

                element=Driver.findElement(By.xpath(xpath));
                element.isDisplayed();
                break;
            }
            catch(Exception e)
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e1)
                {
                    System.out.println("Waiting for element to appear on DOM");
                }
            }


        }
        return element;

    }

    public static WebElement isElementPresentAndClick(String xpath, int time)

    {
        WebElement element = null;

        for(int i=0;i<time;i++)
        {
            try{

                element=Driver.findElement(By.xpath(xpath));
                element.click();
                break;
            }
            catch(Exception e)
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e1)
                {
                    System.out.println("Waiting for element to appear on DOM");
                }
            }


        }
        return element;

    }

    public static WebElement isElementPresentAndClickCSS(String css, int time)

    {
        WebElement element = null;

        for(int i=0;i<time;i++)
        {
            try{

                element=Driver.findElement(By.cssSelector(css));
                element.click();
                break;
            }
            catch(Exception e)
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e1)
                {
                    System.out.println("Waiting for element to appear on DOM");
                }
            }


        }
        return element;

    }


    public static WebElement isElementPresentAndClick(WebElement element, int time)

    {
       // WebElement ele = null;

        for(int i=0;i<time;i++)
        {
            try{

                element.isDisplayed();
                element.click();
                break;
            }
            catch(Exception e)
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e1)
                {
                    System.out.println("Waiting for element to appear on DOM");
                }
            }


        }
        return element;

    }

    public static WebElement isElementPresentAndDisplayed(WebElement element,String verifyText, int time)

    {
        for(int i=0;i<time;i++)
        {
            try{
                element.isDisplayed();
                element.getText().equalsIgnoreCase(verifyText);
                break;
            }
            catch(Exception e)
            {
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e1)
                {
                    System.out.println("Waiting for element to appear on DOM");
                }
            }

        }
        return element;

    }

    public static void loginAsDifferentUser(String username,String password) throws IOException, InterruptedException {


            LogoutTest();

            String user = property(username);
            String pass = property(password);

            logInAsDiffUser(user,pass);


    }



    public static void portfolioGlobalSearch(String portfolioName) throws InterruptedException {

        SearchPage sp = new SearchPage(Driver);
        sp.setSearchIcon();
        sp.setSearchTextBlock(portfolioName);
        sp.setFirstSearchResult();



    }


    public static void accessPeerInsight(String reportName) throws IOException, InterruptedException {

        GoTo.peerInsights();

        try {

            Driver.findElement(By.xpath("//*[@id=\"divExistingAnalyses\"]/div[4]/div[1]/div[2]/div[2]/input")).sendKeys(reportName);

            Driver.findElement(By.xpath("//*[@id=\"divExistingAnalyses\"]/div[4]/div[3]/div/div/div[10]/a")).click();

            Wait.untilJqueryIsDone(Driver,60);

        }catch (Exception e){

            System.out.println("Failed find report: "+e.getMessage());
        }



    }

    public static void isFilePresent(String filePath, int time)

    {
        for(int i=0;i<time;i++)
        {
            try{
                File file = new File(filePath);
                Boolean present = file.exists();
                if(present){
                break;
                }
                throw new Exception();
            }
            catch(Exception e)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    System.out.println("Waiting for File to be downloaded");
                }
            }

        }

    }





    // It will execute after every test execution
    public static void tearDown(ITestResult result) {

        // Here will compare if test is failing then only it will enter into if condition
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Create refernce of TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) Driver;

                // Call method to capture screenshot
                File source = ts.getScreenshotAs(OutputType.FILE);

                // Copy files to specific location here it will save all screenshot in our project home directory and
                // result.getName() will return name of test case so that screenshot name will be same
                FileUtils.copyFile(source, new File("C:\\Selenium\\ScreenshotsErrors\\" + result.getName() + ".png"));
                //FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));

            } catch (Exception e) {

                System.out.println("Exception while taking screenshot " + e.getMessage());
            }


        }

    }

}
