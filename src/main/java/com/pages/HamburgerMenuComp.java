package com.pages;

import com.base.BaseClass;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import com.pages.ProductsPage;

import static com.codeborne.selenide.Selenide.$;

public class HamburgerMenuComp extends BaseClass {

    private static SelenideElement burgerMenu = $(By.xpath("//button[@id='react-burger-menu-btn']"));
    private SelenideElement allItemsSubMenu = $(By.xpath("//a[@id='inventory_sidebar_link']"));
    private SelenideElement abtSubMenu = $(By.xpath("//a[@id='about_sidebar_link']"));
    private SelenideElement logOutSubMenu = $(By.xpath("//a[@id='logout_sidebar_link']"));
    private static SelenideElement resetAppStateSubMenu = $(By.xpath("//a[@id='reset_sidebar_link']"));
    private static SelenideElement closeHamrgerSubMenu = $(By.xpath("//button[@id='react-burger-cross-btn']"));

    public ProductsPage redirectBackToProductPage(){
        burgerMenu.click();
        allItemsSubMenu.click();
        ProductsPage product = new ProductsPage();
        product.confirmProductListTitle();
        return new ProductsPage();
    }

    public LoginPage redirectBackToProductPageFrmLogin(){
        burgerMenu.click();
        logOutSubMenu.click();
        LoginPage login = new LoginPage();
        login.checkURL();
        login.checkUserNamePasswordElements();
        return new LoginPage();
    }
    public void checkHamburgerMenuElements(){
        burgerMenu.click();
        logOutSubMenu.shouldBe(Condition.visible);
        allItemsSubMenu.shouldBe(Condition.visible);
        resetAppStateSubMenu.shouldBe(Condition.visible);
        closeHamrgerSubMenu.click();
    }
    public static void resetAppState(){
        burgerMenu.click();
        resetAppStateSubMenu.shouldBe(Condition.visible);
        closeHamrgerSubMenu.click();
    }



}
