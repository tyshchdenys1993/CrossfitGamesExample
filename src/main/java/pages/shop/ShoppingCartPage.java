package pages.shop;

import base.BaseUiTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends CrossFitStuffShopPage {

    @FindBy(xpath = "//a[contains(@class,'cart-item-remove')]")
    private WebElement removeProductButton;

    @FindBy(xpath = "//p[contains(@class,'cart-items-empty')]")
    private WebElement emptyCardTextField;

    private final String EMPTY_CARD_TEXT = "Your cart is currently empty.";

    public ShoppingCartPage(BaseUiTest testClass) {
        super(testClass);
        PageFactory.initElements(testClass.getDriver(), this);
    }

    public void removeProductsFromShoppingCart(){
        testClass.waitTillElementIsVisible(removeProductButton);
        removeProductButton.click();
    }

    public void verifyThatCartIsEmpty(){
        testClass.waitTillElementIsVisible(emptyCardTextField);
        Assert.assertEquals(EMPTY_CARD_TEXT, emptyCardTextField.getText().trim());
    }
}
