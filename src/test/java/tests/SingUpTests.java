package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingUpTests extends BaseTest{

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        getHomePage().isSingUpLinkPresented();
        getHomePage().openSingUpLink();
        getSingUpPage().isSignUpPageViewPresented();
    }

    // Verify that the /singup route appears in the URL of the page.
    @Test
    public void visitSingUpPage() {
        getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button"), "SIGN ME UP"));

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResult = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);
    }

    // Verify that the email input field for the type attribute has the value email.
    // Verify that the password input field for the type attribute has the value password.
    //  Verify that the confirmation password input field for the type attribute has the value password.
    @Test
    public void checksInputTypes() {
        getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button"), "SIGN ME UP"));

        String actualEmailType = getSingUpPage().typeCheckEmail();
        Assert.assertEquals(actualEmailType, "email");
        String actualPasswordType = getSingUpPage().typeCheckPassword();
        Assert.assertEquals(actualPasswordType, "password");
        String actualConfirmPasswordType = getSingUpPage().typeCheckConfirmPassword();
        Assert.assertEquals(actualConfirmPasswordType,"password");
    }

    // Verify that the error contains the message "E-mail already exists" when you try to sing up with existing user.
    // Verify that the /signup route appears in the URL of the page.
    @Test
    public void displaysErrorsWhenUserAlreadyExists() {
        getSingUpPage().singUpWithExistingUser();

        String expectedResult = "E-mail already exists";
        String actualResult = getSingUpPage().getErrorMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultURL, actualResultURL);
    }

    // Verify that new user can sing up
    // Verify that notification message contains the text "Important: Verify your account".
    @Test
    public void singUpTest() {
        getSingUpPage().singUpWithNewUser("Darko Tot", getFaker().internet().emailAddress(), "123456","123456");

        getDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));
        String expectedResult = "IMPORTANT: Verify your account";
        String actualResult = getSingUpPage().getVerifyMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        getSingUpPage().closeNotification();
        getLoggedHomePage().isLogoutPresented();
    }
}
