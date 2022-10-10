package tests;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest{
  @BeforeMethod
  public void beforeMethod() {
    getDriver().manage().deleteAllCookies();
    getDriver().get("https://vue-demo.daniel-avellaneda.com/");
    getHomePage().openLoginLink();
    getLoginPage().loginWithWalidCredentials();
    getLoggedHomePage().adminLink();
    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]"),"Cities"));
    getLoggedHomePage().citiesLink();
  }
  @AfterMethod
  public void afterMethod() {
    getLoggedHomePage().logoutNow();
  }

  @Test (priority = 1)
  public void visitsTheAdminCitiesPage() {

    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/admin/cities";
    String actualResultURL = getLoggedHomePage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL,actualResultURL);

    getLoggedHomePage().isLogoutPresented();
  }

  @Test (priority = 2)
  public void createNewCityTest(){

    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.className("btnNewItem"), "NEW ITEM"));

    getCitiesPage().addNewCity("Shibby");

    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Saved successfully"));
    String expectedResult = "Saved successfully";
    String actualResult = getCitiesPage().getSuccessMessage().getText();
    Assert.assertTrue(actualResult.contains(expectedResult));

    /*getCitiesPage().searchWishedCity("Shibby");
    getCitiesPage().deleteWishedCity();
    getDriverWait().until(ExpectedConditions.visibilityOf(getCitiesPage().getDeleteCityConfirm()));
    getCitiesPage().getDeleteCityConfirm().click();*/
  }

  @Test (priority = 3)
  public void editCity() {

    getCitiesPage().searchWishedCity("Shibby");
    getCitiesPage().editWishedCity();
    //getDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"name\"]"),"Shibby"));
    //getCitiesPage().isEditItemPopUpPresented();
    getCitiesPage().insertEditItemPopUpText(" - edited");

    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Saved successfully"));
    String expectedResult = "Saved successfully";
    String actualResult = getCitiesPage().getSuccessMessage().getText();
    Assert.assertTrue(actualResult.contains(expectedResult));
  }

  @Test (priority = 4)
  public void searchCity() {

    getCitiesPage().searchWishedCity("Shibby - edited");
    String expectedResult = "Shibby - edited";
    String actualResult = getCitiesPage().getColumnName().getText();
    Assert.assertEquals(expectedResult, actualResult);
  }

  @Test (priority = 5)
  public void deleteCity() {

    getCitiesPage().searchWishedCity("Shibby");
    getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")));
    String expectedResult = "Shibby";
    String actualResult = getCitiesPage().getColumnName().getText();
    Assert.assertTrue(actualResult.contains(expectedResult));

    getCitiesPage().deleteWishedCity();
    getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("text--lighten3")));
    getCitiesPage().getDeleteCityConfirm().click();

    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Deleted successfully"));
    String expectedResultMessage = "Deleted successfully";
    String actualResultMessage = getCitiesPage().getSuccessMessage().getText();
    Assert.assertTrue(actualResultMessage.contains(expectedResultMessage));
  }
}
