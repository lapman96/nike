package com.nike.components;

import org.openqa.selenium.WebDriver;

public abstract class BaseComponent {
    WebDriver driver;

    protected BaseComponent(WebDriver driver) {
        this.driver = driver;
    }
}
