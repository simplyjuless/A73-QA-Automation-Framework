import POM.BaseTest;
import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    public String url = "https://qa.koel.app/";


    @Test
    public void loginValidEmailPassword() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("juliamunoz@testpro.io")
                .providePassword("Ltdan25!")
                .clickSubmit();

        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    @Test
    public void loginEmptyEmailPassword()throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("")
                .providePassword("Ltdan25!")
                .clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
