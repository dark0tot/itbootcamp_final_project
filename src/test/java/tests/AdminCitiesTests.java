package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest{
  @AfterMethod
  public void afterMethod() {
    getLoggedHomePage().logoutNow();
  }

  @Test
  public void visitsTheAdminCitiesPage() {
    getHomePage().openLoginLink();
    getLoginPage().loginWithWalidCredentials();
    getLoggedHomePage().adminLink();
    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]"),"Cities"));
    getLoggedHomePage().citiesLink();

    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/admin/cities";
    String actualResultURL = getLoggedHomePage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL,actualResultURL);

    getLoggedHomePage().isLogoutPresented();
  }

  @Test
  public void createNewCityTest(){
    getHomePage().openLoginLink();
    getLoginPage().loginWithWalidCredentials();
    getLoggedHomePage().adminLink();
    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]"),"Cities"));
    getLoggedHomePage().citiesLink();

    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.className("btnNewItem"), "NEW ITEM"));

    getCitiesPage().addNewCity("Shibby");

    String expectedResult = "Saved successfully";
    String actualResult = getCitiesPage().getSuccessMessage().getText();
    Assert.assertTrue(actualResult.contains(expectedResult));
  }
}
