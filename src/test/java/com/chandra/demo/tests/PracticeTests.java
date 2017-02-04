package com.chandra.demo.tests;

import com.chandra.demo.pages.AddToCartPopUpPage;
import com.chandra.demo.pages.CatalogPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by chandrad on 2/4/17.
 */
public class PracticeTests {

    WebDriver driver ;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

    }

    @Test
    public void testOne(){

        CatalogPage catalogPageObject = new CatalogPage(driver);

        catalogPageObject.waitUntilPageLoads();
        catalogPageObject.getProductNames();
        catalogPageObject.addItemToCart();

        AddToCartPopUpPage page2 = new AddToCartPopUpPage(driver);
        page2.waitUntilPageLoads();

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
