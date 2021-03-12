package junit;

import io.cucumber.java.After;
import org.hamcrest.core.StringContains;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.StartPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestSearchDuckDuckGo {

    String driverPath = "/usr/bin/geckodriver";
    WebDriver driver;
    WebDriverWait wait;
    StartPage startPageDdg;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", driverPath);
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @org.junit.After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testCommonSearch() {
        startPageDdg = new StartPage(driver);
        startPageDdg.goToStartPage();
        startPageDdg.searchSomething("Selenium automation");
        String url = driver.getCurrentUrl();
        assertThat(url, StringContains.containsString("Selenium+automation"));
    }
}
