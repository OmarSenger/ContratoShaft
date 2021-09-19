package ForgetPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;

import pages.ForgetPasswordPage;
import pages.LandingPage;
import pages.LoginPage;

public class ForgetPasswordTest {
	WebDriver driver ;
	private LoginPage loginPage ;
	private LandingPage landingPage ;
	private ForgetPasswordPage forgetPasswordPage ;
	
	@BeforeClass
	public void beforeClass() {
		driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver,"https://thecontrato.com/");
		loginPage = new LoginPage(driver);
		landingPage = new LandingPage(driver);
		forgetPasswordPage = new ForgetPasswordPage(driver);
		landingPage.accessLoginPage();
		loginPage.accessForgetPasswordPage();
	}
	
	@Test
    public void incorrectEmailAddress(){
        forgetPasswordPage.setEmailField("asd");
        forgetPasswordPage.clickOnSendButton();
        String wrongEmailError = ElementActions.getText(driver, By.id("validation-email"));
        Assertions.assertEquals(wrongEmailError, "الرجاء ادخال بريد الكترونى صحيح");
    }
	
    @Test
    public void emptyEmailField(){
        forgetPasswordPage.setEmailField("");
        forgetPasswordPage.clickOnSendButton();
        String wrongEmailError = ElementActions.getText(driver, By.id("validation-email"));
        Assertions.assertEquals(wrongEmailError, "الرجاء ادخال بريد الكترونى");
    }
    @Test
    public void noExistEmail(){
        forgetPasswordPage.setEmailField("oo@contrato.com");
        forgetPasswordPage.clickOnSendButton();
        String wrongEmailError = ElementActions.getText(driver, By.id("validation-email"));
        Assertions.assertEquals(wrongEmailError, "بريد إلكترونى غير موجود");
    }
    @Test
    public void successRedirect (){
        forgetPasswordPage.setEmailField("osenger@barek.com");
        forgetPasswordPage.clickOnSendButton();
    }
}
