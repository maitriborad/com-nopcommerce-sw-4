package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ElectronicPage extends Utility {
    public By electronicLink=By.linkText("Electronics");
    By listViewLink=By.xpath("//a[@title='List']");
    By phoneLink=By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]");
    By headText=By.xpath("//h1");
    By priceText=By.id("price-value-20");
    By quantityLink=By.id("product_enteredQuantity_20");
    By getQuantity=By.xpath("(//input[@value])[2]");
    public void selectListView(){
        clickOnElement(listViewLink);
    }
    public void selectPhone(){
        clickOnElement(phoneLink);
    }
    public String getHeading(){
        return getTextFromElement(headText);
    }
    public String getPrice(){
        return getTextFromElement(priceText);
    }
    public void changeQuantity(String quantity){
        driver.findElement(quantityLink).sendKeys(Keys.BACK_SPACE);
        sendTextToElement(quantityLink,quantity);
    }
    public String getQuantity(){
        return driver.findElement(getQuantity).getAttribute("value");
    }
}
