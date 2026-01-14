package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends BasePage {

    public ResultPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath="//div[@class='result-container']")
    WebElement resultBox;
    @FindBy(tagName = "h2")
    WebElement heading;
    @FindBy(id="healthbox")
    WebElement result;
    @FindBy(id="feedback")
    WebElement feedbackBox;
    public boolean isLogoPresent(){
        return topNav.isLogoPresent();
    }
    public boolean isLogoTextPresent(){
        return topNav.isLogoTextPresent();
    }
    public boolean isResultBoxPresent(){
        return resultBox.isDisplayed();
    }
    public boolean isHeadingPresent() {return heading.isDisplayed();}
    public boolean isResultDisplayed(){return result.isDisplayed();}
    public boolean isFeedbackBoxPresent(){return feedbackBox.isDisplayed();}
}
