package com.testcases;

import com.dataprovider.ConfigUtility;
import com.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class checkoutUserDetailsTests {
    @BeforeClass
    static void setup(){
        ConfigUtility.setupEnvironment();
    }
    @Test
    public void checkoutRedirectBackToCheckoutPage(){
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        CheckoutPage chkPage  = product.prodAddedOnCheckOut();
        CheckoutStepOnePage stepOne = chkPage.checkoutToStepOneFromCart();
        chkPage = stepOne.redirectBackToCheckoutPage();
        chkPage.checkURL();
        chkPage.checkTitle();
    }

    @Test
    public void moveFromStepOneToStepTwo(){
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        CheckoutPage chkPage  = product.prodAddedOnCheckOut();
        CheckoutStepOnePage stepOne = chkPage.checkoutToStepOneFromCart();
        CheckoutStepTwoPage step2 = stepOne.stepOneToStepTwo();
        step2.checkURL();
    }

    @Test
    public void checkErrorOnStepTwoWithout(){
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        CheckoutPage chkPage  = product.prodAddedOnCheckOut();
        CheckoutStepOnePage stepOne = chkPage.checkoutToStepOneFromCart();
        stepOne.checkError();
    }

}
