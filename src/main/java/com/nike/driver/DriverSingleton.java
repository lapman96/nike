package com.nike.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {
    static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        return driver == null ? WebDriverManager.chromedriver().create() : driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
