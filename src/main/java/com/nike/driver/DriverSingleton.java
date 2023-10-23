package com.nike.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {
    static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver != null){
            return driver;
        } else {
            System.out.println("Driver is created");
            return WebDriverManager.chromedriver().create();
        }
    }
}
