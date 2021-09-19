package pages.contracts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.shaft.gui.element.ElementActions;

public class Lease_Of_Apartment_Contract {
	
	// Constructor
		private WebDriver driver;
	    public Lease_Of_Apartment_Contract(WebDriver driver){
	        this.driver = driver ;
	    }
	    
	 // Locators
	    private By rentCat = By.className("it-cat-1028");
	    private By chooseCat = By.className("it-cat-1109");
	    private By createContract = By.linkText("انشاء العقد");
	    private By contractDate = By.className("mydateicon_84092");
	    private By pickDay = By.cssSelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top > div.datepicker-days > table > tbody > tr:nth-child(3) > td:nth-child(5)");
	    private By firstPartyGender = By.className("value_84091");
	    private By secPartyGender = By.className("value_84086");
	    private By textInput = By.className("textEntered");
	    private By nextButton = By.className("btnNext");
	    // Sec Band
	    private By propertyNo = By.className("value_84081");
	    private By streetName = By.className("value_84093");
	    private By floorNo = By.className("value_84080");
	    private By apartNo = By.className("value_84078");
	    private By qessm = By.className("value_84077");
	    private By governante = By.className("value_84076");
	    private By area = By.className("value_84075");
	    // 3rd Band
	    private By termOf = By.className("value_84074");
	    private By cal2 = By.className("mydatediv_84073");
	    private By date2 = By.cssSelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top > div.datepicker-days > table > tbody > tr:nth-child(3) > td:nth-child(5)");
	    private By cal3 = By.className("mydatediv_84072");
	    private By date3 = By.cssSelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top > div.datepicker-days > table > tbody > tr:nth-child(3) > td:nth-child(3)");
	   
	 // Actions 
	    public void accessContract() {
	    	ElementActions.click(driver, rentCat);
	    	ElementActions.click(driver, chooseCat);
	    	ElementActions.click(driver, createContract);
	    }
	    public void FirstBandData() {
	    	int [] fields = {1,2,3,4,5,6,7,8,9};
	    	ElementActions.click(driver,contractDate);
	    	ElementActions.click(driver, pickDay);
	    	ElementActions.select(driver, firstPartyGender, "ذكر");
	    	ElementActions.select(driver, secPartyGender, "أنثى");
	    	for (int j : fields) {
	            if (driver.findElements(textInput).get(j).getAttribute("class").contains("number") || driver.findElements(textInput).get(j).getAttribute("data-code").contains("@FirstpartynationalidentificationnumberCode")) {
	                driver.findElements(textInput).get(j).sendKeys("12345678912345");
	            } else if(driver.findElements(textInput).get(j).getAttribute("data-code").contains("@SecondpartynationalidentificationnumberCode")) {
	                driver.findElements(textInput).get(j).sendKeys("22345678912345");
	            }else {
	                driver.findElements(textInput).get(j).sendKeys("داتا");
	            }
	        }
	    	driver.findElements(nextButton).get(0).click();
	    
	    }
	    
	    public void SecBandData() {
	    	ElementActions.type(driver, propertyNo,"2");
	    	ElementActions.type(driver, streetName, "داتا");
	    	ElementActions.type(driver, floorNo, "2");
	    	ElementActions.type(driver, apartNo, "2");
	    	ElementActions.type(driver, qessm , "داتا");
	    	ElementActions.type(driver, governante , "داتا");
	    	ElementActions.type(driver, area , "200");
	    	driver.findElements(nextButton).get(1).click();
	    }
	    public void ThirdBandData() {
	    	ElementActions.type(driver, termOf,"2");
	    	ElementActions.click(driver, cal2);
	    	ElementActions.click(driver, date2);
	    	ElementActions.click(driver, cal3);
	    	ElementActions.click(driver, date3);
	    	driver.findElements(nextButton).get(2).click();
	    }
}
