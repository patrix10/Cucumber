package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import utils.TestContext;

public class LoginSteps {
	WebDriver driver;
	TestContext context;
	LoginPage loginPage;
	
	public LoginSteps(TestContext context) {
		this.context = context;
		this.loginPage = context.pageObjectManager.getLoginPage();
 	}

    @Given("user is on login page")
    public void user_is_on_login_page() {
    	Assert.assertTrue(loginPage.getTitle().contains("Test Login"));
    };

    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enter_username(username);
        loginPage.enter_password(password);
    };
    
    @When("user gives {string} and {string} for login")
    public void user_gives_credentials_for_login(String username, String password) {
    	loginPage.enter_username(username);
        loginPage.enter_password(password);
    }


    @And("clicks login button")
    public void clicks_login_button() {
    	loginPage.click_login();
    };
    
    @Then("error message is displayed for invalid username")
    public void error_message_for_invalid_username() {
    	Assert.assertEquals(loginPage.error_user(),"Your username is invalid!");
    }
    
    @Then("error message is displayed for invalid password")
    public void error_message_for_invalid_password() {
    	Assert.assertTrue(loginPage.VerifyPassError());
    }
}
