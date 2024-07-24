package betAndGoTests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignInPageTests {
    private WebDriver driver;
    private NavigationBar navigationBar;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private SignInPage signInPage;
    private AccountPage accountPage;
    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        navigationBar = new NavigationBar(driver);
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        signInPage = new SignInPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        accountPage = new AccountPage(driver);

        homePage.navigateTo("https://betandclub.com/");
    }

    @Test
    public void successfulLoginTest(){
        navigationBar.clickSignInButton();
        signInPage.insertUsername("daniel005");
        signInPage.insertPassword("password12345");

        assertTrue(signInPage.isCheckboxChecked());
        signInPage.clickLoginButton();

        assertTrue(homePage.isLogOutButtonDisplayed());
    }

    @Test
    public void emptyFieldsTest() {
        navigationBar.clickSignInButton();
        signInPage.insertUsername("");
        signInPage.clickLoginButton();

        assertEquals("ユーザー名が必要です",signInPage.getErrorMessages());
    }

    @Test
    public void emptyPasswordFieldTest(){
        navigationBar.clickSignInButton();
        signInPage.insertUsername("daniel005");
        signInPage.insertPassword("");
        signInPage.clickLoginButton();

        assertEquals("パスワードが必要",signInPage.getErrorMessages());
    }
    @Test
    public void wrongInformationTest() throws InterruptedException {
        navigationBar.clickSignInButton();
        signInPage.insertUsername(RandomStringUtils.randomAlphanumeric(10));
        signInPage.insertPassword(RandomStringUtils.randomAlphanumeric(9));
        signInPage.clickLoginButton();
        Thread.sleep(5000);

        assertEquals("アカウントにログインできません",signInPage.getErrorMessages());
    }

    @Test
    public void validateForgotPasswordTest(){
        navigationBar.clickSignInButton();
        signInPage.clickForgotPasswordButton();

        assertEquals("Forgot Password?",forgotPasswordPage.getForgotPasswordPageTitleText());
    }
    @Test
    public void validateSignUpNowButtonTest(){
        navigationBar.clickSignInButton();
        signInPage.clickSignUpNowButton();

        assertEquals("Welcome to Bet And Club",signUpPage.getSignUpPageTitleText());
    }

    @Test
    public void validateAccountButtonTest() throws InterruptedException {
        navigationBar.clickSignInButton();
        signInPage.insertUsername("daniel005");
        signInPage.insertPassword("password12345");
        signInPage.clickLoginButton();
        Thread.sleep(5000);

        assertEquals("#000000",homePage.getAccountButtonColor());
        assertEquals("#137946",homePage.getAccountTextButtonColor());
        homePage.hoverAccountButton();
        Thread.sleep(1000);

        assertEquals("#137946",homePage.getAccountButtonColor());
        assertEquals("#ffffff",homePage.getAccountTextButtonColor());
        homePage.clickAccountButton();

        assertEquals("My Account",accountPage.getAccountTitle());
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}