package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public static final int EXPLICIT_WAIT = 10;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		PageFactory.initElements(driver, this);
		//if we give here and extend then no need to give in other class
	}
	
	//when certain pages have there own url
//	public void show() throws NoSuchFieldException, IllegalAccessException {
//        String pageUrl = (String) this.get_page_url();
//        String url     = this.baseUrl + pageUrl;
//        this.driver.navigate().to(url);
//    }
	
//	private Object get_page_url() throws NoSuchFieldException, IllegalAccessException {
//	    Field field = this.getClass().getDeclaredField("URL");
//	    field.setAccessible(true);
//	    return field.get(this);
//	}
	
	public void maximize() {
	    this.driver.manage().window().maximize();
	}
	
	public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	
	public WebElement waitForElementVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
	
	public void fillInputField(WebElement element, String value) {
        element = waitForElementVisibility(element);
        element.clear();
        element.sendKeys(value);
    }

    public void clearAndSendKeys(WebElement element, String value) {
        element = waitForElementVisibility(element);
        element.clear();
        element.sendKeys(value);
    }

    public String grabTextFromElement(WebElement element) {
        element = waitForElementVisibility(element);
        return element.getText();
    }
    
    //extend base page or use genericutils
}
