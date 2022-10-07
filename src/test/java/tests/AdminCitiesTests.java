package tests;

import net.bytebuddy.build.Plugin;
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

  @Test (priority = 1)
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

  @Test (priority = 2)
  public void createNewCityTest(){
    getHomePage().openLoginLink();
    getLoginPage().loginWithWalidCredentials();
    getLoggedHomePage().adminLink();
    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]"),"Cities"));
    getLoggedHomePage().citiesLink();

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
    getHomePage().openLoginLink();
    getLoginPage().loginWithWalidCredentials();
    getLoggedHomePage().adminLink();
    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]"),"Cities"));
    getLoggedHomePage().citiesLink();

    getCitiesPage().searchWishedCity("Shibby");
    getCitiesPage().editWishedCity();
    //getDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"name\"]"),"Shibby"));
    //getCitiesPage().isEditItemPopUpPresented();
    getCitiesPage().insertEditItemPopUpText(" - edited");

  }
}
