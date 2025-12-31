package com.dataprovider;

import com.codeborne.selenide.Configuration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {

    public static void setupEnvironment(){
        try{
           File src = new File("Configuration/config.properties");
           FileInputStream fis = new FileInputStream(src);
           Properties pro = new Properties();
           pro.load(fis);
           Configuration.baseUrl = pro.getProperty("baseUrl");
           Configuration.timeout = Long.parseLong(pro.getProperty("timeout"));
           Configuration.headless = Boolean.parseBoolean(pro.getProperty("headless"));
           Configuration.browserSize = pro.getProperty("browserSize");
           Configuration.browser = pro.getProperty("browser");

       } catch (FileNotFoundException e) {
           System.out.println("Property file not found."+e.getMessage());
       } catch (IOException e) {
           System.out.println("Failed to load/read config file."+e.getMessage());
       }
    }
    public static String getUserDetails(String property){
        String value = "";
        try{
            File src = new File("Configuration/config.properties");
            FileInputStream fis = new FileInputStream(src);
            Properties pro = new Properties();
            pro.load(fis);
            value = pro.getProperty(property);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return value;
    }
}
