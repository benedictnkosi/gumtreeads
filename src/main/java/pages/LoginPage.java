package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    Homepage homepage;

    By userName = By.name("email");
    By password = By.name("password");
    By loginButton = By.id("login-button");
    By successLoginElement = By.className("icon-ChatBubbles");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setUserName(String strUserName) {
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(strUserName);
    }

    //set password in textbox
    public void setPassword(String strPassword) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(strPassword);
    }

    //set password in textbox
    public void clickLoginButton() {

        driver.findElement(loginButton).click();


    }

    public boolean isUserLoggedIn() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(successLoginElement));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void LoginUser(String username, String password) {

        this.setUserName(username);
        this.setPassword(password);
        this.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(successLoginElement));


    }
}
