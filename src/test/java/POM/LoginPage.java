package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final By emailField = By.xpath("//input[@type='email']");
    private final By passwordField = By.xpath("//input[@type='password']");
    private final By submitBtn = By.xpath("//button[@type='submit']");
    private final By welcomeHeader = By.xpath("//h1[contains(text(), 'student')]");

    public LoginPage(WebDriver driver) {
        super(driver); //navigates to BasePage
    }

    private WebElement waitForClickable(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Page Methods//Actions
    public Koel_Homepage login(String email, String password) {
        //wait for login form to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));

        //enter email
        WebElement emailInput = waitForClickable(emailField, 15);
        emailInput.clear();
        emailInput.sendKeys(email);

        //enter password
        WebElement passwordInput = waitForClickable(passwordField, 15);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        //click login
        WebElement btn = waitForClickable(submitBtn, 15);
        btn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeHeader));

        //return POM.Koel_Homepage object
        return new Koel_Homepage(driver);
    }

}