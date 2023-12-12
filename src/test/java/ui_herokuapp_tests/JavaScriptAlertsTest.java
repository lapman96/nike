package ui_herokuapp_tests;

import com.herokuapp.pages.JavaScripAlertsPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

class JavaScriptAlertsTest extends BaseTest {
    JavaScripAlertsPage javaScripAlertsPage = new JavaScripAlertsPage(driver);

    @BeforeEach
    void executePreconditions() {
        javaScripAlertsPage.openPage();
    }

    @Test
    void checkTheAbilityToReadTheInfoFromJsAlert() {
        javaScripAlertsPage.buttonForJsAlert.click();
        assertThat(driver.switchTo().alert().getText()).isEqualTo("I am a JS Alert");
        driver.switchTo().alert().accept();
    }

    @Test
    void checkTheAbilityToAcceptJsAlert() {
        javaScripAlertsPage.buttonForJsAlert.click();
        driver.switchTo().alert().accept();
        assertThat(javaScripAlertsPage.resultString.getText()).isEqualTo("You successfully clicked an alert");
    }

    @Test
    void checkTheAbilityToAcceptConfirmationJsAlert() {
        javaScripAlertsPage.buttonForConfirmAlertButton.click();
        driver.switchTo().alert().accept();
        assertThat(javaScripAlertsPage.resultString.getText()).isEqualTo("You clicked: Ok");
    }

    @Test
    void checkTheAbilityToDismissConfirmationJsAlert() {
        javaScripAlertsPage.buttonForConfirmAlertButton.click();
        driver.switchTo().alert().dismiss();
        assertThat(javaScripAlertsPage.resultString.getText()).isEqualTo("You clicked: Cancel");
    }

    @Test
    void checkTheAbilityToEnterValueInPromptJsAlert() {
        javaScripAlertsPage.buttonForPromptAlertButton.click();
        driver.switchTo().alert().sendKeys("test");
        driver.switchTo().alert().accept();
        assertThat(javaScripAlertsPage.resultString.getText()).isEqualTo("You entered: test");
    }
}

