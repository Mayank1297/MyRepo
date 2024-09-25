package testingbaba_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baselibrary.BaseLibary;

public class CheckBox_Page extends BaseLibary
{
	public CheckBox_Page()
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//button[@data-target='#elements']")
	private WebElement element;
	
	@FindBy(xpath = "//*[@href='#tab_2']")
	private WebElement checkbox;
	
	@FindBy(xpath = "//*[@onclick='myFunction()']")
	private WebElement mobilecheckbox;
	
	@FindBy(xpath = "//input[@id='mylaptop']")
	private WebElement laptopcheckbox;
	
	@FindBy(xpath = "//input[@id='mydesktop']")
	private WebElement desktopcheckbox;
	
	@FindBy(xpath = "//*[@id='text']")
	private WebElement mobiletext;
	
	@FindBy(xpath = "//*[@id='text1']")
	private WebElement laptoptext;
	
	@FindBy(xpath = "//*[@id='text2']")
	private WebElement desktoptext;
	
	@FindBy(xpath = "//*[@src='Checkbox.html']")
	private WebElement iframe;
	
	public void clickonelement()
	{
		element.click();
	}
	
	public void clickoncheckbox()
	{
		checkbox.click();
	}
	
	public void clickonmobile()
	{
		if(getReaddata("mobile").equals("true"))
		{
			driver.switchTo().frame(iframe);
			mobilecheckbox.click();	
			Assert.assertEquals(getReaddata("mobiletext"), mobiletext.getText());
		}
		
	}
	
	public void clickonlaptop()
	{
		if(getReaddata("laptop").equals("true"))
		{
			laptopcheckbox.click();
		}
	}
	
	public void clickondesktop()
	{
		if(getReaddata("desktop").equals("true"))
		{
			desktopcheckbox.click();
			driver.switchTo().defaultContent();
		}
		
	}
}
