import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homeworkk21 extends BaseTest {
    public static Actions actions = null;
    String newPlayListName = "Gym";

    @Test
    public void renamePlaylist() throws InterruptedException {
        String oldName ="Test Pro Playlist";
        String newName = "Gym";
        String expectedRenameMessage = "Updated playlist \"" + "Gym." + "\"";
        
        actions = new Actions(driver);

        //Prerequisite - user renames "Test Pro Playlist" to "Gym"
        doubleClickOnPlaylist();
        enterNewPlaylistName();

        String actualMessage = getRenamePlaylistMsg();
        Assert.assertEquals(actualMessage, expectedRenameMessage, "Playlist rename failed!");

    }
    private String getRenamePlaylistMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement notification  = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.success.show")));
        return notification.getText();
    }

    private void enterNewPlaylistName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[text()='Test Pro Playlist']/following-sibling::input[@type='text']")));

        nameInput.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        nameInput.sendKeys("Gym");
        nameInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//a[@class='active']"), newPlayListName));
    }

    //double-click on "Test Pro Playlist"
    public void doubleClickOnPlaylist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playListElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='#!/playlist/105474' and text()='Test Pro Playlist']")));
        actions.doubleClick(playListElement).perform();
    }
}