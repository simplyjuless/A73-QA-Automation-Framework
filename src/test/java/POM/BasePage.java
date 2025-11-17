package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitForElement(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator, int timeoutSeconds) {
        waitForElement(locator, timeoutSeconds).click();
    }

    protected boolean isDisplayed(By locator, int timeoutSeconds) {
        try {
            return waitForElement(locator, timeoutSeconds).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected String getText(By locator, int timeoutSeconds) {
        return waitForElement(locator, timeoutSeconds).getText();
    }
}
