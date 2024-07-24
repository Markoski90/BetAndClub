package betAndClubTests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.*;

public class SignUpPageTests {
    private WebDriver driver;
    private NavigationBar navigationBar;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private SignInPage signInPage;

    @Before
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        navigationBar = new NavigationBar(driver);
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        signInPage = new SignInPage(driver);

        homePage.navigateTo("https://betandclub.com/");
    }

    @Test
    public void successfulSignUpTest(){
        navigationBar.clickSignUpButton();
        signUpPage.insertUsername(RandomStringUtils.randomAlphabetic(10));
        signUpPage.insertEmail(RandomStringUtils.randomAlphanumeric(10)+ "@email.com");
        signUpPage.insertPassword(RandomStringUtils.randomAlphanumeric(10));
        signUpPage.insertFirstName(RandomStringUtils.randomAlphabetic(8));
        signUpPage.insertLastName(RandomStringUtils.randomAlphabetic(8));
        signUpPage.selectGender("male");
        assertTrue(signUpPage.isGenderSelected("male"));
        signUpPage.clickCountryButton();
        signUpPage.setBirthDate("1996-08-02");
        assertEquals("1996-08-02",signUpPage.getBirthDate());
        signUpPage.clickAdultCheckbox();
        assertTrue(signUpPage.isAdultCheckboxChecked());
        signUpPage.clickCheckBoxMarketingButton();
        assertTrue(signUpPage.isMarketingCheckboxChecked());
        signUpPage.clickSignUpNowButton();
        assertEquals("登録が完了しました。確認のためメールを確認してください。\n" + "×",signUpPage.getSuccessMessage());
    }

    @Test
    public void passwordTooShortTest(){
        navigationBar.clickSignUpButton();
        signUpPage.insertPassword(RandomStringUtils.randomAlphanumeric(5));
        assertEquals("パスワードの最小文字数は6文字です\n" + "×",signUpPage.getErrorMessage());
    }

    @Test
    public void enterExistingUsernameTest() throws InterruptedException {
        navigationBar.clickSignUpButton();
        signUpPage.insertUsername("daniel005");
        Thread.sleep(1000);
        signUpPage.clickSignUpNowButton();
        Thread.sleep(1000);
        assertEquals("ユーザー名は使用されています\n×",signUpPage.getErrorMessage());
    }

    @Test
    public void wrongEmailFormatTest() throws InterruptedException {
        navigationBar.clickSignUpButton();
        signUpPage.insertUsername("");
        signUpPage.insertEmail("mailoemail.com");
        signUpPage.hoverSignUpNowButton();
        Thread.sleep(2000);
        signUpPage.clickSignUpNowButton();
        Thread.sleep(5000);
        assertEquals ("正しいメールアドレスを入力してください\n" + "×",signUpPage.getErrorMessage());
    }

    @Test
    public void emptyUsernameTest() throws InterruptedException {
        navigationBar.clickSignUpButton();
        signUpPage.insertUsername(RandomStringUtils.randomAlphabetic(7));
        Thread.sleep(1000);
        signUpPage.clearUsernameField();
        Thread.sleep(1000);
        assertEquals ("ユーザー名が必要です\n" + "×",signUpPage.getErrorMessage());
    }

    @Test
    public void validateLoginHrefButton(){
        navigationBar.clickSignUpButton();
        signUpPage.clickLoginHrefButton();
        assertEquals("Login, connect with your friends and have fun!",signInPage.getSignInPageTitleText());
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}
