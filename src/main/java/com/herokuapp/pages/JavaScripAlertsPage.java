package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScripAlertsPage extends Basepage {

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement buttonForJsAlert;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement buttonForConfirmAlertButton;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement buttonForPromptAlertButton;

    @FindBy(id = "result")
    public WebElement resultString;

    public JavaScripAlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public JavaScripAlertsPage openPage() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        return this;
    }

}
