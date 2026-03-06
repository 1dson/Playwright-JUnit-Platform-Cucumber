package wonderson.test.config;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrowserSetup {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    void initPlaywright(){
        playwright = Playwright.create();
    }

    public Page selectBrowser(String browserName) {
       boolean isHeadless = browserName.equalsIgnoreCase("headless");

        BrowserType browserType = switch (browserName.toLowerCase()) {
            case "headless", "chromium" -> playwright.chromium();
            case "firefox" -> playwright.firefox();
            case "webkit" -> playwright.webkit();
            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browserName + ". Options: headless, chromium, firefox, webkit"
            );
        };

        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
        context = browser.newContext();
        page = context.newPage();
        return page;
    }

    public void closeBrowseAndPage() {
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
