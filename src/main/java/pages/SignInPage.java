package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    private By signInPageTitle = By.xpath("//*[@id=\"login-page\"]/div/div/form/div/div/div[1]/div/div[1]/h1");
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By checkboxRememberPassword = By.id("checkbox-remember_password-1-0");
    private By loginButton = By.id("login-btn");
    private By forgotPasswordButton = By.xpath("//*[@id=\"login-page\"]/div/div/form/div/div/div[1]/div/div[4]/div[2]/div/div/p/a");
    private By errorMessages = By.xpath("//*[@id=\"login-notification\"]/div[1]/div/span[2]");
    private By signUpNowHrefButton = By.xpath("//*[@id=\"login-page\"]/div/div/form/div/div/div[1]/div/div[7]/p/a");
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignInPage newInstance(WebDriver driver) {
        return new SignInPage(driver);
    }

    public void insertUsername(String username){
        insertText(usernameField,username);
    }
    public void insertPassword(String password){
        insertText(passwordField,password);
    }
    public boolean isCheckboxChecked() {
        return isElementChecked(checkboxRememberPassword);
    }
    public void clickLoginButton() {
        clickElement(loginButton);
    }
    public void clickForgotPasswordButton() {
        clickElement(forgotPasswordButton);
    }
    public void clickSignUpNowButton() {
        clickElement(signUpNowHrefButton);
    }
    public String getErrorMessages() {
        return getTextFromElement(errorMessages);
    }
    public String getSignInPageTitleText(){return
            getTextFromElement(signInPageTitle);}
}
