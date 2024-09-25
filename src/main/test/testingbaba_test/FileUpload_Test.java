package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.BaseLibary;
import testingbaba_pages.FileUpload_Page;

public class FileUpload_Test extends BaseLibary
{
	FileUpload_Page ob;
	@Parameters("env")
	@BeforeTest
	public void getlaunchurl_TestingBaba(String env)
	{
		getLaunchUrl(getReaddata(env));
		ob= new FileUpload_Page();
	}
	
	@Test(priority = 1)
	public void clickon_element(){
		ob.clickonelement();
	}
	
	@Test(priority = 2)
	public void ToVerifyclickonupload() throws InterruptedException {
		ob.clickonupload();
	}
	
	@Test(priority = 3)
	public void clickon_selectfile() {
		ob.clickonselectfile();
	}
}
