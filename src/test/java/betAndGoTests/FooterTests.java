package betAndGoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;

public class FooterTests {
    private WebDriver driver;
    private HomePage homePage;
    private FooterBar footerBar;
    private AboutUsPage aboutUsPage;
    private ContactUsPage contactUsPage;
    private TermsAndConditionsPage termsAndConditionsPage;
    private PrivacyPolicyPage privacyPolicyPage;

    @Before
    public void SetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        footerBar = new FooterBar(driver);
        aboutUsPage = new AboutUsPage(driver);
        contactUsPage = new ContactUsPage(driver);
        termsAndConditionsPage = new TermsAndConditionsPage(driver);
        privacyPolicyPage = new PrivacyPolicyPage(driver);

        homePage.navigateTo("https://betandclub.com/");

    }

    @Test
    public void validateAboutUsButtonTest() throws InterruptedException {
        footerBar.hoverAboutUsButton();
        footerBar.clickAboutUsButton();
        Thread.sleep(1000);

        assertEquals("About the project",aboutUsPage.getAboutUsTitle());
    }

    @Test
    public void validateContactUsButtonTest() throws InterruptedException {
        footerBar.hoverContactUsButton();
        footerBar.clickContactUsButton();
        Thread.sleep(1000);

        assertEquals("Contact Us",contactUsPage.getContactUsTitle());
    }

    @Test
    public void validateTermsAndConditionsButtonTest() throws InterruptedException {
        footerBar.hoverTermsAndConditionsButton();
        footerBar.clickTermsAndConditionsButton();
        Thread.sleep(1000);

        assertEquals("Terms & Conditions",termsAndConditionsPage.getTermsAndConditionsTitle());
    }

    @Test
    public void validatePrivacyPolicyButtonTest() throws InterruptedException {
        footerBar.hoverPrivacyPolicyButton();
        footerBar.clickPrivacyPolicyButton();
        Thread.sleep(1000);

        assertEquals("Privacy Policy",privacyPolicyPage.getPrivacyPolicyTitle());
    }

    @Test
    public void validateJapaneseLanguageOptionTest(){
        footerBar.selectJapaneseLanguage();

        assertEquals("スポーツの勝敗を予想して\n" + "賞品を獲得せよ！",homePage.getMainPageTitleText());
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}
