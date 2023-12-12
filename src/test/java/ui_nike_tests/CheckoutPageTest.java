package ui_nike_tests;

import com.nike.dto.ProductDto;
import com.nike.pages.ProductListingPage;
import org.junit.jupiter.api.Test;

class CheckoutPageTest extends BaseTest {

    ProductDto productDto = ProductDto.builder().build();

    //Test doesn't work since the problem with adding product to the basket
    @Test
    void checkThatSummaryContainsInfoAboutOrderedProduct() {
        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage
                .openProductListingTestPage()
                .getProductByConditionAndSaveItToProductDto(productCart -> productCart.getNumberOfColors() > 1, productDto)
                .clickOnTheProductCardByItsPosition(productDto.getProductPositionIndex())
                .selectAnyColorAndSaveItToProductDto(productDto)
                .selectAnyAvailableSizeAndSaveItToProductDto(productDto)
                .addProductToBag()
                .clickViewBagButtonInMiniBasketPopup();
    }
}
