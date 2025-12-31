package com.testcases;

import com.dataprovider.ConfigUtility;
import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CheckoutTests {

    @BeforeClass
    static void setup(){
        ConfigUtility.setupEnvironment();

    }
    @Test
    public void checkoutRedirectBackToProductPage() throws InterruptedException {
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        CheckoutPage chkPage = product.prodAddedOnCheckOut();
        product = chkPage.redirectBackToProductPage();
        product.checkTitle();
        product.confirmHeader();
    }
    @Test
    public void checkedProductMatches(){
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        String productPageName = product.getProductName();
        CheckoutPage chkPage  = product.prodAddedOnCheckOut();
        String chkPageProductName = chkPage.getProductName();
        Assert.assertEquals(productPageName,chkPageProductName);

    }
    @Test
    public void moveToStepOne() throws InterruptedException {
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        CheckoutPage chkPage  = product.prodAddedOnCheckOut();
        CheckoutStepOnePage stepOne = chkPage.checkoutToStepOneFromCart();
        stepOne.checkURL();
    }


}
