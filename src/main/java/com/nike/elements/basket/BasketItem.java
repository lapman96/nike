package com.nike.elements.basket;

import com.nike.elements.BaseElements;
import com.nike.utils.RandomNumberGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasketItem extends BaseElements {

    protected BasketItem(WebDriver driver, WebElement root) {
        super(driver, root);
    }

    public String getName() {
        return root.findElement(By.xpath(".//div[@data-automation=\"cart-item-product-name\"]")).getText();
    }

    public BasketItem selectRandomQuantityForBasketItem() {
        Select quantitySelector = new Select(root.findElement(By.xpath(".//select[@data-automation=\"quantity-select\"]")));
        int numberOfOptionsInSelector = quantitySelector.getOptions().size();
        quantitySelector.selectByIndex(RandomNumberGenerator.generateRandomNumber(0, numberOfOptionsInSelector));
        return this;
    }

}
