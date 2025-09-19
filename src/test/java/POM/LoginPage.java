package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Basepage{
    //Constructor initializes POM elements
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver); //navigates to BasePage
        PageFactory.initElements(givenDriver, this);
    }

    //Locators
    @FindBy(css ="input[type='email']")
    private WebElement emailField;
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;

    //Page Methods
    public void provideEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        emailField.clear();
        passwordField.sendKeys(password);
    }

    public void submitBtn (){
        submitBtn.click();
    }

    public LoginPage login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        submitBtn();
        return this;
    }

}