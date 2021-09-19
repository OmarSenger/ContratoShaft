package AdminPanelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import AdminPanel.AdminPanelJobPage;
import pages.LandingPage;
import pages.LoginPage;

public class AdminPanelJobTest {
	WebDriver driver ;
	private LoginPage loginPage ;
	private LandingPage landingPage ;
	private AdminPanelJobPage adminPanelJobPage ;
	@BeforeClass
	public void beforeClass() {
		driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver,"https://thecontrato.com/");
		loginPage = new LoginPage(driver);
		landingPage = new LandingPage(driver);
		adminPanelJobPage = new AdminPanelJobPage(driver);
		landingPage.accessLoginPage();
		loginPage.setEmailField("AdminGoContracts@GoContracts.com");
		loginPage.setPassField("zXS#$QR?!4S&9rY");
		loginPage.clickOnLoginButton();
		
	}
	@Test
    public void jobFunctions() {
    	WebElement element = driver.findElement(By.xpath("//a[@href='/office/careers']"));
    	Actions actions = new Actions(driver);
    	actions.moveToElement(element);
    	actions.perform();
    	adminPanelJobPage.addNewJob("أختبار وظيفه", "Job Test","أختبار نوع الوظيفه","Job Type Test","مختبر برمجيات","Software Tester","بنها","Benha","سنه","1 year","2000","5000","osenger@barek.net","1");
    	adminPanelJobPage.editJob("أختبار وظيفه","سنتين","2 years");
    	//BrowserActions.navigateToURL(driver,"https://thecontrato.com/office/careers/");
    	BrowserActions.navigateBack(driver);
    	adminPanelJobPage.deleteJob("أختبار وظيفه");
    }
}
