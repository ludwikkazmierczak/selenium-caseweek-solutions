package pl.caseweek.testcases.listgeeks;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.caseweek.pageobjects.listgeeks.HomePage;
import pl.caseweek.pageobjects.listgeeks.ListGeeksElement;
import pl.caseweek.pageobjects.listgeeks.SingleListPage;
import pl.caseweek.templates.TestTemplate;

public class AddItems  extends TestTemplate {

	private SingleListPage singleListPage;

	private HomePage homePage;

	@BeforeMethod
	public void init(){
		homePage = new HomePage(driver);
	}

	@Test
	public void addList() {
		singleListPage = homePage.get().mainMenu.goToLatestListsPage().openList(1);

		ListGeeksElement firstElement = singleListPage.getListItem(0);
		ListGeeksElement secondElement = singleListPage.getListItem(1);


		firstElement.typeTitle("First");
		secondElement.typeTitle("Second");

		Assert.assertTrue(firstElement.getTitle().equals("First"));
		Assert.assertTrue(secondElement.getTitle().equals("Second"));

		firstElement.typeTitle("Edited");

		Assert.assertTrue(firstElement.getTitle().equals("FirstEdited"));

		secondElement.remove();

		Assert.assertTrue(secondElement.getTitle().isEmpty());
	}
}
