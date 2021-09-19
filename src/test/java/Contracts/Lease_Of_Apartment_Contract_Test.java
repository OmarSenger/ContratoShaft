package Contracts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;


import pages.LandingPage;
import pages.LoginPage;
import pages.contracts.Lease_Of_Apartment_Contract;

public class Lease_Of_Apartment_Contract_Test {
	WebDriver driver ;
	private LoginPage loginPage ;
	private LandingPage landingPage ;
	private Lease_Of_Apartment_Contract leaseApartment ;
	@BeforeClass
	public void beforeClass() {
		driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver,"https://thecontrato.com/");
		loginPage = new LoginPage(driver);
		landingPage = new LandingPage(driver);
		leaseApartment = new Lease_Of_Apartment_Contract(driver);
		landingPage.accessLoginPage();
		loginPage.setEmailField("osenger@barek.net");
		loginPage.setPassField("123456");
		loginPage.clickOnLoginButton();
		leaseApartment.accessContract();
		
	}
	
  @Test
  public void fillingData() {
	  
	  leaseApartment.FirstBandData();
	  leaseApartment.SecBandData();
	  leaseApartment.ThirdBandData();
	  
  }
  
}
