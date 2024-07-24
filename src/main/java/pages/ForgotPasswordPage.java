package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ForgotPasswordPage extends BasePage{
    private By forgotPasswordTitle = By.cssSelector("h4.fusion-title-heading");
    private By backButton = By.xpath("//*[@id=\"recovery-password\"]/div/div/form/div/div/div/div/div[1]/a");
    private By emailField = By.id("email");
    private By recoveryPasswordButton = By.xpath("//*[@id=\"recovery-password\"]/div/div/form/div/div/div/div/div[5]/div/button");
    private By successfulMessage =  By.cssSelector("#recovery-notification .alert-success");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ForgotPasswordPage newInstance(WebDriver driver) {
        return new ForgotPasswordPage(driver);
    }

    public String getForgotPasswordPageTitleText(){return
            getTextFromElement(forgotPasswordTitle);}
    public String getSuccessfulMessageText() {
        return getTextFromElement(successfulMessage);
    }
    public boolean isSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            WebElement messageBox = wait.until(ExpectedConditions.visibilityOfElementLocated(successfulMessage));
            return messageBox.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clickBackButton(){clickElement(backButton);}
    public void clickRecoveryButton(){WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(recoveryPasswordButton));
        button.click();}
    public void insertEmail(String email){
        insertText(emailField,email);
    }
}
