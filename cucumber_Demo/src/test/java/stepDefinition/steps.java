package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class steps extends BaseClass{
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
	   
	}

	@When("Click on Login")
	public void click_on_login() {
		lp.clickLogin();
	   
	}

	@Then("Login Page Title should be {string}")
	public void Login_page_title_should_be(String title) {
		if(title.contains("Dashboard / nopCommerce administration"))
		{
			System.out.println("Login successful");
			
		}
		else
		{
			System.out.println("Login unsuccessful");
			
		}
	}

	@When("User cick on Log out link")
	public void user_cick_on_log_out_link() throws InterruptedException{
		lp.clickLogout();
		Thread.sleep(3000);
	    
	}
	
	@Then("Logout Page Title should be {string}")
	public void Logout_page_title_should_be(String title1) {
		
		if(title1.contains("Your store. Login"))
		{
			//Assert.assertEquals(title1, driver.getTitle());
			//driver.close();
			System.out.println("Logout successful");
			
			
		}
		else
		{
			System.out.println("Logout Unsucessful");
		}
	}


	@And("close browser")
	public void close_browser() {
		driver.quit();
	    
	}
	
	//Customers feature step definitions
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		addCust=new AddcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}
	
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException{
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	}
	
	@And("click on customers Menu item")
	public void click_on_customers_Menu_Item() throws InterruptedException
	{
		Thread.sleep(2000);
		addCust.clickOnCustomersMenuItem();
	}
	
	@And("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException
	{
		addCust.clickOnAddnew();
		Thread.sleep(2000);
	}
	
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page()  {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
		
	}
	
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
		String email=randomestring()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		addCust.setCustomerRoles("Guest");
		Thread.sleep(3000);
		
		addCust.setManagerofVendor("Vendor 2");
		addCust.setGender("Female");
		addCust.setFirstName("Shreya");
		addCust.setLastName("S");
		addCust.setDob("7/05/1999");
		
		addCust.setCompanyName("busyQA");
		//addCust.setAdminContent("This is for testing");
		
		
	}
	
	@And("click on Save button")
	public void click_on_save_button() throws InterruptedException
	{
		addCust.clickOnSave();
		Thread.sleep(2000);
	}
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg)
	{
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
		
	}
	
	@And("Enter customers Email")
	public void enter_customers_Email()
	{
		searchCust=new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
		
	}
	
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException
	{
		searchCust.clickSearch();
		Thread.sleep(3000);
		
	}
	
	@Then("User details should display in search table")
	public void user_details_should_display_in_search_table()
	{
		Boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
		
	}
	
	//Steps for searching customer using firstname and lastname
	
	@And("Enter customers FirstName")
	public void enter_customers_firstName()
	{
		searchCust=new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
		
	}
	
	@And("Enter customers LastName")
	public void enter_customers_LastName()
	{
		searchCust.setLastName("Terces");
	}
	
	@Then("User details with name should display in search table")
	public void user_details_with_name_should_display_in_search_table()
	{
		Boolean status1=searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status1);
	}
	



}
