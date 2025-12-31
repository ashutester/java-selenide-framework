package com.pages;
import com.base.BaseClass;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class ProductsPage extends BaseClass {

    private SelenideElement lblHeader = $(By.xpath("//div[@class='app_logo' and text()='Swag Labs']"));
    private SelenideElement productListTitle = $(By.xpath("//span[@class='title' and text()='Products']"));
    private ElementsCollection productPriceList = $$(By.xpath("//div[@class='inventory_item_price']"));
    private SelenideElement productSortDrpdwn = $(By.xpath("//select[@class='product_sort_container']"));
    private ElementsCollection productNameList = $$(By.xpath("//div[@class='inventory_item_name ']"));
    private SelenideElement firstProdItmAddBttn = $(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
    private SelenideElement firstProdItmRmvBttn = $(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
    private SelenideElement shppngCrtCntnr = $(By.xpath("//div[@id='shopping_cart_container']"));
    private SelenideElement itemsInCartCntr = $(By.xpath("//span[@class='shopping_cart_badge']"));
    private SelenideElement sauceBackPack = $(By.xpath("//div[normalize-space(.)='Sauce Labs Backpack']"));
    public void checkTitle(){
        Assert.assertEquals(title(), "Swag Labs");
    }
    public void checkURL(){
        String url = "https://www.saucedemo.com/inventory";
        webdriver().shouldHave(urlContaining("https://www.saucedemo.com/inventory"));
    }
    public String getProductName(){
        return sauceBackPack.getText();
    }
    public void sortByPriceHiLow(){
        $(productSortDrpdwn).selectOptionContainingText("Price (high to low)");
        SelenideElement firstProdItem = productPriceList.get(0);
        float priceFirst = Float.parseFloat(firstProdItem.getText().substring(1));
        for (int i = 1; i< productPriceList.size(); i++){
            SelenideElement nextItem = productPriceList.get(i);
            float priceNext = Float.parseFloat(nextItem.getText().substring(1));
            Assert.assertTrue(priceFirst>priceNext);
        }
    }

    public void sortByPriceLowHi(){
        $(productSortDrpdwn).selectOptionContainingText("Price (low to high)");
        SelenideElement firstProdItem = productPriceList.get(0);
        float priceFirst = Float.parseFloat(firstProdItem.getText().substring(1));
        for (int i = 1; i< productPriceList.size(); i++){
            SelenideElement nextItem = productPriceList.get(i);
            float priceNext = Float.parseFloat(nextItem.getText().substring(1));
            Assert.assertTrue(priceFirst<priceNext);
        }
    }
    public void sortByNameAToZ(){
        $(productSortDrpdwn).selectOptionContainingText("Name (A to Z)");
        SelenideElement firstProdItem = productNameList.get(0);
         String prodNameFirst = firstProdItem.getText();
        for (int i = 1; i< productNameList.size(); i++){
            SelenideElement nextItem = productNameList.get(i);
            String prodNameNext = nextItem.getText();
            int result = prodNameFirst.compareTo(prodNameNext);
            Assert.assertTrue(result <=0);
        }
    }
    public void sortByNameZToA(){
        $(productSortDrpdwn).selectOptionContainingText("Name (Z to A)");
        SelenideElement firstProdItem = productNameList.get(0);
        String prodNameFirst = firstProdItem.getText();
        for (int i = 1; i< productNameList.size(); i++){
            SelenideElement nextItem = productNameList.get(i);
            String prodNameNext = nextItem.getText();
            int result = prodNameFirst.compareTo(prodNameNext);
            Assert.assertTrue(result >0);
        }
    }

    public void addAndRemoveToCart() {
        if (firstProdItmRmvBttn.isDisplayed()) {
            firstProdItmRmvBttn.click();
        }
        firstProdItmAddBttn.click();
        firstProdItmRmvBttn.shouldBe(visible);
        itemsInCartCntr.shouldHave(exactText("1"));
        firstProdItmRmvBttn.click();
        firstProdItmAddBttn.shouldBe(visible);
        itemsInCartCntr.shouldNot(be(visible));
    }

    public CheckoutPage prodAddedOnCheckOut(){
        if (firstProdItmRmvBttn.isDisplayed()) {
            firstProdItmRmvBttn.click();
        }
        firstProdItmAddBttn.click();
        shppngCrtCntnr.click();
        return new CheckoutPage();
    }

    public void confirmHeader(){
        lblHeader.should(exist,visible);
    }

    public void confirmProductListTitle(){
        productListTitle.should(exist,visible);
    }

}
