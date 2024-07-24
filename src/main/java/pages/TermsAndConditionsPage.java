package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsAndConditionsPage extends BasePage{
    private By termsAndConditionsTitle = By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/div/h2");
    public TermsAndConditionsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TermsAndConditionsPage newInstance(WebDriver driver) {
        return new TermsAndConditionsPage(driver);
    }

    public String getTermsAndConditionsTitle(){return getTextFromElement(termsAndConditionsTitle);}
}
