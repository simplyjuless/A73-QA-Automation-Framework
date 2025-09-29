package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class LoginStepDefinitions {

    WebDriver driver;

    WebDriverWait wait;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Given("I open Koel login page")
    public void iOpenKoelLoginPage() {
        driver.get("https://qa.koel.app/");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[type='email']"))).sendKeys(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[type='password']"))).sendKeys(password);

    }

    @And("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[type='submit']"))).click();

    }

    @Then("I login into Koel home page")
    public void iLoginIntoKoelHomePage() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("img.avatar"))).isDisplayed());
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}

    
    