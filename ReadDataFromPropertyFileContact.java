package Basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ReadDataFromPropertyFileContact {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		
		//Step1:To Read data from External File
	FileInputStream fis = new FileInputStream("src\\test\\resources\\Data.properties");

	//Step2:To read data from Property file
			Properties p = new Properties();
			
		//Step3:To fetch the location of property file
			p.load(fis);
			
			//Step4:We read all keys present in property file
			String BROWSER = p.getProperty("browser");
			
		//To Launch browser 	
			if(BROWSER.equalsIgnoreCase("Chrome")) {
			 driver = new ChromeDriver();
			}else if(BROWSER.equalsIgnoreCase("Edge")) {
			 driver = new EdgeDriver();
			}else {
			driver = new FirefoxDriver();	
			System.out.println("Default browser");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
			String URL = p.getProperty("url");
			String USERNAME = p.getProperty("username");
			String PASSWORD = p.getProperty("password");
			String FIRSTNAME = p.getProperty("firstname");
			String LASTNAME = p.getProperty("lastname");
			String GROUP = p.getProperty("group");
			
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
	
	
	
	
	}

}
