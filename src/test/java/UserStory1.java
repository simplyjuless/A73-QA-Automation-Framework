import POM.BasePage;
import POM.HomePage;
import POM.LoginPage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserStory1 extends BaseTest {

    @Test
    public void userCannotLoginWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("juliamunoz@testpro.io", "Ltdan25!");

        String message = loginPage.getErrorMessage();
        Assert.assertEquals(message, "Email is incorrect");
    }

    @Test
    public void userCannotLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("julia.munoz@testpro.io", "Ltdan");

        String message = loginPage.getErrorMessage();
        Assert.assertEquals(getErrorMessage(), "Password is incorrect");
    }

    @Test
    public void userCannotLoginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(" ", " ");

        String Message = loginPage.getErrorMessage();
        Assert.assertTrue(Message.contains("required") || Message.contains("empty"),
                "Should show message about required fields");
    }

    @Test
    public void userCanLoginWithUpdatedEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("julia.munoz@testpro.io", "Ltdan25!");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(HomePage.isDisplayed(), "User should be on Homepage after login");
    }

    @Test
    public void userCanLoginWithUpdatedPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("julia.munoz@testpro.io", "Ltdan25!");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isDisplayed(), "User should be able to log in with updated password");
    }

    @Test
    public void lastVisitedPageIsRetainedAfterReLogin() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //simulate navigating to Favorites
        loginPage.login("email", "password");
        homePage.navigateTo("Favorites");
        homePage.logout();

        loginPage.login("email", "password");
        WebElement favoritesPage = null;
        Assert.assertTrue(favoritesPage.isDisplayed(), "User should return to last visited page");
    }
}
