package com.Adidas.utilities;

import org.apache.velocity.runtime.directive.contrib.For;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowserUtil {

    public static void sleep(int seconds){

        try{
            Thread.sleep(seconds*1000);
        } catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }
    }

    public static void waitUntilVisibility(List<WebElement> elements, String string){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        for (WebElement each: elements){
            if (each.getText().equalsIgnoreCase(string)){
                wait.until(ExpectedConditions.visibilityOf(each));
            }

            if (each.getText().contains(string)){
                wait.until(ExpectedConditions.visibilityOf(each));
            }
        }
    }



    public static void waitUntilVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }





}
