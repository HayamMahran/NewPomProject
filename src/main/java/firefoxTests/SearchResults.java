package firefoxTests;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchResults {
    private final FirefoxDriver driver;
    private static final String ResultXpath = "(//a[@data-testid='result-title-a'])[4]";

    public SearchResults(FirefoxDriver driver) {
        this.driver =driver;
    }

    public String getFourthResult(){
        return driver.findElement(By.xpath(ResultXpath)).getText();
    }
}
