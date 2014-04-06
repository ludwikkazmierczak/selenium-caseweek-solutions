package pl.caseweek.pageobjects.searchengines;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import pl.caseweek.pageobjects.SearchEngine;

public class Goo extends LoadableComponent<Goo> implements SearchEngine{

	private WebDriver driver;

	@FindBy(id = "searchtop")
	private WebElement searchBox;

	@FindBy(css = "input[name='bt_search']")
	private WebElement searchButton;

	@FindBy(css = "div.result > p.title > a")
	private List<WebElement> searchHeadings;


	public Goo search(String query) {
		searchBox.sendKeys(query);
		searchButton.click();
		return this;
	}

	public List<String> getSearchHeadings() {
		List<String> headingsList = new ArrayList<String>();
		for (WebElement heading : searchHeadings) {
			headingsList.add(heading.getText());
		}
		return headingsList;

	}

	@Override
	protected void load() {
		driver.get("http://goo.ne.jp");
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertEquals(driver.getTitle(), "goo");
	}

	public Goo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
