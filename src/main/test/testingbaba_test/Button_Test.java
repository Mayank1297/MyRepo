package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibary;
import testingbaba_pages.Button_Page;

public class Button_Test extends BaseLibary
{
	Button_Page ob;
	@Parameters("env")
	@BeforeTest
	public void getlaunchurl(String env)
	{
		getLaunchUrl(getReaddata(env));
		ob= new Button_Page();
	}
	
	@Test(priority = 1)
	public void clickonelement()
	{
		ob.clickonelement();
	}
	
	@Test(priority = 2)
	public void clickonbuttons()
	{
		ob.clickonbuttons();
	}
	
	@Test(priority = 3)
	public void performDoubleclick_rightclick()
	{
		ob.performDoubleclick_rightclick();
	}
	
	@Test(priority = 4)
	public void doubletext()
	{
	ob.doubletext();
	}
	
	@Test(priority = 5)
	public void righttext()
	{
		ob.righttext();
	}
}
