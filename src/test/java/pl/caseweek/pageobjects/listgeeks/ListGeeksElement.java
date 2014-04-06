package pl.caseweek.pageobjects.listgeeks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.caseweek.pageobjects.ListElement;

import java.util.List;

public class ListGeeksElement implements ListElement{
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

	public ListGeeksElement remove() {
		removeButton.click();
		return this;
	}

	public ListGeeksElement toggleLinks() {
		toggleButton.click();
		return this;
	}

	public ListGeeksElement typeTitle(String title) {
		titleField.sendKeys(title);
		return this;
	}

	public ListGeeksElement typeLink(String url) {
		urlField.sendKeys(url);
		return this;
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

	public WebElement getDragablePart(){
		return dragablePart;
	}

	public WebElement getElementToDropOn(){
		return urlField;
	}

	private List<WebElement> getAutocompleteItems() {
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

	public ListGeeksElement(WebDriver driver, WebElement element) {
		this.item = element;
		this.driver = driver;
		PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
	}
}
