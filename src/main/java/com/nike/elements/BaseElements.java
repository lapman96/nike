package com.nike.elements;

import org.openqa.selenium.WebElement;

public abstract class BaseElements {
    WebElement root;

    protected BaseElements(WebElement root) {
        this.root = root;
    }
}
