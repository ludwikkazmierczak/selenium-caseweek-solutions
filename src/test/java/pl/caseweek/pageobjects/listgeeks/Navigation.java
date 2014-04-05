package pl.caseweek.pageobjects.listgeeks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ludwik on 05.04.14.
 */
public class Navigation implements pl.caseweek.pageobjects.Navigation{
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(css = "li.lists.ui-enhanced  > a")
	private WebElement browseListsPageLink;

	@FindBy(css = "li.home > a")
	private WebElement homePageLink;

	public LatestListsPage goToLatestListsPage() {
		browseListsPageLink.click();
		//wait can often serve as assertion
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.browse-lists")));
		return new LatestListsPage(driver);
	}

	public HomePage goToHomePage() {
		homePageLink.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.page-home")));
		return new HomePage(driver);
	}

	public Navigation(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
}
