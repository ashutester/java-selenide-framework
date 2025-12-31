package com.testcases;

import com.codeborne.selenide.Selenide;
import com.dataprovider.ConfigUtility;
import com.dataprovider.ExcelUtility;
import com.pages.HamburgerMenuComp;
import com.pages.LoginPage;
import com.pages.ProductsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTests{

    @BeforeClass
    static void setup(){
       ConfigUtility.setupEnvironment();
    }
    @Test(description = "This test will check valid user login")
    public void successfulLogin(){
        LoginPage login = open("/", LoginPage.class);
        ProductsPage product = login.loginToApp(ConfigUtility.getUserDetails("username"),ConfigUtility.getUserDetails("password"));
        product.confirmProductListTitle();
        HamburgerMenuComp bMenu = new HamburgerMenuComp();
        bMenu.checkHamburgerMenuElements();
    }

    @Test
    public void loginWithoutUserNameAndPassword(){
        LoginPage login = open("/", LoginPage.class);
        login.checkURL();
        login.errorWithoutUserName();
        login.errorWithoutPassword();
    }
    @Test
    public void checkUIElements(){
        LoginPage login = open("/", LoginPage.class);
        login.checkUserNamePasswordElements();

    }
    @DataProvider(name = "logindata")
    public Object [][] getLoginData() {
        Object[][] arr = ExcelUtility.getData("Credentials");
        System.out.println("Excel was read successfully");
        return arr;
    }
}
