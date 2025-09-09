package chromeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Home {
    private static WebDriver driver;
    private static final By logoXPath = By.xpath("//div[contains(@class,'headerWrapMobile')]//img");
    private static final By SearchField = By.id("searchbox_input");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isLogoDisplayed() {
       return driver.findElement(logoXPath).isDisplayed();
    }

    public void search(String searchData) {
        driver.findElement(SearchField).sendKeys(searchData, Keys.ENTER);
    }
}
