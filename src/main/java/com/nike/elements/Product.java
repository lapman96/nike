package com.nike.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product extends BaseElements{
    public Product(WebElement root) {
        super(root);
    }

    public String getLabel() {
        return root.findElement(By.xpath(".//div[@data-testid=\"product-card__messaging\"]"))
                .getText();
    }

    public String getName() {
        return root.findElement(By.xpath(".//div[@class=\"product-card__title\"]")).getText();
    }

    public String getSubtitle() {
        return root.findElement(By.xpath(".//div[@class=\"product-card__subtitle\"]")).getText();
    }

    public int getNumberOfColors() {
        String text = root.findElement(By.xpath(".//div[@class=\"product-card__product-count\"]"))
                .getText();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public float getPrice() {
        String price = root.findElement(By.xpath(".//div[@data-testid=\"product-price\"]")).getText();
        return Float.parseFloat(price.replaceAll("[^0-9.]", ""));
    }

    public float getReducedPrice() {
        String price = root.findElement(By.xpath(".//div[@data-testid=\"product-price-reduced\"]")).getText();
        return Float.parseFloat(price.replaceAll("[^0-9.]", ""));
    }

    public float getPercentageOfDiscount() {
        String price = root.findElement(By.xpath(".//div[@class=\"product-price__perc css-1rz91t\"]")).getText();
        return Float.parseFloat(price.replaceAll("[^0-9]", ""));
    }

    @Override
    public String toString() {
        return "Product{} " + this.getName() + " " + this.getPrice();
    }
}
