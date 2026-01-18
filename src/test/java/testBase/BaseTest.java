package testBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    protected String baseUrl="https://hackvyatharth.github.io/Vitalguard_Team_Vanguardians/";
    public Logger logger;
    public Properties p;

    @Parameters({"os","browser"})
    @BeforeMethod(alwaysRun = true,groups = {"Sanity","Regression","Master"})
    public void setUp(String os,String browser) throws IOException {
        FileReader file=new FileReader("C:\\Users\\2457784\\IdeaProjects\\Health_Index_Calculator\\src\\test\\resources\\config.properties");
        p=new Properties();
        p.load(file);

        logger= LogManager.getLogger(this.getClass());

        switch (browser.toLowerCase()){
            case "chrome":driver=new ChromeDriver();break;
            case "edge": driver=new EdgeDriver();break;
            default:
                System.out.println("Invalid browser..."); return;
        }


        driver.get(p.getProperty("appUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }


    @AfterMethod(alwaysRun = true,groups = {"Sanity","Regression","Master"})
    public void tearDown() {
//        try{
//            if (driver != null) {
//                driver.quit();
//            }
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        }
        if(driver!=null){
            driver.quit();

        }


    }

    public String captureScreen(String name) throws IOException{
        String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+name+ "_"+ timeStamp +".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);
  return targetFilePath;
    }


}
