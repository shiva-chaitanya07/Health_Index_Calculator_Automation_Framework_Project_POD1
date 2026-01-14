package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.BaseTest;

import java.time.Duration;

public class CalculatorForm extends BasePage {
    WebDriverWait wait;
    public CalculatorForm(WebDriver driver){
        super(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(id="age")
    WebElement ageField;
    @FindBy(id="pulse") WebElement pulseField;
    @FindBy(id="bp") WebElement bpField;
    @FindBy(tagName="button") WebElement calculateBtn;
    @FindBy(xpath="//h2[normalize-space()='Health Index Calculator']")
    WebElement formHeading;
    public boolean isFormHeadingPresent(){return formHeading.isDisplayed();}
    public boolean isAgeFieldPresent(){return ageField.isDisplayed();}
    public boolean isPulseRateFieldPresent(){return pulseField.isDisplayed();}
    public boolean isBloodPressureFieldPresent(){return bpField.isDisplayed();}
    public boolean isButtonPresentAndClickable(){return calculateBtn.isDisplayed() && calculateBtn.isEnabled();}
    public void enterAge(String age) {
//        wait.until(ExpectedConditions.visibilityOf(ageField)).clear();
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
    public void clickCalculate() {calculateBtn.click();}
    public boolean isAgeFieldTakingValue(String age){
        enterAge(age);
        return !ageField.getAttribute("value").equals("");
    }
    public boolean isPulseRateFieldTakingValue(String pulse){
        enterPulse(pulse);
        return !pulseField.getAttribute("value").equals("");
    }
    public boolean isBloodPressureFieldTakingValue(String bp){
        enterBloodPressure(bp);
        return !bpField.getAttribute("value").equals("");
    }
}
