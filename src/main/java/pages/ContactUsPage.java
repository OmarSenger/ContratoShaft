package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class ContactUsPage {
	
	// Constructor
	private WebDriver driver;
    public ContactUsPage(WebDriver driver){
        this.driver = driver ;
    }
    
    // Locators
    private By contactUsLink = By.linkText("تواصل معنا");
    private By name = By.id("name");
    private By email = By.xpath("/html/body/section/div/div/div[2]/div[2]/form/div[1]/div[2]/input");
    private By title = By.id("Title");
    private By phone = By.id("Phone");
    private By msg = By.id("Msg");
    private By sendButton = By.xpath("//button[@type='submit']");
    private By facebook = By.xpath("/html/body/section/div/div/div[2]/div[1]/div[1]/a[3]");
    private By insta = By.xpath("/html/body/section/div/div/div[2]/div[1]/div[1]/a[2]");
    private By linkedin = By.xpath("/html/body/section/div/div/div[2]/div[1]/div[1]/a[1]");
    
    
    // Actions
    public void accessContactUsPage(){
    	ElementActions.click(driver,contactUsLink);
    }
    
    public void clickOnSendButton(){
        ElementActions.click(driver, sendButton);
    }
    
    public void msgData(String Name , String Email , String Title , String Phone , String Msg){
        ElementActions.type(driver, name, Name);
        ElementActions.type(driver, email, Email);
        ElementActions.type(driver, title, Title);
        ElementActions.type(driver, phone, Phone);
        ElementActions.type(driver, msg, Msg);
    }

    public void accessFacebook(){
       ElementActions.click(driver, facebook);
    }
    
    public void accessInsta(){
    	ElementActions.click(driver, insta);
    }
    
    public void accessLinkedIn(){
    	ElementActions.click(driver, linkedin);
    }


}
