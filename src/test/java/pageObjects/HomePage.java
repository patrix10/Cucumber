package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Home']")
	WebElement Home_Link;
	
	@FindBy(css = ".post-title")
	WebElement Hello_msg;
	
	@FindBy(css = ".mailpoet_captcha")
	WebElement captcha;
	
	@FindBy(css = "img[alt='Dmitry Shyshkin, your Selenium WebDriver instructor']")
	WebElement img;
	
	@FindBy(xpath = "//strong[normalize-space()='Welcome to Practice Test Automation!']")
	WebElement Welcome_msg;
	
	@FindBy(xpath = "//strong[normalize-space()='Experience and Expertise']")
	WebElement Exp_Header;
	
	@FindBy(xpath = "//strong[normalize-space()='Courses and Achievements']")
	WebElement Courses_Desc;
	
	@FindBy(xpath = "//a[normalize-space()='BLOG']")
	WebElement Blog_LinkTxt;
	
	@FindBy(xpath = "//a[normalize-space()='Return to Blog']")
	WebElement return_btn;
	
	@FindBy(tagName = "footer")
    WebElement Footer;
	
	@FindBy(id = "form_first_name_7")
    WebElement field_name;
	
	@FindBy(id = "form_email_7")
    WebElement field_email;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btn_GetXPath;
	
	public void click_on_home_link() {
		Home_Link.click();
	}
	
	public String message_is_displayed() {
		waitForElementVisibility(Hello_msg);
		return Hello_msg.getText();
	}
	
	public WebElement image() {
		return img;
	}
	
	public String Welcome_Text() {
		waitForElementVisibility(Welcome_msg);
		return Welcome_msg.getText();
	}
	
	public String Experience_Header() {
		return Exp_Header.getText();
	}
	
	public WebElement Courses_Description() {
		return Courses_Desc;
	}
	
	public WebElement Blog_Link_Text() {
		return Blog_LinkTxt;
	}
	
	public WebElement Footer_Tag() {
		return Footer;
	}
	
	public void enter_name(String name) {
		field_name.sendKeys(name);
	}
	
	public void enter_email(String email) {
		field_email.sendKeys(email);
	}
	
	public void click_on_xpath() {
		waitForElementToBeClickable(btn_GetXPath);
		btn_GetXPath.click();
	}
	
	public WebElement verify_captcha() {
		waitForElementVisibility(captcha);
		return captcha;
	}
	
	public void return_to_home() {
		return_btn.click();
	}
}
