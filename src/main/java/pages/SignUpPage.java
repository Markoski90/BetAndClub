package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpPage extends BasePage {
    private By signUpPageTitle = By.xpath("//*[@id=\"sign-up\"]/div/div/div/div/form/div/div/div[1]/div/div[1]/h4");
    private By usernameField = By.id("username");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By radioGenderMale = By.id("radio-gendertypeid-1-0");
    private By radioGenderFemale = By.id("radio-gendertypeid-1-1");
    private By labelGenderMale = By.xpath("//label[@for='radio-gendertypeid-1-0']");
    private By labelGenderFemale = By.xpath("//label[@for='radio-gendertypeid-1-1']");
    private By dropdownCountries = By.id("countries");
    private By birthDateField = By.id("birthDate");
    private By checkboxAdult = By.id("checkbox-adult-1-0");
    private By checkboxMarketing = By.id("checkbox-marketingauth-2-0");
    private By signUpNowButtonn = By.cssSelector("#sign-up-btn .fusion-button");
    private By messageSuceess =By.cssSelector("#register-notification .alert-success");
    private By messageError = By.cssSelector("#register-notification .alert-danger");
    private By loginHrefButton = By.xpath("//*[@id=\"sign-up\"]/div/div/div/div/form/div/div/div[1]/div/div[15]/p/a");
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignUpPage newInstance(WebDriver driver) {
        return new SignUpPage(driver);
    }
    public String getSignUpPageTitleText(){return
            getTextFromElement(signUpPageTitle);}
    public void insertUsername(String username){
        insertText(usernameField,username);
    }
    public void insertEmail(String email){
        insertText(emailField,email);
    }
    public void insertPassword(String password){
        insertText(passwordField,password);
    }
    public void insertFirstName(String firstName){
        insertText(firstNameField,firstName);
    }
    public void insertLastName(String lastName){
        insertText(lastNameField,lastName);
    }
    public void setBirthDate(String date) {
        setDate(birthDateField, date);
    }
    public String getBirthDate() {
        return getDate(birthDateField);
    }
    public void hoverSignUpNowButton(){
        hoverElement(signUpNowButtonn);
    }
    public void selectGender(String gender) {
        if ("male".equalsIgnoreCase(gender)) {
            selectRadioButton(labelGenderMale, radioGenderMale);
        } else if ("female".equalsIgnoreCase(gender)) {
            selectRadioButton(labelGenderFemale, radioGenderFemale);
        }
    }
    private void selectRadioButton(By label, By radio) {
        WebElement radioButton = driver.findElement(radio);
        if (!radioButton.isSelected()) {
            driver.findElement(label).click();
            wait.until(ExpectedConditions.elementToBeSelected(radio));
        }
    }
    public boolean isGenderSelected(String gender) {
        if ("male".equalsIgnoreCase(gender)) {
            return isElementChecked(radioGenderMale);
        } else if ("female".equalsIgnoreCase(gender)) {
            return isElementChecked(radioGenderFemale);
        }
        return false;
    }
    public void clickCountryButton() {
        clickElement(dropdownCountries);
    }
    public void clickLoginHrefButton(){clickElement(loginHrefButton);}
    public void clearUsernameField() {

            WebElement element = driver.findElement(usernameField);
            Actions actions = new Actions(driver);
            actions.click(element)
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .sendKeys(Keys.BACK_SPACE)
                    .perform();
        }

    public void clickAdultCheckbox() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(checkboxAdult));

            ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", checkbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", checkbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

        } catch (Exception e) {
            System.out.println("Error clicking adult checkbox: " + e.getMessage());
            throw e;
        }
    }

    public boolean isAdultCheckboxChecked() {
        return isElementChecked(checkboxAdult);
    }

   public void clickCheckBoxMarketingButton() {
       try {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

           WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(checkboxMarketing));

           ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", checkbox);
           ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", checkbox);
           ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
           ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

       } catch (Exception e) {
           System.out.println("Error clicking marketing checkbox: " + e.getMessage());
           throw e;
       }
   }
    public boolean isMarketingCheckboxChecked() {
        return isElementChecked(checkboxMarketing);
    }
    public void clickSignUpNowButton() {
        WebElement signUpNowButton = driver.findElement(signUpNowButtonn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", signUpNowButton);

        try {
            signUpNowButton.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", signUpNowButton);
        }
    }

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