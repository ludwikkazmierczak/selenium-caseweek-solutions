package pl.caseweek.pageobjects.listgeeks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleListPage {
	private WebDriver driver;

	public Navigation mainMenu;

	@FindBy(css = ".ui-sortable > li")
	private List<WebElement> listItems;

	public static final String itemXpathPattern = "//li[div[@class='pos']/input[@value='%s']]";

	public ListGeeks getListItem(int itemIndex) {
		return new ListGeeks(driver, listItems.get(itemIndex));
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

	public SingleListPage(WebDriver driver) {
		this.driver = driver;
		mainMenu = new Navigation(driver);
		PageFactory.initElements(driver, this);
	}

}
