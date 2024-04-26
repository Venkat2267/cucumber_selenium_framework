package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	public WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement textEmail;
	
	@FindBy(id = "Password")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(xpath = "//*[@type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement btnLogout;
	
	public void setUserName(String uname)
	{
		textEmail.clear();
		textEmail.sendKeys(uname);
	}
	
	public void setPassword(String pass)
	{
		textPassword.clear();
		textPassword.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	public void clicLogout()
	{
		btnLogout.click();
	}

}
