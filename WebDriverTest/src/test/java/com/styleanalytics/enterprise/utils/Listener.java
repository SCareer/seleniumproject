package com.styleanalytics.enterprise.utils;

import com.styleanalytics.enterprise.EnterpriseBaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends EnterpriseBaseClass implements ITestListener {



    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        System.out.println("***** Error "+iTestResult.getName()+" test has failed *****");
        String methodName=iTestResult.getName().trim();
        TakeScreenShot.takeScreenShot(methodName,Driver);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
