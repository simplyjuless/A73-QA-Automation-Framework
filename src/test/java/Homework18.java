import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//create a new file, homework18.java in Intellij IDEA
public class Homework18 extends BaseTest {
//Create a test case, playSong() using @Test annotation

    //test annotations
    @Test
    // inherited navigate to page and login with credentials
    public void playsong() throws InterruptedException {
    //click play, play button, & to play a song
        clickPlay();
        Thread.sleep(2000);
    //validate that song is playing by verifying if the sound bar is displayed
        Assert.assertTrue(isSongPlaying(), "Song is not playing");
    }

    private boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }

    private void clickPlay() throws InterruptedException {
        Thread.sleep(2000);
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextButton.click();
        Thread.sleep(2000);

        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playButton.click();
    }
}