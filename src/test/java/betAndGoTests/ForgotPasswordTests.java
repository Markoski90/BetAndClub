package betAndGoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ForgotPasswordTests {
    private WebDriver driver;
    private NavigationBar navigationBar;
    private HomePage homePage;
    private PredictionBattlePage predictionBattlePage;
    private StorePage storePage;
    private SignUpPage signUpPage;
    private SignInPage signInPage;
    private ForgotPasswordPage forgotPasswordPage;

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
        forgotPasswordPage = new ForgotPasswordPage(driver);

        homePage.navigateTo("https://betandclub.com/");
    }
    @Test
    public void successfulRecoveryPasswordTest() {
        navigationBar.clickSignInButton();
        signInPage.clickForgotPasswordButton();
        forgotPasswordPage.insertEmail("mail@email.com");
        forgotPasswordPage.clickRecoveryButton();

        // Optional: Add a short delay to allow the message to appear
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Wait and verify the success message
        boolean isMessageDisplayed = forgotPasswordPage.isSuccessMessageDisplayed();
        assertTrue("The success message should be displayed.", isMessageDisplayed);

        // Verify the text of the success message
        String actualMessage = forgotPasswordPage.getSuccessfulMessageText();
        assertEquals("パスワードが正常に回復されました\n" +
                "×", actualMessage);
    }

    @Test
    public void validateBackButtonTest(){
        navigationBar.clickSignInButton();
        signInPage.clickForgotPasswordButton();
        forgotPasswordPage.clickBackButton();
        assertEquals("Login, connect with your friends and have fun!",signInPage.getSignInPageTitleText());
    }
    @After
    public void TearDown(){
        driver.quit();
    }
}
