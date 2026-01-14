package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;

public class TopNavigation {
    WebDriver driver;

    public TopNavigation(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//div[@class='logo']/img")
    WebElement logo;
    @FindBy(xpath="//div[@class='logo']/a")
    WebElement logoText;
    @FindBy(xpath="//div[@class='nav-links']/a[text()='Home']")
    WebElement homeField;
    @FindBy(xpath="//div[@class='nav-links']/a[text()='Heart Pulse']")
    WebElement heartPulseField;
    @FindBy(xpath="//div[@class='nav-links']/a[text()='Blood Pressure']")
    WebElement bloodPressureField;
    @FindBy(xpath="//div[@class='nav-links']/a[text()='Age Factor']")
    WebElement ageFactorField;
    @FindBy(xpath="//div[@class='nav-links']/a[text()='Team Details']")
    WebElement teamDetailsField;
    public boolean isLogoPresent(){
        return logo.isDisplayed();
    }
    public boolean isLogoTextPresent(){
        return logoText.isDisplayed();
    }
    public boolean isHomeFiledDisplayed(){
        return homeField.isDisplayed();
    }
    public boolean isHeartPulseFieldPresent(){
        return heartPulseField.isDisplayed();
    }
    public boolean isBloodPressureFieldPresent(){
        return bloodPressureField.isDisplayed();
    }
    public boolean isAgeFactorFieldPresent(){
        return ageFactorField.isDisplayed();
    }
    public boolean isTeamDetailsFieldPresent(){
        return teamDetailsField.isDisplayed();
    }
    public boolean isNavBarPresent(){
        return isLogoPresent() &&
                isLogoTextPresent() &&
                isHomeFiledDisplayed() &&
                isHeartPulseFieldPresent() &&
                isBloodPressureFieldPresent() &&
                isAgeFactorFieldPresent() &&
                isTeamDetailsFieldPresent();
    }

    public void clickLogoText() { logoText.click(); }
    public void goToHome(){homeField.click();}
    public void goToHeartPulse() { heartPulseField.click(); }
    public void goToBloodPressure() { bloodPressureField.click(); }
    public void goToAgeFactor() { ageFactorField.click(); }
    public void goToTeamDetails() { teamDetailsField.click(); }
}


