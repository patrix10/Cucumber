package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		//this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement field_username;
	
	@FindBy(css = "#password")
	WebElement field_password;
	
	@FindBy(xpath = "//button[@id='submit']")
	WebElement btn;
	
	@FindBy(css = "#error")
	WebElement error_username;
	
	@FindBy(css = ".show")
	WebElement error_password;
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void enter_username(String username) {
		field_username.sendKeys(username);
	}
	
	public void enter_password(String password) {
		field_password.sendKeys(password);
	}
	
	public void click_login() {
		btn.click();
	}
	
	public String error_user() {
		waitForElementVisibility(error_username);
		return error_username.getText();
	}
	
	public Boolean VerifyPassError()
	{
		waitForElementVisibility(error_password);
		return error_password.isDisplayed();
	}
}
