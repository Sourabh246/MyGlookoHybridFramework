package com.learnautomation.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

public class Helper {




        public String capturesrcshot(WebDriver driver)

        {

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             String ScreenshotPath = System.getProperty("user.dir")+ "/Screenshot/Screen_"+ getcurrentdatetime() +".jpg";

            try {
               // FileUtils.copyFile(src, new File("./Screenshot/screen"+ getcurrentdatetime() +".png"));
                // FileUtils.copyFile(src, new File("./Screenshots/check.png"));
                FileUtils.copyFile(src,new File(ScreenshotPath));
            } catch (IOException e) {
                e.printStackTrace();
            }

            return ScreenshotPath;

        }

        public String getcurrentdatetime()
        {
            DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
            Date currentdate1 = new Date();

            return customformat.format(currentdate1);


        }


}
