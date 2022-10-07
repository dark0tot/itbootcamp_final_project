package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends LoggedHomePage{
  private By newItem = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
  private By name = By.id("name");
  private By cancel = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[3]/button[1]");
  private By save = By.className("btnSave");
  private By successMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

  public CitiesPage(WebDriver driver, WebDriverWait driverWait, Faker faker) {
    super(driver, driverWait, faker);
  }

  public WebElement getNewItem() {
    return getDriver().findElement(newItem);
  }
  public WebElement getName() {
    return getDriver().findElement(name);
  }
  public WebElement getCancel() {
    return getDriver().findElement(cancel);
  }
  public WebElement getSave() {
    return getDriver().findElement(save);
  }
  public WebElement getSuccessMessage() { return getDriver().findElement(successMessage); }

  public void addNewCity(String city) {
    getNewItem().click();
    getName().sendKeys(city);
    getSave().click();
  }


}
