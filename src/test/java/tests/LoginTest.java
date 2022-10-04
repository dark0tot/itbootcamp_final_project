package tests;
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

    String actualEmailType = getLoginPage().typeCheckEmail();
    Assert.assertEquals(actualEmailType,"email");
    String actualPasswordType = getLoginPage().typeCheckPassword();
    Assert.assertEquals(actualPasswordType,"password");
  }
}
