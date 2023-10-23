package com.nike.pages;

import com.nike.components.Header;
import com.nike.elements.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.function.Predicate;

public class ProductListingPage extends BasePage{
    private Header header;

    @FindBy(xpath = "//span[@class=\"wall-header__item_count\"]")
    private WebElement totalProductsCounter;

    @FindBy(xpath = "//div[@class=\"loader-bar css-19k7nfv\"]")
    private WebElement loader;

    public ProductListingPage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
        PageFactory.initElements(driver,this);
    }

    public List<Product> getProducts() throws InterruptedException {
        scrollPageToBottom();
        return driver.findElements(By.xpath("//div[@data-testid=\"product-card\"]"))
                .stream()
                .map(Product::new)
                .toList();
    }

    public Product getProduct(Predicate<Product> condition) throws InterruptedException {
        return getProducts()
                .stream()
                .filter(condition)
                .findFirst()
                .orElseThrow();
    }

    private void scrollPageToBottom() throws InterruptedException {
        int totalProducts = getTotalProductsCounter();
        int numberOfVisibleProducts = 0;
        do {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000);
            numberOfVisibleProducts = driver.findElements(By.xpath("//div[@data-testid=\"product-card\"]")).size();
        } while (numberOfVisibleProducts < totalProducts);
    }

    public int getTotalProductsCounter() {
        String counter = totalProductsCounter.getText();
        return Integer.parseInt(counter.replaceAll("[^\\d]", ""));
    }
}
