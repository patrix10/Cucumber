package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import utils.TestContext;

public class HomeSteps {
	WebDriver driver;
	TestContext context;
	HomePage homePage;
	
	public HomeSteps(TestContext context) {
		this.context = context;
		this.homePage = context.pageObjectManager.getHomePage();
 	}
	
	@Then("user logged in successfully to home page")
    public void user_logged_in_successfully_to_home_page() {
    	homePage.logout_displayed();
    	Assert.assertTrue(homePage.getTitle().contains("Logged In Successfully"));
    	Assert.assertTrue(homePage.getUrl().contains("practicetestautomation.com/logged-in-successfully/"));
    	Assert.assertTrue(homePage.LoggedIn_Displayed().isDisplayed());
    };
}
