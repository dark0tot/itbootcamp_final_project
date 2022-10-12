package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {

    // Verify that when user can change language to Spanish.
    // Verify that title contains "Página de aterrizaje".
    @Test
    public void setLocaleToES() {
        getHomePage().selectES();

        String expectedResult = "Página de aterrizaje";
        String actualResult = getHomePage().getH1().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Verify that when user can change language back to English.
    // Verify that title contains "Landing".
    @Test
    public void setLocaleToEN() {
        getHomePage().selectEN();

        String expectedResult = "Landing";
        String actualResult = getHomePage().getH1().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Verify that when user can change language to French.
    // Verify that title contains "Page d'atterrissage".
    @Test
    public void setLocaleToFR() {
        getHomePage().selectFR();

        String expectedResult = "Page d'atterrissage";
        String actualResult = getHomePage().getH1().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
