package com.nike.pages;

import com.nike.dto.ProductDto;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductDetailsPage extends BasePage {
    @Setter
    @FindAll({@FindBy(xpath = "//fieldset[contains(@class,'colorway-images')]/div")})
    private List<WebElement> coloursOptions;

    @Setter
    @FindAll({@FindBy(xpath = "//label[@class='css-xf3ahq']")})
    private List<WebElement> sizeOptions;

    @FindBy(xpath = "//button[@aria-label=\"Add to Bag\"]")
    private WebElement addToBagButton;

    @FindBy(xpath = "//button[@data-testid=\"qa-cart-view\"]")
    private WebElement viewBagButtonInMiniBasketPopup;

    ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductDetailsPage selectAnyColorAndSaveItToProductDto(ProductDto productDto) {
        WebElement colourOption = coloursOptions.get(0);
        String colorOptionName = colourOption.findElement(By.xpath(".//img")).getAttribute("alt");
        productDto.setColour(colorOptionName);
        colourOption.click();
        return this;
    }

    public ProductDetailsPage selectAnyAvailableSizeAndSaveItToProductDto(ProductDto productDto) {
        WebElement sizeOption = sizeOptions
                .stream()
                .filter(WebElement::isEnabled)
                .findFirst()
                .orElseThrow();

        productDto.setSize(sizeOption.getText());
        sizeOption.click();
        return this;
    }

    public ProductDetailsPage addProductToBag() {
        jsExecutor.executeScript("window.scrollTo(0, 400)");
        webDriverWait.until(ExpectedConditions.visibilityOf(addToBagButton));
        addToBagButton.click();
        return this;
    }

    public BasketPage clickViewBagButtonInMiniBasketPopup() {
        webDriverWait.until(ExpectedConditions.visibilityOf(viewBagButtonInMiniBasketPopup));
        viewBagButtonInMiniBasketPopup.click();
        return new BasketPage(driver);
    }
}
