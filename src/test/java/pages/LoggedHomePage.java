package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedHomePage extends BasePage {

    private By myProfile = By.className("btnProfile");
    private By admin = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private By logout = By.className("btnLogout");
    private By cities = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");


    public LoggedHomePage(WebDriver driver, WebDriverWait driverWait, Faker faker) {
        super(driver, driverWait, faker);
    }

    public WebElement getMyProfile() {
        return getDriver().findElement(myProfile);
    }

    public WebElement getAdmin() {
        return getDriver().findElement(admin);
    }

    public WebElement getLogout() {
        return getDriver().findElement(logout);
    }

    public WebElement getCities() {
        return getDriver().findElement(cities);
    }

    public boolean isLogoutPresented() {
        return getLogout().isDisplayed();
    }

    public void logoutNow() {
        getLogout().click();
    }

    public void adminLink() {
        getAdmin().click();
    }

    public void citiesLink() {
        getCities().click();
    }
}
