package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactUsPage extends BasePage{
    private By contactUsTitle = By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/div/h2");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By emailField = By.id("email_address");
    private By subjectField = By.id("subject");
    private By messageField = By.id("message");
    private By sendMessageButton = By.xpath("//*[@id=\"post-622\"]/div/div[2]/div/div/div/div/form/div/div/div/div/div[12]/div/button");
    private By successMessageSelector = By.cssSelector(".fusion-alert.alert-success");
    private By errorMessageSelector = By.cssSelector(".fusion-alert.alert-danger");
    public ContactUsPage(WebDriver driver) {super(driver);}
    @Override
    public ContactUsPage newInstance(WebDriver driver) {
        return new ContactUsPage(driver);
    }

    public String getContactUsTitle(){return getTextFromElement(contactUsTitle);}
    public void firstNameField(String firstName) {
        insertText(firstNameField, firstName);
    }
    public void lastNameField(String lastName) {
        insertText(lastNameField, lastName);
    }
    public void emailField(String email) {
        insertText(emailField, email);
    }
    public void subjectField(String subject) {
        insertText(subjectField, subject);
    }
    public void messageField(String message) {
        insertText(messageField, message);
    }
    public void clickSendMessageButton(){clickElement(sendMessageButton);}

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageSelector));
        return successMessageElement.getText();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageSelector));
        return errorMessageElement.getText();
    }
}
