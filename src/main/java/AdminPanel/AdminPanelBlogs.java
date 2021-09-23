package AdminPanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;

public class AdminPanelBlogs {
	
	// Constructor
				private WebDriver driver;
			    public AdminPanelBlogs(WebDriver driver){
			        this.driver = driver ;
			    }
			     // Locators
			    private By optionList = By.className("caret");
			    private By blogs = By.xpath("//a[@href='/Office/Blog/index']");
			    private By createBlogButton = By.xpath("//a[@href='/office/blog/create']");
			    private By englishTitle = By.id("Title");
			    private By arabicTitle = By.id("TitleArb");
			    private By status = By.id("Status");
			    private By order = By.id("OrderNo");
			    private By save = By.id("Save");
			    private By submitButton = By.xpath("//input[@type='submit']");
			    private By searchField = By.xpath("//input[@type='search']");
			    private By editButton = By.xpath("/html/body/div/div[2]/div/div/div/div[1]/div/div/div[2]/div/div/table/tbody/tr/td[7]/a[1]/i");
			    private By viewButton = By.xpath("/html/body/div/div[2]/div/div/div/div[1]/div/div/div[2]/div/div/table/tbody/tr/td[7]/a[2]/i");
			    private By checkEnglishTitle = By.xpath("//dl[@class='dl-horizontal']/dd[4]");
			    private By closeButton = By.className("btn-danger");
			    private By deleteButton = By.xpath("/html/body/div/div[2]/div/div/div/div[1]/div/div/div[2]/div/div/table/tbody/tr/td[7]/a[3]/i");
			    private By emptyTable = By.className("dataTables_empty");
			    private By pic = By.id("wizard-picture");
			    private By delete = By.xpath("//button[@onclick='Delete()']");
			  
			    //Actions
			    public void addNewBlog(String enTitle , String arTitle , String Order , String editedEnglishTxt) {
			    	driver.findElements(optionList).get(4).click();
			    	ElementActions.click(driver, blogs);
			    	ElementActions.click(driver, createBlogButton);
			    	ElementActions.type(driver, englishTitle,enTitle);
		            ElementActions.type(driver, arabicTitle,arTitle);
			    	Select selectStatus = new Select(driver.findElement(status));
		            selectStatus.selectByIndex(1);
		            ElementActions.type(driver, order,Order);
		            ElementActions.click(driver, save);
		            ElementActions.type(driver, searchField, enTitle);
			    	ElementActions.click(driver, editButton);
			    	ElementActions.type(driver, englishTitle, editedEnglishTxt);
			    	WebElement chooseFile = driver.findElement(pic);
			    	chooseFile.sendKeys("D:\\Untitled.png");
			    	ElementActions.click(driver, submitButton);
			    	ElementActions.type(driver, searchField, enTitle);
			    	ElementActions.click(driver, viewButton);
			    	String element = driver.findElement(checkEnglishTitle).getText();
			    	Assertions.assertEquals(editedEnglishTxt, element);
			    	ElementActions.click(driver, closeButton);
			    	ElementActions.click(driver, deleteButton);
			    	ElementActions.click(driver, delete);
			    	BrowserActions.navigateToURL(driver,"https://thecontrato.com/office/blog");
			    	ElementActions.type(driver, searchField, enTitle);
			    	String element2 = driver.findElement(emptyTable).getText();
			    	Assertions.assertEquals("لم يعثر على أية سجلات", element2);
			    	
			    }
}
