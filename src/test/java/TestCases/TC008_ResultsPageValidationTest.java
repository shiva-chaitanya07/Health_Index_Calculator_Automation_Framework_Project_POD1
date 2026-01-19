
package TestCases;

import DataProviders.MainDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CalculatorForm;
import pages.ResultPage;
import pages.TopNavigation;
import testBase.BaseTest;

import java.time.Duration;

public class TC008_ResultsPageValidationTest extends BaseTest {
    TopNavigation topNav;
    ResultPage res;
    CalculatorForm cf;
    SoftAssert sa = new SoftAssert();

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        // driver is guaranteed to be non-null after BaseTest.setUp
        topNav = new TopNavigation(driver);
        res = new ResultPage(driver);
        cf = new CalculatorForm(driver);
    }

    @Test(priority = 1, groups = {"Regression","Master","UI"})
    public void resultPageUICheck() {
        logger.info("**** Started TC014_ResultsPageUITest ****");
        try {
            logger.info("Entering valid inputs into Calculator Form");
            logger.info("Entering Age: 20");
            cf.enterAge("20");

            logger.info("Entering Pulse Rate: 60");
            cf.enterPulse("60");

            logger.info("Entering Blood Pressure: 120/80");
            cf.enterBloodPressure("120/80");

            logger.info("Clicking Calculate to navigate to Result page");
            cf.clickCalculate();

            String currentUrl = driver.getCurrentUrl();
            logger.info("Current URL after clicking Calculate: " + currentUrl);

            // UI Validations on Result Page
            logger.info("Validating Result Page UI elements");

            Assert.assertTrue(res.isLogoPresent(), "Logo should be visible");
            logger.info("Logo is visible");

            Assert.assertTrue(res.isLogoTextPresent(), "Logo text should be visible");
            logger.info("Logo text is visible");

            Assert.assertTrue(res.isResultBoxPresent(), "Result box should be visible");
            logger.info("Result box is visible");

            Assert.assertTrue(res.isHeadingPresent(), "Heading should be visible");
            logger.info("Heading is visible");

            Assert.assertTrue(res.isResultDisplayed(), "Result should be displayed");
            logger.info("Result is displayed");

            Assert.assertTrue(res.isFeedbackBoxPresent(), "Feedback box must be present");
            logger.info("Feedback box is present");

        } catch (AssertionError e) {
            logger.info("Test failed...One or more Result Page UI elements are not as expected");
            Assert.fail(e.getMessage());
        }  finally {
            logger.info("**** Finished TC014_ResultsPageUITest ****");
            driver.navigate().back();
        }
    }

    @Test(priority = 2, dataProvider = "resultPageCheck", dataProviderClass = MainDataProvider.class, groups = {"Regression","Master","Functionality"})
    void resultPageCheck(String age, String pulse, String bp) throws InterruptedException {
        logger.info("**** Started TC015_ResultPageFunctionalityTest :: resultPageCheck iteration ****");
        logger.info(String.format("Input dataset => Age: %s | Pulse: %s | BP: %s", age, pulse, bp));


        try {
            logger.info("Entering Age: " + age);

            cf.enterAge(age);

            logger.info("Entering Pulse Rate: " + pulse);
            cf.enterPulse(pulse);

            logger.info("Entering Blood Pressure: " + bp);
            cf.enterBloodPressure(bp);

            logger.info("Clicking Calculate to navigate to Result page");
            cf.clickCalculate();

            String currUrl = driver.getCurrentUrl();
            logger.info("Current URL after Calculate: " + currUrl);

            String expectedUrl = "https://hackvyatharth.github.io/Vitalguard_Team_Vanguardians/result.html";
            logger.info("Validating redirection to Result page: " + expectedUrl);
            sa.assertEquals(currUrl, expectedUrl, "Should be redirected to result page");

        } catch (Exception ex) {
            logger.info("Unexpected exception during resultPageCheck: " + ex.getMessage());
            sa.fail("Unexpected exception while validating result page redirection: " + ex.getMessage());
        } finally {
            try {
                sa.assertAll();
                logger.info("Soft assertions passed for this resultPageCheck iteration");
            } catch (AssertionError ae) {
                logger.info("Soft assertions failed for this resultPageCheck iteration: " + ae.getMessage());
                throw ae; // bubble up to mark the iteration failed
            } finally {
                logger.info("**** Finished TC015_ResultPageFunctionalityTest :: resultPageCheck iteration ****");
            }
        }
    }

    @Test(priority = 3, groups = {"Sanity","Master","Functionality"},dataProvider = "resultPageCheck", dataProviderClass = MainDataProvider.class)
    void isScrollable(String age, String pulse, String bp) {
        logger.info("**** TC015 :: isScrollable validation started ****");
        try {
            cf.enterAge(age);
            cf.enterPulse(pulse);
            cf.enterBloodPressure(bp);
            cf.clickCalculate();
            WebElement textArea = driver.findElement(By.id("feedback"));
            logger.info("Located feedback textarea by id=feedback");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            Long scrollHeight = (Long) js.executeScript("return arguments[0].scrollHeight;", textArea);
            Long clientHeight = (Long) js.executeScript("return arguments[0].clientHeight;", textArea);

            logger.info("Textarea scrollHeight: " + scrollHeight + ", clientHeight: " + clientHeight);

            boolean scrollable = scrollHeight > clientHeight;
            if (scrollable) {
                logger.info("Textarea is scrollable as expected");
                sa.assertTrue(true, "The result text box is scrollable");
            } else {
                logger.info("Textarea is NOT scrollable (unexpected)");
                sa.fail("The result text box is not scrollable");
            }
        } catch (NoSuchElementException nse) {
            logger.info("Feedback textarea not found: " + nse.getMessage());
            sa.fail("Feedback textarea not found on the Result page");
        } catch (Exception ex) {
            logger.info("Unexpected exception during scrollable check: " + ex.getMessage());
            sa.fail("Unexpected exception during isScrollable: " + ex.getMessage());
        } finally {
            try {
                sa.assertAll();
                logger.info("Soft assertions passed for isScrollable");
            } catch (AssertionError ae) {
                logger.info("Soft assertions failed for isScrollable: " + ae.getMessage());
                throw ae;
            } finally {
                logger.info("**** TC015 :: isScrollable validation finished ****");
            }
        }
    }

    @Test(priority = 4, groups = {"Sanity","Master","Functionality"},dataProvider = "resultPageCheck", dataProviderClass = MainDataProvider.class)
    void isResizable(String age, String pulse, String bp) {
        logger.info("**** TC015 :: isResizable validation started ****");
        try {
            cf.enterAge(age);
            cf.enterPulse(pulse);
            cf.enterBloodPressure(bp);
            cf.clickCalculate();
            WebElement textArea = driver.findElement(By.id("feedback"));
            logger.info("Located feedback textarea by id=feedback");

            String resizeCSS = textArea.getCssValue("resize");
            logger.info("Textarea CSS 'resize' value: " + resizeCSS);

            boolean resizable = !"none".equalsIgnoreCase(resizeCSS);
            if (resizable) {
                logger.info("Textarea is resizable as expected");
                sa.assertTrue(true, "The result textbox is resizable");
            } else {
                logger.info("Textarea is NOT resizable (unexpected)");
                sa.fail("The result textbox is not resizable");
            }
        } catch (NoSuchElementException nse) {
            logger.info("Feedback textarea not found: " + nse.getMessage());
            sa.fail("Feedback textarea not found on the Result page");
        } catch (Exception ex) {
            logger.info("Unexpected exception during resizable check: " + ex.getMessage());
            sa.fail("Unexpected exception during isResizable: " + ex.getMessage());
        } finally {
            try {
                sa.assertAll();
                logger.info("Soft assertions passed for isResizable");
            } catch (AssertionError ae) {
                logger.info("Soft assertions failed for isResizable: " + ae.getMessage());
                throw ae;
            } finally {
                logger.info("**** TC015 :: isResizable validation finished ****");
            }
        }
    }
    
}
