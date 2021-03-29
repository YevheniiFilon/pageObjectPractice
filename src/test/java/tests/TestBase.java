package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.MainPage;

public class TestBase {

    private WebDriver driver;
    private WebDriverWait wait;

    MainPage mainPage;
    CartPage cartPage;


    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,5);
        mainPage = new MainPage(driver,wait);
        cartPage = new CartPage(driver,wait);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
