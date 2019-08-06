package pages.shop;

import base.BaseUiTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPopUp extends CrossFitStuffShopPage {

    @FindBy(xpath = "//a[@class='cart__view-bag']")
    private WebElement viewBagButton;

    public YourCartPopUp(BaseUiTest testClass) {
        super(testClass);
        PageFactory.initElements(testClass.getDriver(), this);
    }

    public ShoppingCartPage openShoppingCartPage(){
        testClass.waitTillElementIsVisible(viewBagButton);
        viewBagButton.click();
        return new ShoppingCartPage(testClass);
    }
}
