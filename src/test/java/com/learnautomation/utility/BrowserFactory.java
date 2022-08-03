package com.learnautomation.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory
{

    public static WebDriver startApplication(WebDriver driver , String browserName , String appUrl)

    {
        if (browserName.equals ("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver 2");
            driver= new ChromeDriver();
        }
        else if (browserName.equals("firefox"))
        {
            System.setProperty("webDriver.gecko.driver","./Drivers/geckodriver.exe");
            driver= new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(appUrl);
       // driver.manage().timeouts().implicitlyWait(30 ,TimeUnit.SECONDS );
        return driver;


    }

    public static void quitBrowser(WebDriver driver)
    {
      driver.quit();
    }





}
