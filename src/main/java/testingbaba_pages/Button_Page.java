package testingbaba_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibary;

public class Button_Page extends BaseLibary
{
	public  Button_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@data-target='#elements']")
	private WebElement elements;
	
	@FindBy(xpath = "//a[text()='buttons']")
	private WebElement buttons;
	
	@FindBy(xpath = "//button[@ondblclick='doubletext()']")
	private WebElement doubleclick;
	
	@FindBy(xpath = "//button[@oncontextmenu='righttext()']")
	private WebElement rightclick;
	
	@FindBy(xpath = "//*[@id='double-content']")
	private WebElement doubleclicktext;
	
	@FindBy(xpath = "//*[@id='right-content']")
	private WebElement rightclicktext;
	
	public void clickonelement()
	{
		elements.click();
	}
	
	public void clickonbuttons()
	{
		try {
			Thread.sleep(2000);
			buttons.click();
			
		} catch (Exception e) {
		}
	}
	
	public void performDoubleclick_rightclick()
	{
		doubleclick(doubleclick);
		rightclick(rightclick);
	}
	public void doubletext()
	{
		String text=doubleclicktext.getText();
		System.out.println(text);
	}
	public void righttext()
	{
		String text=rightclicktext.getText();
		System.out.println(text);
	}
}
