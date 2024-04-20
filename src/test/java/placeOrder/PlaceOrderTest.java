package placeOrder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class PlaceOrderTest {
    private WebDriver driver;
    @Test(priority=1)
    public void testPlaceOrder(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        HomePage homePage=loginPage.clickLogin();
        ProductPage productPage= homePage.enterProductPage();
        productPage.addProductToCart();
        shoppingCart shoppingCart =productPage.clickShoppingCart();
        checkout checkout=shoppingCart.ClickCheckOut();
        checkout.enterCheckout_FirstName("Test");
        checkout.enterCheckout_LastName("test");
        checkout.enterCheckout_PostalCode("0000");
        Checkout_OverView checkoutOverview=checkout.continueToCheckOut();
        checkoutOverview.clickFinishButton();

    }
    @Test(priority=2)
    public void verifyCheckoutIconIsDisplayed(){
        Checkout_Complete checkoutComplete=new Checkout_Complete(driver);
        var checkoutIcon =checkoutComplete.isCheckoutComplete_Image();
        Assert.assertTrue(checkoutIcon,"Checkout Complete Image Is not Displayed");
    }
    @Test(priority=3)
    public void verifyCheckoutHeaderText(){
        Checkout_Complete checkoutComplete=new Checkout_Complete(driver);
        String checkoutCompleteHeaderText =checkoutComplete.getCheckoutComplete_HeaderText();
        Assert.assertEquals(checkoutCompleteHeaderText,"Thank you for your order!","Incorrect Header");
    }
    @Test(priority=4)
    public void verifyCheckoutText(){
        Checkout_Complete checkoutComplete=new Checkout_Complete(driver);
        String checkoutCompleteText =checkoutComplete.getCheckoutComplete_Text();
        Assert.assertEquals(checkoutCompleteText,"Your order has been dispatched, and will arrive just as fast as the pony can get there!","Incorrect Text");
    }
    @Test(priority=5)
    public void backToHomePage(){
        Checkout_Complete checkoutComplete=new Checkout_Complete(driver);
        HomePage homePage= checkoutComplete.clickBackToHomePageButton();
        String homePageTitle= homePage.getHomePageTitle();
        Assert.assertEquals(homePageTitle,"Swag Labs","Incorrect Page Title");
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
