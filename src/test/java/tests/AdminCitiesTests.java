package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest{
  @Test
  public void visitsTheAdminCitiesPage() {
    getHomePage().openLoginLink();
    getLoginPage().loginWithWalidCredentials();
    getLoggedHomePage().adminLink();
    getLoggedHomePage().citiesLink();

    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/admin/cities";
    String actualResultURL = getLoggedHomePage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL,actualResultURL);

    getLoggedHomePage().isLogoutPresented();
    getLoggedHomePage().logoutNow();
  }
}
