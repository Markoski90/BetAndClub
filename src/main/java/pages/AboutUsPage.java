package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUsPage extends BasePage{
    private By aboutUsTitle = By.xpath("//*[@id=\"post-575\"]/div/div[1]/div/div[1]/div");
    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AboutUsPage newInstance(WebDriver driver) {
        return new AboutUsPage(driver);
    }
    public String getAboutUsTitle(){return getTextFromElement(aboutUsTitle);}
}
