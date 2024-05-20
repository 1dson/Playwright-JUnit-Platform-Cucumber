//package wonderson.testing.framework;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class SearchTest extends Setup {
//    @Test
//    public void iAmOnTheGoogleSearchPage() {
//        page.navigate("https://www.google.com/");
//            page.locator("//*[@id=\"L2AGLb\"]/div").click();
//
//        page.locator("//*[@name=\"q\"]").fill("searchString");
//        page.locator("//*[@name=\"q\"]").press("Enter");
////        assertEquals("searchString", page.url());
//    }
//}