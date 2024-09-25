package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibary;
import testingbaba_pages.Loginpage;

public class Logintest extends BaseLibary
{
	Loginpage ob;
	@Parameters("env")
	@BeforeTest
	public void getLaunch_urlTestingbaba(String env) 
	{
		getLaunchUrl(getReaddata(env));
		ob= new Loginpage();
	}
	
	@Test
	public void getTitle_testingbaba()
	{
		ob.getTitle();
		
	}
} 
