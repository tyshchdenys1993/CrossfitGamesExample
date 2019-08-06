package pages.shop;

import base.BaseUiTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class CrossFitStuffShopPage extends AbstractPage {

    @FindBy(xpath = "//li[contains(@class,'current')]")
    private WebElement uSStoreButton;

    @FindBy(xpath = "//li[contains(@class,'last')]")
    private WebElement otherStoreButton;

    @FindBy(xpath = "//div[@title='Close']")
            private WebElement discountDialog;

    @FindBy(xpath = "//div[contains(@class,'navbarMain-subMenu')]/preceding-sibling::a[contains(@href,'all-men')]")
    private WebElement menShopButton;

    private Actions actions = new Actions(testClass.getDriver());

    public CrossFitStuffShopPage(BaseUiTest testClass) {
        super(testClass);
    }

    public void clickToUSStoreButton(){
        testClass.waitTillElementIsClickable(uSStoreButton);
        uSStoreButton.click();
    }

    public void clickToOtherStoreButton(){
        testClass.waitTillElementIsClickable(otherStoreButton);
        otherStoreButton.click();
        testClass.waitTillElementIsClickable(otherStoreButton);
        otherStoreButton.click();
    }

    public CrossFitStuffShopPage closeDiscountOfferDialog(){
        testClass.waitTillElementIsVisible(discountDialog);
        if (discountDialog.isDisplayed()) {
            testClass.waitTillElementIsClickable(discountDialog);
            discountDialog.click();
            testClass.waitTillElementIsNotVisible(testClass.getDriver().findElement(By.xpath("//div[@class='privy-popup-content privy-foreground-element']")));
        }
        return new CrossFitStuffShopPage(testClass);
    }

    public MenShopPage openMenShopPage(){
        testClass.waitTillElementIsVisible(menShopButton);
        menShopButton.click();
        return new MenShopPage(testClass);
    }
}
