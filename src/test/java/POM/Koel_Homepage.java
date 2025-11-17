package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Koel_Homepage extends BasePage {

    // Constructor
    public Koel_Homepage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By profileLink = By.xpath("//span[@class='name']");
    private final By logoutBtn = By.xpath("//a[@title='Log student out']");
    private final By aboutButton = By.xpath("//button[@title='About Koel']");
    private final By recentlyPlayedSection = By.xpath("//section[h1[contains(text(),'Recently Played')]]");
    private final By recentlyPlayedViewAll = By.xpath("//button[@data-testid='home-view-all-recently-played-btn']");
    private final By recentlyAddedAlbum = By.xpath()
    private final By recentlyAddedShuffle = By.cssSelector("a.shuffle-album");
    private final By recentlyAddedDownload = By.cssSelector("a.download-album");
    private final By searchField = By.cssSelector("#searchForm input[type='search']");

    // Your Music panel tabs
    private final By homeTab = By.xpath("//nav//a[text()='Home']");
    private final By currentQueueTab = By.xpath("//nav//a[text()='Current Queue']");
    private final By allSongsTab = By.xpath("//nav//a[text()='All Songs']");
    private final By albumsTab = By.xpath("//nav//a[text()='Albums']");
    private final By artistsTab = By.xpath("//nav//a[text()='Artists']");

    // Playlists panel
    private final By createPlaylistBtn = By.xpath("//i[@title='Create a new playlist']");
    private final By createSmartPlaylistBtn = By.xpath("//li[@data-testid='playlist-context-menu-create-smart']");
    private final By favoritesPlaylist = By.xpath("//a[@href='#!/favorites']");
    private final By recentlyPlayedPlaylist = By.xpath("//a[@href='#!/recently-played']");
    private final By smartPlaylist = By.xpath("//a[contains(@href,'#!/playlist/') and contains(text(),'smart playlist')]");
    private final By userCreatedPlaylist = By.xpath("//li[contains(@class,'playlist')]/a[not(contains(text(),'Favorites')) and not(contains(text(),'Recently Played'))]");

    // Helper method
    public WebElement waitForElement(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Methods for verifying visibility
    public boolean isProfileLinkVisible() {
        return waitForElement(profileLink, 10).isDisplayed();
    }

    public boolean isAboutButtonVisible() {
        return waitForElement(aboutButton, 10).isDisplayed();
    }

    public boolean isRecentlyPlayedVisible() {
        return waitForElement(recentlyPlayedSection, 10).isDisplayed();
    }

    public boolean isRecentlyPlayedViewAllVisible() {
        return waitForElement(recentlyPlayedViewAll, 10).isDisplayed();
    }

    public boolean isRecentlyAddedAlbumVisible() {
        return waitForElement(recentlyAddedAlbum, 10).isDisplayed();
    }

    public boolean isRecentlyAddedShuffleVisible() {
        return waitForElement(recentlyAddedShuffle, 10).isDisplayed();
    }

    public boolean isRecentlyAddedDownloadVisible() {
        return waitForElement(recentlyAddedDownload, 10).isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return waitForElement(searchField, 10).isDisplayed();
    }

    // Your Music panel methods
    public boolean isHomePageTabVisible() {
        return waitForElement(homeTab, 10).isDisplayed();
    }

    public boolean isCurrentQueueTabVisible() {
        return waitForElement(currentQueueTab, 10).isDisplayed();
    }

    public boolean isAllSongsTabVisible() {
        return waitForElement(allSongsTab, 10).isDisplayed();
    }

    public boolean isAlbumsTabVisible() {
        return waitForElement(albumsTab, 10).isDisplayed();
    }

    public boolean isArtistsTabVisible() {
        return waitForElement(artistsTab, 10).isDisplayed();
    }

    // Playlists panel methods
    public boolean isCreatePlaylistButtonVisible() {
        return waitForElement(createPlaylistBtn, 10).isDisplayed();
    }

    public boolean isCreateSmartPlaylistButtonVisible() {
        return waitForElement(createSmartPlaylistBtn, 10).isDisplayed();
    }

    public boolean isFavoritesPlaylistVisible() {
        return waitForElement(favoritesPlaylist, 10).isDisplayed();
    }

    public boolean isRecentlyPlayedPlaylistVisible() {
        return waitForElement(recentlyPlayedPlaylist, 10).isDisplayed();
    }

    public boolean isSmartPlaylistVisible() {
        return waitForElement(smartPlaylist, 10).isDisplayed();
    }

    public boolean isUserCreatedPlaylistVisible() {
        return waitForElement(userCreatedPlaylist, 10).isDisplayed();
    }

    // Actions
    public void logout() {
        waitForElement(profileLink, 10).click();
        waitForElement(logoutBtn, 10).click();
    }
}
