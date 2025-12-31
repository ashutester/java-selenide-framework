package com.pages;

import com.base.BaseClass;
import com.codeborne.selenide.SelenideElement;
import com.dataprovider.ConfigUtility;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class CheckoutStepOnePage extends BaseClass {
    private SelenideElement stepOneTitle = $(By.xpath("//span[@class='title' and text()='Checkout: Your Information']"));
    private SelenideElement firstNameTxt = $(By.xpath("//input[@id='first-name']"));
    private SelenideElement lastNameTxt = $(By.xpath("//input[@id='last-name']"));
    private SelenideElement zipCodeTxt = $(By.xpath("//input[@id='postal-code']"));
    private SelenideElement continueBtn = $(By.xpath("//input[@id='continue']"));
    private SelenideElement cancelBtn = $(By.xpath("//button[@id='cancel']"));
    private SelenideElement fstNmErr = $(By.xpath("//h3[normalize-space()='Error: First Name is required']"));
    private SelenideElement errXOut = $(By.xpath("//button[@class='error-button']//*[name()='svg']"));
    public void checkURL(){
        webdriver().shouldHave(urlContaining("https://www.saucedemo.com/checkout-step-one.html"));
    }
    public void confirmCheckoutListTitle(){
        stepOneTitle.should(exist,visible);
    }

    public CheckoutPage redirectBackToCheckoutPage(){
        cancelBtn.click();
        return new CheckoutPage();
    }
    public CheckoutStepTwoPage stepOneToStepTwo(){
        firstNameTxt.setValue(ConfigUtility.getUserDetails("firstName"));
        lastNameTxt.setValue(ConfigUtility.getUserDetails("lastName"));
        zipCodeTxt.setValue(ConfigUtility.getUserDetails("zipCode"));
        continueBtn.click();
        return new CheckoutStepTwoPage();
    }

    public void checkError(){
        continueBtn.click();
        fstNmErr.should(be(visible));
    }
}
