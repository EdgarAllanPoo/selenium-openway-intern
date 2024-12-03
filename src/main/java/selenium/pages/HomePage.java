package selenium.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By signInButton = By.linkText("Sign In");

    public LoginPage clickSignInButton() {
        click(signInButton);
        return new LoginPage();
    }
}
