package Katalon.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class WebUI {
    private  static int TIMEOUT = 10;
    //luôn đợi 10s
    private final static double STEP_TIME = 0.5;
    private final static int PAGE_LOAD_TIMEOUT=20;
    private static WebDriver driver;

    public WebUI(WebDriver driver) {
        WebUI.driver = driver;
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }
    public static WebElement getElement(By by){
        return driver.findElement(by);
    }
    public static List<WebElement> getElements(By by){
        return driver.findElements(by);
    }
    public static void verifyEquals(Object actual, Object expected){
        Assert.assertEquals(actual,expected,"Fail, not match"+ actual.toString()+"not equal"+expected.toString());
        logConsole("Verify equal:" + actual +" and " + expected);
    }
    public static void verifyEquals(Object actual, Object expected, String message){
        Assert.assertEquals(actual,expected,message);
        logConsole("Verify equal:" + actual +" and " + expected);
    }
    public static Boolean checkElementExist(By by) {
        sleep(2);
        List<WebElement> listElement = getElements(by);

        if (listElement.size() > 0) {
            System.out.println("checkElementExist: " + true + " --- " + by);
            return true;
        } else {
            System.out.println("checkElementExist: " + false + " --- " + by);
            return false;
        }
    }

    public static void openURL(String url) {
        driver.get(url);
        logConsole("Open:" + url);
    }

    public static String getURL(String url1) {
        driver.getCurrentUrl();
        logConsole("Get:" + url1);
        return driver.getCurrentUrl();
    }

    public static void clickElement(By by) {
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
       // wait.until(ExpectedConditions.presenceOfElementLocated(by));
        sleep(STEP_TIME) ;
        getElement(by).click();
        logConsole("Click:" + by);
    }

    //đợi theo timeout tự set
    public static void clickElement(By by, long timeout) {
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        getElement(by).click();
        logConsole("Click:" + by);
    }

    public static void setText(By by, String value) {
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        getElement(by).sendKeys(value);
        logConsole("Set text:" + value + " on element " + by);
    }

//    public static void waitForElementVisible(By by) {
//        try {
//         //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//        } catch (Throwable error) {
//            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
//            logConsole("Timeout waiting for the element Visible. " + by.toString());
//        }
//    }

//    public static void waitForElementPresent(By by) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
//            wait.until(ExpectedConditions.presenceOfElementLocated(by));
//        } catch (Throwable error) {
//            Assert.fail("Element not exist. " + by.toString());
//            logConsole("Element not exist. " + by.toString());
//        }
//    }
//    public static void waitForElementClickable(By by) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
//            wait.until(ExpectedConditions.elementToBeClickable(getElement(by)));
//        } catch (Throwable error) {
//            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
//            logConsole("Timeout waiting for the element ready to click. " + by.toString());
//        }
//    }

    public static String getElementText(By by) {
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        logConsole("Get text:" + by);
        return driver.findElement(by).getText();
    }
}
