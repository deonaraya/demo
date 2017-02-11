package com.chandra.demo.tests;

import com.chandra.demo.pages.CatalogPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by chandrad on 2/4/17.
 */
public class PracticeTests {

    WebDriver driver ;
    ExtentReports extent ;
    ExtentTest test ;

//    @BeforeMethod
//    public void setUp(){
//       // System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
//      //  driver = new FirefoxDriver();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://automationpractice.com/index.php");
//
//    }

    @BeforeSuite
    public void beforeSuite(){
        extent = new ExtentReports("extent-report.html") ;
    }

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browser){
        if (browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else if (browser.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else {
            throw new IllegalArgumentException("Invalid browser value!!" + browser);
        }

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void testPlaceOrder(){

        test = extent.startTest("testPlaceOrder" , "generating reports for tests");

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
    public void tearDown(ITestResult result) throws IOException {

        if (result.getStatus()==ITestResult.FAILURE)
        {
            TakesScreenshot ts=(TakesScreenshot)driver;

            // Call method to capture screenshot
            File source=ts.getScreenshotAs(OutputType.FILE);

            // Copy files to specific location here it will save all screenshot in our project home directory and
            // result.getName() will return name of test case so that screenshot name will be same
            String screenshot = "./Screenshots/" + result.getMethod().getMethodName() + System.currentTimeMillis() +".png";
            FileUtils.copyFile(source, new File(screenshot));
            System.out.println("Screenshot taken");

            String img = test.addScreenCapture(screenshot);
            test.log(LogStatus.FAIL, "Image", "Image example: " + img);
        }
        extent.endTest(test);
        extent.flush();
        driver.close();
    }

//    public  void takeScreenshot(ITestResult result) throws IOException {
//
//        TakesScreenshot ts=(TakesScreenshot)driver;
//
//        // Call method to capture screenshot
//        File source=ts.getScreenshotAs(OutputType.FILE);
//
//        // Copy files to specific location here it will save all screenshot in our project home directory and
//        // result.getName() will return name of test case so that screenshot name will be same
//        String screenshot = "./Screenshots/" + result.getMethod().getMethodName() + System.currentTimeMillis() +".png";
//        FileUtils.copyFile(source, new File(screenshot));
//        System.out.println("Screenshot taken");

//    }

    @AfterSuite
    public void afterSuite(){
        extent.close();
    }


}
