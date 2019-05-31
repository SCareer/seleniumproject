package com.styleanalytics.enterprise.Loader;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import com.styleanalytics.enterprise.Utility;
import com.styleanalytics.setup.TestBase;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BulkLoad extends TestBase {

    @Test(priority = 1)
    public void renameFiles(){

        List<String> results = new ArrayList<String>();


        File[] files = new File("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Daily Analysis Test Data").listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null.

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());

                System.out.println(file.getName());

                String date = Utility.todaysDate("ddMMYYYY mm ss");

                String beforeTruncateFName = file.getName();

                String afterTruncateFName = beforeTruncateFName.substring(0,32);

                //String nfname = trimFileExtension(file.getName());

                File oldfile =new File("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Daily Analysis Test Data\\"+file.getName());

                File newfile =new File("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Daily Analysis Test Data\\"+afterTruncateFName+" "+date+".xlsx");


                oldfile.renameTo(newfile);

                System.out.println(newfile);

               }
        }




    }

    private String trimFileExtension(String fileName)
    {
        String[] splits = fileName.split( "\\." );
        return StringUtils.remove( fileName, "." + splits[splits.length - 1] );
    }

    @Test(priority = 2)
    public void getFilesAndLoad() throws IOException, InterruptedException {
        LogoutTest();
        logInAsDiffUser("DailyUserTestAnalyzer","Test12345!");

        List<String> results = new ArrayList<String>();


        File[] files = new File("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Daily Analysis Test Data").listFiles();
         //If this pathname does not denote a directory, then listFiles() returns null.

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());

                System.out.println(file.getName());

                LoadPage loadPage = new LoadPage(getDriver());


                loadPage.loadPortfolio("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Daily Analysis Test Data\\"+file.getName());
                //loadTest.loadMultiplePortfolio("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Daily Analysis Test Data\\",files);
            }
        }


    }
        //This is still in progress
    public void getMultipleFilesAndLoad() throws IOException, InterruptedException {

        List<String> results = new ArrayList<String>();


        File[] files = new File("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Daily Analysis Test Data").listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null.

        LoadTest loadTest = new LoadTest();



        // loadTest.loadPortfolio("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Daily Analysis Test Data\\"+file.getName());
        loadTest.loadMultiplePortfolio("C:\\Users\\viswanath.STYLEDOMAIN\\Desktop\\Regression Test data\\Daily Analysis Test Data\\",files);

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
                System.out.println(file.getName());


            }
        }


    }
}
