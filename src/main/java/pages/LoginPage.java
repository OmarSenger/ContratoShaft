package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;

public class LoginPage {
	
	// Constructor
	private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver ;
    }
    // Locators
    private By emailField = By.className("login-email");
    private By passField = By.className("login-password");
    private By loginButton = By.id("signin");
    private By forgetPassword = By.linkText("لا اتذكر كلمة السر");
    private By userName = By.className("signup-user");
    private By signUpMail = By.className("signup-email");
    private By signUpPhone = By.className("signup-phone");
    private By signUpPass = By.className("signup-password");
    private By confirmSignUpPass = By.className("signup-confirmpassword");
    private By createButton = By.id("signup");
    private By checkBox = By.id("AgreeConditions");
    
    // Actions 
  
    public void setEmailField(String email){
       ElementActions.type(driver, emailField, email);
    }
    
    public void setPassField(String password){
    	ElementActions.type(driver, passField, password);
    }
    
    public String getLoginPageUrl(){
        return BrowserActions.getCurrentURL(driver);
    }
    
    public void clickOnLoginButton () {
    	ElementActions.click(driver,loginButton);
    }
    
    public void accessForgetPasswordPage(){
    	ElementActions.click(driver,forgetPassword);
        
    }
    
    public void signUp(String username , String mail , String phone , String pass , String confirmPass){
    	ElementActions.type(driver, userName, username);
    	ElementActions.type(driver, signUpMail, mail);
    	ElementActions.type(driver, signUpPhone, phone);
    	ElementActions.type(driver, signUpPass, pass);
    	ElementActions.type(driver, confirmSignUpPass, confirmPass);
    	WebElement element = driver.findElement(By.id("AgreeConditions"));
    	Actions actions = new Actions(driver);
    	actions.moveToElement(element).perform();
    	ElementActions.click(driver, checkBox);
        ElementActions.click(driver, createButton);
         }

}
