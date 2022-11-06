package com.Adidas.pages;

import com.Adidas.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a")
    public List<WebElement> allLinks;

    @FindBy (xpath = "//button[@type = 'button']")
    public List<WebElement> allButtons;


    /**
     * click one WebElement from a list of WebElements
     * @param webElements
     * @param string
     */
    public  void click(List<WebElement> webElements, String string){
        for (WebElement each: webElements){
            if (each.getText().equalsIgnoreCase(string)){
                each.click();
                break;
            }
        }
    }
}
