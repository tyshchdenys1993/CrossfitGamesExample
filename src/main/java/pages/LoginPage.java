package pages;

import base.BaseUiTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ParsePropertiesFile;

public class LoginPage extends AbstractPage {
    ParsePropertiesFile userCredentials = new ParsePropertiesFile();

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(BaseUiTest testClass) {
        super(testClass);
    }

    public HomePage login(){
        testClass.waitTillElementIsVisible(emailField);
        emailField.sendKeys(userCredentials.getLogin());
        passwordField.sendKeys(userCredentials.getPassword());
        loginButton.click();
        return new HomePage(testClass);
    }
}
