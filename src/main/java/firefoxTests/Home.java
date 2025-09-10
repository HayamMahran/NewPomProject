package firefoxTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Home {
    private FirefoxDriver driver;
    private static final By SearchField = By.id("searchbox_input");

    public Home(FirefoxDriver driver){
        this.driver = driver;
    }


    public void search(String searchData) {
        driver.findElement(SearchField).sendKeys(searchData, Keys.ENTER);
    }
}
