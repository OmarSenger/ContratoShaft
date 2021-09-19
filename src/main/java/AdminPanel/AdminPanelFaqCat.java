package AdminPanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;


public class AdminPanelFaqCat {
	
	// Constructor
				private WebDriver driver;
			    public AdminPanelFaqCat(WebDriver driver){
			        this.driver = driver ;
			    }
			    
			 // Locators
			    private By optionList = By.className("caret");
			    private By faqCat = By.xpath("//a[@href='/office/faqcategory']");
			    private By addFaqCatButton = By.xpath("//a[@href='/office/faqcategory/create']");
			    private By order = By.id("Order");
			    private By arabicName = By.id("NameArabic");
			    private By englishName = By.id("NameEnglish");
			    private By createButton = By.xpath("//input[@type='submit']");
			    private By searchField = By.xpath("//input[@type='search']");
			    private By button = By.className("dropdown-toggle");
			    private By editOption = By.linkText("تعديل");
			    private By viewOption = By.linkText("التفاصيل");
			    private By arabicNameCheck = By.xpath("//dl[@class='dl-horizontal']/dd[3]");
			    private By englishNameCheck = By.xpath("//dl[@class='dl-horizontal']/dd[4]");
			    private By deleteOption = By.linkText("حذف");
			    private By emptyDataTable = By.className("dataTables_empty");
			    
			 // Actions
			    public void addNewFaqCat(String catOrder , String arName , String enName) {
			    	driver.findElements(optionList).get(7).click();
			    	ElementActions.click(driver, faqCat);
			    	ElementActions.click(driver, addFaqCatButton);
			    	ElementActions.type(driver, order, catOrder);
			    	ElementActions.type(driver, arabicName, arName);
			    	ElementActions.type(driver, englishName, enName);
			    	ElementActions.click(driver, createButton);
			    }
			    
			    public void editFaqCat(String arName, String editedArabicName , String editedEnglishName) {
			    	ElementActions.type(driver, searchField, arName);
			    	ElementActions.click(driver, button);
			    	ElementActions.click(driver, editOption);
			    	ElementActions.type(driver, arabicName, editedArabicName );
			    	ElementActions.type(driver, englishName, editedEnglishName);
			    	ElementActions.click(driver, createButton);
			    	//check if FAQ Category edited
		        	ElementActions.type(driver, searchField, editedArabicName);
		        	ElementActions.click(driver, button);
		        	ElementActions.click(driver, viewOption);
		        	String element = driver.findElement(arabicNameCheck).getText();
		        	String element2 = driver.findElement(englishNameCheck).getText();
		        	Assertions.assertEquals(editedArabicName, element);
		        	Assertions.assertEquals(editedEnglishName, element2);
		        	BrowserActions.navigateToURL(driver,"https://thecontrato.com/office/faqcategory");
			    }
			    
			    public void deleteFaqCat(String arName) {
			    	ElementActions.type(driver, searchField, arName);
			    	ElementActions.click(driver, button);
			    	ElementActions.click(driver, deleteOption);
			    	ElementActions.type(driver, searchField, arName);
			    	String element = driver.findElement(emptyDataTable).getText();
		        	Assertions.assertEquals("لم يعثر على أية سجلات", element);
			    }
}
