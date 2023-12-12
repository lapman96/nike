package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class IFramePage extends Basepage {

    By iframeLocator = By.xpath("//iframe");
    By textInputLocator = By.id("tinymce");

    public IFramePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public IFramePage openPage() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        return this;
    }

    public IFramePage enterTextInTheInputField(String text) {
        WebElement iframe = driver.findElement(iframeLocator);
        driver.switchTo().frame(iframe);
        WebElement textInput = driver.findElement(textInputLocator);

        new Actions(driver)
                .keyDown(textInput, Keys.COMMAND)
                .sendKeys("A")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.DELETE)
                .sendKeys(text)
                .build().perform();

        driver.switchTo().defaultContent();
        return this;
    }

    public String getTextFromInputField() {
        WebElement iframe = driver.findElement(iframeLocator);
        driver.switchTo().frame(iframe);
        WebElement textInput = driver.findElement(textInputLocator);

        String text = textInput.getText();
        driver.switchTo().defaultContent();
        return text;
    }

}
