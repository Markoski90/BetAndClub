package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PredictionBattlePage extends BasePage {

    private By predictionBattlePageTitle = By.xpath("//*[@id=\"post-2302\"]/div/div[1]/div/div[1]/div/div");
    private By euro2024Section = By.xpath("//*[@id=\"post-2302\"]/div/div[2]/div/div[2]/div/div");
    private By coppaAmericaSection = By.xpath("//*[@id=\"post-2302\"]/div/div[2]/div/div[3]/div/div");
    private By errorMessage = By.id("match-x-game-euro-cup");
    public PredictionBattlePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PredictionBattlePage newInstance(WebDriver driver) {
        return new PredictionBattlePage(driver);
    }

    public String getPredictionBattleTitleText(){return
            getTextFromElement(predictionBattlePageTitle);}
    public void clickEuro2024Section(){clickElement(euro2024Section);}
    public void clickCoppaAmericaSection(){clickElement(coppaAmericaSection);}

}
