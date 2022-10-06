package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
  private By homePage = By.xpath("//*[@id=\"app\"]/div/main/div");
  private By loginLink = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
  private By singUpLink = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");

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
}
