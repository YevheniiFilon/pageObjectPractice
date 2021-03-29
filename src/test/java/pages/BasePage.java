package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    String BASE_URL = "http://158.101.173.161";

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void waitVisibility(By elementBy){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public void click(By element){
        waitVisibility(element);
        driver.findElement(element).click();
    }

    public boolean isElementPresent(By element) {
        return driver.findElements(element).size() > 0;
    }
}
