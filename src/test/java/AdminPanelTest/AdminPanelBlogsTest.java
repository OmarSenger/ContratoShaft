package AdminPanelTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import AdminPanel.AdminPanelBlogs;
import pages.LandingPage;
import pages.LoginPage;

public class AdminPanelBlogsTest {
	WebDriver driver ;
	private LoginPage loginPage ;
	private LandingPage landingPage ;
	private AdminPanelBlogs adminPanelBlogs ;
	
	@BeforeClass
	public void beforeClass() {
		driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver,"https://thecontrato.com/");
		loginPage = new LoginPage(driver);
		landingPage = new LandingPage(driver);
		adminPanelBlogs= new AdminPanelBlogs(driver);
		landingPage.accessLoginPage();
		loginPage.setEmailField("AdminGoContracts@GoContracts.com");
		loginPage.setPassField("zXS#$QR?!4S&9rY");
		loginPage.clickOnLoginButton();
		
	}
	
  @Test
  public void addNewBlog() {
	  adminPanelBlogs.addNewBlog("Blog Test","مدونه إختبار","1","Edit Blog Test");
  }
}
