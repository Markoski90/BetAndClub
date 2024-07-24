package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {
    private By storePageTitle = By.xpath("//*[@id=\"post-1272\"]/div/div[1]/div/div/div/div[1]");
    private By buy150PtButton = By.xpath("//*[@id=\"post-1272\"]/div/div[2]/div/div[2]/div/div[3]/div/div/div/a");
    private By buy220PtButton = By.xpath("//*[@id=\"post-1272\"]/div/div[2]/div/div[3]/div/div[3]/div/div/div/a");
    private By buy275PtButton = By.xpath("//*[@id=\"post-1272\"]/div/div[2]/div/div[4]/div/div[3]/div/div/div/a");
    private By buy550PtButton = By.xpath("//*[@id=\"post-1272\"]/div/div[2]/div/div[5]/div/div[3]/div/div/div/a");
    private By buy1000PtButton = By.xpath("//*[@id=\"post-1272\"]/div/div[2]/div/div[6]/div/div[3]/div/div/div/a");
    private By cryptoVoucher100$ = By.xpath("/html/body/div[3]/div/div/div[2]/div/form/div/div/div/div/div[1]");
    private By cryptoVoucher200$ = By.xpath("/html/body/div[4]/div/div/div[2]/div/form/div/div/div/div/div[1]");
    private By cryptoVoucher250$ = By.xpath("/html/body/div[5]/div/div/div[2]/div/form/div/div/div/div/div[1]");
    private By cryptoVoucher500$ = By.xpath("/html/body/div[6]/div/div/div[2]/div/form/div/div/div/div/div[1]");
    private By cryptoVoucher1000$ = By.xpath("/html/body/div[7]/div/div/div[2]/div/form/div/div/div/div/div[1]");
    private By closeBuy150PtButton = By.xpath("/html/body/div[3]/div/div/div[1]/button");
    private By closeBuy220PtButton = By.xpath("/html/body/div[4]/div/div/div[1]/button");
    private By closeBuy275PtButton = By.xpath("/html/body/div[5]/div/div/div[1]/button");
    private By closeBuy550PtButton = By.xpath("/html/body/div[6]/div/div/div[1]/button");
    private By closeBuy1000PtButton = By.xpath("/html/body/div[7]/div/div/div[1]/button");
    private By firstStoreFAQ = By.xpath("//*[@id=\"toggle_a7014b4d54c9fa4c5\"]/a");
    private By firstStoreFAQContent = By.id("a7014b4d54c9fa4c5");
    private By secondStoreFAQ = By.xpath("//*[@id=\"toggle_6a9ae1e76ffc7300e\"]/a");
    private By secondStoreFAQContent = By.id("6a9ae1e76ffc7300e");
    private By thirdStoreFAQ = By.xpath("//*[@id=\"toggle_132e1159fda0c9302\"]/a");
    private By thirdStoreFAQContent = By.id("132e1159fda0c9302");
    private By fourthStoreFAQ = By.xpath("//*[@id=\"toggle_6edc0d40101b19bbc\"]/a");
    private By fourthStoreFAQContent = By.id("6edc0d40101b19bbc");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public StorePage newInstance(WebDriver driver) {
        return new StorePage(driver);
    }

    public void clickBuy150PtButton() {
        clickElement(buy150PtButton);
    }
    public void clickBuy220PtButton() {
        clickElement(buy220PtButton);
    }
    public void clickBuy275PtButton() {
        clickElement(buy275PtButton);
    }
    public void clickBuy550PtButton() {
        clickElement(buy550PtButton);
    }
    public void clickBuy1000PtButton() {
        clickElement(buy1000PtButton);
    }
    public void clickFirstStoreFAQButton(){clickElement(firstStoreFAQ);}
    public void clickSecondStoreFAQButton(){clickElement(secondStoreFAQ);}
    public void clickThirdStoreFAQButton(){clickElement(thirdStoreFAQ);}
    public void clickFourthStoreFAQButton(){clickElement(fourthStoreFAQ);}

    public String getCryptoVoucher100$Text(){return
            getTextFromElement(cryptoVoucher100$);}
    public String getCryptoVoucher200$Text(){return
            getTextFromElement(cryptoVoucher200$);}
    public String getCryptoVoucher250$Text(){return
            getTextFromElement(cryptoVoucher250$);}
    public String getCryptoVoucher500$Text(){return
            getTextFromElement(cryptoVoucher500$);}
    public String getCryptoVoucher1000$Text(){return
            getTextFromElement(cryptoVoucher1000$);}
    public String getFirstStoreFAQText(){return
            getTextFromElement(firstStoreFAQ);}
    public String getFirstStoreFAQContentText(){return
            getTextFromElement(firstStoreFAQContent);}
    public String getSecondStoreFAQText(){return
            getTextFromElement(secondStoreFAQ);}
    public String getSecondStoreFAQContentText(){return
            getTextFromElement(secondStoreFAQContent);}
    public String getThirdStoreFAQText(){return
            getTextFromElement(thirdStoreFAQ);}
    public String getThirdStoreFAQContentText(){return
            getTextFromElement(thirdStoreFAQContent);}
    public String getFourthStoreFAQText(){return
            getTextFromElement(fourthStoreFAQ);}
    public String getFourthStoreFAQContentText(){return
            getTextFromElement(fourthStoreFAQContent);}

    public void clickCloseBuy150PtButton() {
        clickElement(closeBuy150PtButton);
    }
    public void clickCloseBuy220PtButton() {
        clickElement(closeBuy220PtButton);
    }
    public void clickCloseBuy275PtButton() {
        clickElement(closeBuy275PtButton);
    }
    public void clickCloseBuy550PtButton() {
        clickElement(closeBuy550PtButton);
    }
    public void clickCloseBuy1000PtButton() {
        clickElement(closeBuy1000PtButton);
    }
    public String getStorePageTitleText(){return
            getTextFromElement(storePageTitle);}
    public boolean isFirstStoreFAQActive() {
        return isElementActive(firstStoreFAQ);
    }
    public boolean isFirstStoreFAQCollapsed() {
        return isElementCollapsed(firstStoreFAQ);
    }
    public boolean isSecondStoreFAQActive() {
        return isElementActive(secondStoreFAQ);
    }
    public boolean isSecondStoreFAQCollapsed() {
        return isElementCollapsed(secondStoreFAQ);
    }
    public boolean isThirdStoreFAQActive() {
        return isElementActive(thirdStoreFAQ);
    }
    public boolean isThirdStoreFAQCollapsed() {
        return isElementCollapsed(thirdStoreFAQ);
    }
    public boolean isFourthStoreFAQActive() {
        return isElementActive(fourthStoreFAQ);
    }
    public boolean isFourthStoreFAQCollapsed() {
        return isElementCollapsed(fourthStoreFAQ);
    }
}