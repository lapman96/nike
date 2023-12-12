package com.nike.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseElements {
    protected WebDriver driver;
    protected WebElement root;

    protected BaseElements(WebDriver driver, WebElement root) {
        this.driver = driver;
        this.root = root;
    }

    public WebElement getRoot() {
        return root;
    }
}
