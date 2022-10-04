package tests;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

  @Test
  public void visitTheLogPage() {
    Assert.assertTrue(getHomePage().isHomePagePresented());
    Assert.assertTrue(getHomePage().isLoginLinkPresented());
    getHomePage().openLoginLink();

    String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
    String actualResult = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertTrue(expectedResult.contains(actualResult));
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

    getLoginPage().loginWithWrongCredentials((faker.internet().emailAddress()), faker.internet().password());
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
    Assert.assertTrue(expectedResultURL.contains(actualResultURL));

  }
}
