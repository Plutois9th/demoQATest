package settings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
public class SetP {
    private static void setLocalDriver() {
        pageLoadTimeout = 100000000;
        browser = "chrome";
        browserSize = "1200x800";
        headless = false;
//        proxyEnabled = true;
//        fileDownload = PROXY;
        downloadsFolder = "src/test/resources";
        var options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--allow-running-insecure-content");
        browserCapabilities = options;
    }
    @BeforeEach
    void init() {
        setLocalDriver();
    }


    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
