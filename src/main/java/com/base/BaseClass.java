package com.base;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.dataprovider.ConfigUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;
public class BaseClass {

    @BeforeSuite
    public void setup() throws IOException {
        System.out.println("LOG:INFO -Running Before each test");
        System.out.println("LOG:INFO-Browser is up and running");
    }
    @AfterSuite
    public void tearDown(){
        System.out.println("LOG:INFO -Running After Class");
        closeWebDriver();
        System.out.println("LOG:INFO-Session Closed");
    }
}
