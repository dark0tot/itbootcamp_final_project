package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;
import java.util.List;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private Faker faker;
    private HomePage homePage;
    private LoginPage loginPage;
    private LoggedHomePage loggedHomePage;
    private SingUpPage singUpPage;
    private CitiesPage citiesPage;
    private MyProfilePage myProfilePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dark0\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        faker = new Faker();
        homePage = new HomePage(driver, driverWait, faker);
        loginPage = new LoginPage(driver, driverWait, faker);
        loggedHomePage = new LoggedHomePage(driver, driverWait, faker);
        singUpPage = new SingUpPage(driver, driverWait, faker);
        citiesPage = new CitiesPage(driver, driverWait, faker);
        myProfilePage = new MyProfilePage(driver, driverWait, faker);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }

    @AfterMethod
    public void afterMethod() {
        List<WebElement> logout = getDriver().findElements(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]/span"));
        if (logout.size() == 1) {
            logout.get(0).click();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
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

    public HomePage getHomePage() {
        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public LoggedHomePage getLoggedHomePage() {
        return loggedHomePage;
    }

    public SingUpPage getSingUpPage() {
        return singUpPage;
    }

    public CitiesPage getCitiesPage() {
        return citiesPage;
    }

    public MyProfilePage getMyProfilePage() {
        return myProfilePage;
    }
}
