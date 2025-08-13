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

    @Test
    public void loginEmptyEmailPassword() throws InterruptedException{

        navigateToPage(url);
        provideEmail("julia.munoz@testpro.io");
        providePassword("Ltdan25!");
        clickOnLoginBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://qa.koel.app/"));

        Assert.assertTrue(driver.getCurrentUrl().contains("https://qa.koel.app/"), "URL after login is incorrect");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //String url = "https://testpro.io/";
        //driver.get(url);
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
        }

        private void clickOnLoginBtn () {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            loginButton.click();
        }

        private void providePassword (String password){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
            passwordField.clear();
            passwordField.sendKeys(password);

        }

        private void provideEmail (String email){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
            emailField.clear();
            emailField.sendKeys(email);
        }

        public void navigateToPage (String url){
            driver.get(url);
        }
    }