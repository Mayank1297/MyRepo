package testingbaba_test;

import java.awt.AWTException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibary;
import jdk.jfr.Description;
import testingbaba_pages.SelectMenu_Page;

public class SelectMenu_Test extends BaseLibary
{
	SelectMenu_Page ob;
	@Parameters("env")
	@BeforeTest
	public void getlaunchurl_TestingBaba(String env)
	{
		getLaunchUrl(getReaddata(env));
		ob= new SelectMenu_Page();
	}
	@Description("To Click on Widget")
	@Test(priority = 1)
	public void clickonselectwidget()
	{
		ob.clickonselectwidget();
	}
	
	@Description("To click on Select Menu")
	@Test(priority = 2)
	public void clickonselectmenu() throws InterruptedException
	{
		ob.clickonselectmenu();
	}
	
	@Description("To Select Drop Down")
	@Test(priority = 3)
	public void selectdropdown()
	{
		ob.selectdropdown();
	}
	
	@Description("To Select One Value")
	@Test(priority = 4)
	public void select_one()
	{
		ob.select_one();
	}
	
	@Description("To select old style menu")
	@Test(priority = 5)
	public void selectold_menu()
	{
		ob.selectold_menu();
	}
	@Test(priority = 6)
	public void select_multiple() throws AWTException
	{
		ob.select_multiple();
	}
}
