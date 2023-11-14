package settings;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
public class SetP {
    private static void setLocalDriver() {
        pageLoadTimeout = 100000000;
        browser = "chrome";
        browserSize = "1500x1000";
        headless = false;
//        proxyEnabled = true;
//        fileDownload = PROXY;
        downloadsFolder = "src/test/resources";
        var options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--allow-running-insecure-content");
        browserCapabilities = options;
        remote = "http://localhost:4444/wd/hub";
    }
    @BeforeEach
    void init() {
        setLocalDriver();
    }


    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
    @BeforeAll
    static void setUp() {
        var allureSelenide = new AllureSelenide()
                .screenshots(true)
                .savePageSource(true);
        SelenideLogger.addListener("AllureSelenide", allureSelenide);
    }
}

