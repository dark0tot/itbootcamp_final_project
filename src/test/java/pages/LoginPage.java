package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
  private By loginPage = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div");
  private By email = By.id("email");
  private By password = By.id("password");
  private By loginBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");

  public LoginPage(WebDriver driver, WebDriverWait driverWait) {
    super(driver, driverWait);
  }

  public WebElement getLoginPage() {
    return getDriver().findElement(loginPage);
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
}
