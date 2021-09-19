package ConsultationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;

import pages.ConsultationPage;
import pages.LandingPage;
import pages.LoginPage;

public class ConsultationPageTest {
	WebDriver driver ;
	private ConsultationPage consultationPage ;
	private LandingPage landingPage ;
	private LoginPage loginPage ;
	
	@BeforeClass
	public void beforeClass() {
		driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver,"https://thecontrato.com/");
		consultationPage = new ConsultationPage(driver);
		landingPage = new LandingPage(driver);
		loginPage = new LoginPage(driver);
		landingPage.accessLoginPage();
		loginPage.setEmailField("osenger@barek.net");
		loginPage.setPassField("123456");
		loginPage.clickOnLoginButton();
		consultationPage.accessConsultationPage();
	}
	
	@Test
    public void checkPage(){
        String consultationUrl = BrowserActions.getCurrentURL(driver);
        Assertions.assertEquals(consultationUrl, "https://thecontrato.com/ar/lawyers");
    }
	
	@Test
	public void changeLang() {
		ElementActions.click(driver, By.linkText("حنان حسن أحمد عبد الله"));
		consultationPage.changeLang();
		String lawyerEnglishName = ElementActions.getText(driver,By.cssSelector("#wrapper > div:nth-child(1) > div > div > div > div > div > div.utf-lawyer-listing-description > h3.utf-lawyer-listing-title > a"));
		Assertions.assertEquals(lawyerEnglishName, "Hanan Hassan Ahmed Abdallah");
	}
	
    @Test
    public void chooseLawyer(){
    	BrowserActions.navigateToURL(driver, "https://thecontrato.com/ar/lawyers");
    	consultationPage.reservation();

    }
    @Test
    public void sort() {
    	consultationPage.sortByExp();
    }
    
}
