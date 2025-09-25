import POM.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist()  {
        driver.get(url);

        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";

        provideEmail("julia.munoz@testpro.io");
        providePassword("Ltdan25!");
        clickOnLoginBtn();


        searchSong("Dark Days");
        clickViewAllBtn();

        selectFirstSong();
        clickAddBtn();

        choosePlaylist();

        getAddToPlaylistSuccessMsg();
        System.out.println(getAddToPlaylistSuccessMsg());


        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);

    }

    private String getAddToPlaylistSuccessMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement notifMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'success') and contains(@class, 'show')]")));
        return notifMessage.getText();
    }

    private void choosePlaylist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement playListBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Test Pro Playlist')]")));
        playListBtn.click();
    }

    private void clickAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-test='add-to-btn']")));
        addToBtn.click();
    }

    private void selectFirstSong()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]")));
        firstSong.click();
    }


    private void clickViewAllBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement viewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-test='view-all-songs-btn']")));
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
