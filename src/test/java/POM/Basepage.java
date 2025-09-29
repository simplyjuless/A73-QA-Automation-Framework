package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Basepage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    //Basepage is to connect pages

    //Constructor intializzes WebDriver, WebDriverWait, and Actions
    public Basepage(WebDriver driver) {
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
        //super driver
    }
    //Explicit wait for WebELements directly (POM compatible)
    public void waitForVisibility (WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    //Click a locator
    public void click (WebElement element) {
        waitForVisibility(element);
        element.click();
    }
    //Double-click a WebElement
    public void doubleClick (WebElement element) {
        waitForVisibility(element);
        actions.doubleClick(element).perform();
    }
    //Get text safely
    public String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }
}