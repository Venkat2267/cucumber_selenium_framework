package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.Loginpage;
import pageObjects.SearchCustomer;

public class Steps {
	
	public WebDriver driver;
	Loginpage lp;
	AddCustomerPage cp;
	SearchCustomer sp;
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
	    System.setProperty("webdriver.chrome.driver",".//Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    lp = new Loginpage(driver);
	    cp = new AddCustomerPage(driver);
	    sp = new SearchCustomer(driver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	   driver.get(url);
	   driver.manage().window().maximize();
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pass) {
	    
		lp.setUserName(email);
		lp.setPassword(pass);
	}

	@When("Click on login")
	public void click_on_login() throws InterruptedException {
	    lp.clickLogin();
	    Thread.sleep(4000);
	}

	@Then("Page Title Should be {string}")
	public void page_title_should_be(String title) {
	   if(driver.getPageSource().contains("Login was unsuccessful."))
	   {
		   driver.close();
		   Assert.assertTrue(false);
	   }
	   else
	   {
		   Assert.assertEquals(title, driver.getTitle());
	   }
	}

	@When("User click on the Log out")
	public void user_click_on_the_log_out() {
	    lp.clicLogout();
	}

	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	}
	
	//Customer Feature
	
	
	@Then("User can view dashboard")
	public void user_can_view_dashboard() {
			
	}

	@When("User Click on customer menu")
	public void user_click_on_customer_menu() {
	   
		cp.customersList();
	}

	@When("Click on Customer menu item")
	public void click_on_customer_menu_item() {
	   cp.customers();
	}

	@When("Click on add new")
	public void click_on_add_new() {
	    cp.addnewcustomer();
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
	    
	}

	@When("Enter Customer Info Email  as {string} password as {string} Firstname as {string} Lastname as {string} gender as {string} company as {string} tax as {string} news as {string} role as {string} vendor as {string} comment as {string}")
	public void enter_customer_info_email_as_password_as_firstname_as_lastname_as_gender_as_company_as_tax_as_news_as_role_as_vendor_as_comment_as(String email, String password, String firstname, String lastname, String gender, String company, String tax, String news, String role, String vendor, String comment) throws InterruptedException {
	   cp.setEmail(email);
	   cp.setPassword(password);
	   cp.setFirstname(firstname);
	   cp.setLastname(lastname);
	   cp.setGender(gender);
	   cp.setCompany(company);
	   cp.setTax(tax);
	   //cp.setNewsletter(news);
	   //cp.setCustomerrole(role);
	   cp.setVendor(vendor);
	   cp.setActive();
	   cp.setAdmincomment(comment);
	   Thread.sleep(5000);
	}

	@When("Click on save button")
	public void click_on_save_button() {
	    cp.save();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
	    if(driver.getPageSource().contains(message))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}
	
	//Search for Customer
	
	@When("Enter Customer Email as {string}")
	public void enter_customer_email_as(String email) throws InterruptedException {
	    boolean value = sp.searchcustomer(email);
	    
	    Assert.assertEquals(value,true);
	}
	


}
