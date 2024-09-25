package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibary;
import testingbaba_pages.CheckBox_Page;

public class CheckBox_Test extends BaseLibary
{
	CheckBox_Page ob;
	@Parameters("env")
	@BeforeTest
	public void getlaunchurl_TestingBaba(String env)
	{
		getLaunchUrl(getReaddata(env));
		ob= new CheckBox_Page();
	}
	@Test(priority = 1)
	public void clickonelement() {
		ob.clickonelement();
	}
	@Test(priority = 2)
	public void clickoncheckbox() {
		ob.clickoncheckbox();
	}
	@Test(priority = 3)
	public void clickonmobile() {
		ob.clickonmobile();
	}
	@Test(priority = 4)
	public void clickonlaptop() {
		ob.clickonlaptop();
	}
	@Test(priority = 5)
	public void clickondesktop() {
		ob.clickondesktop();
	}
			
}
