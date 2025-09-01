package stepDefinitions;

import org.testng.Assert;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObjects.CoursesPage;
import utils.TestContext;

public class CoursesSteps {
	WebDriver driver;
	TestContext context;
	CoursesPage coursesPage;
	
	public CoursesSteps(TestContext context) {
		this.context = context;
		this.driver = context.getDriver();
		this.coursesPage = new CoursesPage(driver);
	}
	
	@When("user clicks on Courses Link")
	public void user_clicks_on_courses_link() {
		coursesPage.click_courses_link();
	}

	@Then("Courses Page must display")
	public void courses_page_must_display() {
		Assert.assertTrue(coursesPage.Courses_Text().contains("Courses"));
	}

	@When("user clicks on Selenium Course Link")
	public void user_clicks_on_selenium_course_link() {
		coursesPage.click_Seleniumcourses_link();
		context.genericUtils.SwitchWindowToChild();
	}

	@Then("child window must open")
	public void child_window_must_open() {
		Assert.assertTrue(coursesPage.child_window_url().contains("selenium"));
	}

	@When("user get back to parent window")
	public void user_get_back_to_parent_window() {
		context.genericUtils.SwitchWindowToParent();
	}

	@Then("verify user is on parent window")
	public void verify_user_is_on_parent_window() {
		Assert.assertTrue(coursesPage.parent_window_url().toLowerCase().contains("courses"));
	}

	@When("user hovers and clicks on java")
	public void user_hovers_and_clicks_on_java() {
		coursesPage.hovers_and_clicks_java();
	}

	@Then("java page must get open")
	public void java_page_must_get_open() {
		Assert.assertEquals(coursesPage.java_text(),"Java Courses");
	}
}