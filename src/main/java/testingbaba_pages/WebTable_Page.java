package testingbaba_pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import baselibrary.BaseLibary;

public class WebTable_Page extends BaseLibary
{
	public WebTable_Page()
	{
		PageFactory.initElements(driver, this);
	}
	String path="C:\\Users\\lovis\\eclipse-workspace\\27_feb_NewAutomation\\testdata\\testdata.xlsx";

	@FindBy(xpath = "//button[@data-target='#elements']")
	private WebElement elements;
	public void clickonelement()
	{
		elements.click();
	}
	@FindBy(xpath = "//a[text()='web tables']")
	private WebElement webtable;
	public void clickonwebtable() throws InterruptedException
	{Thread.sleep(2000);
		webtable.click();
	}
	@FindBy(xpath = "//iframe[@src='Webtable.html']")
	private WebElement iframe;
	
	@FindBy(xpath = "//*[@pattern='^[a-zA-Z][\\sa-zA-Z]{2,32}']")
	private WebElement name;
	
	@FindBy(xpath = "//button[text()='Edit']")
	private List<WebElement> editdetails;
	
	@FindBy(xpath = "//*[@pattern='[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$']")
	private WebElement email;
	
	@FindBy(xpath = "//*[@class='btn btn-success save-btn']")
	private WebElement savebtn;
	
	@FindBy(xpath = "//input[@name='edit_name']")
	private WebElement editname;
	
	@FindBy(xpath = "//input[@name='edit_email']")
	private WebElement editemail;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement update;
	
	
	public void Webtabledetail()
	{

		driver.switchTo().frame(iframe);
		for(int i=1; i<11; i++) {
			name.sendKeys(GetReaddata(path, 1, 0, i));
			email.sendKeys(GetReaddata(path, 1, 1, i));
			savebtn.click();
		}
		ArrayList<String> actual= new ArrayList<String>();

		for(int i=0; i<=1; i++)
		{
			for(int j=1; j<=10; j++)
			{
				actual.add(GetReaddata(path, 1, i, j));
			}
		}
		ArrayList<String> expected= new ArrayList<String>();
		for(int i=1; i<=2; i++)
		{
			for(int j=1; j<=10; j++)
			{
				String path="//*[@class='table table-bordered data-table']/tbody/tr["+j+"]/td["+i+"]";
				WebElement value=driver.findElement(By.xpath(path));
				expected.add(value.getText());
			}
		}
			SoftAssert sf= new SoftAssert();
			for(int i=0; i<actual.size(); i++)
			{
				sf.assertEquals(actual.get(i), expected.get(i));
			}
			sf.assertAll();
		
		driver.switchTo().defaultContent();
	}
	public void editdetails()
	{
		int i=1;
		for(WebElement edit:editdetails)
		{
			edit.click();
			editname.clear();
			editname.sendKeys(GetReaddata(path, 2, 0, i));
			editemail.clear();
			editemail.sendKeys(GetReaddata(path, 2, 1, i));
			i++;
			update.click();
		}
	}
}
