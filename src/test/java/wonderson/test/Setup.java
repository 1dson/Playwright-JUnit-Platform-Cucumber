package wonderson.test;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.TestInstance;

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

    public Page selectBrowser(String browserName, Boolean headless) {
        BrowserType browserType = null;
        if (browserName.equals("Firefox")) {
            browserType = create().firefox();
        }
        if (browserName.equals("Chrome")) {
            browserType = create().chromium();
        }
        if (browserType == null) {
            throw new IllegalArgumentException("Browser " + browserName + "could not be launched");
        }
        if(headless == null){
            throw new IllegalArgumentException("You must specify if you want the browser is to be in headed or headless");
        }
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
        context = browser.newContext();
        page = context.newPage();
        return page;
    }

    public void closeBrowseAndPage(){
        if(browser != null)
            browser.close();
        if(page != null){
            page.close();
        }
    }
}