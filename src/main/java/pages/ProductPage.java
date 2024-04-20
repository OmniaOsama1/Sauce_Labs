package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private final WebDriver driver;
    private final By addToCartButton = By.id("add-to-cart");
    public By productName = By.xpath("//div[text()='Sauce Labs Backpack']");
    public By productDetails = By.xpath("//div[contains(text(),'sleek')]");
    private final By productPrice = By.className("inventory_details_price");
    private final By productImage= By.className("inventory_details_img");
    private final By backButton = By.id("back-to-products");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By shoppingCart = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return this.driver.findElement(this.productName).getText();
    }

    public String getProductDetails() {
        return this.driver.findElement(this.productDetails).getText();
    }

    public String getProductPrice() {
        return this.driver.findElement(this.productPrice).getText();
    }

    public boolean confirmProductImageIsDisplayed() {
        return this.driver.findElement(this.productImage).isDisplayed();
    }

    public void addProductToCart() {
        this.driver.findElement(this.addToCartButton).click();
    }

    public void pressBackButtonToHomePage() {
        this.driver.findElement(this.backButton).click();
    }

    public String getCartBadge() {
        return this.driver.findElement(this.cartBadge).getText();
    }

    public shoppingCart clickShoppingCart() {
        this.driver.findElement(this.shoppingCart).click();
        return new shoppingCart(this.driver);
    }
}
