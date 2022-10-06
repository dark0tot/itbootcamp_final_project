package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingUpTests extends BaseTest{

  @Test
  public void visitSingUpPage() {
    getHomePage().isSingUpLinkPresented();
    getHomePage().openSingUpLink();
    getSingUpPage().isSignUpPageViewPresented();
    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button"), "SIGN ME UP"));

    String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";
    String actualResult = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResult,actualResult);
  }

  @Test
  public void checksInputTypes() {
    getHomePage().isSingUpLinkPresented();
    getHomePage().openSingUpLink();
    getSingUpPage().isSignUpPageViewPresented();
    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button"), "SIGN ME UP"));

    String actualEmailType = getSingUpPage().typeCheckEmail();
    Assert.assertEquals(actualEmailType, "email");
    String actualPasswordType = getSingUpPage().typeCheckPassword();
    Assert.assertEquals(actualPasswordType, "password");
    String actualConfirmPasswordType = getSingUpPage().typeCheckConfirmPassword();
    Assert.assertEquals(actualConfirmPasswordType,"password");
  }

  @Test
  public void displaysErrorsWhenUserAlreadyExists() {
    getHomePage().isSingUpLinkPresented();
    getHomePage().openSingUpLink();
    getSingUpPage().isSignUpPageViewPresented();
    getSingUpPage().singUpWithExistingUser();

    String expectedResult = "E-mail already exists";
    String actualResult = getSingUpPage().getErrorMessage().getText();
    Assert.assertTrue(actualResult.contains(expectedResult));

    String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/signup";
    String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
    Assert.assertEquals(expectedResultURL,actualResultURL);
  }

  @Test
  public void singUpTest() {
    getHomePage().isSingUpLinkPresented();
    getHomePage().openSingUpLink();
    getSingUpPage().isSignUpPageViewPresented();
    getSingUpPage().singUpWithNewUser("Darko Tot", getFaker().internet().emailAddress(), "123456","123456");

    getDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));
    String expectedResult = "IMPORTANT: Verify your account";
    String actualResult = getSingUpPage().getVerifyMessage().getText();
    Assert.assertTrue(actualResult.contains(expectedResult));

    getSingUpPage().closeNotification();
    getSingUpPage().isLogoutLinkPresented();
    getSingUpPage().logoutNow();

  }
}