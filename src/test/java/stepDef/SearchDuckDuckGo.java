package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.core.StringContains;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ResultsPage;
import pages.StartPage;

import java.util.concurrent.TimeUnit;


public class SearchDuckDuckGo {

    String driverPath = "/usr/bin/geckodriver";
    WebDriver driver;
    StartPage startPageDdg;
    ResultsPage resultsPageDdg;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("I go to DuckDuckGo start page")
    public void iGoToDuckDuckGoStartPage() {
        startPageDdg = new StartPage(driver);
        startPageDdg.goToStartPage();
    }

    @When("I search for something")
    public void iSearchForSomething() {
        startPageDdg.searchSomething("Selenium automation");
    }

    @Then("DuckDuckGo shows the results first page")
    public void duckDuckGoShowsTheResultsFirstPage() {
        String url = driver.getCurrentUrl();
        assertThat(url, StringContains.containsString("Selenium+automation"));
    }

}
