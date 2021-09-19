package AdminPanelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;

import AdminPanel.AdminPanelPage;
import pages.LandingPage;
import pages.LoginPage;

public class AdminPanelLoginTest {
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
    public void loginAsAdmin(){
        String adminPanelUrl = BrowserActions.getCurrentURL(driver);
        Assertions.assertEquals(adminPanelUrl, "https://thecontrato.com/Office/Home/Dashboard");
        adminPanelPage.langChanger();
        String logoutButtonText = ElementActions.getText(driver, By.className("enArbtn"));
        Assertions.assertEquals(logoutButtonText, "LOGOUT");
    }
	
	@Test
    public void dashboardCounters(){
        int [] option = {0,1,2,3,4};
        for (int i = 0 ; i< option.length ; i++){
            String category = driver.findElements(By.className("card-category")).get(option[i]).getText();
            String content = driver.findElements(By.className("card-title")).get(option[i]).getText();
            System.out.println(content+"/"+category);
            
        }
    }
	
	@Test
    public void logoutFromAdminPanel(){
        adminPanelPage.logoutFromAdminPanel();
        String loginUrl = BrowserActions.getCurrentURL(driver);
        Assertions.assertEquals(loginUrl, "https://thecontrato.com/en/login");
    }
}
