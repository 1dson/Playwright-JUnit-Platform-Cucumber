package org.testing.framework.stepdefs;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testing.framework.Setup;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Search extends Setup {
//    World world;
//    Initialisation initialisation;
//
//    public Search(World world){
//        this.world = world;
//        this.initialisation = new Initialisation(world);
//    }
    @Before
    public void bef(){
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    @Given("I am on the google search page")
    public void iAmOnTheGoogleSearchPage() {
        page.navigate("https://www.google.com/");
    }

    @And("I search for {string}")
    public void iSearchFor(String searchString) {
//        world.setup.page.getByLabel("Search").click();
//        world.setup.page.getByLabel("Search").fill(searchString);
//        world.setup.page.getByLabel("Search").press("Enter");
    }

    @Then("I should see {string} text")
    public void iShouldSeeText(String searchString) {
//        assertEquals(searchString, world.setup.page.url());
    }
}