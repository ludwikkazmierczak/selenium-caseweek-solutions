package pl.caseweek.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LGSingleListPage {
	private WebDriver driver;

	public static final String itemXpathPattern = "//li[div[@class='pos']/input[@value='%s']]";

	public LGListElement getListItem(int itemIndex) {
		String xpath = String.format(itemXpathPattern, itemIndex);
		WebElement listItem = driver.findElement(By.xpath(xpath));
		return new LGListElement(driver, listItem);
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
		boolean passed = false;
		for (WebElement autoCmpltItem : autocompleteItems) {
			if (expectedToSeeInAutocomplete.equals(autoCmpltItem.getText())) {
				passed = true;
				break;
			}
		}
		return passed;
	}


	public LGSingleListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
