package com.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class CheckoutStepTwoPage {
    private SelenideElement paymentInfoDetails = $(By.xpath("//div[normalize-space()='SauceCard #31337']"));
    private SelenideElement shippingInfoDetails = $(By.xpath("//div[normalize-space()='Free Pony Express Delivery!']"));
    private SelenideElement cancelBtn = $(By.xpath("//button[@id='cancel']"));
    private SelenideElement finishBtn = $(By.xpath("//button[@id='finish']"));
    public void checkURL(){
        webdriver().shouldHave(urlContaining("https://www.saucedemo.com/checkout-step-two.html"));
    }

}
