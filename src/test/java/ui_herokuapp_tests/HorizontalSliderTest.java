package ui_herokuapp_tests;

import com.herokuapp.pages.HorizontalSliderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HorizontalSliderTest extends BaseTest{
    HorizontalSliderPage horizontalSliderPage;
    @BeforeEach
    void executePreconditions() {
        horizontalSliderPage = new HorizontalSliderPage(driver);
        horizontalSliderPage.openPage();
    }

    @Test
    void checkAbilityToIncreaseSliderValue() {
        horizontalSliderPage.changeValueInSliderInput(3.5f);
        assertThat(horizontalSliderPage.getCurrentSliderValue()).isEqualTo(3.5f);
    }

    @Test
    void checkAbilityToDecreaseSliderValue() {
        horizontalSliderPage.changeValueInSliderInput(4.5f).changeValueInSliderInput(2f);
        assertThat(horizontalSliderPage.getCurrentSliderValue()).isEqualTo(2f);
    }
}
