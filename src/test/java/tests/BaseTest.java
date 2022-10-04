package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public abstract class BaseTest {

  private WebDriver driver;
  private WebDriverWait driverWait;
  private HomePage homePage;
  private LoginPage loginPage;

  @BeforeClass
  public void beforeClass() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\dark0\\IdeaProjects\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://vue-demo.daniel-avellaneda.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    homePage = new HomePage(driver, driverWait);
    loginPage = new LoginPage(driver, driverWait);
  }

  @BeforeMethod
  public void beforeMethod() {
    driver.get("https://vue-demo.daniel-avellaneda.com/");
  }

  @AfterClass
  public void afterClass() {
    driver.quit();
  }

}
