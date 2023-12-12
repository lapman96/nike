package com.nike.components.filter;

import com.nike.components.BaseComponent;
import com.nike.components.filter.filter_enums.ShopByPriceFilterOptions;
import com.nike.pages.ProductListingPage;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

public class Filters extends BaseComponent {
    @FindBy(xpath = "//div[@aria-label=\"Shop By Price\" and @role=\"button\"]")
    private WebElement shopByPriceFilter;

    public Filters(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @SneakyThrows
    public ProductListingPage applyShopByPriceFilter(ShopByPriceFilterOptions... options) {
        shopByPriceFilter.click();
        Arrays.stream(options)
                .map(option -> driver.findElement(By.xpath(String.format("//button[@aria-label='Filter for %s']", option.getValue()))))
                .forEach(WebElement::click);
        Thread.sleep(1000);
        return new ProductListingPage(driver);
    }
}
