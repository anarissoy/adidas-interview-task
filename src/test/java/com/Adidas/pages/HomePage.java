package com.Adidas.pages;

import com.Adidas.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div[@class='list-group']/a")
    public List<WebElement> allCategories;

    @FindBy(id = "nava")
    public WebElement homeBtn;


    public void clickCategory(List<WebElement> listOfElements, String str) {
        for (WebElement each : listOfElements) {
            if (each.getText().contains(str)) {
                each.click();
                break;
            }
        }
    }
}



