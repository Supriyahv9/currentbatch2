package Basic;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switch1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("Patil");
		
		//Click on + icon in Organization name tf
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
	//	Transfer control from Parent to child
		
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
		Thread.sleep(2000);
		//search Org name
		driver.findElement(By.id("search_txt")).sendKeys("Pune8");
		//click on search now
		driver.findElement(By.name("search")).click();
		//Click on Org name text
		driver.findElement(By.xpath("//a[text()='Pune8']")).click();
		
		//Transfer control from Child to parent
		
		for(String e :ids) {
			String actualurl = driver.switchTo().window(e).getCurrentUrl();
			
		String	parenturl="http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
			if(actualurl.contains(parenturl)) {
				break;
			}
		}
		
		Thread.sleep(2000);
		//click on calender
		driver.findElement(By.id("jscal_trigger_birthday")).click();
		Thread.sleep(2000);
		//Select date
		driver.findElement(By.xpath("(//td[text()='29'])[4]")).click();
	}

}
