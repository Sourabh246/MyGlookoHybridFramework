package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {

    WebDriver driver;
    public Loginpage(WebDriver ldriver)
    {
        this.driver= ldriver;
    }

    @FindBy(id = "user_email") WebElement userid;

    @FindBy(id = "user_password") WebElement user_password;
    @FindBy(name ="commit" ) WebElement button;

    public void LogintoGlooko(String username , String password)

       {
    try
    {
        userid.sendKeys(username);
        user_password.sendKeys(password);
        button.click();
        Thread.sleep(2000);
    }
    catch (InterruptedException e)

    {
System.out.println("nhi chalega");
    }

}


}
