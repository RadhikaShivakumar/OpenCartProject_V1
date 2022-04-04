package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	WebDriver driver;
	
	//construct
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;

	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtSearch;
	
	@FindBy(xpath="//span[@class='input-group-btn']")
	WebElement btnSearch;
	
	@FindBy(xpath="//a[text()='iMac']")
	WebElement productCaption;
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	public void search(String product)
	{
		txtSearch.sendKeys(product);
	}
	
	public void clickbtnSearch()
	{
		btnSearch.click();
	}
	
	public String productCaption()
	{
		return (productCaption.getText());
	}
}
