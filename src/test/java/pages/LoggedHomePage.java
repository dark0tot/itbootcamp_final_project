package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedHomePage extends BasePage {

  private By about = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[2]");
  private By myProfile = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
  private By admin = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]");
  private By logout = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]");


  public LoggedHomePage(WebDriver driver, WebDriverWait driverWait, Faker faker) {
    super(driver, driverWait, faker);
  }

  public WebElement getAbout() {
    return getDriver().findElement(about);
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

  public boolean isLogoutPresented() {
    return getLogout().isDisplayed();
  }
  public void logoutNow() {
    getLogout().click();
  }
}
