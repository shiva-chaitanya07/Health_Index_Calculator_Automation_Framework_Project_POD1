
package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TopNavigation;
import testBase.BaseTest;

import static org.testng.Assert.*;

public class TC002_HomePageValidationTest extends BaseTest {
    HomePage hp;
    TopNavigation tn;

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        // driver is guaranteed to be non-null after BaseTest.setUp
        hp = new HomePage(driver);
        tn = new TopNavigation(driver);
    }

    @Test(priority = 1, groups = {"Regression","Master","UI","Functionality"})
    void goToHomePage() {
        logger.info("**** Started TC002_HomePageValidationTest ****");
        try {
            logger.info("Navigating to homepage");
            tn.goToHome();
            String url = driver.getCurrentUrl();
            String accUrl = "https://hackvyatharth.github.io/Vitalguard_Team_Vanguardians/#container";
            logger.info("Current URL after navigation: " + url);
            assertEquals(url, accUrl, "Did not navigate to expected homepage URL");
            logger.info("Successfully navigated to homepage");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to homepage");
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 2, groups = {"Sanity","Master","UI"})
    void isLeftImagePresent() {
        try {
            logger.info("Validating the image in the left frame on Home page");
            assertTrue(hp.isLeftImagePresent(), "Left image not present");
            logger.info("Left image is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Left image not present");
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 3, groups = {"Regression","Master","UI"})
    void isFormHeadingPresent() {
        try {
            logger.info("Validating the calculator form heading on Home page");
            assertTrue(hp.isFormHeadingPresent(), "Form heading not present");
            logger.info("Form heading is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Form heading not present");
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 4, groups = {"Sanity","Master","UI"})
    void hasCalculatorFields() {
        try {
            logger.info("Validating the fields in the calculator form on Home page");
            assertTrue(hp.hasCalculatorFields(), "Fields are not present");
            logger.info("All required calculator form fields are present");
        } catch (AssertionError e) {
            logger.info("Test failed...Fields are not present");
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 5, groups = {"Regression","Master","UI"})
    void isTopNavPresent() {
        try {
            logger.info("Validating the presence of the top navigation bar on Home page");
            assertTrue(hp.isTopNavPresent(), "Top navigation bar not present");
            logger.info("Top navigation bar is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Top navigation bar not present");
            Assert.fail(e.getMessage());
        }
        logger.info("**** Finished TC002_HomePageValidationTest ****");
    }

//    @Test(priority = 1, groups = {"Regression","Master","Functionality"})
//    public void goToHomePage() {
//        logger.info("**** Starting TC003_HomePageFunctionalityTest ****");
//        try {
//            logger.info("Navigating to homepage via top navigation");
//            tn.goToHome();
//            String url = driver.getCurrentUrl();
//            String accUrl = "https://hackvyatharth.github.io/Vitalguard_Team_Vanguardians/#container";
//            logger.info("Current URL after navigation: " + url);
//            assertEquals(url, accUrl, "Did not navigate to homepage");
//            logger.info("Successfully navigated to homepage");
//        } catch (AssertionError e) {
//            logger.info("Test failed...Did not navigate to homepage");
//            Assert.fail(e.getMessage());
//        }
//    }

    @Test(priority = 2, groups = {"Sanity","Master","Functionality"})
    public void gotoHeartPulse() {
        try {
            logger.info("Navigating to Heart Pulse page from Home");
            hp.goToHeartPulse();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Heart Pulse: " + url);
            Assert.assertTrue(url.contains("#pulseRate"), "Did not navigate to Heart Pulse section");
            logger.info("Successfully navigated to Heart Pulse section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Heart Pulse page");
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 3, groups = {"Regression","Master","Functionality"})
    public void gotoBloodPressure() {
        try {
            logger.info("Navigating to Blood Pressure page from Home");
            hp.goToBloodPressure();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Blood Pressure: " + url);
            Assert.assertTrue(url.contains("#bloodPressure"), "Did not navigate to Blood Pressure section");
            logger.info("Successfully navigated to Blood Pressure section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Blood Pressure page");
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 4, groups = {"Sanity","Master","Functionality"})
    public void gotoAgeFactor() {
        try {
            logger.info("Navigating to Age Factor page from Home");
            hp.goToAgeFactor();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Age Factor: " + url);
            Assert.assertTrue(url.contains("#ageFactor"), "Did not navigate to Age Factor section");
            logger.info("Successfully navigated to Age Factor section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Age Factor page");
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 5, groups = {"Regression","Master","Functionality"})
    public void gotoTeamDetails() {
        try {
            logger.info("Navigating to Team Details page from Home");
            hp.goToTeamDetails();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Team Details: " + url);
            Assert.assertTrue(url.contains("#foot"), "Did not navigate to Team Details section");
            logger.info("Successfully navigated to Team Details section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Team Details page");
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 6, groups = {"Sanity","Master","Functionality"})
    public void goHomeViaLogoText() {
        try {
            logger.info("Navigating to Home page via logo text");
            hp.goHomeViaLogoText();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating via logo text: " + url);
            Assert.assertTrue(url.contains("#container"), "Did not navigate to Home via logo text");
            logger.info("Successfully navigated to Home via logo text");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Home via logo text");
            Assert.fail(e.getMessage());
        }
        logger.info("**** Finished TC003_HomePageFunctionalityTest ****");
    }

}
