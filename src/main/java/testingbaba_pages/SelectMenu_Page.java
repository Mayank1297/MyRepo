package testingbaba_pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibary;

public class SelectMenu_Page extends BaseLibary
{
	public SelectMenu_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@data-target='#widget']")
	private WebElement selectwidget;
	
	@FindBy(xpath = "//a[text()='select menu']")
	private WebElement selectmenu;
	
	@FindBy(xpath = "//div[@id='tab_24']/form/div/div[1]/select")
	private WebElement selectdropdown;
	
	@FindBy(xpath = "//div[@id=\"tab_24\"]/form/div/div[2]/select")
	private WebElement selectone;
	
	@FindBy(xpath = "//div[@id=\"tab_24\"]/form/div/div[3]/div/select")
	private WebElement selectoldmenu;
	
	@FindBy(xpath = "//div[@class='form-group']/div/select[@multiple='multiple']")
	private WebElement selectmultiple;
	
	public void clickonselectwidget()
	{
		selectwidget.click();
	}
	
	public void clickonselectmenu() throws InterruptedException
	{Thread.sleep(2000);
		selectmenu.click();
	}
	
	public void selectdropdown()
	{
		selectbyvalue("Group 1, Option 1", selectdropdown);
	}
	
	public void select_one()
	{
		selectone("Java", selectone);
	}
	
	public void selectold_menu()
	{
		selectoldmenu("PHP", selectoldmenu);
	}
	
	public void select_multiple() throws AWTException
	{
		Robot robot=new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		selectmultiple("HTML", selectmultiple);
		selectmultiple("PHP", selectmultiple);
		selectmultiple("javascript", selectmultiple);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	}
