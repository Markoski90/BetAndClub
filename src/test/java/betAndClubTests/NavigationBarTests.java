package betAndClubTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigationBarTests {
    private WebDriver driver;
    private NavigationBar navigationBar;
    private HomePage mainPage;
    private PredictionBattlePage predictionBattlePage;
    private StorePage storePage;
    private SignUpPage signUpPage;
    private SignInPage signInPage;

    @Before
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        navigationBar = new NavigationBar(driver);
        mainPage = new HomePage(driver);
        predictionBattlePage = new PredictionBattlePage(driver);
        storePage = new StorePage(driver);
        signUpPage = new SignUpPage(driver);
        signInPage = new SignInPage(driver);

        navigationBar.navigateTo("https://betandclub.com/");
    }

    @Test
    public void validateHomeButtonTest(){
        navigationBar.clickHomeButton();
        assertTrue(navigationBar.isHomeButtonActive());
        assertEquals("Predict of sports\n" + "Win a prizes!",mainPage.getMainPageTitleText());
    }

    @Test
    public void validatePredictionBattleButtonTest(){
        //color before hover and click on button
        assertEquals("#ffffff",navigationBar.getPredictionBattleButtonColor());
        navigationBar.hoverPredictionBattleButton();
        navigationBar.clickPredictionBattleButton();
        assertTrue(navigationBar.isPredictionBattleButtonActive());
        assertEquals("Special match",predictionBattlePage.getPredictionBattleTitleText());
        assertEquals("\"Noto Sans\"",navigationBar.getPredictionBattleFontType());
        assertEquals("14px",navigationBar.getPredictionBattleButtonFontSize());
        //color after hover and click on button
        assertEquals("#1ec170",navigationBar.getPredictionBattleButtonColor());
    }

    @Test
    public void validateStoreButtonTest(){
        navigationBar.clickStoreButton();
        assertTrue(navigationBar.isStoreButtonActive());
        assertEquals("Bet And Club Store",storePage.getStorePageTitleText());
    }

    @Test
    public void validateSignUpButtonTest(){
        assertEquals("#000000",navigationBar.getSignUpButtonHoverColor());
        navigationBar.clickSignUpButton();
        assertEquals("Welcome to Bet And Club",signUpPage.getSignUpPageTitleText());
        assertEquals("13px",navigationBar.getSignUpButtonFontSize());
        assertEquals("\"Noto Sans\"",navigationBar.getSignUpButtonFontType());
        assertEquals("#137946",navigationBar.getSignUpButtonColor());
    }

    @Test
    public void validateSignInButtonTest() throws InterruptedException {
        navigationBar.hoverSignInButton();
        Thread.sleep(300);
        assertEquals("#0e492b",navigationBar.getSignInButtonHoverColor());
        navigationBar.clickSignInButton();
        assertEquals("Login, connect with your friends and have fun!",signInPage.getSignInPageTitleText());
        assertEquals("13px",navigationBar.getSignInButtonFontSize());
        assertEquals("\"Noto Sans\"",navigationBar.getSignInButtonFontType());
        assertEquals("#137946",navigationBar.getSignInButtonActiveColor());
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}