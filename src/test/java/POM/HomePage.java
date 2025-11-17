package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By welcomeMessage = By.xpath("//h1[contains(text(), 'student')]");
    private final By searchField = By.cssSelector("#searchForm input[type='search']");

    // Actions
    public boolean isWelcomeMessageDisplayed() {
        return isDisplayed(welcomeMessage, 10);
    }

    public String getWelcomeMessageText() {
        return getText(welcomeMessage, 10);
    }

    public boolean isSearchFieldVisible() {
        return isDisplayed(searchField, 10);
    }
}
