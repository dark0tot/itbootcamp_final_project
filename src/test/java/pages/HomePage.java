package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
  private By homePage = By.xpath("//*[@id=\"app\"]/div/main/div");
  private By loginLink = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");


  public HomePage(WebDriver driver, WebDriverWait driverWait) {
    super(driver, driverWait);
  }

  public WebElement getHomePage() {
    return getDriver().findElement(homePage);
  }

  public WebElement getLoginLink() {
    return getDriver().findElement(loginLink);
  }

  public boolean isHomePagePresented() {
    return getHomePage().isDisplayed();
  }

  public boolean isLoginLinkPresented() {
    return getLoginLink().isDisplayed();
  }

  public void openLoginLink() {
    getLoginLink().click();
  }
}
