package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{

    // Verify that user can not go to /home page URL when is not logged in.
    // Verify that the route /login appears in the URL of the page.
    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        getDriver().get("https://vue-demo.daniel-avellaneda.com/home");

        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultURL, actualResultURL);
    }

    // Verify that user can not go to /profile page URL when is not logged in.
    // Verify that the route /login appears in the URL of the page.
    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        getDriver().get("https://vue-demo.daniel-avellaneda.com/profile");

        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultURL, actualResultURL);
    }

    // Verify that user can not go to /admin/cities page URL when is not logged in.
    // Verify that the route /login appears in the URL of the page.
    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/cities");

        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultURL, actualResultURL);
    }

    // Verify that user can not go to /admin/users page URL when is not logged in.
    // Verify that the route /login appears in the URL of the page.
    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        getDriver().get("https://vue-demo.daniel-avellaneda.com/admin/users");

        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResultURL = getLoginPage().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultURL, actualResultURL);
    }
}
