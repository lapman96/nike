package ui_nike_tests;

import com.nike.pages.ProductListingPage;
import com.nike.validation.ProductListingPageValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

class SearchTest extends BaseTest {
    ProductListingPageValidator validator = new ProductListingPageValidator();

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/searchExistingProductsTest.csv", numLinesToSkip = 1)
    void checkTheAbilityToSearchExistingProducts(String searchQuery) {
        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage
                .openProductListingTestPage()
                .getHeader()
                .executeSearch(searchQuery);

        validator.checkThatThereIsAtLeastOneProductOnThePage(productListingPage);
    }

    @ParameterizedTest
    @CsvSource({"bgfjgfgf", "invalid search query", "2535353453"})
    void searchNonExistingProducts(String searchQuery) {
        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage
                .openProductListingTestPage()
                .getHeader()
                .executeSearch(searchQuery);

        assertThat(productListingPage.hasAtLeastOneProductOnThePage()).isFalse();
    }
}