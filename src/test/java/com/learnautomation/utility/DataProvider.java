package com.learnautomation.utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataProvider {

    XSSFWorkbook wb;
    public DataProvider()
    {
        File src = new File("./TestData/Test data.xlsx");

        try {
            FileInputStream fis = new FileInputStream(src);
            wb=new XSSFWorkbook(fis);
        } catch (IOException e) {

          System.out.println("unable to read excel file");
            e.printStackTrace();
        }


    }

    //method overloading concept below - three methods of same name but different params


    public String getStringdata(String sheetName , int row , int column)
    {
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    /*

    public String getStringdata(int sheetIndex , int row , int column)
    {
       return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();

    }*/

    public double getNumericdata(String sheetName , int row , int column)
    {
       return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue() ;

    }


}
