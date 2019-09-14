package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostAdvertPage {

    public static By propertyCategory = By.xpath("//div[contains(text(),'Property')]");
    public static By serviceCategory = By.xpath("//div[contains(text(),'Services')]");
    public static By selectedCategoryMessage = By.className("postad-category-type");
    public static By inputTittle = By.xpath("//div[contains(@class, 'title-input-wrapper')]/div/textarea");
    public static By descriptionFrame = By.xpath("//iframe[contains(@id,'iframe-description')]");
    public static By descriptionInput = By.id("rte");

    //location dropdown
    public static By selectProvince = By.className("location-select-l1");
    public static By selectCity = By.className("location-select-l2");
    public static By selectSuburb = By.className("location-select-l3");

    //sub category dropdown
    public static By selectSubCategory = By.xpath("//div[contains(@class, 'category-selection')]//select");

    //about property fields
    public static By selectParking = By.xpath("//div[contains(text(), 'Parking')]//..//following-sibling::div[1]//select");
    public static By selectOwner = By.xpath("//div[contains(text(), 'For Rent By')]//..//following-sibling::div[1]//select");
    public static By selectDwelling = By.xpath("//div[contains(text(), 'Dwelling Type')]//..//following-sibling::div[1]//select");
    public static By selectBathrooms = By.xpath("//div[contains(text(), 'Bathrooms (#)')]//..//following-sibling::div[1]//select");
    public static By selectBedrooms = By.xpath("//div[contains(text(), 'Bedrooms (#)')]//..//following-sibling::div[1]//select");
    public static By inputSleeps = By.xpath("//input[@placeholder='Enter the Sleeps']");

    //price
    public static By selectPriceType = By.className("price-type");
    public static By inputPrice = By.xpath("//input[@placeholder='Type your price']");

    //phone number
    public static By inputPhoneNumber = By.xpath("//input[@placeholder='type your phone number']");

    //post button
    public static By submitButton = By.xpath("//div[@class='post-button-wrapper']//span[text()='Post']");

    //images success element
    public static String imageUploadSuccessElement = "//*[contains(@class, 'image-container')]/div[{index}]";

    //images upload
    public static By inputImageUpload = By.name("pic");

    //post advert success element
    public static By postAdSuccessElement = By.className("icon-gl-message-success");



}
