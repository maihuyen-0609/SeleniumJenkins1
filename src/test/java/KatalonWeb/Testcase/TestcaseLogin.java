package KatalonWeb.Testcase;

import Common.BaseTest;
import KatalonWeb.Pages.Login.PageLogin;
import dataprovider.DataProviderManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestcaseLogin  extends BaseTest {
    public PageLogin pageLogin;
@BeforeMethod
public void Login(){

    pageLogin=new PageLogin(driver);
}

    @Test
    public void LoginSuccess(){

    pageLogin.Login("born.to.shine0609@gmail.com","Maihuyen69@");
    }
    @Test(priority = 0,dataProvider = "data_provider_login", dataProviderClass = DataProviderManager.class)
    public void LoginSuccessfromDataProvider(String username, String password){
    pageLogin.Login(username,password);
    }
    @Test
    public void ReadKatalonterm(){
    pageLogin.ReadKatalonTerm();
    }
    @Test
    public void ForgotPassword(){
    pageLogin.ForgotPassword("born.to.shine0609@gmail.com");
    }
}
