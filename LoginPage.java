package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
		@FindBy(name="user_name")
		private WebElement usernametf;
		
		@FindBy(name="user_password")
		private WebElement passwordtf;
		
		@FindBy(id="submitButton")
		private WebElement loginbtn;

		public WebElement getUsernametf() {
			return usernametf;
		}

		public WebElement getPasswordtf() {
			return passwordtf;
		}

		public WebElement getLoginbtn() {
			return loginbtn;
		}
		
		//Create Constructor
		public LoginPage(WebDriver driver) {
		
			PageFactory.initElements(driver, this);
		}
		
		//Create a method
		public HomePage Login(String usernamedata,String passworddata) {
			
			usernametf.sendKeys(usernamedata);
			passwordtf.sendKeys(passworddata);
			loginbtn.click();
			return new HomePage(driver);
			
			
			
		}
		
		
		
		
	}


