package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HeartPulsePage extends BasePage{

    public HeartPulsePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath="//div[@class='heading']/h2[contains(text(),'heart rate')]")
    WebElement  heading;
    @FindBy(xpath="//div[@class='agepara']/h4")
    WebElement subHeading;
    @FindBy(xpath="//div[@class='agepara' and  contains(normalize-space(),'A healthy heart ')]")
    WebElement info;
    @FindBy(xpath="//div[@class='agepara']/img")
    WebElement table;
    public boolean isHeadingPresent(){
        return heading.isDisplayed();
    }
    public boolean isSubHeadingPresent(){
        return subHeading.isDisplayed();
    }
    public boolean isInfoPresent(){
        return info.isDisplayed();
    }
    public boolean isTablePresent(){
        return table.isDisplayed();
    }
    public boolean isTopNavPresent() {
        return topNav.isNavBarPresent();
    }

    public void goToHome() {
        topNav.goToHome();
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

}
