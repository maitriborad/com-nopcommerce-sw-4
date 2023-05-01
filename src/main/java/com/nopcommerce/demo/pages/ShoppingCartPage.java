package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ShoppingCartPage extends Utility {
    By quantityLink =By.xpath("//input[@class='qty-input']");
    By updateCartLink=By.id("updatecart");
    By priceLink=By.xpath("//span[@class='product-subtotal']");
    By termsAndConditionLink=By.id("termsofservice");
    By checkoutLink=By.id("checkout");
    By checkoutGuestLink=By.xpath("//button[normalize-space()='Checkout as Guest']");
    By registerLink=By.xpath("//a[starts-with(text(),'Reg')]");
    public void changeQuantity(String quantity){
        driver.findElement(quantityLink).sendKeys(Keys.BACK_SPACE);
        sendTextToElement(quantityLink,quantity);
    }
    public void updateCart(){
        clickOnElement(updateCartLink);
    }
    public String getPrice(){
        return getTextFromElement(priceLink);
    }
    public void termsAndCondition(){
        clickOnElement(termsAndConditionLink);
    }
    public void goCheckout(){
        clickOnElement(checkoutLink);
    }
    public void clickCheckoutAsGuest(){
        clickOnElement(checkoutGuestLink);
    }
    public void clickOnRegister(){
        clickOnElement(registerLink);
    }
}
