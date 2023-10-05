package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import javax.validation.contraints.Size;
//import java.awt.Dimension;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	WaitHelper waitHelper;
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waitHelper=new WaitHelper(ldriver);
		
	}
	
	@FindBy(id="SearchEmail")
	@CacheLookup
	WebElement srchEmail;
	
	@FindBy(id="SearchFirstName")
	@CacheLookup
	WebElement srchFirstName;
	
	@FindBy(id="SearchLastName")
	@CacheLookup
	WebElement srchLastName;
	
	
	@FindBy(id="search-customers")
	@CacheLookup
	WebElement srchButton;
	
	@FindBy(id="customers-grid_wrapper")
	@CacheLookup
	WebElement srchTable;
	
	@FindBy(xpath="//div[@id='customers-grid_wrapper']//tbody/tr")
	@CacheLookup
	WebElement TableRows;
	
	@FindBy(xpath="//div[@id='customers-grid_wrapper']//tbody/tr/td")
	@CacheLookup
	WebElement TableColumns;
	
	
	public void setEmail(String email)
	{
		waitHelper.WaitForElement(srchEmail, 30);
		srchEmail.clear();
		srchEmail.sendKeys(email);
		
	}
	
	public void setFirstName(String fname)
	{
		waitHelper.WaitForElement(srchFirstName, 30);
		srchFirstName.clear();
		srchFirstName.sendKeys(fname);
		
	}
	
	public void setLastName(String lname)
	{
		waitHelper.WaitForElement(srchLastName, 30);
		srchLastName.clear();
		srchLastName.sendKeys(lname);
		
	}
	
	
	public void clickSearch() {
		srchButton.click();
		waitHelper.WaitForElement(srchButton, 30);
		
	}
	
	public Dimension getNoOfRows() {
		return(TableRows.getSize());
	}
	
	
	public Dimension getNoOfColumns() {
		return(TableColumns.getSize());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag=false;
		//for( int i=1;i<=1;i++)
		//{
			String emailid=srchTable.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr[1]/td[2]")).getText();
			System.out.println(emailid);
			if(emailid.equals(email))
			{
				flag=true;
			}
		//}
		return flag;
	}
	
	public boolean searchCustomerByName(String Name)
	{
		boolean flag=false;
		String name=srchTable.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr[1]/td[3]")).getText();
		String names[]=name.split(" ");//separating fname and lastname
		if(names[0].equals("Victoria") && names[1].equals("Terces"))
		{
			flag=true;
		}
		return flag;
		
	}
	


}
