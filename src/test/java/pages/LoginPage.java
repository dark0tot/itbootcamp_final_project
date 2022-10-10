package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By loginPageShow = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div");
    private By email = By.id("email");
    private By password = By.id("password");
    private By loginBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private By errorMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");

    public LoginPage(WebDriver driver, WebDriverWait driverWait, Faker faker) {
        super(driver, driverWait, faker);
    }

    public WebElement getLoginPageShow() {
        return getDriver().findElement(loginPageShow);
    }
    public WebElement getEmail() {
        return getDriver().findElement(email);
    }
    public WebElement getPassword() {
        return getDriver().findElement(password);
    }
    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }
    public WebElement getErrorMessage() {
        return getDriver().findElement(errorMessage);
    }
    public boolean isLoginPagePresented() {
        return getLoginPageShow().isDisplayed();
    }
    public String typeCheckEmail() {
        return getEmail().getAttribute("type");
    }
    public String typeCheckPassword() {
        return getPassword().getAttribute("type");
    }

    public void loginWithWrongCredentials(String email, String password) {
        getEmail().clear();
        getPassword().clear();
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginBtn().click();
    }

    public void loginWithWrongPassword(String password) {
        String email = "admin@admin.com";
        getEmail().clear();
        getPassword().clear();
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginBtn().click();
    }

    public void loginWithWalidCredentials() {
        String email = "admin@admin.com";
        String password = "12345";
        getEmail().clear();
        getPassword().clear();
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginBtn().click();
    }
}
