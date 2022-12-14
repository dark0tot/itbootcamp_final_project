package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{

    // Verify that user can edit his profile
    // Verify that notification message is appeared and contains text "Profile saved successfully".
    // Verify that each input now for the attribute value has the value entered within the form.
    @Test
    public void editsProfile() {
        getHomePage().openLoginLink();
        getLoginPage().loginWithWalidCredentials();
        getLoggedHomePage().getMyProfile().click();

        getMyProfilePage().editMyProfileName();
        getMyProfilePage().editMyProfilePhone();
        getMyProfilePage().editMyProfileCity("Oakland");
        getMyProfilePage().editMyProfileCountry();
        getMyProfilePage().editMyProfileTwitter();
        getMyProfilePage().editMyProfileGitHub();

        getMyProfilePage().getMyProfileSaveButton().click();

        getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Profile saved successfully"));
        String expectedResultMessage = "Profile saved successfully";
        String actualResultMessage = getCitiesPage().getSuccessMessage().getText(); // actual result contains spelling error in message its word "successfuly".
        Assert.assertTrue(actualResultMessage.contains(expectedResultMessage));

        String expectedName = getMyProfilePage().getName();
        String actualName = getMyProfilePage().getMyProfileName().getAttribute("value");
        Assert.assertEquals(actualName, expectedName);

        String expectedPhone = getMyProfilePage().getPhone();
        String actualPhone = getMyProfilePage().getMyProfilePhone().getAttribute("value");
        Assert.assertEquals(actualPhone, expectedPhone);

        String expectedCity = "Oakland";
        String actualCity = getMyProfilePage().getMyProfileCity().getAttribute("value");
        Assert.assertEquals(actualCity, expectedCity);

        String expectedCountry = getMyProfilePage().getCountry();
        String actualCountry = getMyProfilePage().getMyProfileCountry().getAttribute("value");
        Assert.assertEquals(actualCountry, expectedCountry);

        String expectedTwitterProfile = getMyProfilePage().getTwitter();
        String actualTwitterProfile = getMyProfilePage().getMyProfileTwitter().getAttribute("value");
        Assert.assertEquals(actualTwitterProfile, expectedTwitterProfile);

        String expectedGitHubProfile = getMyProfilePage().getGitHub();
        String actualGitHubProfile = getMyProfilePage().getMyProfileGitHub().getAttribute("value");
        Assert.assertEquals(actualGitHubProfile, expectedGitHubProfile);
    }
}
