package baselibrary;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import applicationutility.Applicationutility;
import excExelutility.Excelutility;
import propertyutility.Propertyutility;
import screenshotutility.ScreenShotUtility;

public class BaseLibary implements ScreenShotUtility, Applicationutility,Excelutility,Propertyutility
{
	static public WebDriver driver;
    String closebtn="//button[text()='×']";
    String practice="//a[text()='Practice']";
    String configloc="C:\\Users\\lovis\\eclipse-workspace\\27_feb_NewAutomation\\testdata\\config.properties";
	public void getLaunchUrl(String url)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lovis\\eclipse-workspace\\27_feb_NewAutomation\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(closebtn)).click();
		driver.findElement(By.xpath(practice)).click();

	}
	@AfterMethod
	public void Teardown() {
		//driver.quit();
	}
	@Override
	public String GetReaddata(String path, int sheet, int col, int row) {
		String value="";
		try {
			FileInputStream fis= new FileInputStream(path);
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sheetno= wb.getSheetAt(sheet);
			value=sheetno.getRow(row).getCell(col).getStringCellValue();
			
			
		} catch (Exception e) 
		{
			System.out.println("Issue in GetReaddata "+e);
		}
		return value;
	}
	@Override
	public String getReaddata(String key) {
		String value="";
		try {
			FileInputStream fis= new FileInputStream(configloc);
			Properties prop= new Properties();
			prop.load(fis);
			value=prop.getProperty(key);
			
		} catch (Exception e) {
			System.out.println("Issue in Property File "+e);
		}
		return value;
	}
	@Override
	public void doubleclick(WebElement ele) {
		Actions act= new Actions(driver);
		act.doubleClick(ele).perform();
	}
	@Override
	public void rightclick(WebElement ele) {
		Actions act= new Actions(driver);
		act.contextClick(ele).perform();
	}
	@Override
	public void fileupload(String loc) 
	{
		try {
			Robot robot=new Robot();
			robot.delay(1000);
			StringSelection sec= new StringSelection(loc);
			Clipboard clip=Toolkit.getDefaultToolkit().getSystemClipboard();
			clip.setContents(sec, null);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
			
			
		} catch (Exception e) {
			
		}
		
	}
	@Override
	public void selectbyvalue(String value, WebElement ele) {
       Select sel= new Select(ele);
       sel.selectByVisibleText(value);
	}
	@Override
	public void selectone(String value, WebElement ele) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(value);
	}
	@Override
	public void selectoldmenu(String value, WebElement ele) {
		Select sel=new Select(ele);
		sel.selectByVisibleText(value);
	}
	@Override
	public void selectmultiple(String value, WebElement ele)
	{
		Select sel = new Select(ele);
		sel.selectByVisibleText(value);
		
	}
	
	/*public String getdatetime()
	{
		String Value="";
		try {
			Date db = new Date(0);
			SimpleDateFormat df= new SimpleDateFormat("dd_MM_yyyy_hhmmss");
			Value=df.format(db);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Value;
	}*/
	
	@Override
	public void getscreenshot(String foldername, String filename) 
	{
		try {
			String path= System.getProperty("user.dir");
			String finalpath=path+"\\Screenshot\\"+foldername+"\\"+filename+".jpeg";
			EventFiringWebDriver efw=new EventFiringWebDriver(driver);
			File src=efw.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(finalpath));
			
		} catch (Exception e) 
		{
			System.out.println("Issue in Get Screenshot "+e);
		}	
	}
	@AfterMethod
	public void ResultAnalysis(ITestResult result) //predefine (listener=interface)
	{
		String name=result.getMethod().getMethodName();
		if(result.isSuccess())
		{
			getscreenshot("passed", name);
		}
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			getscreenshot("failed", name);
		}
		
	}
	
}
