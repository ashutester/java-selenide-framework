package com.pages;

import com.base.BaseClass;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class CheckoutPage extends BaseClass {
    private SelenideElement checkoutListTitle = $(By.xpath("//span[@class='title' and text()='Your Cart']"));
    private SelenideElement continueShpngBtn = $(By.xpath("//button[@id='continue-shopping']"));
    private SelenideElement checkOutBtn = $(By.xpath("//button[@id='checkout']"));
    private SelenideElement rmvItemBtn = $(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
    private SelenideElement sauceBackPack = $(By.xpath("//div[normalize-space(.)='Sauce Labs Backpack']"));

    public void checkTitle(){
        Assert.assertEquals(title(), "Swag Labs");
    }
    public void checkURL(){
        webdriver().shouldHave(urlContaining("https://www.saucedemo.com/cart.html"));
    }
    public String getProductName(){
        return sauceBackPack.getText();
    }
    public void confirmCheckoutListTitle(){
        checkoutListTitle.should(exist,visible);
    }
    public ProductsPage redirectBackToProductPage(){
        continueShpngBtn.click();
        return new ProductsPage();
    }
    public CheckoutStepOnePage checkoutToStepOneFromCart(){
        checkOutBtn.click();
        return new CheckoutStepOnePage();
    }

}

