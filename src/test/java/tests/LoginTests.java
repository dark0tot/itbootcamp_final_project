package tests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
  @BeforeMethod
  public void beforeMethod() {
    getDriver().manage().deleteAllCookies();
    getDriver().get("https://vue-demo.daniel-avellaneda.com/");
  }

  @Test
  public void visitTheLogPage() {
    Assert.assertTrue(getHomePage().isHomePagePresented());
    Assert.assertTrue(getHomePage().isLoginLinkPresented());
    getHomePage().openLoginLink();

    String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
    String actualResult = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResult,actualResult);
  }

  @Test
  public void checksInputTypes() {
    getHomePage().openLoginLink();

    Assert.assertTrue(getLoginPage().isLoginPagePresented());

    String actualEmailType = getLoginPage().typeCheckEmail();
    Assert.assertEquals(actualEmailType,"email");
    String actualPasswordType = getLoginPage().typeCheckPassword();
    Assert.assertEquals(actualPasswordType,"password");
  }

  @Test
  public void displaysErrorsWhenUserDoesNotExist() {
    getHomePage().openLoginLink();

    getLoginPage().loginWithWrongCredentials((getFaker().internet().emailAddress()), getFaker().internet().password());

    String expectedResult = "User does not exists";
    String actualResult = getLoginPage().getErrorMessage().getText();
    Assert.assertTrue(actualResult.contains(expectedResult));

    /*try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/

    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
    String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL, actualResultURL);
  }

  @Test
  public void displaysErrorsWhenPasswordIsWrong() {
    getHomePage().openLoginLink();

    getLoginPage().loginWithWrongPassword(getFaker().internet().password());
    String expectedResult = "Wrong password";
    String actualResult = getLoginPage().getErrorMessage().getText();
    Assert.assertTrue(actualResult.contains(expectedResult));

    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
    String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL, actualResultURL);
  }

  @Test
  public void loginWithWalidCredentials() {
    getHomePage().openLoginLink();

    getLoginPage().loginWithWalidCredentials();

    getDriverWait().until(ExpectedConditions.urlContains("/home"));

    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/home";
    String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL, actualResultURL);

    getLoggedHomePage().logoutNow();
  }

  @Test
  public void logout() {
    getHomePage().openLoginLink();

    getLoginPage().loginWithWalidCredentials();
    getDriverWait().until(ExpectedConditions.urlContains("/home"));

    getLoggedHomePage().isLogoutPresented();
    getLoggedHomePage().logoutNow();

    String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
    String actualResult = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResult, actualResult);

    getDriver().navigate().to("https://vue-demo.daniel-avellaneda.com/home");
    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
    String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL, actualResultURL);
  }
}
