package pl.caseweek.pageobjects;

import pl.caseweek.pageobjects.listgeeks.LatestListsPage;

/**
 * Created by Ludwik on 05.04.14.
 */
public interface Navigation {

	public <H extends HomePage> H goToHomePage();

	public <L extends LatestListsPage> L goToLatestListsPage();
}
