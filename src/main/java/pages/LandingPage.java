package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class LandingPage {
	
	private WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver ;
    }
    
    private By navigateToLoginPageButton = By.xpath("/html/body/header[1]/div/nav/ul/li[7]/a");

    public void accessLoginPage() {
    	ElementActions.click(driver, navigateToLoginPageButton);
    	
    }
}
