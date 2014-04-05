package pl.caseweek.pageobjects.listgeeks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pl.caseweek.data.Titles;
import pl.caseweek.data.Urls;

public class HomePage extends LoadableComponent<HomePage> implements pl.caseweek.pageobjects.HomePage {
	WebDriver driver;
	WebDriverWait wait;

	public Navigation mainMenu;

	@Override
	protected void load() {
		driver.get(Urls.LIST_GEEKS);
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertEquals(driver.getTitle(), Titles.LIST_GEEKS);
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		this.mainMenu = new Navigation(driver);
		PageFactory.initElements(driver, this);
	}
}