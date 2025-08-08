import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    public String url = "https://qa.koel.app/";

    @Test
    public void loginEmptyEmailPassword() {}

    @Test
    public void loginInvalidEmailPassword() throws InterruptedException {

        navigateToPage(url);
        provideEmail("julia.munoz@testpro.io");
        providePassword("Ltdan25!");
        Thread.sleep(2000);
        clickOnLoginBtn();

        Thread.sleep(2000);


        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    private void clickOnLoginBtn() {
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

    private void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    private void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

}
