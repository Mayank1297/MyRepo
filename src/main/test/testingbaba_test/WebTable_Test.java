package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibary;
import testingbaba_pages.WebTable_Page;

public class WebTable_Test extends BaseLibary
{
	WebTable_Page ob;
	@Parameters("env")
	@BeforeTest
	public void getlaunchurl(String env)
	{
		getLaunchUrl(getReaddata(env));
		ob=new WebTable_Page();
	}
	@Test(priority = 1)
	public void clickonelement()
	{
		ob.clickonelement();
	}
	@Test(priority = 2)
	public void clickonwebtable() throws InterruptedException
	{
		ob.clickonwebtable();
	}
	@Test(priority = 3)
	public void Webtabledetail()
	{
		ob.Webtabledetail();
	}
	
	@Test(priority = 4)
	public void editdetails()
	{
		ob.editdetails();
	}
}
