package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.PracticePage;
import utils.TestContext;

public class PracticeSteps {
	WebDriver driver;
	TestContext context;
	PracticePage practicePage;
	
	public PracticeSteps(TestContext context) {
		this.context = context;
		this.driver = context.getDriver();
		this.practicePage = new PracticePage(driver);
	}
	
	@When("user clicks on Practice Link")
	public void userClicksOnPracticeLink() {
		practicePage.click_practiceLink();
	}

	@And("click on Test Exceptions Link")
	public void clickOnTestExceptionsLink() {
		practicePage.click_exceptionLink();
	}

	@Then("verify you are on Exceptions Page")
	public void verifyYouAreOnExceptionsPage() {
		String url = practicePage.get_exception_url();
		Assert.assertTrue(url.contains("exception"));
	}

	@When("click on Add button")
	public void clickOnAddButton() {
		practicePage.click_addBtn();
	}

	@Then("See that new Row input field is displayed")
	public void seeThatNewRowInputFieldIsDisplayed() {
		practicePage.input_field_displayed();
	}

	@And("Type text into the second input field")
	public void typeTextIntoTheSecondInputField() {
		practicePage.type_Text();
	}

	@When("Push Save button")
	public void pushSaveButton() {
		practicePage.click_save();
	}

	@When("Clear input field")
	public void clearInputField() {
		practicePage.clear_input();
	}

	@And("Type text into the input field")
	public void typeTextIntoTheInputField() {
		practicePage.type_Text_without_Add();
	}

	@When("Find the instructions text element")
	public void findTheInstructionsTextElement() {
		practicePage.instruction_Text();
	}

	@Then("Verify instruction text element is no longer displayed")
	public void verifyInstructionTextElementIsNoLongerDisplayed() {
		boolean isDisplayed = practicePage.instruction_Text();
		Assert.assertFalse(isDisplayed);
	}

	@And("Wait for 3 seconds for the second input field to be displayed")
	public void waitFor3SecondsForTheSecondInputFieldToBeDisplayed() {
		practicePage.wait_for_element_to_appear();
	}

	@And("Enter {string} in input field with different locator")
	public void enterTextInInputFieldWithDifferentLocator(String text) {
		practicePage.enter_Text(text);
	}

	@And("push remove button")
	public void pushRemoveButton() {
		practicePage.remove();
	}

	@Then("Verify text removed")
	public void verifyTextRemoved() {
		assertTrue(practicePage.Text_removed().isDisplayed());
	}
}