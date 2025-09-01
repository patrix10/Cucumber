package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import utils.TestContext;

public class HomeSteps {
	WebDriver driver;
	TestContext context;
	HomePage homePage;
	
	public HomeSteps(TestContext context) {
		this.context = context;
		this.driver = context.getDriver();
	    this.homePage = new HomePage(driver);
	}
	
	@When("user clicks on Home Link")
	public void user_clicks_on_home_link() {
		homePage.click_on_home_link();
	}
	
	@Then("{string} message is displayed")
	public void hello_message_is_displayed(String Message) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(homePage.message_is_displayed().contains(Message));
		softAssert.assertAll();
	}

	@And("Image is also displayed")
	public void image_is_also_displayed() {
		Assert.assertTrue(homePage.image().isDisplayed());
	}

	@Then("verify welcome message")
	public void verify_welcome_message() {
		Assert.assertEquals(homePage.Welcome_Text(),"Welcome to Practice Test Automation!");
	}

	@And("verify that Experience Discription is available")
	public void verify_experience_discription_is_available() {
		Assert.assertTrue(homePage.Experience_Header().contains("Expertise"));
	}

	@Then("verify Courses and Achievements Discriptions are available")
	public void verify_courses_and_achievements_discriptions_are_available() {
		Assert.assertTrue(homePage.Courses_Description().isDisplayed());
	}

	@And("verify Blog and Courses Link tag are present")
	public void verify_blog_and_courses_link_tag_are_present() {
		Assert.assertTrue(homePage.Blog_Link_Text().isDisplayed());
	}

	@Then("Check if footer section is present or not")
	public void check_if_footer_section_is_present_or_not() {
		Assert.assertTrue(homePage.Footer_Tag().isDisplayed());
	}

	@When("Enter {string} and {string}")
	public void enter_name_and_email(String name, String email) {
		homePage.enter_name(name);
		homePage.enter_email(email);
	}

	@When("Click on Get xpath button")
	public void click_on_get_xpath_button() {
		homePage.click_on_xpath();
	}

	@Then("Verify You are on Confirmation Page")
	public void verify_you_are_on_confirmation_page() {
		Assert.assertTrue(homePage.verify_captcha().isDisplayed());
	}

	@When("Get back to Home Page")
	public void get_back_to_home_page() {
		homePage.return_to_home();
	}

	@Then("Verify You are on Home Page")
	public void verify_you_are_on_home_page() {
		Assert.assertEquals(homePage.Welcome_Text(),"Welcome to Practice Test Automation!");
	}
}