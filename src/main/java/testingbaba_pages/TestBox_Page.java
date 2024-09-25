package testingbaba_pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import baselibrary.BaseLibary;

public class TestBox_Page extends BaseLibary
{
	public TestBox_Page()
	{
		PageFactory.initElements(driver, this);
	}
	String path="C:\\Users\\lovis\\eclipse-workspace\\27_feb_NewAutomation\\testdata\\testdata.xlsx";
	
	
   @FindBy(xpath = "//button[@data-target='#elements']")
   private WebElement elements;
   
   public void clickonelements()
   {
	  elements.click(); 
   }
   
   @FindBy(xpath = "//a[text()='text box']")
   private WebElement textbox;
   
   public void clickontextbox()
   {
	   textbox.click();
   }
   
   @FindBy(xpath = "//input[@id='fullname1']")
   private WebElement fullname;
   
   @FindBy(xpath = "//input[@id='fullemail1']")
   private WebElement fullemail;
   
   @FindBy(xpath = "//textarea[@id='fulladdresh1']")
   private WebElement caddresh;
   
   @FindBy(xpath = "//textarea[@id='paddresh1']")
   private WebElement paddresh;
   
   @FindBy(xpath = "//input[@value='Submit']")
   private WebElement submitbutton;
   
   @FindBy(xpath = "//div[@class='col-md-6 mt-5']/label")
   private List<WebElement> listdata;
   
   public void filldetails()
   {
	   fullname.sendKeys(GetReaddata(path, 0, 0, 1));
	   fullemail.sendKeys(GetReaddata(path, 0, 1, 1));
	   caddresh.sendKeys(GetReaddata(path, 0, 2, 1));
	   paddresh.sendKeys(GetReaddata(path, 0, 3, 1));
	   submitbutton.click();
   }
   public void Verify()
   {
	   SoftAssert sf= new SoftAssert();
	ArrayList<String>expected= new ArrayList<String>();
	for(int i=1;i<=listdata.size()-1;i=i+2)
	{
		expected.add(listdata.get(i).getText());
	}
	ArrayList<String>actual= new ArrayList<String>();
	actual.add(GetReaddata(path, 0, 0, 1));
	actual.add(GetReaddata(path, 0, 1, 1));
	actual.add(GetReaddata(path, 0, 2, 1));
	actual.add(GetReaddata(path, 0, 3, 1));
	
	for(int k=0;k<=actual.size()-1;k++) 
	{
		sf.assertEquals(actual.get(k), expected.get(k));
	}
		sf.assertAll();
   }
}
