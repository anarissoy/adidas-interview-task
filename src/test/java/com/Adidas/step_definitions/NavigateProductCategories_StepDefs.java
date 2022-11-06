package com.Adidas.step_definitions;

import com.Adidas.pages.CartPage;
import com.Adidas.pages.HomePage;
import com.Adidas.pages.ProductDetailPage;
import com.Adidas.utilities.BrowserUtil;
import com.Adidas.utilities.ConfigurationReader;
import com.Adidas.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NavigateProductCategories_StepDefs {

    HomePage homePage = new HomePage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    CartPage cartPage = new CartPage();
    Faker faker = new Faker();

    @Given("Navigate to {string} → {string} and click on {string}. Accept pop up confirmation.")
    public void navigate_to_and_click_on_accept_pop_up_confirmation(String category, String item, String button){

        homePage.clickCategory(homePage.allCategories, category);

        BrowserUtil.sleep(1);
        homePage.click(homePage.allLinks,item);

        BrowserUtil.sleep(1);
        productDetailPage.click(homePage.allLinks, button);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();


        BrowserUtil.sleep(1);
        homePage.homeBtn.click();
        BrowserUtil.sleep(1);

    }

    @When("Navigate to {string} → Delete {string} from cart.")
    public void navigate_to_delete_from_cart(String module, String nameOfProduct) {
        homePage.click(homePage.allLinks,module);
        cartPage.deleteProduct(nameOfProduct);
    }

    @When("Click on {string}.")
    public void click_on(String button) throws InterruptedException {
        BrowserUtil.sleep(1);
        cartPage.click(cartPage.allButtons, button);
    }

    @When("Fill in all web form fields.")
    public void fill_in_all_web_form_fields() {
        cartPage.inputName.sendKeys(faker.name().name());
        cartPage.inputCountry.sendKeys(faker.address().country());
        cartPage.inputCity.sendKeys(faker.address().cityName());
        cartPage.inputCreditCard.sendKeys(faker.business().creditCardNumber());
        cartPage.inputMonth.sendKeys(faker.number().numberBetween(1,12) + "");
        cartPage.inputYear.sendKeys(faker.number().numberBetween(1900,2022) + "");

    }

    @When("Capture and log purchase Id and Amount.")
    public String capture_and_log_purchase_id_and_amount() {

        String[] information = cartPage.purchaseInfo.getText().split("\n");
        String actualAmount = cartPage.returnNumberFromString(information[1]);

        return actualAmount;
    }

    @When("Assert purchase amount equals expected.")
    public void assert_purchase_amount_equals_expected() {
        String expectedAmount = "790";
        Assert.assertEquals(expectedAmount,capture_and_log_purchase_id_and_amount());
    }


}
