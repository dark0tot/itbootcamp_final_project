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
  private final String name = getFaker().name().firstName();
  private final String phone = getFaker().phoneNumber().phoneNumber();
  private final String country = getFaker().address().country();
  private final String twitter = getFaker().internet().avatar();
  private final String gitHub = getFaker().internet().avatar();

  public MyProfilePage(WebDriver driver, WebDriverWait driverWait, Faker faker) {
    super(driver, driverWait, faker);
  }

  public String getName() {
    return name;
  }
  public String getPhone() {
    return phone;
  }
  public String getCountry() {
    return country;
  }
  public String getTwitter() {
    return twitter;
  }
  public String getGitHub() {
    return gitHub;
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

  public void editMyProfileName() {
    getMyProfileName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfileName().sendKeys(getName());
  }
  public void editMyProfilePhone() {
    getMyProfilePhone().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfilePhone().sendKeys(getPhone());
  }
  public void editMyProfileCity(String city) {
    getMyProfileCity().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfileCity().sendKeys(city);
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    getMyProfileCity().sendKeys(Keys.ENTER);
  /*
    Select selectCity = new Select(getDriver().findElement(By.id("city")));
    try {
    selectCity.selectByVisibleText(city);*/
  }
  public void editMyProfileCountry() {
    getMyProfileCountry().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfileCountry().sendKeys(getCountry());
  }
  public void editMyProfileTwitter() {
    getMyProfileTwitter().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfileTwitter().sendKeys(getTwitter());
  }
  public void editMyProfileGitHub() {
    getMyProfileGitHub().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
    getMyProfileGitHub().sendKeys(getGitHub());
  }
}
