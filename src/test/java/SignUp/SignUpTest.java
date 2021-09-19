package SignUp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;

import pages.LandingPage;
import pages.LoginPage;

public class SignUpTest {
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
  public void signUpSuccessfully() {
	  landingPage.accessLoginPage();
	  loginPage.signUp("Omar", "osenger@cont.com", "01240472150", "123456", "123456");
  }
}
