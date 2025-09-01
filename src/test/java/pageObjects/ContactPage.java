package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {
	
	public ContactPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='wpforms-161-field_0']")
	WebElement Firstname_field;
	
	@FindBy(xpath = "(//input[@id='wpforms-161-field_0-last'])[1]")
	WebElement Secondname_field;
	
	@FindBy(xpath = "//input[@id='wpforms-161-field_1']")
	WebElement email_field;
	
	@FindBy(xpath = "//textarea[@id='wpforms-161-field_2']")
	WebElement msg_field;
	
	@FindBy(xpath = "//a[normalize-space()='Contact']")
	WebElement lnk_contact;
	
	@FindBy(css = ".recaptcha-checkbox-border")
	WebElement captcha_sqr;
	
	@FindBy(id = "wpforms-submit-161")
	WebElement btn_submit;
	
	@FindBy(css = "div[id='wpforms-confirmation-161'] p")
	WebElement thanks_msg;
	
	public void click_Course_link() {
		lnk_contact.click();
	}
	
	public String get_Course_url() {
		return driver.getCurrentUrl();
	}
	
	public void enter_fname(String fname) {
		Firstname_field.sendKeys(fname);
	}
	
    public void enter_lname(String lname) {
    	Secondname_field.sendKeys(lname);
	}
    
    public void enter_email(String email) {
    	email_field.sendKeys(email);
	}
    
    public void enter_message(String message) {
    	msg_field.sendKeys(message);
	}
    
    public void click_captcha_tick() throws InterruptedException {
    	Thread.sleep(15000);
//    	driver.switchTo().frame(captcha_sqr);
//    	captcha_sqr.click();
//    	driver.switchTo().defaultContent();
    }
    
    public void click_submit() {
    	btn_submit.click();
    }
    
    public WebElement Thanks_msg() {
    	waitForElementVisibility(thanks_msg);
    	return thanks_msg;
    }
}