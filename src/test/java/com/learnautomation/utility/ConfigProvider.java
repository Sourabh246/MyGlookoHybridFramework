package com.learnautomation.utility;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.testng.IConfigurable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider

{
     Properties pro;

    public ConfigProvider()
        {
        File src=new File("./Config/config.properties");


                FileInputStream fis=null;
            try {
                fis=new FileInputStream(src);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            pro=new Properties();
            try {
                pro.load(fis);
            }
            catch (IOException e)
            {
                System.out.println("file not found");
                e.printStackTrace();
            }


        }


        public String geturlfromconfig()
    {

       return pro.getProperty("qaUrl");
    }
    public String getbrowserfromconfig()
    {
      return  pro.getProperty("Browser");


    }

    public String getdatafromconfig(String KeyToSearch)
    {
  return pro.getProperty("KeyToSearch");

    }


        }


