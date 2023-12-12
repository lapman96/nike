package ui_herokuapp_tests;

import com.herokuapp.pages.IFramePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IFrameTest extends BaseTest{

    @Test
    void checkTheAbilityToEnterNewTextInTheInputField() {
        IFramePage iFramePage = new IFramePage(driver);
        String testData = "Test data";
        iFramePage.openPage().enterTextInTheInputField(testData);

        assertThat(iFramePage.getTextFromInputField()).isEqualTo(testData);
    }
}
