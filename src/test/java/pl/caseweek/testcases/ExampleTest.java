package pl.caseweek.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pl.caseweek.templates.TestTemplate;

public class ExampleTest extends TestTemplate {

	@Test
	public void openCognifidePage() {
		driver.get("http://cognifide.com");
		Assert.assertEquals(driver.getTitle(), "Cognifide");
	}

}
