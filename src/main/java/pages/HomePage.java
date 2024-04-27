package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final By dropDownMenu = By.className("product_sort_container");
    private final By itemPrice = By.className("inventory_item_price");
    private final By itemName = By.className("inventory_item_name");
    private final By sideBarMenu = By.id("react-burger-menu-btn");
    private final By LogOut = By.id("logout_sidebar_link");
    private final By homePageTitle = By.className("app_logo");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageTitle() {
        return driver.findElement(homePageTitle).getText();
    }

    public void sort_HighToLowPrice(String text) {
        Select select = new Select(driver.findElement(dropDownMenu));
        select.selectByVisibleText(text);
    }

    public List<Double> beforeSort() {
        List<WebElement> beforeSortElement = driver.findElements(itemPrice);
        ArrayList<Double> beforeSortPrice = new ArrayList<>();
        for (WebElement e : beforeSortElement) {
            beforeSortPrice.add(Double.valueOf(e.getText().replace("$", "")));
        }
        Collections.sort(beforeSortPrice);
        Collections.reverse(beforeSortPrice);
        return beforeSortPrice;
    }

    public List<Double> afterSort() {
        List<WebElement> afterSortElement = driver.findElements(itemPrice);
        ArrayList<Double> afterSortPrice = new ArrayList<>();
        for (WebElement e : afterSortElement) {
            afterSortPrice.add(Double.valueOf(e.getText().replace("$", "")));
        }
        return afterSortPrice;
    }

    public void logOut() {
        driver.findElement(sideBarMenu).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(LogOut));
        driver.findElement(LogOut).click();
    }

    public ProductPage enterProductPage() {
        driver.findElement(itemName).click();
        return new ProductPage(driver);
    }
}
