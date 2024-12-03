package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class OldCartTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.periplus.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    private void waitForPreloaderToDisappear() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
    }

    @Test
    public void addProductToCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open Login Page
        waitForPreloaderToDisappear();
        driver.findElement(By.linkText("Sign In")).click();

        // Enter Login Credentials
        waitForPreloaderToDisappear();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("rakeanraiza@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("openwaytest");
        driver.findElement(By.id("button-login")).click();

        // Search for one product
        waitForPreloaderToDisappear();
        driver.findElement(By.id("filter_name")).sendKeys("Blue Sisters");

        WebElement searchDesktop = driver.findElement(By.xpath("//div[@class='search-bar']//button[contains(@class, 'btnn')]"));
        WebElement searchMobile = driver.findElement(By.xpath("//div[@class='search-bar mobilephone']//button[contains(@class, 'btnn')]"));

        if (searchDesktop.isDisplayed()) {
            searchDesktop.click();
        } else {
            searchMobile.click();
        }

        // Open product page
        waitForPreloaderToDisappear();
        driver.findElement(By.linkText("Blue Sisters")).click();

        // Add to Cart
        waitForPreloaderToDisappear();
        driver.findElement(By.cssSelector(".btn.btn-add-to-cart")).click();

        WebElement closePop = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-modal-close.close")));
        closePop.click();

        WebElement cartDesktop = driver.findElement(By.id("show-your-cart"));
        WebElement cartMobile = driver.findElement(By.id("show-your-cart_mobile"));

        if (cartDesktop.isDisplayed()) {
            cartDesktop.click();
        } else {
            cartMobile.click();
        }

        // Check Quantity
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
        String actualResult = driver.findElement(By.id("qty_66692402")).getAttribute("value");
        String expectedResult = "1";
        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(5000);

    }
}
