package AdminPanelTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import AdminPanel.AdminPanelFaq;
import AdminPanel.AdminPanelFaqCat;
import pages.LandingPage;
import pages.LoginPage;

public class AdminPanelFaqTest {
	
	WebDriver driver ;
	private LoginPage loginPage ;
	private LandingPage landingPage ;
	private AdminPanelFaqCat adminPanelFaqCat ;
	private AdminPanelFaq adminPanelFaq;
	@BeforeClass
	public void beforeClass() {
		driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver,"https://thecontrato.com/");
		loginPage = new LoginPage(driver);
		landingPage = new LandingPage(driver);
		adminPanelFaqCat = new AdminPanelFaqCat(driver);
		adminPanelFaq = new AdminPanelFaq(driver);
		landingPage.accessLoginPage();
		loginPage.setEmailField("AdminGoContracts@GoContracts.com");
		loginPage.setPassField("zXS#$QR?!4S&9rY");
		loginPage.clickOnLoginButton();
		
	}
	
	@Test
	public void faqCatFunctions() {
		adminPanelFaqCat.addNewFaqCat("0","قسم أختبار","Category Test");
		adminPanelFaqCat.editFaqCat("قسم أختبار","تعديل قسم أختبار","Edited English Name");
    }
	
	@Test(priority=1)
	public void faqFunctions() {
		
		adminPanelFaq.addNewFaq("0", "سؤال أختبار ؟","Test Question?");
		adminPanelFaq.editFaq("سؤال أختبار ؟", "تعديل أختبار سؤال ؟", "Edited Test Question?");
		adminPanelFaq.deleteFaq("تعديل أختبار سؤال ؟");
	}
	
	@Test(priority =2)
	public void deleteFaqCat() {
		BrowserActions.navigateToURL(driver,"https://thecontrato.com/office/faqcategory");
		adminPanelFaqCat.deleteFaqCat("تعديل قسم أختبار");
	}

}
