package AdminPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;

public class AdminPanelFaq {
	
	// Constructor
	private WebDriver driver;
    public AdminPanelFaq(WebDriver driver){
        this.driver = driver ;
    }
    
 // Locators
    private By optionList = By.className("caret");
    private By faq = By.xpath("//a[@href='/office/faq']");
    private By addFaqButton = By.xpath("//a[@href='/office/faq/create']");
    private By order = By.id("Order");
    private By arabicQuestion = By.id("QuestionArabic");
    private By englishQuestion = By.id("QuestionEnglish");
    private By selectCatList = By.id("select2-CategoryId-container");
    private By selectCat = By.xpath("/html/body/span/span/span[2]/ul/li[2]");
    private By createButton = By.xpath("//input[@type='submit']");
    private By searchField = By.xpath("//input[@type='search']");
    private By button = By.className("dropdown-toggle");
    private By editOption = By.linkText("تعديل");
    private By viewOption = By.linkText("التفاصيل");
    private By deleteOption = By.linkText("حذف");
    private By emptyDataTable = By.className("dataTables_empty");
    private By arQuestionCheck = By.xpath("//dl[@class='dl-horizontal']/dd[4]");
    private By enQuestionCheck = By.xpath("//dl[@class='dl-horizontal']/dd[5]");
 // Actions
    
    public void addNewFaq(String faqOrder , String arQuestion , String enQuestion) {
    	driver.findElements(optionList).get(7).click();
    	ElementActions.click(driver, faq);
    	ElementActions.click(driver, addFaqButton);
    	ElementActions.type(driver, order, faqOrder);
    	ElementActions.type(driver, arabicQuestion, arQuestion);
    	ElementActions.type(driver, englishQuestion, enQuestion);
    	ElementActions.click(driver, selectCatList);
    	ElementActions.click(driver, selectCat);
    	ElementActions.click(driver, createButton);
    	
    }
    
    public void editFaq(String arQuestion, String editedArabicQuestion , String editedEnglishQuestion) {
    	ElementActions.type(driver, searchField, arQuestion);
    	ElementActions.click(driver, button);
    	ElementActions.click(driver, editOption);
    	ElementActions.type(driver, arabicQuestion, editedArabicQuestion );
    	ElementActions.type(driver, englishQuestion, editedEnglishQuestion);
    	ElementActions.click(driver, createButton);
    	//check if FAQ edited
    	ElementActions.type(driver, searchField, editedArabicQuestion);
    	ElementActions.click(driver, button);
    	ElementActions.click(driver, viewOption);
    	String element = driver.findElement(arQuestionCheck).getText();
    	String element2 = driver.findElement(enQuestionCheck).getText();
    	Assertions.assertEquals(editedArabicQuestion, element);
    	Assertions.assertEquals(editedEnglishQuestion, element2);
    	BrowserActions.navigateToURL(driver,"https://thecontrato.com/office/faq");
    }
    
    public void deleteFaq(String arQuestion) {
    	ElementActions.type(driver, searchField, arQuestion);
    	ElementActions.click(driver, button);
    	ElementActions.click(driver, deleteOption);
    	BrowserActions.navigateToURL(driver,"https://thecontrato.com/office/faq");
    	ElementActions.type(driver, searchField, arQuestion);
    	String element = driver.findElement(emptyDataTable).getText();
    	Assertions.assertEquals("لم يعثر على أية سجلات", element);
    }

}


