package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibary;
import testingbaba_pages.TestBox_Page;

public class TestBox_Test extends BaseLibary
{
	TestBox_Page ob;
	@Parameters("env")
	@BeforeTest
	public void getlaunchurl(String env)
	{
		getLaunchUrl(getReaddata(env));
		ob=new TestBox_Page();
	}

	@Test(priority = 0)
	public void clickonelements()
	{
		ob.clickonelements();
	}
	@Test(priority = 1)
	public void clickontextbox()
	{
		ob.clickontextbox();
	}
	@Test(priority = 2)
	public void filldetails()
	{
		ob.filldetails();
	}
	@Test(priority = 3)
	public void Verify()
	{
		ob.Verify();
	}
}
