package betAndGoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StorePageTests {
    String firstStoreFAQContent = "At Bet And Club you can use your points to buy real and virtual gifts.";
    String secondStoreFAQContent = "Points for bets are counted differently depending on the game categories where bets are made";
    String thirdStoreFAQContent = "General bonus terms and conditions are applied to the gifts players can purchase with accumulated points. Whenever the rules of a certain bonus directly contradict the general bonus terms and conditions, the individual bonus rules take precedence.";
    String fourthStoreFAQContent = "We reserve the right to modify the terms of this Loyalty Program at any time without prior notice. However, we will inform the players about any changes made. Any fraudulent or abusive activity may result in the player’s disqualification from the Loyalty Program and forfeiture of any rewards earned.";
    private WebDriver driver;
    private NavigationBar navigationBar;
    private HomePage homePage;
    private StorePage storePage;
    private SignInPage signInPage;

    @Before
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        navigationBar = new NavigationBar(driver);
        homePage = new HomePage(driver);
        storePage = new StorePage(driver);
        signInPage = new SignInPage(driver);

        homePage.navigateTo("https://betandclub.com/");
        navigationBar.clickSignInButton();
        signInPage.insertUsername("daniel005");
        signInPage.insertPassword("password12345");
        signInPage.clickLoginButton();
    }

    @Test
    public void validateVoucher100USDTTest() throws InterruptedException {
        Thread.sleep(2000);
        navigationBar.clickStoreButton();
        Thread.sleep(1000);
        storePage.clickBuy150PtButton();
        Thread.sleep(1000);
        assertEquals("VOUCHER 100 USDT\n" + "VOUCHER 100 USDT",storePage.getCryptoVoucher100$Text());
        Thread.sleep(1000);
        storePage.clickCloseBuy150PtButton();
    }

    @Test
    public void validateVoucher200USDTTest() throws InterruptedException {
        Thread.sleep(2000);
        navigationBar.clickStoreButton();
        Thread.sleep(1000);
        storePage.clickBuy220PtButton();
        Thread.sleep(1000);
        assertEquals("VOUCHER 200 USDT\n" + "VOUCHER 200 USDT",storePage.getCryptoVoucher200$Text());
        Thread.sleep(1000);
        storePage.clickCloseBuy220PtButton();
    }

    @Test
    public void validateVoucher250USDTTest() throws InterruptedException {
        Thread.sleep(2000);
        navigationBar.clickStoreButton();
        Thread.sleep(1000);
        storePage.clickBuy275PtButton();
        Thread.sleep(1000);
        assertEquals("VOUCHER 250 USDT\n" + "VOUCHER 250 USDT",storePage.getCryptoVoucher250$Text());
        Thread.sleep(1000);
        storePage.clickCloseBuy275PtButton();
    }

    @Test
    public void validateVoucher500USDTTest() throws InterruptedException {
        Thread.sleep(2000);
        navigationBar.clickStoreButton();
        Thread.sleep(1000);
        storePage.clickBuy550PtButton();
        Thread.sleep(1000);
        assertEquals("VOUCHER 500 USDT\n" + "VOUCHER 500 USDT",storePage.getCryptoVoucher500$Text());
        Thread.sleep(1000);
        storePage.clickCloseBuy550PtButton();
    }

    @Test
    public void validateVoucher1000USDTTest() throws InterruptedException {
        Thread.sleep(2000);
        navigationBar.clickStoreButton();
        Thread.sleep(1000);
        storePage.clickBuy1000PtButton();
        Thread.sleep(1000);
        assertEquals("VOUCHER 1000 USDT\n" + "VOUCHER 1000 USDT",storePage.getCryptoVoucher1000$Text());
        Thread.sleep(1000);
        storePage.clickCloseBuy1000PtButton();
    }

    @Test
    public void validateFirstStoreFAQTest() {
        navigationBar.clickStoreButton();
        storePage.clickFirstStoreFAQButton();
        assertTrue(storePage.isFirstStoreFAQActive());
        assertEquals("How can you buy real and virtual gifts?", storePage.getFirstStoreFAQText());
        assertEquals(firstStoreFAQContent, storePage.getFirstStoreFAQContentText());
        storePage.clickFirstStoreFAQButton();
        assertTrue(storePage.isFirstStoreFAQCollapsed());
    }

    @Test
    public void validateSecondStoreFAQTest() {
        navigationBar.clickStoreButton();
        storePage.clickSecondStoreFAQButton();
        assertTrue(storePage.isSecondStoreFAQActive());
        assertEquals("Acquiring Points in Different Game Categories", storePage.getSecondStoreFAQText());
        assertEquals(secondStoreFAQContent, storePage.getSecondStoreFAQContentText());
        storePage.clickSecondStoreFAQButton();
        assertTrue(storePage.isSecondStoreFAQCollapsed());
    }

    @Test
    public void validateThirdStoreFAQTest() {
        navigationBar.clickStoreButton();
        storePage.clickThirdStoreFAQButton();
        assertTrue(storePage.isThirdStoreFAQActive());
        assertEquals("What terms and condxitions are applicable?", storePage.getThirdStoreFAQText());
        assertEquals(thirdStoreFAQContent, storePage.getThirdStoreFAQContentText());
        storePage.clickThirdStoreFAQButton();
        assertTrue(storePage.isThirdStoreFAQCollapsed());
    }

    @Test
    public void validateFourthStoreFAQTest() {
        navigationBar.clickStoreButton();
        storePage.clickFourthStoreFAQButton();
        assertTrue(storePage.isFourthStoreFAQActive());
        assertEquals("Disclaimer", storePage.getFourthStoreFAQText());
        assertEquals(fourthStoreFAQContent, storePage.getFourthStoreFAQContentText());
        storePage.clickFourthStoreFAQButton();
        assertTrue(storePage.isFourthStoreFAQCollapsed());
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}
