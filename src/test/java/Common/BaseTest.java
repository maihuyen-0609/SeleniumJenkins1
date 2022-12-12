package Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
   public static WebDriver driver;
    @BeforeMethod
    public static void createDriver(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
     //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      //  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    @AfterMethod
    public static void closeDriver(){
        if(driver!=null){
        driver.quit();}
    }


    }





