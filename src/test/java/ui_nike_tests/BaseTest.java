package ui_nike_tests;

import com.nike.driver.DriverSingleton;
import com.nike.utils.CookiesSettingsManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {
    static WebDriver driver;
    protected JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    protected WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeAll
    public static void setUp() {
        driver = DriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        CookiesSettingsManager cookiesSettingsManager = new CookiesSettingsManager(driver);
        cookiesSettingsManager.acceptAllPrivacyAndCookiePolicies();
    }

    @AfterAll
    public static void tearDown() {
        DriverSingleton.closeDriver();
    }
}
