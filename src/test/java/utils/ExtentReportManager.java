package utils;

import org.testng.ITestListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.internal.BaseClassFinder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import testBase.BaseTest;

public class ExtentReportManager implements ITestListener
{
    public ExtentSparkReporter sparkReporter;  // UI of the report
    public ExtentReports extent;  //populate common info on the report
    public ExtentTest test; // creating test case entries in the report and update status of the test methods

    String repName;

    public void onStart(ITestContext context) {
    /*
        SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Date dt=new Date();
        String currentdatetimestamp=df.format(dt);
    */
        String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName="Test-Report-"+timeStamp+".html";

        sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+repName);//specify location of the report

        sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
        sparkReporter.config().setReportName("Functional Testing"); // name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application","Health Index Calculator");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("Tester Name","POD1");
        extent.setSystemInfo("os","Windows11");
        extent.setSystemInfo("Browser name","Chrome");

        String os=context.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System",os);

        String browser=context.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser",browser);

        List<String> includeGroups=context.getCurrentXmlTest().getIncludedGroups();
        if(!includeGroups.isEmpty()){
            extent.setSystemInfo("Groups",includeGroups.toString());
        }

    }


    public void onTestSuccess(ITestResult result) {

        test = extent.createTest(result.getTestClass().getName()); // create a new enty in the report
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName()+" got successfully executed"); // update status p/f/s

    }

    public void onTestFailure(ITestResult result) {

        test = extent.createTest(result.getClass().getName());
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL, result.getName()+" got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        BaseTest base = (BaseTest) result.getInstance();

        try{
            String impPath=base.captureScreen(result.getName());
            test.addScreenCaptureFromPath(impPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult result) {

        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP,result.getName()+"got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());

    }


    public void onFinish(ITestContext context) {
            extent.flush();

            //To directly open the report upon creation
            String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
            File extentReport=new File(pathOfExtentReport);

            try{
                Desktop.getDesktop().browse(extentReport.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
