package com.nike.validation;

import com.nike.components.filter.filter_enums.ShopByPriceFilterOptions;
import com.nike.elements.product_listing.ProductCart;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductListingPageValidator extends BaseValidator {
    public ProductListingPageValidator() {
    }

    public void checkThatAllProductsCorrespondToAppliedPriceFilter(List<ProductCart> productCartsList, ShopByPriceFilterOptions appliedFilterOption) {
        productCartsList.forEach(productCart -> {
            float productPrice = productCart.doesProductHaveReducedPrice() ? productCart.getReducedPrice() : productCart.getBasicPrice();
            assertThat(productPrice).isGreaterThanOrEqualTo(appliedFilterOption.getMinPrice());
            assertThat(productPrice).isLessThanOrEqualTo(appliedFilterOption.getMaxPrice());
        });
    }

    public void checkThatProductCardHasAllRequiredInfo(ProductCart productCart) {
        assertThat(productCart.getName()).matches("^[a-zA-Z0-9\\s'-]+$");
        assertThat(productCart.getSubtitle()).matches("^[a-zA-Z\\s'-]+$");
        assertThat(productCart.getNumberOfColors()).isGreaterThanOrEqualTo(1);
        assertThat(productCart.getBasicPrice()).isGreaterThanOrEqualTo(0.01f);
    }
}
