package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderManager {
    @DataProvider(name="data_provider_login")
    public Object[][] datakatalonlogin(){
        return new Object[][]{{"born.to.shine0609@gmail.com"},{"Maihuyen69@"}};
    }

}
