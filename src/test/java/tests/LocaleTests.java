package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{
  @BeforeMethod
  public void beforeMethod() {
    getDriver().manage().deleteAllCookies();
    getDriver().get("https://vue-demo.daniel-avellaneda.com/");
  }

  @Test
  public void setLocaleToES() {
    getHomePage().selectES();

    String expectedResult = "Página de aterrizaje";
    String actualResult = getHomePage().getH1().getText();
    Assert.assertEquals(actualResult,expectedResult);
  }

  @Test
  public void setLocaleToEN() {
    getHomePage().selectEN();

    String expectedResult = "Landing";
    String actualResult = getHomePage().getH1().getText();
    Assert.assertEquals(actualResult,expectedResult);
  }

  @Test
  public void setLocaleToFR() {
    getHomePage().selectFR();

    String expectedResult = "Page d'atterrissage";
    String actualResult = getHomePage().getH1().getText();
    Assert.assertEquals(actualResult,expectedResult);
  }
}
