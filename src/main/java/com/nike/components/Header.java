package com.nike.components;

import com.nike.pages.ProductListingPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends BaseComponent {

    @FindBy(xpath = "//input[@id=\"VisualSearchInput\"]")
    private WebElement searchField;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductListingPage executeSearch(String searchQuery) {
        searchField.sendKeys(searchQuery);
        searchField.sendKeys(Keys.ENTER);
        return new ProductListingPage(driver);
    }
}
