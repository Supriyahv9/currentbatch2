package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactinformationPage {

	@FindBy(name="firstname")
	private WebElement firstnametf;
	
	@FindBy(name="lastname")
	private WebElement lastnametf;

	public WebElement getFirstnametf() {
		return firstnametf;
	}

	public WebElement getLastnametf() {
		return lastnametf;
	}
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement radiobtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement groupdropdown;

	public WebElement getRadiobtn() {
		return radiobtn;
	}

	public WebElement getGroupdropdown() {
		return groupdropdown;
	}
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement plusiconOrgnametf;

	public WebElement getPlusiconOrgnametf() {
		return plusiconOrgnametf;
	}
	
	@FindBy(id="search_txt")
	private WebElement searchtf;

	public WebElement getSearchtf() {
		return searchtf;
	}
	
	@FindBy(name="search")
	private WebElement searchbtn;

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	@FindBy(xpath="//a[text()='Pune8']")
	private WebElement Orgtext;

	public WebElement getOrgtext() {
		return Orgtext;
	}
	
	@FindBy(id="jscal_field_birthday")
	private WebElement birthdaytf;

	public WebElement getBirthdaytf() {
		return birthdaytf;
	}
	
	@FindBy(name="button")
	private WebElement savebtn;

	public WebElement getSavebtn() {
		return savebtn;
	}
}
