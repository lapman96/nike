package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DragAndDropPage extends Basepage {
    @FindBy(id = "column-a")
    public WebElement columnA;

    @FindBy(id = "column-b")
    public WebElement columnB;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DragAndDropPage openPage() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        return this;
    }

    public List<String> getSquaresInTheOrderAsTheyDisplayedOnThePage() {
        return driver.findElements(By.xpath("//div[@class='column']/header"))
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public void dragAndDropSquareToColumn(WebElement source, WebElement target) {
        new Actions(driver)
                .dragAndDrop(source, target)
                .build()
                .perform();
    }
}
