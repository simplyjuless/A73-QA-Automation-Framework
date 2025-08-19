package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage extends Basepage{
    //Constructor
    public Loginpage(WebDriver givenDriver) {
        super(givenDriver); //navigates to BasePage
    }

    //Locators
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    //Page Methods
    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void submitBtn (){
        findElement(submitBtn).click();
    }

    public void login() {
        provideEmail("julia.munoz@testpro.io");
        providePassword("Ltdan25!");
        submitBtn();
    }

}
