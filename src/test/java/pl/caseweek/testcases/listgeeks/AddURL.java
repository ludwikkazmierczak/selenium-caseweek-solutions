package pl.caseweek.testcases.listgeeks;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.caseweek.pageobjects.listgeeks.HomePage;
import pl.caseweek.pageobjects.listgeeks.ListGeeksElement;
import pl.caseweek.pageobjects.listgeeks.SingleListPage;
import pl.caseweek.templates.TestTemplate;

public class AddURL extends TestTemplate{

	private SingleListPage singleListPage;

	private HomePage homePage;

	@BeforeMethod
	public void init(){
		homePage = new HomePage(driver);
	}

	@Test
	public void addURL() {

		singleListPage = homePage.get().mainMenu.goToLatestListsPage().openList(1);

		ListGeeksElement firstElement = singleListPage.getListItem(0);
		ListGeeksElement secondElement = singleListPage.getListItem(1);

		firstElement.typeTitle("First").typeLink("FirstLink");
		secondElement.typeLink("Second").typeLink("Second link");


		Assert.assertTrue(firstElement.getUrl().equals("FirstLink"));
		Assert.assertTrue(firstElement.isLinkVisible());

		Assert.assertTrue(secondElement.getUrl().equals("SecondLink"));
		Assert.assertTrue(secondElement.isLinkVisible());

		firstElement.typeLink("Edited");

		Assert.assertTrue(firstElement.getUrl().equals("FirstLinkEdited"));

		secondElement.toggleLinks();

		Assert.assertFalse(secondElement.isLinkVisible());
	}
}
