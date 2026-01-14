
package TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CalculatorForm;
import testBase.BaseTest;

import java.time.Duration;

public class TC007_CalculatorValidationTest extends BaseTest {
    CalculatorForm cf;

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        // driver is guaranteed to be non-null after BaseTest.setUp
        cf = new CalculatorForm(driver);
    }

    @Test(priority = 1, groups = {"Regression","Master","UI"})
    public void isFormHeadingPresent() {
        logger.info("**** Started TC012_CalculatorValidationTest ****");
        try {
            logger.info("Validating that the calculator form heading is present");
            Assert.assertTrue(cf.isFormHeadingPresent(), "Form heading should be present");
            logger.info("Calculator form heading is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Form heading is not present");
            Assert.fail();
        }
    }

    @Test(priority = 2, groups = {"Sanity","Master","UI"})
    public void isAgeFieldPresent() {
        try {
            logger.info("Validating that the Age field is present in the calculator form");
            Assert.assertTrue(cf.isAgeFieldPresent(), "Age field should be present");
            logger.info("Age field is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Age field is not present");
            Assert.fail();
        }
    }

    @Test(priority = 3, groups = {"Regression","Master","UI"})
    public void isPulseRateFieldPresent() {
        try {
            logger.info("Validating that the Pulse Rate field is present in the calculator form");
            Assert.assertTrue(cf.isPulseRateFieldPresent(), "Pulse Rate field should be present");
            logger.info("Pulse Rate field is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Pulse Rate field is not present");
            Assert.fail();
        }
    }

    @Test(priority = 4, groups = {"Sanity","Master","UI"})
    public void isBloodPressureFieldPresent() {
        try {
            logger.info("Validating that the Blood Pressure field is present in the calculator form");
            Assert.assertTrue(cf.isBloodPressureFieldPresent(), "Blood Pressure field should be present");
            logger.info("Blood Pressure field is present");
        } catch (AssertionError e) {
            logger.info("Test failed...Blood Pressure field is not present");
            Assert.fail();
        }
    }

    @Test(priority = 5, groups = {"Regression","Master","UI"})
    public void isCalculateButtonPresentAndClickable() {
        try {
            logger.info("Validating that the Calculate button is present and clickable");
            Assert.assertTrue(cf.isButtonPresentAndClickable(), "Calculate button should be present and clickable");
            logger.info("Calculate button is present and clickable");
        } catch (AssertionError e) {
            logger.info("Test failed...Calculate button is not present or not clickable");
            Assert.fail();
        }
        logger.info("**** Finished TC012_CalculatorValidationTest ****");
    }

    @Test(dataProvider = "dp", dataProviderClass = DataProviders.MainDataProvider.class,groups = {"Master","Sanity","Functionality"})
    void setData(String age, String pulse, String bp, String testType, String testResult) throws Exception {
        logger.info("**** Started TC013_CalculatorFunctionalityTest iteration ****");
        logger.info(String.format("Test data => Age: %s | Pulse: %s | BP: %s | Type: %s | Expected: %s",
                age, pulse, bp, testType, testResult));

        // Enter inputs
        try {
            logger.info("Entering Age: " + age);
            cf.enterAge(age);

            logger.info("Entering Pulse Rate: " + pulse);
            cf.enterPulse(pulse);

            logger.info("Entering Blood Pressure: " + bp);
            cf.enterBloodPressure(bp);
        } catch (Exception ex) {
            logger.info("Exception while entering input values: " + ex.getMessage());
            // We keep the flow to allow SoftAssert to conclude.
        }

        String type = testType.toLowerCase();
        SoftAssert sa = new SoftAssert();

        // Trigger calculation
        logger.info("Clicking Calculate button");
        cf.clickCalculate();

        // Alert handling
        Alert alert = null;
        try {
            logger.info("Waiting for alert presence (3 seconds)");
            alert = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException ignored) {
            logger.info("No alert appeared within timeout");
        }

        boolean validInputs = type.equalsIgnoreCase("positive");
        boolean invalidInputs = type.equalsIgnoreCase("negative");

        if (alert != null) {
            logger.info("Alert appeared. Accepting alert.");
            alert.accept();
            if (invalidInputs) {
                logger.info("Alert appeared for invalid inputs as expected");
                sa.assertTrue(true, "Invalid inputs are generating alerts");
            } else if (validInputs) {
                logger.info("Unexpected alert for valid inputs");
                sa.fail("Valid inputs are generating alerts");
            } else {
                logger.info("Unrecognized test type: " + testType);
                sa.fail("Unrecognized test type led to alert handling ambiguity");
            }
        } else {
            logger.info("No alert appeared. Verifying navigation result.");
            String currUrl = driver.getCurrentUrl();
            String resultUrl = "https://hackvyatharth.github.io/Vitalguard_Team_Vanguardians/result.html";
            logger.info("Current URL: " + currUrl);

            if (validInputs) {
                logger.info("Expecting navigation to result page for valid inputs");
                boolean navigated = currUrl.equals(resultUrl);
                if (navigated) {
                    logger.info("Navigation to result page succeeded for valid inputs");
                    sa.assertTrue(true, "Valid inputs navigated to the result page");
                    logger.info("Navigating back to the previous page");
                    driver.navigate().back();
                } else {
                    logger.info("Navigation to result page failed for valid inputs");
                    sa.fail("Valid inputs did not navigate to the result page");
                }
            } else if (invalidInputs) {
                logger.info("Expecting no navigation to result page for invalid inputs");
                boolean navigated = currUrl.equals(resultUrl);
                if (navigated) {
                    logger.info("Unexpected navigation to result page for invalid inputs");
                    sa.fail("Invalid inputs navigated to the result page");
                    logger.info("Navigating back to the previous page");
                    driver.navigate().back();
                } else {
                    logger.info("No navigation occurred for invalid inputs as expected");
                    sa.assertTrue(true, "Invalid inputs did not navigate to the result page");
                }
            } else {
                logger.info("Unrecognized test type: " + testType);
                sa.fail("Unrecognized test type: " + testType);
            }
        }

        // Final assertion for this data set
        try {
            sa.assertAll();
            logger.info("Soft assertions passed for this iteration");
        } catch (AssertionError ae) {
            logger.info("Soft assertions failed for this iteration: " + ae.getMessage());
            throw ae; // Re-throw to mark the test iteration as failed
        } finally {
            logger.info("**** Finished TC013_CalculatorFunctionalityTest iteration ****");
        }
    }

}
