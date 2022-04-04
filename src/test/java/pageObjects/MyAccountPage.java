package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	public WebDriver driver;
	

	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	@FindBy(xpath="//a[text()='MacBook']")
	WebElement lnkMacbook;
	
	public void clickLogout()
	{
		lnkLogout.click();
	}

	public void clicklnkMacbook()
	{
		lnkMacbook.click();
	}
	
}
