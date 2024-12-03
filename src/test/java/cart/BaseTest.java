package cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import selenium.pages.BasePage;
import selenium.pages.HomePage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected BasePage basePage;
    protected HomePage homePage;
    private String url = "https://www.periplus.com/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        basePage = new BasePage();
        basePage.setDriver(driver);
        basePage.setWait(wait);

        homePage = new HomePage();
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
