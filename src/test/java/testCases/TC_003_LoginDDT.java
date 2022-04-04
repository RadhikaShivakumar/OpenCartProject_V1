package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",groups= {"Regression","master"})

	public void TC_003_testLoginDDT(String email,String password,String exp)
	{
		logger.info("started TC_003_testLoginDDT");
		
		try 
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home Page Displayed ");
			driver.manage().window().maximize();
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info(" Clicked on MyAccount  ");
			
			hp.clickLogin();
			logger.info(" Clicked on Login link ");
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			logger.info(" Provided Email");
			
			lp.setPassword(password);
			logger.info(" Provided Password");
			
			lp.clicLogin();
			logger.info(" clicked on Login button ");
			
			System.out.println("Email: "+ email);
			System.out.println("Password: "+ password);
			System.out.println("Valid or Invalid data: "+ exp);
			boolean targetPage = lp.isMyAccountPageExists();
			
			if(exp.equals("Valid"))
			{
				if(targetPage==true)
				{
					logger.info(" Login  Successful");
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					logger.info(" Clicked on logout ");
					Assert.assertTrue(true);
				}
				else
				{
					logger.error("Login Failed");
					Assert.assertTrue(false);
				}
			} 
			
			if(exp.equals("Invalid"))
			{
				if(targetPage==true)
				{
					logger.error("Login Successful");
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				}
				else 
				{
					logger.info("Login Failed");
					Assert.assertTrue(true);
				}
			}
			
		}
		catch (Exception e)
		{
			logger.fatal("Login not successful");
			Assert.fail();
		}
		
		logger.info(" Finished TC_003_LoginDDT ");
	}
	
	@DataProvider(name="LoginData")
	public String[] [] getData() throws IOException
	{
		
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		
		XLUtility xlutil = new XLUtility(path);
		
		int rowCount = xlutil.getRowCount("Sheet1");
		int colCount = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[] [] = new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
		
		
	}
	
}
