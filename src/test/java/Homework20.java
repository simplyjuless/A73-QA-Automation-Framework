import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeleteMessage = "Deleted playlist \"Test Pro Playlist.\"";


        //Login
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlayListMsg(), expectedPlaylistDeleteMessage);
        }

    //Click on "Test Pro Playlist"
    private void openPlaylist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Test Pro Playlist')]")));
        emptyPlaylist.click();
    }


    //Verify success message appears
        public String getDeletedPlayListMsg () throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alertify-logs.top.right")));
            return notificationMsg.getText();
        }


        //Click delete button
        public void clickDeletePlaylistBtn () throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement deletePlaylist = wait.until (ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Delete this playlist']")));
            deletePlaylist.click();

        }

    }