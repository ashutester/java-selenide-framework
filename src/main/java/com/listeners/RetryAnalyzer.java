package com.listeners;

import com.dataprovider.ConfigUtility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount= Integer.parseInt(ConfigUtility.getUserDetails("retryFailedTCAttempts"));
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount<maxRetryCount) {
            retryCount++;
            return true;
        }return false;
    }

}
