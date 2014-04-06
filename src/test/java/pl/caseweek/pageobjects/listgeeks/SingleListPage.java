package pl.caseweek.pageobjects.listgeeks;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleListPage {
	private WebDriver driver;

	public Navigation mainMenu;

	@FindBy(css = ".ui-sortable > li")
	public List<WebElement> listItems;

	public static final String itemXpathPattern = "//li[div[@class='pos']/input[@value='%s']]";

	public ListGeeksElement getListItem(int itemIndex) {
		return new ListGeeksElement(driver, listItems.get(itemIndex));
	}

	public void changeOrder(WebElement first, WebElement second){
		Actions action = new Actions(driver);
		action.clickAndHold(first).moveToElement(second).moveByOffset(0, 5).release().build().perform();
	}


	public SingleListPage(WebDriver driver) {
		this.driver = driver;
		mainMenu = new Navigation(driver);
		PageFactory.initElements(driver, this);
	}

}
