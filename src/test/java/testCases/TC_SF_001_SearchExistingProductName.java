package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_SF_001_SearchExistingProductName extends BaseClass
{

	@Test
	public void testSearchExistingProductName() throws IOException
	{

		try 
		{
			driver.get(rb.getString("appURL"));
			logger.info(" Home Page Displayed ");
			driver.manage().window().maximize();
			
			HomePage hp = new HomePage(driver);
			hp.search("iMac");
			logger.info("Entered iMac in search result");
			
			hp.clickbtnSearch();
			logger.info("clicked on search result");
			
			String searchResult = hp.productCaption();
			
			if(searchResult.equals("iMac"))
			{
				logger.info("Searched product shown in search result.");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("product is not shown correctly on the search result.");
				captureScreen(driver,"testSearchExistingProductName");
				Assert.assertTrue(false);
			}
		}
		
		catch(Exception e)
		{
			logger.fatal(" product search Failed ");
			captureScreen(driver, "testSearchExistingProductName"); //Capturing screenshot
			Assert.fail();
		}
	
		logger.info(" Finished TC_SF_001_SearchExistingProductName ");
		
		
	}
}
