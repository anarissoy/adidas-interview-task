package com.Adidas.pages;

import com.Adidas.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage{

    public ProductDetailPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
