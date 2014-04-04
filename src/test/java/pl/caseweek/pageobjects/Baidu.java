package pl.caseweek.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import pl.caseweek.data.Titles;

import java.util.ArrayList;
import java.util.List;

public class Baidu extends LoadableComponent<Baidu> {
	WebDriver driver;


	@FindBy(xpath="//input[@id='kw1']")
	private WebElement searchBox;

	@FindBy(xpath="//input[@id='su1']")
	private WebElement searchButton;

	@FindBy(xpath="//div[contains(@class, 'result')]/h3/a")
	private List<WebElement> searchHeadings;



	public void search(String searchTerm) {
		searchBox.sendKeys(searchTerm);
		searchButton.click();
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
		driver.get("http://baidu.com");
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertEquals(driver.getTitle(), Titles.BAIDU);
	}

	public Baidu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
