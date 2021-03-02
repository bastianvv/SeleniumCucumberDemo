package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    WebDriver driver;

    @FindBy(name = "q")
    WebElement txtSearch;

    @FindBy(id = "search_button_homepage")
    WebElement btnSearch;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToStartPage() {
        driver.get("http://start.duckduckgo.com");
    }

    public void searchSomething(String search) {
        txtSearch.sendKeys(search);
        btnSearch.click();
    }


}
