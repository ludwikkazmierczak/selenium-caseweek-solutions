package pl.caseweek.testcases.listgeeks;

import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.caseweek.pageobjects.listgeeks.HomePage;
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

		singleListPage.getListItem(0).typeTitle("First");

		Assert.assertTrue(singleListPage.getListItem(0).getTitle().equals("First"));
		Assert.assertTrue(singleListPage.getListItem(0).isLinkVisible());

		singleListPage.getListItem(1).typeTitle("Second");

		Assert.assertTrue(singleListPage.getListItem(1).getTitle().equals("Second"));
		Assert.assertTrue(singleListPage.getListItem(1).isLinkVisible());

		singleListPage.changeOrder(singleListPage.getListItem(0).getDraggablePart(), singleListPage.getListItem(1).getDropArea());

		Assert.assertTrue(singleListPage.getListItem(0).getTitle().equals("Second"));
		Assert.assertTrue(singleListPage.getListItem(0).isLinkVisible());

		Assert.assertTrue(singleListPage.getListItem(1).getTitle().equals("First"));
		Assert.assertTrue(singleListPage.getListItem(1).isLinkVisible());
	}
}
