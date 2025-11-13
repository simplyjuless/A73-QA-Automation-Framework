package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    //Constructor
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver); //navigates to BasePage
    }

    //Locators
    By emailField = By.cssSelector("form#loginForm input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");
    By errorMsg = By.cssSelector(".error");

    //Page Methods
    public void provideEmail(String email) {
        WebElement emailInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submitBtn() {
        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(submitBtn));
        loginButton.click();
    }

    public HomePage login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        submitBtn();
        return new HomePage(driver);
    }

    public String getErrorMessage() {
        try {
            WebElement error = new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            return error.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }


    public boolean isLoginButtonDisplayed() {
        WebElement loginBtn = findElement(submitBtn);
        return !loginBtn.isEnabled();
    }

}