package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
        WebDriver driver;
        Actions actions;
        WebDriverWait wait;
        public BasePage(WebDriver driver) {
            this.driver = driver;
            actions = new Actions(driver);

        }
        public abstract BasePage newInstance (WebDriver driver);

        public void navigateTo (String url) {
            driver.get(url);
        }

        public void clickElement(By element) {
            driver.findElement(element).click();
        }

        public String getTextFromElement(By element){
            return driver.findElement(element).getText();
        }
        public void insertText(By element,String text){
            driver.findElement(element).sendKeys(text);
        }
        public boolean isElementDisplayed(By element) {
            try {
                driver.findElement(element).getText();
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }
        public boolean isElementChecked(By element) {
            try {
                return driver.findElement(element).isSelected();
            } catch (NoSuchElementException e) {
                return false;
            }
        }
        public boolean isElementEnabled(By element) {
            try {
                WebElement webElement = driver.findElement(element);
                return webElement.isEnabled();
            } catch (NoSuchElementException e) {
                return false;
            }
        }
        public void hoverElement(By locator){
            WebElement element = driver.findElement(locator);
            actions.moveToElement(element).perform();
        }
        public boolean isElementActive(By locator) {
            String ariaExpanded = driver.findElement(locator).getAttribute("aria-expanded");
            return "true".equals(ariaExpanded);
        }
        public boolean isElementCollapsed(By locator) {
            String ariaExpanded = driver.findElement(locator).getAttribute("aria-expanded");
            return "false".equals(ariaExpanded);
        }
        public void setDate(By locator, String date) {
            WebElement dateInput = driver.findElement(locator);
            dateInput.clear();
            dateInput.sendKeys(date);
        }
        public String getDate(By locator) {
            WebElement dateInput = driver.findElement(locator);
            return dateInput.getAttribute("value");
        }
}


