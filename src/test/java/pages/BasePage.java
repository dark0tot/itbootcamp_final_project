package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private Faker faker;

    public BasePage(WebDriver driver, WebDriverWait driverWait, Faker faker) {
        this.driver = driver;
        this.driverWait = driverWait;
        this.faker = faker;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public Faker getFaker() {
        return faker;
    }
}
