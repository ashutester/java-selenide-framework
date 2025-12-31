package com.listeners;
import com.aventstack.chaintest.plugins.ChainTestListener;
import com.codeborne.selenide.Screenshots;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestNGListeners implements ITestListener{
    public void onTestSuccess(ITestResult result){
        ChainTestListener.log("LOG:INFO -Test Passed "+result.getMethod().getMethodName());

    }
    public void onTestFailure(ITestResult result){
        ChainTestListener.log("LOG:INFO -Test Failed "+result.getMethod().getMethodName());
        ChainTestListener.log("LOG:INFO -Exceptions "+result.getThrowable().getMessage());
        ChainTestListener.embed(Screenshots.takeScreenShotAsFile(),"image/png");
    }
    public void onTestSkipped(ITestResult result){
        ChainTestListener.log("LOG:INFO -Test Failed "+result.getMethod().getMethodName());
        ChainTestListener.log("LOG:INFO -Exceptions "+result.getThrowable().getMessage());
    }
}
