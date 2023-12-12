package com.nike.pages;

import com.nike.components.CookiesPopup;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.nike.PagesUrl.COOKIES_PAGE;

public class CookiesPage extends BasePage {
    @Getter
    private CookiesPopup cookiesPopup;

    @Setter
    @FindAll({@FindBy(xpath = "//div[@data-testid]//input[not(@disabled)]")})
    private List<WebElement> cookiesCheckboxes;

    public CookiesPage(WebDriver driver) {
        super(driver);
        this.cookiesPopup = new CookiesPopup(driver);
        PageFactory.initElements(driver, this);
    }

    public CookiesPage openCookiesPage() {
        driver.get(COOKIES_PAGE);
        return new CookiesPage(driver);
    }
}
