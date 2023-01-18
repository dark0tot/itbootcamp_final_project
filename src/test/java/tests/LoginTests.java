package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        Assert.assertTrue(getHomePage().isHomePagePresented());
        Assert.assertTrue(getHomePage().isLoginLinkPresented());
        getHomePage().openLoginLink();
    }

    // Verify that in page URL is presented /login route.
    @Test
    public void visitTheLogPage() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);
    }

    // Verify that the email input field for the attribute type has te value email.
    // Verify that the password input field for the attribute type has te value password.
    @Test
    public void checksInputTypes() {
        Assert.assertTrue(getLoginPage().isLoginPagePresented());

        String actualEmailType = getLoginPage().typeCheckEmail();
        Assert.assertEquals(actualEmailType, "email");
        String actualPasswordType = getLoginPage().typeCheckPassword();
        Assert.assertEquals(actualPasswordType, "password");
    }

    // Verify that error message contains text "User does not exist" when you try to log in with wrong credentials.
    // Verify that in page URL is presented /login route.
    @Test
    public void displaysErrorsWhenUserDoesNotExist() {
        getLoginPage().loginWithWrongCredentials((getFaker().internet().emailAddress()), getFaker().internet().password());

        String expectedResult = "User does not exists";
        String actualResult = getLoginPage().getErrorMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultURL, actualResultURL);
    }

    // Verity that error message contains text "Wrong password" when you insert wrong password only with correct email.
    // Verify that in page URL is presented /login route.
    @Test
    public void displaysErrorsWhenPasswordIsWrong() {
        getLoginPage().loginWithWrongPassword(getFaker().internet().password());
        String expectedResult = "Wrong password";
        String actualResult = getLoginPage().getErrorMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultURL, actualResultURL);
    }

    // Verify that you can log in with walid credentials.
    // Verify that in page URL is presented /home route.
    @Test
    public void loginWithWalidCredentials() {
        getLoginPage().loginWithWalidCredentials();

        getDriverWait().until(ExpectedConditions.urlContains("/home"));

        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/home";
        String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultURL, actualResultURL);
    }

    // Verify that "Logout" button is presented on page after login with walid credentials.
    // Verify that page URL after logout contains /login rout.
    // Verify that after trying to open the /home route, the /login route appears in the URL of the page.
    @Test
    public void logout() {
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
