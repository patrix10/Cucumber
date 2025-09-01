package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LogoutPage;
import utils.TestContext;

public class LogoutSteps {
	WebDriver driver;
	TestContext context;
	LogoutPage logoutPage;
	
	public LogoutSteps(TestContext context) {
		this.context = context;
		this.driver = context.getDriver();
		this.logoutPage = new LogoutPage(driver);
 	}
	
	@Then("user logged in successfully to home page")
    public void user_logged_in_successfully_to_home_page() {
    	logoutPage.logout_displayed();
    	Assert.assertTrue(logoutPage.getTitle().contains("Logged In Successfully"));
    	Assert.assertTrue(logoutPage.getUrl().contains("practicetestautomation.com/logged-in-successfully/"));
    	Assert.assertTrue(logoutPage.LoggedIn_Displayed().isDisplayed());
    };
}
