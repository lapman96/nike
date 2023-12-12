package ui_herokuapp_tests;

import com.herokuapp.pages.DragAndDropPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DragAndDropTest extends BaseTest {
    DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

    @Test
    void checkTheAbilityToDragAndDropSquareToDifferentColumn() {
        dragAndDropPage
                .openPage()
                .dragAndDropSquareToColumn(dragAndDropPage.columnA, dragAndDropPage.columnB);
        List<String> squaresHeaders = dragAndDropPage.getSquaresInTheOrderAsTheyDisplayedOnThePage();

        assertThat(squaresHeaders.get(0)).isEqualTo("B");
    }
}
