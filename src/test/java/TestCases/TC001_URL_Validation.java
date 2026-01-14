
package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TopNavigation;
import testBase.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC001_URL_Validation extends BaseTest {

    TopNavigation tn;
    HomePage hp;
    String urlMain = "https://hackvyatharth.github.io/Vitalguard_Team_Vanguardians/";

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        // driver is guaranteed to be non-null after BaseTest.setUp
        hp = new HomePage(driver);
        tn = new TopNavigation(driver);
    }

    @Test(priority = 1, groups = {"Sanity","Regression","Master","Functionality"})
    public void urlMatches() {
        logger.info("**** Starting TC001_URL_Validation ****");
        try {
            logger.info("Navigating to the configured application URL: " + urlMain);
            driver.navigate().to(urlMain);

            String currUrl = driver.getCurrentUrl();
            logger.info("Current URL after navigation: " + currUrl);

            assertEquals(currUrl, urlMain, "URL does not match the configured application URL");
            logger.info("Successfully loaded the exact configured application URL");
        } catch (AssertionError e) {
            logger.error("Test failed...URL mismatch");
            logger.debug("Expected URL: " + urlMain);
            logger.debug("Actual URL: " + driver.getCurrentUrl());
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 2, groups = {"Sanity","Regression","Master","Functionality"})
    public void isURLWorking(){
        try {
            logger.info("Validating that the homepage is loaded and key UI elements are present");
            boolean homeLoaded = hp.isLeftImagePresent();
            logger.info("hiiiii {}--------------------------------------------------------------",homeLoaded);
            assertTrue(homeLoaded, "Home page should be loaded with navbar, left image, and calculator fields");
            logger.info("Homepage is loaded successfully with navbar, left image, and calculator fields");
        } catch (AssertionError e) {
            logger.info("Test failed...URL not working or homepage not loaded with required elements");
            Assert.fail(e.getMessage());
        }  finally {
            logger.info("**** Finished TC001_URL_Validation ****");
        }
    }
}
