package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    By userNameField =By.id("user-name");
    By passwordField =By.id("password");
    By loginButton=By.id("login-button");
    By loginError=By.xpath("//div/h3");
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void enterUserName(String User){
        driver.findElement(userNameField).sendKeys(User);
    }
    public void enterPassword(String Password){
        driver.findElement(passwordField).sendKeys(Password);
    }
    public HomePage clickLogin(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
    public String incorrectCredentials_ErrorMessage(){
        return driver.findElement(loginError).getText();
    }
}
