package com.nike.pages;

import com.nike.PagesUrl;
import com.nike.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage{
    Header header;

    public Homepage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
        PageFactory.initElements(driver,this);
    }

    public Homepage openHomepage(){
        driver.get(PagesUrl.BASE_URL);
        return this;
    }

    public ProductListingPage executeSearch(String searchQuery) {
        return header.executeSearch(searchQuery);
    }
}
