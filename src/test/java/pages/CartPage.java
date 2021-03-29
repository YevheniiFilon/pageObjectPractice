package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

//TaskOne
public class CartPage extends BasePage{

    private By openCart = By.cssSelector("#cart");
    private By cartItemsTable = By.cssSelector(".items.list-unstyled");
    private By deleteItemBtn = By.cssSelector("[name='remove_cart_item']");
    private By noItemsTxt = By.xpath("//*[text()='There are no items in your cart.']");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void cleanUpCart() {

        wait.until(elementToBeClickable(openCart)).click();

        while (!isElementPresent(noItemsTxt))
        {
            WebElement table = wait.until(elementToBeClickable(cartItemsTable));
            wait.until(elementToBeClickable(deleteItemBtn)).click();
            wait.until(stalenessOf(table));
        }

        driver.get(BASE_URL);
    }
}
