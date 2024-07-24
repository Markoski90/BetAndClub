package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PrivacyPolicyPage extends BasePage{
    private By privacyPolicyTitle = By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/div/h2");
    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PrivacyPolicyPage newInstance(WebDriver driver) {
        return new PrivacyPolicyPage(driver);
    }

    public String getPrivacyPolicyTitle(){return getTextFromElement(privacyPolicyTitle);}
}
