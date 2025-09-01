package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.ContactPage;
import utils.TestContext;

public class ContactSteps {
	WebDriver driver;
	TestContext context;
	ContactPage contactPage;
	
	public ContactSteps(TestContext context) {
		this.context = context;
		this.driver = context.getDriver();
		this.contactPage = new ContactPage(driver);
	}
	
	@When("user clicks on Contact Link")
    public void userClicksOnContactLink() {
		contactPage.click_Course_link();
    }

    @Then("Contact page must get open")
    public void contactPageMustGetOpen() {
    	Assert.assertTrue(contactPage.get_Course_url().toLowerCase().contains("contact"));
    }

    @When("user enters the following details")
    public void userEntersTheFollowingDetails(List<String> details) {
    	contactPage.enter_fname(details.get(0));
    	contactPage.enter_lname(details.get(1));
    	contactPage.enter_email(details.get(2));
    	contactPage.enter_message(details.get(3));
    }

    @And("user clicks the captcha box")
    public void userClicksTheCaptchaBox() throws InterruptedException {
    	contactPage.click_captcha_tick();
    }

    @When("user clicks the submit button")
    public void userClicksTheSubmitButton() {
    	contactPage.click_submit();
    }

    @Then("Thanks message must appear")
    public void thanksMessageMustAppear() {
    	Assert.assertTrue(contactPage.Thanks_msg().isDisplayed());
    }
}