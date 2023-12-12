package ui_nike_tests;

import com.nike.pages.ProductListingPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

class FooterTest extends BaseTest {

    @Test
    void checkTheAbilityToOpenInstagramPage() {
        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage
                .getFooter()
                .clickOnInstagramMediaIcon();

        boolean isNikeInstagramOpened = driver.getWindowHandles()
                .stream()
                .map(browserTab -> {
                    driver.switchTo().window(browserTab);
                    webDriverWait.until(ExpectedConditions.jsReturnsValue("return document.title !== undefined && document.title !== ''"));
                    return (String) jsExecutor.executeScript("return document.title;");
                })
                .anyMatch(title -> title.contains("Nike") && title.contains("Instagram"));

        assertThat(isNikeInstagramOpened).isTrue();
    }
}

