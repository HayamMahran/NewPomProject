import chromeTests.Home;
import chromeTests.SearchResults;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ChromeTests {

    /**
     * Test case for assert that the title of the page is "Google"
     * 1. Open the Chrome browser
     * 2. Navigate to "<a href="https://www.duckduckgo.com">duckduckgo.com</a>"
     * 3. Assert that the title of the page is "Google"
     * 4. Close the browser
     */
    private ChromeDriver driver;
    private Home home;
    private SearchResults SearchResults;

    @Test
    public void testTitle() {
        //test data
        String expectedTitle = "Google";
        //String actualTitle = home.getPageTitle();
        Assert.assertEquals(home.getPageTitle(), expectedTitle, "Title does not match!");
    }

    /**
     * Test case for assert that the logo is displayed
     * 1. Open the Chrome browser
     * 2. Navigate to "<a href="https://www.duckduckgo.com">duckduckgo.com</a>"
     * 3. Assert that the logo is displayed
     * 4. Close the browser
     */

    @Test
    public void testLogoDisplayed() {
        Assert.assertTrue(home.isLogoDisplayed(), "Logo is not displayed!");
    }

    /**
     * Test case for assert the first result in the search page is "Selenium WebDriver"
     * 1. Open the Chrome browser
     * 2. Navigate to "<a href="https://www.duckduckgo.com">duckduckgo.com</a>"
     * 3. Search for "Selenium"
     * 4. Assert that the first result is "Selenium WebDriver"
     * 5. Close the browser
     */

    @Test
    public void testFirstResult() {
        //test data
        String expectedFirstResultLink = "https://www.selenium.dev/documentation/webdriver/";
        home.search("Selenium WebDriver");
        //String actualFirstResultLink = SearchResults.getFirstResultLink();
        String actualFirstResultLink = SearchResults.getResultLinkusingIndex(1);
        Assert.assertEquals(actualFirstResultLink, expectedFirstResultLink, "First result does not match!");
    }

    /**
     * Test case for assert that the second result link contains "https://www.linkedin.com"
     * 1. Open the Chrome browser
     * 2. Navigate to "<a href="https://www.duckduckgo.com">duckduckgo.com</a>"
     * 3. Search for "Cucumber io"
     * 4. Assert that the second result link contains "https://www.linkedin.com"
     * 5. Close the browser
     */

    @Test
    public void testSecondResultLink() {
        //test data
        String expectedSecondResultLinkPart = "https://www.linkedin.com";
        home.search("Cucumber io");
        //String actualSecondResultLink = SearchResults.getSecondResultLink();
        String actualSecondResultLink = SearchResults.getResultLinkusingIndex(2);
        Assert.assertTrue(actualSecondResultLink.contains(expectedSecondResultLinkPart), "Second result link does not contain https://www.linkedin.com");
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.duckduckgo.com");
        home = new Home(driver);
        SearchResults = new SearchResults(driver);
    }

    @AfterMethod
    public void teardown() {
            driver.quit();
    }

}
