package betAndGoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.assertEquals;

public class PredictionBattlePageTests {
    private WebDriver driver;
    private NavigationBar navigationBar;
    private HomePage homePage;
    private PredictionBattlePage predictionBattlePage;
    private SignInPage signInPage;

    @Before
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        navigationBar = new NavigationBar(driver);
        homePage = new HomePage(driver);
        predictionBattlePage = new PredictionBattlePage(driver);
        signInPage = new SignInPage(driver);

        homePage.navigateTo("https://betandclub.com/");
        navigationBar.clickSignInButton();
        signInPage.insertUsername("daniel005");
        signInPage.insertPassword("password12345");
        signInPage.clickLoginButton();
    }

    @Test
    public void euro2024SectionTest() throws InterruptedException {
        navigationBar.hoverPredictionBattleButton();
        Thread.sleep(1000);
        assertEquals("#1ec170",navigationBar.getPredictionBattleButtonColor());
        navigationBar.clickPredictionBattleButton();
        Thread.sleep(3000);
        predictionBattlePage.clickEuro2024Section();
        Thread.sleep(1000);
        String URL = driver.getCurrentUrl();
        assertEquals("https://betandclub.com/euro-cup/",URL);
    }
    @Test
    public void coppaAmericaSectionTest() throws InterruptedException {
        navigationBar.hoverPredictionBattleButton();
        Thread.sleep(1000);
        assertEquals("#1ec170",navigationBar.getPredictionBattleButtonColor());
        navigationBar.clickPredictionBattleButton();
        Thread.sleep(3000);
        predictionBattlePage.clickCoppaAmericaSection();
        Thread.sleep(1000);
        String URL = driver.getCurrentUrl();
        assertEquals("https://betandclub.com/copa-america/",URL);
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}