
package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AgeFactorPage;
import pages.TopNavigation;
import testBase.BaseTest;

import static org.testng.Assert.assertTrue;

public class TC005_AgeFactorPageValidation extends BaseTest {
    AgeFactorPage af;
    TopNavigation tp;

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        // driver is guaranteed to be non-null after BaseTest.setUp
        af = new AgeFactorPage(driver);
        tp = new TopNavigation(driver);
    }

    @Test(priority = 1, groups = {"Regression","Master","UI","Functionality"})
    public void goToAgeFactor() {
        logger.info("**** Started TC008_AgeFactorPageValidation ****");
        try {
            logger.info("Navigating to Age Factor section via top navigation");
            tp.goToAgeFactor();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigation: " + url);
            Assert.assertTrue(url.contains("#ageFactor"), "Did not navigate to Age Factor section");
            logger.info("Successfully navigated to Age Factor section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Age Factor section");
            Assert.fail();
        }
    }

    @Test(priority = 2, groups = {"Sanity","Master","UI"})
    public void isTopNavPresent() {
        try {
            logger.info("Validating the presence of the top navigation bar on Age Factor page");
            Assert.assertTrue(af.isTopNavPresent(), "Top navigation bar should be present on Age Factor page");
            logger.info("Top navigation bar is present on Age Factor page");
        } catch (AssertionError e) {
            logger.info("Test failed...Top navigation bar not present on Age Factor page");
            Assert.fail();
        }
    }

    @Test(priority = 3, groups = {"Regression","Master","UI"})
    public void isHeadingPresent() {
        try {
            logger.info("Validating the main heading on Age Factor page");
            Assert.assertTrue(af.isHeadingPresent(), "Heading should be present on Age Factor page");
            logger.info("Main heading is present on Age Factor page");
        } catch (AssertionError e) {
            logger.info("Test failed...Heading not present on Age Factor page");
            Assert.fail();
        }
    }

    @Test(priority = 4, groups = {"Sanity","Master","UI"})
    public void isInfoPresent() {
        try {
            logger.info("Validating the informational content/description on Age Factor page");
            Assert.assertTrue(af.isInfoPresent(), "Informational content should be present on Age Factor page");
            logger.info("Informational content is present on Age Factor page");
        } catch (AssertionError e) {
            logger.info("Test failed...Informational content not present on Age Factor page");
            Assert.fail();
        }
        logger.info("**** Finished TC008_AgeFactorPageValidation ****");
    }

//    @Test(priority = 1, groups = {"Regression","Master","Functionality"})
//    public void goToAgeFactor() {
//        logger.info("**** Started TC009_AgeFactorPageFunctionalityValidation ****");
//        try {
//            logger.info("Navigating to Age Factor section via top navigation");
//            tp.goToAgeFactor();
//            String url = driver.getCurrentUrl();
//            logger.info("Current URL after navigating to Age Factor: " + url);
//            Assert.assertTrue(url.contains("#ageFactor"), "Did not navigate to Age Factor section");
//            logger.info("Successfully navigated to Age Factor section");
//        } catch (AssertionError e) {
//            logger.info("Test failed...did not navigate to Age Factor section");
//            Assert.fail();
//        }
//    }

    @Test(priority = 2, groups = {"Sanity","Master","Functionality"})
    public void gotoHome() {
        try {
            logger.info("Navigating to Home section from Age Factor page");
            af.goToHome();
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
            logger.info("Navigating to Heart Pulse section from Age Factor/Home");
            af.goToHeartPulse();
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
    public void gotoBloodPressure() {
        try {
            logger.info("Navigating to Blood Pressure section from Age Factor/Heart Pulse");
            af.goToBloodPressure();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Blood Pressure: " + url);
            Assert.assertTrue(url.contains("#bloodPressure"), "Did not navigate to Blood Pressure section");
            logger.info("Successfully navigated to Blood Pressure section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Blood Pressure section");
            Assert.fail();
        }
    }

    @Test(priority = 5, groups = {"Regression","Master","Functionality"})
    public void gotoTeamDetails() {
        try {
            logger.info("Navigating to Team Details section from Age Factor");
            af.goToTeamDetails();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Team Details: " + url);
            Assert.assertTrue(url.contains("#foot"), "Did not navigate to Team Details section");
            logger.info("Successfully navigated to Team Details section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Team Details section");
            Assert.fail();
        }
        logger.info("**** Finished TC009_AgeFactorPageFunctionalityValidation ****");
    }

}
