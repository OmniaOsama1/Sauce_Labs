package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver;
    @Test (priority=1)
    public void testLogin_ValidCredentials(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        HomePage homePage= loginPage.clickLogin();
        String homePageTitle= homePage.getHomePageTitle();
        Assert.assertEquals(homePageTitle,"Swag Labs","Incorrect Page Title");
    }
    @Test(priority=2)
    public void logout(){
        HomePage homePage=new HomePage(driver);
        homePage.logOut();
    }
    @Test(priority=3)
    public void testLogin_InvalidCredentials(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUserName("Test");
        loginPage.enterPassword("Test");
        loginPage.clickLogin();
        String loginErrorMessage=loginPage.incorrectCredentials_ErrorMessage();
        Assert.assertEquals(loginErrorMessage,"Epic sadface: Username and password do not match any user in this service","Incorrect Error Message");
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
