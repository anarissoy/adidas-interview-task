package com.Adidas.pages;

import com.Adidas.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    public void deleteProduct(String nameOfProduct){
        String locator = "//table//tbody[@id='tbodyid']//td[.= '" + nameOfProduct + "']/following-sibling::td[2]/a";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }

    @FindBy (xpath = "//button[.='Place Order']")
    public WebElement placeOrderBtn;

    @FindBy (id = "name")
    public WebElement inputName;

    @FindBy (id = "country")
    public WebElement inputCountry;

    @FindBy (id = "city")
    public WebElement inputCity;

    @FindBy (id = "card")
    public WebElement inputCreditCard;

    @FindBy (id = "month")
    public WebElement inputMonth;

    @FindBy (id = "year")
    public WebElement inputYear;

    @FindBy (xpath = "//p[@class='lead text-muted ']")
    public WebElement purchaseInfo;


    public String returnNumberFromString(String str){
        String number = "";
        for(int i = 0; i < str.length(); i++){
            if (Character.isDigit(str.charAt(i))){
                number += str.charAt(i);
            }
        }
        return number;
    }

}
