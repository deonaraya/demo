package com.chandra.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by chandrad on 2/4/17.
 */
public class AddToCartPopUpPage {

    WebDriver driver ;
    WebDriverWait wait ;

    public AddToCartPopUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(className = "icon-ok")
    private WebElement cartSuccessMessage ;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement checkoutStep1Button ;

    @FindBy(id = "layer_cart_product_title")
    private static WebElement addedprocutName ;

    public void waitforElement(WebElement element){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitUntilPageLoads() {
        waitforElement(cartSuccessMessage);
    }

}
