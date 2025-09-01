package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement txt_logout;
	
	@FindBy(css = "p[class='has-text-align-center'] strong")
	WebElement txt_loggedIn;
	
	public void logout_displayed() {
		//driver.findElement(txt_logout).isDisplayed();
		txt_logout.isDisplayed();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public WebElement LoggedIn_Displayed() {
		return txt_loggedIn;
	}
}
