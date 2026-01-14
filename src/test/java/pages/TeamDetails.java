package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamDetails {
    WebDriver driver;
    TopNavigation topNav;
    public TeamDetails(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.topNav=new TopNavigation(driver);
    }
    @FindBy(xpath="//footer/h3")
    WebElement heading;

    @FindBy(tagName = "ul")
    WebElement teamMembers;

    public boolean isHeadingPresent(){
        return heading.isDisplayed();
    }

    public boolean isTeamDetailsPresent(){
        return teamMembers.isDisplayed();
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

    public void goToBloodPressure() {
        topNav.goToBloodPressure();
    }
}
