package pl.caseweek.pageobjects;

/**
 * This interface connected with navigation functionality, prepared for CaseWeek 2014 Selenium workshop
 * Created by Ludwik and Yaci
 */
public interface Navigation {

	/**
	 * Navigate to 'home' page
	 * @return HomePage
	 */
	public <H extends HomePage> H goToHomePage();

	/**
	 * Navigate to 'latest lists' page
	 * @return LatestListsPage
	 */
	public <L extends LatestListsPage> L goToLatestListsPage();
}
