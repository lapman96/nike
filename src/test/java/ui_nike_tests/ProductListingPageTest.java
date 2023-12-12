package ui_nike_tests;

import com.nike.components.filter.filter_enums.ShopByPriceFilterOptions;
import com.nike.elements.product_listing.ProductCart;
import com.nike.pages.ProductListingPage;
import com.nike.validation.ProductListingPageValidator;
import org.junit.jupiter.api.Test;
import java.util.List;

class ProductListingPageTest extends BaseTest {
    ProductListingPageValidator validator = new ProductListingPageValidator();

    @Test
    void checkThatProductCartHasAllRequiredInfo() {
        ProductListingPage productListingPage = new ProductListingPage(driver);
        ProductCart productCart = productListingPage
                .openProductListingTestPage()
                .getFirstProductOnThePageAsProductCart();

        validator.checkThatProductCardHasAllRequiredInfo(productCart);
    }

    @Test
    void checkApplyingPriceFilter() {
        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage
                .openProductListingTestPage()
                .getFilter().applyShopByPriceFilter(ShopByPriceFilterOptions.FROM_FIFTY_TO_ONE_HUNDRED);
        List<ProductCart> productCarts = productListingPage.getProducts();

        validator.checkThatAllProductsCorrespondToAppliedPriceFilter(productCarts, ShopByPriceFilterOptions.FROM_FIFTY_TO_ONE_HUNDRED);
    }
}
