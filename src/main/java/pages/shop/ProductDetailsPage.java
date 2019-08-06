package pages.shop;

import base.BaseUiTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class ProductDetailsPage extends CrossFitStuffShopPage {

    @FindBy(xpath = "//input[@name='add']")
    private WebElement addToCartButton;


    public ProductDetailsPage(BaseUiTest testClass) {
        super(testClass);
        PageFactory.initElements(testClass.getDriver(), this);
    }

    public YourCartPopUp addProductToCart(){
        testClass.waitTillElementIsVisible(addToCartButton);
        addToCartButton.click();
        return new YourCartPopUp(testClass);
    }
}
