package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class ForgetPasswordPage {
	// Constructor
			private WebDriver driver;
		    public ForgetPasswordPage(WebDriver driver){
		        this.driver = driver ;
		    }
		    
	// Locators
		    private By emailField = By.id("email");
		    private By sendButton = By.id("send");
		    
	// Actions 
		    public void setEmailField(String email){
		    	ElementActions.type(driver, emailField, email);		        
		    }
		    public void clickOnSendButton(){
		    	ElementActions.click(driver, sendButton);
		    }
}
