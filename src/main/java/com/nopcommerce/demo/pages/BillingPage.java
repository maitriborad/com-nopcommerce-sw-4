package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class BillingPage extends Utility {
    By firstNameLink=By.id("BillingNewAddress_FirstName");
    By lastNameLink=By.id("BillingNewAddress_LastName");
    By emailLink=By.id("BillingNewAddress_Email");
    By countryLink=By.xpath("//select[@id='BillingNewAddress_CountryId']");
    By cityLink=By.id("BillingNewAddress_City");
    By addressLink=By.id("BillingNewAddress_Address1");
    By postCodeLink=By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    By phoneNumberLink=By.id("BillingNewAddress_PhoneNumber");
    By continueLink=By.xpath("//button[@onclick='Billing.save()']");
    By shippingLink=By.id("shippingoption_1");
    By shippingLink2=By.id("shippingoption_2");
    By creditCardLink=By.id("paymentmethod_1");
    By paymentMethodLink=By.xpath("//button[@class='button-1 payment-method-next-step-button']");

    By cardLink=By.xpath("//select[@id='CreditCardType']");
    By cardHolderNameLink=By.id("CardholderName");
    By cardNumberLink=By.xpath("//input[@id='CardNumber']");
    By cardMonthLink=By.xpath("//select[@id='ExpireMonth']");
    By cardYearLink=By.xpath("//select[@id='ExpireYear']");
    By cardCVVLink=By.xpath("//input[@id='CardCode']");
    By creditCardTextLink=By.xpath("//li[@class='payment-method']");
    By shippingMethodText=By.xpath("//li[@class='shipping-method']");
    By totalText=By.xpath("//span[@class='value-summary']//strong[starts-with(text(),'$')]");
    By confirmButton=By.xpath("//button[normalize-space()='Confirm']");
    By headText=By.xpath("//div[@class='page-title']//h1[text()='Thank you']");
    By successText=By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
    By continueButton=By.xpath("//button[normalize-space()='Continue']");
    By nextStep=By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    By paymentNextStep=By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    By paymentInfoNextLink=By.xpath("//button[@class='button-1 payment-info-next-step-button']");

    public void enterFirstname(String name){
        sendTextToElement(firstNameLink,name);
    }
    public void enterLastname(String name){
        sendTextToElement(lastNameLink,name);
    }
    public void enterEmail(String email){
        sendTextToElement(emailLink,email);
    }
    public void selectCountry(String country){
        selectByVisibleTextFromDropDown(countryLink,country);
    }
    public void enterCity(String city){
        sendTextToElement(cityLink,city);
    }
    public void enterAddress(String address){
        sendTextToElement(addressLink,address);
    }
    public void enterPostcode(String postcode){
        sendTextToElement(postCodeLink,postcode);
    }
    public void enterPhoneNumber(String number){
        sendTextToElement(phoneNumberLink,number);
    }
    public void clickContinue(){
        clickOnElement(continueLink);
    }
    public void selectShipping(){
        clickOnElement(shippingLink);
    }
    public void clickCreditCard(){
        clickOnElement(creditCardLink);
    }
    public void selectPaymentMethod(){
        clickOnElement(paymentMethodLink);
    }
    public void selectCard(int index){
        selectByIndexFromDropDown(cardLink,index);
    }
    public void enterCardHolderName(String name){
        sendTextToElement(cardHolderNameLink,name);
    }
    public void enterCardNumber(String number){
        sendTextToElement(cardNumberLink,number);
    }
    public void selectExpiryMonth(int month){
        selectByIndexFromDropDown(cardMonthLink,month);
    }
    public void selectExpiryYear(int year){
        selectByIndexFromDropDown(cardYearLink,year);
    }
    public void enterCVV(String cvv){
        sendTextToElement(cardCVVLink,cvv);
    }
    public String getPaymentText(){
        return getTextFromElement(creditCardTextLink);
    }
    public String getShippingText(){
        return getTextFromElement(shippingMethodText);
    }
    public String getPriceText(){
        return getTextFromElement(totalText);
    }
    public void clickConfirm(){
        clickOnElement(confirmButton);
    }
    public String getHeadText(){
        return getTextFromElement(headText);
    }
    public String getSuccessText(){
        return getTextFromElement(successText);
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
    public void clickOnContinue(){
        clickOnElement(nextStep);
    }
    public void clickPaymentContinue(){
        clickOnElement(paymentNextStep);
    }
    public void clickOnPaymentContinue(){
        clickOnElement(paymentInfoNextLink);
    }
    public void selectShipping2(){
        clickOnElement(shippingLink2);
    }
}
