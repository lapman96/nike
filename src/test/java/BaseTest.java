import com.nike.components.CookiesPopup;
import com.nike.driver.DriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public abstract class BaseTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = DriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
        CookiesPopup cookiesPopup = new CookiesPopup(driver);
        cookiesPopup.acceptAllCookies();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}
