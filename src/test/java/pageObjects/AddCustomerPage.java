package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this); 
	}
	
	@FindBy(xpath ="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p")
	WebElement customerslist;
	
	@FindBy(xpath ="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
	WebElement customers;
	
	@FindBy(xpath ="/html/body/div[3]/div[1]/form[1]/div/div/a")
	WebElement addnew;
	
	@FindBy(id ="Email")
	WebElement email;
	
	@FindBy(id ="Password")
	WebElement password;
	
	@FindBy(id ="FirstName")
	WebElement firstname;
	
	@FindBy(id ="LastName")
	WebElement lastname;
	
	@FindBy(id ="Gender_Male")
	WebElement male;
	
	@FindBy(id ="Gender_Female")
	WebElement female;
	
	@FindBy(id ="DateOfBirth")
	WebElement dob;
	
	@FindBy(id ="Company")
	WebElement company;
	
	@FindBy(id ="IsTaxExempt")
	WebElement taxexempt;
	
	@FindBy(xpath ="//li[contains(text(),'Your store name')]")
	WebElement newsletter;
	
	@FindBy(xpath ="//li[contains(text(),'Vendors')]")
	WebElement customerrole;
	
	@FindBy(id ="VendorId")
	WebElement vendorid;
	
	@FindBy(id ="Active")
	WebElement active;
	
	@FindBy(id ="AdminComment")
	WebElement admincomment;

	@FindBy(xpath ="//*[@name='save']")
	WebElement save;
	

	public void customersList()
	{
		customerslist.click();
	}
	
	public void customers()
	{
		customers.click();
	}
	
	public void addnewcustomer()
	{
		addnew.click();
	}
	
	public void setEmail(String ueamil)
	{
		email.sendKeys(ueamil);
	}
	
	public void setPassword(String upass)
	{
		password.sendKeys(upass);
	}
	public void setFirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	public void setLastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void setGender(String gen)
	{
		if(gen.equals("Male"))
		{
			male.click();
		}
		else
		{
			female.click();
		}
		
	}
	public void setCompany(String comname)
	{
		company.sendKeys(comname);
	}
	
	public void setTax(String taxvalue)
	{
		if (taxvalue.equals("Yes")) {
			taxexempt.click();
		}
	}
	
	public void setNewsletter(String news)
	{
		Select se = new Select(newsletter);
		se.deselectByVisibleText(news);
	}
	
	public void setCustomerrole(String role)
	{
		if(role.equals("Vendors"))
		{
			customerrole.click();
		}
	}
	public void setVendor(String vend)
	{
		Select se=new Select(vendorid);
		se.selectByVisibleText(vend);
	}
	public void setActive()
	{
		active.click();
	}
	public void setAdmincomment(String comments)
	{
		admincomment.sendKeys(comments);
	}
	public void save()
	{
		save.click();
	}
}
