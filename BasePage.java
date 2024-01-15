package Basicpom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtil;
import POM.ContactinformationPage;
import POM.ContactsPage;
import POM.HomePage;
import POM.LoginPage;

public class BasePage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverUtil wutils = new WebDriverUtil();	
		
		
		
		
	WebDriver driver = new ChromeDriver();		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888");
	
	LoginPage lp = new LoginPage(driver);
	lp.Login("admin", "root");
	
		
	HomePage hp = new HomePage(driver);
	hp.Home();
		
		
	ContactsPage cp = new ContactsPage(driver);
	
	cp.getPlusicon().click();
	
	ContactinformationPage cip = new ContactinformationPage();
	PageFactory.initElements(driver, cip);
	cip.getFirstnametf().sendKeys("Akash");
	cip.getLastnametf().sendKeys("Patil");
	cip.getRadiobtn().click();
	wutils.handledropdown(cip.getGroupdropdown(), "Support Group");
	cip.getPlusiconOrgnametf().click();
	wutils.Switch(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
	cip.getSearchtf().sendKeys("Pune8");
	cip.getSearchbtn().click();
	cip.getOrgtext().click();
	wutils.Switch(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
	cip.getBirthdaytf().sendKeys("2024-01-2");
	cip.getSavebtn().click();
	wutils.totakescreenshot(driver);
	}

}
