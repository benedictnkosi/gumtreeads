package driver;

import DTO.AdvertCommonPropertiesDTO;
import DTO.ShortTermRentalDTO;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PostAdvertPage;
import properties.Application;
import utils.DataProvider;
import utils.UIOperations;


public class ServicesTest extends BaseClass{

    @Test(dataProvider = "servicesProvider", dataProviderClass = DataProvider.class)
    public void runServicesTestCases(String testCaseName, AdvertCommonPropertiesDTO advertDTO) {
        //ExtentTest test = null;

        try {
            System.out.println("running login test cases");
            LoginPage loginPage = new LoginPage(driver);
            UIOperations uiOperations = new UIOperations(driver);

            AdvertCommonPropertiesDTO advertCommonPropertiesDTO = advertDTO;

            test = extent.createTest(testCaseName, "Username :" + advertCommonPropertiesDTO.getUsername() + " Password: " + advertCommonPropertiesDTO.getPassword());

            if (testCaseName != null) {
                log.debug(advertCommonPropertiesDTO.getUsername());

                test.log(Status.INFO,"Launching application");
                driver.get(Application.baseUrl + Application.loginPageUlr);
                test.pass("Launch application");

                log.debug("Launch application completed");

                test.log(Status.INFO,"typing username : " + advertCommonPropertiesDTO.getUsername());
                loginPage.setUserName(advertCommonPropertiesDTO.getUsername());
                test.pass("type username");

                log.debug("type username completed");

                test.log(Status.INFO,"type password : " + advertCommonPropertiesDTO.getPassword());
                loginPage.setPassword(advertCommonPropertiesDTO.getPassword());
                test.pass("type password");

                test.log(Status.INFO,"click login button");
                loginPage.clickLoginButton();
                test.pass("click login button");

                test.log(Status.INFO,"navigate to post advert : " + Application.baseUrl +  Application.createAdUlr);
                driver.get(Application.baseUrl + Application.createAdUlr);
                test.pass("navigate to post advert");

                test.log(Status.INFO,"Select Category :  propertyCategory");
                uiOperations.clickElement(PostAdvertPage.serviceCategory);
                test.pass("Select Category");


                test.log(Status.INFO,"set advert tittle : " + advertCommonPropertiesDTO.getTittle());
                uiOperations.setText(PostAdvertPage.inputTittle, advertCommonPropertiesDTO.getTittle());
                test.pass("set advert tittle");

                test.log(Status.INFO,"Select Sub category : " + advertCommonPropertiesDTO.getCategory() );
                uiOperations.selectByVisibleText(PostAdvertPage.selectSubCategory, advertCommonPropertiesDTO.getCategory());
                test.pass("Select Sub category");

                test.log(Status.INFO,"set description text : " + advertCommonPropertiesDTO.getDescription());
                uiOperations.sleep(5000);
                uiOperations.switchToFrame(PostAdvertPage.descriptionFrame);
                uiOperations.sleep(5000);
                uiOperations.clickElement(PostAdvertPage.descriptionInput);
                uiOperations.sleep(5000);
                uiOperations.sendKeysOnly(PostAdvertPage.descriptionInput, advertCommonPropertiesDTO.getDescription());
                driver.switchTo().defaultContent();
                test.pass("set description text");

                test.log(Status.INFO,"Uploading images : " + advertCommonPropertiesDTO.getImages().toString());
                uiOperations.uploadImages(PostAdvertPage.inputImageUpload, advertCommonPropertiesDTO.getImages());
                test.pass("Uploading images");


                test.log(Status.INFO,"Select location");
                test.log(Status.INFO,"Select Province : " + advertCommonPropertiesDTO.getProvince());
                uiOperations.selectByVisibleText(PostAdvertPage.selectProvince, advertCommonPropertiesDTO.getProvince());

                test.log(Status.INFO,"Select City : " + advertCommonPropertiesDTO.getCity());
                uiOperations.selectByVisibleText(PostAdvertPage.selectCity, advertCommonPropertiesDTO.getCity());

                test.log(Status.INFO,"Select Suburb : " + advertCommonPropertiesDTO.getSuburb());
                uiOperations.selectByVisibleText(PostAdvertPage.selectSuburb, advertCommonPropertiesDTO.getSuburb());
                test.pass("Select location");

                test.log(Status.INFO,"set phone number : " + advertCommonPropertiesDTO.getPhone());
                uiOperations.setText(PostAdvertPage.inputPhoneNumber, advertCommonPropertiesDTO.getPhone());
                test.pass("set phone number");

                test.log(Status.INFO,"Click the submit button ");
                uiOperations.clickElement(PostAdvertPage.submitButton);
                if(uiOperations.isElementPresent(PostAdvertPage.postAdSuccessElement)){
                    test.pass("Click the submit button");
                }else{
                    test.fail("Click the submit button. element postAdSuccessElement not found");
                }
            }

        } catch (Exception ex) {
            test.fail(ex.getMessage());
            Assert.fail(ex.getMessage());
        }
    }
}
