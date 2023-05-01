package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenu extends Utility {
    By headingText=By.xpath("//h1");
    public void selectMenu(String menu){
        List<WebElement> list=driver.findElements(By.xpath("//ul[@class='top-menu notmobile']//a"));
        for(WebElement e:list){
            if(e.getText().equalsIgnoreCase(menu)){
                e.click();
                break;
            }
        }
    }
    public String getHeadingText(){
        return getTextFromElement(headingText);
    }
}
