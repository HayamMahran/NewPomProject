package chromeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResults {
    private static WebDriver driver;
//    private static final String firstResultXPath = "(//a[@data-testid='result-title-a'])[1]";
//    private static final String secondResultXPath = "(//a[@data-testid='result-title-a'])[2]";
    private static final String ResultXpath = "(//a[@data-testid='result-title-a'])";

    public SearchResults(WebDriver driver) {
        this.driver = driver;
    }

//    public String getFirstResultLink(){
//        return driver.findElement(By.xpath(firstResultXPath)).getDomAttribute("href");
//    }
//
//    public String getSecondResultLink() {
//        return driver.findElement(By.xpath(secondResultXPath)).getDomAttribute("href");
//    }

    public static String getResultLinkusingIndex(int index) {
        return driver.findElement(By.xpath(ResultXpath+"["+index+"]")).getDomAttribute("href");
    }
}
