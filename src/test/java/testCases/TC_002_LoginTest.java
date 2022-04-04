package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void TC_002_testLogin() throws IOException
	{
		
		logger.info(" Started TC_001_LoginText ");
		
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home Page Displayed ");
			driver.manage().window().maximize();
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info(" Clicked on MyAccount  ");
			
			hp.clickLogin();
			logger.info(" Clicked on Login ");
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			logger.info(" Provided Email");
			
			lp.setPassword(rb.getString("password"));
			logger.info(" Provided Password");
			
			lp.clicLogin();
			logger.info(" clicked on Login ");
			
			boolean targetPage = lp.isMyAccountPageExists();
			if(targetPage)
			{
				logger.info(" Login Successful ");
				Assert.assertTrue(true);
			}
			else 
			{
				logger.info(" Login not Successful ");
				captureScreen(driver,"TC_002_testLogin");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			logger.fatal("Login not successful");
			captureScreen(driver,"TC_002_testLogin");
			Assert.fail();
		}
		
		logger.info(" Finished TC_002_testLogin ");
		
	}
	
}
