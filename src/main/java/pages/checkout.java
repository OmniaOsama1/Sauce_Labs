package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkout {
    private final WebDriver driver;
    private final By firstName=By.id("first-name");
    private final By lastName=By.id("last-name");
    private final By postalCode=By.id("postal-code");
    private final By checkoutContinueButton=By.id("continue");
    public checkout(WebDriver driver){
        this.driver=driver;
    }
    public void enterCheckout_FirstName(String FirstName){
        driver.findElement(firstName).sendKeys(FirstName);
    }
    public void enterCheckout_LastName(String LastName){
        driver.findElement(lastName).sendKeys(LastName);
    }
    public void enterCheckout_PostalCode(String PostalCode){
        driver.findElement(postalCode).sendKeys(PostalCode);
    }
    public Checkout_OverView continueToCheckOut(){
        driver.findElement(checkoutContinueButton).click();
        return new Checkout_OverView(driver);
    }
}
