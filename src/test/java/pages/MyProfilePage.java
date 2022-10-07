package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage extends BasePage{
  private By myProfileName = By.id("name");
  private By myProfilePhone = By.id("phone");
  private By myProfileCity = By.id("city");
  private By myProfileCountry = By.id("country");
  private By myProfileTwitter = By.id("urlTwitter");
  private By myProfileGitHub = By.id("urlGitHub");
  private By myProfileSaveButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
  private By profileSaved = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");

  public MyProfilePage(WebDriver driver, WebDriverWait driverWait, Faker faker) {
    super(driver, driverWait, faker);
  }

  public WebElement getMyProfileName() {
    return getDriver().findElement(myProfileName);
  }
  public WebElement getMyProfilePhone() {
    return getDriver().findElement(myProfilePhone);
  }
  public WebElement getMyProfileCity() {
    return getDriver().findElement(myProfileCity);
  }
  public WebElement getMyProfileCountry() {
    return getDriver().findElement(myProfileCountry);
  }
  public WebElement getMyProfileTwitter() {
    return getDriver().findElement(myProfileTwitter);
  }
  public WebElement getMyProfileGitHub() {
    return getDriver().findElement(myProfileGitHub);
  }
  public WebElement getMyProfileSaveButton() {
    return getDriver().findElement(myProfileSaveButton);
  }
  public WebElement getProfileSaved() {
    return getDriver().findElement(profileSaved);
  }

  public void editMyProfileName(String name) {
    getMyProfileName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfileName().sendKeys(name);
  }
  public void editMyProfilePhone(String phone) {
    getMyProfilePhone().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfilePhone().sendKeys(phone);
  }
  public void editMyProfileCity(String city) {
    getMyProfileCity().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfileCity().sendKeys(city);
  /*  try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Select selectCity = new Select(getDriver().findElement(By.id("city")));
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    selectCity.selectByVisibleText(city);*/
  }
  public void editMyProfileCountry(String country) {
    getMyProfileCountry().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfileCountry().sendKeys(country);
  }
  public void editMyProfileTwitter(String twitter) {
    getMyProfileTwitter().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfileTwitter().sendKeys(twitter);
  }
  public void editMyProfileGitHub(String gitHub) {
    getMyProfileGitHub().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfileGitHub().sendKeys(gitHub);
  }
}
