package selenium.pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private By addToCartButton = By.cssSelector(".btn.btn-add-to-cart");
    private By closePopUpButton = By.cssSelector(".btn.btn-modal-close.close");
    private By cartButton = By.id("show-your-cart");
    private By cartMobileButton = By.id("show-your-cart_mobile");

    public void clickAddToCart() {
        click(addToCartButton);
    }

    public void clickClosePopUp() {
       clickWaitUntilClickable(closePopUpButton);
    }

    public CartPage clickCartButton() {
        var cart = find(cartButton);
        var cartMobile = find(cartMobileButton);

        if (cart.isDisplayed()) {
            cart.click();
        } else {
            cartMobile.click();
        }

        return new CartPage();
    }
}
