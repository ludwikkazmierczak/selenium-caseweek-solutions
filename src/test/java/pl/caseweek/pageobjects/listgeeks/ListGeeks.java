package pl.caseweek.pageobjects.listgeeks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

	@FindBy(css = "span.position")
	private WebElement dragablePart;

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
		return titleField.getAttribute("value");
	}

	public String getUrl() {
		return urlField.getAttribute("value");
	}

	public boolean isLinkVisible(){
		return urlField.isDisplayed();
	}

	public WebElement getDraggablePart(){
		return dragablePart;
	}

	public WebElement getDropArea(){
		return urlField;
	}
	public List<WebElement> getAutocompleteItems() {
		String autoCmpltCss =  "ul.ui-autocomplete[style*='display: block'] li.ui-menu-item a";

		//wait below is actually useless since we are already using implicit waits (defined in TestTemplate)
		//it just demonstrates one of the possible techinques
		List<WebElement> autocompleteItems =
				new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(autoCmpltCss)));

		return autocompleteItems;
	}

	public boolean autocompleteContains(String expectedToSeeInAutocomplete) {
		List<WebElement> autocompleteItems = getAutocompleteItems();
		for (WebElement autoCmpltItem : autocompleteItems) {
			if (expectedToSeeInAutocomplete.equals(autoCmpltItem.getText())) {
				return true;
			}
		}
		return false;
	}

	public ListGeeks(WebDriver driver, WebElement element) {
		this.item = element;
		this.driver = driver;
		PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
	}
}
