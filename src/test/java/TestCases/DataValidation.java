package TestCases;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.CalculatorForm;
import pages.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.BaseTest;
import utils.DataParsing;

import java.io.IOException;
import java.time.Duration;

public class DataValidation extends BaseTest {

    CalculatorForm cf=new CalculatorForm(driver);


    @Test(dataProvider = "dp")
    void setData(String age,String pulse,String bp,String testType,String testResult) throws Exception {
        cf.enterAge(age);
        cf.enterPulse(pulse);
        cf.enterBloodPressure(bp);
        String type = testType.toLowerCase();
        String result=testResult.toLowerCase();


        SoftAssert sa = new SoftAssert();
        cf.clickCalculate();

        Alert alert = null;
        try {
            alert = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException ignored) {

        }

        boolean validInputs=type.equalsIgnoreCase("positive");
        boolean invalidInputs =type.equalsIgnoreCase("negative");
        boolean resultPositive=type.equalsIgnoreCase("positive");
        boolean resultNegative=type.equalsIgnoreCase("negative");

         if(alert!=null){
             alert.accept();
             if(invalidInputs){
                 sa.assertTrue(true,"Invalid inputs are generating alerts");
             } else if (validInputs) {
                 sa.fail("Valid inputs are generating alerts");
             }
         }
         else{

             String currUrl= driver.getCurrentUrl();
             if(validInputs){

                    String resultUrl="https://hackvyatharth.github.io/Vitalguard_Team_Vanguardians/result.html";
                    boolean navigated=currUrl.equals(resultUrl);
                    if(navigated){
                        sa.assertTrue(true,"Valid inputs are getting navigated to the result page");
                        driver.navigate().back();
                    }
                    else {
                        sa.fail("Valid inputs are not getting navigated to result page");
                    }
             } else if (invalidInputs) {

//                 String resultUrl="https://hackvyatharth.github.io/Vitalguard_Team_Vanguardians/result.html";
                 boolean navigated=currUrl.contains("result.html");
                 if(navigated){
                     sa.fail("Invalid inputs are getting navigated to result page");
                     driver.navigate().back();
                 }
                 else {
                     sa.assertTrue(true);
                 }

             }
         }
        sa.assertAll();
    }



//        @DataProvider(name="dp")
//        Object[][] testData() throws IOException {
//
//                data = parsing.parseExcel();
//                return data;
//
//        }



}
