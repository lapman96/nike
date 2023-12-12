package com.nike.pages;

import com.nike.components.filter.Filters;
import com.nike.dto.ProductDto;
import com.nike.elements.product_listing.ProductCart;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.function.Predicate;


public class ProductListingPage extends BasePage{
    @Getter
    private Filters filter;

    @FindBy(xpath = "//span[@class=\"wall-header__item_count\"]")
    private WebElement totalProductsCounter;

    private final By productCardXpath = By.xpath("//div[@data-testid=\"product-card\"]");

    public ProductListingPage(WebDriver driver) {
        super(driver);
        this.filter = new Filters(driver);
        PageFactory.initElements(driver,this);
    }

    public List<ProductCart> getProducts() {
        scrollThroughAllProducts();
        return driver.findElements(productCardXpath)
                .stream()
                .map(root -> new ProductCart(driver,root))
                .toList();
    }

    public ProductCart getFirstProductOnThePageAsProductCart() {
        WebElement firstProductCartOnThePage = driver.findElement(productCardXpath);
        return new ProductCart(driver, firstProductCartOnThePage);
    }

    public ProductListingPage getFirstProductAndSaveItToProductDto(ProductDto productDto) {
        ProductCart firstProduct = getFirstProductOnThePageAsProductCart();
        transferAllDataFromProductCartToProductDto(firstProduct, productDto);
        return this;
    }

    public ProductListingPage getProductByConditionAndSaveItToProductDto(Predicate<ProductCart> predicate, ProductDto productDto) {
        ProductCart productCart = getProducts()
                .stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow();

        transferAllDataFromProductCartToProductDto(productCart, productDto);
        return this;
    }

    public ProductDetailsPage clickOnTheProductCardByItsPosition(int productPositionIndex) {
        String productXpath = String.format("//div[@data-product-position=\"%d\"]", productPositionIndex);
        driver.findElement(By.xpath(productXpath)).click();
        return new ProductDetailsPage(driver);
    }

    @SneakyThrows
    private void scrollThroughAllProducts() {
        int totalProducts = getTotalNumberOfProductsFromProductCounter();
        int numberOfVisibleProducts = 0;

        do {
            scrollPageToBottom();
            Thread.sleep(2000);
            numberOfVisibleProducts = driver.findElements(productCardXpath).size();
        } while (numberOfVisibleProducts < totalProducts);
    }

    public int getTotalNumberOfProductsFromProductCounter() {
        String counter = totalProductsCounter.getText();
        return Integer.parseInt(counter.replaceAll("[^\\d]", ""));
    }

    private void transferAllDataFromProductCartToProductDto(ProductCart productCart, ProductDto productDto) {
        productDto.setLabel(productCart.getLabel());
        productDto.setName(productCart.getName());
        productDto.setSubtitle(productCart.getSubtitle());
        productDto.setNumberOfColours(productCart.getNumberOfColors());
        productDto.setBasicPrice(productCart.getBasicPrice());
        productDto.setReducedPrice(productCart.getReducedPrice());
        productDto.setPercentageOfDiscount(productCart.getPercentageOfDiscount());
        productDto.setProductPositionIndex(productCart.getProductPositionIndex());
    }
}
