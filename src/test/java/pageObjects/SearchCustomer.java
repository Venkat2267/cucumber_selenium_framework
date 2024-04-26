package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomer {
	
	public WebDriver ldriver;
	public SearchCustomer(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id ="SearchEmail")
	WebElement searchemail;
	
	@FindBy(id ="search-customers")
	WebElement search;
	public boolean searchcustomer(String email) throws InterruptedException
	{
		searchemail.sendKeys(email);
		search.click();
		Thread.sleep(3000);
		boolean flag = false;
		int row = ldriver.findElements(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr")).size();		
		for (int i=1;i<=row;i++)
		{
			String value = ldriver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText();
			if(email.equals(value))
			{
				flag = true;			
			}
			
		}
		return flag;
	}
	
	
}
