package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class HomePage extends BasePage {
    private By homePageTitle = By.xpath("//*[@id=\"post-15\"]/div/div[1]/div/div[1]/div/div/div/div/ul/li[2]/div[1]/div/div[1]/div/div");
    private By logoutButton = By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/div/div[2]/div/div/div[1]/div/div");
    private By accountButton = By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/div/div[2]/div/div/div[2]/div/div[2]/a");
    private By signUpNowButton = By.xpath("//*[@id=\"post-15\"]/div/div[1]/div/div[1]/div/div/div/div/ul/li[2]/div[1]/div/div[3]/div/a");
    private By predictingSportsSection = By.xpath("//*[@id=\"post-15\"]/div/div[2]/div/div[7]/div/div/span");
    private By earnPointsSection = By.xpath("//*[@id=\"post-15\"]/div/div[2]/div/div[8]/div/div[2]/span");
    private By exchangeForPrizeSection = By.xpath("//*[@id=\"post-15\"]/div/div[2]/div/div[9]/div/div[2]/span");
    private By signUpNowBigButton = By.xpath("//*[@id=\"post-15\"]/div/div[2]/div/div[12]/div/div/a");
    private By firstFAQ = By.xpath("//*[@id=\"toggle_827d3f3ac5f06d064\"]/a");
    private By firstFAQContent = By.id("827d3f3ac5f06d064");
    private By freeHrefButton = By.xpath("//*[@id=\"827d3f3ac5f06d064\"]/div/p/a");
    private By secondFAQ = By.xpath("//*[@id=\"toggle_a1c7c9cb2c6f1a0da\"]/a");
    private By secondFAQContent = By.id("a1c7c9cb2c6f1a0da");
    private By thirdFAQ = By.xpath("//*[@id=\"toggle_daa9ae3fbe8245d9b\"]/a");
    private By thirdFAQContent = By.id("daa9ae3fbe8245d9b");
    private By fourthFAQ = By.xpath("//*[@id=\"toggle_08fef361d5f488c7b\"]/a");
    private By fourthFAQContent = By.id("08fef361d5f488c7b");
    private By fifthFAQ = By.xpath("//*[@id=\"toggle_131477e4d74be3078\"]/a");
    private By fifthFAQContent = By.id("131477e4d74be3078");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage newInstance(WebDriver driver) {
        return new HomePage(driver);
    }

    public String getMainPageTitleText(){
        return getTextFromElement(homePageTitle);
    }
    public void clickAccountButton(){clickElement(accountButton);}
    public void clickSignUpNowTopButton(){clickElement(signUpNowButton);}
    public void clickPredictingSportsSection(){clickElement(predictingSportsSection);}
    public void clickEarnPointsSection(){clickElement(earnPointsSection);}
    public void clickExchangeForPrizeSection(){clickElement(exchangeForPrizeSection);}
    public void clickSignUpNowBigButton(){clickElement(signUpNowBigButton);}
    public void clickFirstFAQButton(){clickElement(firstFAQ);}
    public void clickSecondFAQButton(){clickElement(secondFAQ);}
    public void clickThirdFAQButton(){clickElement(thirdFAQ);}
    public void clickFourthFAQButton(){clickElement(fourthFAQ);}
    public void clickFifthFAQButton(){clickElement(fifthFAQ);}
    public void clickFreeHrefButton(){clickElement(freeHrefButton);}
    public void hoverAccountButton(){
        hoverElement(accountButton);
    }
    public void hoverPredictingSportsSection(){
        hoverElement(predictingSportsSection);
    }
    public void hoverEarnPointsSection(){
        hoverElement(earnPointsSection);
    }
    public void hoverExchangeForPrizeSection(){
        hoverElement(exchangeForPrizeSection);
    }
    public void hoverSignUpNowButton(){
        hoverElement(signUpNowButton);
    }
    public void hoverSignUpNowBigButton(){
        hoverElement(signUpNowBigButton);
    }
    public String getPredictingSportsText(){return
            getTextFromElement(predictingSportsSection);}
    public String getEarnPointsText(){return
            getTextFromElement(earnPointsSection);}
    public String getExchangeForPrizeText(){return
            getTextFromElement(exchangeForPrizeSection);}
    public String getFirstFAQText(){return
            getTextFromElement(firstFAQ);}
    public String getFirstFAQContentText(){return
            getTextFromElement(firstFAQContent);}
    public String getSecondFAQText(){return
            getTextFromElement(secondFAQ);}
    public String getSecondFAQContentText(){return
            getTextFromElement(secondFAQContent);}
    public String getThirdFAQText(){return
            getTextFromElement(thirdFAQ);}
    public String getThirdFAQContentText(){return
            getTextFromElement(thirdFAQContent);}
    public String getFourthFAQText(){return
            getTextFromElement(fourthFAQ);}
    public String getFourthFAQContentText(){return
            getTextFromElement(fourthFAQContent);}
    public String getFifthFAQText(){return
            getTextFromElement(fifthFAQ);}
    public String getFifthFAQContentText(){return
            getTextFromElement(fifthFAQContent);}
    public boolean isFirstFAQActive() {
        return isElementActive(firstFAQ);
    }
    public boolean isFirstFAQCollapsed() {
        return isElementCollapsed(firstFAQ);
    }
    public boolean isSecondFAQActive() {
        return isElementActive(secondFAQ);
    }
    public boolean isSecondFAQCollapsed() {
        return isElementCollapsed(secondFAQ);
    }
    public boolean isThirdFAQActive() {
        return isElementActive(thirdFAQ);
    }
    public boolean isThirdFAQCollapsed() {
        return isElementCollapsed(thirdFAQ);
    }
    public boolean isFourthFAQActive() {
        return isElementActive(fourthFAQ);
    }
    public boolean isFourthFAQCollapsed() {
        return isElementCollapsed(fourthFAQ);
    }
    public boolean isFifthFAQActive() {
        return isElementActive(fifthFAQ);
    }
    public boolean isFifthFAQCollapsed() {
        return isElementCollapsed(fifthFAQ);
    }
    public boolean isLogOutButtonDisplayed(){return isElementDisplayed(logoutButton);}
    public String getSignUpNowButtonFontType() {
        return driver.findElement(signUpNowButton).getCssValue("font-family");
    }
    public String getSignUpNowButtonFontSize() {
        return driver.findElement(signUpNowButton).getCssValue("font-size");
    }
    public String getSignUpNowButtonHoverColor(){
        Color signUpNowButtonColor = Color.fromString(driver.findElement(signUpNowButton).getCssValue("background-color"));
        return signUpNowButtonColor.asHex();
    }
    public String getSignUpNowBigButtonFontType() {
        return driver.findElement(signUpNowBigButton).getCssValue("font-family");
    }
    public String getSignUpNowBigButtonFontSize() {
        return driver.findElement(signUpNowBigButton).getCssValue("font-size");
    }
    public String getSignUpNowBigButtonHoverColor(){
        Color signUpNowBigButtonColor = Color.fromString(driver.findElement(signUpNowBigButton).getCssValue("background-color"));
        return signUpNowBigButtonColor.asHex();
    }
    public String getFreeHrefButtonColor(){
        Color freeHrefButtonColor = Color.fromString(driver.findElement(freeHrefButton).getCssValue("color"));
        return freeHrefButtonColor.asHex();
    }
    public String getAccountButtonColor(){
        Color accountButtonColor = Color.fromString(driver.findElement(accountButton).getCssValue("background-color"));
        return accountButtonColor.asHex();
    }
    public String getAccountTextButtonColor(){
        Color accountButtonColor = Color.fromString(driver.findElement(accountButton).getCssValue("color"));
        return accountButtonColor.asHex();
    }
}