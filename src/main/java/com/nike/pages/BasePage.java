package com.nike.pages;

import com.nike.components.Footer;
import com.nike.components.Header;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nike.PagesUrl.MENS_FOOTBALL_SHOES_PRODUCT_LISTING_URL;

public abstract class BasePage {
    WebDriver driver;

    @Getter
    Header header;

    @Getter
    Footer footer;

    JavascriptExecutor jsExecutor;

    WebDriverWait webDriverWait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.header = new Header(driver);
        this.footer = new Footer(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage openPage(String url) {
        driver.get(url);
        return this;
    }

    public ProductListingPage openProductListingTestPage() {
        driver.get(MENS_FOOTBALL_SHOES_PRODUCT_LISTING_URL);
        return new ProductListingPage(driver);
    }

    void scrollPageToBottom() {
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight - 500)");
    }
}
