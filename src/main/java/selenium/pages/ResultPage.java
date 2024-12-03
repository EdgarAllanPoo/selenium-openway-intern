package selenium.pages;

import org.openqa.selenium.By;

public class ResultPage extends BasePage {

    public ProductPage clickProductLink(String productName) {
        By productLink = By.linkText(productName);
        click(productLink);
        return new ProductPage();
    }
}
