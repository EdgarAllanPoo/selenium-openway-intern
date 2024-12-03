package cart;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @DataProvider(name = "testData")
    public Object[][] getTestData() {
        return new Object[][]{
                {"rakeanraiza@gmail.com", "openwaytest", "Blue Sisters", "1"}
        };
    }

    @Test(dataProvider = "testData")
    public void addProductToCart(String email, String password, String productName, String expectedQuantity) {
        basePage.checkPreloader();
        var loginPage = homePage.clickSignInButton();

        basePage.checkPreloader();
        var accountPage = loginPage.login(email, password);

        basePage.checkPreloader();
        var searchResultPage = accountPage.searchForProduct(productName);

        basePage.checkPreloader();
        var selectedProductPage = searchResultPage.clickProductLink(productName);

        basePage.checkPreloader();
        selectedProductPage.clickAddToCart();
        selectedProductPage.clickClosePopUp();
        var cartPage = selectedProductPage.clickCartButton();

        basePage.checkPreloader();
        var actualQuantity = cartPage.getProductQuantity();

        Assert.assertEquals(actualQuantity, expectedQuantity,
                "Expected product quantity in the cart was " + expectedQuantity +
                        ", but found " + actualQuantity);    }
}
