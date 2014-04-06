package pl.caseweek.pageobjects;

/**
 * This interface connected with 'latest lists' page functionality, prepared for CaseWeek 2014 Selenium workshop
 * Created by Ludwik and Yaci
 */
public interface LatestListsPage {

	/**
	 * Open one of the list form 'latest lists' page
	 * @return
	 */
	public <O extends SingleListPage> O openList();

}
