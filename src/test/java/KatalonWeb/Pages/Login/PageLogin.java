package KatalonWeb.Pages.Login;

import Katalon.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Set;

public class PageLogin {
    private WebDriver driver;
    public PageLogin(WebDriver driver){
        this.driver=driver;
        new WebUI(driver);
    }
    private By textPage=By.xpath("//h1[@class='hero_title']");
    private By buttonLogin=By.xpath("//div[@class='right_content']//a[@class='btn_login'][normalize-space()='Log in']");
    private By inputUsername= By.xpath("//input[@id='signin_email']");
    private By inputPassword=By.xpath("//input[@id='signin_password']");
    private By buttonSignin=By.xpath("//input[@value='Sign in']");
    private By textWelcome=By.xpath("//div[@title='Welcome to Organization born.to.shine0609']");
    private By linkKatalonTerm=By.xpath("//a[normalize-space()='Katalon Terms of Service and Privacy Policy']");
    private By textKatalonTerm= By.xpath("//h1[normalize-space()='Katalon Terms']");
    private By logoKatalonTestops=By.xpath("//img[@alt='Test Opts Logo']");
private By buttonForgotPassword=By.xpath("//a[normalize-space()='Forgot your password?']");
private By textResetPassword=By.xpath("//h2[@id='forgot-form-dialog-title']");
private By inputEmailReset=By.xpath("(//input[@name='email'])[2]");
private By checkboxnotrobot=By.xpath("//span[id='recaptcha-anchor']");
private By buttonResetPassword=By.xpath("//button[normalize-space()='Reset Password']");

    public void Login(String email, String password){
        WebUI.openURL("https://katalon.com/");
        WebUI.getURL("https://katalon.com/");
        WebUI.verifyEquals(WebUI.getURL("https://katalon.com/"),"https://katalon.com/");
        WebUI.clickElement(buttonLogin);
        WebUI.setText(inputUsername,email);
        WebUI.setText(inputPassword,password);
        WebUI.clickElement(buttonSignin);
      //  WebUI.waitForElementVisible(textWelcome);
        WebUI.getElementText(textWelcome);
        Assert.assertEquals(WebUI.getElementText(textWelcome),"Welcome to Organization born.to.shine0609","Login thành công");
    }
    public void ReadKatalonTerm(){
        WebUI.openURL("https://testops.katalon.io/login");
        WebUI.getURL("https://testops.katalon.io/login");
        WebUI.verifyEquals(WebUI.getURL("https://testops.katalon.io/login"), "https://testops.katalon.io/login");
        WebUI.clickElement(linkKatalonTerm);
        String Mainwindow=driver.getWindowHandle();
        System.out.println(Mainwindow);
        Set<String> windows=driver.getWindowHandles();
        ArrayList<String> tab=new ArrayList<>(driver.getWindowHandles());
        System.out.println(tab.get(0));
        System.out.println(tab.get(1));
        driver.switchTo().window(tab.get(1));
     //   WebUI.waitForElementVisible(textKatalonTerm);
        WebUI.getElementText(textKatalonTerm);
        Assert.assertEquals(WebUI.getElementText(textKatalonTerm),"Katalon Terms","Open Katalon Term success");
    }
    public void ForgotPassword(String emailreset){
        WebUI.openURL("https://katalon.com/");
        WebUI.clickElement(buttonLogin);
        Actions action = new Actions(driver);
        // Scroll down
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        WebUI.clickElement(buttonForgotPassword);
        Set<String> windows=driver.getWindowHandles();
        ArrayList<String> tab1=new ArrayList<>(driver.getWindowHandles());
        System.out.println(tab1.get(0));
        System.out.println(tab1.get(1));
        driver.switchTo().window(tab1.get(1));
        WebUI.getElementText(textResetPassword);
        WebUI.setText(inputEmailReset,emailreset);
        WebUI.sleep(10);
        driver.switchTo().frame(0);
        WebUI.clickElement(checkboxnotrobot);
        WebUI.clickElement(buttonResetPassword);

    }

}

