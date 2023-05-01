package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ComputerPage extends Utility {
    public By computerLink=By.linkText("Computers");
    By dropDownLink=By.id("products-orderby");
    By listLink=By.xpath("//h2[@class='product-title']");
    By addToCartButton=By.xpath("(//button[normalize-space()='Add to cart'])[1]");
    By processorLink=By.id("product_attribute_1");
    By RAMLink=By.id("product_attribute_2");
    By hddRadio=By.id("product_attribute_3_7");
    By osLink=By.id("product_attribute_4_9");
    By checkboxLink=By.id("product_attribute_5_12");
    By priceLink=By.id("price-value-1");
    By successMessageLink=By.xpath("//p[@class='content']");
    By closeLink=By.xpath("//span[@title='Close']");
    public By shoppingCartLink=By.xpath("//span[@class='cart-label']");
    By goToCartLink=By.xpath("(//button[normalize-space()='Go to cart'])[1]");
    public void mouseHover(By link){
        mouseHoverToElement(link);
    }
    public void selectFromDropDown(String value){
        selectByVisibleTextFromDropDown(dropDownLink,value);
    }
    public List getList(){
        List<WebElement> list=driver.findElements(listLink);
        List<String> orignalList= new ArrayList<>();
        for(WebElement e:list){
            orignalList.add(e.getText());
        }
        return orignalList;
    }
    public void addToCart(){
        clickOnElement(addToCartButton);
    }
    public void selectProcessor(String value){
        selectByValueFromDropDown(processorLink,value);
    }
    public void selectRAM(String value){
        selectByVisibleTextFromDropDown(RAMLink,value);
    }
    public void selectHddRadio(){
        clickOnElement(hddRadio);
    }
    public void selectOs(){
        clickOnElement(osLink);
    }
    public void selectCheckBox(){
        clickOnElement(checkboxLink);
    }
    public String getPrice(){
       return getTextFromElement(priceLink);
    }
    public String getSuccessMessage(){
        return getTextFromElement(successMessageLink);
    }
    public void closeMessage(){
        clickOnElement(closeLink);
    }
    public void clickOnGoToCart(){
        clickOnElement(goToCartLink);
    }
}