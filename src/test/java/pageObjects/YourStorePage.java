package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourStorePage {
	
	public WebDriver driver;
	
	public YourStorePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="YourStorePage")
	WebElement lnkAddtoCart;
	
	public void clickAddToCart()
	{
		lnkAddtoCart.click();
	}
	
}
