package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    WebDriver driver;

    @FindBy(className = "c-base__title")
    WebElement txtInstantAnswer;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getInstantAnswerTitle() {
        txtInstantAnswer.getText();
    }

}
