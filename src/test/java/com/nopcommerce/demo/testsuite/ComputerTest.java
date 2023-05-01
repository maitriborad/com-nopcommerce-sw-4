package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.BillingPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.TopMenu;
import com.nopcommerce.demo.pages.ShoppingCartPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ComputerTest extends BaseTest {
    TopMenu topMenu=new TopMenu();
    ComputerPage computerPage=new ComputerPage();
    ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
    BillingPage billingPage=new BillingPage();
    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        computerPage.mouseHover(computerPage.computerLink);
        topMenu.selectMenu("Desktops");
        Thread.sleep(1000);
        List<String>expectedList=computerPage.getList();
        expectedList.sort(Comparator.reverseOrder());
        computerPage.selectFromDropDown("Name: Z to A");
        Thread.sleep(1000);
        List<String>actualList=computerPage.getList();
        Assert.assertEquals(expectedList,actualList,"Products not displayed Z to A order");
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        computerPage.mouseHover(computerPage.computerLink);
        topMenu.selectMenu("Desktops");
        computerPage.selectFromDropDown("Name: A to Z");
        Thread.sleep(1000);
        computerPage.addToCart();
        Thread.sleep(1000);
        Assert.assertEquals("Build your own computer",topMenu.getHeadingText(),"Not right product");
        computerPage.selectProcessor("1");
        computerPage.selectRAM("8GB [+$60.00]");
        computerPage.selectHddRadio();
        computerPage.selectOs();
        computerPage.selectCheckBox();
        Thread.sleep(2000);
        Assert.assertEquals(computerPage.getPrice(),"$1,475.00","Options not selected correctly");
        computerPage.addToCart();
        Thread.sleep(1000);
        Assert.assertEquals(computerPage.getSuccessMessage(),"The product has been added to your shopping cart","Product is not added successfully");
        computerPage.closeMessage();
        computerPage.mouseHover(computerPage.shoppingCartLink);
        computerPage.clickOnGoToCart();
        Assert.assertEquals(topMenu.getHeadingText(),"Shopping cart","Shopping cart not displayed successfully");
        shoppingCartPage.changeQuantity("2");
        shoppingCartPage.updateCart();
        Thread.sleep(2000);
        Assert.assertEquals(shoppingCartPage.getPrice(),"$2,950.00","Cart not updated");
        shoppingCartPage.termsAndCondition();
        shoppingCartPage.goCheckout();
        Thread.sleep(1000);
        Assert.assertEquals(topMenu.getHeadingText(),"Welcome, Please Sign In!","Checkout navigation not succeed");
        shoppingCartPage.clickCheckoutAsGuest();
        billingPage.enterFirstname("Maitri");
        billingPage.enterLastname("Borad");
        billingPage.enterEmail("Boradm@gmail.com");
        billingPage.selectCountry("United Kingdom");
        billingPage.enterCity("London");
        billingPage.enterAddress("23, London road");
        billingPage.enterPostcode("UB123N");
        billingPage.enterPhoneNumber("7896541230");
        billingPage.clickContinue();
        billingPage.selectShipping();
        Thread.sleep(1000);
        billingPage.clickOnContinue();
        billingPage.clickCreditCard();
        Thread.sleep(1000);
        billingPage.clickPaymentContinue();
        billingPage.selectPaymentMethod();
        billingPage.selectCard(1);
        billingPage.enterCardHolderName("Prime Testing");
        billingPage.enterCardNumber("5105105105105100");
        billingPage.selectExpiryMonth(1);
        billingPage.selectExpiryYear(2);
        billingPage.enterCVV("769");
        billingPage.clickOnPaymentContinue();
        Assert.assertEquals(billingPage.getPaymentText(),"Payment Method: Credit Card","Payment method not right");
        Assert.assertEquals(billingPage.getShippingText(),"Shipping Method: Next Day Air","Shipping method not correct");
        Assert.assertEquals(billingPage.getPriceText(),"$2,950.00","Price not correct");
        billingPage.clickConfirm();
        Thread.sleep(1000);
        Assert.assertEquals(billingPage.getHeadText(),"Thank you","Not confirmed");
        Assert.assertEquals(billingPage.getSuccessText(),"Your order has been successfully processed!","Order Not done Successfully");
        billingPage.clickOnContinueButton();
        Assert.assertEquals(topMenu.getHeadingText(),"Welcome to our store","Message not displayed");
    }
}
