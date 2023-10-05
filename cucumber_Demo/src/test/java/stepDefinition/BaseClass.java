package stepDefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import pageObjects.AddcustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AddcustomerPage addCust;
	public SearchCustomerPage searchCust;
	
	//created for generating random string for unique email
	
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
		
	}

}
