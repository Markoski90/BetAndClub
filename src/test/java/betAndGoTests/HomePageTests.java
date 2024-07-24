package betAndGoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.*;

public class HomePageTests {
    String predictingSportsText="Predict which team will win a baseball, soccer, basketball or other sports game. Prediction events will be held daily.";
    String earnPointsText="You can earn points when your predictions are successful. In addition to hitting the target, you can also get points by accomplishing simple missions.";
    String exchangeForPrizeText="Points earned can be redeemed for various prizes. The prizes are listed in the store, so be sure to check them out.";
    String secondFAQContent = "Bet And Club is in top worldwide, and it is the most accurate Sports Prediction Website.";
    String thirdFAQContent = "There are several factors to consider when making NBA predictions. At Bet And Club our experts do all the legwork for you to bring you the best NBA predictions in the market.";
    String fourthFAQContent = "Bet And Club offers accurate predictions, selected by experts to ensure you place guided bets and make maximum wins and profits.";
    String fifthFAQContent = "For football predictions, the easiest is goals category: either over or under and for other sports predictions (Tennis is 1HH/2HH) while Basketball (1HH/2HH)";
    private WebDriver driver;
    private NavigationBar navigationBar;
    private HomePage homePage;
    private PredictionBattlePage predictionBattlePage;
    private StorePage storePage;
    private SignUpPage signUpPage;
    private SignInPage signInPage;

    @Before
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        navigationBar = new NavigationBar(driver);
        homePage = new HomePage(driver);
        predictionBattlePage = new PredictionBattlePage(driver);
        storePage = new StorePage(driver);
        signUpPage = new SignUpPage(driver);
        signInPage = new SignInPage(driver);

        homePage.navigateTo("https://betandclub.com/");
    }

   @Test
   public void validateSignUpNowTopButton() throws InterruptedException {
       homePage.hoverSignUpNowButton();
       Thread.sleep(100);
       assertEquals("#0e492b",homePage.getSignUpNowButtonHoverColor());
       assertEquals("Poppins",homePage.getSignUpNowButtonFontType());
       assertEquals("16px",homePage.getSignUpNowButtonFontSize());
       homePage.clickSignUpNowTopButton();
       assertEquals("Welcome to Bet And Club",signUpPage.getSignUpPageTitleText());
   }

   @Test
   public void validatePredictingSportsSectionTest() throws InterruptedException {
        homePage.hoverPredictingSportsSection();
        Thread.sleep(500);
        assertEquals(predictingSportsText,homePage.getPredictingSportsText());
        homePage.clickPredictingSportsSection();
        assertEquals("Login, connect with your friends and have fun!",signInPage.getSignInPageTitleText());
   }

   @Test
   public void validateEarnPointsSectionTest() throws InterruptedException {
        homePage.hoverEarnPointsSection();
        Thread.sleep(500);
        assertEquals(earnPointsText,homePage.getEarnPointsText());
        homePage.clickEarnPointsSection();
        assertTrue(navigationBar.isPredictionBattleButtonActive());
        assertEquals("#1ec170",navigationBar.getPredictionBattleButtonColor());
        assertEquals("Special match",predictionBattlePage.getPredictionBattleTitleText());
   }
   @Test
   public void validateExchangeForPrizeSectionTest() throws InterruptedException {
        homePage.hoverExchangeForPrizeSection();
        Thread.sleep(500);
        assertEquals(exchangeForPrizeText,homePage.getExchangeForPrizeText());
        homePage.clickExchangeForPrizeSection();
        assertTrue(navigationBar.isStoreButtonActive());
       assertEquals("Bet And Club Store",storePage.getStorePageTitleText());
   }
    @Test
    public void validateSignUpNowBigButtonTest() throws InterruptedException {
        homePage.hoverSignUpNowBigButton();
        Thread.sleep(500);
        assertEquals("#0e492b",homePage.getSignUpNowBigButtonHoverColor());
        assertEquals("Poppins",homePage.getSignUpNowBigButtonFontType());
        assertEquals("18px",homePage.getSignUpNowBigButtonFontSize());
        homePage.clickSignUpNowBigButton();
        assertEquals("Welcome to Bet And Club",signUpPage.getSignUpPageTitleText());
    }

    @Test
    public void validateFirstFAQSectionTest() {
        homePage.clickFirstFAQButton();
        assertTrue(homePage.isFirstFAQActive());
        assertEquals("How do I join Bet And Club?", homePage.getFirstFAQText());
        assertEquals("You can join Bet And Club for Free.", homePage.getFirstFAQContentText());
        homePage.clickFirstFAQButton();
        assertTrue(homePage.isFirstFAQCollapsed());
    }
    @Test
    public void validateFreeHrefButtonTest(){
        homePage.clickFirstFAQButton();
        assertEquals("#137946",homePage.getFreeHrefButtonColor());
        homePage.clickFreeHrefButton();
        assertEquals("Welcome to Bet And Club",signUpPage.getSignUpPageTitleText());
    }
    @Test
    public void validateSecondFAQSectionTest() {
        homePage.clickSecondFAQButton();
        assertTrue(homePage.isSecondFAQActive());
        assertEquals("Which is the most accurate prediction site?", homePage.getSecondFAQText());
        assertEquals(secondFAQContent, homePage.getSecondFAQContentText());
        homePage.clickSecondFAQButton();
        assertTrue(homePage.isSecondFAQCollapsed());
    }
    @Test
    public void validateThirdFAQSectionTest() {
        homePage.clickThirdFAQButton();
        assertTrue(homePage.isThirdFAQActive());
        assertEquals("How to predict NBA?", homePage.getThirdFAQText());
        assertEquals(thirdFAQContent, homePage.getThirdFAQContentText());
        homePage.clickThirdFAQButton();
        assertTrue(homePage.isThirdFAQCollapsed());
    }
    @Test
    public void validateFourthFAQSectionTest() {
        homePage.clickFourthFAQButton();
        assertTrue(homePage.isFourthFAQActive());
        assertEquals("Where can i get free predictions?", homePage.getFourthFAQText());
        assertEquals(fourthFAQContent, homePage.getFourthFAQContentText());
        homePage.clickFourthFAQButton();
        assertTrue(homePage.isFourthFAQCollapsed());
    }
    @Test
    public void validateFifthFAQSectionTest() {
        homePage.clickFifthFAQButton();
        assertTrue(homePage.isFifthFAQActive());
        assertEquals("What is the easiest bet to win?", homePage.getFifthFAQText());
        assertEquals(fifthFAQContent, homePage.getFifthFAQContentText());
        homePage.clickFifthFAQButton();
        assertTrue(homePage.isFifthFAQCollapsed());
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}
