package testingbaba_pages;

import baselibrary.BaseLibary;

public class Loginpage extends BaseLibary
{
	public void getTitle()
	{
		String title = driver.getTitle();
		System.out.println(title);
	}
	


}
