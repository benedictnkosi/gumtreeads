package utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import properties.Application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ExcelReader {


    public Sheet readExcelSheet(String sheetName) throws IOException {
        //get the file path from the application.properties file
        Properties obj = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\application.properties");
        obj.load(objfile);
        String mobileTesting = obj.getProperty("MobileTesting");

        //Create an object of DataProvider class
        ExcelReader excelUtil = new ExcelReader();
        Sheet dataSheet = excelUtil.readExcel(Application.dataFilePath, Application.dataFileName, sheetName);
        return dataSheet;
    }

    private Sheet readExcel(String filePath, String fileName, String sheetName) throws IOException {
        //Create a object of File class to open xlsx file
        File file = new File(filePath + "\\" + fileName);
        //Create an object of FileInputStream class to read utils file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook dataWorkbook = null;
        //Find the file extension by spliting file name in substing and getting only extension name
        String fileExtensionName = fileName.substring(fileName.lastIndexOf("."));
        //Check condition if the file is xlsx file
        if (fileExtensionName.equals(".xlsx")) {
            //If it is xlsx file then create object of XSSFWorkbook class
            dataWorkbook = new XSSFWorkbook(inputStream);
        }
        //Check condition if the file is xls file
        else if (fileExtensionName.equals(".xls")) {
            //If it is xls file then create object of XSSFWorkbook class
            dataWorkbook = new HSSFWorkbook(inputStream);
        }
        //Read sheet inside the workbook by its name
        Sheet dataSheet = dataWorkbook.getSheet(sheetName);
        return dataSheet;
    }


    public int getNumberOfTestCasesToRun(Sheet dataSheet) {
        try {
            int rowCount = dataSheet.getLastRowNum() - dataSheet.getFirstRowNum();
            int j = 0;
            int numberOfTestCasesToRun = 0;

            for (int i = 1; i < rowCount + 1; i++) {
                //Loop over all the rows

                Row row = dataSheet.getRow(i);
                //Check if the first cell contain a value, if yes, That means it is the new testcase name
                if (row.getCell(0).toString().length() > 0) {
                    if (Boolean.parseBoolean(row.getCell(this.getColumnIndex(dataSheet,Application.RunIndicatorColumnHeader)).toString())) {
                        numberOfTestCasesToRun++;
                    }
                }
            }

            return numberOfTestCasesToRun;
        } catch (Exception ex) {
            return 0;
        }
    }

    public int getColumnIndex(Sheet dataSheet, String coulumnName) {
        try {

            int columnIndex = 0;
            Row row = dataSheet.getRow(0);
            int colCount = row.getLastCellNum();
            for (int i = 0; i < colCount; i++) {
                if(row.getCell(i).toString().equalsIgnoreCase(coulumnName)){
                    columnIndex = i;
                }
            }
            return columnIndex;
        } catch (Exception ex) {
            return 0;
        }
    }

}
