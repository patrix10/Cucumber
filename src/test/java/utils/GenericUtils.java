package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
    //genericutils are used for
	//-switch to child window
	//-waits
	//-parse strings, etc
	public void SwitchWindowToChild()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1 =s1.iterator();
//		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}
	//we can use inside any stepdefinitions as
	//context.genericutils.switchwindowtochild()
}
