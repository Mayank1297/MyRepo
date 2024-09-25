package applicationutility;

import org.openqa.selenium.WebElement;

public interface Applicationutility 
{
	public void doubleclick(WebElement ele);
	public void rightclick(WebElement ele);
	public void fileupload(String loc);
	public void selectbyvalue(String value, WebElement ele);
	public void selectone(String value, WebElement ele);
	public void selectoldmenu(String value, WebElement ele);
	public void selectmultiple(String value, WebElement ele);

}
