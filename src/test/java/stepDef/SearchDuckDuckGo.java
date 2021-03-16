package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.StartPage;
import pages.ResultsPage;

import java.util.concurrent.TimeUnit;

public class SearchDuckDuckGo {

    String driverPath = "/usr/bin/geckodriver";
    WebDriver driver;
    WebDriverWait wait;
    StartPage startPageDdg;
    ResultsPage resultsPageddg;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", driverPath);
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, 10);
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

    @When("I search for nothing")
    public void iSearchForNothing() {
        startPageDdg.searchSomething("");
    }

    @When("I search {} using the {word} bang")
    public void iSearchUsingTheBang(String search, String bang) {
        startPageDdg.searchSomething(bang + " " + search);
    }

    @Then("DuckDuckGo shows the results first page")
    public void duckDuckGoShowsTheResultsFirstPage() {
        String url = driver.getCurrentUrl();
        resultsPageddg = new ResultsPage(driver);
        assertThat(url, StringContains.containsString("Selenium+automation"));
        Assert.assertTrue(resultsPageddg.checkResults("Selenium"));
    }

    @Then("DuckDuckGo redirects to the main page")
    public void duckDuckGoReloadsTheStartPage() {
        String url = driver.getCurrentUrl();
        assertThat(url, StringContains.containsString("https://duckduckgo.com"));
    }

    @Then("DuckDuckGo shows the results for {} in {word}")
    public void duckDuckGoShowsTheResultsInTheWebsite(String search, String website) {

        wait.until(ExpectedConditions.urlContains(website));
        String url = driver.getCurrentUrl();
        assertThat(url, StringContains.containsString(search));
    }


}
