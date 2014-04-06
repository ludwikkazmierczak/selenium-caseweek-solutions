package pl.caseweek.testcases.listgeeks;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.caseweek.pageobjects.listgeeks.HomePage;
import pl.caseweek.pageobjects.listgeeks.ListGeeksElement;
import pl.caseweek.pageobjects.listgeeks.SingleListPage;
import pl.caseweek.templates.TestTemplate;

/**
 * Created by Ludwik on 05.04.14.
 */
public class ChangeOrder extends TestTemplate{

	private SingleListPage singleListPage;

	private HomePage homePage;

	@BeforeMethod
	public void init(){
		homePage = new HomePage(driver);
	}

	@Test
	public void changeOrder() {

		singleListPage = homePage.get().mainMenu.goToLatestListsPage().openList(1);

		ListGeeksElement firstElement = singleListPage.getListItem(0);
		ListGeeksElement secondElement = singleListPage.getListItem(1);


		firstElement.typeTitle("First");

		Assert.assertTrue(firstElement.getTitle().equals("First"));
		Assert.assertTrue(firstElement.isLinkVisible());

		secondElement.typeTitle("Second");

		Assert.assertTrue(secondElement.getTitle().equals("Second"));
		Assert.assertTrue(secondElement.isLinkVisible());

		singleListPage.changeOrder(firstElement.getDragablePart(), secondElement.getElementToDropOn());

		Assert.assertTrue(firstElement.getTitle().equals("Second"));
		Assert.assertTrue(firstElement.isLinkVisible());

		Assert.assertTrue(secondElement.getTitle().equals("First"));
		Assert.assertTrue(secondElement.isLinkVisible());
	}
}
