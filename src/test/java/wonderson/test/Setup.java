package wonderson.test;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static com.microsoft.playwright.Playwright.create;

// Subclasses will inherit PER_CLASS behavior.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Setup {
    // Shared between all tests in the class.
    Playwright playwright;
    Browser browser;
    // New instance for each test method.
    BrowserContext context;
    Page page;

    public Page selectBrowser(String browserName) {
        boolean runInHeadlessMode = false;
        BrowserType browserType;
        switch (browserName) {
            case "headless":
                runInHeadlessMode = true;
                browserType = create().chromium();
                break;
            case "firefox":
                browserType = create().firefox();
                break;
            case "chromium":
                browserType = create().chromium();
                break;
            default:
                throw new IllegalArgumentException("Browser " + browserName + " not found, options are 1)headless 2)firefox 3)chromium");
        }
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(runInHeadlessMode));
        context = browser.newContext();
        page = context.newPage();
        return page;
    }

    public void closeBrowseAndPage() {
        if (browser != null)
            browser.close();
        if (page != null) {
            page.close();
        }
    }
}
