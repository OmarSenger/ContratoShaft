package ContactUs;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;

import pages.ContactUsPage;


public class ContactUsTest {
	WebDriver driver ;
	private ContactUsPage contactUsPage ;
	@BeforeClass
	public void beforeClass() {
		driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver,"https://thecontrato.com/ar");
		contactUsPage = new ContactUsPage(driver);
	}
  @Test
  public void accessPage(){
      contactUsPage.accessContactUsPage();
      String url = driver.getCurrentUrl();
      Assertions.assertEquals(url, "https://thecontrato.com/ar/contactus");
  }
  
  @Test(priority = 1)
  public void noData (){
      contactUsPage.clickOnSendButton();
  }
  
  @Test(priority = 2)
  public void wrongEmailFormat(){
      contactUsPage.msgData("Omar","Omar","QC","01068938890","Testing Wrong Email Format !");
      contactUsPage.clickOnSendButton();
      String element = ElementActions.getText(driver,By.xpath("//input[@id='Email' and @class='form-control']"));
      System.out.println(element);
  }
  
  @Test(priority = 3)
  public void accessFacebookPage(){
      contactUsPage.accessFacebook();
      ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
      driver.switchTo().window(tabs2.get(1));
      String facebookUrl = BrowserActions.getCurrentURL(driver);
      driver.close();
      driver.switchTo().window(tabs2.get(0));
      Assertions.assertEquals("https://www.facebook.com/thecontrato/", facebookUrl);
  }
  
  @Test(priority = 4)
  public void accessInstaPage(){
      contactUsPage.accessInsta();
      ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
      driver.switchTo().window(tabs2.get(1));
      String instaUrl = BrowserActions.getCurrentURL(driver);
      driver.close();
      driver.switchTo().window(tabs2.get(0));
      Assertions.assertEquals("https://www.instagram.com/thecontrato/", instaUrl);
  }
  
  @Test(priority = 5)
  public void accessLinkedInPage(){
      contactUsPage.accessLinkedIn();
  }
  
  @Test(priority = 6)
  public void sendMessage(){
      contactUsPage.msgData("OmarSenger","osenger@barek.net","QC","01068938890","Automation Testing For Contact Us Page !");
      contactUsPage.clickOnSendButton();
      String successMsg = ElementActions.getText(driver ,By.id("sendmessage"));
      Assertions.assertEquals(successMsg, "تم ارسال رسالتك . شكرا لك !");
  }
}
