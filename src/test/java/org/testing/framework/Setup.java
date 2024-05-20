package org.testing.framework;

import com.microsoft.playwright.*;
import io.cucumber.java.*;
import org.junit.jupiter.api.TestInstance;

// Subclasses will inherit PER_CLASS behavior.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Setup {
    // Shared between all tests in the class.
    Playwright playwright;
    public Browser browser;
    // New instance for each test method.
    public
    BrowserContext context;
    public Page page;
//    public void configureBrowser() {
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//    }

//    public void closeBrowser() {
//        playwright.close();
//    }

//    public void createContextAndPage() {
//        context = browser.newContext();
//        page = context.newPage();
//    }

//    public void closeContext() {
//        context.close();
//    }
}