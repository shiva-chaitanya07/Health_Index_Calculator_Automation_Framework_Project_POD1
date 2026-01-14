package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath="//div[@class='image']/img")
     WebElement image;
    @FindBy(css=".calc") WebElement calculatorForm;
    @FindBy(xpath="//h2[normalize-space()='Health Index Calculator']")
     WebElement formHeading;
    @FindBy(id="age")
     WebElement ageField;
    @FindBy(id="pulse")
     WebElement pulseField;
    @FindBy(id="bp")
     WebElement bpField;
    @FindBy(tagName="button")
     WebElement calculateBtn;


    public boolean isLeftImagePresent() { return image.isDisplayed(); }

    public boolean isFormHeadingPresent() { return formHeading.isDisplayed(); }

    public boolean hasCalculatorFields() {
        return ageField.isDisplayed()
                && pulseField.isDisplayed()
                && bpField.isDisplayed()
                && calculateBtn.isDisplayed();
    }

    public boolean isTopNavPresent() {
        return topNav.isNavBarPresent();
    }


    public void enterAge(String age) {
        ageField.clear();
        ageField.sendKeys(age);
   }

    public void enterPulse(String pulse) {
        pulseField.clear();
        pulseField.sendKeys(pulse);
    }

    public void enterBloodPressure(String bp) {
        bpField.clear();
        bpField.sendKeys(bp);
    }

    public void clickCalculate() {
        calculateBtn.click();
    }



    public void goToHeartPulse() {
        topNav.goToHeartPulse();
    }

    public void goToBloodPressure() {
        topNav.goToBloodPressure();
    }

    public void goToAgeFactor() {
        topNav.goToAgeFactor();
    }

    public void goToTeamDetails() {
        topNav.goToTeamDetails();
    }

    public void goHomeViaLogoText() {
        topNav.clickLogoText();
    }

}
