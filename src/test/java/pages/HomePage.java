package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    private By homePage = By.xpath("//*[@id=\"app\"]/div/main/div");
    private By loginLink = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By singUpLink = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");
    private By languageBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button");
    private By btnES = By.className("btnES");
    private By btnEN = By.className("btnEN");
    private By btnFR = By.className("btnFR");
    private By h1 = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");

    public HomePage(WebDriver driver, WebDriverWait driverWait, Faker faker) {
        super(driver, driverWait, faker);
    }

    public WebElement getHomePage() {
        return getDriver().findElement(homePage);
    }
    public WebElement getLoginLink() {
        return getDriver().findElement(loginLink);
    }
    public WebElement getSingUpLink() {
        return  getDriver().findElement(singUpLink);
    }
    public WebElement getLanguageBtn() { return getDriver().findElement(languageBtn); }
    public WebElement getBtnES() { return getDriver().findElement(btnES); }
    public WebElement getBtnEN() { return getDriver().findElement(btnEN); }
    public WebElement getBtnFR() { return getDriver().findElement(btnFR); }
    public WebElement getH1() { return getDriver().findElement(h1); }

    public boolean isHomePagePresented() {
        return getHomePage().isDisplayed();
    }
    public boolean isLoginLinkPresented() {
        return getLoginLink().isDisplayed();
    }
    public boolean isSingUpLinkPresented() {
        return getSingUpLink().isDisplayed();
    }
    public void openLoginLink() {
        getLoginLink().click();
    }
    public void openSingUpLink() { getSingUpLink().click(); }

    public void selectES() {
        getLanguageBtn().click();
        getDriverWait().until(ExpectedConditions.visibilityOf(getBtnES()));
        getBtnES().click();
    }
    public void selectEN() {
        getLanguageBtn().click();
        getDriverWait().until(ExpectedConditions.visibilityOf(getBtnEN()));
        getBtnEN().click();
    }
    public void selectFR() {
        getLanguageBtn().click();
        getDriverWait().until(ExpectedConditions.visibilityOf(getBtnFR()));
        getBtnFR().click();
    }
}
