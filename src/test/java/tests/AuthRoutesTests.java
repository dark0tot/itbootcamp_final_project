package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{
  @BeforeMethod
  public void beforeMethod() {
    getDriver().manage().deleteAllCookies();
  }

  @Test
  public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
    getDriver().get("https://vue-demo.daniel-avellaneda.com/home");

    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
    String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL, actualResultURL);
  }

  @Test
  public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
    getDriver().get("https://vue-demo.daniel-avellaneda.com/profile");

    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
    String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL, actualResultURL);
  }

  @Test
  public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
    getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/cities");

    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
    String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL, actualResultURL);
  }

  @Test
  public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
    getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/users");

    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
    String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL, actualResultURL);
  }
}
