package com.chandra.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by chandrad on 2/11/17.
 */
public class SummaryPage extends BasePage {

//    WebDriver driver ;
//    WebDriverWait wait;

    public SummaryPage(WebDriver driver) {
        super(driver);
      //  this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "cart_summary")
    private WebElement cartSummary ;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
    private WebElement checkoutStep2 ;

//    public SummaryPage waitforElement(WebElement element){
//        wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(element));
//         return this ;
//    }

    public SummaryPage waitUntilPageLoads(){
         waitforElement(cartSummary);
        return this ;
    }



}
