package com.nike.elements.product_listing;

import com.nike.elements.BaseElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class ProductCart extends BaseElements {
    public ProductCart(WebDriver driver, WebElement root) {
        super(driver, root);
    }

    public String getLabel() {
        List<WebElement> label = findOptionalCartInfo(".//div[@data-testid=\"product-card__messaging\"]");
        return label.isEmpty() ? null : label.get(0).getText();
    }

    public String getName() {
        return root.findElement(By.xpath(".//div[@class=\"product-card__title\"]")).getText();
    }

    public String getSubtitle() {
        List<WebElement> subtitle = findOptionalCartInfo(".//div[@class=\"product-card__subtitle\"]");
        return subtitle.isEmpty() ? null : subtitle.get(0).getText();
    }

    public int getNumberOfColors() {
        String numberOfColors = root.findElement(By.xpath(".//div[@class=\"product-card__product-count\"]")).getText();
        return Integer.parseInt(numberOfColors.replaceAll("[^0-9]", ""));
    }

    public float getBasicPrice() {
        String price = root.findElement(By.xpath(".//div[@data-testid=\"product-price\"]")).getText();
        return Float.parseFloat(price.replaceAll("[^0-9.]", ""));
    }

    public boolean doesProductHaveReducedPrice() {
        List<WebElement> oldPrice = findOptionalCartInfo(".//div[@data-testid=\"product-price-reduced\"]");
        return !oldPrice.isEmpty();
    }

    public float getReducedPrice() {
        List<WebElement> oldPrice = findOptionalCartInfo(".//div[@data-testid=\"product-price-reduced\"]");
        return oldPrice.isEmpty() ? 0 : Float.parseFloat(oldPrice.get(0).getText().replaceAll("[^0-9.]", ""));
    }

    public float getPercentageOfDiscount() {
        List<WebElement> percentageOfDiscount = findOptionalCartInfo(".//div[@class=\"product-price__perc css-1rz91t\"]");
        return percentageOfDiscount.isEmpty() ? 0 : Float.parseFloat(percentageOfDiscount.get(0).getText().replaceAll("[^0-9]", ""));
    }

    private List<WebElement> findOptionalCartInfo(String xpath) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        List<WebElement> optionalProductCartElement = root.findElements(By.xpath(xpath));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return optionalProductCartElement;
    }

    public int getProductPositionIndex() {
        return Integer.parseInt(getRoot().getAttribute("data-product-position"));
    }
}
