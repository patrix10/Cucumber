package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CoursesPage extends BasePage {
	
	public CoursesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Courses']")
	WebElement lnk_courses;
	
	@FindBy(css = ".post-title")
	WebElement text_courses;
	
	@FindBy(css = "h2:nth-child(1) a:nth-child(1)")
	WebElement text_selenium_course;
	
	@FindBy(xpath = "//img[@alt='Udemy']")
	WebElement txt_Udemy;
	
	@FindBy(xpath = "//span[normalize-space()='Explore']")
	WebElement main_menu;
	
	@FindBy(xpath = "//div[text()='Development']")
	WebElement sub_menu;
	
	@FindBy(xpath = "//div[text()='Programming Languages']")
	WebElement program_menu;
	
	@FindBy(xpath = "//div[normalize-space()='Java']")
	WebElement java_menu;
	
	@FindBy(xpath = "//h1[normalize-space()='Java Courses']")
	WebElement java_text;
	
	public void click_courses_link() {
		lnk_courses.click();
	}
	
	public String Courses_Text() {
		waitForElementVisibility(text_courses);
		return text_courses.getText();
	}
	
	public void click_Seleniumcourses_link() {
		text_selenium_course.click();
	}
	
	public String child_window_url() {
		waitForElementVisibility(txt_Udemy);
		return driver.getCurrentUrl();
	}
	
	public String parent_window_url() {
		return driver.getCurrentUrl();
	}
	
	public void hovers_and_clicks_java() {
		waitForElementVisibility(txt_Udemy);
		Actions actions = new Actions(driver);
		actions.moveToElement(main_menu).perform();
		
		waitForElementVisibility(sub_menu);
		actions.moveToElement(sub_menu).perform();
		
		waitForElementVisibility(program_menu);
		actions.moveToElement(program_menu).perform();
		
		waitForElementVisibility(java_menu);
		actions.moveToElement(java_menu).click().build().perform();
	}
	
	public String java_text() {
		waitForElementVisibility(java_text);
		return java_text.getText();
	}
}
