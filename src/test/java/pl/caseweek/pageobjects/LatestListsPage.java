package pl.caseweek.pageobjects;

import pl.caseweek.pageobjects.listgeeks.SingleListPage;

/**
 * This interface connected with 'latest lists' page functionality, prepared for CaseWeek 2014 Selenium workshop
 * Created by Ludwik on 06.04.14.
 */
public interface LatestListsPage {

	/**
	 * Open one of the list form 'latest lists' page
	 * @return
	 */
	public <O extends SingleListPage> O openList();

}
