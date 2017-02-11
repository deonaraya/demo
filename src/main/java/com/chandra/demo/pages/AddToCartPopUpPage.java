package com.chandra.demo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by chandrad on 2/4/17.
 */
public class AddToCartPopUpPage extends BasePage {

//    WebDriver driver ;
//    WebDriverWait wait ;

    public AddToCartPopUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//i[@class='icon-ok']/parent::h2")
    private WebElement cartSuccessMessage ;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement checkoutStep1Button ;

    @FindBy(id = "layer_cart_product_title")
    private static WebElement addedprocutName ;

//    public AddToCartPopUpPage waitforElement(WebElement element){
//        wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(element));
//
//        return this ;
//    }

    public AddToCartPopUpPage waitUntilPageLoads() {
        waitforElement(cartSuccessMessage);
        return  this;
    }

    public AddToCartPopUpPage assertSuccessMessage(){
        Assert.assertEquals("Product successfully added to your shopping cart", cartSuccessMessage.getText());
        return this;
    }

    public SummaryPage navToSumary(){
        checkoutStep1Button.click();
        return new SummaryPage(driver);
    }

}
