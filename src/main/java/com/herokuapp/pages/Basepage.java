package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;

public abstract class Basepage {
    WebDriver driver;

    protected Basepage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract Basepage openPage();
}
