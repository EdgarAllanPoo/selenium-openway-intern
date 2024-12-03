package selenium.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.id("button-login");

    public void setEmail(String email) {
        set(emailField, email);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public AccountPage login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();

        return new AccountPage();
    }
}
