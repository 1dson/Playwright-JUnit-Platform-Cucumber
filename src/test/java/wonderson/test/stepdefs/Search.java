package wonderson.test.stepdefs;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import wonderson.test.Setup;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Search extends Setup {
    Page page;

    @Before
    public void setPage() {
        page = selectBrowser(System.getProperty("browser"));
    }

    @Given("I am on the google search page")
    public void iAmOnTheGoogleSearchPage() {
        page.navigate("https://www.google.com/");
    }

    @And("I search for {string}")
    public void iSearchFor(String searchString) {
        page.locator("//*[@id='L2AGLb']/div").click();
        page.locator("//*[@name='q']").fill(searchString);
        page.locator("//*[@name='q']").press("Enter");
    }

    @Then("I should see {string} text")
    public void iShouldSeeText(String searchString) {
        assertThat(page.getByText(searchString)).isVisible();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            Path path = Paths.get("target/screenshots/screenshot.png");
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(path));
            try (InputStream is = Files.newInputStream(path)) {
                Allure.attachment("image.png", is);
            }
        }
        closeBrowseAndPage();
    }
}