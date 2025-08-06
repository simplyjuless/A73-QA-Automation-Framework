import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework17 extends BaseTest {

    @Test
    public void AddSongToPlaylist() throws InterruptedException {
        driver.get("https://qa.koel.app/");
        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";

        Thread.sleep(2000);
        provideEmail("julia.munoz@testpro.io");
        providePassword("Ltdan25!");
        clickOnLoginBtn();
        Thread.sleep(2000);

        searchSong("Dark Days");
        clickViewAllBtn();
        Thread.sleep(3000);
        selectFirstSong();
        clickAddBtn();
        Thread.sleep(1000);
        choosePlaylist();
        Thread.sleep(2000);
        getAddToPlaylistSuccessMsg();
        System.out.println(getAddToPlaylistSuccessMsg());
        Thread.sleep(2000);

        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);

    }

    private String getAddToPlaylistSuccessMsg() {
        WebElement notifMessage = driver.findElement(By.xpath("//div[contains(@class, 'success') and contains(@class, 'show')]"));
        return notifMessage.getText();
    }

    private void choosePlaylist() {
        WebElement playListBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Test Pro Playlist')]"));
        playListBtn.click();
    }

    private void clickAddBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//button[@data-test='add-to-btn']"));
        addToBtn.click();
    }

    private void selectFirstSong()  {
        WebElement firstSong = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
        firstSong.click();
    }


    private void clickViewAllBtn() {
       WebElement viewAllBtn =driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
       viewAllBtn.click();

    }

    private void searchSong(String song) {
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys(song);
    }

    private void clickOnLoginBtn() {
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

    private void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    private void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    private void navigateToPage(String url) {
        driver.get(url);
    }


}
