package pl.caseweek.templates;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestTemplate {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.getDriver("FF");
		Assert.assertNotNull(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}


}
