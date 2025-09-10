import firefoxTests.Home;
import firefoxTests.SearchResults;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirefoxTests {
    /**
     * Test case for assert that the fourth result is "TestNG Tutorial"
     * 1. Open the Firefox browser
     * 2. Navigate to "<a href="https://www.duckduckgo.com">duckduckgo.com</a>"
     * 3. Search for "TestNG"
     * 4. Assert that the fourth result is "TestNG Tutorial"
     * 5. Close the browser
     */

    private FirefoxDriver driver;
    private Home home;
    private SearchResults SearchResults;

    @Test
    public void testFourthResult() {
        //test data
        String expectedFourthResul = "TestNG Tutorial";
        home.search("TestNG");
        String actualFourthResult = SearchResults.getFourthResult();
        Assert.assertEquals(actualFourthResult, expectedFourthResul, "Fourth result does not match!");
    }

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.duckduckgo.com");
        home = new Home(driver);
        SearchResults = new SearchResults(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
