package pl.caseweek.pageobjects;

import pl.caseweek.pageobjects.listgeeks.LatestListsPage;

/**
 * This interface connected with navigation functionality, prepared for CaseWeek 2014 Selenium workshop
 * Created by Ludwik on 05.04.14.
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
