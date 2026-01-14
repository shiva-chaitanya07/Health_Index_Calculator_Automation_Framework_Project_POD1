
package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TeamDetails;
import pages.TopNavigation;
import testBase.BaseTest;

import static org.testng.Assert.assertTrue;

public class TC006_TeamDetailsPageValidation extends BaseTest {
    TeamDetails td;
    TopNavigation tn;

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        // driver is guaranteed to be non-null after BaseTest.setUp
        td = new TeamDetails(driver);
        tn = new TopNavigation(driver);
    }

    @Test(priority = 1, groups = {"Regression","Master","UI","Functionality"})
    public void goToTeamDetails() {
        logger.info("**** Started TC010_TeamDetailsPageValidation ****");
        try {
            logger.info("Navigating to Team Details section via top navigation");
            tn.goToTeamDetails();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Team Details: " + url);
            Assert.assertTrue(url.contains("#foot"), "Did not navigate to Team Details section");
            logger.info("Successfully navigated to Team Details section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Team Details section");
            Assert.fail();
        }
    }

    @Test(priority = 2, groups = {"Sanity","Master","UI"})
    public void isTopNavPresent() {
        try {
            logger.info("Validating the presence of the top navigation bar on Team Details page");
            Assert.assertTrue(td.isTopNavPresent(), "Nav bar must be present on Team Details page");
            logger.info("Top navigation bar is present on Team Details page");
        } catch (AssertionError e) {
            logger.info("Test failed...Top navigation bar not present on Team Details page");
            Assert.fail();
        }
    }

    @Test(priority = 3, groups = {"Regression","Master","UI"})
    public void isHeadingPresent() {
        try {
            logger.info("Validating the main heading on Team Details page");
            Assert.assertTrue(td.isHeadingPresent(), "Heading must be present on Team Details page");
            logger.info("Main heading is present on Team Details page");
        } catch (AssertionError e) {
            logger.info("Test failed...Heading not present on Team Details page");
            Assert.fail();
        }
    }

    @Test(priority = 4, groups = {"Sanity","Master","UI"})
    public void isTeamDetailsPresent() {
        try {
            logger.info("Validating that team member details are displayed on Team Details page");
            Assert.assertTrue(td.isTeamDetailsPresent(), "Team details should be displayed on Team Details page");
            logger.info("Team details are displayed on Team Details page");
        } catch (AssertionError e) {
            logger.info("Test failed...Team details not displayed on Team Details page");
            Assert.fail();
        }
        logger.info("**** Finished TC010_TeamDetailsPageValidation ****");
    }

//    @Test(priority = 1, groups = {"Regression","Master","Functionality"})
//    public void goToTeamDetails() {
//        logger.info("**** Started TC011_TeamDetailsFunctionalityValidation ****");
//        try {
//            logger.info("Navigating to Team Details section via top navigation");
//            tn.goToTeamDetails();
//            String url = driver.getCurrentUrl();
//            logger.info("Current URL after navigating to Team Details: " + url);
//            Assert.assertTrue(url.contains("#foot"), "Did not navigate to Team Details section");
//            logger.info("Successfully navigated to Team Details section");
//        } catch (AssertionError e) {
//            logger.info("Test failed...did not navigate to Team Details section");
//            Assert.fail();
//        }
//    }

    @Test(priority = 2, groups = {"Sanity","Master","Functionality"})
    public void gotoHome() {
        try {
            logger.info("Navigating to Home section from Team Details page");
            td.goToHome();
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
            logger.info("Navigating to Blood Pressure section from Team Details/Home");
            td.goToBloodPressure();
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
    public void gotoHeartPulse() {
        try {
            logger.info("Navigating to Heart Pulse section from Team Details/Blood Pressure");
            td.goToHeartPulse();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Heart Pulse: " + url);
            Assert.assertTrue(url.contains("#pulseRate"), "Did not navigate to Heart Pulse section");
            logger.info("Successfully navigated to Heart Pulse section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Heart Pulse section");
            Assert.fail();
        }
    }

    @Test(priority = 5, groups = {"Regression","Master","Functionality"})
    public void gotoAgeFactor() {
        try {
            logger.info("Navigating to Age Factor section from Team Details/Heart Pulse");
            td.goToAgeFactor();
            String url = driver.getCurrentUrl();
            logger.info("Current URL after navigating to Age Factor: " + url);
            Assert.assertTrue(url.contains("#ageFactor"), "Did not navigate to Age Factor section");
            logger.info("Successfully navigated to Age Factor section");
        } catch (AssertionError e) {
            logger.info("Test failed...did not navigate to Age Factor section");
            Assert.fail();
        }
        logger.info("**** Finished TC011_TeamDetailsFunctionalityValidation ****");
    }

}
