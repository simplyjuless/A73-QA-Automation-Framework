package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators
    private static By avatarIcon = By.cssSelector("img.avatar");
    private By favoritesTab = By.cssSelector("a[href='#/favorites']");
    private By logoutBtn = By.cssSelector(".logout");

    //Actions
    public static boolean isDisplayed() {
        //check if avatar is visible
        return findElement(avatarIcon).isDisplayed();
    }

    public void navigateTo(String pageName) {
        if (pageName.toLowerCase().equals("favorites")) {
            findElement(favoritesTab).click();
            //can add more pages here:
            // case "albums""findElement(albumsTabs).click(); break;
        } else {
            throw new IllegalArgumentException("Unknown page:" + pageName);
        }
    }
    public boolean isFavoritesPageDisplayed() {
        By favoritesHeader = By.cssSelector("section.favorites, h1.page-title");
        return findElement(favoritesHeader).isDisplayed();
    }
    public void logout() {
        findElement(avatarIcon).click(); //opens dropdown menu
        findElement(logoutBtn).click(); //logs user out
    }
}