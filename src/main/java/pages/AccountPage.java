package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountPage extends BasePage{
    private By accountTitle = By.xpath("//*[@id=\"my-details\"]/div/div[1]/div/div/h1");
    private By currentPasswordField = By.id("current_password");
    private By newPasswordField = By.id("new_password");
    private By repeatNewPasswordField = By.id("repeat_new_password");
    private By updatePasswordButton = By.id("change-password-btn");
    private By messageSuceess = By.cssSelector(".fusion-alert.alert-success");
    private By messageError = By.cssSelector(".fusion-alert.alert-danger");
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountPage newInstance(WebDriver driver) {
        return new AccountPage(driver);
    }

    public String getAccountTitle(){return getTextFromElement(accountTitle);}
    public void currentPasswordField(String password){
        insertText(currentPasswordField,password);
    }
    public void newPasswordField(String newPassword){
        insertText(newPasswordField,newPassword);
    }
    public void repeatNewPasswordField(String repeatPassword){
        insertText(repeatNewPasswordField,repeatPassword);
    }
    public void clickUpdatePasswordButton(){clickElement(updatePasswordButton);}

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(messageSuceess));
        return successMessageElement.getText();
    }
    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(messageError));
        return errorMessageElement.getText();
    }
}
