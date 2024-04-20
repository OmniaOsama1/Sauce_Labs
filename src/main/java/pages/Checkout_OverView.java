package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout_OverView {
    private final WebDriver driver;
    private final By finishButton=By.id("finish");
    public Checkout_OverView(WebDriver driver){
        this.driver=driver;
    }
    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }
}
