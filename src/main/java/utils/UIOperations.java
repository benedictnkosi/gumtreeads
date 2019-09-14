package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PostAdvertPage;
import properties.Application;

public class UIOperations {

    WebDriver driver;

    public UIOperations(WebDriver driver){
        this.driver = driver;
    }

    public void setText(By element, String text) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }

    public void sendKeysOnly(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public void clickElement(By element) {
        if (isElementPresent(element)) {
            driver.findElement(element).click();
        }
    }


    public void selectByVisibleText(By element, String value) {
        Select drpElement = new Select(driver.findElement(element));
        drpElement.selectByVisibleText(value);
    }


    public void switchToFrame(By element) throws InterruptedException {
        WebElement elementIFRAME = driver.findElement(element);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementIFRAME);
        Thread.sleep(5000);

        Actions actions2 = new Actions(driver);
        actions2.moveToElement(elementIFRAME);


        driver.switchTo().frame(elementIFRAME);


    }

    public boolean uploadImages(By element, String images) throws Exception{
        try{


        StringUtils stringUtils = new StringUtils();
        String[] imagesArray = stringUtils.splitStringByDelimeter(images, Application.imagesDelimeter);
        for(String image:imagesArray){
            System.out.println(image);
            driver.findElement(element)
                    .sendKeys(Application.imagesFilePath +image );
        }

        String   imageUploadSuccessElementXpath = PostAdvertPage.imageUploadSuccessElement.replace("{index}",String.valueOf(imagesArray.length));
        By imageUploadSuccessElement = By.xpath(imageUploadSuccessElementXpath);
        //check if last image uploaded is complete
        for (int second = 0;; second++) {
            if (second <= Application.uploadImagesTimeOut) {
                WebElement ele = driver.findElement(imageUploadSuccessElement);

                try {
                    if (!ele.getAttribute("class").contains("no-photo"))
                        break;
                } catch (Exception e) {
                }
                Thread.sleep(1000);
                System.out.println("Still Uploading pics");
            } else {
                return false;
            }

        }

        return true;

        }catch (Exception ex){
            return false;
        }

    }






    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {

        }
    }


}
