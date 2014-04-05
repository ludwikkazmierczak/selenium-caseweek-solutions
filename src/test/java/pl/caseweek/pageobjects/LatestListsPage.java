package pl.caseweek.pageobjects;

import pl.caseweek.pageobjects.listgeeks.SingleListPage;

/**
 * Created by Ludwik on 05.04.14.
 */
public interface LatestListsPage {

	public <O extends SingleListPage> O openList();

}
