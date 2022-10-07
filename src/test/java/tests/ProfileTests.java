package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{

  @Test
  public void editsProfile() {
    getHomePage().openLoginLink();
    getLoginPage().loginWithWalidCredentials();
    getLoggedHomePage().getMyProfile().click();

    getMyProfilePage().editMyProfileName(getFaker().name().fullName());
    getMyProfilePage().editMyProfilePhone(getFaker().phoneNumber().toString());
    getMyProfilePage().editMyProfileCity("Oakland");
    getMyProfilePage().editMyProfileCountry(getFaker().address().country());
    getMyProfilePage().editMyProfileTwitter(getFaker().internet().avatar());
    getMyProfilePage().editMyProfileGitHub(getFaker().internet().avatar());

    getMyProfilePage().getMyProfileSaveButton().click();
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Profile saved successfully"));
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String expectedResult = "Profile saved successfully";
    String actualResult = getCitiesPage().getSuccessMessage().getText();
    Assert.assertTrue(actualResult.contains(expectedResult));

    getLoggedHomePage().logoutNow();
  }
}
