package com.nike.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer extends BaseComponent {

    @FindBy(xpath = "//div[@id='gen-nav-footer']")
    private WebElement footerRoot;

    @FindBy(xpath = "//a[@data-path='social:instagram']")
    private WebElement instagramSocialMediaIcon;

    public Footer(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnInstagramMediaIcon() {
        instagramSocialMediaIcon.click();
    }
}
