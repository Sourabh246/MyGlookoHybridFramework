package com.learnautomation.testcases;

import com.learnautomation.pages.Baseclass;
import com.learnautomation.pages.Loginpage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestGlooko extends Baseclass
{


  /*  WebDriver driver;

    @BeforeTest
    public void setup(){
        driver=BrowserFactory.startApplication(driver , "Chrome","https://qa-us.my.glooko.com");

    }

    @AfterTest

        public void teardown()
    {
        BrowserFactory.quitBrowser(driver);

    }
*/
    @Test
    public void loginApp() throws IOException {

        //DataProvider data= new DataProvider();

    //System.out.println(driver.getTitle());

        Logger = report.createTest("Login to Glooko");


       Loginpage Loginpage= PageFactory.initElements(driver , Loginpage.class);

       Logger.info("Starting test");
        Loginpage.LogintoGlooko(data.getStringdata("Login", 0, 0), data.getStringdata("Login", 0, 1));

        Logger.pass("login success");

        // Thread.sleep(5000);




    }




}
