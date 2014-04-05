package pl.caseweek.pageobjects.listgeeks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ListGeeks {
	private WebDriver driver;
	private WebElement item;

	@FindBy(css = "h3 > input")
	private WebElement titleField;

	@FindBy(css = "div.links > h3 > input")
	private WebElement firstEmptyItem;

	@FindBy(css = "div.links > input")
	private WebElement urlField;

	@FindBy(css = "a.delete")
	private WebElement removeButton;

	@FindBy(css = "a.toggle-details")
	private WebElement toggleButton;

	public void remove() {
		removeButton.click();
	}

	public void toggleLinks() {
		toggleButton.click();
	}

	public void typeTitle(String title) {
		titleField.sendKeys(title);
	}

	public void typeLink(String url) {
		urlField.sendKeys(url);
	}

	public String getTitle() {
		return titleField.getText();
	}

	public String getUrl() {
		return urlField.getText();
	}


	public ListGeeks(WebDriver driver, WebElement element) {
		this.item = element;
		this.driver = driver;
		PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
	}
}
