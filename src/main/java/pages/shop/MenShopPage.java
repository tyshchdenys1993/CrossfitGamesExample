package pages.shop;

import base.BaseUiTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MenShopPage extends CrossFitStuffShopPage {

    @FindBy(xpath = "//a[@data-value='Footwear']")
    private WebElement footwearCheckbox;

    @FindBy (xpath = "//a[@data-value='Footwear']/span[@class='bc-sf-filter-option-amount']")
    private WebElement footwearAmountFromCheckbox;

    @FindBy (xpath = "//li[@class='productGrid-item']")
    private List<WebElement> productsList;

    @FindBy(xpath = "//div[@class='bc-sf-filter-selection-wrapper']/div[@class='bc-sf-filter-block-title']")
    private WebElement refineByField;

    private final String PRODUCT_DETAILS_XPATH = "//li[@class='productGrid-item']/h3/a[text()='%s']";


    public MenShopPage(BaseUiTest testClass) {
        super(testClass);
        PageFactory.initElements(testClass.getDriver(), this);
    }

    public void clickToFootwearCheckbox(){
        testClass.waitTillElementIsVisible(footwearCheckbox);
        footwearCheckbox.click();
    }

    public void verifyAmountOfFootwear(){
        testClass.waitTillElementIsVisible(refineByField);
        int expectedFootwearAmount = Integer.valueOf(footwearAmountFromCheckbox.getText().replaceAll("[\\W]", ""));
        Assert.assertEquals(expectedFootwearAmount, productsList.size());
    }

    public ProductDetailsPage openProductByName(String productName){
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.xpath(String.format(PRODUCT_DETAILS_XPATH, productName))));
        testClass.getDriver().findElement(By.xpath(String.format(PRODUCT_DETAILS_XPATH, productName))).click();
        return new ProductDetailsPage(testClass);
    }
}
