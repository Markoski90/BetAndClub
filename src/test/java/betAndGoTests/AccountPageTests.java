package betAndGoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.assertEquals;

public class AccountPageTests {
    private WebDriver driver;
    private NavigationBar navigationBar;
    private HomePage homePage;
    private SignInPage signInPage;
    private AccountPage accountPage;

    @Before
    public void SetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        navigationBar = new NavigationBar(driver);
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        accountPage = new AccountPage(driver);

        homePage.navigateTo("https://betandclub.com/");
    }

    @Test
    public void successfulChangePassword() throws InterruptedException {
        navigationBar.clickSignInButton();
        signInPage.insertUsername("daniel005");
        signInPage.insertPassword("password12345");
        signInPage.clickLoginButton();
        Thread.sleep(2000);
        homePage.clickAccountButton();
        accountPage.currentPasswordField("password12345");
        accountPage.newPasswordField("password123456");
        accountPage.repeatNewPasswordField("password123456");
        accountPage.clickUpdatePasswordButton();
        assertEquals("あなたのパスワードは変更されました。\n" + "×",accountPage.getSuccessMessage());
    }

    @Test
    public void wrongPasswordTest() throws InterruptedException {
        navigationBar.clickSignInButton();
        signInPage.insertUsername("daniel005");
        signInPage.insertPassword("password12345");
        signInPage.clickLoginButton();
        Thread.sleep(2000);
        homePage.clickAccountButton();
        accountPage.currentPasswordField("password12");
        accountPage.newPasswordField("password1");
        accountPage.repeatNewPasswordField("password1");
        accountPage.clickUpdatePasswordButton();
        assertEquals("Error: パスワードが古く無効です\n" + "×",accountPage.getErrorMessage());
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}
