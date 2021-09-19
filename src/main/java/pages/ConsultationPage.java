package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;

public class ConsultationPage {
	// Constructor
    private WebDriver driver;
    public ConsultationPage(WebDriver driver){
        this.driver = driver ;
    }
 // Locators
    private By consultation = By.cssSelector("#navbar-primary-collapse > ul > li:nth-child(2) > a");
    private By lawyer = By.linkText("حنان حسن أحمد عبد الله");
    private By date = By.cssSelector("#picker1 > div > div.myc-week-container > div.myc-available-time-container > div.myc-day-time-container.myc-day-time-container-2 > a:nth-child(4)");
    private By confirmDate = By.className("swal2-confirm");
    private By reservationButton = By.cssSelector("#wrapper > div > div > div > div > div.row > div:nth-child(1) > div > div.pricingTable-signup > button");
    private By reasonText = By.id("ReasonTxt");
    private By submitButton = By.id("SubmitBtn");
    private By promoText = By.id("txtpromo");
    private By promoButton = By.id("btnpromo");
    private By paymentButton = By.id("MakePayment");
    private By backToMyConsultation = By.className("homeLink");
    private By langButton = By.cssSelector("#navbar-primary-collapse > ul > li:nth-child(7) > a");
    private By year4Check = By.xpath("//input[@id='year4Chk']");
// Actions
    public void accessConsultationPage(){
    	ElementActions.click(driver, consultation);
    }
    
    public void changeLang() {
    	ElementActions.click(driver, langButton);
    }
    
    public void reservation() {
    	ElementActions.click(driver, lawyer);
    	ElementActions.click(driver, date);
    	ElementActions.click(driver, confirmDate);
    	ElementActions.click(driver, reservationButton);
    	ElementActions.type(driver, reasonText, "Automation Test");
    	ElementActions.click(driver, submitButton);
    	ElementActions.type(driver, promoText, "sharaf2021");
    	ElementActions.click(driver, promoButton);
    	ElementActions.click(driver, paymentButton);
    	String msg = ElementActions.getText(driver, By.className("succesorfailmsg")); 
    	Assertions.assertEquals(msg, "عملية الدفع تمت بنجاح");
    	ElementActions.click(driver, backToMyConsultation);
    }
    
    public void sortByExp() {
    	WebElement element = driver.findElement(By.xpath("//input[@id='year4Chk']"));
    	Actions actions = new Actions(driver);
    	actions.moveToElement(element).perform();
    	ElementActions.click(driver,year4Check);
    }
    
}
