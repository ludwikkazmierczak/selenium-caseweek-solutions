package pl.caseweek.testcases.listgeeks;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.caseweek.pageobjects.listgeeks.HomePage;
import pl.caseweek.pageobjects.listgeeks.SingleListPage;
import pl.caseweek.templates.TestTemplate;

public class ListGeeksBasic extends TestTemplate{

	private SingleListPage singleListPage;

	private HomePage homePage;

	@BeforeMethod
	public void init(){
		homePage = new HomePage(driver);
	}

	@Test
	public void testNavigation() {
		homePage
				.get() //
				.mainMenu //
				.goToLatestListsPage() //
				.mainMenu //
				.goToHomePage();


	}

	@Test
	public void openList() {
		homePage
				.get() //
				.mainMenu //
				.goToLatestListsPage() //
				.openList(1);
	}
}