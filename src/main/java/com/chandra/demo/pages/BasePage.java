package com.chandra.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by chandrad on 2/11/17.
 */
public class BasePage {

    WebDriver driver;
    WebDriverWait wait ;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitforElement(WebElement element){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
