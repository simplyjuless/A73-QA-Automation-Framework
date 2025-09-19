import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    public String url = "https://qa.koel.app/";
    public static WebDriver driver = null;

    @Test
    public void loginValidEmailPassword() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("juliamunoz@testpro.io").providePassword("Ltdan25!").clickSubmit();

        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    @Test
    public void loginEmptyEmailPassword()throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("").providePassword("Ltdan25!").clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
