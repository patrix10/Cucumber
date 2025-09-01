package pageObjects;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage extends BasePage {
	
	public PracticePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Practice']")
	WebElement practice_Link;
	
	@FindBy(xpath = "//a[normalize-space()='Test Exceptions']")
	WebElement Exception_Link;
	
	@FindBy(id = "edit_btn")
	WebElement btn_edit;
	
	@FindBy(id = "remove_btn")
	WebElement btn_remove;
	
	@FindBy(id = "add_btn")
	WebElement btn_add;
	
	@FindBy(id = "confirmation")
	WebElement toaster_confirm;
	
	@FindBy(id = "instructions")
	WebElement instructions;
	
	@FindBy(xpath = "//div[@id='row2']//input[@type='text']")
	WebElement field_input;
	
	@FindBy(xpath = "//input[@value='Pizza']")
	WebElement field_pizza;
	
	@FindBy(name = "Save")
    WebElement btn_save;
	
	public void click_practiceLink() {
		practice_Link.click();
	}
	
	public void click_exceptionLink() {
		Exception_Link.click();
	}
	
	public String get_exception_url() {
		waitForElementVisibility(btn_edit);
		return driver.getCurrentUrl();
	}
	
	public void click_addBtn() {
		btn_add.click();
	}
	
	public boolean input_field_displayed() {
		try {
			return field_input.isDisplayed();
		} catch(NoSuchElementException e) {
			System.out.println("Caught NoSuchElementException" + e.getMessage());
			return false;
		}
	}
	
	public void type_Text() {
		waitForElementToBeClickable(field_input);
		field_input.sendKeys("Shawarma");;
	}
	
	public boolean click_save() {
		try {
			btn_save.click();
			waitForElementVisibility(toaster_confirm);
			return toaster_confirm.isDisplayed();
		} catch(ElementNotInteractableException e) {
			System.out.println("Caught ElementNotInteractableException" + e.getRawMessage());
			return false;
		}
	}
	
	public void clear_input() {
		try {
			field_pizza.clear();
		} catch(InvalidElementStateException e) {
			System.out.println("Caught InvalidElementStateException" + e.getRawMessage());
		}
	}
	
    public void type_Text_without_Add() {
    	try {
    		field_pizza.sendKeys("Burger");
		} catch(ElementNotInteractableException e) {
			System.out.println("Caught ElementNotInteractableException" + e.getMessage());
		}
	}
    
    public boolean instruction_Text() {
        try {
            return instructions.isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            System.out.println("Caught Exception while checking instruction text: " + e.getMessage());
            return false;
        }
    }
    
    public boolean wait_for_element_to_appear() {
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement ele = wait.until(ExpectedConditions.visibilityOf(field_input));
            return ele.isDisplayed();
		} catch(TimeoutException e) {
			System.out.println("Caught TimeoutException" + e.getMessage());
			return false;
		}
    }
    
    public void enter_Text(String text) {
    	waitForElementToBeClickable(field_input);
    	field_input.sendKeys(text);
    }
    
    public void remove() {
    	btn_remove.click();
    }

    public WebElement Text_removed() {
    	waitForElementVisibility(toaster_confirm);
		return toaster_confirm;
    }
}