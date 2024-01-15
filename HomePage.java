package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

		@FindBy(xpath="//a[text()='Contacts']")
		private WebElement contactele;

		public WebElement getContactele() {
			return contactele;
		}
		
		//Create a Constructor
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);	
		}
		
		//Create a Method
		public ContactsPage Home() {
			
			contactele.click();
			return new ContactsPage(driver);
			
		}
		
	}


