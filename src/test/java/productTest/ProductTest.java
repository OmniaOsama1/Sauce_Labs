package productTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import loginTest.LoginData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

import java.io.IOException;

public class ProductTest {
    private WebDriver driver;
    @Test
    public void testProduct() throws IOException, ParseException {
        LoginData loginData=new LoginData(driver);
        loginData.loginDataProvider();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUserName(loginData.getUserName());
        loginPage.enterPassword(loginData.getPassword());
        HomePage homePage=loginPage.clickLogin();
        ProductPage product =homePage.enterProductPage();
        var productName= product.getProductName();
        var ProductDetails=product.getProductDetails();
        var productPrice=product.getProductPrice();
        boolean isImageDisplayed=product.confirmProductImageIsDisplayed();
        product.addProductToCart();
        product.pressBackButtonToHomePage();
        var cartBadge=product.getCartBadge();
        Assert.assertEquals(productName,"Sauce Labs Backpack","Error:Product Name is incorrect");
        Assert.assertEquals(ProductDetails,"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.","Error:Product Details is incorrect");
        Assert.assertEquals(productPrice,"$29.99","Error:Product Price is incorrect");
        Assert.assertTrue(isImageDisplayed);
        Assert.assertEquals("1",cartBadge,"Error:Cart Badge number is incorrect");
    }
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
