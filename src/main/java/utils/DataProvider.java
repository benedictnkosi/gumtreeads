package utils;


import DTO.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import properties.Application;


public class DataProvider {

    @org.testng.annotations.DataProvider(name = "shortTermRentalProvider")
    public static Object[][] readShortTermRentalTestCases(){
        Object[][] dataProviderObject = null;
        try{


            ExcelReader myExcel = new ExcelReader();
            Sheet dataSheet = myExcel.readExcelSheet(Application.short_term_rental_sheet_name);
            int rowCount = dataSheet.getLastRowNum() - dataSheet.getFirstRowNum();
            int numberOfTestCasesToRun = myExcel.getNumberOfTestCasesToRun(dataSheet);

            dataProviderObject = new Object[numberOfTestCasesToRun][2];

            int j = 0;

            for (int i = 1; i < rowCount + 1; i++) {
                //Loop over all the rows

                Row row = dataSheet.getRow(i);
                //Check if the first cell contain a value, if yes, That means it is the new testcase name
                if (row.getCell(0).toString().length() > 0) {
                    if (Boolean.parseBoolean(row.getCell(1).toString())) {

                        System.out.println("including test case : " + row.getCell(0).toString() + "----" + row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" + row.getCell(3).toString());

                        AdvertCommonPropertiesDTO advertCommonPropertiesDTO =  new AdvertCommonPropertiesDTO();
                        ShortTermRentalDTO shortTermRentalDTO = new ShortTermRentalDTO();

                        //common advert properties

                        advertCommonPropertiesDTO.setTestCaseName(row.getCell(0).toString());
                        advertCommonPropertiesDTO.setUsername(row.getCell(2).toString());
                        advertCommonPropertiesDTO.setPassword(row.getCell(3).toString());

                        advertCommonPropertiesDTO.setTittle(row.getCell(4).toString());
                        advertCommonPropertiesDTO.setDescription(row.getCell(5).toString());
                        advertCommonPropertiesDTO.setPhone(row.getCell(6).toString());
                        advertCommonPropertiesDTO.setCategory(row.getCell(7).toString());
                        advertCommonPropertiesDTO.setProvince(row.getCell(8).toString());
                        advertCommonPropertiesDTO.setCity(row.getCell(9).toString());
                        advertCommonPropertiesDTO.setSuburb(row.getCell(10).toString());
                        advertCommonPropertiesDTO.setImages(row.getCell(11).toString());
                        advertCommonPropertiesDTO.setPrice(row.getCell(12).toString().replace(".0",""));


                        shortTermRentalDTO.setAdvertCommonPropertiesDTO(advertCommonPropertiesDTO);

                        //short term rental specific
                        shortTermRentalDTO.setSleeps(row.getCell(13).toString().replace(".0",""));
                        shortTermRentalDTO.setBedrooms(row.getCell(14).toString().replace(".0",""));
                        shortTermRentalDTO.setBathroom(row.getCell(15).toString().replace(".0",""));
                        shortTermRentalDTO.setParking(row.getCell(16).toString());
                        shortTermRentalDTO.setDwelling(row.getCell(17).toString());

                        dataProviderObject[j][0] = advertCommonPropertiesDTO.getTestCaseName();
                        dataProviderObject[j][1] = shortTermRentalDTO;
                        j++;

                    } else {
                        System.out.println("excluding test case : " + row.getCell(0).toString() + "----" + row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" + row.getCell(3).toString());
                    }
                } else {
                    System.out.println("no cells found");
                }
            }
            return dataProviderObject;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return dataProviderObject;
        }
    }


    @org.testng.annotations.DataProvider(name = "servicesProvider")
    public static Object[][] readServicesTestCases(){
        Object[][] dataProviderObject = null;
        try{


            ExcelReader myExcel = new ExcelReader();
            Sheet dataSheet = myExcel.readExcelSheet(Application.services_sheet_name);
            int rowCount = dataSheet.getLastRowNum() - dataSheet.getFirstRowNum();
            int numberOfTestCasesToRun = myExcel.getNumberOfTestCasesToRun(dataSheet);

            dataProviderObject = new Object[numberOfTestCasesToRun][2];

            int j = 0;

            for (int i = 1; i < rowCount + 1; i++) {
                //Loop over all the rows

                Row row = dataSheet.getRow(i);
                //Check if the first cell contain a value, if yes, That means it is the new testcase name
                if (row.getCell(0).toString().length() > 0) {
                    if (Boolean.parseBoolean(row.getCell(1).toString())) {

                        System.out.println("including test case : " + row.getCell(0).toString() + "----" + row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" + row.getCell(3).toString());

                        AdvertCommonPropertiesDTO advertCommonPropertiesDTO =  new AdvertCommonPropertiesDTO();

                        //common advert properties

                        advertCommonPropertiesDTO.setTestCaseName(row.getCell(0).toString());
                        advertCommonPropertiesDTO.setUsername(row.getCell(2).toString());
                        advertCommonPropertiesDTO.setPassword(row.getCell(3).toString());

                        advertCommonPropertiesDTO.setTittle(row.getCell(4).toString());
                        advertCommonPropertiesDTO.setDescription(row.getCell(5).toString());
                        advertCommonPropertiesDTO.setPhone(row.getCell(6).toString());
                        advertCommonPropertiesDTO.setCategory(row.getCell(7).toString());
                        advertCommonPropertiesDTO.setProvince(row.getCell(8).toString());
                        advertCommonPropertiesDTO.setCity(row.getCell(9).toString());
                        advertCommonPropertiesDTO.setSuburb(row.getCell(10).toString());
                        advertCommonPropertiesDTO.setImages(row.getCell(11).toString());
                        advertCommonPropertiesDTO.setPrice(row.getCell(12).toString().replace(".0",""));


                        dataProviderObject[j][0] = advertCommonPropertiesDTO.getTestCaseName();
                        dataProviderObject[j][1] = advertCommonPropertiesDTO;
                        j++;

                    } else {
                        System.out.println("excluding test case : " + row.getCell(0).toString() + "----" + row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" + row.getCell(3).toString());
                    }
                } else {
                    System.out.println("no cells found");
                }
            }
            return dataProviderObject;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return dataProviderObject;
        }
    }






}
