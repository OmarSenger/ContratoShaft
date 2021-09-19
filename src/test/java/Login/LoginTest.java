package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;

import pages.LandingPage;
import pages.LoginPage;

public class LoginTest {
	WebDriver driver ;
	private LandingPage landingPage;
	private LoginPage loginPage ;
	@BeforeClass
	public void beforeClass() {
		driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver,"https://thecontrato.com/");
		landingPage = new LandingPage(driver);
		loginPage = new LoginPage(driver);
	}
	
  @Test
  public void LoginPageAccess() {
	  landingPage.accessLoginPage();
  }
  @Test(priority = 1)
  public void checkingValidation() {
	  loginPage.clickOnLoginButton();
	  String ErrorMsg = ElementActions.getText(driver, By.cssSelector("#Email-error"));
	  Assertions.assertEquals(ErrorMsg, "ادخل البريد الالكترونى");
  }
  @Test(priority = 2)
  public void ValidUserWithInvalidPassword() {
	  loginPage.setEmailField("osenger@barek.net");
	  loginPage.setPassField("123456789");
	  loginPage.clickOnLoginButton();
	  String errorMsg = ElementActions.getText(driver, By.className("validation-summary-errors"));
	  Assertions.assertEquals(errorMsg, "كلمة المرور غير صحيحة");
  }
  @Test(priority = 3)
  public void securedPassword() {
	  String passwordType = ElementActions.getAttribute(driver, By.className("login-password"), "type");
	  Assertions.assertEquals(passwordType, "password");
  }
  @Test(priority = 4)
  public void accessForgetPassword() {
	  loginPage.accessForgetPasswordPage();
	  String url = BrowserActions.getCurrentURL(driver);
	  Assertions.assertEquals(url, "https://thecontrato.com/ar/Account/ForgetPwd");
	  BrowserActions.navigateBack(driver);
	  
  }
  @Test(priority = 5)
  public void successLogin() {
	  loginPage.setEmailField("osenger@barek.net");
	  loginPage.setPassField("123456");
	  loginPage.clickOnLoginButton();
	  String url = BrowserActions.getCurrentURL(driver);
	  Assertions.assertEquals(url, "https://thecontrato.com/ar/Home/Index");
  }
}
