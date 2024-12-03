package selenium.pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private By productQuantity = By.id("qty_66692402");

    public String getProductQuantity() {
        return getValue(productQuantity, "value");
    }
}
