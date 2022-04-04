package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass 
{

	@Test(groups= {"regression","master"})
	public void test_Account_Registration() throws IOException
	{
		try 
		{
			driver.get(rb.getString("appURL"));
			logger.info(" Home Page Displayed ");
			driver.manage().window().maximize();
			
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			
			hp.clickRegister();
			logger.info("Clicked on Register ");
			
			AccountRegistrationPage ap = new AccountRegistrationPage(driver);
			ap.setFirstName("Ram");
			logger.info("Provided First Name ");
			
			ap.setLastName("verma");
			logger.info("Provided Last Name");
			
			ap.setEmail(randomString()+"@gmail.com");
			logger.info("Provided Email");
			
			ap.setTelephone("9199877272");
			logger.info("Provided Telephone ");
			
			ap.setPassword("test123");
			logger.info("Provided Password ");
			
			ap.setConfirmPassword("test123");
			logger.info("Provided Confirm Password ");
			
			ap.setPrivacyPolicy();
			logger.info("Set Privacy Policy ");
			
			ap.clickContinue();
			logger.info("Clicked on Continue ");
			
			String msg = ap.getConfirmationMsg();
			
			if(msg.equals("Your Account Has Been Created!"))
			{
				logger.info("Account Registration Success ");
				Assert.assertTrue(true);
			}
			else 
			{
				logger.error(" Account Registration Failed ");
				captureScreen(driver, "test_Account_Registration"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			logger.fatal(" Account Registration Failed ");
			captureScreen(driver, "test_Account_Registration"); //Capturing screenshot
			Assert.fail();
		}
	
		logger.info(" Finished TC_001_AccountRegistration ");
		
	}
}
