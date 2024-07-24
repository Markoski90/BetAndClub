package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FooterBar extends BasePage {
    private By languageDropdown = By.cssSelector(".gt_float_switcher");
    private By japaneseOption= By.cssSelector("a[data-gt-lang='ja']");
    private By aboutUsButton = By.id("menu-item-1350");
    private By cotactUsButton = By.id("menu-item-1347");
    private By termsAndConditionsButton = By.id("menu-item-1348");
    private By privacyPolicyButton = By.id("menu-item-1349");

    public FooterBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public FooterBar newInstance(WebDriver driver) {
        return new FooterBar(driver);
    }

    public void selectJapaneseLanguage() {
        wait.until(ExpectedConditions.elementToBeClickable(languageDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(japaneseOption));
        wait.until(ExpectedConditions.elementToBeClickable(japaneseOption)).click();
    }
    public void clickAboutUsButton(){clickElement(aboutUsButton);}
    public void clickContactUsButton(){clickElement(cotactUsButton);}
    public void clickTermsAndConditionsButton(){clickElement(termsAndConditionsButton);}
    public void clickPrivacyPolicyButton(){clickElement(privacyPolicyButton);}
    public void hoverAboutUsButton(){
        hoverElement(aboutUsButton);
    }
    public void hoverContactUsButton(){
        hoverElement(cotactUsButton);
    }
    public void hoverTermsAndConditionsButton(){
        hoverElement(termsAndConditionsButton);
    }
    public void hoverPrivacyPolicyButton(){
        hoverElement(privacyPolicyButton);
    }

}
