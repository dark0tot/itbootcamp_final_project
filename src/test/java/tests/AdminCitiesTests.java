package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        getHomePage().openLoginLink();
        getLoginPage().loginWithWalidCredentials();
        getLoggedHomePage().adminLink();
        getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]"), "Cities"));
        getLoggedHomePage().citiesLink();
    }

    // Verify that when you log in with walid credentials and go to cities page, in page URL is presented /admin/cities rout.
    // Verify that logout button is presented when the user is logged in.
    @Test(priority = 1)
    public void visitsTheAdminCitiesPage() {
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        String actualResultURL = getLoggedHomePage().getDriver().getCurrentUrl();
        Assert.assertEquals(expectedResultURL, actualResultURL);

        getLoggedHomePage().isLogoutPresented();
    }

    // Verify that when user create new city info message appears and contains text "Saved successfully".
    @Test(priority = 2)
    public void createNewCityTest() {
        getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.className("btnNewItem"), "NEW ITEM"));

        getCitiesPage().addNewCity("Shibby");

        getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Saved successfully"));
        String expectedResult = "Saved successfully";
        String actualResult = getCitiesPage().getSuccessMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    /*getCitiesPage().searchWishedCity("Shibby");
    getCitiesPage().deleteWishedCity();
    getDriverWait().until(ExpectedConditions.visibilityOf(getCitiesPage().getDeleteCityConfirm()));
    getCitiesPage().getDeleteCityConfirm().click();*/
    }

    // Verify that user can edit created city and info message with "Saved successfully" is presented.
    @Test(priority = 3)
    public void editCity() {
        getCitiesPage().searchWishedCity("Shibby");
        getCitiesPage().editWishedCity();
        //getDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"name\"]"),"Shibby"));
        //getCitiesPage().isEditItemPopUpPresented();
        getCitiesPage().insertEditItemPopUpText(" - edited");

        getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Saved successfully"));
        String expectedResult = "Saved successfully";
        String actualResult = getCitiesPage().getSuccessMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    // Verify that searched city is presented in "Name" column.
    @Test(priority = 4)
    public void searchCity() {
        getCitiesPage().searchWishedCity("Shibby - edited");
        String expectedResult = "Shibby - edited";
        String actualResult = getCitiesPage().getColumnName().getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    // Verify that user can delete created city and notification message contains "Deleted successfully".
    @Test(priority = 5)
    public void deleteCity() {
        getCitiesPage().searchWishedCity("Shibby");
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")));
        String expectedResult = "Shibby";
        String actualResult = getCitiesPage().getColumnName().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        getCitiesPage().deleteWishedCity();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("text--lighten3")));
        getCitiesPage().getDeleteCityConfirm().click();

        getDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Deleted successfully"));
        String expectedResultMessage = "Deleted successfully";
        String actualResultMessage = getCitiesPage().getSuccessMessage().getText();
        Assert.assertTrue(actualResultMessage.contains(expectedResultMessage));
    }
}
