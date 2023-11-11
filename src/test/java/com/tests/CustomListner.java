package com.tests;

import com.utils.Utility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListner implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        //ITestListener.super.onTestFailure(result);
        System.out.println("The name of the testcase failed is :"+result.getName());
        Utility.takeScreenShot();
    }


    @Override
    public void onStart(ITestContext context) {
       // ITestListener.super.onStart(context);
        System.out.println("Test is started :"+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        //ITestListener.super.onFinish(context);
        System.out.println("Test is finished :"+context.getName());
    }
}
