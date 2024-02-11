package ui_nike_tests;

import com.nike.dto.ProductDTO;
import com.nike.pages.ProductListingPage;
import org.junit.jupiter.api.Test;

class CheckoutPageTest extends BaseTest {

    ProductDTO productDto = ProductDTO.builder().build();

    //Test doesn't work since the problem with adding product to the basket
    @Test
    void checkThatSummaryContainsInfoAboutOrderedProduct() {
        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage
                .openProductListingTestPage()
                .getFirstProductAndSaveItToProductDto(productDto)
                .clickOnTheProductCardByItsPosition(productDto.getProductPositionIndex())
                .selectAnyColorAndSaveItToProductDto(productDto)
                .selectAnyAvailableSizeAndSaveItToProductDto(productDto)
                .addProductToBag()
                .clickViewBagButtonInMiniBasketPopup();
    }
}
