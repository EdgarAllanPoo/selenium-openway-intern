package selenium.pages;

import org.openqa.selenium.By;

public class AccountPage extends BasePage{

    private By searchBar = By.id("filter_name");
    private By searchButton = By.xpath("//div[@class='search-bar']//button[contains(@class, 'btnn')]");
    private By searchMobileButton = By.xpath("//div[@class='search-bar mobilephone']//button[contains(@class, 'btnn')]");

    public void setSearchBar(String query) {
        set(searchBar, query);
    }

    public void clickSearchButton() {
        var search = find(searchButton);
        var searchMobile = find(searchMobileButton);

        if (search.isDisplayed()) {
            search.click();
        } else {
            searchMobile.click();
        }
    }

    public ResultPage searchForProduct(String productName) {
        setSearchBar(productName);
        clickSearchButton();

        return new ResultPage();
    }

}
