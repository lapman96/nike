package com.herokuapp.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HorizontalSliderPage extends Basepage {

    @FindBy(xpath = "//input")
    public WebElement slider;

    @FindBy(id = "range")
    public WebElement currentSliderValue;

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public HorizontalSliderPage openPage() {
        driver.get("http://the-internet.herokuapp.com/horizontal_slider");
        return this;
    }

    public HorizontalSliderPage changeValueInSliderInput (float desiredValue) {
        validateInputValue(desiredValue);
        slider.click();

        if (desiredValue > getCurrentSliderValue()) {
            do {
                slider.sendKeys(Keys.ARROW_UP);
            } while (desiredValue != getCurrentSliderValue());
        } else if (desiredValue < getCurrentSliderValue()) {
            do {
                slider.sendKeys(Keys.ARROW_DOWN);
            } while (desiredValue != getCurrentSliderValue());
        }

        return this;
    }

    private float getMaximumValueOfSlider() {
        return Float.parseFloat(slider.getAttribute("max"));
    }

    private float getSliderStep() {
        return Float.parseFloat(slider.getAttribute("step"));
    }

    public float getCurrentSliderValue() {
        return Float.parseFloat(currentSliderValue.getText());
    }

    private void validateInputValue(float inputValue) {
        if (inputValue > getMaximumValueOfSlider()) {
            throw new IllegalArgumentException("inputValue is bigger than maximum value that input is able to accept");
        } else if (inputValue % getSliderStep() != 0) {
            throw new IllegalArgumentException("inputValue the entered value is not a multiple of the step");
        }
    }

}
