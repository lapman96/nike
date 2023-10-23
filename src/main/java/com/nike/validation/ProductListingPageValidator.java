package com.nike.validation;

import com.nike.dto.ProductDto;
import com.nike.elements.Product;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductListingPageValidator extends BaseValidator{
    public ProductListingPageValidator() {
    }

    public void compareProducts(Product actualResult, ProductDto expectedResult) {
        assertThat(actualResult.getLabel()).isEqualTo(expectedResult.getLabel());
        assertThat(actualResult.getName()).isEqualTo(expectedResult.getName());
        assertThat(actualResult.getSubtitle()).isEqualTo(expectedResult.getSubtitle());
        assertThat(actualResult.getNumberOfColors()).isEqualTo(expectedResult.getNumberOfColours());
        assertThat(actualResult.getPrice()).isEqualTo(expectedResult.getPrice());
        assertThat(actualResult.getReducedPrice()).isEqualTo(expectedResult.getReducedPrice());
        assertThat(actualResult.getPercentageOfDiscount()).isEqualTo(expectedResult.getPercentageOfDiscount());
    }
}
