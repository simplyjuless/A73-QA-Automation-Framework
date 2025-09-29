package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Basepage {

    WebDriver driver;

    public Homepage (WebDriver givenDriver) {
        super(givenDriver);
        this.driver = givenDriver;
        PageFactory.initElements(driver, this);
    }
    //@FindBy instead of By locators
    @FindBy(css = "a[href*='favorites']")
    private WebElement firstPlaylist;

    @FindBy(css ="input[data-testid='inline-playlist-name-input']")
    private WebElement playlistNameField;

    @FindBy(css = "div.alert-success")
    private WebElement renamePlaylistSuccessMsg;

    //Double-click a playlist
    public void doubleClickPlaylist() {
        actions.doubleClick(firstPlaylist).perform();
    }
    public void enterNewPlaylistName(String playlistName) {
        playlistNameField.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        playlistNameField.sendKeys(playlistName);
        playlistNameField.sendKeys(Keys.ENTER);
    }
    //Success message getter
    public String getRenamePlaylistSuccessMsg(){
        return renamePlaylistSuccessMsg.getText();
    }
}