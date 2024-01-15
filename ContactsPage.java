package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement plusicon;

	public WebElement getPlusicon() {
		return plusicon;
	}
	
	//Create a Constructor
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}
