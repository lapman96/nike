package com.nike.components;

import com.nike.PagesUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesPopup extends BaseComponent {

    @FindBy(xpath = "//button[@data-testid=\"dialog-accept-button\"]")
    private WebElement acceptAllButton;

    public CookiesPopup(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void acceptAllCookies() {
        driver.get(PagesUrl.BASE_URL);
        acceptAllButton.click();
    }
}
