package AdminPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;

public class AdminPanelJobPage {
	
	// Constructor
			private WebDriver driver;
		    public AdminPanelJobPage(WebDriver driver){
		        this.driver = driver ;
		    }
		     // Locators
		
		        private By job = By.xpath("//a[@href='/office/careers']");
		        private By addJobButton = By.className("pull-right");
		        private By arabicJobTitle = By.id("JobTitleAr");
		        private By englishJobTitle = By.id("JobTitleEn");
		        private By arabicJobType = By.id("JobTypeAr");
		        private By englishJobType = By.id("JobTypeEn");
		        private By arabicEmpType = By.id("EmployeeTypeAr");
		        private By englishEmpType = By.id("EmployeeTypeEn");
		        private By arabicLocation = By.id("LocationAr");
		        private By englishLocation = By.id("LocationEn");
		        private By arabicExp = By.id("ExperienceAr");
		        private By englishExp = By.id("ExperienceEn");
		        private By salaryFrom = By.id("SalaryFrom");
		        private By salaryTo = By.id("SalaryTo");
		        private By jobMail = By.id("JobEmail");
		        // private By qualifications = By.id("QualificationsAr");
		        private By positions = By.id("OpeningPositions");
		        private By saveButton = By.cssSelector("body > div.wrapper > div.main-panel > div > div > div > div.row > div > div > div.card-body > form > fieldset > div:nth-child(8) > div > button");
		        private By searchField = By.xpath("//input[@type='search']");
		        private By jobButton = By.className("dropdown-toggle");
		        private By deleteButton = By.xpath("//a[@onclick='Delete(this)']");
		        private By editButton = By.linkText("تعديل");
		        private By viewButton = By.linkText("التفاصيل");
		        private By expCheck = By.xpath("//dl[@class='dl-horizontal']/dd[5]");
		        private By emptyDataTable = By.className("dataTables_empty");
		        
		     // Actions

		        public void addNewJob(String arTitle , String enTitle , String arType , String enType , String arEmp , String enEmp , String arLocation , String enLocation ,String arExp , String enExp, String salaryF , String salaryT, String jobEmail , String avPositions) {
		        	ElementActions.click(driver, job);
		        	ElementActions.click(driver,addJobButton);
		        	ElementActions.type(driver, arabicJobTitle,arTitle);
		        	ElementActions.type(driver, englishJobTitle, enTitle);
		        	ElementActions.type(driver, arabicJobType, arType );
		        	ElementActions.type(driver, englishJobType, enType );
		        	ElementActions.type(driver, arabicEmpType, arEmp );
		        	ElementActions.type(driver, englishEmpType, enEmp );
		        	ElementActions.type(driver, arabicLocation, arLocation );
		        	ElementActions.type(driver, englishLocation, enLocation );
		        	ElementActions.type(driver, arabicExp, arExp );
		        	ElementActions.type(driver, englishExp, enExp );
		        	ElementActions.type(driver, salaryFrom, salaryF );
		        	ElementActions.type(driver, salaryTo, salaryT );
		        	ElementActions.type(driver, jobMail, jobEmail );
		    	    ElementActions.type(driver, positions, avPositions);
		        	ElementActions.click(driver, saveButton);
		 	        }
		        
		        public void editJob(String arTitle, String arExp , String enExp) {
		        	ElementActions.type(driver, searchField, arTitle);
		        	ElementActions.click(driver, jobButton);
		        	ElementActions.click(driver, editButton);
		        	ElementActions.type(driver, arabicExp, arExp );
		        	ElementActions.type(driver, englishExp, enExp );
		        	ElementActions.click(driver, saveButton);
		        	//check if job edited
		        	ElementActions.type(driver, searchField, arTitle);
		        	ElementActions.click(driver, jobButton);
		        	ElementActions.click(driver, viewButton);
		        	String element = driver.findElement(expCheck).getText();
		        	Assertions.assertEquals(arExp, element);
		        }
		        
		        public void deleteJob(String arTitle ) {
		        	ElementActions.type(driver, searchField, arTitle);
		        	ElementActions.click(driver, jobButton);
		        	ElementActions.click(driver, deleteButton);
		        	BrowserActions.navigateToURL(driver,"https://thecontrato.com/office/careers/");
		        	ElementActions.type(driver, searchField, arTitle);
		        	String element = driver.findElement(emptyDataTable).getText();
		        	Assertions.assertEquals("لم يعثر على أية سجلات", element);
		        	
		        }

}
