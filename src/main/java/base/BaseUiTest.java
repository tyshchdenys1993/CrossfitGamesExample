package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utils.ParseYamlFile;

public abstract class BaseUiTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Rule public RunTestRule unTestRule = new RunTestRule(this);

    public BaseUiTest() {
        System.setProperty("webdriver.chrome.driver","src/main//resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public HomePage openSite(){
        driver.get(ParseYamlFile.getYamlData().getUrl());
        waitForLoad();
        return new HomePage(this);
    }

    public void closeSite(){
        driver.quit();
    }

    public void log(String message){
        logger.info(message);
    }

    public void error(String message){
        logger.error(message);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitTillElementIsVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitTillElementIsClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitTillElementIsNotVisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitTillAttributeIsChanged(WebElement element, String attribute, String value){
        wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    public void waitForLoad() {
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

}
