package betAndGoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;

public class ContactUsPageTests {
    private WebDriver driver;
    private HomePage homePage;
    private FooterBar footerBar;
    private ContactUsPage contactUsPage;

    @Before
    public void SetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        footerBar = new FooterBar(driver);
        contactUsPage = new ContactUsPage(driver);

        homePage.navigateTo("https://betandclub.com/");
    }
    @Ignore("This test has possible bug with background color")
    @Test
    public void SuccessfulSendMessageTest() {
        footerBar.clickContactUsButton();
        contactUsPage.firstNameField("Petko");
        contactUsPage.lastNameField("Petkoski");
        contactUsPage.emailField("petko@mail.com");
        contactUsPage.subjectField("Problem with Background Color");
        contactUsPage.messageField("Fields are all the time black color possible bug");
        contactUsPage.clickSendMessageButton();
    }

    @Test
    public void UnsuccessfulSendMessageTest(){
        footerBar.clickContactUsButton();
        contactUsPage.firstNameField("Petko");
        contactUsPage.lastNameField("Petkoski");
        contactUsPage.emailField("petko@mail.com");
        contactUsPage.subjectField("Test");
        contactUsPage.messageField("Testing ContactUs Page");
        contactUsPage.clickSendMessageButton();
        assertEquals("There was an error trying to send your message. Please try again later.\n" + "×",contactUsPage.getErrorMessage());
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}
