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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadDataFromPropertyFileOrganization {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
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
				String NAME = p.getProperty("name");
				String GROUP = p.getProperty("group");
				String INDUSTRY = p.getProperty("industry");
	
				//Step5:Load the url
				driver.get(URL);
				
			//Step6:Login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
	//Step7:To click on Organization
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	
	//Step8:To click on + icon of Organization
	driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	
	//Step9:To Enter Organization name
	driver.findElement(By.name("accountname")).sendKeys(NAME);
	
	//Step10:To click on Group radio button
	driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//Step11:Select Support group in Groupdropdown
	WebElement Groupdropdown = driver.findElement(By.name("assigned_group_id"));
	Select s = new Select(Groupdropdown);
	s.selectByVisibleText(GROUP);
	
	//Step12:Select Industrydropdown as Chemicals
		WebElement Industrydropdown = driver.findElement(By.name("industry"));
		Select s1 = new Select(Industrydropdown);
		s1.selectByValue(INDUSTRY);
		
	//Step13:Click on Save Button	
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		Thread.sleep(4000);
		
		//Step14:For Validation
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		
		String expectedtitle = "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM/Pune";
		
		/*if(actualtitle.equals(expectedtitle)) {
			System.out.println("Title are matching");
		}else {
			System.out.println("Title are not matching");
		}*/
		WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(10));
		waits.until(ExpectedConditions.titleIs(expectedtitle));
		
		//Step15:Mouse hover on Administrator icon
		WebElement adminicon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(adminicon).perform();
	
		
		Thread.sleep(2000);
		
		//Step16:Click on Signout 
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
	
	
	
	
	
	
	}

}
