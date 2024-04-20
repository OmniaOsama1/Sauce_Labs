package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class shoppingCart {
    private final WebDriver driver;
    //private By removeItem_shoppingCart=By.id("remove-sauce-labs-backpack");
    private final By checkout=By.id("checkout");
    public shoppingCart(WebDriver driver){
        this.driver=driver;
    }
    public checkout ClickCheckOut(){
        driver.findElement(checkout).click();
        return new checkout(driver);
    }
}
