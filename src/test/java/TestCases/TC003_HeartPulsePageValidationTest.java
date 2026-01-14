
package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeartPulsePage;
import pages.TopNavigation;
import testBase.BaseTest;

public class TC003_HeartPulsePageValidationTest extends BaseTest {
    HeartPulsePage hp;
    TopNavigation tn;

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        // driver is guaranteed to be non-null after BaseTest.setUp
        hp = new HeartPulsePage(driver);
        tn = new TopNavigation(driver);
    }

    @Test(priority = 1, groups = {"Regression","Master","UI","Functionality"})
    public void goToHeartPulse() {
        logger.info("**** Started TC004_HeartPulsePageValidationTest ****");
        try {
            logger.info("Navigating to Heart Pulse section");
            tn.goToHeartPulse();
            String url = driver.getCurrentUrl();
            logger.info("Current URL: " + url);
            Assert.assertTrue(url.contains("#pulseRate"), "Did not navigate to Heart Pulse section");
            logger.info("Successfully navigated to Heart Pulse section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Heart Pulse section");
            Assert.fail();
        }
    }

    @Test(priority = 2, groups = {"Sanity","Master","UI"})
    public void isTopNavPresent() {
        try {
            logger.info("Validating the presence of top navigation bar on Heart Pulse page");
            Assert.assertTrue(hp.isTopNavPresent(), "Top navigation bar not present on Heart Pulse page");
            logger.info("Top navigation bar is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Top navigation bar not present on Heart Pulse page");
            Assert.fail();
        }
    }

    @Test(priority = 3, groups = {"Regression","Master","UI"})
    public void isHeadingPresent() {
        try {
            logger.info("Validating the main heading on Heart Pulse page");
            Assert.assertTrue(hp.isHeadingPresent(), "Main heading not present on Heart Pulse page");
            logger.info("Main heading is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Main heading not present on Heart Pulse page");
            Assert.fail();
        }
    }

    @Test(priority = 4, groups = {"Sanity","Master","UI"})
    public void isSubHeadingPresent() {
        try {
            logger.info("Validating the sub-heading on Heart Pulse page");
            Assert.assertTrue(hp.isSubHeadingPresent(), "Sub-heading not present on Heart Pulse page");
            logger.info("Sub-heading is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Sub-heading not present on Heart Pulse page");
            Assert.fail();
        }
    }

    @Test(priority = 5, groups = {"Regression","Master","UI"})
    public void isInfoPresent() {
        try {
            logger.info("Validating the informational text/description on Heart Pulse page");
            Assert.assertTrue(hp.isInfoPresent(), "Informational text not present on Heart Pulse page");
            logger.info("Informational text is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Informational text not present on Heart Pulse page");
            Assert.fail();
        }
    }

    @Test(priority = 6, groups = {"Sanity","Master","UI"})
    public void isTablePresent() {
        try {
            logger.info("Validating the pulse rate table on Heart Pulse page");
            Assert.assertTrue(hp.isTablePresent(), "Pulse rate table not present on Heart Pulse page");
            logger.info("Pulse rate table is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Pulse rate table not present on Heart Pulse page");
            Assert.fail();
        }
        logger.info("**** Finished TC004_HeartPulsePageValidationTest ****");
    }

//    @Test(priority = 1, groups = {"Regression","Master","Functionality"})
//    public void goToHeartPulse() {
//        logger.info("**** Started TC005_HeartPulseFunctionalityTest ****");
//        try {
//            logger.info("Navigating to Heart Pulse section from top navigation");
//            tn.goToHeartPulse();
//            String url = driver.getCurrentUrl();
//            logger.info("Current URL after navigation: " + url);
//            Assert.assertTrue(url.contains("#pulseRate"), "Did not navigate to Heart Pulse section");
//            logger.info("Successfully navigated to Heart Pulse section");
//        } catch (AssertionError e) {
//            logger.info("Test failed...did not navigate to Heart Pulse section");
//            Assert.fail();
//        }
//    }

    @Test(priority = 2, groups = {"Sanity","Master","Functionality"})
    public void gotoHome() {
        try {
            logger.info("Navigating to Home section from Heart Pulse page");
            hp.goToHome();
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
    public void gotoBloodPressure() {
        try {
            logger.info("Navigating to Blood Pressure section from Heart Pulse/Home");
            hp.goToBloodPressure();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Blood Pressure: " + url);
            Assert.assertTrue(url.contains("#bloodPressure"), "Did not navigate to Blood Pressure section");
            logger.info("Successfully navigated to Blood Pressure section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Blood Pressure section");
            Assert.fail();
        }
    }

    @Test(priority = 4, groups = {"Sanity","Master","Functionality"})
    public void gotoAgeFactor() {
        try {
            logger.info("Navigating to Age Factor section");
            hp.goToAgeFactor();
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
            hp.goToTeamDetails();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Team Details: " + url);
            Assert.assertTrue(url.contains("#foot"), "Did not navigate to Team Details section");
            logger.info("Successfully navigated to Team Details section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Team Details section");
            Assert.fail();
        }
        logger.info("**** Finished TC005_HeartPulseFunctionalityTest ****");
    }

}
