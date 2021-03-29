package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class MainPage extends BasePage {

    private String popularProductXPath = "//*[@id='box-popular-products']//*[@class='product-column'][%s]";
    private By popularProducts = By.cssSelector("#box-popular-products .product-column");
    private By addToCartBtn = By.cssSelector("[name=add_cart_product]");
    private By itemsCountLabel = By.cssSelector(".badge.quantity");

    private Random random = new Random();
    private final By declineCookies = By.name("decline_cookies");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public MainPage goTo(){
        driver.get(BASE_URL);
        return this;
    }

    private void addRandomProduct() {
        if (isElementPresent(declineCookies)) {
            click(declineCookies);
            //driver.findElement(declineCookies).click();
        }
        int items = driver.findElements(popularProducts).size();
        WebElement item = wait.until(elementToBeClickable(By.xpath(String.format(popularProductXPath, random.nextInt(items) + 1))));
        new Actions(driver).moveToElement(item).pause(500).click(item).perform();
    }

    public void addProductsToTheCart(Integer itemsCount) {

        for (int i = 1; i <= itemsCount; i++) {
            addRandomProduct();
            wait.until(elementToBeClickable(addToCartBtn)).click();
            wait.until(textToBePresentInElementLocated(itemsCountLabel, String.valueOf(i)));
            driver.get(BASE_URL);
        }
        assertThat(driver.findElement(itemsCountLabel).getText(), is(String.valueOf(itemsCount)));
    }




}
