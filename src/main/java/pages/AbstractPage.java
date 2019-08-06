package pages;

import base.BaseUiTest;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.shop.CrossFitStuffShopPage;
import utils.ParseYamlFile;

public abstract class AbstractPage {

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@id='athleteMenu']")
    private WebElement loggedUserField;

    @FindBy(css = "a#pp-cookie-accept")
    private WebElement acceptCookieButton;

    @FindBy(xpath = "//div[@id='_atssh']/following-sibling::div")
    private WebElement cookiePolicyBlock;

    @FindBy(xpath = "//li[contains(@class,'col-md-7')]/a")
    private WebElement logoutButton;

    @FindBy(xpath = "//ul[contains(@class,'athlete-dropdown-menu')]")
    private WebElement loggedUserDropDownMenu;

    @FindBy(xpath = "//li[@id='shop']")
    private WebElement shopHeaderMenu;

    @FindBy(xpath = "//li[@id='shop']//a[contains(@href,'stuff')]")
    private WebElement stuffLink;

    protected BaseUiTest testClass;

    public AbstractPage(BaseUiTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
    }

    public LoginPage clickToLoginButton() {

        testClass.waitTillElementIsVisible(loginButton);
        loginButton.click();
        return new LoginPage(testClass);
    }

    public void verifyThatUserIsLoggedIn() {
        testClass.waitTillElementIsVisible(loggedUserField);
        Assert.assertEquals("This is incorrect User", ("Hello, " + ParseYamlFile.getYamlData().getUsername()).toUpperCase(), loggedUserField.getText().trim());
    }

    public void clickToAcceptCookieButton() {
        JavascriptExecutor js = (JavascriptExecutor) testClass.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        testClass.waitTillElementIsClickable(acceptCookieButton);
        acceptCookieButton.click();
        testClass.waitTillElementIsNotVisible(cookiePolicyBlock);
        js.executeScript("window.scrollTo(0, 0)");
    }

    public void logout() {
        Actions actions = new Actions(testClass.getDriver());
        actions.moveToElement(loggedUserField).build().perform();
        testClass.waitTillAttributeIsChanged(loggedUserDropDownMenu, "style", "display: block;");
        logoutButton.click();
    }

    public void verifyThatUserIsLoggedOut() {
        testClass.waitTillElementIsVisible(loginButton);
        Assert.assertEquals("Some user is logged in", "LOG IN", loginButton.getText().trim());
    }

    public CrossFitStuffShopPage openCrossFitStuffShopPage(){
        testClass.waitTillElementIsVisible(shopHeaderMenu);
//        Actions actions = new Actions(testClass.getDriver());
//        actions.moveToElement(shopHeaderMenu).build().perform();
//        testClass.waitTillElementIsClickable(stuffLink);
//        stuffLink.click();
        testClass.waitTillElementIsClickable(shopHeaderMenu);
        shopHeaderMenu.click();
        return new CrossFitStuffShopPage(testClass);
    }
}
