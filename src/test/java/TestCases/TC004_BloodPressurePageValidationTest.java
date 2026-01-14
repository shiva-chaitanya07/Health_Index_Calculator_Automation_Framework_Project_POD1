
package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BloodPressurePage;
import pages.TopNavigation;
import testBase.BaseTest;

import static org.testng.Assert.assertTrue;

public class TC004_BloodPressurePageValidationTest extends BaseTest {
    BloodPressurePage bp;
    TopNavigation tn;

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        // driver is guaranteed to be non-null after BaseTest.setUp
        bp = new BloodPressurePage(driver);
        tn = new TopNavigation(driver);
    }

    @Test(priority = 1, groups = {"Regression","Master","UI","Functionality"})
    public void goToBloodPressure() {
        logger.info("**** Started TC006_BloodPressurePageValidationTest ****");
        try {
            logger.info("Navigating to Blood Pressure section via top navigation");
            tn.goToBloodPressure();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigation: " + url);
            Assert.assertTrue(url.contains("#bloodPressure"), "Did not navigate to Blood Pressure section");
            logger.info("Successfully navigated to Blood Pressure section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Blood Pressure section");
            Assert.fail();
        }
    }

    @Test(priority = 2, groups = {"Sanity","Master","UI"})
    public void isTopNavPresent() {
        try {
            logger.info("Validating the presence of the top navigation bar on Blood Pressure page");
            Assert.assertTrue(bp.isTopNavPresent(), "Top navigation bar should be present on Blood Pressure page");
            logger.info("Top navigation bar is present on Blood Pressure page");
        } catch (AssertionError e) {
            logger.info("Test failed...Top navigation bar not present on Blood Pressure page");
            Assert.fail();
        }
    }

    @Test(priority = 3, groups = {"Regression","Master","UI"})
    public void isHeadingPresent() {
        try {
            logger.info("Validating the main heading on Blood Pressure page");
            Assert.assertTrue(bp.isHeadingPresent(), "Heading should be present on Blood Pressure page");
            logger.info("Main heading is present on Blood Pressure page");
        } catch (AssertionError e) {
            logger.info("Test failed...Heading not present on Blood Pressure page");
            Assert.fail();
        }
    }

    @Test(priority = 4, groups = {"Sanity","Master","UI"})
    public void isInfoPresent() {
        try {
            logger.info("Validating the informational content/description on Blood Pressure page");
            Assert.assertTrue(bp.isInfoPresent(), "Informational content should be present on Blood Pressure page");
            logger.info("Informational content is present on Blood Pressure page");
        } catch (AssertionError e) {
            logger.info("Test failed...Informational content not present on Blood Pressure page");
            Assert.fail();
        }
        logger.info("**** Finished TC006_BloodPressurePageValidationTest ****");
    }

//    @Test(priority = 1, groups = {"Regression","Master","Functionality"})
//    public void goToBloodPressure() {
//        logger.info("**** Started TC007_BloodPressureFunctionalityTest ****");
//        try {
//            logger.info("Navigating to Blood Pressure section via top navigation");
//            tn.goToBloodPressure();
//            String url = driver.getCurrentUrl();
//            logger.info("Current URL after navigation: " + url);
//            Assert.assertTrue(url.contains("#bloodPressure"), "Did not navigate to Blood Pressure section");
//            logger.info("Successfully navigated to Blood Pressure section");
//        } catch (AssertionError e) {
//            logger.info("Test failed...did not navigate to Blood Pressure section");
//            Assert.fail();
//        }
//    }

    @Test(priority = 2, groups = {"Sanity","Master","Functionality"})
    public void gotoHome() {
        try {
            logger.info("Navigating to Home section from Blood Pressure page");
            bp.goToHome();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Home: " + url);
            Assert.assertTrue(url.contains("#container"), "Did not navigate to Home section");
            logger.info("Successfully navigated to Home section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Home section");
            Assert.fail();
        }
    }

    @Test(priority = 3, groups = {"Regression","Master","Functionality"})
    public void gotoHeartPulse() {
        try {
            logger.info("Navigating to Heart Pulse section from Blood Pressure/Home");
            bp.goToHeartPulse();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Heart Pulse: " + url);
            Assert.assertTrue(url.contains("#pulseRate"), "Did not navigate to Heart Pulse section");
            logger.info("Successfully navigated to Heart Pulse section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Heart Pulse section");
            Assert.fail();
        }
    }

    @Test(priority = 4, groups = {"Sanity","Master","Functionality"})
    public void gotoAgeFactorPage() {
        try {
            logger.info("Navigating to Age Factor section from Blood Pressure/Heart Pulse");
            bp.goToAgeFactor();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Age Factor: " + url);
            Assert.assertTrue(url.contains("#ageFactor"), "Did not navigate to Age Factor section");
            logger.info("Successfully navigated to Age Factor section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Age Factor section");
            Assert.fail();
        }
    }

    @Test(priority = 5, groups = {"Regression","Master","Functionality"})
    public void gotoTeamDetails() {
        try {
            logger.info("Navigating to Team Details section");
            bp.goToTeamDetails();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Team Details: " + url);
            Assert.assertTrue(url.contains("#foot"), "Did not navigate to Team Details section");
            logger.info("Successfully navigated to Team Details section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Team Details section");
            Assert.fail();
        }
        logger.info("**** Finished TC007_BloodPressureFunctionalityTest ****");
    }

}
