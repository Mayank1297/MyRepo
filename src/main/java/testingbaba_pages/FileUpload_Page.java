package testingbaba_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.BaseLibary;

public class FileUpload_Page extends BaseLibary
{
	public FileUpload_Page()
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//button[@data-target='#elements']")
	private WebElement element;
	
	@FindBy(xpath = "//*[@href=\"#tab_8\"]")
	private WebElement uploadanddownload;
	
	@FindBy(xpath = "//*[text()='Select a file']")
	private WebElement selectfile;
	
	public void clickonelement()
	{
		element.click();
	}
	
	
	public void clickonupload() throws InterruptedException
	{Thread.sleep(2000);
		uploadanddownload.click();
	}
	
	public void clickonselectfile()
	{
		selectfile.click();
		fileupload("C:\\Users\\DELL\\eclipse-workspace\\27_feb_NewAutomation\\testdata\\testdata.xlsx");
	}
	
}
