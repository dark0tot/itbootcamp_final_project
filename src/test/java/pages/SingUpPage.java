package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingUpPage extends BasePage{
  private By signUpPageView = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div");
  private By name = By.id("name");
  private By email = By.id("email");
  private By password = By.id("password");
  private By confirmPassword = By.id("confirmPassword");
  private By signMeUpBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");

  public SingUpPage(WebDriver driver, WebDriverWait driverWait, Faker faker) {
    super(driver, driverWait, faker);
  }

  public WebElement getSignUpPageView() {
    return getDriver().findElement(signUpPageView);
  }
  public WebElement getName() {
    return getDriver().findElement(name);
  }
  public WebElement getEmail() {
    return getDriver().findElement(email);
  }
  public WebElement getPassword() {
    return getDriver().findElement(password);
  }
  public WebElement getConfirmPassword() {
    return getDriver().findElement(confirmPassword);
  }
  public WebElement getSignMeUpBtn() {
    return getDriver().findElement(signMeUpBtn);
  }

  public String typeCheckEmail() {
    return getEmail().getAttribute("type");
  }
  public String typeCheckPassword() {
    return getPassword().getAttribute("type");
  }
  public String typeCheckConfirmPassword() {
    return getConfirmPassword().getAttribute("type");
  }
  public boolean isSignUpPageViewPresented() {
    return getSignUpPageView().isDisplayed();
  }
}
