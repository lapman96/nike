import com.nike.dto.ProductDto;
import com.nike.dto.ProductDtoBuilder;
import com.nike.elements.Product;
import com.nike.pages.Homepage;
import com.nike.validation.ProductListingPageValidator;
import org.junit.jupiter.api.Test;


class ProductCardsTest extends BaseTest {
    ProductListingPageValidator validator = new ProductListingPageValidator();

    @Test
    void checkProductCardWithAllFields() throws InterruptedException {
        ProductDto expectedResult = new ProductDtoBuilder()
                .setLabel("Sustainable Materials")
                .setName("Nike Air Force 1 '07 NN")
                .setSubtitle("Women's Shoes")
                .setNumberOfColours(1)
                .setPrice(119.99f)
                .setReducedPrice(83.97f)
                .setPercentageOfDiscount(30)
                .build();

        Homepage homepage = new Homepage(driver);
        Product actualResult = homepage
                .openHomepage()
                .executeSearch("Nike Air Force 1")
                .getProduct(product -> product.getName().equals("Nike Air Force 1 '07 NN"));

        validator.compareProducts(actualResult, expectedResult);
    }
}
