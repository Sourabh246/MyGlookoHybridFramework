package com.learnautomation.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigProvider;
import com.learnautomation.utility.DataProvider;
import com.learnautomation.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import javax.xml.crypto.Data;
import java.io.File;

public class Baseclass {

    public  WebDriver driver;
    public DataProvider data;
    public ConfigProvider configdata;
    public Helper obj1;
    public ExtentReports report;
    public ExtentTest Logger;

/*  // we can implement the screenshot method like below as well , i.e. creating an object of the class
 and then calling the method
@AfterMethod

public void methodscreenshot()
{

    Helper obj1= new Helper();
    obj1.capturesrcshot(driver);

}

 */

    @AfterMethod
    public void anothermethodsrcsht(ITestResult result)
    {
        if (result.getStatus()==ITestResult.SUCCESS)
       // If(result.getStatus()==ITestResult.FAILURE)
        {
            //Helper.capturesrcshot(driver);
            Helper obj1= new Helper();
            obj1.capturesrcshot(driver);

            //Helper.capturesrcshot(driver);  we can use this as well directly if the helper class would be static
        }

    }



//if the helper class is static then its not required to create an object here , directly
// calling the helper.capturesrcshot(driver) in the test cases would work fine


    @BeforeSuite
    public void exceldata()
    {
        data = new DataProvider();
         configdata = new ConfigProvider();

         Helper obj1= new Helper();

        ExtentSparkReporter spark = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/"+obj1.getcurrentdatetime()+".html"));

        report = new ExtentReports();
        report.attachReporter(spark);
        //ExtentHtmlReporter is now removed in version 5 of aventstack and extentreport

    }


    @BeforeTest
    public void setup(){
        driver= BrowserFactory.startApplication(driver, configdata.getbrowserfromconfig(), configdata.geturlfromconfig());

    }

  @AfterTest

    public void teardown()
    {
        BrowserFactory.quitBrowser(driver);
        report.flush();

    }

    @AfterMethod

    public void screenshotinreport(ITestResult result)
    {


        if(result.getStatus()==ITestResult.SUCCESS) {

            Helper obj1 = new Helper();
            //obj1.capturesrcshot(driver);
            Logger.pass("test passed", MediaEntityBuilder.createScreenCaptureFromPath(obj1.capturesrcshot(driver)).build());
        }
        else if(result.getStatus()==ITestResult.FAILURE)
        {
            Logger.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(obj1.capturesrcshot(driver)).build());

        }
    }

}
