package driver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import properties.Application;
import org.apache.log4j.Logger;

public class BaseClass {

    WebDriver driver;
    ExtentReports extent;

    ExtentTest test = null;
    Logger log = null;

    @BeforeSuite
    public void setupReports(){
        // start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ex.html");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void setup(){
        try {
            String driverPath = "C:\\Classes\\geckodriver.exe";

            System.setProperty("webdriver.gecko.driver", driverPath);

            log = Logger.getLogger("devpinoyLogger");

            driver = new FirefoxDriver();

            driver.manage().timeouts().implicitlyWait(Application.timeoutSeconds, TimeUnit.SECONDS);

            driver.manage().window().maximize();

            driver.get(Application.baseUrl);



        } catch (Exception ex) {
            Assert.fail(ex.getStackTrace()[0].getMethodName(), ex);
        }
    }

     //AfterMethod annotation - This method executes after every test execution
     public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
         //below line is just to append the date format with the screenshot name to avoid duplicate names
         String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
         TakesScreenshot ts = (TakesScreenshot) driver;
         File source = ts.getScreenshotAs(OutputType.FILE);
         //after execution, you could see a folder "FailedTestsScreenshots" under src folder
         String filename = screenshotName+dateName+".png";
         String destination = "/" + Application.screenshotFolderName+"/"+filename;
         File finalDestination = new File(destination);
         FileUtils.copyFile(source, finalDestination);
         //Returns the captured file path
         return filename;
     }




    @AfterMethod
    public void teardown(ITestResult result)  throws Exception {
        try {
            if(result.getStatus() == ITestResult.FAILURE){

                String filename = this.getScreenshot(driver, result.getName());
                //To add it in the extent report
                test.fail("failed damn", MediaEntityBuilder.createScreenCaptureFromPath(Application.screenshotPath + filename).build());
            }else if(result.getStatus() == ITestResult.SKIP){
                test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
            }

            extent.flush();
            System.out.println("closing firefox browser");

            driver.quit();
        } catch (Exception ex) {
            Assert.fail(ex.getStackTrace()[0].getMethodName(), ex);
        }
    }



}