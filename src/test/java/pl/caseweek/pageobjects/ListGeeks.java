package pl.caseweek.pageobjects;

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

public class ListGeeks extends LoadableComponent<ListGeeks> {
	WebDriver driver;
	WebDriverWait wait;

	private static final String navigationXpath = "//header//nav[@class='main']";


	@FindBy(xpath = navigationXpath + "//a[text()='Browse Lists']")
	public WebElement browseListsLink;

	@FindBy(xpath = navigationXpath + "//a[text()='Home']")
	public WebElement homeLink;


	public ListGeeks goToBrowseLists() {
		browseListsLink.click();
		//wait can often serve as assertion
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.browse-lists")));
		return this;
	}

	public ListGeeks goToHomePage() {
		homeLink.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.page-home")));
		return this;
	}



	@Override
	protected void load() {
		driver.get(Urls.LIST_GEEKS);
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertEquals(driver.getTitle(), Titles.LIST_GEEKS);
	}

	public ListGeeks(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}








}
