package sortTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class SortTest {
    private WebDriver driver;
    @Test
    public void testPriceDescendingSort() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        HomePage homepage = loginPage.clickLogin();
        List<Double> beforeSort = homepage.beforeSort();
        System.out.println(homepage.beforeSort());
        homepage.sort_HighToLowPrice("Price (high to low)");
        List<Double> afterSort = homepage.afterSort();
        System.out.println(homepage.afterSort());
        Assert.assertEquals(afterSort, beforeSort);
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
