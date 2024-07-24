package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class NavigationBar extends BasePage {

    private By homeButton = By.xpath("//*[@id=\"menu-item-40\"]/a");
    private By predictionBattleButton = By.xpath("//*[@id=\"menu-item-2305\"]/a");
    private By storeButton = By.xpath("//*[@id=\"menu-item-1530\"]/a");
    private By signUpButton = By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/div/div[2]/div/div/div/div/div[1]/a");
    private By signInButton = By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/div/div[2]/div/div/div/div/div[2]/a");

    public NavigationBar(WebDriver driver) {
        super(driver);
    }
    @Override
    public NavigationBar newInstance(WebDriver driver) {
        return new NavigationBar(driver);
    }

    public void clickHomeButton() {
        clickElement(homeButton);
    }
    public void clickPredictionBattleButton() {
        clickElement(predictionBattleButton);
    }
    public void clickStoreButton() {
        clickElement(storeButton);
    }
    public void clickSignUpButton() {
        clickElement(signUpButton);
    }
    public void clickSignInButton() {
        clickElement(signInButton);
    }

    public boolean isHomeButtonActive() {
        WebElement homeButton = driver.findElement(By.className("awb-menu__main-background-active"));
        return homeButton.getAttribute("class").contains("awb-menu__main-background-active_center-vertical");
    }
    public boolean isPredictionBattleButtonActive() {
        WebElement homeButton = driver.findElement(By.className("awb-menu__main-background-active"));
        return homeButton.getAttribute("class").contains("awb-menu__main-background-active_center-vertical");
    }
    public boolean isStoreButtonActive() {
        WebElement homeButton = driver.findElement(By.className("awb-menu__main-background-active"));
        return homeButton.getAttribute("class").contains("awb-menu__main-background-active_center-vertical");
    }
    public void hoverPredictionBattleButton(){
        hoverElement(predictionBattleButton);
    }
    public String getPredictionBattleFontType() {
        return driver.findElement(predictionBattleButton).getCssValue("font-family");
    }
    public String getPredictionBattleButtonFontSize() {
        return driver.findElement(predictionBattleButton).getCssValue("font-size");
    }
    public String getPredictionBattleButtonColor(){
        Color predictionBattleButtonColor = Color.fromString(driver.findElement(predictionBattleButton).getCssValue("color"));
        return predictionBattleButtonColor.asHex();
    }
    public String getSignUpButtonFontType() {
        return driver.findElement(signUpButton).getCssValue("font-family");
    }

    public String getSignUpButtonFontSize() {
        return driver.findElement(signUpButton).getCssValue("font-size");
    }
    public String getSignUpButtonColor(){
        Color signUpButtonColor = Color.fromString(driver.findElement(signUpButton).getCssValue("color"));
        return signUpButtonColor.asHex();
    }
    public String getSignUpButtonHoverColor(){
        Color signUpHoverButtonColor = Color.fromString(driver.findElement(signUpButton).getCssValue("background-color"));
        return signUpHoverButtonColor.asHex();
    }
    public void hoverSignInButton(){
        hoverElement(signInButton);
    }
    public String getSignInButtonFontType() {
        return driver.findElement(signInButton).getCssValue("font-family");
    }
    public String getSignInButtonFontSize() {
        return driver.findElement(signInButton).getCssValue("font-size");
    }
    public String getSignInButtonActiveColor(){
        Color signInButtonColor = Color.fromString(driver.findElement(signInButton).getCssValue("background-color"));
        return signInButtonColor.asHex();
    }
    public String getSignInButtonHoverColor(){
        Color signInHoverButtonColor = Color.fromString(driver.findElement(signInButton).getCssValue("background-color"));
        return signInHoverButtonColor.asHex();
    }
}