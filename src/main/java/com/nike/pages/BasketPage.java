package com.nike.pages;

import com.nike.elements.basket.BasketItem;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.function.Predicate;

public class BasketPage extends BasePage {
    @Setter
    @FindAll({@FindBy(xpath = "//div[@data-automation=\"cart-item\"]")})
    private List<BasketItem> basketItems;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage selectRandomQuantityForBasketItem(Predicate<BasketItem> basketItemPredicate) {
        BasketItem basketItem = basketItems.stream()
                .filter(basketItemPredicate)
                .findFirst()
                .orElseThrow();

        basketItem.selectRandomQuantityForBasketItem();
        return this;
    }
}
