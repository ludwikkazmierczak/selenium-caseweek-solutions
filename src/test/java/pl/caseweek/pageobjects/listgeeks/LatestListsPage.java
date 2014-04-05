package pl.caseweek.pageobjects.listgeeks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Ludwik on 05.04.14.
 */
public class LatestListsPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public Navigation mainMenu;

	@FindBy(css = "article.lst h1 > a")
	private List<WebElement> lists;

	public SingleListPage openList(int index) {
		lists.get(index).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.page-lst")));
		return new SingleListPage(driver);
	}

	public LatestListsPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		this.mainMenu = new Navigation(driver);
		PageFactory.initElements(driver, this);
	}
}
