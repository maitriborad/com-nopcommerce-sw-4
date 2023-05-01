package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ElectronicTest extends BaseTest {
    TopMenu topMenu=new TopMenu();
    ComputerPage computerPage=new ComputerPage();
    ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
    BillingPage billingPage=new BillingPage();
    ElectronicPage electronicPage=new ElectronicPage();
    RegisterPage registerPage=new RegisterPage();
    LoginPage loginPage=new LoginPage();
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        computerPage.mouseHover(electronicPage.electronicLink);
        topMenu.selectMenu("Cell phones");
        Thread.sleep(1000);
        Assert.assertEquals(topMenu.getHeadingText(),"Cell phones","Navigation is not successful");
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        computerPage.mouseHover(electronicPage.electronicLink);
        topMenu.selectMenu("Cell phones");
        Thread.sleep(1000);
        Assert.assertEquals(topMenu.getHeadingText(),"Cell phones","Navigation is not successful");
        electronicPage.selectListView();
        Thread.sleep(2000);
        electronicPage.selectPhone();
        Assert.assertEquals(electronicPage.getHeading(),"Nokia Lumia 1020","navigation not successful");
        Assert.assertEquals(electronicPage.getPrice(),"$349.00","Price is not correct");
        electronicPage.changeQuantity("2");
        Thread.sleep(1000);
        computerPage.addToCart();
        Thread.sleep(1000);
        Assert.assertEquals(computerPage.getSuccessMessage(),"The product has been added to your shopping cart","Product is not added successfully");
        computerPage.closeMessage();
        computerPage.mouseHover(computerPage.shoppingCartLink);
        computerPage.clickOnGoToCart();
        Assert.assertEquals(topMenu.getHeadingText(),"Shopping cart","Shopping cart not displayed successfully");
        Thread.sleep(2000);
        Assert.assertEquals(electronicPage.getQuantity(),"2","Quantity is not correct");
        Assert.assertEquals(shoppingCartPage.getPrice(),"$698.00","Price is not updated");
        shoppingCartPage.termsAndCondition();
        shoppingCartPage.goCheckout();
        Thread.sleep(1000);
        Assert.assertEquals(topMenu.getHeadingText(),"Welcome, Please Sign In!","Checkout navigation not succeed");
        shoppingCartPage.clickOnRegister();
        Assert.assertEquals(topMenu.getHeadingText(),"Register","Navigation not successful");
        registerPage.enterFirstname("Maitri");
        registerPage.enterLastname("Borad");
        String email= "random-" + UUID.randomUUID().toString() + "@example.com";
        registerPage.enterEmail(email);
        registerPage.enterPassword("Maitri@123");
        registerPage.enterConfirmPassword("Maitri@123");
        registerPage.clickOnRegister();
        Assert.assertEquals(registerPage.getRegisterMessage(),"Your registration completed","Registration is not done");
        registerPage.clickOnContinue();
        Assert.assertEquals(topMenu.getHeadingText(),"Shopping cart","Shopping cart not displayed successfully");
        registerPage.clickOnLoginLink();
        loginPage.enterEmailId(email);
        loginPage.enterPassword("Maitri@123");
        loginPage.clickOnLoginButton();
        shoppingCartPage.termsAndCondition();
        shoppingCartPage.goCheckout();
        billingPage.selectCountry("United Kingdom");
        billingPage.enterCity("London");
        billingPage.enterAddress("23, London road");
        billingPage.enterPostcode("UB123N");
        billingPage.enterPhoneNumber("7896541230");
        billingPage.clickContinue();
        billingPage.selectShipping2();
        Thread.sleep(1000);
        billingPage.clickOnContinue();
        billingPage.clickCreditCard();
        Thread.sleep(1000);
        billingPage.clickPaymentContinue();
        billingPage.selectPaymentMethod();
        billingPage.selectCard(0);
        billingPage.enterCardHolderName("Prime Testing");
        billingPage.enterCardNumber("5105105105105100");
        billingPage.selectExpiryMonth(1);
        billingPage.selectExpiryYear(2);
        billingPage.enterCVV("769");
        billingPage.clickOnPaymentContinue();
        Assert.assertEquals(billingPage.getPaymentText(),"Payment Method: Credit Card","Payment method not right");
        Assert.assertEquals(billingPage.getShippingText(),"Shipping Method: 2nd Day Air","Shipping method not correct");
        Assert.assertEquals(billingPage.getPriceText(),"$698.00","Price not correct");
        billingPage.clickConfirm();
        Thread.sleep(1000);
        Assert.assertEquals(billingPage.getHeadText(),"Thank you","Not confirmed");
        Assert.assertEquals(billingPage.getSuccessText(),"Your order has been successfully processed!","Order Not done Successfully");
        billingPage.clickOnContinueButton();
        Assert.assertEquals(topMenu.getHeadingText(),"Welcome to our store","Message not displayed");
        loginPage.clickOnLogout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/","Log out not successful");
    }
}
