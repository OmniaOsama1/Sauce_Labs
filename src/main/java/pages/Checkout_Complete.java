package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout_Complete {
    private final WebDriver driver;
    public Checkout_Complete(WebDriver driver){
        this.driver=driver;
    }
    private final By checkoutComplete_Image= By.className("pony_express");
    private final By checkoutComplete_Header=By.className("complete-header");
    private final By checkoutComplete_Text=By.className("complete-text");
    private final By backHomeButton=By.id("back-to-products");
    public Boolean isCheckoutComplete_Image(){
        return driver.findElement(checkoutComplete_Image).isDisplayed();
    }
    public String getCheckoutComplete_HeaderText(){
        return driver.findElement(checkoutComplete_Header).getText();
    }
    public String getCheckoutComplete_Text(){
        return driver.findElement(checkoutComplete_Text).getText();
    }
    public HomePage clickBackToHomePageButton(){
        driver.findElement(backHomeButton).click();
        return new HomePage(driver);
    }
}
