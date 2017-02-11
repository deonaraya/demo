package com.chandra.demo.tests;

import com.chandra.demo.pages.CatalogPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
       // System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        driver = new FirefoxDriver();
      //  driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

    }

    @Test
    public void testPlaceOrder(){

//        CatalogPage catalogPageObject = new CatalogPage(driver);
//
//        catalogPageObject.waitUntilPageLoads();
//        catalogPageObject.getProductNames();
//        catalogPageObject.addItemToCart(); // return new AddToCartPopUpPage(driver);
//
//        AddToCartPopUpPage page2 = new AddToCartPopUpPage(driver);
//        page2.waitUntilPageLoads();
//        page2.assertSuccessMessage();
//        page2.navToSumary();
//
//        SummaryPage page3 = new SummaryPage(driver);
//        page3.waitUntilPageLoads();

        CatalogPage page = new CatalogPage(driver);
        page.waitUntilPageLoads().getProductNames().addItemToCart().
                waitUntilPageLoads().assertSuccessMessage().
                navToSumary().waitUntilPageLoads();

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
