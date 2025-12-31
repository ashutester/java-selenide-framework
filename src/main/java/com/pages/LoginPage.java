package com.pages;

import com.base.BaseClass;
import com.codeborne.selenide.SelenideElement;
import com.dataprovider.ConfigUtility;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class LoginPage extends BaseClass {

    private SelenideElement txtUsername = $(By.id("user-name"));
    private SelenideElement txtPassword = $(By.id("password"));
    private SelenideElement btnLogin = $(By.id("login-button"));
    private SelenideElement validationError = $(By.xpath("//h3[@data-test='error']"));
    private String userNameError = "Epic sadface: Username is required";
    private String passwordError = "Epic sadface: Password is required";
    private SelenideElement xOutBtn = $(By.xpath("//button[@class='error-button']"));

    public ProductsPage loginToApp(String userName, String password){
        txtUsername.setValue(ConfigUtility.getUserDetails("username"));
        txtPassword.setValue(ConfigUtility.getUserDetails("password"));
        btnLogin.click();
        return new ProductsPage();
    }

    public void checkURL(){
        webdriver().shouldHave(urlContaining("https://www.saucedemo.com"));
    }
    public void checkUserNamePasswordElements(){
        txtUsername.should(be(visible));
        txtPassword.should(be(visible));
        btnLogin.should(be(enabled));
    }
    public void errorWithoutUserName(){
        btnLogin.click();
        validationError.shouldHave(text(userNameError));
        xOutBtn.click();

    }
    public void errorWithoutPassword(){
        txtUsername.setValue(ConfigUtility.getUserDetails("username"));
        btnLogin.click();
        $("//divsdsd").click();//This has been added to deliberately fail test case to show in report.
        validationError.shouldHave(text(passwordError));
        xOutBtn.click();
    }
}
