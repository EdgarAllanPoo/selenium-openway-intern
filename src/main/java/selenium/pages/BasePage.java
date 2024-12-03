package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public void setWait(WebDriverWait wait) {
        BasePage.wait = wait;
    }

    public void checkPreloader() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected String getValue(By locator, String key) {
        return find(locator).getAttribute(key);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void clickWaitUntilClickable(By locator) {
        var button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }
}
