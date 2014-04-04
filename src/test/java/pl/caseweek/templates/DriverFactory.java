package pl.caseweek.templates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static WebDriver getDriver(String browser) {

		if ("FF".equals(browser)) {
			return new FirefoxDriver();
		}
		else if ("IE".equals(browser)) {
			System.setProperty("webdriver.ie.driver", "??");
			return new InternetExplorerDriver();
		}
		else if ("Chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", "??");
			return new ChromeDriver();
		}
		throw new RuntimeException("Specified browser is not supported. Please use one of the following: FF, IE, Chrome.");
	}

}
