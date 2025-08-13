import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeleteMessage ="Deleted playlist \"Test Pro Playlist.\"";


        //Login
        openPlaylist();
        clickDeletePlaylistBtn();
        Thread.sleep(5000);
        String actualMessage= getDeletedPlayListMsg();
        Assert.assertEquals(getDeletedPlayListMsg(), expectedPlaylistDeleteMessage);
    }


    //Verify success message appears
    public String getDeletedPlayListMsg() throws InterruptedException {
        Thread.sleep(3000);
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return notificationMsg.getText();
    }


    //Click delete button
    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deletePlaylist.click();
        Thread.sleep(2000);


    }
    //Click on "Test Pro Playlist"
    public void openPlaylist() {
        WebElement emptyPlaylist = driver.findElement(By.xpath("//a[contains(text(),'Test Pro Playlist')]"));
        emptyPlaylist.click();
    }

}
