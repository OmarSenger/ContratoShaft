package AdminPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.shaft.gui.element.ElementActions;

public class AdminPanelPage {
	// Constructor
		private WebDriver driver;
	    public AdminPanelPage(WebDriver driver){
	        this.driver = driver ;
	    }
	     // Locators
	        private By langChanger = By.id("ArButton");
	        private By logout = By.className("enArbtn");
	        private By optionList = By.className("caret");
	        private By contracts = By.cssSelector("#Contracts > ul > li:nth-child(1) > a > p");
	        private By addNewContButton = By.className("pull-right");
	        private By contractEnglishName = By.id("NameEn");
	        private By contractArabicName = By.id("NameAr");
	        private By status = By.id("Status");
	        private By rank = By.id("rank");
	        private By categorySection = By.className("select2-selection__rendered");
	        private By category = By.xpath("/html/body/span/span/span/ul/li[1]");
	        private By addButton = By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/div/div/div[3]/button[1]");
	        
	     // Actions

	        public void langChanger (){
	        	ElementActions.click(driver,langChanger);
	        }
	        public void logoutFromAdminPanel (){
	        	ElementActions.click(driver, logout);
	        }
	        public void addNewContract(String englishName , String arabicName , String Rank){
	           
	            driver.findElements(optionList).get(0).click();
	            ElementActions.click(driver, contracts);
	            ElementActions.click(driver, addNewContButton);
	            ElementActions.type(driver, contractEnglishName, englishName);
	            ElementActions.type(driver, contractArabicName, arabicName);
	            ElementActions.click(driver, categorySection);
	            ElementActions.click(driver, category);
	            Select selectStatus = new Select(driver.findElement(status));
	            selectStatus.selectByIndex(2);
	            ElementActions.type(driver, rank, Rank);
	            ElementActions.click(driver, addButton);
	        } 
	        
}
