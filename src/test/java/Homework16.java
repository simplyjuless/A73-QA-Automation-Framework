import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    public String url = "https://qa.koel.app/";

    @Test
    //Step 1 & 2 Using selenium, navigate to koel app
   public void registrationNavigation() throws InterruptedException{
        driver.get("https://qa.koel.app/");
        Thread.sleep(2000);

        //Step 3 - Click Registration Link
        WebElement registrationLink = driver.findElement(By.xpath("//a[contains(@href, 'registration')]"));
        registrationLink.click();
        Thread.sleep(2000);

        //Step 4 - Verify Registration Page Using Assert Method
        String expectedURL = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL, "You are not on the registration page.");
    }

}
