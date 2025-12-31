package com.testcases;

import com.codeborne.selenide.Selenide;
import com.dataprovider.ConfigUtility;

import com.pages.CheckoutPage;
import com.pages.CheckoutStepOnePage;
import com.pages.LoginPage;
import com.pages.ProductsPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ProductPageTests {

    @BeforeClass
    static void setup(){
        ConfigUtility.setupEnvironment();
    }
    @Test
    public void checkProductPageListSortByPriceHiLow(){
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        product.sortByPriceHiLow();

    }
    @Test
    public void checkProductPageListSortByPriceLowHi(){
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        product.sortByPriceLowHi();
    }
    @Test
    public void checkProductPageListSortByNameAToZ(){
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        product.sortByNameAToZ();
    }

    @Test
    public void checkProductPageListSortByNameZToA(){
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        product.sortByNameZToA();;
    }
    @Test
    public void checkProductAddedToCart() throws InterruptedException {
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        product.addAndRemoveToCart();
    }
   @Test
    public void checkProductAddedOnCheckOut() throws InterruptedException {
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"), ConfigUtility.getUserDetails("password"));
        CheckoutPage chkPage = product.prodAddedOnCheckOut();
        chkPage.checkTitle();
        chkPage.checkURL();
    }



}
