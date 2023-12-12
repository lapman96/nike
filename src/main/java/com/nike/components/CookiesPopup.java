package com.nike.components;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesPopup extends BaseComponent {

    @FindBy(xpath = "//button[@data-testid=\"dialog-accept-button\"]")
    private WebElement acceptAllButton;

    public CookiesPopup(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @SneakyThrows
    public void acceptAllCookies() {
        acceptAllButton.click();
        Thread.sleep(3000);
    }
}
