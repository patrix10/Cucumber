package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;


public class TestContext {
	private WebDriver driver;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContext() throws IOException {
		testBase = new TestBase();
		driver = testBase.WebDriverManager();
		genericUtils = new GenericUtils(driver);
	}
	
	public WebDriver getDriver() {
        return driver;
    }
}
