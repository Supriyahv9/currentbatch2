package Module;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
	WebDriver driver;
		
	PropertyFileUtil putils =new PropertyFileUtil();
	WebDriverUtil  wutils = new WebDriverUtil();
	
	
	//Read data from property file
	String BROWSER = putils.getdatafromPropertyFile("browser");
	String URL = putils.getdatafromPropertyFile("url");
	String USERNAME = putils.getdatafromPropertyFile("username");
	String PASSWORD = putils.getdatafromPropertyFile("password");
	String FIRSTNAME = putils.getdatafromPropertyFile("firstname");
	String LASTNAME = putils.getdatafromPropertyFile("lastname");
	String GROUP = putils.getdatafromPropertyFile("group");
				
		//To Launch browser 	
			if(BROWSER.equalsIgnoreCase("Chrome")) {
			 driver = new ChromeDriver();
			}else if(BROWSER.equalsIgnoreCase("Edge")) {
			 driver = new EdgeDriver();
			}else {
			driver = new FirefoxDriver();	
			System.out.println("Default browser");
			}
			
			wutils.maximizewindow(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
			
			//Step5:Load the url
			driver.get(URL);
			
		//Step6:Login to application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
		//Step7:Click on Contacts
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			
		//Step8:Click on +(Create contact..) icon
			driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
			
		//Step9:Enter the First name
			driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
			
		//Step10:Enter the Last name
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			
		//Step11:Click on Group radio button
			driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//Step12:Select Support Group in groupdropdown
		WebElement Groupdropdown = driver.findElement(By.name("assigned_group_id"));	
		Select s = new Select(Groupdropdown);
		s.selectByVisibleText(GROUP);
		
	//Step13:Click on + icon in Organization name tf
	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	
//		Transfer control from Parent to child
		
			Set<String> ids = driver.getWindowHandles();
			System.out.println(ids);
			
			for(String e : ids) {
				String actaulurl = driver.switchTo().window(e).getCurrentUrl();
				System.out.println(actaulurl);
				
			String	childurl="http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
				
				if(actaulurl.contains(childurl)) {
					break;
				}
			}
			
			
	//Step14:Search Organization name in search tf
		driver.findElement(By.id("search_txt")).sendKeys("Pune8");
	
	//Step15:Click on search now btn
		driver.findElement(By.name("search")).click();
		
	//Step16:Click on Organization name text
		driver.findElement(By.xpath("//a[text()='Pune8']")).click();
		
		
	//Transfer control from Child to parent
		
				for(String e :ids) {
					String actualurl = driver.switchTo().window(e).getCurrentUrl();
					
				String	parenturl="http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
					if(actualurl.contains(parenturl)) {
						break;
					}
				}
				
	//Step17:Enter the date in Birthdate
	driver.findElement(By.id("jscal_field_birthday")).sendKeys("2024-01-2");
	
	//Step18:Click on Save btn
	driver.findElement(By.name("button")).click();
	
	//Step19:Mouse hover on Administrator icon
			WebElement adminicon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions a = new Actions(driver);
			a.moveToElement(adminicon).perform();
		
			
			Thread.sleep(2000);
			
			//Step20:Click on Signout 
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	}

}
