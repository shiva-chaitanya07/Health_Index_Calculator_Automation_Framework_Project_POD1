package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BloodPressurePage extends BasePage {

    public BloodPressurePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath="//div[@class='heading']/h2[contains(text(),'Blood Pressure')]")
    WebElement heading;

    @FindBy(xpath="//div[@class='agepara' and  contains(normalize-space(),'Abnormal blood pressure and an aging population')]")
    WebElement info;

    public boolean isHeadingPresent(){
        return heading.isDisplayed();
    }

    public boolean isInfoPresent(){
        return info.isDisplayed();
    }

    public boolean isTopNavPresent() {
        return topNav.isNavBarPresent();
    }

    public void goToHome() {
        topNav.goToHome();
    }

    public void goToHeartPulse() {
        topNav.goToHeartPulse();
    }

    public void goToAgeFactor() {
        topNav.goToAgeFactor();
    }

    public void goToTeamDetails() {
        topNav.goToTeamDetails();
    }
}
