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
  private By searchCity = By.id("search");
  private By deleteCity = By.id("delete");
  private By deleteCityConfirm = By.className("text--lighten3");
  private By deleteCityCancel = By.className("green--text");
  private By editCity = By.id("edit");
  private By editItemPopUp = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[2]/div");
  private By editItemTextBox = By.id("name");  ////*[@id="name"]
  private By editItemSaveBtn = By.className("green--text");
  private By columnName = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");


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
  public WebElement getSearchCity() { return getDriver().findElement(searchCity); }
  public WebElement getDeleteCity() { return getDriver().findElement(deleteCity); }
  public WebElement getDeleteCityConfirm() { return getDriver().findElement(deleteCityConfirm); }
  public WebElement getDeleteCityCancel() { return getDriver().findElement(deleteCityCancel); }
  public WebElement getEditCityBtn() { return getDriver().findElement(editCity); }
  public WebElement getEditItemPopUp() { return getDriver().findElement(editItemPopUp); }
  public WebElement getEditItemTextBox() { return getDriver().findElement(editItemTextBox); }
  public WebElement getEditItemSaveBtn() { return getDriver().findElement(editItemSaveBtn); }
  public WebElement getColumnName() { return getDriver().findElement(columnName); }

  public void addNewCity(String city) {
    getNewItem().click();
    getName().sendKeys(city);
    getSave().click();
  }

  public void searchWishedCity(String city) {
    getSearchCity().sendKeys(city);
  }
  public void deleteWishedCity() {
    getDeleteCity().click();
  }
  public void editWishedCity(){
    getEditCityBtn().click();
  }
  public boolean isEditItemPopUpPresented() {
    return getEditItemPopUp().isDisplayed();
  }
  public void insertEditItemPopUpText(String addText) {
    getEditItemTextBox().click();
    getEditItemTextBox().sendKeys(addText);
    getEditItemSaveBtn().click();
  }
}
