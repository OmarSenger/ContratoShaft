package AdminPanelTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import AdminPanel.AdminPanelPage;
import pages.LandingPage;
import pages.LoginPage;

public class AdminPanelTestContract {
	WebDriver driver ;
	private LoginPage loginPage ;
	private LandingPage landingPage ;
	private AdminPanelPage adminPanelPage ;
	
	@BeforeClass
	public void beforeClass() {
		driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver,"https://thecontrato.com/");
		loginPage = new LoginPage(driver);
		landingPage = new LandingPage(driver);
		adminPanelPage = new AdminPanelPage(driver);
		landingPage.accessLoginPage();
		loginPage.setEmailField("AdminGoContracts@GoContracts.com");
		loginPage.setPassField("zXS#$QR?!4S&9rY");
		loginPage.clickOnLoginButton();
		
	}

    @Test
    public void addNewContract(){
        adminPanelPage.addNewContract("Contract Test","إختبار عقد" , "1" );
    }
}
