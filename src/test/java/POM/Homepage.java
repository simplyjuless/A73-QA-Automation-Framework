package POM;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends Basepage {

    public Homepage (WebDriver givenDriver){
        super(givenDriver);
    }
    By avatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar(){
        return findElement(avatarIcon);
    }
}
