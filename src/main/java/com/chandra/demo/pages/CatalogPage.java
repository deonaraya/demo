package com.chandra.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by chandrad on 2/4/17.
 */

public class CatalogPage {

    WebDriver driver ;
    WebDriverWait wait ;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id ="home-page-tabs")
    private WebElement catalogTabs ;

    @FindBy(className = "blockbestsellers")
    private WebElement bestSellerCatalog ;

    @FindBy(className = "homefeatured")
    private WebElement popularCatalog ;

    //concept of list of weblements ...
    @FindBy(xpath="//ul[@id='homefeatured']/li//div[@class='right-block']//a[@class='product-name']")
    private List<WebElement> productNames ;

    //concept of list of weblements ...
    @FindBy(xpath="//ul[@id='homefeatured']/li//div[@class='right-block']//span[@itemprop='price']")
    private List<WebElement> productPrices ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[1]/div")
    private WebElement productContainer1 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[2]/div")
    private WebElement productContainer2 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]/div")
    private WebElement productContainer3 ;

    //concept of index
    @FindBy(xpath = "//ul[@id='homefeatured']/li[1]//div[@class='right-block']//a[@class='product-name']")
    private static WebElement productName1 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[2]//div[@class='right-block']//a[@class='product-name']")
    private WebElement productName2 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]//div[@class='right-block']//a[@class='product-name']")
    private WebElement productName3 ;

    //concept of custom attributes
    @FindBy(xpath = "//ul[@id='homefeatured']/li[1]//div[@class='right-block']//span[@itemprop='price']")
    private WebElement productPrice1 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[2]//div[@class='right-block']//span[@itemprop='price']")
    private WebElement productPrice2 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]//div[@class='right-block']//span[@itemprop='price']")
    private WebElement productPrice3 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[1]//div[@class='right-block']//a[@title='Add to cart']")
    private WebElement addToCartButton1 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[2]//div[@class='right-block']//a[@title='Add to cart']")
    private WebElement addToCartButton2 ;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[3]//div[@class='right-block']//a[@title='Add to cart']")
    private WebElement addToCartButton3 ;


    public void waitforElement(WebElement element){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitUntilPageLoads(){
        waitforElement(catalogTabs);
    }

    public void getProductNames(){
        for (WebElement name: productNames
             ) {
            System.out.println("Product names are listed in order as " + name.getText());
        }

    }

    public void addItemToCart(){

        Actions action = new Actions(driver);
        action.moveToElement(productContainer3).build().perform();
        waitforElement(addToCartButton3);
        addToCartButton3.click();


    }




}
